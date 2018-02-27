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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Jorge Augusto
 */
public class Citas extends Conexion
{
    private int id,participante, usuario, estado,empresa;
    private String hora,Enombre,Pnombre,Pnum,Pcorreo,Pape;
    private final String tabla;
    Connection conectarse = super.getConection();
    PreparedStatement declarar;
    ResultSet resultado;
    ResultSetMetaData resultData;
    DefaultTableModel dtm;
    public Citas()
    {
      this.tabla = "DETALLE_CITA";
      this.estado = 1;
    }
    public int getId()
    {
      return id;
    }
    public int getParticipante()
    {
      return participante;
    }
    public int getUsuario()
    {
      return usuario;
    }
    public int getEstado()
    {
      return estado;
    }
    public String getHora()
    {
      return hora;
    }
    public int getEmpresa()
    {
      return empresa;
    }
    public String getnombreEmpresa()
    {
    return Enombre;
    }
    public String getnombreParticipante()
    {
    return Pnombre;
    }
    public String  getNroIdentificacion()
    {
    return Pnum;
    }
    public String  getCorreo()
    {
    return Pcorreo;
    }
    public String  getPape()
    {
    return Pape;
    }
    public void setId(int id)
    {
      this.id = id;
    }
    public void setIdEmpresa(int idEmpresa) {
        this.empresa = idEmpresa;
    }
    public void setParticipante(int participante)
    {
      this.participante = participante;
    }
    public void setUsuario(int usuario)
    {
      this.usuario = usuario;
    }
    public void setEstado(int estado)
    {
      this.estado = estado;
    }
    public void setHora(String hora)
    {
      this.hora = hora;
    }
    public void setnombreEmpresa(String enom)
    {
      this.Enombre = enom;
    }
    public void setnombreParticipante(String partic)
    {
      this.Pnombre = partic;
    }
    public void setNroIdentificacion(String iden)
    {
      this.Pnum = iden;
    }
    public void setCorreo(String mail)
    {
      this.Pcorreo = mail;
    }
    public void setPape(String ape)
    {
      this.Pape = ape;
    }
    public void crearCita() throws SQLException
    {
      try {
        declarar = conectarse.prepareStatement("INSERT INTO " + this.tabla + "(ID_ASIGNA,ID_PARTICIPANTE,HORAASIGNADA,ESTADO) VALUES(?, ?, ?, ?)");
        declarar.setInt(1, getEmpresa());
        declarar.setInt(2, getParticipante());
        declarar.setString(3, getHora());
        declarar.setInt(4, getEstado());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos insertados");
      } catch (SQLException ex) {
        throw new SQLException(ex);
      }
    }
    public void listarCitas(JTable tabla) throws SQLException
    {
      try{
        declarar=conectarse.prepareStatement(
                "SELECT DETALLE_CITA.ID_DETALLECITA,EMPRESA.NOMBREEMPRESA,PARTICIPANTE.NOMBRE ,DETALLE_CITA.HORAASIGNADA,MESA.ID_MESA "
                + "FROM EMPRESA,PARTICIPANTE,MESA,ASIGNACION_MESA,DETALLE_CITA "
                + "WHERE EMPRESA.ID_EMPRESA = ASIGNACION_MESA.ID_EMPRESA "
                + "AND MESA.ID_MESA = ASIGNACION_MESA.ID_MESA "
                + "AND ASIGNACION_MESA.ID_ASIGNA = DETALLE_CITA.ID_ASIGNA "
                + "AND DETALLE_CITA.ID_PARTICIPANTE = PARTICIPANTE.ID_PARTICIPANTE "
                + "AND DETALLE_CITA.estado = ?");
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
    public void actualizarCita() throws SQLException
    {
      try {
        declarar = conectarse.prepareStatement("UPDATE " + this.tabla + " SET HORAASIGNADA = ? WHERE ID_RUBRO = ?");
        declarar.setString(1, getHora());
        declarar.setInt(2, getId());
        declarar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos Actualizados");
      } catch (SQLException ex) {
        throw new SQLException(ex);
      }
    }
    public void cancelarCita() throws SQLException
    {
      try {
        if (getEstado()==1)
        {
          declarar = conectarse.prepareStatement("UPDATE " + this.tabla + " SET  estado = ? WHERE ID_CITA = ?");
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
    public DefaultTableModel BuscarParticipante() throws SQLException{
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Codigo Participante");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Documento");
        modelo.addColumn("Email");
        Object datos[]= new Object[5];
        String consulta =("SELECT id_participante,nombre,apellido,num_documento,email FROM PARTICIPANTE WHERE nombre LIKE'"+getnombreParticipante()+"%'"
                + "AND estado = ? "
                + "OR apellido LIKE'"+getnombreParticipante()+"%'"
                + "OR num_documento LIKE'"+getnombreParticipante()+"%'"
                + "OR email LIKE'"+getnombreParticipante()+"%'");
        try{
            declarar = conectarse.prepareStatement(consulta);
            declarar.setInt(1, getEstado());
            resultado = declarar.executeQuery();
            while(resultado.next()){
                System.out.println("Existe Resultado");
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
        public DefaultTableModel BuscarEmpresa() throws SQLException{
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Codigo Asignacion");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Pais");
        Object datos[]= new Object[5];
        String consulta =("SELECT id_asigna,nombreempresa,telefono,ciudad,pais FROM EMPRESA,ASIGNACION_MESA,MESA "
                + "WHERE EMPRESA.id_empresa = ASIGNACION_MESA.id_empresa "
                + "AND ASIGNACION_MESA.id_mesa = MESA.id_mesa ");
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
        public DefaultTableModel Listar() throws SQLException{
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Numero de Cita");
        modelo.addColumn("Empresa a Citarse");
        modelo.addColumn("Representante");
        modelo.addColumn("Hora Asignada");
        modelo.addColumn("Nro Mesa");
        Object datos[]= new Object[5];
        String consulta =("SELECT DETALLE_CITA.ID_DETALLECITA,EMPRESA.NOMBREEMPRESA,PARTICIPANTE.NOMBRE ,DETALLE_CITA.HORAASIGNADA,MESA.ID_MESA "
                + "FROM EMPRESA,PARTICIPANTE,MESA,ASIGNACION_MESA,DETALLE_CITA "
                + "WHERE EMPRESA.ID_EMPRESA = ASIGNACION_MESA.ID_EMPRESA "
                + "AND MESA.ID_MESA = ASIGNACION_MESA.ID_MESA "
                + "AND ASIGNACION_MESA.ID_ASIGNA = DETALLE_CITA.ID_ASIGNA "
                + "AND DETALLE_CITA.ID_PARTICIPANTE = PARTICIPANTE.ID_PARTICIPANTE "
                + "AND DETALLE_CITA.estado = ?");
        try{
            declarar = conectarse.prepareStatement(consulta);
            resultado = declarar.executeQuery();
            while(resultado.next()){
                datos[0]=resultado.getInt(1);
                datos[1]=resultado.getString(2);
                datos[2]=resultado.getString(3);
                datos[3]=resultado.getString(4);
                datos[4]=resultado.getInt(5);
                modelo.addRow(datos);                
                }
                return modelo;
            
        } 
        catch (SQLException ex) {
                   
            throw new SQLException(ex);
    }
   }
}
