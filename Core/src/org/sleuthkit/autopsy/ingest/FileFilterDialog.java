/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sleuthkit.autopsy.ingest;

/**
 *
 * @author brianc
 */
public class FileFilterDialog extends javax.swing.JDialog {

    private IngestFileFilter fileFilter = null;
    
    /**
     * Creates new form FileFilterDialog
     */
    public FileFilterDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        allFilesRadio = new javax.swing.JRadioButton();
        jpegsRadio = new javax.swing.JRadioButton();
        userRadio = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(FileFilterDialog.class, "FileFilterDialog.title")); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        buttonGroup1.add(allFilesRadio);
        allFilesRadio.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(allFilesRadio, org.openide.util.NbBundle.getMessage(FileFilterDialog.class, "FileFilterDialog.allFilesRadio.text")); // NOI18N
        allFilesRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allFilesRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(jpegsRadio);
        org.openide.awt.Mnemonics.setLocalizedText(jpegsRadio, org.openide.util.NbBundle.getMessage(FileFilterDialog.class, "FileFilterDialog.jpegsRadio.text")); // NOI18N

        buttonGroup1.add(userRadio);
        org.openide.awt.Mnemonics.setLocalizedText(userRadio, org.openide.util.NbBundle.getMessage(FileFilterDialog.class, "FileFilterDialog.userRadio.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(FileFilterDialog.class, "FileFilterDialog.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(allFilesRadio)
                    .addComponent(jpegsRadio)
                    .addComponent(userRadio)
                    .addComponent(jButton1))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allFilesRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpegsRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userRadio)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allFilesRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allFilesRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allFilesRadioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       setVisible(false);
       if (allFilesRadio.isSelected()) {
           fileFilter = null;
       }
       else if (jpegsRadio.isSelected()) {
           fileFilter = new IngestFileFilter();
           fileFilter.add("jpg", null);
       }
       else if (userRadio.isSelected()) {
           fileFilter = new IngestFileFilter();
           fileFilter.add(null, "Documents and Settings");
       }
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formComponentShown

    IngestFileFilter getFileFilter() {
        return fileFilter;
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
            java.util.logging.Logger.getLogger(FileFilterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileFilterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileFilterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileFilterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FileFilterDialog dialog = new FileFilterDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allFilesRadio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jpegsRadio;
    private javax.swing.JRadioButton userRadio;
    // End of variables declaration//GEN-END:variables
}
