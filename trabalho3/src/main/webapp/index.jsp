<%-- 
    Document   : newjsp
    Created on : 04/04/2018, 15:08:12
    Author     : João Paulo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.trabalho3.MyServlet"%>
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
        <form action="MyServlet" method="POST">
            <fieldset>
                <legend>Notas do Aluno:</legend>
                Nome:       <input type="text" name="nome"><br>
                Frequencia: <input type="text" name="freq"><br>
                P1:         <input type="text" name="p1"><br>
                Trabalhos:  <input type="text" name="trab"><br>
                Projeto:    <input type="text" name="proj"><br>
                PF:         <input type="text" name="pf"><br>
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
            <%
                if(application.getAttribute("lista") != null){
                %>
            <% 
                for(int i =0; i<((List)application.getAttribute("lista")).size(); i+= 7){
                    %>
                    <tr>
                    <%
                    for(int j = i; j<i+7; j++){
                        %>
                        <td> 
                            <%=((List)application.getAttribute("lista")).get(j) %> 
                        </td>
                        <%
                        
                    }
                %>
                    </tr>
                <%
                }
}
            %>
        </table>
    </body>
</html>
