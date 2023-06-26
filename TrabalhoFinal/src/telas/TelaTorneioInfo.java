/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import trabalhofinal.TrabalhoFinal;
import trabalhofinal.Organizador;
import trabalhofinal.MataMata;
import trabalhofinal.Torneio;
        
/**
 *
 * @author guton
 */
public class TelaTorneioInfo extends javax.swing.JFrame {

    /**
     * Creates new form TelaTorneioInfo
     */
    public TelaTorneioInfo() {
        initComponents();
        setLocationRelativeTo(null);
        this.setup();
    }
    
    public void setup(){
        if(TrabalhoFinal.currentTorneio.getStatusTorneio() != 2){
           this.btnEditarTorneio.setVisible(false);
           if(TrabalhoFinal.currentTorneio.getStatusTorneio() < 2){
                this.btnPontuacao.setVisible(false);
           }
            
        }
        
        
        if(TrabalhoFinal.login instanceof Organizador){
            this.btnCancelaInscr.setVisible(false);
            this.btnInscricao.setVisible(false);
            if(TrabalhoFinal.login.getId() != TrabalhoFinal.currentTorneio.getOrganizador().getId()){
                this.btnEditarTorneio.setVisible(false);
            }
        } else{
            this.btnEditarTorneio.setVisible(false);
        }
        
        this.lblDescricao.setText(TrabalhoFinal.currentTorneio.getDescricao());
        this.jLabel7.setText(TrabalhoFinal.currentTorneio.getFimInscricao().toString());
        this.jLabel10.setText(TrabalhoFinal.currentTorneio.getFimTorneio().toString());
        this.jLabel9.setText(TrabalhoFinal.currentTorneio.getDataInicioInscricao().toString());
        this.jLabel8.setText(TrabalhoFinal.currentTorneio.getDataInicio().toString());
        this.jLabel1.setText(TrabalhoFinal.currentTorneio.getLocal());
        this.jLabel5.setText(String.valueOf(TrabalhoFinal.currentTorneio.getMaxParticipantes()));
        this.jLabel3.setText(String.valueOf(TrabalhoFinal.currentTorneio.getMinParticipantes()));
        this.jLabel11.setText(String.valueOf(TrabalhoFinal.currentTorneio.getNumJogosPartida()));
        this.jLabel2.setText(TrabalhoFinal.currentTorneio.getRegras());
        if(TrabalhoFinal.currentTorneio instanceof MataMata){
            this.jLabel4.setText("Mata-mata");
        } else{
            this.jLabel4.setText("Liga");
        }
        this.lblTitulo.setText(TrabalhoFinal.currentTorneio.getNome());
        this.jLabel13.setText(TrabalhoFinal.currentTorneio.getOrganizador().getNome());
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        lblInicioInscr = new javax.swing.JLabel();
        lblFimInscr = new javax.swing.JLabel();
        lblInicioJogos = new javax.swing.JLabel();
        lblFimJogos = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblNumJogos = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        btnListaPart = new javax.swing.JButton();
        lblLocal = new javax.swing.JLabel();
        btnPontuacao = new javax.swing.JButton();
        lblRegra = new javax.swing.JLabel();
        btnInscricao = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        btnCancelaInscr = new javax.swing.JButton();
        lblMaxPart = new javax.swing.JLabel();
        btnEditarTorneio = new javax.swing.JButton();
        lblMinPart = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel6.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblInicioInscr.setText("Início das Inscrições:");

        lblFimInscr.setText("Encerramento das Incrições:");

        lblInicioJogos.setText("Inicío dos Jogos:");

        lblFimJogos.setText("Fim dos Jogos:");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Torneio do Tio Zé");

        lblNumJogos.setText("Número de jogos por partida:");

        lblDescricao.setText("Descrição ");

        btnListaPart.setText("Lista de participantes");
        btnListaPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaPartActionPerformed(evt);
            }
        });

        lblLocal.setText("Local: ");

        btnPontuacao.setText("Pontuação");
        btnPontuacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPontuacaoActionPerformed(evt);
            }
        });

        lblRegra.setText("Regra:");

        btnInscricao.setText("Inscrever-se");
        btnInscricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscricaoActionPerformed(evt);
            }
        });

        lblTipo.setText("Tipo:");

        btnCancelaInscr.setText("Cancelar Inscrição");
        btnCancelaInscr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaInscrActionPerformed(evt);
            }
        });

        lblMaxPart.setText("Máximo de participantes:");

        btnEditarTorneio.setText("Atualiar Resultados");
        btnEditarTorneio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTorneioActionPerformed(evt);
            }
        });

        lblMinPart.setText("Mínimo de participantes:");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel1");

        jLabel3.setText("jLabel1");

        jLabel4.setText("jLabel1");

        jLabel5.setText("jLabel1");

        jLabel7.setText("jLabel1");

        jLabel8.setText("jLabel1");

        jLabel9.setText("jLabel1");

        jLabel10.setText("jLabel1");

        jLabel11.setText("jLabel1");

        jLabel12.setText("Organizador:");

        jLabel13.setText("jLabel13");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTitulo)
                                .addGap(150, 150, 150)
                                .addComponent(btnEditarTorneio)
                                .addGap(57, 57, 57))
                            .addComponent(lblDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblLocal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblRegra)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTipo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMaxPart)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMinPart)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnListaPart)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPontuacao)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblInicioJogos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblFimJogos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnInscricao)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancelaInscr))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblInicioInscr)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblFimInscr)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNumJogos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(72, 72, 72)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnEditarTorneio)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocal)
                    .addComponent(lblInicioInscr)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegra)
                    .addComponent(lblFimInscr)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicioJogos)
                    .addComponent(jLabel8))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaxPart)
                    .addComponent(lblFimJogos)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMinPart)
                    .addComponent(lblNumJogos)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListaPart)
                    .addComponent(btnPontuacao)
                    .addComponent(btnInscricao)
                    .addComponent(btnCancelaInscr))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaPartActionPerformed
        // TODO add your handling code here:
        new ListaParticipantes().setVisible(true);
    }//GEN-LAST:event_btnListaPartActionPerformed

    private void btnPontuacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPontuacaoActionPerformed
        // TODO add your handling code here:
        if(TrabalhoFinal.currentTorneio instanceof MataMata){
            new MataMataPontuacao().setVisible(true);
        } else{
           new LigaPontuacao().setVisible(true);
        }
    }//GEN-LAST:event_btnPontuacaoActionPerformed

    private void btnEditarTorneioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTorneioActionPerformed
        // TODO add your handling code here:
        new EditarTorneio().setVisible(true);
    }//GEN-LAST:event_btnEditarTorneioActionPerformed

    private void btnInscricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscricaoActionPerformed
        // TODO add your handling code here:
        if(LocalDate.now().compareTo(TrabalhoFinal.currentTorneio.getDataInicioInscricao()) >= 0 && LocalDate.now().compareTo(TrabalhoFinal.currentTorneio.getFimInscricao()) <= 0){
            if(TrabalhoFinal.isInscrito()){
                JOptionPane.showMessageDialog(null, "Você já está inscrito nesse torneio!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else{
                TrabalhoFinal.inscricao();
                JOptionPane.showMessageDialog(null, "Inscrição realizada!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Período de inscrições não começou ou já acabou!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnInscricaoActionPerformed

    private void btnCancelaInscrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaInscrActionPerformed
        // TODO add your handling code here:
        if(LocalDate.now().compareTo(TrabalhoFinal.currentTorneio.getDataInicioInscricao()) >= 0 && LocalDate.now().compareTo(TrabalhoFinal.currentTorneio.getFimInscricao()) <= 0){
            if(TrabalhoFinal.isInscrito()){
                JOptionPane.showMessageDialog(null, "Inscrição cancelada com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                TrabalhoFinal.cancelarInscricao();
            } else{
                JOptionPane.showMessageDialog(null, "Você não está inscrito nesse torneio!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Período de inscrições não começou ou já acabou!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelaInscrActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        TrabalhoFinal.currentTorneio = new Torneio(-1);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(TelaTorneioInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTorneioInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTorneioInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTorneioInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTorneioInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelaInscr;
    private javax.swing.JButton btnEditarTorneio;
    private javax.swing.JButton btnInscricao;
    private javax.swing.JButton btnListaPart;
    private javax.swing.JButton btnPontuacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFimInscr;
    private javax.swing.JLabel lblFimJogos;
    private javax.swing.JLabel lblInicioInscr;
    private javax.swing.JLabel lblInicioJogos;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblMaxPart;
    private javax.swing.JLabel lblMinPart;
    private javax.swing.JLabel lblNumJogos;
    private javax.swing.JLabel lblRegra;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
