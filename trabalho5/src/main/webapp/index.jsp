<%-- 
    Document   : index
    Created on : 16/05/2018, 15:59:19
    Author     : João Paulo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
        </style>
    </head>
    <body>
        <h1>Validando e mostrando tabela com JSTL</h1>
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
                <c:forEach items="${lista}" var="item">
                    <tr>
                        <td>${item.getNome()}</td>
                        <td>${item.getFrequencia()}</td>
                        <td>${item.getP1()}</td>
                        <td>${item.getTrab()}</td>
                        <td>${item.getProj()}</td>
                        <td>${item.getPf()}</td>
                        <td>${item.situacao()}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>
