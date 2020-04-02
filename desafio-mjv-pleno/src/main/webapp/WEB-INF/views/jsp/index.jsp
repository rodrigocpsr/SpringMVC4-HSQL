<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>

<title>Desafio MJV - Pleno</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/css/tempusdominus-bootstrap-4.min.css" />
<link href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet">

</head>

<body>
	
	<div class="container">
	
		<h3 style="text-align: center;">PRJ: Desafio MJV - Nível: Pleno - Por: Rodrigo Carlos</h3><br><br>

		<div class="form-group">

			<fieldset class="border p-2" >
				<legend class="w-auto">Cadastro de Colaborador</legend>

					<form:form action="adicionar" method="post" modelAttribute="colaborador">
					  <div class="form-row">
					    <div class="form-group col-md-6">
					      <label for="inputEmail4">Nome*</label>
					      <form:input class="form-control" path="nome" required="required" maxlength="30" />
					    </div>
					    <div class="form-group col-md-6">
					      <label for="inputPassword4">Sobrenome*</label>
					     <form:input class="form-control" path="sobrenome" required="required" maxlength="30" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputEmail">E-mail*</label>
					     <form:input class="form-control" path="email" required="required" maxlength="50" type="email"/>
					  </div>
					  <div class="form-row">
					    <div class="form-group col-md-4">
					      <label for="inputState">Departamento</label>
					      <form:select class="form-control" path="departamento">
								<form:option value="Select" disabled="true" selected="selected">-- Selecione --</form:option>
								<form:option value="Saude">Saude</form:option>
								<form:option value="Seguros">Seguros</form:option>
						 </form:select>
					    </div>
					    <div class="form-group col-md-4">
					      <label for="inputState">Projeto</label>
					      <form:select class="form-control" path="projeto">
								<form:option value="Select" disabled="true" selected="selected">-- Selecione --</form:option>
								<form:option value="PRJ Vendas">PRJ Vendas</form:option>
								<form:option value="PRJ Bibnet">PRJ Bibnet</form:option>
						 </form:select>
					    </div>
					   	<div class="form-group col-md-4">
					      <label for="inputState">Gestor</label>
					      <form:select class="form-control" path="gestor">
							<form:option value="Select" disabled="true" selected="selected">-- Selecione --</form:option>
							<form:option value="Marcia">Marcia</form:option>
							<form:option value="Paulo">Paulo</form:option>
						 </form:select>
					    </div>	
					  </div>
					  <input type="submit" class="btn btn-primary" name="action" value="Cadastrar" />
				</form:form>

			</fieldset>

			<br>
			<br>

			<!-- MENSAGEM ERRO -->
			<c:if test="${msgErro != null}"> 
				<div class="alert alert-danger" role="alert3">
					<strong>Atenção!</strong> ${msgErro}
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    				<span aria-hidden="true">&times;</span>
    				</button>
				</div>
			</c:if>
						
			<fieldset class="border p-2">
				
				<legend class="w-auto">Lista de Colaboradores</legend><br>
				
				<form class="form" name="tabelaForm" action="/excluir" method="post">
					
					<table id="colaboradorTabela" class="table">
						<thead>
							<tr style="text-align: center;">
								<th>Id</th>
								<th>Nome</th>
								<th>Sobrenome</th>
								<th>E-mail</th>
								<th>Projeto</th>
								<th>Gestor</th>
								<th>Departamento</th>
								<th>Ação</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstColaborador}" var="colaborador">
								<tr>
									<td>${colaborador.idcolaborador}</td>
									<td>${colaborador.nome}</td>
									<td>${colaborador.sobrenome}</td>
									<td>${colaborador.email}</td>
									<td>${colaborador.projeto}</td>
									<td>${colaborador.gestor}</td>
									<td>${colaborador.departamento}</td>
									<td style="text-align: center; padding: 1px">
										<a class="btn btn-info" data-toggle="modal" data-target="#modalExemplo" onclick="setaDadosModal('${colaborador.idcolaborador}','${colaborador.nome}','${colaborador.sobrenome}','${colaborador.email}','${colaborador.projeto}','${colaborador.gestor}','${colaborador.departamento}')">Editar</a>
										<a href="excluir?id=${colaborador.idcolaborador}" class="btn btn-danger">Excluir</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</form>

					<!-- MODAL EDITAR -->
					<div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
						<form:form action="alterar" method="post" modelAttribute="colaborador">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Editar Colaborador</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
										  <div class="form-row">
											<form:input class="form-control" path="idcolaborador" type="hidden" name="cid" id="cid"/>
										    <div class="form-group col-md-6">
										      <label for="nomeForm">Nome*</label>
										      <form:input class="form-control" path="nome" type="text" name="cnome" id="cnome" maxlength="30"/>
										    </div>
										    <div class="form-group col-md-6">
										      <label for="sobrenomeForm">Sobrenome*</label>
										     <form:input class="form-control" path="sobrenome" type="text" name="unome" id="unome" maxlength="30" />
										    </div>
										  </div>
										  <div class="form-group">
										    <label for="emailForm">E-mail*</label>
										     <form:input class="form-control" path="email" type="text" name="cmail" id="cmail" maxlength="50" />
										  </div>
										  <div class="form-row">
										    <div class="form-group col-md-4">
										      <label for="deptoForm">Departamento</label>
										      	<form:select class="form-control" path="departamento" name="cdepto" id="cdepto">
										      		<form:option value=""></form:option>
												    <form:option value="Seguros">Seguros</form:option>
												    <form:option value="Saude">Saude</form:option>
												</form:select>
										    </div>
										    <div class="form-group col-md-4">
										      <label for="prjForm">Projeto</label>
										      	<form:select class="form-control" path="projeto" name="cprj" id="cprj">
										      		<form:option value=""></form:option>
												    <form:option value="PRJ Vendas">PRJ Vendas</form:option>
												    <form:option value="PRJ Bibnet">PRJ Bibnet</form:option>
												</form:select>
										    </div>
										   	<div class="form-group col-md-4">
										      <label for="gestorForm">Gestor</label>
										        <form:select class="form-control" path="gestor" name="cgestor" id="cgestor">
										        	<form:option value=""></form:option>
												    <form:option value="Marcia">Marcia</form:option>
												    <form:option value="Paulo">Paulo</form:option>
												</form:select>
										    </div>	
										  </div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
									<input type="submit" class="btn btn-primary" name="action" value="Alterar" />
								</div>
							</div>
						</form:form>
						</div>
					</div>

				
	
			</fieldset>

		</div>

	</div>

  	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
  	<script src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/js/tempusdominus-bootstrap-4.min.js"></script>

	<script>
		function setaDadosModal(valor1, valor2, valor3, valor4, valor5, valor6, valor7) {
			document.getElementById('cid').value = valor1;
			document.getElementById('cnome').value = valor2;
		    document.getElementById('unome').value = valor3; 
		    document.getElementById('cmail').value = valor4;
		    document.getElementById('cprj').value = valor5;
		    document.getElementById('cgestor').value = valor6;
		    document.getElementById('cdepto').value = valor7;
		}
	</script>

	<script>
	  $(document).ready(function(){
		  
	      $('#colaboradorTabela').DataTable({
	    	  searching: false,
	    	  ordering:  false,
	    	  "language": {
	                "lengthMenu": "Mostrando _MENU_ registros por página",
	                "zeroRecords": "Nada encontrado",
	                "info": "Mostrando página _PAGE_ de _PAGES_",
	                "infoEmpty": "Nenhum registro disponível",
	                "infoFiltered": "(filtrado de _MAX_ registros no total)"
	            }
	        });
	  });
	  </script>
</body>