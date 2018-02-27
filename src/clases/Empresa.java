
package clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Empresa {
     //ATRIBUTOS
    private int codEmpresa,estado;
    private String nombre,persona;
    private String direccion;
    private String pais;
    private String ciudad;
    private String telefono;
    private String email;
    private String website;
    public int idrubro;
    public String tipo;
  
     //Conexion BD
    Conexion con=new Conexion();
    Connection cn=con.getConection();
    
    
     //CONSTRUCTOR
    public Empresa(){
        this.codEmpresa=0;
        this.nombre="";
        this.direccion="";
        this.pais="";        
        this.ciudad="";
        this.telefono="";
        this.email="";
        this.website="";
        this.tipo="";
        this.estado=1;
    
    } 
     public Empresa(int codEmpresa, String nombre,String direccion,String pais,String ciudad,
                    String telefono,String email,String website,int idrubro,String tipo,String persona){
        this.codEmpresa=codEmpresa;
        this.nombre=nombre;
        this.direccion=direccion;
        this.pais=pais;
        this.ciudad=ciudad;
        this.telefono=telefono;
        this.email=email;
        this.website=website;
        this.idrubro=idrubro;
        this.tipo=tipo;
        this.persona = persona;
        
    }
      //METODOS DE ACCESO
    public void setcodEmpresa(int codEmpresa){
        this.codEmpresa=codEmpresa;
    }
    public int getcodEmpresa(){
        return this.codEmpresa;
    }
    public void setnombre(String nombre){
         this.nombre=nombre;
    }
    public String getnombre(){
        return this.nombre;
    }  
   
    public void setdireccion(String direccion){
         this.direccion=direccion;
    }
    public String getdireccion(){
        return this.direccion;
    }
      public void setpais(String pais){
         this.pais=pais;
    }
    public String getpais(){
        return this.pais;
    }
    public void setciudad(String ciudad){
         this.ciudad=ciudad;
    }
    public String getciudad(){
        return this.ciudad;
    }
    public void settelefono(String telefono){
        this.telefono=telefono;
    }
    public String gettelefono(){
        return this.telefono;
    }
    public void setemail(String email){
         this.email=email;
    }
    public String getemail(){
        return this.ciudad;
    }
    public void setwebsite(String website){
         this.website=website;
    }
    public String getwebsite(){
        return this.website;
    }
   public void setidrubro(int idrubro){
       this.idrubro=idrubro;
   }
   public int getidrubro(){
       return this.idrubro;
   }
     public void settipo(String tipo){
         this.tipo=tipo;
    }
    public String gettipo(){
        return this.tipo;
    }
   
   public int getEstado(){
        return this.estado;
    }
   public void setEstado(int estado){
         this.estado=estado;
    }
   public String getPersona(){
        return this.persona;
    }
    public void setPersona(String persona){
         this.persona=persona;
    }
    public boolean InsertarEmpresa(){
        boolean resp=false;
        if(ExisteEmpresa()==false){
            try{
                PreparedStatement pps=cn.prepareStatement("INSERT INTO EMPRESA (ID_RUBRO,NOMBREEMPRESA,DIRECCION,CIUDAD,PAIS, "
                        + "TELEFONO,EMAIL,PAGINAWEB,TIPO,PERSONACONTACTO,ESTADO)VALUE(?,?,?,?,?,?,?,?,?,?,?)");
                pps.setInt(1, getidrubro());
                pps.setString(2, this.nombre);
                pps.setString(3,this.direccion);
                pps.setString(4, this.ciudad);
                pps.setString(5,this.pais);
                pps.setString(6,this.telefono);
                pps.setString(7, this.email);
                pps.setString(8, this.website);
                pps.setString(9, this.tipo);
                pps.setString(10, getPersona());
                pps.setInt(11, 1);
                pps.execute();
                con.desconectar();
                JOptionPane.showMessageDialog(null, "Empresa Registrada con Exito");
                resp=true;
                 }
            catch(SQLException e){
                System.out.println("Error no se pudo Registrar a la Empresa "+e);
                }
        }
        else{
            System.out.println("Ya existe la Empresa");
        }
        return resp;
    }
         public boolean ExisteEmpresa(){
            boolean existe=false;
            String sql="SELECT * FROM EMPRESA WHERE NOMBREEMPRESA='"+this.nombre+"' and DIRECCION='"+this.direccion+"'";
            Statement st;
            try{
                st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                while(rs.next()){
                    existe=true;
                    System.out.println("Existe Empresa");
                }
            
            }
            catch(SQLException e){
                System.out.println("Error en la consulta");
            
            }
        return existe;
        }
         
    public DefaultTableModel BuscarEmpresa() throws SQLException{
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("codEmpresa");
        modelo.addColumn("Nombre Empresa");
        modelo.addColumn("Direccion");
        modelo.addColumn("Pais");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        modelo.addColumn("Web Site");
        modelo.addColumn("Rubro");
        modelo.addColumn("Estado");
        String sql="SELECT * FROM EMPRESA WHERE nombreempresa LIKE'"+this.nombre+"%'";
     
        String datos[]=new String[10];
        Statement st;
        try{
            st= cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.println("Existe Resultado");
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                modelo.addRow(datos);                
                }
                return modelo;
            
        } 
        catch (SQLException e) {
                   
            System.out.println("Error en la Busqueda " + e);
                 return null;   
        }
    }
    public boolean EliminarEmpresa(){
        boolean resp=false;
        try{
            PreparedStatement pps;
            pps= cn.prepareStatement("DELETE FROM empresa WHERE codEmpresa="+this.codEmpresa);
            pps.executeUpdate();
            System.out.println("Se elimino correctamente");
            resp=true;
            con.desconectar();
        }catch(SQLException ex){
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("error no se pudo eliminar");
            JOptionPane.showMessageDialog(null,"error no se pudo eliminar los datos");
        }
    return resp;
    }
    public boolean ModificarEmpresa(boolean modfecha,boolean mismaEmpresa) {
        boolean resp=false;
       boolean modificar= false;
       if(mismaEmpresa){
           modificar= true;
       }
       else{
           if(ExisteEmpresa()==false){
                modificar= true;
            }
       }
        if(modificar==true){
            try{
                PreparedStatement pps;
                if(modfecha ==true){   
                 pps=cn.prepareStatement("UPDATE empresa SET nombre='"+this.nombre+"',direccion="+this.direccion+",pais="+this.pais+",ciudad='"+this.ciudad+"',telefono="+this.telefono+",email='"+this.email+"',website='"+this.website+
               "' WHERE codempresa="+this.codEmpresa);

                }
                else{                    
                   pps = cn.prepareStatement("UPDATE empresa SET nombre='"+this.nombre+"',direccion="+this.direccion+",ciudad="+this.ciudad+",telefono='"+this.telefono+"',email="+this.email+",ciudad='"+this.ciudad+"' WHERE codempresa="+this.codEmpresa);
                }
                pps.executeUpdate();
                System.out.println("se modifico correctamente");
                resp=true;
                con.desconectar();
            } catch(SQLException ex){
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE,null,ex);
                System.out.println("error no se puede modificar");
                JOptionPane.showMessageDialog(null,"error no se modificaron los datos" );
            }    
        }
        else{
            System.out.println("Error Cliente ya existe");
        }
        return resp;
        }
    
    public void ObtenerAtributos(int codEmp){
        String sql = "SELECT * FROM empresa WHERE codEmpresa ="+codEmp;
        Statement st ;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){

                this.nombre = rs.getString(2);
                this.direccion = rs.getString(3);
                this.pais = rs.getString(4);
                this.ciudad = rs.getString(5); 
                this.telefono = rs.getString(6);
                this.email = rs.getString(7);
                this.website = rs.getString(8);
                this.idrubro = rs.getInt(9);
                this.tipo = rs.getString(10);
            }
        } catch (SQLException e) {
            System.out.println("Error en la busqueda "+e);

        }
    } 
public void listarEmpresaCbox(JComboBox cbu, String consulta){
  try{
      ResultSet rt;
      PreparedStatement pps;
      consulta=("SELECT * FROM RUBRO WHERE estado = 1");
      pps=cn.prepareStatement(consulta);
      rt=pps.executeQuery();
      while(rt.next())
      cbu.addItem(rt.getString("nombre_rubro"));
      cbu.setSelectedIndex(-1);
  }
  catch(Exception E){
   E.printStackTrace();
  }
}
}
