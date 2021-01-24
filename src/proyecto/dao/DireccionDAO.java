package proyecto.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proyecto.db.Conexion;
import proyecto.entity.Direccion;

public class DireccionDAO {

    public static Direccion getDireccion(int id) {
        final String QUERY = "SELECT * FROM poo_direccion\n" +
                                "WHERE persona_id=?";

                              
        Connection conexion = Conexion.getConexion();

        Direccion direccion = null;
        
         try {
             PreparedStatement sentencia = conexion.prepareStatement(QUERY);
             sentencia.setInt(1, id);
             ResultSet resultado = sentencia.executeQuery();

             if(resultado.next())
                 direccion = new Direccion(
                     resultado.getInt("id"),
                     resultado.getString("calle"),
                     resultado.getString("numeroExterior"),
                     resultado.getString("NumeroInterior"),
                     resultado.getString("colonia"),
                     resultado.getInt("codigoPostal"),
                     resultado.getString("delegacionMunicipio"),
                     resultado.getString("estado"),
                     resultado.getInt("persona_id")
                 );
         } catch (SQLException e) {
             System.out.println(e.getMessage());
           } 
         return direccion;
    }

    public static ArrayList<Direccion> getDirecciones() {
        final String QUERY = "SELECT * FROM poo_direccion";

        ArrayList<Direccion> direcciones = new ArrayList<Direccion>();

        Connection conexion = Conexion.getConexion();
        
        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            ResultSet resultado = sentencia.executeQuery();

            
            while (resultado.next()){
                direcciones.add(new Direccion(
                    resultado.getInt("id"),
                    resultado.getString("calle"),
                    resultado.getString("numeroExterior"),
                    resultado.getString("NumeroInterior"),
                    resultado.getString("colonia"),
                    resultado.getInt("codigoPostal"),
                    resultado.getString("delegacionMunicipio"),
                    resultado.getString("estado"),
                    resultado.getInt("persona_id")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return direcciones;
    }


    public static int crearDireccion(Direccion direccion) {
         if(direccion == null) return -1;
         final String QUERY_1 = "INSERT INTO direccion VALUES (?,?,?,?,?,?,?,?)";
        
         Connection conexion = Conexion.getConexion();
        
         try {
             PreparedStatement sentencia = conexion.prepareStatement(QUERY_1);
             sentencia.setString(1, direccion.getCalle());
             sentencia.setString(2, direccion.getNumeroExterior());
             sentencia.setString(3, direccion.getNumeroInterior());
             sentencia.setString(4, direccion.getColonia());
             sentencia.setInt(5, direccion.getCodigoPostal());
             sentencia.setString(6, direccion.getDelegacionMunicipio());
             sentencia.setString(7, direccion.getEstado());
             sentencia.setInt(8, direccion.getPersona_id());
             sentencia.executeUpdate();
             sentencia.close();
            
             conexion.close();
             return 0;
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         } 
         return -1;
 }


    public static int actualizarDireccion(Direccion direccion) {
         if(direccion == null) return -1;
         final String QUERY_1 = "UPDATE poo_direccion SET \n" +
                                 "calle=?, \n" +
                                 "numeroExterior=?, \n" +
                                 "NumeroInterior=?, \n" +
                                 "colonia=?, \n" +
                                 "codigoPostal=?, \n" +
                                 "delegacionMunicipio=?, \n" +
                                 "estado=?, \n" +
                                 "persona_id=?, \n" +
                                 "WHERE id=?";
        
        Connection conexion = Conexion.getConexion();
        
        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY_1, Statement.RETURN_GENERATED_KEYS);
            
             sentencia.setString(1, direccion.getCalle());
             sentencia.setString(2, direccion.getNumeroExterior());
             sentencia.setString(3, direccion.getNumeroInterior());
             sentencia.setString(4, direccion.getColonia());
             sentencia.setInt(5, direccion.getCodigoPostal());
             sentencia.setString(6, direccion.getDelegacionMunicipio());
             sentencia.setString(7, direccion.getEstado());
             sentencia.setInt(8, direccion.getPersona_id());
            
             sentencia.close();
            
             conexion.close();
             return 0;
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
         return -1;
    }

    
    public static int borrarDireccion(int id) {
         final String QUERY = "DELETE FROM poo_direccion WHERE persona_id=?";

         Connection conexion = Conexion.getConexion();

         try {
             PreparedStatement sentencia = conexion.prepareStatement(QUERY);

             sentencia.setInt(1, id);
             sentencia.executeUpdate();
            
             conexion.commit();
             conexion.close();
             return 0;
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         } 
         return -1;
    }
}




