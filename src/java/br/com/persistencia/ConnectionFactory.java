package br.com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author francisco.newton
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Murilo Alves
 */
public class ConnectionFactory {
    Connection con;




public Connection conectar(){
    try{
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sisaluno?user=root&password=6mp5YrN8i9");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível encontrar o banco");
        }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível conectar ao banco");
        }
    return con;
    }

    public void desconectar(){
         try{
             con.close();
         } catch (SQLException ex){
             ex.printStackTrace();
         }
    }
}
