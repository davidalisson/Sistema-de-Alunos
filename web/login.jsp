<%
    if (session.getAttribute("usuario") != null) {
        response.sendRedirect("index.jsp");
    }
%>


<html>
    <head>
        <link rel="icon" type="image/png" href="icon.png" />
        <title>Login SisAluno</title>

        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Carregando o CSS do Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">




        <script>
            var ajaxRequest;

            function getXMLHttpRequest() {
                var ajax = null;
                if (window.XMLHttpRequest)
                {
                    ajax = new XMLHttpRequest();
                } else if (window.ActiveXObject)
                {
                    try
                    {
                        ajax = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e)
                    {
                        ajax = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                return ajax;
            }

            window.onload = function () {


                document.getElementById("botao").onclick = function () {
                    var login = document.frm1.login.value;
                    var senha = document.frm1.senha.value;
                    var div = document.getElementById("msg");
                    if (!login.length) {
                        div.innerHTML = "O login deve ser preenchido!";
                        return true;
                    }
                    exp = /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/;
                    
                    if (!exp.test(senha)) {
                        div.innerHTML = "A senha deve ter mais de 8 caracteres e\n\
                        possuir pelo menos 1 letra minúscula(ex: abc), 1 letra maiúscula(ex: ABC) e 1 dígito(0 a 9)";
                        return true;
                    }
                    getLoginAjax(login, senha);

                }
            }

            function getLoginAjax(login, senha) {
                ajaxRequest = getXMLHttpRequest();
                if (ajaxRequest) {   //  se o navagador suporta ajax
                    ajaxRequest.onreadystatechange = ajaxLoginResposta;
                    ajaxRequest.open("POST", "login");
                    ajaxRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    var parametros = "login=" + login + "&senha=" + senha;
                    ajaxRequest.send(parametros);
                }
            }

            function ajaxLoginResposta() {
                if (ajaxRequest.readyState != 4)  //  Checa se a requisição foi completada
                {
                    return;
                }
                else {

                    if (ajaxRequest.status == 200) //  Checa se o código HTTP é de sucesso
                    {
                        var divMsg = document.getElementById("msg");

                        var resposta = ajaxRequest.responseText;
                        if (resposta == "OK") {
                            divMsg.innerHTML = "Sussesso!";
                            setTimeout(function () {
                                window.location.href = "index.jsp"
                            }, 2000);
                        }
                        if (resposta == "Erro") {
                            divMsg.innerHTML = "Usuario e/ou Senha incorretos!";
                        }
                    }
                    else {
                        alert("Falhou: " + ajaxRequest.status + " " + ajaxRequest.statusText);
                    }
                }
            }
        </script>

    </head>
    <body >

        <!-- Formulário-->
        <div id="divForm">
            <form class="form-inline" method="POST" role="form" action="login" name="frm1" >

                <div class="control-group">
                    <label for="login" class="control-label">Login:</label>
                    <div class="controls">
                        <input name="login" required="required" type="text" placeholder="login" />

                    </div>
                </div>

                <div class="control-group">
                    <label for="senha" class="control-label">Senha:</label>
                    <div class="controls">
                        <input name="senha" required="required" type="password" placeholder="******" />

                    </div>
                </div>
                <br>
                <!--<input type="button" class="btn btn-primary" onkeyup="javascript:teclaPressionadaLogin(event);">-->
                <a href="#" class="btn btn-primary" id="botao">Entrar</a>
                <div id="msg" style="color:red;"></div>


            </form>
        </div>       



        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>

    </body>
</html>
