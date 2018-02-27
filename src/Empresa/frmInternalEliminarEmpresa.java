
package Empresa;

import clases.Empresa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmInternalEliminarEmpresa extends javax.swing.JInternalFrame {

    
    public frmInternalEliminarEmpresa() {
        initComponents();
        txtidoculto.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        txtidoculto = new javax.swing.JTextField();

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Cerrar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setText("Eliminar Empresa:");

        txtidoculto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidocultoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(207, 207, 207))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnEliminar)))
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButton2)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtidoculto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToggleButton2)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel9))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtidoculto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnEliminar)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       Empresa emp= new Empresa();
       emp.setnombre(txtBuscar.getText());
       DefaultTableModel modelo= new DefaultTableModel();
        try {
            modelo = emp.BuscarEmpresa();
        } catch (SQLException ex) {
            Logger.getLogger(frmInternalBuscarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
       tblDatos.setModel(modelo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
       dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila = tblDatos.getSelectedRow();
        System.out.println("fila "+fila);
        if(fila>=0){
            int dialogResult = JOptionPane.showConfirmDialog(null,"esta seguro de eliminar");
            if(dialogResult==JOptionPane.YES_OPTION){
                txtidoculto.setText(tblDatos.getValueAt(fila,0).toString());
                Empresa emp = new Empresa();
                emp.setcodEmpresa(Integer.parseInt(txtidoculto.getText()));
                if(emp.EliminarEmpresa()==true){
                    JOptionPane.showConfirmDialog(null,"se elimino correctamente");
                    DefaultTableModel modolimpio = (DefaultTableModel) tblDatos.getModel();
                    while (modolimpio.getRowCount()>0)modolimpio.removeRow(0);
                }           
                else{
                    JOptionPane.showMessageDialog(null,"error no se pudo eliminar");
                }
            }
            //sino no hago nada        
       }
       else{
        JOptionPane.showMessageDialog(null,"fila no seleccionada");
       }        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtidocultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidocultoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidocultoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtidoculto;
    // End of variables declaration//GEN-END:variables
}
