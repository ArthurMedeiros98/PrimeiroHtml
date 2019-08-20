/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author papiro
 */
public class pessoa {
    
    private int id;
    private String nome;
    private String data;
    private String cpf;
    private String mc;

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }
    
    public pessoa(String nome){
        this.nome = nome;
    }

    public pessoa(String nome,String data,String cpf){
        this.nome = nome;
        this.data = data;
        this.cpf = cpf;
    }

    public pessoa() {
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }        

    
}
