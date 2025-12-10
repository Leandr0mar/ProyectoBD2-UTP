CREATE TABLE usuarios (
    idUsuarios SERIAL PRIMARY KEY ,
	codigo VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL 
        CHECK (email like '%@%'),
    contrasena VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(255) NOT NULL,
	dni VARCHAR(9) UNIQUE NOT NULL 
        CHECK (LENGTH(dni) >= 8 AND LENGTH(dni) <= 9)
        CHECK (dni ~ '^[0-9]+$'),
    rol VARCHAR(15) NOT NULL CHECK (rol IN ('administrador', 'profesor', 'alumno')),
    estado BOOLEAN DEFAULT true,
	token_recuperacion VARCHAR(255) NULL,
	token_expiracion TIMESTAMP NULL
);
select * from cursos
CREATE TABLE periodos_academicos (
    idPeriodoAcademico SERIAL PRIMARY KEY,
    codigoPeriodo VARCHAR(10) UNIQUE NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    activo BOOLEAN DEFAULT true
);

CREATE TABLE cursos (
    idCursos SERIAL PRIMARY KEY,
    codigoCurso VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
	horas_semanales INT DEFAULT 5,
	ciclo int NOT NULL
);


CREATE TABLE matriculas (
    idMatriculas SERIAL PRIMARY KEY,
    codigoMatricula VARCHAR(10) UNIQUE NOT NULL,
    alumno_id INT NOT NULL REFERENCES usuarios(idUsuarios),
    curso_id INT NOT NULL REFERENCES cursos(idCursos),
    periodo_id INT NOT NULL REFERENCES periodos_academicos(idPeriodoAcademico),
    fecha_matricula DATE DEFAULT CURRENT_DATE
);

CREATE TABLE seccion (
    idseccion SERIAL PRIMARY KEY,
    idCursos INT NOT NULL REFERENCES cursos(idCursos),
    idPeriodoAcademico INT NOT NULL REFERENCES periodos_academicos(idPeriodoAcademico),
    idProfesor INT NOT NULL REFERENCES usuarios(idUsuarios)
);

CREATE TABLE notas (
    idNotas SERIAL PRIMARY KEY,
    idMatriculas INT NOT NULL REFERENCES matriculas(idMatriculas),
    idseccion INT NOT NULL REFERENCES seccion(idseccion),
    PC1 DECIMAL(4,2) CHECK (PC1 BETWEEN 0 AND 20),
    PC2 DECIMAL(4,2) CHECK (PC2 BETWEEN 0 AND 20),
    PC3 DECIMAL(4,2) CHECK (PC3 BETWEEN 0 AND 20),
    PA DECIMAL(4,2) CHECK (PA BETWEEN 0 AND 20),
    EF DECIMAL(4,2) CHECK (EF BETWEEN 0 AND 20),
    
    promedio_final DECIMAL(4,2) GENERATED ALWAYS AS (
        ROUND((
            COALESCE(PC1,0)*2+ 
            COALESCE(PC2,0)*2+ 
            COALESCE(PC3,0)*2+ 
            COALESCE(PA,0)*1+ 
            COALESCE(EF,0)*3) / 10, 2)
    ) STORED,
    
    estado VARCHAR(20) GENERATED ALWAYS AS (
        CASE WHEN 
            (ROUND((
                COALESCE(PC1,0)*2+ 
                COALESCE(PC2,0)*2+ 
                COALESCE(PC3,0)*2+ 
                COALESCE(PA,0)*1+ 
                COALESCE(EF,0)*3) / 10, 2)
            ) >= 12 THEN 'Aprobado' 
             ELSE 'Reprobado' END) 
        STORED
);

CREATE TABLE asistencias (
    idAsitencias SERIAL PRIMARY KEY,
    idMatriculas INT NOT NULL REFERENCES matriculas(idMatriculas),
    idseccion INT NOT NULL REFERENCES seccion(idseccion),
    fecha DATE NOT NULL,
    presente BOOLEAN DEFAULT true
);

CREATE TABLE certificados (
    idCertificados SERIAL PRIMARY KEY,
    idMatriculas INT NOT NULL REFERENCES matriculas(idMatriculas),
    idPeriodoAcademico INT NOT NULL REFERENCES periodos_academicos(idPeriodoAcademico),
    codigo_verificacion VARCHAR(20) UNIQUE NOT NULL,
    fecha_emision TIMESTAMP DEFAULT NOW()
);



-- Funciones y Triggers

CREATE SEQUENCE seq_codigo_usuario START 1 INCREMENT 1;

CREATE OR REPLACE FUNCTION generar_codigo_usuario()
RETURNS TRIGGER AS $$
DECLARE
    next_id BIGINT;
    prefijo CHAR(1) := 'U';
BEGIN
    -- 1. Obtener el siguiente valor de la secuencia
    SELECT nextval('seq_codigo_usuario') INTO next_id;

    -- 2. Formatear y Asignar el Código
    -- NEW.codigo será: 'A' + número rellenado (ej: A00100)
    NEW.codigo := prefijo || LPAD(next_id::text, 5, '0');
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_antes_insertar_usuario
BEFORE INSERT ON usuarios
FOR EACH ROW
EXECUTE FUNCTION generar_codigo_usuario();


--ALTER SEQUENCE seq_codigo_usuario RESTART WITH 50;
--ALTER SEQUENCE seq_codigo_curso RESTART WITH 1;


CREATE SEQUENCE seq_codigo_curso START 1 INCREMENT 1;

CREATE OR REPLACE FUNCTION generar_codigo_curso()
RETURNS TRIGGER AS $$
DECLARE
    next_id BIGINT;
    prefijo CHAR(1) := 'C'; -- Definimos el prefijo fijo 'C'
BEGIN
    -- 1. Obtener el siguiente valor de la secuencia
    SELECT nextval('seq_codigo_curso') INTO next_id;

    -- 2. Formatear y Asignar el Código
    -- NEW.codigoCurso será: 'C' + número rellenado (ej: C00001)
    NEW.codigoCurso := prefijo || LPAD(next_id::text, 5, '0');
    
    -- 3. Devolver la fila modificada
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_antes_insertar_curso
BEFORE INSERT ON cursos
FOR EACH ROW
EXECUTE FUNCTION generar_codigo_curso();



CREATE SEQUENCE seq_codigo_matricula START 1 INCREMENT 1;

CREATE OR REPLACE FUNCTION generar_codigo_matricula()
RETURNS TRIGGER AS $$
DECLARE
    next_id BIGINT;
    prefijo CHAR(1) := 'M'; -- Definimos el prefijo fijo 'M'
BEGIN
    -- 1. Obtener el siguiente valor de la secuencia
    SELECT nextval('seq_codigo_matricula') INTO next_id;

    -- 2. Formatear y Asignar el Código
    -- NEW.codigoMatricula será: 'M' + número rellenado (ej: M00001)
    NEW.codigoMatricula := prefijo || LPAD(next_id::text, 5, '0');
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_antes_insertar_matricula
BEFORE INSERT ON matriculas
FOR EACH ROW
EXECUTE FUNCTION generar_codigo_matricula();




--Consultas

INSERT INTO usuarios(codigo, email, contrasena, nombre_completo, dni, rol) 
VALUES
('U00001', 'ana.rojas.adm@gmail.com', 'admin_ana123', 'Ana María Rojas Soto', '80123456', 'administrador'),
('U00002', 'carlos.mora@outlook.com', 'profesor_car456', 'Carlos Alberto Mora Díaz', '10987654', 'profesor'),
('U00003', 'luis.perez.alum@gmail.com', 'alumno_lui789', 'Luis Ángel Pérez Salas', '71234567', 'alumno'),
('U00004', 'mariana.cruz@outlook.com', 'alumno_mar101', 'Mariana Fernanda Cruz Flores', '72345678', 'alumno'),
('U00005', 'javier.sanchez.profe@gmail.com', 'profe_jav202', 'Javier Andrés Sánchez Torres', '11001122', 'profesor'),
('U00006', 'sofia.guerra@outlook.com', 'admin_sof303', 'Sofía Elena Guerra Paz', '80876543', 'administrador'),
('U00007', 'ricardo.sosa.alum@gmail.com', 'alumno_ric404', 'Ricardo José Sosa León', '73456789', 'alumno'),
('U00008', 'elena.castro@outlook.com', 'alumno_ele505', 'Elena Lucía Castro Ramos', '74567890', 'alumno'),
('U00009', 'raul.valdez.profe@gmail.com', 'profe_rau606', 'Raúl Armando Valdez Vega', '12131415', 'profesor'),
('U00010', 'diana.torres@outlook.com', 'alumno_dia707', 'Diana Carolina Torres Ruiz', '75678901', 'alumno'),
('U00011', 'fernando.diaz.alum@gmail.com', 'alumno_fer808', 'Fernando Miguel Díaz Rivas', '76789012', 'alumno'),
('U00012', 'monica.flores@outlook.com', 'profesor_mon909', 'Mónica Isabel Flores Huamán', '13456789', 'profesor'),
('U00013', 'gabriel.rojas.alum@gmail.com', 'alumno_gab111', 'Gabriel Omar Rojas Quispe', '77890123', 'alumno'),
('U00014', 'veronica.soto@outlook.com', 'alumno_ver222', 'Verónica Paz Soto Luna', '78901234', 'alumno'),
('U00015', 'pablo.rios.profe@gmail.com', 'profe_pab333', 'Pablo Martín Ríos Núñez', '14567890', 'profesor'),
('U00016', 'andres.videla@outlook.com', 'alumno_and444', 'Andrés Felipe Videla Cruz', '79012345', 'alumno'),
('U00017', 'natalia.lopez.alum@gmail.com', 'alumno_nat555', 'Natalia Belén López Mena', '70123456', 'alumno'),
('U00018', 'hugo.gomez@outlook.com', 'profesor_hug666', 'Hugo Ricardo Gómez Tello', '15678901', 'profesor'),
('U00019', 'camila.diaz.alum@gmail.com', 'alumno_cam777', 'Camila Alejandra Díaz Pinto', '71123456', 'alumno'),
('U00020', 'juan.quispe@outlook.com', 'alumno_jua888', 'Juan Diego Quispe Mamani', '72234567', 'alumno'),
('U00021', 'david.chavez.adm@gmail.com', 'admin_dav999', 'David Alfonso Chávez Ríos', '81234567', 'administrador'),
('U00022', 'eliza.torres@outlook.com', 'profesor_eli100', 'Elisa Gabriela Torres Núñez', '16789012', 'profesor'),
('U00023', 'miguel.ramos.alum@gmail.com', 'alumno_mig120', 'Miguel Ángel Ramos Cárdenas', '73345678', 'alumno'),
('U00024', 'valeria.vega@outlook.com', 'alumno_val130', 'Valeria Pía Vega Rojas', '74456789', 'alumno'),
('U00025', 'roberto.linares.profe@gmail.com', 'profe_rob140', 'Roberto Jesús Linares Huanca', '17890123', 'profesor');

INSERT INTO cursos (,nombre, horas_semanales, ciclo)
VALUES 
('Introducción a la Programación', 5, 1), -- idCursos = 1
('Álgebra Lineal', 6, 2),                  -- idCursos = 2
('Bases de Datos I', 5, 3),                 -- idCursos = 3
('Programación Orientada a Objetos', 6, 4),  -- idCursos = 4
('Diseño Web UX/UI', 4, 4),                 -- idCursos = 5
('Cálculo Integral', 6, 2),                -- idCursos = 6
('Redes y Conectividad', 5, 5),             -- idCursos = 7
('Tesis y Proyectos', 4, 9),                -- idCursos = 8
('Gestión Empresarial', 4, 7),              -- idCursos = 9
('Sistemas Operativos', 5, 3);              -- idCursos = 10

INSERT INTO periodos_academicos (codigoPeriodo, fecha_inicio, fecha_fin, activo)
VALUES 
('2025-I', '2025-03-01', '2025-07-31', FALSE),
('2025-II', '2025-08-15', '2025-12-15', TRUE);


INSERT INTO matriculas (alumno_id, curso_id, periodo_id, fecha_matricula)
VALUES 
-- Alumno 3 (Luis Pérez) se matricula en Curso 1 (Intro a Programación)
(52, 7, 1, CURRENT_DATE); 



SELECT codigo,email, contrasena, nombre_completo, dni, rol, estado FROM usuarios WHERE rol like('alumno')order by codigo
SELECT codigoPeriodo FROM periodos_academicos WHERE activo = TRUE