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
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TINO
 */
public class Participante extends Conexion {

    private int Id, estado;
    private String nombre, apellido, cargo, documento, num_documento, genero, telefono, celular, email;
    private final String tabla;
    Connection conectarse = super.getConection();
    PreparedStatement declarar;
    ResultSet resultado;
    ResultSetMetaData resultData;
    DefaultTableModel dtm;

    public Participante() {
        this.tabla = "PARTICIPANTE";
        this.estado = 1;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void crearParticipante() throws SQLException {
        try {
            declarar = conectarse.prepareStatement("INSERT INTO " + this.tabla + "(nombre,apellido,cargo,num_documento,documento,genero,telefono,celular,email,estado) VALUES(?,?,?,?,?,?,?,?,?,?)");
            declarar.setString(1, getNombre());
            declarar.setString(2, getApellido());
            declarar.setString(3, getCargo());
            declarar.setString(4, getNum_documento());
            declarar.setString(5, getDocumento());
            declarar.setString(6, getGenero());
            declarar.setString(7, getTelefono());
            declarar.setString(8, getCelular());
            declarar.setString(9, getEmail());
            declarar.setInt(10, getEstado());
            declarar.executeUpdate();
             
            JOptionPane.showMessageDialog(null, "Datos insertados");
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void listarParticipante(JTable tabla) throws SQLException {
        try {
            declarar = conectarse.prepareStatement("SELECT ID_PARTICIPANTE,nombre,apellido,cargo,num_documento,documento,genero,telefono,celular,email,estado from " + this.tabla + " WHERE estado = ?");
            declarar.setInt(1, getEstado());
            resultado = declarar.executeQuery();
            resultData = resultado.getMetaData();
            ArrayList<Object[]> datos = new ArrayList<>();
            while (resultado.next()) {
                Object[] filas = new Object[resultData.getColumnCount()];
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = resultado.getObject(i + 1);
                }
                datos.add(filas);

            }
            dtm = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < datos.size(); i++) {
                dtm.addRow(datos.get(i));

            }

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

        dtm.fireTableDataChanged();
    }

    public void actualizarParticipante() throws SQLException {
        try {
            declarar = conectarse.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, apellido = ?, cargo=?,num_documento=? , documento=?, genero=?, telefono=?, celular=?, email=? WHERE ID_PARTICIPANTE = ?");

            declarar.setString(1, getNombre());
            declarar.setString(2, getApellido());
            declarar.setString(3, getCargo());
            declarar.setString(4, getNum_documento());
            declarar.setString(5, getDocumento());
            declarar.setString(6, getGenero());
            declarar.setString(7, getTelefono());
            declarar.setString(8, getCelular());
            declarar.setString(9, getEmail());
            declarar.setInt(10, getId());
            declarar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void dardeBajaParticipante() throws SQLException {
        try {
            if (getEstado() == 1) {
                declarar = conectarse.prepareStatement("UPDATE " + this.tabla + " SET  estado = ? WHERE ID_PARTICIPANTE = ?");
                declarar.setInt(1, 0);
                declarar.setInt(2, getId());
                declarar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deshabilitacion exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Este participante ya se dio de baja");
            }

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
}
