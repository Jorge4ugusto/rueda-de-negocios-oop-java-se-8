
package Empresa;

import clases.Conexion;
import clases.Empresa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class frmInternalInsertarEmpresa extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInternalInsertarEmpresa
     */
    public frmInternalInsertarEmpresa() {
        initComponents();
        Empresa emp = new Empresa();
        
        emp.listarEmpresaCbox(cboxRubro,"select * from rubro;");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtWebSite = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cboxRubro = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cboxTipo = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaisKeyTyped(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setText("Nombre Empresa:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel10.setText("Direccion:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel11.setText("Pais:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel12.setText("Ciudad:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel13.setText("Telefono:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel14.setText("Email:");

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel16.setText("REGISTRO DE EMPRESAS");

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel15.setText("Web Site:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel17.setText("Rubro:");

        cboxRubro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cboxRubroAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cboxRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRubroActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel18.setText("Tipo:");

        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ofertante", "Demandante", "Ambos" }));

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel19.setText("Persona Contacto");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtPais, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(txtWebSite)
                            .addComponent(cboxRubro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnRegistrar)
                .addGap(33, 33, 33)
                .addComponent(btnLimpiar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addComponent(jLabel16))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cboxRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnLimpiar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        String nombre=txtNombre.getText();
        String personaEmergencia=jTextArea1.getText();
        String direccion=txtDireccion.getText();
        String pais=txtPais.getText();
        String ciudad=txtCiudad.getText();
        String telefono = txtTelefono.getText();
        String email=txtEmail.getText();
        String website=txtWebSite.getText();
        //int idrubro=(int) cboxRubro.getSelectedItem();
        int id_rubro;
        String tipo=(String) cboxTipo.getSelectedItem();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConection();
       try{
        Statement sent = cn.createStatement(); 
        ResultSet rs = sent.executeQuery("SELECT * FROM RUBRO WHERE nombre_rubro = '"+this.cboxRubro.getSelectedItem()+"'");
        rs.next();
        id_rubro = rs.getInt("id_rubro");
        Empresa emp = new Empresa(0,nombre,direccion,ciudad,pais,telefono,email,website,id_rubro,tipo,personaEmergencia);
       emp.InsertarEmpresa();
        }
        catch(Exception e){
        
        }
        
       
       
       
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
dispose();       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
            txtNombre.setText("");
            txtDireccion.setText("");
            txtPais.setText("");
            txtCiudad.setText("");
            txtTelefono.setText("");
            txtEmail.setText("");
            txtWebSite.setText("");
            
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
       
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyTyped
       
    }//GEN-LAST:event_txtPaisKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){//Si NO es un número no le permite escribir
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void cboxRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRubroActionPerformed
        
        
        
    }//GEN-LAST:event_cboxRubroActionPerformed

    private void cboxRubroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cboxRubroAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxRubroAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboxRubro;
    private javax.swing.JComboBox<String> cboxTipo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtWebSite;
    // End of variables declaration//GEN-END:variables
}
