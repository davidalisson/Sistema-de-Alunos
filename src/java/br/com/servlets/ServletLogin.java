/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlets;

import br.com.dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dom
 */
public class ServletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    
                try{
                    String opcao = request.getParameter("opcao");
                    if (opcao == null ) opcao = ""; // Para evitar erros
                    HttpSession session = request.getSession();
                    //session.setMaxInactiveInterval(2000);
        
                    LoginDAO loginDAO = new LoginDAO();
                    String login = request.getParameter("login");
                    String senha = request.getParameter("senha");
                    String logout = request.getParameter("logout");
                    boolean resposta = loginDAO.verificarSenha(login, senha);
                    
                    if (resposta == true){                    
                        enviarTexto(response, "OK");                        
                        session.setAttribute("usuario",loginDAO.getUsuario());
                    } else {
                        enviarTexto(response, "Erro");
                    }
                    
                    if (session.getAttribute("usuario") == null) {
                        response.sendRedirect("login.jsp");
                        return;
                    }
                    if (logout.equals("yes")) {
                        session.invalidate();
                        response.sendRedirect("login.jsp");
                        return;
                    }
                    
                }catch (Exception e) {
                    PrintWriter out = response.getWriter();
                    out.println(e);
                    out.close();
                }            
    }
    
    
    private void encaminhar(HttpServletRequest request,  HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
    
    private void enviarTexto( HttpServletResponse response, String texto) throws IOException {
         PrintWriter out = response.getWriter();
         out.print(texto);
         out.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
