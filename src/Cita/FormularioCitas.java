/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cita;

import clases.Citas;
import clases.Conexion;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 *
 * @author Jorge Augusto
 */
public class FormularioCitas extends javax.swing.JInternalFrame {
    Conexion conexion = new Conexion();
    Connection conectarse = conexion.getConection();
    PreparedStatement declarar;
    ResultSet resultado;
    DefaultTableModel modelo,modelo1,modelo2;
    private int fila,fila1;
    public FormularioCitas() {
         initComponents();
         modelo = new DefaultTableModel();
         modelo1 = new DefaultTableModel();
         modelo2 = new DefaultTableModel();
         jButton1.setEnabled(false);
    }
        public void ExportareImprimirPDF()
    {
     try{
        String sq2="SELECT DETALLE_CITA.ID_DETALLECITA,EMPRESA.NOMBREEMPRESA,PARTICIPANTE.NOMBRE ,DETALLE_CITA.HORAASIGNADA,MESA.ID_MESA "
                + "FROM EMPRESA,PARTICIPANTE,MESA,ASIGNACION_MESA,DETALLE_CITA "
                + "WHERE EMPRESA.ID_EMPRESA = ASIGNACION_MESA.ID_EMPRESA "
                + "AND MESA.ID_MESA = ASIGNACION_MESA.ID_MESA "
                + "AND ASIGNACION_MESA.ID_ASIGNA = DETALLE_CITA.ID_ASIGNA "
                + "AND DETALLE_CITA.ID_PARTICIPANTE = PARTICIPANTE.ID_PARTICIPANTE "
                + "AND DETALLE_CITA.estado = 1";
        declarar=conectarse.prepareStatement(sq2);
        resultado = declarar.executeQuery();
         try (OutputStream file = new FileOutputStream(new File("C:\\Users\\Jorge Augusto\\Desktop\\Citas.pdf")) //Lice debe cambiar esta parte para que le genere el archivo pdf en la ruta que desea
         ) {
             Document document = new Document();
             PdfWriter.getInstance(document, file);
             
             document.open();
             PdfPTable tabla = new PdfPTable(5);
             Paragraph p=new Paragraph("Lista de Citas",
                     FontFactory.getFont("arial",   // fuente
                             14,                            // tamaño
                             Font.ITALIC,                   // estilo
                             BaseColor.BLACK));
             p.setAlignment(Element.ALIGN_CENTER);
             document.add(p);
             document.add(new Paragraph(" "));
             
             float[] medidaCeldas = {0.75f, 1.00f, 1.50f, 0.75f,0.55f};
             tabla.setWidths(medidaCeldas);
             tabla.addCell(new Paragraph("Nro Cita",FontFactory.getFont("arial",12)));
             tabla.addCell(new Paragraph("Empresa",FontFactory.getFont("arial",12)));
             tabla.addCell(new Paragraph("Representante",FontFactory.getFont("arial",12)));
             tabla.addCell(new Paragraph("Hora",FontFactory.getFont("arial",12)));
             tabla.addCell(new Paragraph("Mesa",FontFactory.getFont("arial",12)));
             
             while (resultado.next()){
                 tabla.addCell(new Paragraph(resultado.getString(1),FontFactory.getFont("arial",10)));
                 tabla.addCell(new Paragraph(resultado.getString(2),FontFactory.getFont("arial",10)));
                 tabla.addCell(new Paragraph(resultado.getString(3),FontFactory.getFont("arial",10)));
                 tabla.addCell(new Paragraph(resultado.getString(4),FontFactory.getFont("arial",10)));
                 tabla.addCell(new Paragraph(resultado.getString(5),FontFactory.getFont("arial",10)));
             }
             document.add(tabla);
             document.close();
         }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
        }
        try {
        File file = new File("C:\\Users\\Jorge Augusto\\Desktop\\Citas.pdf");
        Desktop.getDesktop().open(file);
        } catch(Exception e) {
        e.printStackTrace();
        }
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablabusquedaEmpresa = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaBusquedaParticipante = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        HoraAsignacion = new com.lavantech.gui.comp.TimePanel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Citas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Crear Cita");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Empresas con");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Reunion", "Empresa a Citarse", "Participante", "Hora de la Cita", "Numero de Mesa"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Buscar Participante");

        tablabusquedaEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablabusquedaEmpresa);

        tablaBusquedaParticipante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaBusquedaParticipante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBusquedaParticipanteMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaBusquedaParticipante);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("mesa Asignada");

        HoraAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoraAsignacionActionPerformed(evt);
            }
        });

        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Por nombre");

        jLabel9.setText("nro de Documento");

        jLabel10.setText("o Correo Electronico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(80, 80, 80)
                                .addComponent(jButton2)
                                .addGap(65, 65, 65)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(187, 187, 187)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel10)))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(HoraAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel8)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(HoraAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Citas cita = new Citas();
        try {
            
           // modelo2=cita.Listar();
          //  jTable2.setModel(modelo2);
            cita.listarCitas(jTable2);
            modelo = cita.BuscarEmpresa();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        tablabusquedaEmpresa.setModel(modelo);
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Citas cita = new Citas();
        fila = tablabusquedaEmpresa.getSelectedRow();
        fila1 = tablaBusquedaParticipante.getSelectedRow();
        int id_asigna = (int) tablabusquedaEmpresa.getValueAt(fila,0);
        int id_participante = (int) tablaBusquedaParticipante.getValueAt(fila1,0);
        int hora = HoraAsignacion.getCalendar().get(Calendar.HOUR);
        int min = HoraAsignacion.getCalendar().get(Calendar.MINUTE);
        int seg = HoraAsignacion.getCalendar().get(Calendar.SECOND);
        String horaObtenida = hora+":"+min+":"+seg;
        cita.setIdEmpresa(id_asigna);
        cita.setParticipante(id_participante);
        cita.setHora(horaObtenida);
        try {
            cita.crearCita();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
       Citas cita = new Citas();
       cita.setnombreParticipante(jTextField2.getText());
        try {
            modelo1 = cita.BuscarParticipante();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
       tablaBusquedaParticipante.setModel(modelo1);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaBusquedaParticipanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaParticipanteMouseClicked
        jButton1.setEnabled(true);
    }//GEN-LAST:event_tablaBusquedaParticipanteMouseClicked

    private void HoraAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoraAsignacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoraAsignacionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     ExportareImprimirPDF();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lavantech.gui.comp.TimePanel HoraAsignacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tablaBusquedaParticipante;
    private javax.swing.JTable tablabusquedaEmpresa;
    // End of variables declaration//GEN-END:variables
}
