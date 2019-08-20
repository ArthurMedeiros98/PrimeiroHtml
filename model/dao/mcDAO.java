/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.moto;
import model.bean.motoClub;

/**
 *
 * @author papiro
 */
public class mcDAO {
    private Connection con = null;
    private String campo;
    
    public mcDAO(){
        con = Conexao_BD.getConnection();
    }
    
    public boolean Cadastrar(motoClub mc){
        String sql = "INSERT INTO motoClub (id,nome,regiao,estado,quantidade,integrantes) VALUES(?,?,?,?,?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mc.getId());
            stmt.setString(2, mc.getNome());
            stmt.setString(3, mc.getRegiao());
            stmt.setString(4, mc.getEstado());
            stmt.setInt(5, mc.getQtd());
            stmt.setInt(6, mc.getIntegrantes());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.print("ERRO: "+ex);
            return false;
        }finally{
            Conexao_BD.closeConnection(con, stmt);
        }
    }
    
    public List<motoClub> BuscarTodos(){
        String sql = "SELECT * FROM motoClub";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<motoClub> motoClubs = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                motoClub mc = new motoClub();
                mc.setId(rs.getInt("id"));
                mc.setNome(rs.getString("nome"));
                mc.setRegiao(rs.getString("regiao"));
                mc.setEstado(rs.getString("estado"));
                mc.setQtd(rs.getInt("quantidade"));
                mc.setIntegrantes(rs.getInt("integrantes"));
                motoClubs.add(mc);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }finally{
            Conexao_BD.closeConnection(con, stmt, rs);
        }
        return motoClubs;
    }
    
    public List<motoClub> Validar(){
        String sql = "SELECT * FROM motoClub";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<motoClub> motoClubs = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                motoClub mc = new motoClub();
                mc.setId(rs.getInt("id"));
                mc.setNome(rs.getString("nome"));
                mc.setRegiao(rs.getString("regiao"));
                mc.setEstado(rs.getString("estado"));
                mc.setQtd(rs.getInt("quantidade"));
                mc.setIntegrantes(rs.getInt("integrantes"));
                motoClubs.add(mc);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }
        return motoClubs;
    }
    
    public List<moto> buscaMotos(){
        String sql = "SELECT * FROM moto";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<moto> motos = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                moto m = new moto();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setCategoria(rs.getString("categoria"));
                m.setMarca(rs.getString("marca"));
                m.setValor(rs.getDouble("valor"));
                motos.add(m);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }
        return motos;
    }

    public boolean CadastrarIntegrante(motoClub mc){
        PreparedStatement  stmt = null;
        String sql = "UPDATE motoClub SET integrantes = ? WHERE id = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,mc.getIntegrantes());
            stmt.setInt(2, mc.getId());
            
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.err.print("ERRO: "+ex);
            return false;
        }   
        
    }
    
    public boolean Alterar(motoClub mc,String c){
        campo = c;
        PreparedStatement stmt = null;
        boolean cont = false;
        if(campo.compareToIgnoreCase("Nome") == 0){
            String sql = "UPDATE motoClub SET nome = ? WHERE id = ?";
        
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1, mc.getNome());
                stmt.setInt(2, mc.getId());
                stmt.executeUpdate();
                cont = true;

            }catch(SQLException ex){
                System.err.println("ERRO: "+ex);

            }
            
        }else if(campo.compareToIgnoreCase("Região") == 0){
            String sql = "UPDATE motoClub SET regiao = ? WHERE id = ?";
        
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1, mc.getRegiao());
                stmt.setInt(2, mc.getId());
                stmt.executeUpdate();
                cont = true;

            }catch(SQLException ex){
                System.err.println("ERRO: "+ex);

            }
            
        }else if(campo.compareToIgnoreCase("Estado") == 0){
            String sql = "UPDATE motoClub SET estado = ? WHERE id = ?";
        
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1, mc.getEstado());
                stmt.setInt(2, mc.getId());
                stmt.executeUpdate();
                cont = true;

            }catch(SQLException ex){
                System.err.println("ERRO: "+ex);

            }
        }else if(campo.compareToIgnoreCase("Quantidade") == 0){
            String sql = "UPDATE motoClub SET quantidade = ? WHERE id = ?";
        
            try{
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, mc.getQtd());
                stmt.setInt(2, mc.getId());
                stmt.executeUpdate();
                cont = true;

            }catch(SQLException ex){
                System.err.println("ERRO: "+ex);

            }
            
        }
//        Conexao_BD.closeConnection(con, stmt);
        return cont;
    }
    
    public boolean Excluir(motoClub mc){
        String sql = "DELETE FROM motoClub WHERE id = ?";
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,mc.getId());
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
            return false;
            
        }finally{
            Conexao_BD.closeConnection(con, stmt);
        }
        
    }
}
