<%--
  Created by IntelliJ IDEA.
  User: rodrigo
  Date: 24/03/2023
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="cadastraNovaEmpresa" value="empresa-form"/>
<c:url var="editarEmpresa" value="empresa-edita"/>
<html>
<head>
    <title>Formulário</title>
</head>
<body>
<c:if test="${ not empty empresa }">
    <h3>Editando empresa</h3>
    <form action="${ editarEmpresa }" method="POST">
        <fieldset>

            <input type="hidden" value="${ empresa.id }" name="id" id="id">

            <label for="editaNome">Nome:</label>
            <input type="text" value="${ empresa.nome }" name="editaNome" id="editaNome">

            <label for="editaDataAbertura">Data de abertura:</label>
            <input type="date" value="${ empresa.dataAbertura }" name="editaDataAbertura" id="editaDataAbertura">
        </fieldset>
        <input type="submit">
    </form>
</c:if>
<c:if test="${ empty empresa }">
    <h3>Cadastrando empresa</h3>
    <form action="${ cadastraNovaEmpresa }" method="POST">
        <fieldset>
            <label for="cadastraNome">Nome:</label>
            <input type="text" name="cadastraNome" id="cadastraNome">

            <label for="cadastraDataAbertura">Data de abertura:</label>
            <input type="date" name="cadastraDataAbertura" id="cadastraDataAbertura">
        </fieldset>
        <input type="submit">
    </form>
</c:if>
</body>
</html>
