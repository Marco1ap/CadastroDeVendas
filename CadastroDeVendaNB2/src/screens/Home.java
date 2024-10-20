/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

/**
 *
 * @author marco
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        
        jBCadastrarVenda.setOpaque(false);   
        jBCadastrarVenda.setContentAreaFilled(false);
        jBCadastrarVenda.setBorderPainted(false);
         
        jBCadastrarCliente.setOpaque(false);    
        jBCadastrarCliente.setContentAreaFilled(false);
        jBCadastrarCliente.setBorderPainted(false);
          
        jBListaDeVendas.setOpaque(false);  
        jBListaDeVendas.setContentAreaFilled(false);
        jBListaDeVendas.setBorderPainted(false);
        
        jBListaDeClientes.setOpaque(false);  
        jBListaDeClientes.setContentAreaFilled(false);
        jBListaDeClientes.setBorderPainted(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBCadastrarVenda = new javax.swing.JButton();
        jBCadastrarCliente = new javax.swing.JButton();
        jBListaDeClientes = new javax.swing.JButton();
        jBListaDeVendas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBCadastrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarVendaActionPerformed(evt);
            }
        });
        getContentPane().add(jBCadastrarVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 270, 80));

        jBCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jBCadastrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 517, 260, 80));

        jBListaDeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListaDeClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jBListaDeClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 260, 80));

        jBListaDeVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListaDeVendasActionPerformed(evt);
            }
        });
        getContentPane().add(jBListaDeVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 627, 260, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tela Principal1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarVendaActionPerformed

        TelaCadastrarVenda botaotela1 = new TelaCadastrarVenda();
        botaotela1.setVisible(true);
        
    }//GEN-LAST:event_jBCadastrarVendaActionPerformed

    private void jBCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarClienteActionPerformed
        
        TelaCadastrarCliente botaotela2 = new TelaCadastrarCliente();
        botaotela2.setVisible(true);
        
    }//GEN-LAST:event_jBCadastrarClienteActionPerformed

    private void jBListaDeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListaDeClientesActionPerformed
        
        TelaListaDeClientes botaotela4 = new TelaListaDeClientes();
        botaotela4.setVisible(true);
        
    }//GEN-LAST:event_jBListaDeClientesActionPerformed

    private void jBListaDeVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListaDeVendasActionPerformed
        
        TelaDeListaDeVendas botaotela3 = new TelaDeListaDeVendas();
        botaotela3.setVisible(true);
        
    }//GEN-LAST:event_jBListaDeVendasActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrarCliente;
    private javax.swing.JButton jBCadastrarVenda;
    private javax.swing.JButton jBListaDeClientes;
    private javax.swing.JButton jBListaDeVendas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
