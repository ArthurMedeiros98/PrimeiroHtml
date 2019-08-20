/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.awt.Image;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author papiro
 */
public class moto {
    public int id;
    public String nome;
    public String categoria;
    public String marca;
    public double valor;
    public ImageIcon imagem;
    
   /* public byte[] imagem;

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public ImageIcon getImagem(int aux){
        if(aux == 0){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-CG-160.jpg");
        }else if(aux == 1){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-CB-TWISTER.jpg");       
        }else if(aux == 2){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-CG-125.jpg");
        }else if(aux == 3){
            ImageIcon imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-YBR-150.jpg");
        }else if(aux == 4){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-FAZER-250.jpg");
        }else if(aux == 5){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-883.jpg");
        }else if(aux == 6){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-XL1200.jpg");
        }else if(aux == 7){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/SUZUKI/moto-KAWASAKI-VULCAN.jpg");
        }else if(aux == 8){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/OUTROS/moto-ROYAL-CLASSIC.jpg");
        }else if(aux == 9){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-FATBOB.jpg");
        }else if(aux == 10){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/BMW/moto-BMw-R1200.jpg");
        }else if(aux == 11){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/OUTROS/moto-TRIUMPH-800.jpg");
        }else if(aux == 12){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/BMW/moto-BMW-800GS.jpg");
        }else if(aux == 13){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-AFRICA.jpg");
        }else if(aux == 14){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/SUZUKI/moto-SUZUKI-VSTROM.jpg");
        }else if(aux == 15){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-YAMAHA-MT03.jpg");
        }else if(aux == 16){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-CB500R.jpg");
        }else if(aux == 17){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-CB650F.jpg");
        }else if(aux == 18){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/SUZUKI/moto-SUZUKI-GSXSS750.jpg");
        }else if(aux == 19){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-YAMAHA-MT07.jpg");
        }else if(aux == 20){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-YAMAHA-YZFR3.jpg");
        }else if(aux == 21){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/BMW/moto-BMW-S1000.jpg");
        }else if(aux == 22){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-CBR500R.jpg");
        }else if(aux == 23){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/SUZUKI/moto-SUZUKI-GSXS1000F.jpg");
        }else if(aux == 24){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-CBR650F.jpg");
        }else if(aux == 25){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-ROADGLIDE.jpg");
        }else if(aux == 26){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-ULTRALIMITED.jpg");
        }else if(aux == 27){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-HERITAGE.jpg");
        }else if(aux == 28){
            imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-ROADKING.jpg");
        }else if(aux == 29){
           imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-STREETGLIDE.jpg");
        }
        return imagem;
    }
    
    public ImageIcon getImagemPesquisa (int  aux, String pesquisa){
        if(pesquisa.compareToIgnoreCase("City") == 0){
            if(aux == 4){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-CG-160.jpg");
            }else if(aux == 3){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-CB-TWISTER.jpg");       
            }else if(aux == 2){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-CG-125.jpg");
            }else if(aux == 1){
                ImageIcon imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-YBR-150.jpg");
            }else if(aux == 0){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-FAZER-250.jpg");
            }
        }else if(pesquisa.compareToIgnoreCase("Custom") == 0){
            if(aux == 4){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-883.jpg");
            }else if(aux == 3){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-XL1200.jpg");
            }else if(aux == 2){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/SUZUKI/moto-KAWASAKI-VULCAN.jpg");
            }else if(aux == 1){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/OUTROS/moto-ROYAL-CLASSIC.jpg");
            }else if(aux == 0){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-FATBOB.jpg");
            }
        }else if(pesquisa.compareToIgnoreCase("Maxtrail") == 0){
            if(aux == 0){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/BMW/moto-BMw-R1200.jpg");
            }else if(aux == 1){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/OUTROS/moto-TRIUMPH-800.jpg");
            }else if(aux == 2){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/BMW/moto-BMW-800GS.jpg");
            }else if(aux == 3){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-AFRICA.jpg");
            }else if(aux == 4){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/SUZUKI/moto-SUZUKI-VSTROM.jpg");
            }
        }else if (pesquisa.compareToIgnoreCase("Sport") == 0){
            if(aux == 4){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-YAMAHA-YZFR3.jpg");
            }else if(aux == 3){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/BMW/moto-BMW-S1000.jpg");
            }else if(aux == 2){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-CBR500R.jpg");
            }else if(aux == 1){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/SUZUKI/moto-SUZUKI-GSXS1000F.jpg");
            }else if(aux == 0){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-CBR650F.jpg");
            }
        }else if (pesquisa.compareToIgnoreCase("Naked") == 0){
            if(aux == 4){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-YAMAHA-MT03.jpg");
            }else if(aux == 3){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-CB500R.jpg");
            }else if(aux == 2){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HONDA/moto-HONDA-CB650F.jpg");
            }else if(aux == 1){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/SUZUKI/moto-SUZUKI-GSXSS750.jpg");
            }else if(aux == 0){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/YAMAHA/moto-YAMAHA-MT07.jpg");
            }
        }else if (pesquisa.compareToIgnoreCase("Touring") == 0){
             if(aux == 4){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-ROADGLIDE.jpg");
            }else if(aux == 3){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-ULTRALIMITED.jpg");
            }else if(aux == 2){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-HERITAGE.jpg");
            }else if(aux == 1){
                imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-ROADKING.jpg");
            }else if(aux == 0){
               imagem = new ImageIcon("/home/papiro/NetBeansProjects/MotoClub/src/imagens/HARLEY/moto-HARLEY-STREETGLIDE.jpg");
            }
        }
        return imagem;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
