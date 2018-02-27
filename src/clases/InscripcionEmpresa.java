/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
 */
public class InscripcionEmpresa {
    
    Conexion con = new Conexion();
    Connection conectarse = con.getConection();
    PreparedStatement declarar;
    ResultSet resultado;
    ResultSetMetaData resultData;
    DefaultTableModel dtm;
    int idEmpresa,idEvento;
    String datoEmpresa,fecha;
    public int getIdEmpresa()
    {
    return idEmpresa;
    }
    public int getIdEvento()
    {
    return idEvento;
    }
    public String getDatoEmpresa()
    {
    return datoEmpresa;
    }
    public String getFecha()
    {
    return fecha;
    }
    public void setIdEmpresa(int id)
    {
    this.idEmpresa = id;
    }
    public void setIdEvento(int id)
    {
    this.idEvento = id;
    }
    public void setDatoEmpresa(String dato)
    {
    this.datoEmpresa = dato;
    }
    public void setFecha(String fecha)
    {
    this.fecha = fecha;
    }
    

    
    public DefaultTableModel BuscarEmpresa() throws SQLException{
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Codigo Empresa");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Pais");
        Object datos[]= new Object[5];
        String consulta =("SELECT id_empresa,nombreempresa,telefono,ciudad,pais FROM EMPRESA "
                + "WHERE nombreempresa LIKE'"+getDatoEmpresa()+"%'"
                + "OR ciudad LIKE'"+getDatoEmpresa()+"%'"
                + "OR pais LIKE'"+getDatoEmpresa()+"%'");
        try{
            declarar = conectarse.prepareStatement(consulta);
        resultado = declarar.executeQuery();
            while(resultado.next()){
                datos[0]=resultado.getInt(1);
                datos[1]=resultado.getString(2);
                datos[2]=resultado.getString(3);
                datos[3]=resultado.getString(4);
                datos[4]=resultado.getString(5);
                modelo.addRow(datos);                
                }
                return modelo;
            
        } 
        catch (SQLException ex) {
                   
            throw new SQLException(ex);
    }
   }
    
    public void listarMesaBox(JComboBox cbu){
      String consulta;
  try{
      consulta=("SELECT nombre_evento FROM EVENTO WHERE estado = 1");
      declarar=conectarse.prepareStatement(consulta);
      resultado=declarar.executeQuery();
      while(resultado.next())
      cbu.addItem(resultado.getString("nombre_evento"));
  }
  catch(Exception E){
   E.printStackTrace();
  }
}
    
public void Inscribir() throws SQLException
  {
      try {
        declarar = conectarse.prepareStatement("INSERT INTO REGISTRO_INSCRIPCION (id_evento, id_empresa,fecharegistro, estado) VALUES(?,?,?,1)");
        declarar.setInt(1, getIdEvento());
        declarar.setInt(2, getIdEmpresa());
        declarar.setString(3, getFecha());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Inscripcion Exitosa");
      } catch (SQLException ex) {
        throw new SQLException(ex);
      }
  }
}
