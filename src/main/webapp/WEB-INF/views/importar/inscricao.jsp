<%-- 
    Document   : inscricao
    Created on : Jan 11, 2019, 2:40:54 PM
    Author     : ednascimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GRUPO EXPOENTE</title>
    </head>
    <body>
        <title>Importar Planilha</title>    

        <form action='/planilharest/importar' method="post">
            <div>
                <label>Código do Cliente</label>
                <input type="text" name="cod_cliente_sga"/>
            </div>
            <button type="submit">Importar</button>
        </form>
    </body>
</html>
