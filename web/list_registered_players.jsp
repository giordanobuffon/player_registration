<%@ page import="br.edu.ifrs.modelo.bean.Player" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h2>Consulta de Jogadores</h2>
<div class="global">
    <form action="ProcessingConsultPlayer" method="post">
        <label for="name">Nome:</label>
        <input type="text" name="name" id="name" maxlength="45" onchange="nameValidation()">
        <br><br>
        <label for="team">Time:</label>
        <select name="team" id="team" onchange="teamValidation()">
            <option value="empty_team">--Selecione o time--</option>
            <option value="Gremio">Grêmio</option>
            <option value="Internacional">Internacional</option>
            <option value="Sao Paulo">São Paulo</option>
            <option value="Fluminense">Fluminense</option>
        </select><br><br>
        <input class="button" type="submit" value="Pesquisar" style="margin-left: 21%">
        <input class="button" type="reset" value="Limpar" style="margin-left: 20px">
    </form>
    <hr>
    <table border="1">
        <tr>
            <th>Nome</th>
            <th>Time</th>
            <th>Altura</th>
            <th>Peso</th>
            <th>Idade</th>
        </tr>
        <%
            if (request.getAttribute("players") == null) {
        %>
        <tr>
            <td colspan="4">Nenhum dado encontrado!!!</td>
        </tr>
        <%
        } else {
            Player[] players = (Player[])request.getAttribute("players");
            for (int i=0; i<players.length; i++) {
        %>
        <tr>
            <td><%= players[i].getName()%></td>
            <td><%= players[i].getTeam()%></td>
            <td><%= players[i].getHeight()%></td>
            <td><%= players[i].getWeight()%></td>
            <td><%= players[i].getAge()%></td>
        </tr>
        <%
                }
            }
        %>
    </table>

</div>

<%@include file="footer.jsp"%>