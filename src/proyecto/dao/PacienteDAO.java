package proyecto.dao;

import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proyecto.db.Conexion;
import proyecto.entity.Paciente;

public class PacienteDAO {

public static Paciente getPaciente(int numeroPaciente) {
        final String QUERY = "SELECT ps.id, ps.nombre, ps.apellidoPaterno,\n" +
                             "ps.apellidoMaterno, ps.fechaNacimiento, ps.telefono,\n" +
                             "ps.correoElectronico, ps.usuario, pc.numeroPaciente\n" +
                             "FROM poo_paciente pc INNER JOIN\n" +
                             "poo_persona ps ON pc.persona_id = ps.id\n" +
                             "WHERE pc.numeroPaciente=?";
        
        Connection conexion = Conexion.getConexion();

        Paciente paciente = null;
        
        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            sentencia.setInt(1, numeroPaciente);
            ResultSet resultado = sentencia.executeQuery();

            if(resultado.next())
                paciente = new Paciente(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("apellidoPaterno"),
                    resultado.getString("apellidoMaterno"),
                    resultado.getDate("fechaNacimiento"),
                    resultado.getString("telefono"),
                    resultado.getString("correoElectronico"),
                    resultado.getString("usuario"), "",
                    resultado.getInt("numeroPaciente")
                );

                conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paciente;
    }

    public static ArrayList<Paciente> getPacientes() {
        final String QUERY = "SELECT ps.id, ps.nombre, ps.apellidoPaterno,\n" +
                                "ps.apellidoMaterno, ps.fechaNacimiento, ps.telefono,\n" +
                                "ps.correoElectronico, ps.usuario, pc.numeroPaciente\n" + 
                                "FROM poo_paciente pc INNER JOIN\n" +
                                "poo_persona ps ON pc.persona_id = ps.id";

        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        Connection conexion = Conexion.getConexion();
        
        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            ResultSet resultado = sentencia.executeQuery();

            
            while (resultado.next()){
                pacientes.add(new Paciente(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("apellidoPaterno"),
                    resultado.getString("apellidoMaterno"),
                    resultado.getDate("fechaNacimiento"),
                    resultado.getString("telefono"),
                    resultado.getString("correoElectronico"),
                    resultado.getString("usuario"), "",
                    resultado.getInt("numeroPaciente")
                ));
            }
            conexion.close();
            return pacientes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return pacientes;
    }

    public static int crearPaciente(Paciente paciente) {
        if(paciente == null) return -1;
        final String QUERY_1 =  "INSERT INTO poo_persona (nombre, apellidoPaterno,\n" +
                                "apellidoMaterno, fechaNacimiento, telefono,\n" +
                                "correoElectronico, usuario, contrasenia)\n" +
                                "VALUES (?,?,?,?,?,?,?,?)";
        final String QUERY_2 =  "INSERT INTO poo_paciente (numeroPaciente, persona_id)\n"+
                                "VALUES (?,?)";
        
        
        Connection conexion = Conexion.getConexion();
        
        try {           
            PreparedStatement sentencia = conexion.prepareStatement(QUERY_1);
            
            sentencia.setString(1, paciente.getNombre());
            sentencia.setString(2, paciente.getApellidoPaterno());
            sentencia.setString(3, paciente.getApellidoMaterno());
            sentencia.setDate(4, paciente.getFechaNacimiento());
            sentencia.setString(5, paciente.getCorreoElectronico());
            sentencia.setString(6, paciente.getTelefono());
            sentencia.setString(7, paciente.getUsuario());
            sentencia.setString(8, paciente.getContrasenia());
            sentencia.executeUpdate();
            int idPersona = sentencia.executeUpdate();

            sentencia = conexion.prepareStatement(QUERY_2);
            sentencia.setInt(1, paciente.getNumeroPaciente());
            sentencia.setInt(2, idPersona);
            sentencia.executeUpdate();
            
            conexion.commit();
            conexion.close();
            return 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static int actualizarPaciente(Paciente paciente) {
        if(paciente == null) return -1;
        final String QUERY_1 = "UPDATE poo_persona SET \n" +
                                "nombre=?, \n" +
                                "apellidoPaterno=?, \n" +
                                "apellidoMaterno=?, \n" +
                                "fechaNacimiento=?, \n" +
                                "telefono=?, \n" +
                                "correoElectronico=?, \n" +
                                "usuario=?, \n" +
                                "contrasenia=? \n" +
                                "WHERE id=?";
        final String QUERY_2 = "UPDATE poo_paciente SET numeroPaciente=?\n" + 
                                "WHERE persona_id=?";
        
        
        
        Connection conexion = Conexion.getConexion();
        
        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY_1, Statement.RETURN_GENERATED_KEYS);
            
            sentencia.setString(1, paciente.getNombre());
            sentencia.setString(2, paciente.getApellidoPaterno());
            sentencia.setString(3, paciente.getApellidoMaterno());
            sentencia.setDate(4, paciente.getFechaNacimiento());
            sentencia.setString(5, paciente.getCorreoElectronico());
            sentencia.setString(6, paciente.getTelefono());
            sentencia.setString(7, paciente.getUsuario());
            sentencia.setString(8, paciente.getContrasenia());
            sentencia.setInt(9, paciente.getId());
            sentencia.executeUpdate();
            sentencia.close();

            sentencia = conexion.prepareStatement(QUERY_2);
            sentencia.setInt(1, paciente.getNumeroPaciente());
            sentencia.setInt(2, paciente.getId());
            sentencia.executeUpdate();
            
            conexion.commit();
            conexion.close();
            return 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static int borrarPaciente(int numeroPaciente) {
        final String QUERY = "DELETE FROM poo_paciente WHERE numeroPaciente=?";

        Connection conexion = Conexion.getConexion();

        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);

            sentencia.setInt(1, numeroPaciente);
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
