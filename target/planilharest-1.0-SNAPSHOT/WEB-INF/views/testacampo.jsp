<%-- 
    Document   : EscondeCampo
    Created on : Jan 16, 2019, 8:54:02 AM
    Author     : ednascimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Untitled Document</title>
        <script language="javascript">
            
        function HabCampos() {
          if (document.getElementById('periodo_sim').checked) {
                document.getElementById('campos').style.display = "";
                document.getElementById('textfield').focus();
          }  else {
                document.getElementById('campos').style.display = "none";
          }}
      
        function Mostra() {
                document.getElementById('campos').style.display = "";
                document.getElementById('textfield').focus();
        }

        </script>
        
        
    </head>
    <body>
        <form name="form1" method="post" action="">
            <input name="periodo" id="periodo_sim" type="radio" value="sim" onClick="HabCampos()"/>Sim
            <input name="periodo" id="periodo_nao" type="radio" value="nao" onClick="HabCampos()"/>N&atilde;o<br/><br/>
            
            <a class="nav-link" href="#" onClick="Mostra()">Importar</a> <br /><br />
            
            <label id="campos" style="display:none">
                Nome:<input type="text" name="textfield" id="textfield"/><br/><br/>
                <input name="checkbox1" type="checkbox" id="checkbox1" value="profissional"/>Profissional
                <input type="checkbox" name="checkbox2" id="checkbox2" value="t&eacute;cnico"/>T&eacute;cnico
                <input type="checkbox" name="checkbox3" id="checkbox3" value="Estagiario"/>Estagi&aacute;rio
            </label>
        </form>
   
       
    </body>
</html>
