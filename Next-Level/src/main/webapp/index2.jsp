<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Next level</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="./css/inicio.css" />
<link rel="stylesheet" href="./img/Icons/css/all.min.css " />
<link rel="stylesheet" href="css/style.css" />
<style type="text/css">
#login {
	display: flex;
	margin-left: 575px;
	margin-top: -40px;
	margin-bottom: 20px;
}


</style>
</head>
<body>

	<header>


		<div class="nav">


			<div class="menu">
				<h1>
					<a href="index2.jsp" class="logo">Next-Level</a>
				</h1>
			
				<ul>
					<li class="menu-item"><a href="#cursos">Cursos</a></li>
					<li class="menu-item"><a href="./page/nos.html">Sobre n�s</a></li>
					<li class="menu-item"><a href="login.jsp">Login</a></li>
					<li class="menu-item"><a href="#cardFooter">Contatos</a></li>
				</ul>
			</div>
		</div>
	</header>
	<h9 id="login"> <%
     request.getSession().getAttribute("usuario");
	 Object usu = session.getAttribute("usuario");
	  System.out.println(usu); 
		 
 out.print("Bem Vindo(a) - " + usu);
 %> </h9>


	<i id="temaBtn" class="fa-solid fa-circle-half-stroke fa-flip"
		style="color: #ffffff" onclick="trocarTema()"></i>
	<svg id="iconMenu" xmlns="http://www.w3.org/2000/svg" height="16"
		width="14" viewBox="0 0 448 512">
      <!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2023 Fonticons, Inc.-->
      <path
			d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z" />
    </svg>
	<div class="menu2" id="menu2Id">
		<a href="#cursos"><li>Cursos</li></a> <a href="./page/nos.html"><li>Sobre
				n�s</li></a> <a href="login.jsp"><li>Login</li></a> <a href="#cardFooter"><li>Contatos</li></a>
		<svg id="closeMenu" xmlns="http://www.w3.org/2000/svg" height="16"
			width="16" viewBox="0 0 512 512">
        <!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2023 Fonticons, Inc.-->
        <path
				d="M256 48a208 208 0 1 1 0 416 208 208 0 1 1 0-416zm0 464A256 256 0 1 0 256 0a256 256 0 1 0 0 512zM175 175c-9.4 9.4-9.4 24.6 0 33.9l47 47-47 47c-9.4 9.4-9.4 24.6 0 33.9s24.6 9.4 33.9 0l47-47 47 47c9.4 9.4 24.6 9.4 33.9 0s9.4-24.6 0-33.9l-47-47 47-47c9.4-9.4 9.4-24.6 0-33.9s-24.6-9.4-33.9 0l-47 47-47-47c-9.4-9.4-24.6-9.4-33.9 0z" />
      </svg>
	</div>

	<div id="carouselExampleDark" class="carousel carousel-dark slide">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleDark"
				data-bs-slide-to="0" aria-label="Slide 1" id="bntCarousel"
				class="active" aria-current="true"></button>
			<button type="button" data-bs-target="#carouselExampleDark"
				data-bs-slide-to="1" aria-label="Slide 2" id="bntCarousel"></button>
			<button type="button" data-bs-target="#carouselExampleDark"
				data-bs-slide-to="2" aria-label="Slide 3" id="bntCarousel"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="10000">
				<section class="home">
					<div class="home-text">
						<h4 class="text-h4">Bem vindo a Next-level</h4>
						<h1 class="text-h1">Amplie seu Conhecimento</h1>
						<p>Na vanguarda da revolu��o tecnol�gica, a Next-Level � o seu
							destino definitivo para aprimorar suas habilidades e impulsionar
							sua carreira no mundo da Tecnologia da Informa��o. Oferecemos uma
							ampla gama de cursos especializados, ministrados por
							especialistas da ind�stria, para ajud�-lo a dominar as
							tecnologias mais recentes e atender �s demandas do mercado de
							trabalho em constante evolu��o.</p>
						<a href="./page/nos.html" class="home-btn">Sobre n�s</a>
					</div>

					<div class="home-img">
						<img src="./img/animacao/server-animate.svg" class="imgBannerHome" />
					</div>
				</section>
			</div>
			<div class="carousel-item" data-bs-interval="2000">
				<section class="home">
					<div class="home-text">
						<h4 class="text-h4">Bem vindo a Next-level</h4>
						<h1 class="text-h1">Amplie seu Conhecimento</h1>
						<p>Na vanguarda da revolu��o tecnol�gica, a Next-Level � o seu
							destino definitivo para aprimorar suas habilidades e impulsionar
							sua carreira no mundo da Tecnologia da Informa��o. Oferecemos uma
							ampla gama de cursos especializados, ministrados por
							especialistas da ind�stria, para ajud�-lo a dominar as
							tecnologias mais recentes e atender �s demandas do mercado de
							trabalho em constante evolu��o.</p>
						<a href="./page/nos.html" class="home-btn">Sobre n�s</a>
					</div>

					<div class="home-img">
						<img src="./img/animacao/server-animate.svg" class="imgBannerHome" />
					</div>
				</section>
			</div>
			<div class="carousel-item">
				<section class="home">
					<div class="home-text">
						<h4 class="text-h4">Bem vindo a Next-level</h4>
						<h1 class="text-h1">Amplie seu Conhecimento</h1>
						<p>Na vanguarda da revolu��o tecnol�gica, a Next-Level � o seu
							destino definitivo para aprimorar suas habilidades e impulsionar
							sua carreira no mundo da Tecnologia da Informa��o. Oferecemos uma
							ampla gama de cursos especializados, ministrados por
							especialistas da ind�stria, para ajud�-lo a dominar as
							tecnologias mais recentes e atender �s demandas do mercado de
							trabalho em constante evolu��o.</p>
						<a href="./page/nos.html" class="home-btn">Sobre n�s</a>
					</div>

					<div class="home-img">
						<img src="./img/animacao/server-animate.svg" class="imgBannerHome" />
					</div>
				</section>
			</div>
		</div>
	</div>
	<div class="containerbtnCarolsel">
		<button id="prev" class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleDark" data-bs-slide="prev">
			<span><</span>
		</button>
		<button id="next" class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleDark" data-bs-slide="next">
			<span>></span>
		</button>
	</div>
	<h1 class="textCurso" id="cursos">Conhe�a Todos os Cursos</h1>
	<div class="containerCardCursos">
		<div class="card" id="cardAllCourse" style="width: 18rem">
			<img class="card-img-top"
				src="img/imgCurso/Desenvolvimento Full Stack.jpg"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">Desenvolvimento Full Stack</h5>
				<p class="card-text">Prepare-se para dominar o desenvolvimento
					Full Stack, explorando todas as camadas para uma carreira din�mica
					e cheia de oportunidades em software.</p>
				<a href="page/Cursos/curso2.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top"
				src="img/imgCurso/Engenharia da Computa��o.jpg"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">Engenharia da Computa��o</h5>
				<p class="card-text">Curso de Engenharia da Computa��o: Explore
					inova��o, lidere a revolu��o digital, desenvolva habilidades
					essenciais em hardware e software para moldar o futuro da
					computa��o.</p>
				<a href="./page/Cursos/curso3.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top" src="img/imgCurso/Ci�ncia de Dados.jpg"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">
					Ci�ncia de Dados<br /> <br />
				</h5>
				<p class="card-text">Desvende segredos em dados! Nosso curso de
					Ci�ncia de Dados capacita voc� a analisar informa��es, tornando-se
					um mestre na revolu��o, moldando o futuro com insights
					significativos.</p>
				<a href="./page/Cursos/curso4.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top" src="img/imgCurso/banco.webp"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">
					Banco de Dados <br /> <br />
				</h5>
				<p class="card-text">Domine a gest�o de dados para impulsionar
					sua carreira com o Curso de Banco de Dados: destaque-se no mercado
					de TI com uma jornada pr�tica e envolvente.</p>
				<a href="page/Cursos/curso1.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top" src="img/imgCurso/redes.jpg"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">Redes de Computadores</h5>
				<p class="card-text">Nosso Curso de Redes de Computadores
					capacita l�deres para o futuro digital, promovendo imers�o completa
					e troca instant�nea de informa��es globais.</p>
				<a href="./page/Cursos/curso5.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top" src="img/imgCurso/defesa.webp"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">
					Defesa Cibern�tica <br /> <br />
				</h5>
				<p class="card-text">Curso de Defesa Cibern�tica: Imers�o
					completa na seguran�a online, capacitando para enfrentar amea�as
					emergentes e proteger sistemas digitais na era digital.</p>
				<a href="page/Cursos/curso6.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top" src="img/imgCurso/Digitar.jpg"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">An�lise e Desenvolvimento</h5>
				<p class="card-text">Transforme sua paix�o pela tecnologia em
					habilidades pr�ticas com nosso Curso de An�lise e Desenvolvimento,
					ideal para uma carreira inovadora em software.</p>
				<a href="page/Cursos/curso7.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top" src="img/imgCurso/Dev.jpg"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">
					DevOps <br /> <br />
				</h5>
				<p class="card-text">Junte-se � revolu��o DevOps: curso
					abrangente para integrar inova��o, automa��o e colabora��o no
					desenvolvimento de software.</p>
				<a href="page/Cursos/curso8.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top" src="img/imgCurso/cloud.webp"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">Ci�ncia da Computa��o</h5>
				<p class="card-text">Curso de Ci�ncia da Computa��o: jornada
					intelectual para desvendar tecnologia, explorar algoritmos e moldar
					o futuro digital, com imers�o nos fundamentos e avan�os.</p>
				<a href="page/Cursos/curso9.html" class="btn btn-primary"
					id="saibamaisCursos"> Saiba Mais </a>
			</div>
		</div>
		<div class="card" style="width: 18rem">
			<img class="card-img-top" src="img/imgCurso/Casal.webp"
				alt="Imagem de capa do card" />
			<div class="card-body">
				<h5 class="card-title">Licenciatura em Computa��o</h5>
				<p class="card-text">Curso de Licenciatura em Computa��o
					inovador une educa��o e tecnologia, capacitando educadores digitais
					para moldar mentes e inspirar inova��o na pr�xima gera��o.</p>
				<a href="page/Cursos/curso10.html" class="btn btn-primary"
					id="saibamaisCursos">Saiba Mais</a>
			</div>
		</div>
	</div>
	<footer>
		<div class="cardFooter">
			<a href="./index.html">Next-Level</a>
		</div>
		<div class="cardFooter">
			<li><a href="#cursos">Cursos</a></li>
			<li><a href="./page/nos.html">Sobre n�s</a></li>
			<li><a href="login.jsp">Login</a></li>
		</div>
		<div class="cardFooter" id="cardFooter">
			<a href="https://www.facebook.com" target="_blank"> <svg
					xmlns="http://www.w3.org/2000/svg" height="16" width="16"
					viewBox="0 0 512 512">
            <!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2023 Fonticons, Inc.-->
            <path
						d="M512 256C512 114.6 397.4 0 256 0S0 114.6 0 256C0 376 82.7 476.8 194.2 504.5V334.2H141.4V256h52.8V222.3c0-87.1 39.4-127.5 125-127.5c16.2 0 44.2 3.2 55.7 6.4V172c-6-.6-16.5-1-29.6-1c-42 0-58.2 15.9-58.2 57.2V256h83.6l-14.4 78.2H287V510.1C413.8 494.8 512 386.9 512 256h0z" />
          </svg>
			</a> <a href="https://www.instagram.com" target="_blank"> <svg
					xmlns="http://www.w3.org/2000/svg" height="16" width="14"
					viewBox="0 0 448 512">
            <!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2023 Fonticons, Inc.-->
            <path
						d="M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z" />
          </svg>
			</a> <a href="https://twitter.com/?lang=pt-br" target="_blank"> <svg
					xmlns="http://www.w3.org/2000/svg" height="16" width="16"
					viewBox="0 0 512 512">
            <!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2023 Fonticons, Inc.-->
            <path
						d="M389.2 48h70.6L305.6 224.2 487 464H345L233.7 318.6 106.5 464H35.8L200.7 275.5 26.8 48H172.4L272.9 180.9 389.2 48zM364.4 421.8h39.1L151.1 88h-42L364.4 421.8z" />
          </svg>
			</a>
		</div>
	</footer>

	<script src="./js/script.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>














	<!-- 	<div class="container-fluid text-center"> -->
	<!-- 					<div class="row"> -->
	<!-- 						<div class="col-md-20" id="user"> -->

	<%-- 							<h9> <% --%>
	// Object usu = session.getAttribute("usuario"); // out.print("Bem
	Vindo(a) - " + usu);
	<%--  %> </h9> --%>
	<!-- 						</div> -->
	<!-- 					</div> -->
	<!-- 				</div> -->




</body>
</html>
