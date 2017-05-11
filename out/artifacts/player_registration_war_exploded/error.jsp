<%@ page import="com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erro</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="global">
    <h2>Parece que tivemos problemas... </h2>
    <hr>
    <p>Verifique a mensagem abaixo e tente novamente mais tarde:</p>

    <%
        Exception e = (Exception)request.getAttribute("exc");

        if (e instanceof MySQLIntegrityConstraintViolationException) {
    %>
    <p style="color: red">Chave Duplicada.</p>
    <%
    } else {
        if (e instanceof SQLException) {
    %>
    <p style="color: red">Não foi possível conectar no banco de dados. Verifique usuário, senha ou IP do banco de dados.</p>
    <%
    } else {
    %>
    <p style="color: red">Falha não identificada. Volte novamente mais tarde! </p>
    <p style="color: red"><%= e.getMessage()%></p>
    <%
            }
        }
    %>

    <a href="javascript:window.history.go(-1)">Voltar</a>
</div>
</body>
</html>
