<%--
  Created by IntelliJ IDEA.
  User: rodrigo
  Date: 24/03/2023
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="empresa-remove" var="remover"/>
<c:url value="empresa-edita" var="editar"/>

<html>
<head>
    <title>Lista</title>
</head>
<body>
Lista de Empresas<br/>


<c:if test="${ not empty mensagem }">
    <h2>
        ${ mensagem }
    </h2>
</c:if>

<c:if test="${ empty empresas }">
    <li>
        Nenhuma empresa listada.
    </li>
</c:if>
<ul>
    <c:forEach items="${ empresas }" var="empresa" >
        <li>
                ${ empresa.id } |
                ${ empresa.nome } -
                    <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
                    <a href="${ editar }?id=${ empresa.id }">editar</a>
                    <a href="${ remover }?id=${ empresa.id }">remover</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
