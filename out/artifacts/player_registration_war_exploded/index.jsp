<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h2>Cadastro de Jogadores</h2>
<div class="global">
    <form action="ProcessingInsertPlayer" method="post" onsubmit="return requiredField()">
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
        </select>
        <br><br>
        <label for="height">Altura:</label>
        <input type="text" name="height" id="height" maxlength="4" onchange="heightValidation()">
        <br><br>
        <label for="weight">Peso:</label>
        <input type="text" name="weight" id="weight" maxlength="5" onchange="weightValidation()">
        <br><br>
        <label for="age">Idade:</label>
        <input type="text" name="age" id="age" maxlength="2" onchange="ageValidation()">
        <br><br>
        <input class="button" type="submit" value="Cadastrar" style="margin-left: 21%">
        <input class="button" type="reset" value="Limpar" style="margin-left: 20px">
    </form>
</div>
<%@include file="footer.jsp"%>
