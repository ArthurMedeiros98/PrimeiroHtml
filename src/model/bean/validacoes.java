/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author papiro
 */
public class validacoes {
    public static String dataBrasil(String data){
        
        String dd = data.substring(0,2);
        String mm = data.substring(2,4);
        String yyyy = data.substring(4,8);
        String dataBR = dd+"/"+mm+"/"+yyyy;
        return dataBR;
    }
   
    public static String DataBDBR(String data){
        String yyyy = data.substring(0, 4);
        String mm = data.substring(5, 7);
        String dd = data.substring(8, 10);
        String dataBDBR = dd+"/"+mm+"/"+yyyy;
        return dataBDBR;
    }
    
    public static String dataBD(String data){
        
        String dd = data.substring(0,2);
        String mm = data.substring(3,5);
        String yyyy = data.substring(6,10);
        String dataBD = yyyy+"-"+mm+"-"+dd;
        return dataBD;
    }
    
    public static String CpfConvertido(String cpf){
        
        String x1 = cpf.substring(0,3);
        String x2 = cpf.substring(3,6);
        String x3 = cpf.substring(6,9);
        String x4 = cpf.substring(9,11);
        String cpfFormatado = x1+"."+x2+"."+x3+"-"+x4;
        return cpfFormatado;
    }         
}


