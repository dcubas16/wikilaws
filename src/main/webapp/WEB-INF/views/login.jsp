<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en" class="translated-ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="../views/jspf/resources.jsp" />


<title>Wikilegal</title>

<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/dist/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/examples/signin/signin.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->



</head>

<body class=" wa2biys">

	<div class="container">

		<form class="form-signin" name=form >
			<h2 class="form-signin-heading">
				<font><font>Por favor, inicie sesión</font></font>
			</h2>
			<input type="text" class="form-control" placeholder="Email address"
				autofocus="" name=login> <input type="password"
				class="form-control" placeholder="Password" name=password>
			<!--<INPUT onclick=go() type=button value=Acceder>-->
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				onclick="go(event)">
				<font><font>Iniciar Sesión</font></font>
			</button>
		</form>

	</div>
	<!-- /container -->



<script language=javascript>
	function go(e){
		e.preventDefault();
		if (document.form.password.value='1234' && document.form.login.value=='erwin'){
			
// 			response.redirect("../wikilaws/home.htm");
			window.location.href = "../wikilaws/home.htm";
	    }
	    else{
	        alert("Porfavor ingrese, nombre de usuario y contraseña correctos.");
	    }
	}
</script>
	<!-- 
<FORM name=form action="TU_PAGINA_WEB.HTML">

<P>Usuario:    <INPUT type=text name=login>
<P>ContraseÃ±a: <INPUT type=password name=password>
<INPUT onclick=go() type=button value=Acceder>

</FORM>  -->

</body>
</html>