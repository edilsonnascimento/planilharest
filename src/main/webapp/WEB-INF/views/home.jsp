<%-- 
    Document   : home
    Created on : Jan 11, 2019, 2:19:58 PM
    Author     : ednascimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grupo Expoente</title>
    </head>
    <body>
        <h1>GRUPO EXPOENTE </h1>
        
        <nav> 
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="${s:mvcUrl('IC#inscricao').build()}">Importar Planilha </a></li>
            </ul>
        </nav>
    </body>
</html>
