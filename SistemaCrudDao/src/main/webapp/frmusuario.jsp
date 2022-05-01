<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Modelos.usuario"%>
<%
    usuario usuario = (usuario) request.getAttribute("usuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo usuario</h1>

        <form class="d-6 mx-auto" action="UsuarioController" method="post">

            <input type="hidden" name="id" value="${usuario.id}" />
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input class="form-control" type="text" id="validationTooltip01" name="nombre" value="${usuario.nombre}" required></td>
       
                </div>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td><input class="form-control" type="email" name="correo" value ="${usuario.correo}"></td>


                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input class="form-control" type="password" name ="clave" value="${usuario.clave}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
