<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        
    }else{    
        String nome =((br.com.entidades.Usuario)session.getAttribute("usuario")).getNome();
    
%>
<html>
    <head>
        <link rel="icon" type="image/png" href="icon.png" />
        <title>Sistema de Alunos</title>
     
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <!-- Carregando o CSS do Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        
        
        
    </head>
    <body >
        <nav class="navbar navbar-inverse " >

            <ul class="nav nav-pills">
                <a class="navbar-brand" href="#">Sistema de Alunos </a>

                <li role="presentation" class="active"><a href="index.jsp">Início</a></li>


                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                        Aluno <span class="caret"></span>
                    </a>
                <ul class="dropdown-menu">
                    <li><a href="cadastrarAluno.html">Cadastrar</a></li>
                    <li><a href="alterarAluno.jsp">Alterar</a></li>
                    <li><a href="listarAluno.jsp">Listar</a></li>
                    <li><a href="excluirAluno.jsp">Excluir</a></li>
                  
                </ul>
                    <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                        Notas <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                    <li><a href="cadastrarNotas.jsp">Cadastrar</a></li>
                    <li><a href="alterarNotas.jsp">Alterar</a></li>
                    <li><a href="excluirNotas.jsp">Excluir</a></li>

                    </ul>
                       
            </ul>
        </nav>
        <div class="page-header" >
            <h1>Bem Vindo: <%=nome %></h1>
            <!--<h1>Seu Login: <jsp:getProperty name="usuario" property="login"/></h1>-->
           
            <form method="post" action="login" name="form1">
                <input type="hidden" value="yes" name="logout">
                <input type="submit" class="btn btn-primary" value="Logout" >
            </form>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
<%}%>