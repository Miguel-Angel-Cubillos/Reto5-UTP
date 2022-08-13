/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package miguel.reto5.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import miguel.reto5.controller.ReportesController;
import miguel.reto5.model.vo.ComprasDeLiderVo;

/**
 *
 * @author usuario
 */
public class ReportesViewGuiConsulta3 extends javax.swing.JFrame {

    /**
     * Creates new form ReportesViewGuiConsulta3
     */
    public ReportesViewGuiConsulta3() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla3 = new javax.swing.JTable();
        Btncargar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        consulta1 = new javax.swing.JMenuItem();
        consulta2 = new javax.swing.JMenuItem();
        consulta3 = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Lider", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla3);

        Btncargar.setText("Cargar");
        Btncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtncargarActionPerformed(evt);
            }
        });

        jMenu1.setText("Consultas");

        consulta1.setText("Consulta1");
        consulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulta1ActionPerformed(evt);
            }
        });
        jMenu1.add(consulta1);

        consulta2.setText("Consulta2");
        consulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulta2ActionPerformed(evt);
            }
        });
        jMenu1.add(consulta2);

        consulta3.setText("Consulta3");
        jMenu1.add(consulta3);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu1.add(salir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(Btncargar)
                .addContainerGap(416, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btncargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulta2ActionPerformed
        ReportesViewGuiConsulta2 reporte2 = new ReportesViewGuiConsulta2();
        reporte2.setVisible(true);
        reporte2.setSize(900,450);
        reporte2.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_consulta2ActionPerformed

    private void consulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulta1ActionPerformed
        ReportesViewGuiConsulta1 reporte1 = new ReportesViewGuiConsulta1();
        reporte1.setVisible(true);
        reporte1.setSize(900,450);
        reporte1.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_consulta1ActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void BtncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtncargarActionPerformed
        DefaultTableModel modeloTabla3 = new DefaultTableModel();
        Tabla3.setModel(modeloTabla3);
        modeloTabla3.addColumn("Lider");
        modeloTabla3.addColumn("Valor");
        
        ReportesController reportesController = new ReportesController();
        List<ComprasDeLiderVo> respuesta = reportesController.listarLideresQueMasGastan();
        for (ComprasDeLiderVo compra : respuesta) {
            Object fila[] = new Object[2];
                fila[0] = compra.getLider();
                fila[1] = compra.getValor();
                modeloTabla3.addRow(fila);
        }
    }//GEN-LAST:event_BtncargarActionPerformed

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
            java.util.logging.Logger.getLogger(ReportesViewGuiConsulta3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportesViewGuiConsulta3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportesViewGuiConsulta3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportesViewGuiConsulta3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesViewGuiConsulta3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btncargar;
    private javax.swing.JTable Tabla3;
    private javax.swing.JMenuItem consulta1;
    private javax.swing.JMenuItem consulta2;
    private javax.swing.JMenuItem consulta3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem salir;
    // End of variables declaration//GEN-END:variables
}