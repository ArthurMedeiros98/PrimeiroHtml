/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;
import java.sql.PreparedStatement;
import java.sql.Connection; //IMPORT JAVA.SQL.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author papiro
 */
public class Conexao_BD {
    
    //CARRREGANDO OS ARQUIVOS PARA CONEXAO COM O SISTEMA MYSQL
    private static final String DRIVER = "com.mysql.jdbc.Driver"; //DRIVER JAVA PARA MYSQL
    private static final String URL = "jdbc:mysql://localhost:3306/conexao"; //LOCALIZAO DO LOCALHOST MYSQL
    private static final String USER = "root";
    private static final String PASS = "shuairan44";
    
    public static Connection getConnection(){
        try {
            
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("ERRO NA CONEXÃO",ex);
        }
    }
    
    public static void closeConnection (Connection con){
        if(con != null){            
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("ERRO: "+ex);
            }            
        }
    }
    
    public static void closeConnection (Connection con, PreparedStatement stmt){
        if(stmt != null){            
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("ERRO: "+ex);            
            }            
        }
        closeConnection(con);
    }
    
    public static void closeConnection (Connection con, PreparedStatement stmt, ResultSet rs){
        if(rs != null){            
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("ERRO: "+ex);            
            }            
        }
        closeConnection(con,stmt);
    }   
    
}
