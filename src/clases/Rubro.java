/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Jorge Augusto
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

/**
 *
 * @author Jorge Augusto
 */
public class Rubro extends Conexion
{
  private String nombre,descripcionRubro;
  private final String tabla;
  private int Id,estado;
  Connection conectarse = super.getConection();
  PreparedStatement declarar;
  ResultSet resultado;
  ResultSetMetaData resultData;
  DefaultTableModel dtm;
  public Rubro()
  {
    this.tabla = "RUBRO";
    this.estado = 1;
  }
  public int getId()
  {
    return Id;
  }
  public String getNombre()
  {
    return nombre;
  }
  public String getDescripcion()
  {
    return descripcionRubro;
  }
  public int getEstado()
  {
    return estado;
  }
  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  public void setDescripcion(String nombre)
  {
    this.descripcionRubro = nombre;
  }
  public void setEstado(int estado)
  {
    this.estado = estado;
  }
  public void setId(int Id)
  {
    this.Id = Id;
  }

  public void crearRubro() throws SQLException
  {
      /*String tabla,valores,campos;
      tabla= "RUBRO";
      campos = "(nombre_rubro,descripcionRubro,estado)";
      valores = "('"+this.nombre+"','"+this.descripcionRubro+"','1' )";
      conexion.InsertarporParametros(tabla,campos,valores);*/
      try {
        declarar = conectarse.prepareStatement("INSERT INTO " + this.tabla + "(nombre_rubro,descripcionRubro,estado) VALUES(?, ?, ?)");
        declarar.setString(1, getNombre());
        declarar.setString(2, getDescripcion());
        declarar.setInt(3, getEstado());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos insertados");
      } catch (SQLException ex) {
        throw new SQLException(ex);
      }
  }
 public void listarRubro(JTable tabla) throws SQLException{
      try{
        declarar=conectarse.prepareStatement("SELECT ID_RUBRO,nombre_rubro,descripcionRubro,estado from "+this.tabla+" WHERE estado = ?");
        declarar.setInt(1, getEstado());
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
        dtm = (DefaultTableModel)tabla.getModel();
        for (int i = 0; i <datos.size(); i++) {
            dtm.addRow(datos.get(i));

        }

      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      dtm.fireTableDataChanged();
   }
  public void actualizarRubro() throws SQLException
  {
    try {
      declarar = conectarse.prepareStatement("UPDATE " + this.tabla + " SET nombre_rubro = ?, descripcionRubro = ? WHERE ID_RUBRO = ?");
      declarar.setString(1, getNombre());
      declarar.setString(2, getDescripcion());
      declarar.setInt(3, getId());
      declarar.executeUpdate();
      JOptionPane.showMessageDialog(null, "Datos Actualizados");
    } catch (SQLException ex) {
      throw new SQLException(ex);
    }
  }
  public void dardeBajaRubro() throws SQLException
  {
    try {
      if (getEstado()==1)
      {
        declarar = conectarse.prepareStatement("UPDATE " + this.tabla + " SET  estado = ? WHERE ID_RUBRO = ?");
        declarar.setInt(1, 0);
        declarar.setInt(2, getId());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Deshabilitacion exitosa");
      }
      else {
        JOptionPane.showMessageDialog(null, "Este rubro ya se dio de baja");
      }

    }
    catch (SQLException ex)
    {
      throw new SQLException(ex);
    }
  }
}
