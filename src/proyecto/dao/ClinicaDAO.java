package proyecto.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyecto.db.Conexion;
import proyecto.entity.Clinica;

public class ClinicaDAO {

    public static Clinica getClinica(int numeroClinica) {
        final String QUERY = "SELECT * FROM poo_clinica\n" + "WHERE numeroClinica=?";

        Connection conexion = Conexion.getConexion();

        Clinica clinica = null;

        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            sentencia.setInt(1, numeroClinica);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next())
                clinica = new Clinica(resultado.getInt("id"), resultado.getInt("numeroClinica"),
                        resultado.getString("nombre"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clinica;
    }

    public static ArrayList<Clinica> getClinicas() {
        final String QUERY = "SELECT * FROM poo_clinica";

        ArrayList<Clinica> clinicas = new ArrayList<Clinica>();

        Connection conexion = Conexion.getConexion();
        
        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            ResultSet resultado = sentencia.executeQuery();

            
            while (resultado.next()){
                clinicas.add(new Clinica(
                    resultado.getInt("id"),
                    resultado.getInt("numeroClinica"),
                    resultado.getString("nombre")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return clinicas;
    }

    public static int crearClinica(Clinica clinica) {
        if (clinica == null)
            return -1;
        final String QUERY =    "INSERT INTO poo_clinica (numeroclinica, nombre,\n)" + 
                                "VALUES (?,?)";

        Connection conexion = Conexion.getConexion();

        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);

            sentencia.setInt(1, clinica.getNumeroClinica());
            sentencia.setString(2, clinica.getNombre());
            sentencia.executeUpdate();
            sentencia.close();

            conexion.close();
            return 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static int actualizarClinica(Clinica clinica) {
        if (clinica == null)
            return -1;
        final String QUERY =  "UPDATE poo_clinica SET \n" + 
                                "numeroClinica=?, \n" + 
                                "nombre=?, \n" + 
                                "WHERE id=?";

        Connection conexion = Conexion.getConexion();

        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);

            sentencia.setInt(1, clinica.getNumeroClinica());
            sentencia.setString(2, clinica.getNombre());

            sentencia.close();
            conexion.close();
            return 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return -1;
    }

    public static int borrarClinica(int numeroClinica) {
        final String QUERY = "DELETE FROM poo_clinica WHERE numeroClinica=?";

        Connection conexion = Conexion.getConexion();

        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);

            sentencia.setInt(1, numeroClinica);
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
