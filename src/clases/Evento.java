/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author BETO
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Evento extends Conexion
{
  private String nombreE, sigla, fecha, horaIni, horaFin, tabla;

    

 
  private int estado;
  Connection conectarse = super.getConection();
  PreparedStatement declarar;
  ResultSet resultado;
  ResultSetMetaData resultData;
  public Evento(String nombreE, String fecha, String horaIni, String horaFin, String sigla)
  {
     
    this.nombreE = nombreE;
    this.sigla = sigla;
    this.fecha = fecha;
    this.horaIni = horaIni;
    this.horaFin = horaFin;
    this.tabla = "EVENTO";
    this.estado = 1;
  }
  public String getNombre()
  {
    return nombreE;
  }
  public String getSigla()
  {
    return sigla;
  }
     public String getFecha() {
        return fecha;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public String getHoraFin() {
        return horaFin;
    }
  public int getEstado()
  {
    return estado;
  }
  public void setNombre(String nombre)
  {
    this.nombreE = nombre;
  }
  public void setSigla(String sigla)
  {
    this.sigla = sigla;
  }
  public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
  public void setEstado(int estado)
  {
    this.estado = estado;
  }
  public void crearEvento() throws SQLException
  {
    
      try {
        declarar = conectarse.prepareStatement("INSERT INTO " + this.tabla + "(nombre_evento, fecha_evento, hora_inicio, hora_fin, sigla, estado) VALUES(?, ?, ?, ?, ?, ?)");
        declarar.setString(1, getNombre());
        declarar.setString(2, getFecha());
        declarar.setString(3, getHoraIni());
        declarar.setString(4, getHoraFin());
        declarar.setString(5, getSigla());
        declarar.setInt(6, getEstado());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos insertados");
      } catch (Exception e) {
        throw new SQLException(e);
      }
  }
  public void listarEvento(JTable tabla) throws SQLException{
      try{
        declarar= conectarse.prepareStatement("SELECT nombre_evento, fecha_evento, hora_inicio, hora_fin, sigla, estado from EVENTO");
        resultado=declarar.executeQuery();
        resultData=resultado.getMetaData();
        ArrayList<Object[]> datos=new ArrayList<>();
        while (resultado.next()) {            
            Object[] filas=new Object[resultData.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i]=resultado.getObject(i+1);  
            }
            datos.add(filas);
        }
        DefaultTableModel dtm = (DefaultTableModel)tabla.getModel();
        for (int i = 0; i <datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }
         
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      
   }
  public void actualizarEvento() throws SQLException
  {
    try {
      declarar = conectarse.prepareStatement("UPDATE " + this.tabla + " SET nombre_evento = ?, fecha_evento = ?, hora_inicio = ?, hora_fin = ?, sigla = ?, estado WHERE nombre_evento = ?");
      declarar.setString(1, getNombre());
      declarar.setString(2, getFecha());
      declarar.setString(3, getHoraIni());
      declarar.setString(4, getHoraFin());
      declarar.setString(5, getSigla());
      declarar.setString(6, getNombre());
      declarar.executeUpdate();
      JOptionPane.showMessageDialog(null, "Datos Actualizados");
    } catch (Exception e) {
      throw new SQLException(e);
    }
  }
  public void dardeBajaEvento() throws SQLException
  {
    try {
      if (getEstado()==1)
      {
        declarar = conectarse.prepareStatement("UPDATE " + this.tabla + " SET  estado = ? WHERE nombre_evento = ?");
        declarar.setInt(1, 0);
        declarar.setString(2, getNombre());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Baja exitosa");
      }
      else {
        JOptionPane.showMessageDialog(null, "Este evento ya se dio de baja");
      }

    }
    catch (Exception e)
    {
      throw new SQLException(e);
    }
  }

}