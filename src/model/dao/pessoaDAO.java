/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao_BD;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.pessoa;

/**
 * CRUD
 * @author papiro
 */
public class pessoaDAO {
    
    private Connection con = null;
    private String campo;

    public pessoaDAO() {
        con = Conexao_BD.getConnection();
    }
    
    public boolean Cadastrar(pessoa p){
        String sql = "INSERT INTO pessoa (id,nome,data,cpf,MotoClub) VALUES (?,?,?,?,?)"; 
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,p.getId());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getData());
            stmt.setString(4, p.getCpf());
            stmt.setString(5,p.getMc());
            
            stmt.executeUpdate(); 
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
            return false;
        }finally{
            Conexao_BD.closeConnection(con, stmt);
        }                
    }
    
    public List<pessoa> Buscartodos(){
        String sql = "SELECT * FROM pessoa"; 
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<pessoa> pessoas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                pessoa p = new pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setData(rs.getString("data"));
                p.setCpf(rs.getString("cpf"));
                pessoas.add(p);
            }
        } catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }finally{
            Conexao_BD.closeConnection(con, stmt, rs);
        }
        
        return pessoas;
    }
    
    public boolean Alterar(pessoa p, String c){ 
        campo = c;
        boolean cont = false;
        PreparedStatement stmt = null; 
        
        if(campo.compareToIgnoreCase("Nome") == 0){
            String sql = "UPDATE pessoa SET nome = ? WHERE id = ?";

            
            try {
                stmt = con.prepareStatement(sql);
                stmt.setString(1,p.getNome());
                stmt.setInt(2, p.getId());
                stmt.executeUpdate(); 
                cont = true;
            } catch (SQLException ex) {
                System.err.println("ERRO: "+ex);
            }  
            
        }else if(campo.compareToIgnoreCase("Cpf") == 0){
            String sql = "UPDATE pessoa SET cpf = ? WHERE id = ?";

            
            try {
                stmt = con.prepareStatement(sql);
                stmt.setString(1,p.getCpf());
                stmt.setInt(2, p.getId());
                stmt.executeUpdate(); 
                cont = true;
            } catch (SQLException ex) {
                System.err.println("ERRO: "+ex);
            }  
            
        }else if(campo.compareToIgnoreCase("Data") == 0){
            String sql = "UPDATE pessoa SET data = ? WHERE id = ?";

            
            try {
                stmt = con.prepareStatement(sql);
                stmt.setString(1,p.getData());
                stmt.setInt(2, p.getId());
                stmt.executeUpdate(); 
                cont = true;
            } catch (SQLException ex) {
                System.err.println("ERRO: "+ex);
            }  
            
        }else if(campo.compareToIgnoreCase("MotoClub") == 0){
            String sql = "UPDATE pessoa SET MotoClub = ? WHERE id = ?";

            
            try {
                stmt = con.prepareStatement(sql);
                stmt.setString(1,p.getMc());
                stmt.setInt(2, p.getId());
                stmt.executeUpdate(); 
                cont = true;
            } catch (SQLException ex) {
                System.err.println("ERRO: "+ex);
            } 
            
        }
            return cont;
        }    
    
    public boolean Excluir(pessoa p){
        
        String sql = "DELETE FROM pessoa WHERE cpf = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,p.getCpf());
            stmt.executeUpdate(); 
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
            return false;
        }finally{
            Conexao_BD.closeConnection(con, stmt);
        }   
    }
    
    public List<pessoa> Validar(){
        String sql = "SELECT * FROM pessoa";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<pessoa> pessoas = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                pessoa p = new pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setData(rs.getString("data"));
                p.setCpf(rs.getString("cpf"));
                p.setMc(rs.getString("MotoClub"));
                pessoas.add(p);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }
        return pessoas;
    }
}
