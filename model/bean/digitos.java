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
public class digitos extends PlainDocument{
     private int qtdMax;
        public digitos(int maxLen){
            super();
            if(maxLen<=0)
                throw new IllegalArgumentException("ESPECIFIQUE A QUANTIDADE.");
            qtdMax = maxLen;   
        }
        
        @Override
        public void insertString(int offset, String str, AttributeSet attr)
        throws BadLocationException{
            if(str == null || getLength() == qtdMax)
                return;
            int totQtd = (getLength()+str.length());
            if(totQtd<=qtdMax){
                super.insertString(offset, str.replaceAll("[^0-9]",""), attr);
                return;
            }
            String nova = str.substring(0,getLength()-qtdMax);
            super.insertString(offset, nova, attr);
        }

}
