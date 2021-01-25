CREATE SEQUENCE poo_persona_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
	
CREATE SEQUENCE poo_paciente_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
	
CREATE SEQUENCE poo_empleado_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE poo_doctor_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE poo_administrador_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
	
CREATE SEQUENCE poo_clinica_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
	
CREATE SEQUENCE poo_direccion_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
	
CREATE SEQUENCE poo_horario_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
	
CREATE SEQUENCE poo_cita_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE poo_persona
(
    id integer NOT NULL DEFAULT nextval('poo_persona_id_seq'::regclass),
    nombre character varying(20) COLLATE pg_catalog."default" NOT NULL,
    apellidopaterno character varying(20) COLLATE pg_catalog."default" NOT NULL,
    apellidomaterno character varying(20) COLLATE pg_catalog."default",
    fechanacimiento date NOT NULL,
    telefono character varying(10) COLLATE pg_catalog."default",
    correoelectronico character varying(40) COLLATE pg_catalog."default" NOT NULL,
    usuario character varying(20) COLLATE pg_catalog."default" NOT NULL,
    contrasenia character varying(15) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT poo_persona_pkey PRIMARY KEY (id),
    CONSTRAINT poo_persona_usuario_key UNIQUE (usuario)
)

CREATE TABLE poo_clinica
(
    id integer NOT NULL DEFAULT nextval('poo_clinica_id_seq'::regclass),
    numeroclinica integer NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT poo_clinica_pkey PRIMARY KEY (id),
    CONSTRAINT poo_unique_numeroclinica UNIQUE (numeroclinica)
)

CREATE TABLE poo_direccion
(
    id integer NOT NULL DEFAULT nextval('poo_direccion_id_seq'::regclass),
    calle character varying(20) COLLATE pg_catalog."default" NOT NULL,
    numeroexterior character varying(10) COLLATE pg_catalog."default" NOT NULL,
    numerointerior character varying(10) COLLATE pg_catalog."default",
    colonia character varying(20) COLLATE pg_catalog."default" NOT NULL,
    codigopostal integer NOT NULL,
    delegacionmunicipio character varying(30) COLLATE pg_catalog."default" NOT NULL,
    estado character varying(20) COLLATE pg_catalog."default" NOT NULL,
    persona_id integer NOT NULL,
    CONSTRAINT poo_direccion_pkey PRIMARY KEY (id),
    CONSTRAINT poo_one_to_one_persona UNIQUE (persona_id),
    CONSTRAINT poo_fk_persona_direccion FOREIGN KEY (persona_id)
        REFERENCES poo_persona (id) MATCH SIMPLE
)

CREATE TABLE poo_paciente
(
    id integer NOT NULL DEFAULT nextval('poo_paciente_id_seq'::regclass),
    numeropaciente integer NOT NULL,
    persona_id integer NOT NULL,
    CONSTRAINT poo_paciente_pkey PRIMARY KEY (id),
    CONSTRAINT poo_one_to_one UNIQUE (persona_id),
    CONSTRAINT poo_unique_numpaciente UNIQUE (numeropaciente),
    CONSTRAINT poo_fk_persona FOREIGN KEY (persona_id)
        REFERENCES poo_persona (id) MATCH SIMPLE
)

CREATE TABLE poo_empleado
(
    id integer NOT NULL DEFAULT nextval('poo_empleado_id_seq'::regclass),
    numeroempleado integer NOT NULL,
    salario money,
    fechaingreso date,
    persona_id integer NOT NULL,
    clinica_id integer NOT NULL,
    CONSTRAINT poo_empleado_pkey PRIMARY KEY (id),
    CONSTRAINT poo_one_to_one_persona_empleado UNIQUE (persona_id),
    CONSTRAINT poo_unique_numeroempleado UNIQUE (numeroempleado),
    CONSTRAINT poo_fk_clinica_empleado FOREIGN KEY (clinica_id)
        REFERENCES poo_clinica (id) MATCH SIMPLE,
    CONSTRAINT fk_persona_empleado FOREIGN KEY (persona_id)
        REFERENCES poo_persona (id) MATCH SIMPLE
)

CREATE TABLE poo_administrador
(
    id integer NOT NULL DEFAULT nextval('poo_administrador_id_seq'::regclass),
    numeroadmin integer NOT NULL,
    oficina integer NOT NULL,
    empleado_id integer NOT NULL,
    CONSTRAINT poo_administrador_pkey PRIMARY KEY (id),
    CONSTRAINT poo_one_to_one_empleado_admin UNIQUE (empleado_id),
    CONSTRAINT poo_unique_numeroadmin UNIQUE (numeroadmin),
    CONSTRAINT poo_fk_empleado_administrador FOREIGN KEY (empleado_id)
        REFERENCES poo_empleado (id) MATCH SIMPLE
)

CREATE TABLE poo_doctor
(
    id integer NOT NULL DEFAULT nextval('poo_doctor_id_seq'::regclass),
    cedula integer NOT NULL,
    especialidad character varying(50) COLLATE pg_catalog."default" NOT NULL,
    empleado_id integer NOT NULL,
    CONSTRAINT poo_doctor_pkey PRIMARY KEY (id),
    CONSTRAINT poo_one_to_one_empleado_doctor UNIQUE (empleado_id),
    CONSTRAINT poo_unique_cedula UNIQUE (cedula),
    CONSTRAINT poo_fk_empleado_doctor FOREIGN KEY (empleado_id)
        REFERENCES poo_empleado (id) MATCH SIMPLE
)

CREATE TABLE poo_horario
(
    id integer NOT NULL DEFAULT nextval('poo_horario_id_seq'::regclass),
    horainicio time without time zone,
    horatermino time without time zone,
    doctor_id integer NOT NULL,
    CONSTRAINT poo_horario_pkey PRIMARY KEY (id),
    CONSTRAINT poo_fk_doctor_horario FOREIGN KEY (doctor_id)
        REFERENCES poo_doctor (id) MATCH SIMPLE,
    CONSTRAINT poo_horario_check CHECK (horatermino > horainicio)
)

CREATE TABLE poo_cita
(
    id integer NOT NULL DEFAULT nextval('poo_cita_id_seq'::regclass),
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    paciente_id integer NOT NULL,
    horario_id integer NOT NULL,
    CONSTRAINT poo_cita_pkey PRIMARY KEY (id),
    CONSTRAINT poo_fk_horario_cita FOREIGN KEY (horario_id)
        REFERENCES poo_horario (id) MATCH SIMPLE,
    CONSTRAINT poo_fk_paciente_cita FOREIGN KEY (paciente_id)
        REFERENCES poo_paciente (id) MATCH SIMPLE
)