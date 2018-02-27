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
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Alumno
 */
public class Mesa {
    private int idMesa, estado,idempresa;
    PreparedStatement declarar;
    Conexion con = new Conexion();
    Connection conectarse = con.getConection();
    ResultSet resultado;
    DefaultTableModel dtm;
    ResultSetMetaData resultData;
    
public Mesa()
{
this.idMesa = idMesa;
this.estado = 1;
}
  public int getIdMesa()
  {
    return idMesa;
  }
  public int getIdEmpresa()
  {
    return idempresa;
  }
  public int getEstado()
  {
    return estado;
  }
  public void SetIdMesa(int mesa)
  {
   this.idMesa = mesa;
  }
  public void SetIdEmpresa(int empresa)
  {
   this.idempresa = empresa;
  }
  
  public void CrearMesa() throws SQLException
  {
      try {
        declarar = conectarse.prepareStatement("INSERT INTO MESA (ESTADO) VALUES(?)");
        declarar.setInt(1, getEstado());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Nueva Mesa creada con Exito");
      } catch (SQLException ex) {
        throw new SQLException(ex);
      }
  }
  
   public void AsignarMesa() throws SQLException
  {
      try {
        declarar = conectarse.prepareStatement("INSERT INTO ASIGNACION_MESA (id_empresa, id_mesa,estado) VALUES(?,?,?)");
        declarar.setInt(1, getIdEmpresa());
        declarar.setInt(2, getIdMesa());
        declarar.setInt(3, getEstado());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Asignacion Exitosa");
      } catch (SQLException ex) {
        throw new SQLException(ex);
      }
  }
  
  public void dardeBajameMesa() throws SQLException
  {
    try {
      if (getEstado()==1)
      {
        declarar = conectarse.prepareStatement("UPDATE MESA SET  estado = ? WHERE ID_MESA = ?");
        declarar.setInt(1, 0);
        declarar.setInt(2, getIdMesa());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Deshabilitacion exitosa");
      }
      else {
        JOptionPane.showMessageDialog(null, "Este Mesa ya se dio de baja");
      }

    }
    catch (SQLException ex)
    {
      throw new SQLException(ex);
    }
  }
      public void listarMesa (JTable tabla) throws SQLException
    {
      try{
        declarar=conectarse.prepareStatement("SELECT ID_MESA from "+this.idMesa+" WHERE estado = ?");
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
      
   }
      
      
      
  public void listarMesaBox(JComboBox cbu){
      String consulta;
  try{
      consulta=("SELECT id_mesa FROM MESA WHERE estado = 1");
      declarar=conectarse.prepareStatement(consulta);
      resultado=declarar.executeQuery();
      while(resultado.next())
      cbu.addItem(resultado.getString("id_mesa"));
  }
  catch(Exception E){
   E.printStackTrace();
  }
}
    public void listarEmpresa(JComboBox cbu){
      String consulta;
  try{
      consulta=("SELECT nombreempresa FROM EMPRESA WHERE estado = 1");
      declarar=conectarse.prepareStatement(consulta);
      resultado=declarar.executeQuery();
      while(resultado.next())
      cbu.addItem(resultado.getString("nombreempresa"));
  }
  catch(Exception E){
   E.printStackTrace();
  }
}
}

