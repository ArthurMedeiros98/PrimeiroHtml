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
import model.bean.moto;
import model.bean.motoClub;

/**
 *
 * @author papiro
 */
public class motoDAO {
    private Connection con = null;
    
    public motoDAO(){
        con = Conexao_BD.getConnection();
    }
    
    public List<moto> BuscarTodos(){
        String sql = "SELECT * FROM moto";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<moto> motos = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                moto mc = new moto();
                mc.setId(rs.getInt("id"));
                mc.setNome(rs.getString("nome"));
                mc.setCategoria(rs.getString("categoria"));
                mc.setMarca(rs.getString("marca"));
                mc.setValor(rs.getDouble("valor"));
                motos.add(mc);
            }
        
        }catch(SQLException ex){
            System.err.println("ERRO: "+ex);
        }finally{
            Conexao_BD.closeConnection(con, stmt, rs);
        }
        return motos;
    }
}
