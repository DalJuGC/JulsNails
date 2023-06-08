<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Empleado"%>
<%@ page import="datos.EmpleadoDAO"%>
<html>
<head>
    <title>Empleados</title>
</head>
<body>
<header>
  <nav>
    <ul>
      <li><a href="/ProyectoDAW/index.jsp">Inicio</a></li>
      <li><a href="/ProyectoDAW/Cliente/ListaCliente.jsp">Clientes</a></li>
      <li><a href="/ProyectoDAW/Cita/ListaCita.jsp">Citas</a></li>
      <li><a href="/ProyectoDAW/Tratamiento/ListaTra.jsp">Tratamientos</a></li>
      <li><a href="/ProyectoDAW/Promocion/ListaProm.jsp">Promociones</a></li>
      <li><a href="/ProyectoDAW/Empleado/ListaEmp.jsp">Empleados</a></li>
    </ul>
  </nav>
</header>
<main>
  <div>
    <h1>Citas Registradas</h1>
    <button onclick="location.href='/ProyectoDAW/Empleado/RegistrarEmp.jsp'">Registrar empleado</button>
    <button onclick="location.href='/ProyectoDAW/Empleado/BuscarEmp.jsp'">Buscar empleado</button>
    <button onclick="location.href='/ProyectoDAW/Empleado/ModificarEmp.jsp'">Modificar empleado</button>
    <table>
      <thead>
      <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Cargo</th>
        <th>Telefono</th>
      </tr>
      </thead>
    </table>
  </div>
</main>
</body>
</html>
