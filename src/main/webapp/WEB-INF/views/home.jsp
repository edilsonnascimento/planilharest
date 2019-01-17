<%-- 
    Document   : home
    Created on : Jan 11, 2019, 2:19:58 PM
    Author     : ednascimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Grupo Expoente <a class="nav-link" href="#">Features</a> </title>
    </head>
    <body>
        <a class="nav-link" href="#"><h1>GRUPO EXPOENTE </h1> </a>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">HOME</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Importar<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${s:mvcUrl('IC#lista').build()}"> Listar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"></a>
                    </li>
                </ul>
                <span class="navbar-text">
                    usuario@expoente.com.br
                </span>
            </div>
        </nav>
        
        <br /><br />
        
        <center>
            <p>${mensagem}</p>
            <form:form action="${s:mvcUrl('IC#importa').build()}" method="post" enctype="multipart/form-data">
                <div>
                    <label>Código do Cliente</label>
                    <input type="text" name="codigo"/>
                </div>        
                <div>
                    <label>Planilha</label>    
                    <input name="arquivo " type="file" />
                </div>
                <button type="submit">Importar</button>
            </form:form>
        </center>              

</body>
</html>
