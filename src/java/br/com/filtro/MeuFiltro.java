package br.com.filtro;

import br.com.entidades.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MeuFiltro implements Filter {
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, 
            FilterChain chain) throws IOException, ServletException {
            
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            HttpSession session = request.getSession();
            Usuario usuario = (Usuario)session.getAttribute("usuario");
            String url = request.getServletPath();
            System.out.println("Usuario \"" + usuario + "\" acessando a url: " + url);             
            if(!(url.startsWith("/login") || (url.startsWith("/Login")) || (url.startsWith("/css/bootstrap.min.css")) || (url.startsWith("/css/style.css"))) || (url.startsWith("/js/ajax.js")) || (url.startsWith("/js/jquery.js")) || (url.startsWith("/js/bootstrap.min.js"))) {
                 session = request.getSession(false);
                    if ((session != null) && (usuario != null)) {
                       
                        chain.doFilter(req, res);
                    } else {
                        response.sendRedirect(request.getContextPath() + "/login.jsp");
                    }                    
            } else {
                chain.doFilter(req, res);
            }

    }
       
        
    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }
    
        
}
