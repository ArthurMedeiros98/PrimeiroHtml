/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.bean.moto;
import model.bean.motoClub;
import model.bean.pessoa;
import model.bean.usuario;
import model.bean.validacoes;
import model.dao.mcDAO;
import model.dao.pessoaDAO;
import model.dao.usuarioDAO;

/**
 *
 * @author papiro
 */
public class TelaEditarPessoa extends javax.swing.JFrame {
    
    private List<usuario> usuarios;
    private List<motoClub> MCs;
    private List<pessoa> pessoas;
    private List<moto> motos1;
    private usuarioDAO form;
    private pessoaDAO form1;
    private mcDAO form2;
    private moto moto;
    private pessoa pessoa;
    private usuario usuario;
    private motoClub mc;
    private validacoes aux;
    /**
     * Creates new form telaEditarPessoa
     */
    public TelaEditarPessoa() {
        initComponents();
        grupoBotoes();
        pessoa = new pessoa();
        usuario = new usuario();
        aux = new validacoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        checkUser = new javax.swing.JRadioButton();
        checkPessoa = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnConfimar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblMc = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemHome4 = new javax.swing.JMenuItem();
        itemSair = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        editarMC = new javax.swing.JMenuItem();
        editarUsuario = new javax.swing.JMenuItem();
        excluirUsuario = new javax.swing.JMenuItem();
        excluirMC = new javax.swing.JMenuItem();
        menuListar = new javax.swing.JMenu();
        motos = new javax.swing.JMenuItem();
        motoclubs = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 128, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(1, 1, 1));

        checkUser.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        checkUser.setText("Informações Usuário");

        checkPessoa.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        checkPessoa.setText("Informações Pessoais");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Selecione abaixo quais informações deseja alterar:");

        btnConfimar.setBackground(new java.awt.Color(1, 1, 1));
        btnConfimar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnConfimar.setForeground(new java.awt.Color(254, 254, 254));
        btnConfimar.setText("Confirmar");
        btnConfimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfimarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Cpf:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Data de Nascimento:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("MotoClub:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Usuário: ");

        lblNome.setText("jLabel7");

        lblData.setText("jLabel8");

        lblCpf.setText("jLabel9");

        lblMc.setText("jLabel10");

        lblUsuario.setText("jLabel11");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(btnConfimar)
                .addGap(183, 183, 183))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkPessoa)))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lblMc, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lblNome)
                    .addComponent(lblCpf))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblData))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblMc))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkUser)
                    .addComponent(checkPessoa))
                .addGap(18, 18, 18)
                .addComponent(btnConfimar)
                .addContainerGap())
        );

        menuBar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        menuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuBar.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));

        menuArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page.png"))); // NOI18N
        menuArquivo.setText("Arquivo");

        itemHome4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N
        itemHome4.setText("Home");
        itemHome4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHome4ActionPerformed(evt);
            }
        });
        menuArquivo.add(itemHome4);

        itemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/door_out.png"))); // NOI18N
        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });
        menuArquivo.add(itemSair);

        menuBar.add(menuArquivo);

        menuEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        menuEditar.setText("Editar");

        editarMC.setBackground(new java.awt.Color(1, 1, 1));
        editarMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconMoto.png"))); // NOI18N
        editarMC.setText("MotoClub");
        editarMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarMCActionPerformed(evt);
            }
        });
        menuEditar.add(editarMC);

        editarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user_edit.png"))); // NOI18N
        editarUsuario.setText("Info. Pessoais");
        editarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarUsuarioActionPerformed(evt);
            }
        });
        menuEditar.add(editarUsuario);

        excluirUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user_delete.png"))); // NOI18N
        excluirUsuario.setText("Excluir Usuário");
        excluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirUsuarioActionPerformed(evt);
            }
        });
        menuEditar.add(excluirUsuario);

        excluirMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/group_delete.png"))); // NOI18N
        excluirMC.setText("ExcluirMC");
        excluirMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirMCActionPerformed(evt);
            }
        });
        menuEditar.add(excluirMC);

        menuBar.add(menuEditar);

        menuListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/printer.png"))); // NOI18N
        menuListar.setText("Listar");

        motos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/moto.png"))); // NOI18N
        motos.setText("Motos");
        motos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motosActionPerformed(evt);
            }
        });
        menuListar.add(motos);

        motoclubs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/group.png"))); // NOI18N
        motoclubs.setText("MotoClubs");
        motoclubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motoclubsActionPerformed(evt);
            }
        });
        menuListar.add(motoclubs);

        menuBar.add(menuListar);

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/help.png"))); // NOI18N
        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        menuBar.add(menuSobre);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void grupoBotoes(){
        ButtonGroup gB = new ButtonGroup();
        gB.add(checkPessoa);
        gB.add(checkUser);
    }
    
    private void itemHome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHome4ActionPerformed
        // TODO add your handling code here:
        TelaMenuInicial tela = new TelaMenuInicial();
        tela.getObjetos(usuarios, pessoas, MCs, motos1);
        tela.getMc(mc);
        tela.getPessoa(pessoa);
        tela.getUsuario(usuario);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_itemHome4ActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        // TODO add your handling code here:
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_itemSairActionPerformed

    private void editarMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarMCActionPerformed
        // TODO add your handling code here:
        TelaEditarMC tela = new TelaEditarMC();
        tela.getObjetos(usuarios, pessoas, MCs, motos1);
        tela.getMc(mc);
        tela.getPessoa(pessoa);
        tela.getUsuario(usuario);
        tela.inserir();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_editarMCActionPerformed

    private void editarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarUsuarioActionPerformed
        // TODO add your handling code here:
        TelaEditarPessoa tela = new TelaEditarPessoa();
        tela.getObjetos(usuarios, pessoas, MCs, motos1);
        tela.getMc(mc);
        tela.getPessoa(pessoa);
        tela.getUsuario(usuario);
        tela.inserir();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_editarUsuarioActionPerformed

    private void excluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirUsuarioActionPerformed
        // TODO add your handling code here:
        PopUpConfirmar conf = new PopUpConfirmar();
        conf.confirmar("usuario",usuario,mc,pessoa,MCs); //FALTA CRIAR UMA RELACAO ENTRE USUARIO, PESSOA LA NO BD COM A FOREIGN KEY
        conf.setVisible(true);
    }//GEN-LAST:event_excluirUsuarioActionPerformed

    private void excluirMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirMCActionPerformed
        // TODO add your handling code here:
        PopUpConfirmar conf = new PopUpConfirmar();
        conf.confirmar("mc",usuario,mc,pessoa,MCs); //FALTA CRIAR UMA RELACAO ENTRE USUARIO E MC LA NO BD COM A FOREIGN KEY
        conf.setVisible(true);
    }//GEN-LAST:event_excluirMCActionPerformed

    private void motosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motosActionPerformed
        // TODO add your handling code here:
        TelaMotos tela1 = new TelaMotos();
        tela1.setVisible(true);
        tela1.getMc(mc);
        tela1.getPessoa(pessoa);
        tela1.getUsuario(usuario);
        tela1.getObjetos(usuarios, pessoas, MCs, motos1);
        tela1.inserir();
        dispose();
    }//GEN-LAST:event_motosActionPerformed

    private void motoclubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motoclubsActionPerformed
        // TODO add your handling code here:
        TelaMCs tela1 = new TelaMCs();
        tela1.getMc(mc);
        tela1.getPessoa(pessoa);
        tela1.getUsuario(usuario);
        tela1.getObjetos(usuarios, pessoas, MCs, motos1);
        tela1.setVisible(true);
        dispose();
    }//GEN-LAST:event_motoclubsActionPerformed

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Sistema de gerenciamento de MotorClubs\nVersão 1.0");
    }//GEN-LAST:event_menuSobreMouseClicked

    private void btnConfimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfimarActionPerformed
        // TODO add your handling code here:
        AlterarPessoa telaP = new AlterarPessoa();
        AlterarUsuario telaU = new AlterarUsuario();
        if(checkPessoa.isSelected() == true){
            telaP.getObjetos(usuarios, pessoas,MCs);
            telaP.getPessoa(pessoa);
            telaP.getUsuario(usuario);
            telaP.setVisible(true);
            
        }else if(checkUser.isSelected() == true){
            telaU.getObjetos(usuarios, pessoas);
            telaU.getUsuario(usuario);
            telaU.setVisible(true);
        }else
            JOptionPane.showMessageDialog(null, "Selecione uma opção, para poder prosseguir.");
    }//GEN-LAST:event_btnConfimarActionPerformed

    public void getObjetos(List<usuario> u, List<pessoa> p, List<motoClub> mc, List<moto> m){
        usuarios = u;
        MCs = mc; 
        pessoas = p;
        motos1 = m;
    }
    public void getMc(motoClub mc){this.mc = mc;}
    public void getPessoa(pessoa p){pessoa = p;}
    public void getUsuario(usuario u){usuario = u;}
    public void inserir(){
        System.out.println(usuario.getIdmc());
        lblNome.setText(pessoa.getNome());
        lblCpf.setText(pessoa.getCpf());
        lblData.setText(aux.DataBDBR(pessoa.getData()));
        lblMc.setText(pessoa.getMc());
        lblUsuario.setText(usuario.getNome());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEditarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfimar;
    private javax.swing.JRadioButton checkPessoa;
    private javax.swing.JRadioButton checkUser;
    private javax.swing.JMenuItem editarMC;
    private javax.swing.JMenuItem editarUsuario;
    private javax.swing.JMenuItem excluirMC;
    private javax.swing.JMenuItem excluirUsuario;
    private javax.swing.JMenuItem itemHome4;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblMc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenu menuListar;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenuItem motoclubs;
    private javax.swing.JMenuItem motos;
    // End of variables declaration//GEN-END:variables
}
