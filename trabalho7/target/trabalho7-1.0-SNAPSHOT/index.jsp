<%-- 
    Document   : index
    Created on : 16/05/2018, 15:59:19
    Author     : João Paulo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" uri="WEB-INF/tags.tld"%>

<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Validando e mostrando tabela com uma Tag</h1>
        <form action="MyServlet" method="POST">
            <fieldset>
                <legend>Notas do Aluno:</legend>
                Nome:       <input type="text" name="nome"> ${msgNome} <br>
                Frequencia: <input type="text" name="freq"> ${msgFreq} <br>
                P1:         <input type="text" name="p1"> ${msgP1} <br>
                Trabalhos:  <input type="text" name="trab"> ${msgTrab} <br>
                Projeto:    <input type="text" name="proj"> ${msgProj} <br>
                PF:         <input type="text" name="pf"> ${msgPf} <br>
                <br>
                <input type="submit" value="Enviar">
            </fieldset>
        </form>
        
        <table id="customers">
            <tr>
                <th>Nome</th>
                <th>Frequencia</th>
                <th>P1</th>
                <th>Trabalhos</th>
                <th>Projetos</th>
                <th>Prova Final</th>
                <th>Situação</th>
            </tr>
            <c:if test="${not empty lista}">
                <tags:ImprimeTag lista="${lista}"/>
            </c:if>
        </table>
    </body>
</html>
