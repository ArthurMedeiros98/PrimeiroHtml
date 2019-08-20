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
import model.bean.motoClub;
import model.bean.pessoa;
import model.bean.usuario;

/**
 *
 * @author papiro
 */
public class usuarioDAO {
    
    private Connection con = null;
    private String campo;
    
    public usuarioDAO(){
        con = Conexao_BD.getConnection();
    }
    
    public boolean cadastrar(usuario u){
        String sql = "INSERT INTO usuario (iduser,idpessoa,idMc,nome,senha) VALUES(?,?,?,?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, u.getIduser());
            stmt.setInt(2, u.getIdpessoa());
            stmt.setInt(3, u.getIdmc());
            stmt.setString(4, u.getNome());
            stmt.setString(5, u.getSenha());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.print("ERRO: "+ex);
            return false;
        }finally{
            Conexao_BD.closeConnection(con, stmt);
        }
    }
    
    public List<usuario> BuscarTodos(){
        String sql = "SELECT * FROM usuario";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<usuario> usuarios = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                usuario u = new usuario();
                u.setIduser(rs.getInt("iduser"));
                u.setIdpessoa(rs.getInt("idpessoa"));
                u.setIdmc(rs.getInt("idMc"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }finally{
            Conexao_BD.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
    
    public List<usuario> Validar(){
        String sql = "SELECT * FROM usuario";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<usuario> usuarios = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                usuario u = new usuario();
                u.setIduser(rs.getInt("iduser"));
                u.setIdpessoa(rs.getInt("idpessoa"));
                u.setIdmc(rs.getInt("idMc"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }
        return usuarios;
    }
    
    public ArrayList<motoClub> ValidarMC(usuario u){
        String sql = "SELECT motoClub.id, motoClub.nome, motoClub.regiao, motoClub.estado, motoClub.quantidade FROM usuario join motoClub on ? = motoClub.id ";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<motoClub> Mcs = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, u.getIdmc());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                motoClub mc = new motoClub();
                mc.setId(rs.getInt("id"));
                mc.setNome(rs.getString("nome"));
                mc.setRegiao(rs.getString("regiao"));
                mc.setEstado(rs.getString("estado"));
                mc.setQtd(rs.getInt("quantidade"));
                Mcs.add(mc);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }
        return Mcs;
    }
    
    public ArrayList<pessoa> ValidarP(){
        String sql = "SELECT pessoa.id, pessoa.nome, pessoa.data, pessoa.cpf, pessoa.MotoClub FROM usuario join pessoa on usuario.idpessoa = pessoa.id ";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<pessoa> pessoas = new ArrayList<>();
        
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
    
    public ArrayList<pessoa> ValidarMcP(motoClub mc){
        String sql = "SELECT pessoa.nome from pessoa join usuario on usuario.idMc = ? and pessoa.id = usuario.idpessoa";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<pessoa> pessoas = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mc.getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                pessoa p = new pessoa();
                p.setNome(rs.getString("nome"));
                pessoas.add(p);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }
        return pessoas;
    }
    
    public boolean Alterar(usuario u,String c){
        campo = c;
        PreparedStatement stmt = null;
        boolean cont = false;
        
        if(campo.compareToIgnoreCase("Senha") == 0){
            String sql = "UPDATE usuario SET senha = ? WHERE iduser = ?";
    
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1, u.getSenha());
                stmt.setInt(2, u.getIduser());
                stmt.executeUpdate();
                cont = true;

            }catch(SQLException ex){
                System.err.println("ERRO: "+ex);

            }

        }else if(campo.compareToIgnoreCase("Nome") == 0){
            
            String sql = "UPDATE usuario SET nome = ? WHERE iduser = ?";
    
            try{
                stmt = con.prepareStatement(sql);
                stmt.setString(1, u.getNome());
                stmt.setInt(2, u.getIduser());
                stmt.executeUpdate();
                cont = true;

            }catch(SQLException ex){
                System.err.println("ERRO: "+ex);

            }
        }else if(campo.compareToIgnoreCase("MotoClub") == 0){
            
            String sql = "UPDATE usuario SET idMc = ? WHERE iduser = ?";
    
            try{
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, u.getIdmc());
                stmt.setInt(2, u.getIduser());
                stmt.executeUpdate();
                cont = true;

            }catch(SQLException ex){
                System.err.println("ERRO: "+ex);

            }
        }
        
        return cont;
    }
    
    public boolean Excluir(usuario u){
        String sql = "DELETE FROM usuario WHERE nome = ? AND senha = ?";
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,u.getNome());
            stmt.setString(2,u.getSenha());
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


/*public boolean BuscarUser(){
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        usuario u = null;
        boolean cont = false;
        ArrayList<usuario> users = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                u = new usuario();
                u.setIduser(rs.getInt("iduser"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                users.add(u);
            }
        
            for(usuario u1:users){
                if(u1.getNome().equals(u.getNome()) && u1.getSenha().equals(u.getSenha())){
                    System.out.println("ENCONTROU!");
                    stmt.setString(1, u1.getNome());
                    stmt.setString(2, u1.getSenha());
                    cont = true;
                    break;                
                }
            }
            return cont;
        } catch (SQLException ex) {
            System.err.print("ERRO NÃO ENCONTROU: "+ex);
            return false;
        }finally{
            Conexao_BD.closeConnection(con, stmt, rs);
        }



 public motoClub Validarmc(usuario u){
        String sql = "SELECT motoClub.id, motoClub.nome, motoClub.regiao, motoClub.estado, motoClub.quantidade FROM motoClub join usuario on ? = motoClub.id ";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        motoClub mc = new motoClub();
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, u.getIdmc());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                mc.setId(rs.getInt("id"));
                mc.setNome(rs.getString("nome"));
                mc.setRegiao(rs.getString("regiao"));
                mc.setEstado(rs.getString("estado"));
                mc.setQtd(rs.getInt("quantidade"));
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }
        return mc;
    }
    }*/