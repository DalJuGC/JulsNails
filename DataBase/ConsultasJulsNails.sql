-->Consultas JulsNails<--

--> Consulta para mostrar los tratamiento registrados y el empleado que lo realiza 
SELECT Tratamiento.codigo, Tratamiento.nombre AS Tratamiento, Tratamiento.precio, Empleado.nombre AS Empleado FROM Tratamiento
JOIN Empleado ON Tratamiento.cod_empleado = Empleado.codigo

--> Consulta para mostrar la lista de citas con su respectivo tratamiento y ver si cuenta con promoción
SELECT Cita.codigo, Cliente.nombre AS cliente, Cita.fecha, Cita.horario, Tratamiento.nombre AS tratamiento, Promocion.nombre AS promocion, Cita.cancelar FROM Cita
JOIN Tratamiento ON Cita.codigo = Tratamiento.codigo
JOIN Cliente ON Cita.codigo = Cliente.codigo
JOIN Promocion ON Cita.codigo = Promocion.codigo
ORDER BY Cita.fecha, Cita.horario