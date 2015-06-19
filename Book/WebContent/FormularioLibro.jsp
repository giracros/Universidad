<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link data-require="bootstrap-css@*" data-semver="3.3.1"
	rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<script data-require="jquery@2.1.3" data-semver="2.1.3"
	src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script data-require="bootstrap@*" data-semver="3.3.2"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css" />
<script type='text/javascript'>
        function validacion(){
         var isbn = document.getElementById("ISBN");
         var miformulario = document.getElementById("miformulario");
         if (isbn.value == ""){
                 alert ("datos vacios");
        return false;
         }
              else
         miformulario.submit();
        }
    </script>
</head>

<body>
	<h1>Inserte un libro</h1>
	<form class="form-inline" id='miformulario'>
		<div class="form-group">
			<label for="ISBN">ISBN</label> <input type="text"
				class="form-control" id="ISBN" placeholder="Inserte un Codigo" />
		</div>
		<div class="form-group">
			<label for="Titulo">Titulo</label> <input type="text"
				class="form-control" id="Titulo" placeholder="Ponga un titulo" />
		</div>
		<div class="form-group">
			<label for="Categoria">Categoria</label> <input type="text"
				class="form-control" id="Categoria"
				placeholder="Ponga una categoria" />
		</div>
		<button type="button" value='Insertar' class="btn btn-default"
			onclick="return validacion();">Insertar</button>
	</form>
</body>
</html>