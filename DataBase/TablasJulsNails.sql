-->ProyectoDAW JulsNails<--
--Creación de las tablas

-->Tabla Cliente
CREATE TABLE Cliente(
	codigo SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	domicilio VARCHAR(100) NOT NULL
);

-->Tabla Empleado
CREATE TABLE Empleado(
	codigo SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	cargo VARCHAR(50) NOT NULL,
	telefono VARCHAR(20) NOT NULL,
	domicilio VARCHAR(100) NOT NULL,
	fecha_contrato DATE NOT NULL
);

-->Tabla Promocion
CREATE TABLE Promocion(
	codigo SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	precio FLOAT NOT NULL,
	vigencia BOOLEAN NOT NULL
);

-->Tabla Tratamiento
CREATE TABLE Tratamiento(
	codigo SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	precio FLOAT NOT NULL,
	cod_empleado INTEGER REFERENCES Empleado(codigo)
);

-->Tabla Cita
CREATE TABLE Cita(
	codigo SERIAL PRIMARY KEY,
	cod_cliente INTEGER REFERENCES Cliente(codigo),
	fecha DATE NOT NULL,
	horario TIME NOT NULL,
	cod_tratamiento INTEGER REFERENCES Tratamiento(codigo),
	cod_promocion INTEGER REFERENCES Promocion(codigo),
	cancelar BOOLEAN NOT NULL
);
