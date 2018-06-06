var ajaxRequest;

function criaXMLHttpRequest(xmlhttp) {
var xmlhttp;
try { 
    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");  // I.E mais moderno
} catch (e) { 
    try { 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");   // I.E antigo
    } catch (E) { 
        xmlhttp = false; 
    } 
} 
if  (!xmlhttp && typeof  XMLHttpRequest != 'undefined' ) { 
    try  { 
        xmlhttp = new  XMLHttpRequest();   // Outros Navegadores
    } catch  (e) { 
        //Alert(“Seu navegador não suporta AJAX!”);
        xmlhttp = false;
    } 
}
 ajaxRequest = xmlhttp;
}

function teclaPressionadaLogin(e) {

		var keynum
		if (window.event) // IE
		{
			keynum = e.keyCode
		} else if (e.which) // Netscape/Firefox/Opera
		{
			keynum = e.which
		}
		if (keynum == 13) {
			var login = document.frm1.login.value;
			var senha = document.frm1.senha.value;
			var div = document.getElementById("msg");
			if ( ! login.length) {
				div.innerHTML = "O login deve ser preenchido!";
				return true;
			}
			if (!senha.length) {
				div.innerHTML =  "A senha deve ser preenchida!";
				return true;
			}
			
			getLoginAjax(login,senha); 
			
		}
	}

function getLoginAjax(login, senha) {
	criaXMLHttpRequest();
	if (ajaxRequest) {   //  se o navagador suporta ajax
	      ajaxRequest.onreadystatechange = ajaxLoginResposta;  
	      ajaxRequest.open("POST", "login");	      
              ajaxRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
              var parametros = "opcao=login&login="+login+"&senha="+senha;
	      ajaxRequest.send(parametros);
     }
}

function ajaxLoginResposta() {
	if (ajaxRequest.readyState != 4)  //  Checa se a requisição foi completada
      {  return;  }
   else {

     if (ajaxRequest.status == 200) //  Checa se o código HTTP é de sucesso
          {  
            var resposta = ajaxRequest.responseText;
            var div = document.getElementById("msg");
            if (resposta === "OK") {
                div.innerHTML = "Usuario Autenticado! <br> Voce esta sendo redirecionado";  
                window.location.href="index.jsp";                
            }
            if (resposta === "Erro") {
        	div.innerHTML = "Usuario e/ou Senha incorretos!";               
            }
 	 }
     else {
       alert("Falhou: " + ajaxRequest.status + " " + ajaxRequest.statusText);
          }
     }
}

