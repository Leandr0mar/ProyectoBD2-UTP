--Nombre de Base de datos : ProyectoBD2

CREATE TABLE usuarios (
    idUsuarios SERIAL PRIMARY KEY,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL 
        CHECK (email LIKE '%@%'),
    contrasena VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(255) NOT NULL,
    dni VARCHAR(9) UNIQUE NOT NULL 
        CHECK (LENGTH(dni) = 8)
        CHECK (dni ~ '^[0-9]+$'),
    rol VARCHAR(15) NOT NULL CHECK (rol IN ('administrador', 'profesor', 'alumno')),
    estado BOOLEAN DEFAULT true,
    token_recuperacion VARCHAR(255) NULL,
    token_expiracion TIMESTAMP NULL,
    fecha_usuario TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() 
);

CREATE TABLE periodos_academicos (
    idPeriodoAcademico SERIAL PRIMARY KEY,
    codigoPeriodo VARCHAR(20) UNIQUE NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    activo BOOLEAN DEFAULT true,
    fecha_periodo TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);

CREATE TABLE cursos (
    idCursos SERIAL PRIMARY KEY,
    codigoCurso VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    horas_semanales INT NOT NULL CHECK (horas_semanales BETWEEN 1 AND 10),
    ciclo INT NOT NULL CHECK (ciclo BETWEEN 1 AND 10),
    fecha_curso TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);

CREATE TABLE matriculas (
    idMatriculas SERIAL PRIMARY KEY,
    codigoMatricula VARCHAR(20) UNIQUE NOT NULL,
    alumno_id INT NOT NULL REFERENCES usuarios(idUsuarios),
    curso_id INT NOT NULL REFERENCES cursos(idCursos),
    periodo_id INT NOT NULL REFERENCES periodos_academicos(idPeriodoAcademico),
    fecha_matricula TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    UNIQUE(alumno_id, curso_id, periodo_id)
);

CREATE TABLE secciones (
    idseccion SERIAL PRIMARY KEY,
    codigoSeccion VARCHAR(20) UNIQUE NOT NULL,
    idCursos INT NOT NULL REFERENCES cursos(idCursos),
    idPeriodoAcademico INT NOT NULL REFERENCES periodos_academicos(idPeriodoAcademico),
    idProfesor INT NOT NULL REFERENCES usuarios(idUsuarios),
    fecha_seccion TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    UNIQUE(idCursos, idPeriodoAcademico, codigoSeccion)
);

CREATE TABLE notas (
    idNotas SERIAL PRIMARY KEY,
    idMatriculas INT NOT NULL REFERENCES matriculas(idMatriculas),
    idseccion INT NOT NULL REFERENCES secciones(idseccion),
    PC1 DECIMAL(4,2) DEFAULT 0.00 CHECK (PC1 BETWEEN 0 AND 20),
    PC2 DECIMAL(4,2) DEFAULT 0.00 CHECK (PC2 BETWEEN 0 AND 20),
    PC3 DECIMAL(4,2) DEFAULT 0.00 CHECK (PC3 BETWEEN 0 AND 20),
    PA DECIMAL(4,2) DEFAULT 0.00 CHECK (PA BETWEEN 0 AND 20),
    EF DECIMAL(4,2) DEFAULT 0.00 CHECK (EF BETWEEN 0 AND 20),
    
    promedio_final DECIMAL(4,2) GENERATED ALWAYS AS (
        ROUND((
            COALESCE(PC1,0)*2+COALESCE(PC2,0)*2+ 
            COALESCE(PC3,0)*2+COALESCE(PA,0)*1+ 
            COALESCE(EF,0)*3) / 10, 2)
    ) STORED,
    
    estado VARCHAR(20) GENERATED ALWAYS AS (
        CASE 
            WHEN 
                ROUND((
                    COALESCE(PC1,0)*2+COALESCE(PC2,0)*2+ 
                    COALESCE(PC3,0)*2+COALESCE(PA,0)*1+ 
                    COALESCE(EF,0)*3) / 10, 2)
                >= 12 
            THEN 'Aprobado' 
            ELSE 'Reprobado' 
        END
    ) STORED,
    fecha_nota TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    UNIQUE(idMatriculas, idseccion)
);



-- Funciones y Triggers y Secuencias

CREATE SEQUENCE seq_usuarios      START 1;
CREATE SEQUENCE seq_cursos        START 1;
CREATE SEQUENCE seq_matriculas    START 1;
CREATE SEQUENCE seq_secciones     START 1;

-- =============================================
-- FUNCIÓN REUTILIZABLE PARA GENERAR CÓDIGO
-- =============================================
CREATE OR REPLACE FUNCTION generar_codigo()
RETURNS TRIGGER AS $$
DECLARE
    tipo_tabla CHAR(1) := TG_ARGV[0]; 
    anio_actual CHAR(4) := to_char(CURRENT_DATE, 'YYYY');
    secuencial  TEXT;
    nuevo_codigo TEXT;
BEGIN
    
    secuencial := LPAD(nextval('seq_' || 
        CASE tipo_tabla
            WHEN 'U' THEN 'usuarios'
            WHEN 'C' THEN 'cursos'
            WHEN 'M' THEN 'matriculas'
            WHEN 'S' THEN 'secciones'
        END)::TEXT, 5, '0');

    nuevo_codigo := tipo_tabla || '-' || anio_actual || '-' || secuencial;

 
    CASE tipo_tabla
        WHEN 'U' THEN NEW.codigo := nuevo_codigo;
        WHEN 'C' THEN NEW.codigoCurso := nuevo_codigo;
        WHEN 'M' THEN NEW.codigoMatricula := nuevo_codigo;
        WHEN 'S' THEN NEW.codigoSeccion := nuevo_codigo;
    END CASE;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


-- =============================================
-- TRIGGERS POR TABLA
-- =============================================

-- 1. USUARIOS
CREATE TRIGGER trg_codigo_usuario
    BEFORE INSERT ON usuarios
    FOR EACH ROW
    WHEN (NEW.codigo IS NULL OR NEW.codigo = '')
    EXECUTE FUNCTION generar_codigo('U');

-- 2. CURSOS
CREATE TRIGGER trg_codigo_curso
    BEFORE INSERT ON cursos
    FOR EACH ROW
    WHEN (NEW.codigoCurso IS NULL OR NEW.codigoCurso = '')
    EXECUTE FUNCTION generar_codigo('C');

-- 3. MATRÍCULAS
CREATE TRIGGER trg_codigo_matricula
    BEFORE INSERT ON matriculas
    FOR EACH ROW
    WHEN (NEW.codigoMatricula IS NULL OR NEW.codigoMatricula = '')
    EXECUTE FUNCTION generar_codigo('M');

-- 4. SECCIONES
CREATE TRIGGER trg_codigo_seccion
    BEFORE INSERT ON secciones
    FOR EACH ROW
    WHEN (NEW.codigoseccion IS NULL OR NEW.codigoseccion = '')
    EXECUTE FUNCTION generar_codigo('S');




-- *** ADMINISTRADORES (IDs 1-3) ***
INSERT INTO usuarios (codigo, email, contrasena, nombre_completo, dni, rol) VALUES
('', 'admin.jtorres@univ.edu', 'pass_hashed_1', 'Javier Torres Guzmán', '70123451', 'administrador'),
('', 'admin.mrojas@univ.edu', 'pass_hashed_2', 'Mariana Rojas Soto', '70123452', 'administrador'),
('', 'admin.lramos@univ.edu', 'pass_hashed_3', 'Luis Ramos Flores', '70123453', 'administrador');

-- *** PROFESORES (IDs 4-10) ***
INSERT INTO usuarios (codigo, email, contrasena, nombre_completo, dni, rol) VALUES
('', 'prof.asantos@univ.edu', 'pass_hashed_4', 'Ana Santos Rivas', '70123454', 'profesor'), -- ID 4
('', 'prof.bgomez@univ.edu', 'pass_hashed_5', 'Benito Gómez Lira', '70123455', 'profesor'), -- ID 5
('', 'prof.ccastillo@univ.edu', 'pass_hashed_6', 'Claudia Castillo Vega', '70123456', 'profesor'), -- ID 6
('', 'prof.dmartinez@univ.edu', 'pass_hashed_7', 'Daniel Martínez Paz', '70123457', 'profesor'), -- ID 7
('', 'prof.erios@univ.edu', 'pass_hashed_8', 'Elena Ríos Ochoa', '70123458', 'profesor'), -- ID 8
('', 'prof.fcampos@univ.edu', 'pass_hashed_9', 'Fernando Campos Salas', '70123459', 'profesor'), -- ID 9
('', 'prof.glopez@univ.edu', 'pass_hashed_10', 'Gabriela López Cieza', '70123460', 'profesor'); -- ID 10

-- *** ALUMNOS (IDs 11-30) ***
INSERT INTO usuarios (codigo, email, contrasena, nombre_completo, dni, rol) VALUES
('', 'alu.hmedina@univ.edu', 'pass_hashed_11', 'Hugo Medina Díaz', '70123461', 'alumno'), -- ID 11
('', 'alu.iparedes@univ.edu', 'pass_hashed_12', 'Isabel Paredes Luna', '70123462', 'alumno'), -- ID 12
('', 'alu.jquispe@univ.edu', 'pass_hashed_13', 'Jorge Quispe Vera', '70123463', 'alumno'), -- ID 13
('', 'alu.kgutierrez@univ.edu', 'pass_hashed_14', 'Karla Gutiérrez Peña', '70123464', 'alumno'), -- ID 14
('', 'alu.lherrera@univ.edu', 'pass_hashed_15', 'Lucio Herrera Soto', '70123465', 'alumno'), -- ID 15
('', 'alu.mruiz@univ.edu', 'pass_hashed_16', 'Mónica Ruiz Baca', '70123466', 'alumno'), -- ID 16
('', 'alu.nnunez@univ.edu', 'pass_hashed_17', 'Natalia Núñez Cruz', '70123467', 'alumno'), -- ID 17
('', 'alu.ocarvajal@univ.edu', 'pass_hashed_18', 'Omar Carvajal Roca', '70123468', 'alumno'), -- ID 18
('', 'alu.pvalencia@univ.edu', 'pass_hashed_19', 'Paola Valencia Díaz', '70123469', 'alumno'), -- ID 19
('', 'alu.qsuarez@univ.edu', 'pass_hashed_20', 'Quique Suárez Leyva', '70123470', 'alumno'), -- ID 20
('', 'alu.rtello@univ.edu', 'pass_hashed_21', 'Roxana Tello Pinto', '70123471', 'alumno'), -- ID 21
('', 'alu.ssalas@univ.edu', 'pass_hashed_22', 'Sergio Salas Moya', '70123472', 'alumno'), -- ID 22
('', 'alu.tvasquez@univ.edu', 'pass_hashed_23', 'Tania Vásquez Lino', '70123473', 'alumno'), -- ID 23
('', 'alu.ufernandez@univ.edu', 'pass_hashed_24', 'Uriel Fernández Paz', '70123474', 'alumno'), -- ID 24
('', 'alu.vgonzales@univ.edu', 'pass_hashed_25', 'Valeria Gonzales Soto', '70123475', 'alumno'), -- ID 25
('', 'alu.wcastro@univ.edu', 'pass_hashed_26', 'Walter Castro Ramos', '70123476', 'alumno'), -- ID 26
('', 'alu.xescobar@univ.edu', 'pass_hashed_27', 'Ximena Escobar Vela', '70123477', 'alumno'), -- ID 27
('', 'alu.ypalacios@univ.edu', 'pass_hashed_28', 'Yanet Palacios Tello', '70123478', 'alumno'), -- ID 28
('', 'alu.zromero@univ.edu', 'pass_hashed_29', 'Zacarias Romero Cruz', '70123479', 'alumno'), -- ID 29
('', 'alu.aalarcon@univ.edu', 'pass_hashed_30', 'Alba Alarcón Mesa', '70123480', 'alumno'); -- ID 30

INSERT INTO periodos_academicos (codigoPeriodo, fecha_inicio, fecha_fin, activo) VALUES
('2025-1', '2024-03-01', '2024-07-15', TRUE),  -- ID 1: Período Activo
('2023-2', '2023-08-15', '2023-12-30', FALSE); -- ID 2: Período Inactivo

INSERT INTO cursos (codigoCurso, nombre, horas_semanales, ciclo) VALUES
-- Ciclo 1 (IDs 1-2)
('', 'Fundamentos de Programación', 4, 1),
('', 'Introducción a Bases de Datos', 5, 1),
-- Ciclo 2 (IDs 3-4)
('', 'Estructuras de Datos', 6, 2),
('', 'Análisis de Sistemas', 4, 2),
-- Ciclo 3 (IDs 5-6)
('', 'Programación Orientada a Objetos', 8, 3),
('', 'Cálculo Diferencial', 5, 3),
-- Ciclo 4 (IDs 7-8)
('', 'Redes y Comunicación', 5, 4),
('', 'Sistemas Operativos', 7, 4),
-- Ciclo 5 (IDs 9-10)
('', 'Ingeniería de Software', 6, 5),
('', 'Probabilidad y Estadística', 4, 5),
-- Ciclo 6 (IDs 11-12)
('', 'Desarrollo Web Frontend', 8, 6),
('', 'Desarrollo Web Backend', 7, 6),
-- Ciclo 7 (IDs 13-14)
('', 'Inteligencia Artificial', 6, 7),
('', 'Seguridad Informática', 5, 7),
-- Ciclo 8 (IDs 15-16)
('', 'Minería de Datos', 6, 8),
('', 'Gestión de Proyectos', 4, 8),
-- Ciclo 9 (IDs 17-18)
('', 'Computación en la Nube', 8, 9),
('', 'Taller de Tesis I', 3, 9),
-- Ciclo 10 (IDs 19-20)
('', 'Práctica Profesional', 10, 10),
('', 'Taller de Tesis II', 3, 10);

select * from secciones
INSERT INTO secciones (codigoSeccion, idCursos, idPeriodoAcademico, idProfesor) VALUES
('', 1, 1, 4),  -- Sec. 1: Curso 1 (ID 1) con Prof. 1 (ID 4) en Período Activo (ID 1)
('', 2, 1, 5),  -- Sec. 2: Curso 2 (ID 2) con Prof. 2 (ID 5) en Período Activo (ID 1)
('', 3, 1, 6),  -- Sec. 3: Curso 3 (ID 3) con Prof. 3 (ID 6) en Período Activo (ID 1)
('', 4, 1, 7),  -- Sec. 4: Curso 4 (ID 4) con Prof. 4 (ID 7) en Período Activo (ID 1)
('', 5, 1, 8),  -- Sec. 5: Curso 5 (ID 5) con Prof. 5 (ID 8) en Período Activo (ID 1)
('', 6, 1, 9),  -- Sec. 6: Curso 6 (ID 6) con Prof. 6 (ID 9) en Período Activo (ID 1)
('', 7, 1, 10); -- Sec. 7: Curso 7 (ID 7) con Prof. 7 (ID 10) en Período Activo (ID 10)

INSERT INTO matriculas (codigoMatricula, alumno_id, curso_id, periodo_id) VALUES
('', 11, 1, 1), -- Alumno 11 en Curso 1 / Período 1 (Sec 1) - ID Matrícula 1
('', 12, 1, 1), -- Alumno 12 en Curso 1 / Período 1 (Sec 1) - ID Matrícula 2
('', 13, 2, 1), -- Alumno 13 en Curso 2 / Período 1 (Sec 2) - ID Matrícula 3
('', 14, 2, 1), -- Alumno 14 en Curso 2 / Período 1 (Sec 2) - ID Matrícula 4
('', 15, 3, 1), -- Alumno 15 en Curso 3 / Período 1 (Sec 3) - ID Matrícula 5
('', 16, 4, 1), -- Alumno 16 en Curso 4 / Período 1 (Sec 4) - ID Matrícula 6
('', 17, 5, 1), -- Alumno 17 en Curso 5 / Período 1 (Sec 5) - ID Matrícula 7
('', 18, 6, 1), -- Alumno 18 en Curso 6 / Período 1 (Sec 6) - ID Matrícula 8
('', 19, 7, 1), -- Alumno 19 en Curso 7 / Período 1 (Sec 7) - ID Matrícula 9
('', 20, 8, 2); -- Alumno 20 en Curso 8 / Período 2 (Inactivo) - ID Matrícula 10

INSERT INTO notas (idMatriculas, idseccion, PC1, PC2, PC3, PA, EF) VALUES
(1, 8, 15.00, 12.00, 18.00, 14.00, 17.00), -- Alumno 11 (Aprobado: 15.50)
(2, 9, 05.00, 11.00, 08.00, 09.00, 10.00), -- Alumno 12 (Reprobado: 8.90)
(3, 10, 13.00, 13.00, 13.00, 13.00, 13.00), -- Alumno 13 (Aprobado: 13.00)
(4, 11, 10.00, 10.00, 10.00, 10.00, 10.00), -- Alumno 14 (Reprobado: 10.00)
(5, 12, 16.50, 14.50, 17.00, 15.00, 18.00), -- Alumno 15 (Aprobado: 16.20)
(6, 13, 08.00, 13.00, 11.00, 10.00, 12.00), -- Alumno 16 (Reprobado: 11.00)
(7, 14, 18.00, 18.00, 18.00, 18.00, 18.00); -- Alumno 17 (Aprobado: 18.00)

   select         s.idProfesor,n.idNotas,
            u.nombre_completo AS alumno,
            c.nombre AS curso,
            p.codigoPeriodo AS periodo,
            COALESCE(n.PC1, 0) AS PC1,
            COALESCE(n.PC2, 0) AS PC2,
            COALESCE(n.PC3, 0) AS PC3, 
            COALESCE(n.PA, 0) AS PA, 
            COALESCE(n.EF, 0) AS EF, 
            n.promedio_final,
            n.estado 
        FROM notas n 
        JOIN matriculas m ON n.idMatriculas = m.idMatriculas 
        JOIN usuarios u ON m.alumno_id = u.idUsuarios 
        JOIN cursos c ON m.curso_id = c.idCursos 
        JOIN periodos_academicos p ON m.periodo_id = p.idPeriodoAcademico
         JOIN secciones s on s.idSeccion=n.idSeccion

        ORDER BY n.idNotas ASC
     