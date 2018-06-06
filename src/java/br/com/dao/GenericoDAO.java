package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import br.com.persistencia.ConnectionFactory;

/**
 *
 * @author francisco.newton
 */
public abstract class GenericoDAO 
{
    private final Connection connection = new ConnectionFactory().conectar();
    
    protected Statement stmt;
    protected ResultSet rs;
    protected PreparedStatement pstmt;
    
    public Connection getConnection()
    {
        return connection;
    }
    
    
    
}
