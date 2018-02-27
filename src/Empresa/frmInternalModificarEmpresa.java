
package Empresa;

import clases.Empresa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmInternalModificarEmpresa extends javax.swing.JInternalFrame {

    
    public frmInternalModificarEmpresa() {
        initComponents();
        jPanelModificar.setVisible(false);
        txtCodemOculto.setVisible(false);
        txtnombreOculto.setVisible(false);
        txtdireccionOculto.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGfecha = new javax.swing.ButtonGroup();
        btnGciudad = new javax.swing.ButtonGroup();
        txtBuscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jPanelModificar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblFechaLimite = new javax.swing.JLabel();
        btnModificar = new javax.swing.JToggleButton();
        lblCiudad = new javax.swing.JLabel();
        txtCodemOculto = new javax.swing.JTextField();
        txtnombreOculto = new javax.swing.JTextField();
        txtdireccionOculto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtWebSite = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cboxRubro = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cboxTipo = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnIraModificar = new javax.swing.JButton();

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setText("Buscar Empresa:");

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel10.setText("Nombre Empresa:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel11.setText("Direccion:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel12.setText("Pais:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel13.setText("Ciudad:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel14.setText("Telefono:");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel15.setText("Email:");

        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaisKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel17.setText("MODIFICAR EMPRESA");

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel16.setText("Web Site:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel19.setText("Rubro:");

        cboxRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRubroActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel18.setText("Tipo:");

        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ofertante", "Demandante", "Ambos" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Persona Contacto");

        javax.swing.GroupLayout jPanelModificarLayout = new javax.swing.GroupLayout(jPanelModificar);
        jPanelModificar.setLayout(jPanelModificarLayout);
        jPanelModificarLayout.setHorizontalGroup(
            jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(30, 30, 30))
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addComponent(txtdireccionOculto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtDireccion)
                            .addComponent(txtPais)
                            .addComponent(txtCiudad)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarLayout.createSequentialGroup()
                                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(lblFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodemOculto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombreOculto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelModificarLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(btnModificar))
                            .addGroup(jPanelModificarLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel17)))
                .addContainerGap())
        );
        jPanelModificarLayout.setVerticalGroup(
            jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel17)
                .addGap(33, 33, 33)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarLayout.createSequentialGroup()
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addComponent(lblFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(txtCodemOculto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombreOculto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdireccionOculto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cboxRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar))))
        );

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnIraModificar.setText("Ir a Modificar");
        btnIraModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIraModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIraModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnBuscar)
                    .addComponent(btnCerrar)
                    .addComponent(btnIraModificar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
      dispose();   
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        //validar campos
        if(txtNombre.getText().equals("")||txtDireccion.getText().equals("")||txtPais.getText().equals("")||txtCiudad.getText().equals("")
                ||txtTelefono.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Debe llenar todos los campos");
        
        }
        else{ 
           //Cargar Valores        
           String nombre=txtNombre.getText();
           String direccion=txtDireccion.getText();
           String pais=txtPais.getText();
           String ciudad=txtCiudad.getText();
           String telf=txtTelefono.getText();
           String email=txtEmail.getText();
           String website=txtWebSite.getText();
           String persona = jTextField1.getText();
           int idrubro=0;
           String tipo="";
           
           boolean modfecha=false;
           boolean mismaEmpresa=false;           
           int cod=Integer.parseInt(txtCodemOculto.getText());
           
           //crear el objeto
           //Empresa(int codEmpresa, String nombre,String direccion,String pais,String ciudad,
                   // int telefono,String email,String website,int idrubro,String tipo,String persona)
            clases.Empresa emp =new Empresa(cod,nombre,direccion,pais,ciudad,telf,email,website,idrubro,tipo,persona);
            if(emp.ModificarEmpresa(modfecha,mismaEmpresa)==true){
                JOptionPane.showMessageDialog(null,"datos modificados");
                jPanelModificar.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"No se pudo modificar");
             }
            
             //limpiar tabla
            DefaultTableModel modolimpio=(DefaultTableModel) tblDatos.getModel();
            while(modolimpio.getRowCount()>0)modolimpio.removeRow(0); 
        }
        
        
        
              
        
        
        
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnIraModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIraModificarActionPerformed
        int fila =tblDatos.getSelectedRow();
        if(fila>=0){
            
            txtCodemOculto.setText(tblDatos.getValueAt(fila,0).toString());
            txtNombre.setText(tblDatos.getValueAt(fila,1).toString());
            txtnombreOculto.setText(tblDatos.getValueAt(fila,1).toString());
            txtDireccion.setText(tblDatos.getValueAt(fila,2).toString());
            txtPais.setText(tblDatos.getValueAt(fila,3).toString());
            txtCiudad.setText(tblDatos.getValueAt(fila,4).toString());
            txtdireccionOculto.setText(tblDatos.getValueAt(fila,4).toString());
            txtTelefono.setText(tblDatos.getValueAt(fila,5).toString());
            txtEmail.setText(tblDatos.getValueAt(fila,6).toString());
            txtWebSite.setText(tblDatos.getValueAt(fila,7).toString());
           
            jPanelModificar.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Seleccione fila");
        }
    }//GEN-LAST:event_btnIraModificarActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){//Si NO es un número no le permite escribir
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyTyped
       
    }//GEN-LAST:event_txtPaisKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){//Si NO es un número no le permite escribir
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void cboxRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRubroActionPerformed

    }//GEN-LAST:event_cboxRubroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.ButtonGroup btnGciudad;
    private javax.swing.ButtonGroup btnGfecha;
    private javax.swing.JButton btnIraModificar;
    private javax.swing.JToggleButton btnModificar;
    private javax.swing.JComboBox<String> cboxRubro;
    private javax.swing.JComboBox<String> cboxTipo;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanelModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblFechaLimite;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodemOculto;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtWebSite;
    private javax.swing.JTextField txtdireccionOculto;
    private javax.swing.JTextField txtnombreOculto;
    // End of variables declaration//GEN-END:variables
}
