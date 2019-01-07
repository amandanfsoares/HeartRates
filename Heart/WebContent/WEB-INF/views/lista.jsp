<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="spring.Idade" %>
<%@page import="spring.HeartRates" %>
<%@page import="spring.FrequenciaCardiaca" %>
<%@page import="spring.FrequenciaCardiacaAlvo" %>
<html>
<head>
<style>
	body{
		background-image:url("https://i.pinimg.com/originals/21/b7/82/21b78225953c1f1f817da2d8c92f9aa9.jpg");
		background-size:cover;
		}
	table{
	text-align:center;


}
</style>
<title>Lista de Pacientes</title>
<meta charset="utf-8">
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Sobrenome</th>
			<th>Dia</th>
			<th>Mes</th>
			<th>Ano</th>
			<th>Idade</th>
			<th>Frequência Cardiaca</th>
			<th>Frequência Cardiaca Mínima</th>
			<th>Frequência Cardiaca Máxima</th>	
			<th colspan="2"> Ações</th>
			</tr>
	<c:forEach items="${heart}" var="paciente">
				<tr>
					<td>${paciente.id}</td>
					<td>${paciente.nome}</td>
					<td>${paciente.sobrenome}</td>
					<td>${paciente.dia}</td>
					<td>${paciente.mes}</td>
					<td>${paciente.ano}</td>
						<%
			
			HeartRates heart = new HeartRates();
			heart =(HeartRates) pageContext.getAttribute("paciente");
			Idade ida = new Idade(heart);
			FrequenciaCardiaca fqc = new FrequenciaCardiaca(ida,heart);
			FrequenciaCardiacaAlvo fqca = new FrequenciaCardiacaAlvo(ida,heart,fqc);
			
			%>
					<td><%=ida.Calculo(heart)%></td>
					<td><%=fqc.CalcularFreqCard(ida, heart)%></td>
					<td><%=fqca.CalcFreqCardAlvInicio(fqc)%></td>
					<td><%=fqca.CalcFreqCardAlvFim(fqc)%></td>
					
					<td><a href="removepaciente?id=${paciente.id}">Remover</a></td>
					 <td><a href="updatepaciente?id=${paciente.id}">Alterar</a></td>
					

				</tr>
			</c:forEach></table>
			
		
	<br>
	<br>
	<a href="heart">Cadastrar novo paciente</a>
</body>
</html>