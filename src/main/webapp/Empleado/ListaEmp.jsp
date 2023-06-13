<%@ page import="modelo.Empleado" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empleados</title>
  <link rel="stylesheet" href="/JulsNails/Estilos/BarraNav.css" type="text/css">
  <link rel="stylesheet" href="/JulsNails/Estilos/Button.css" type="text/css">
  <link rel="stylesheet" href="/JulsNails/Estilos/Tabla.css" type="text/css">
</head>
<body>
<header>
  <nav>
    <ul>
      <li><a href="/JulsNails/index.jsp">Inicio</a></li>
      <li><a href="/JulsNails/Cliente/ListaCliente.jsp">Clientes</a></li>
      <li><a href="/JulsNails/Cita/ListaCita.jsp">Citas</a></li>
      <li><a href="/JulsNails/Tratamiento/ListaTra.jsp">Tratamientos</a></li>
      <li><a href="/JulsNails/Promocion/ListaProm.jsp">Promociones</a></li>
      <li><a href="/JulsNails/Empleado/ListaEmp.jsp">Empleados</a></li>
    </ul>
  </nav>
</header>
<main>
  <div>
    <h1>Citas Registradas</h1>
    <button class="button" onclick="location.href='/JulsNails/Empleado/RegistrarEmp.jsp'">Registrar empleado</button>
    <button class="button" onclick="location.href='/JulsNails/Empleado/ModificarEmp.jsp'">Modificar empleado</button>
    <button class="button" onclick="location.href='/JulsNails/Empleado/BuscarEmp.jsp'">Buscar empleado</button>

    <table>
      <thead>
      <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Cargo</th>
        <th>Teléfono</th>
        <th>Domicilio</th>
        <th>Fecha de contratación</th>
      </tr>
      <tbody>
      <%
        ArrayList<Empleado> lista = (ArrayList<Empleado>)session.getAttribute("datos");
        if (lista != null && !lista.isEmpty()){
          for (Empleado empleado : lista){
      %>
      <tr>
        <td><%out.print(empleado.getCodigo()); %></td>
        <td><%out.print(empleado.getNombre()); %></td>
        <td><%out.print(empleado.getCargo()); %></td>
        <td><%out.print(empleado.getTelefono()); %></td>
        <td><%out.print(empleado.getDomicilio()); %></td>
        <td><%out.print(empleado.getFecha_contrato()); %></td>
      </tr>
      <%
          }
        }
      %>
      </tbody>
    </table>
  </div>
</main>
</body>
</html>
