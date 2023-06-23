/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import trabalhofinal.TrabalhoFinal;
import trabalhofinal.Organizador;

/**
 *
 * @author guton
 */
public class TelaCriarTorneio extends javax.swing.JFrame {

    /**
     * Creates new form TelaCriarTorneio
     */
    public TelaCriarTorneio() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInicioJogos = new javax.swing.JLabel();
        ftxtInicioJogos = new javax.swing.JFormattedTextField();
        lblPeriodoJogos = new javax.swing.JLabel();
        txtPeriodoJogos = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCriar = new javax.swing.JButton();
        lblDescricao = new javax.swing.JLabel();
        lblRegra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDescricao = new javax.swing.JTextArea();
        cbxRegra = new javax.swing.JComboBox<>();
        lblLocal = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblInicioInscr = new javax.swing.JLabel();
        ftxtInicioInscr = new javax.swing.JFormattedTextField();
        lblPeriodoInscr = new javax.swing.JLabel();
        txtPeriodoInscr = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblInicioJogos.setText("Início dos jogos:");

        try {
            ftxtInicioJogos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtInicioJogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtInicioJogosActionPerformed(evt);
            }
        });

        lblPeriodoJogos.setText("Período dos jogos (dias):");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Criar Torneio");

        lblNome.setText("Nome:");

        btnCriar.setText("Criar");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        lblDescricao.setText("Descrição:");

        lblRegra.setText("Regra: ");

        txtaDescricao.setColumns(20);
        txtaDescricao.setRows(5);
        jScrollPane1.setViewportView(txtaDescricao);

        cbxRegra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinuquinha", "Bola 8" }));

        lblLocal.setText("Local:");

        lblTipo.setText("Tipo:");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mata-mata", "Liga" }));

        lblInicioInscr.setText("Inicio das Inscrições:");

        try {
            ftxtInicioInscr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtInicioInscr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtInicioInscrActionPerformed(evt);
            }
        });

        lblPeriodoInscr.setText("Período de inscrições (dias):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNome)
                        .addComponent(lblLocal)
                        .addComponent(txtLocal)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRegra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxRegra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInicioInscr)
                    .addComponent(ftxtInicioInscr, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodoInscr)
                    .addComponent(txtPeriodoInscr, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInicioJogos)
                    .addComponent(ftxtInicioJogos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodoJogos)
                    .addComponent(txtPeriodoJogos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(btnCriar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitulo)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegra)
                    .addComponent(cbxRegra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInicioInscr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtInicioInscr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPeriodoInscr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeriodoInscr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInicioJogos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtInicioJogos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPeriodoJogos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeriodoJogos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnCriar)
                .addGap(127, 127, 127))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        // TODO add your handling code here:
        if(this.txtLocal.getText().equals("") || this.txtNome.getText().equals("") || 
           this.txtPeriodoInscr.getText().equals("") || this.txtPeriodoJogos.getText().equals("") || this.txtaDescricao.getText().equals("") || 
           this.ftxtInicioJogos.getText().equals("") || this.ftxtInicioInscr.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            TrabalhoFinal.criarTorneio(this.txtNome.getText(),
                                   this.txtaDescricao.getText(),
                                   this.txtLocal.getText(),
                                   LocalDate.parse(this.ftxtInicioJogos.getText()),
                                   LocalDate.parse(this.ftxtInicioInscr.getText()),
                                   Integer.parseInt(this.txtPeriodoJogos.getText()),
                                   Integer.parseInt(this.txtPeriodoInscr.getText()),
                                   "Sinuquinha",
                                   (Organizador) TrabalhoFinal.login,
                                   this.cbxTipo.getSelectedIndex()
                                   );
            
            JOptionPane.showMessageDialog(null, "Torneio criado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            this.txtLocal.setText("");
            this.txtNome.setText("");
            this.txtPeriodoInscr.setText("");
            this.txtPeriodoJogos.setText("");
            this.txtaDescricao.setText("");
            this.ftxtInicioJogos.setText("");
            this.ftxtInicioInscr.setText("");
        }
    }//GEN-LAST:event_btnCriarActionPerformed

    private void ftxtInicioInscrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtInicioInscrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtInicioInscrActionPerformed

    private void ftxtInicioJogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtInicioJogosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtInicioJogosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCriarTorneio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCriarTorneio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCriarTorneio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCriarTorneio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCriarTorneio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JComboBox<String> cbxRegra;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JFormattedTextField ftxtInicioInscr;
    private javax.swing.JFormattedTextField ftxtInicioJogos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblInicioInscr;
    private javax.swing.JLabel lblInicioJogos;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeriodoInscr;
    private javax.swing.JLabel lblPeriodoJogos;
    private javax.swing.JLabel lblRegra;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPeriodoInscr;
    private javax.swing.JTextField txtPeriodoJogos;
    private javax.swing.JTextArea txtaDescricao;
    // End of variables declaration//GEN-END:variables
}
