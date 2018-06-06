/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlets;

import br.com.dao.AlunoDAO;
import br.com.entidades.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dom
 */
public class ServletAlterar extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/Estacio/error.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
         AlunoDAO alunodao = new AlunoDAO();
        try {
            
            Aluno aluno = new Aluno();
            int mat = Integer.parseInt(request.getParameter("inputMatricula"));
            String nome = request.getParameter("inputNome");
            String curso = request.getParameter("inputCurso");
            
            aluno.setMatricula(mat);
            aluno.setNome(nome);
            aluno.setCurso(curso);
            alunodao.alterar(aluno);
            
            
            
            
            response.sendRedirect("/Estacio/mensagemAlterado.html");
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
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
