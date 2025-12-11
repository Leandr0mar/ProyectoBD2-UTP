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
    PC1 DECIMAL(4,2) CHECK (PC1 BETWEEN 0 AND 20),
    PC2 DECIMAL(4,2) CHECK (PC2 BETWEEN 0 AND 20),
    PC3 DECIMAL(4,2) CHECK (PC3 BETWEEN 0 AND 20),
    PA DECIMAL(4,2) CHECK (PA BETWEEN 0 AND 20),
    EF DECIMAL(4,2) CHECK (EF BETWEEN 0 AND 20),
    
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

CREATE TABLE asistencias (
    idAsitencias SERIAL PRIMARY KEY,
    idMatriculas INT NOT NULL REFERENCES matriculas(idMatriculas),
    idseccion INT NOT NULL REFERENCES secciones(idseccion),
    fecha DATE NOT NULL,
    presente BOOLEAN DEFAULT true,
    UNIQUE(idMatriculas, idseccion, fecha)
);

CREATE TABLE certificados (
    idCertificados SERIAL PRIMARY KEY,
    codigoCertificado VARCHAR(20) UNIQUE NOT NULL,
    idMatriculas INT NOT NULL REFERENCES matriculas(idMatriculas),
    idPeriodoAcademico INT NOT NULL REFERENCES periodos_academicos(idPeriodoAcademico),
    codigo_verificacion VARCHAR(20) UNIQUE NOT NULL,
    fecha_emision TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);




-- Funciones y Triggers y Secuencias

-- =============================================
-- SECUENCIAS POR TABLA (una por cada una)
-- =============================================
CREATE SEQUENCE seq_usuarios      START 1;
CREATE SEQUENCE seq_cursos        START 1;
CREATE SEQUENCE seq_matriculas    START 1;
CREATE SEQUENCE seq_secciones     START 1;
CREATE SEQUENCE seq_certificados  START 1;
-- =============================================
-- FUNCIÓN REUTILIZABLE PARA GENERAR CÓDIGO
-- =============================================
CREATE OR REPLACE FUNCTION generar_codigo()
RETURNS TRIGGER AS $$
DECLARE
    tipo_tabla CHAR(1) := TG_ARGV[0]; -- Lee el argumento pasado por el TRIGGER
    anio_actual CHAR(4) := to_char(CURRENT_DATE, 'YYYY');
    secuencial  TEXT;
    nuevo_codigo TEXT;
BEGIN
    -- Generamos el número con 5 dígitos (00001, 00002...)
    secuencial := LPAD(nextval('seq_' || 
        CASE tipo_tabla
            WHEN 'U' THEN 'usuarios'
            WHEN 'C' THEN 'cursos'
            WHEN 'M' THEN 'matriculas'
            WHEN 'S' THEN 'secciones'
            WHEN 'T' THEN 'certificados'
        END)::TEXT, 5, '0');

    nuevo_codigo := tipo_tabla || '-' || anio_actual || '-' || secuencial;

    -- Asignamos al campo correspondiente en la nueva fila (NEW)
    CASE tipo_tabla
        WHEN 'U' THEN NEW.codigo := nuevo_codigo;
        WHEN 'C' THEN NEW.codigoCurso := nuevo_codigo;
        WHEN 'M' THEN NEW.codigoMatricula := nuevo_codigo;
        WHEN 'S' THEN NEW.codigoSeccion := nuevo_codigo;
        WHEN 'T' THEN NEW.codigoCertificado := nuevo_codigo;
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

-- 5. CERTIFICADOS
ALTER TABLE certificados ADD COLUMN IF NOT EXISTS codigo_certificado VARCHAR(20) UNIQUE;

CREATE TRIGGER trg_codigo_certificado
    BEFORE INSERT ON certificados
    FOR EACH ROW
    WHEN (NEW.codigo_certificado IS NULL OR NEW.codigo_certificado = '')
    EXECUTE FUNCTION generar_codigo('T');

