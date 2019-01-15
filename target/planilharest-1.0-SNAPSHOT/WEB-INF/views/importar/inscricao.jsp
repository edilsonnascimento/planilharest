<%-- 
    Document   : inscricao
    Created on : Jan 11, 2019, 2:40:54 PM
    Author     : ednascimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>GRUPO EXPOENTE</title>
    </head>
    <body>
        <title>Importar Planilha</title>    

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

        <table>
            <tr>
                <td>Código SGA</td>
                <td>Nome Aluno</td>
            </tr>            
            <c:forEach items="${inscricoes}" var="inscricao">
                <tr>
                    <td>${inscricao.cod_cliente_sqa}</td>                  
                    <td>${inscricao.nm_inscrito}</td>                
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
