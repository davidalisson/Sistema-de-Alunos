/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.entidades.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Dom
 */
public class LoginDAO extends GenericoDAO {
     
   // private String nome;
    private Usuario usuario = new Usuario();
   
    
    
    public boolean verificarSenha(String login, String senha)
    {
        String sql = "SELECT LOGIN,SENHA,NOME FROM USUARIOS WHERE LOGIN=? AND SENHA=?";
        try 
        {
            boolean autenticado = false;
            
            this.pstmt = this.getConnection().prepareStatement(sql);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setNome(rs.getString("NOME"));
                autenticado = true;
            }
            pstmt.close();
            
            return autenticado;
        }
        catch (SQLException e) 
        {
                throw new RuntimeException(e);
        }
    }
     public Usuario getUsuario()
     {
         return usuario;
     }
}
