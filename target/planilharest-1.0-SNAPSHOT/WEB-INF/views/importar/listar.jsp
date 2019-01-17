<%-- 
    Document   : listar
    Created on : Jan 16, 2019, 2:19:29 PM
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
        <a align = "center" class="nav-link" href="${s:mvcUrl('HC#index').build()}"><h1>Lista de Produtos</h1> </a>
        
        <div>            
            <form action="${s:mvcUrl('IC#listaPorCLiente').build()}" method="get">
                <label>Código do Cliente</label>
                <input type="text" name="cod_cliente_sga"/>
                <button type="submit">Pesquisar</button>
            </form>
        </div>
        
        <div class="container" >
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <td>Código SGA</td>
                    <td>Nome Aluno</td>
                    <td>Serie</td>
                    <td>Curso</td>
                    <td>Turma</td>
                    <td>Turno</td>
                </tr>            
                <c:forEach items="${inscricoes}" var="inscricao">
                    <tr>
                        <td>${inscricao.cod_cliente_sga}</td>                  
                        <td>${inscricao.nm_inscrito}</td>                
                        <td>${inscricao.nm_serie}</td>
                        <td>${inscricao.nm_curso}</td>
                        <td>${inscricao.nm_turma}</td>
                        <td>${inscricao.nm_turno}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
    
</html>
