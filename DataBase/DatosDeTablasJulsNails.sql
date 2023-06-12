-->Proyecto DAW JulsNails<--
--Llenado de la tablas

INSERT INTO Cliente(codigo,nombre, telefono, domicilio)
VALUES ('1','Julissa','2851087745', 'Boca del Río, Ver.'),
('2','Nayubel','2855504439', 'Boca del Río, Ver.'),
('3','Liz','2294837497','Ignacio de la Llave');

INSERT INTO Empleado(codigo,nombre,cargo,telefono,domicilio, fecha_contrato)
VALUES ('1','Dania','Jefa','2851093286','Ignacio de la Llame','21/09/2022');

INSERT INTO Tratamiento(codigo,nombre, precio,cod_empleado)
VALUES('1','Uñas de acrilico','300','1'),
('2','Gel en pies','100','1'),
('3','Gel el manos','100','1'),
('4','PediSpa','150','1');

INSERT INTO Promocion(codigo,nombre, precio, vigencia)
VALUES ('1','Gel','70','1'),
('2','Spa','100','1'),
('3','Manicura','150','0');

INSERT INTO Cita(codigo, cod_cliente, fecha, horario, cod_tratamiento,cod_promocion,cancelar)
VALUES ('1','1','20/05/2023','09:00','1','1','0'),
('2','2','20/05/2023','13:00','4','1','1'),
('3','1','20/05/2023','15:00','3','1','1');