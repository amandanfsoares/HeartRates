 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
   <html>
   <head>
   <title>Alterar Paciente</title>
   <meta charset="utf-8">
   </head>
  <body>
      <h3>Alterar Paciente - ${heart.id} </h3>
      <form action="alterarpaciente" method="post">

          <input type="hidden" name="id" value="${heart.id}" />

          Nome:<br>
          <input type="text" name="nome" value="${heart.nome}"><br>            
		 Sobrenome:<br>
          <input  type="text" name="sobrenome" value="${heart.sobrenome}"><br>            
		 Dia:<br>
          <input type="number" name="dia" value="${heart.dia}"><br>            
		 Mes:<br>
          <input type="number" name="mes" value="${heart.mes}"><br>            
		 Ano:<br>
          <input  type="number"name="ano" value="${heart.ano}" ><br>
               
		
        <br><br>
          <input type="submit" value="Alterar"/>
      </form>
  </body>
  </html>