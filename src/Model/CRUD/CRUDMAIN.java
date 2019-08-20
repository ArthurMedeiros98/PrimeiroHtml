/* 
/////////////////////////////////////////////////////////////////////////////////////
LEVE ISSO COMO PRIORIDADE:
    REALIZAR FOREIGN KEY PARA CRIAR CARDINALIDADE ENTRE AS TABELAS DO USUARIO E 
    PESSOA, ACREDITO QUE SEJA PESSOA(1) PARA USUARIO(N). OU SEJA, UMA PESSOA PODE
    POSSUIR VÁRIOS USUÁRIOS CADASTRADOS EM SEU NOME E COM OS SEUS DADOS.
   
PRIMEIRO:
    AO REALIZAR LOGIN ACESSE TUDO QUE ESTIVER CADASTRADO NAQUELE LOGIN, ACREDITO QUE
    O RELACIONAMENTO SEJA DE 1 USUÁRIO PARA 1 PESSOA E MOTOCLUB. QUANTO AO FOREIGN KEY ACHO
    QUE SEJA TANTO O NOME DO USUÁRIO QUANTO O ID DO USUÁRIO. SE FOR O PRIMEIRO CASO,
    AO  CADASTRAR O USUÁRIO DEVE VERIFICAR SE EXISTE UM USUÁRIO JA CADASTRADO COM 
    AQUELE NOME.

SEGUNDO:
    INTERFACE:
            CONCLUÍDOS: 
                BANCO DE DADOS (ok)

                TELA LOGIN (ok)

                TELA CADASTRO DE PESSOA E DE MOTOCLUBs (ok)           

                TELA MENU INICIAL(ok)

                TELA DE LISTAGEM DE MOTOS E MOTOCLUBS (ok)

                TELA DE PESQUISA (ok)


            DESENVOLVIMENTO:
                
                TELA DE LISTAGEM DE MOTOS(PRIORIDADE 3):
                    ESTOU TENTANDO BUSCAR IMAGEM PELO BD                

                POPMENU PARA EXCLUIR MC(PRIORIDADE 1):  
                        AO ALTERAR O MOTOCLUB NA PAGINA DE ALTERAR O NOVO MC
                        NÃO É REPASSADO PARA A INTERFACE PRINCIPAL

                        PRECISO REALIZAR AS ALTERAÇÕES NA TABELA PESSOA E LA NA
                        TABELA MC PARA AUMENTAR UM INTEGRANTE NO NUMERO DE NÃO POSSUI

                POPMENU PARA EXCLUIR PESSOA(PRIORIDADE 2):
                        AO EXCLUIR UMA PESSOA OU USUARIO DEVE-SE ALTERAR A QUANTIDADE
                        DE INTEGRANTES DO MC DO USUARIO EXCLUIDO

/////////////////////////////////////////////////////////////////////////////////////
 
 */
package Model.CRUD;

import model.bean.pessoa;
import model.bean.usuario;
import model.dao.pessoaDAO;
import model.dao.usuarioDAO;
import java.util.Scanner;

/**
 *
 * @author papiro
 */
public class CRUDMAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        pessoa p1 = new pessoa();
        pessoaDAO p2 = new pessoaDAO();
        usuario u1 = new usuario();
        usuarioDAO u2 = new usuarioDAO();
        
        MenuInicial(p1,p2,u1,u2);
        
        }
        
                                                       

    public static void MenuInicial(pessoa p1, pessoaDAO p2, usuario u1, usuarioDAO u2){
        Scanner tec = new Scanner(System.in);
        Scanner tec2 = new Scanner(System.in);
        boolean cont = false;
    
        System.out.print("\n\t(1)LOGIN\n\t(2)CADASTRAR USUÁRIO\n\t(0)SAIR\nESCOLHA UMA OPÇÃO:");
        int op = tec.nextInt();
        
        switch(op){
            case(1):
                System.out.print("Usuário: ");
                String user = (tec2.nextLine());
                System.out.print("Senha: ");
                String pass = (tec2.nextLine());                
                
                for(usuario u:u2.Validar()){
                    if(u.getNome().equals(user)){
                        if(u.getSenha().equals(pass)){
                            cont = true;
                            u1 = u;
                            System.out.println("USUARIO: "+u1.getNome()+"SENHA: "+u1.getSenha());            
                            break;                
                        }
                    }
                }
                
                if(cont){
                    System.out.print("\n\t(1)ATUALIZAR INFORMAÇÕES PESSOAIS\n\t(2)ATUALIZAR INFORMAÇÕES DO USUÁRIO\n\t(0)SAIR\nESCOLHA UMA OPÇÃO:");
                    int op1 = tec.nextInt();
                    switch(op1){
                        case(1):
                            MenuCRUD(p1, p2, tec);    
                            break;
                        case(2):
                            MenuUser(u1,u2,tec);
                            break;
                        case(0):
                            System.out.println("SAINDO...");
                            break;
                    }
                    break;
                }else{
                    System.out.println("USUÁRIO OU SENHA INVÁLIDOS!");
                    MenuInicial(p1, p2, u1, u2);
                    break;
                }
            case(2):
                CadastrarP(p1, p2);
                CadastrarUsuario(u1,u2);
                break;
            case(0):
                System.out.println("SAINDO...");
                break;
        }
    }
    
    public static void MenuCRUD(pessoa p1, pessoaDAO p2, Scanner tec){
        System.out.print("\n\t(1)ALTERAR\n\t(2)EXCLUIR\n\t(3)INFORMAÇÕES\n\t(0)SAIR\nESCOLHA UMA OPÇÃO:");
        int op = tec.nextInt();
        
        switch(op){
                case(0):
                    System.out.println("SAINDO...");
                    break;
                case(1):
                    AlterarP(p1,p2);
                    break;
                case(2):
                    ExcluirP(p1,p2);
                    break;
                case(3):
                    BuscarPCPF(p1,p2);
                    break;
            }
    }
    
    public static void MenuUser(usuario u1, usuarioDAO u2, Scanner tec){
        System.out.print("\n\t(1)ALTERAR\n\t(2)EXCLUIR\n\t(3)INFORMAÇÕES\n\t(0)SAIR\nESCOLHA UMA OPÇÃO:");
        int op = tec.nextInt();
        
        switch(op){
                case(0):
                    System.out.println("SAINDO...");
                    break;
                case(1):
                    AlterarUsuario(u1,u2);
                    break;
                case(2):
                    ExcluirUsuario(u1,u2);
                    break;
                case(3):
                     BuscarTodosUser(u2);
                     break;                        
            }
    }
    
    public static void CadastrarP(pessoa p1, pessoaDAO p2){
        
        Scanner tec = new Scanner(System.in);                        
        
        System.out.print("Informe seu nome: ");
        p1.setNome(tec.nextLine());        
        System.out.print("Informe sua data de nascimento (dd/mm/yyyy): ");           
        String data = tec.nextLine();
        
        if(data.length()<=8){
            data = dataBrasil(data);
            p1.setData(dataBD(data));
            
        }
        else{
            p1.setData(dataBD(data));
        }
        
        System.out.print("Informe seu CPF: ");
        String cpf = (tec.nextLine());                        
        
        if(cpf.length()<=11){
            p1.setCpf(CpfConvertido(cpf));            
        }else if(cpf.length()==14)
            p1.setCpf(cpf);
        else
            System.out.println("CPF INVÁLIDO");
       
        if(p2.Cadastrar(p1))
            System.out.println("SALVO COM SUCESSO!");
        else
            System.out.println("ERRO AO SALVAR!");
        
    }
    
    public static void AlterarP(pessoa p1, pessoaDAO p2){
        
        Scanner tec = new Scanner(System.in);
        
        System.out.print("Informe o seu cpf: ");
        String con = tec.nextLine();
               
/*        if(con.length()<=11){
            p1.setCpf(CpfConvertido(con)); 
            System.out.print("Informe o novo nome: ");
            String newN = tec.nextLine();
            p1.setNome(newN);
           if(p2.Alterar(p1))
                System.out.println("Atualizado com sucesso!");
            else
                System.out.println("FALHOU!");
            
        }else if(con.length()==14){
            p1.setCpf(con);
            System.out.print("Informe o novo nome: ");
            String newN = tec.nextLine();
            p1.setNome(newN);
            
          //  if(p2.Alterar(p1))
                System.out.println("Atualizado com sucesso!");
            else
                System.out.println("FALHOU!");
        }
        else
            System.out.println("CPF INVÁLIDO!");*/
            
        } //COLOQUE UM LAÇO
 
    public static void ExcluirP(pessoa p1, pessoaDAO p2){
        Scanner tec = new Scanner(System.in);
        System.out.print("Informe seu CPF: ");
        String con = tec.nextLine();
        
        if(con.length()<=11){
            p1.setCpf(CpfConvertido(con)); 
            
            if(p2.Excluir(p1))
                System.out.println("Excluído");
            else
                System.out.println("FALHOU!");
            
        }else if(con.length()==14){
            p1.setCpf(con);
            
            if(p2.Excluir(p1))
                System.out.println("Excluído");
            else
                System.out.println("FALHOU!");
        }
        else
            System.out.println("CPF INVÁLIDO!");
        
    }        
    
    public static void BuscarTodosP(pessoaDAO p2){        
        int aux = 0;
        for(pessoa p:p2.Buscartodos()){
            System.out.println("Nome: "+p.getNome());            
            System.out.println("Data: "+DataBDBR(p.getData()));
            System.out.println("CPF: "+p.getCpf());
            System.out.println("-------------");
            aux = 1;
        }
        if(aux == 0)
            System.out.println("NENHUM CADASTRO ENCONTRADO!");
    }
    
    public static void CadastrarUsuario(usuario u1,usuarioDAO u2){
        boolean cont = true;
        Scanner tec = new Scanner(System.in);
        
        System.out.print("Informe o novo usuário: ");
        String n = tec.nextLine();
        for(usuario u:u2.Validar()){
            if(u.getNome().equals(n)){
                cont = false;
                break;
            }
        }
        
        if(cont == true){
            System.out.print("Nova senha: ");
            String pass1 = tec.nextLine();
            System.out.print("Confirmar senha: ");
            String pass2 = tec.nextLine();              
            u1.setNome(n);
            while(pass1.equals(pass2) != true || pass2.length() < 8){
                System.out.println("SENHA INVÁLIDA! NÃO COMPATÌVEL OU MÍNIMO DE CARACTERES 8");
                System.out.print("Nova senha: ");
                pass1 = tec.nextLine();
                System.out.print("Confirmar senha: ");
                pass2 = tec.nextLine();                
            }


            u1.setSenha(pass2);
        
        if(u2.cadastrar(u1))
            System.out.println("SALVO COM SUCESSO!");
        else
            System.out.println("ERRO AO SALVAR!");
        }else{
            System.out.println("ERRO AO SALVAR!JÁ EXISTE UM USUÁRIO COM ESSE NOME.");
            CadastrarUsuario(u1, u2);
        }
    }
    
    public static void AlterarUsuario(usuario u1, usuarioDAO u2){ //ALTERANDO SENHA
        Scanner tec = new Scanner(System.in);
        System.out.print("Informar a nova senha: ");
        String cod = tec.nextLine();

        while(cod.length() < 8){
            System.out.print("Informar a nova senha: ");
            cod = tec.nextLine();    
        }
        u1.setSenha(cod);
 /*       if(u2.AlterarSenha(u1)){
            System.out.println("ALTERADO COM SUCESSO!");
        }else{
            System.out.println("FALHOU!");
            AlterarUsuario(u1, u2);
        }*/
        
    }
    
    public static void ExcluirUsuario(usuario u1, usuarioDAO u2){
        boolean cont = false;
        Scanner tec = new Scanner(System.in);
        String user = u1.getNome();
        System.out.print("Senha: ");
        String pass = tec.nextLine();
        
        for(usuario u:u2.Validar()){
            if(u.getNome().equals(user)){
                if(u.getSenha().equals(pass)){
                    cont = true;
                    break;                
                }
            }
        }
        if(cont){
            if(u2.Excluir(u1)){
                System.out.println("Excluído com sucesso!");
            }else
                System.out.println("ERRO! Senha Inválida.");
        }else{
            System.out.println("SENHA INCORRETA!");
            ExcluirUsuario(u1, u2);
        }
    }
            
    public static void BuscarTodosUser(usuarioDAO u2){
        for(usuario u:u2.BuscarTodos()){
            System.out.println("Usuário: "+u.getNome());
            System.out.println("-------------");
        }
    }
    
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
    
    public static void BuscarPCPF(pessoa p1,pessoaDAO p2){ //FALTA
        Scanner tec = new Scanner(System.in);
        System.out.print("Informe seu CPF: ");
        String con = tec.nextLine();
        int aux = 0;
        
        if(con.length()<=11){
            p1.setCpf(CpfConvertido(con)); 
            con = p1.getCpf();
            for(pessoa p:p2.Buscartodos()){
                    if(p.getCpf().equals(con)){
                        System.out.println("Nome: "+p.getNome());            
                        System.out.println("Data: "+DataBDBR(p.getData()));
                        System.out.println("CPF: "+p.getCpf());
                        System.out.println("-------------"); 
                        aux = 1;
                    }
            }
           if(aux == 0)
                System.out.println("NÃO EXISTE CADASTROS COM ESSE CPF.");
        }else if(con.length()==14){
            p1.setCpf(con);
            for(pessoa p:p2.Buscartodos()){
                    if(p.getCpf().equals(con)){
                        System.out.println("Nome: "+p.getNome());            
                        System.out.println("Data: "+DataBDBR(p.getData()));
                        System.out.println("CPF: "+p.getCpf());
                        System.out.println("-------------");                
                        aux = 1;
                    }
            }
            if(aux == 0)
                System.out.println("NÃO EXISTE CADASTROS COM ESSE CPF.");
        }
        else
            System.out.println("CPF INVÁLIDO!");
    }
}
