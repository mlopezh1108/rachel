package proyecto.dao;

import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proyecto.db.Conexion;
import proyecto.entity.Doctor;

public class DoctorDAO {
    // public static Doctor getPaciente(int id) {
    //     final String QUERY = "SELECT ps.id, ps.nombre, ps.apellidoPaterno,\n" +
    //                          "ps.apellidoMaterno, ps.fechaNacimiento, ps.telefono,\n" +
    //                          "ps.correoElectronico, ps.usuario, em.numeroEmpleado\n" +
    //                          "em.salario, em.fechaIngreso, dc.cedula\n" +
    //                          "FROM empleado em INNER JOIN\n" +
    //                          "persona ps ON em.persona_id = ps.id\n" +
    //                          "INNER JOIN doctor dc ON dc.empleado_id = em.id\n" +
    //                          "WHERE ps.id=?";
        
    //     Connection conexion = Conexion.getConexion();

    //     Doctor paciente;
        
    //     try {
    //         PreparedStatement sentencia = conexion.prepareStatement(QUERY);
    //         sentencia.setInt(1, id);
    //         ResultSet resultado = sentencia.executeQuery();

    //         if(resultado.next())
    //             paciente = new Doctor(
    //                 resultado.getInt("id"),
    //                 resultado.getString("nombre"),
    //                 resultado.getString("apellidoPaterno"),
    //                 resultado.getString("apellidoMaterno"),
    //                 resultado.getDate("fechaNacimiento"),
    //                 resultado.getString("telefono"),
    //                 resultado.getString("correoElectronico"),
    //                 resultado.getString("usuario"), "",
    //                 resultado.getInt("numeroPaciente")
    //             );

    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     } finally {
    //         conexion.close();
    //     }
    //     return paciente;
    // }

    // public static ArrayList<Doctor> getPacientes() {
    //     final String QUERY = "SELECT ps.id, ps.nombre, ps.apellidoPaterno,\n" +
    //                             "ps.apellidoMaterno, ps.fechaNacimiento, ps.telefono,\n" +
    //                             "ps.correoElectronico, ps.usuario, pc.numeroPaciente\n" + 
    //                             "FROM paciente pc INNER JOIN\n" +
    //                             "persona ps ON pc.persona_id = ps.id";

    //     final ArrayList<Doctor> pacientes = new ArrayList<Doctor>();

    //     Connection conexion = Conexion.getConexion();
        
    //     try {
    //         PreparedStatement sentencia = conexion.prepareStatement(QUERY);
    //         ResultSet resultado = sentencia.executeQuery();
            
    //         while (resultado.next())
    //             pacientes.add(
    //                 new Doctor(
    //                     resultado.getInt("id"),
    //                     resultado.getString("nombre"),
    //                     resultado.getString("apellidoPaterno"),
    //                     resultado.getString("apellidoMaterno"),
    //                     resultado.getDate("fechaNacimiento"),
    //                     resultado.getString("telefono"),
    //                     resultado.getString("correoElectronico"),
    //                     resultado.getString("usuario"), "",
    //                     resultado.getInt("numeroPaciente")
    //                 )
    //             );
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     } finally {
    //         conexion.close();
    //     }
    //     return pacientes;
    // }

    // public static int crearPaciente(Doctor paciente) {
    //     if(paciente == null) return -1;
    //     final String QUERY_1 = "INSERT INTO persona VALUES (?,?,?,?,?,?,?,?)";
    //     final String QUERY_2 = "INSERT INTO paciente VALUES (?,(\n" + 
    //                            "SELECT id FROM persona WHERE usuario=?))";
        
    //     MessageDigest digest = MessageDigest.getInstance("SHA-256");        
    //     byte[] hash = digest.digest(paciente.getContrasenia().getBytes(StandardCharsets.UTF_8));
        
    //     Connection conexion = Conexion.getConexion();
        
    //     try {
    //         PreparedStatement sentencia = conexion.prepareStatement(QUERY_1);
            
    //         sentencia.setString(1, paciente.getNombre());
    //         sentencia.setString(2, paciente.getApellidoPaterno());
    //         sentencia.setString(3, paciente.getApellidoMaterno());
    //         sentencia.setDate(4, paciente.getFechaNacimiento());
    //         sentencia.setString(5, paciente.getCorreoElectronico());
    //         sentencia.setString(6, paciente.getTelefono());
    //         sentencia.setString(7, paciente.getUsuario());
    //         sentencia.setString(8, hash.toString());
    //         sentencia.executeUpdate();
    //         sentencia.close();

    //         sentencia = conexion.prepareStatement(QUERY_2);
    //         sentencia.setInt(1, paciente.getNumeroPaciente());
    //         sentencia.setString(2, paciente.getUsuario());
    //         sentencia.executeUpdate();
            
    //         conexion.close();
    //         return 0;
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     } finally {
    //         conexion.close();
    //     }
    //     return -1;
    // }

    // public static int actualizarPaciente(Doctor paciente) {
    //     if(paciente == null) return -1;
    //     final String QUERY_1 = "UPDATE persona SET \n" +
    //                             "nombre=?, \n" +
    //                             "apellidoPaterno=?, \n" +
    //                             "apellidoMaterno=?, \n" +
    //                             "fechaNacimiento=?, \n" +
    //                             "telefono=?, \n" +
    //                             "correoElectronico=?, \n" +
    //                             "usuario=?, \n" +
    //                             "contrasenia=?, \n" +
    //                             "WHERE id=?";
    //     final String QUERY_2 = "UPDATE paciente SET numeroPaciente=?\n" + 
    //                             "WHERE persona_id=?";
        
    //     MessageDigest digest = MessageDigest.getInstance("SHA-256");        
    //     byte[] hash = digest.digest(paciente.getContrasenia().getBytes(StandardCharsets.UTF_8));
        
    //     Connection conexion = Conexion.getConexion();
        
    //     try {
    //         PreparedStatement sentencia = conexion.prepareStatement(QUERY_1, Statement.RETURN_GENERATED_KEYS);
            
    //         sentencia.setString(1, paciente.getNombre());
    //         sentencia.setString(2, paciente.getApellidoPaterno());
    //         sentencia.setString(3, paciente.getApellidoMaterno());
    //         sentencia.setDate(4, paciente.getFechaNacimiento());
    //         sentencia.setString(5, paciente.getCorreoElectronico());
    //         sentencia.setString(6, paciente.getTelefono());
    //         sentencia.setString(7, paciente.getUsuario());
    //         sentencia.setString(8, hash.toString());
    //         sentencia.setInt(9, paciente.getId());
    //         int idPersona = sentencia.executeUpdate();
    //         sentencia.close();

    //         sentencia = conexion.prepareStatement(QUERY_2);
    //         sentencia.setInt(1, paciente.getNumeroPaciente());
    //         sentencia.setInt(2, paciente.getId());
    //         sentencia.executeUpdate();
            
    //         conexion.close();
    //         return 0;
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     } finally {
    //         conexion.close();
    //     }
    //     return -1;
    // }

    // public static int borrarPaciente(int id) {
    //     final String QUERY = "DELETE FROM paciente WHERE persona_id=?";

    //     Connection conexion = Conexion.getConexion();

    //     try {
    //         PreparedStatement sentencia = conexion.prepareStatement(QUERY);

    //         sentencia.setInt(id);
    //         sentencia.executeUpdate();
            
    //         conexion.close();
    //         return 0;
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     } finally {
    //         conexion.close();
    //     }
    //     return -1;
    // }
}
