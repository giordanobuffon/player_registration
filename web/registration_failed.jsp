<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erro</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="global">
    <h2>Parece que tivemos problemas... </h2>
    <p><%= request.getAttribute("error_message")%></p>
    <br>
    <a href="index.jsp">Voltar ao formulário</a>
</div>
</body>
</html>
