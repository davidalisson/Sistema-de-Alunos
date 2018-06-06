<%@page import="br.com.dao.AlunoDAO"%>
<%@page import="br.com.entidades.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    AlunoDAO alunoDao = new AlunoDAO();
   List<Aluno> lista = alunoDao.getLista();
  
%>

<html>
    <head>
        <link rel="icon" type="image/png" href="icon.png" />
        <title>Sistema de Alunos</title>

        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
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

        <!-- FormulÃ¡rio-->
       <div id="divForm">
          <form class="form-inline" role="form" action="AlterarNotas" method="post">
                
              <div class="control-group">
                    <label for="inputMatricula" class="control-label">Digite a matrícula do aluno:</label>
                    <div class="controls">
                       <input type="number" required="required"  name="inputMatricula" placeholder="Digite a matricula..." />
                   
                    </div>
                </div>
              
                <div class="control-group">
                    <label for="inputNome" class="control-label">Nota 1:</label>
                    <div class="controls">
                          <input type="number" required="required" step="0.1" min="0" max="10" name="nota1" placeholder="Nota 1...">
                   
                    </div>
                </div>
                <br>
                <div class="control-group">
                    <label for="inputNome" class="control-label">Nota 2:</label>
                    <div class="controls">
                        <input type="number" required="required" step="0.01" min="0" max="10" name="nota2" placeholder="Nota 2...">
                   
                    </div>
                </div>
                
                <br>
                
                <div class="control-group">
                    <div class="controls">
                      <input class="btn btn-primary" type="submit" value="Alterar"onclick="return confirm('Fazer alterações?')/>
                    </div>
                </div>
            </form>
                <div class="control-group">
                    <div class="controls">
                        <h4>Tabela:</h4>
                        <table border ="1" class="table table-hover">
                            <tr>
                                <th>Matrícula</th>
                                <th>Nome</th>
                                <th>Curso</th>
                                <th>Nota 1</th>
                                <th>Nota 2</th>
                                <th>Média</th>

                            </tr>
                            <%
                                for (int i=0;i< lista.size();i++) { 
                                     Aluno aluno= (Aluno) lista.get(i);
                            %>

                            <tr>                      
                                <td><%=aluno.getMatricula()%></td><td><%=aluno.getNome()%></td><td><%=aluno.getCurso()%></td><td><%=aluno.getNota1()%></td><td><%=aluno.getNota2()%></td><td><%=aluno.getMedia()%></td>
                                

                                

                            </tr>
                            <% } %>
                        </table>
                   
                    </div>
                </div>
                <br>

                

        </div>   





        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
