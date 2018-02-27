/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class Conexion {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "itmatica_poo";
    private static final String password = "1hQNX966S+cG";
    private static final String url = "jdbc:mysql://itmatica.net:3306/itmatica_poo";
    
    public Conexion()
    {
        conn = null;
        try
        {
          Class.forName(driver);
          conn = DriverManager.getConnection(url, user, password);
          if(conn != null)
          {
              System.out.println("Conexion establecida");
          }
        }
        catch(ClassNotFoundException | SQLException e)
          {
              System.out.println("Error al conectar"+e);
          }
    }
    
    public Connection getConection()
    {
        return conn;
    }
    public void desconectar()
    {
        conn = null;
        if(conn == null)
        {
            System.out.println("Conexion Terminada");
        }
    }
}