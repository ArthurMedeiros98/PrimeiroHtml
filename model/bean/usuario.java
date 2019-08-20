/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;
import model.dao.usuarioDAO;

public class usuario {
    private int iduser;
    private int idpessoa;
    private int idmc;
    private String nome;
    private String senha;
    
    public usuario(){}

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public int getIdmc() {
        return idmc;
    }

    public void setIdmc(int idmc) {
        this.idmc = idmc;
    }

    public usuario(String nome, String senha, pessoa pessoa){
        this.nome = nome;
        this.senha = senha;
    }                                              

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
