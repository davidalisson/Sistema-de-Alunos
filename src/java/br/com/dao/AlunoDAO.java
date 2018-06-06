package br.com.dao;

import br.com.entidades.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends GenericoDAO{

 
    
     public void incluir(Aluno aluno)
    {
        String sql = "INSERT INTO alunos (nome,curso) VALUES (?,?);" ;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getCurso());
            
            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }
    
    public List<Aluno> getLista() 
    {
        String sql = "SELECT * FROM alunos";
        List<Aluno> listaAlunos = new ArrayList();
        Aluno aluno;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                aluno = new Aluno();
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setNota1(rs.getDouble("nota1"));
                aluno.setNota2(rs.getDouble("nota2"));
                aluno.setMedia(rs.getDouble("media"));
                listaAlunos.add(aluno);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return listaAlunos;
    }
    
    public boolean alterar(Aluno aluno)
    {
        String sql = "UPDATE alunos SET nome=?, curso=? WHERE matricula=?";
        boolean resultado;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getCurso());
            
            pstmt.setInt(3, aluno.getMatricula());
            resultado = (pstmt.executeUpdate() > 0);
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return resultado;
    }
      
    public boolean excluir(int matricula)
    {
        String sql = "DELETE FROM alunos WHERE matricula=?";
        boolean resultado;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, matricula);
            resultado = (pstmt.executeUpdate() > 0);
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    public boolean alterarNotas(Aluno aluno)
    {
        String sql = "UPDATE alunos SET nota1=?, nota2=?, media=? WHERE matricula=?";
        boolean resultado;

        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setDouble(1, aluno.getNota1());
            pstmt.setDouble(2, aluno.getNota2());
            pstmt.setDouble(3, aluno.getMedia());
            
            pstmt.setInt(4, aluno.getMatricula());
            resultado = (pstmt.executeUpdate() > 0);
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    public boolean excluirNotas(int matricula)
    {
        String sql = "UPDATE alunos set nota1=null, nota2=null, media=null WHERE matricula=?";
        boolean resultado;
        try
        {
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, matricula);
            resultado = (pstmt.executeUpdate() > 0);
            pstmt.close();
        }
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        return resultado;
    }
     
}
