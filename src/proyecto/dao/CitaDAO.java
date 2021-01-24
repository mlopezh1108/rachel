package dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CitaDAO{

//      public static Cita getCita(int id) {
//         final String QUERY = "SELECT * FROM cita\n" +
//                              "WHERE ps.id=?";
        
//         Connection conexion = Conexion.getConexion();

//         Cita cita;

//         try {
//             PreparedStatement sentencia = conexion.prepareStatement(QUERY);
//             sentencia.setInt(1, id);
//             ResultSet resultado = sentencia.executeQuery();

//             if(resultado.next())
//                 cita = new Cita(
//                     resultado.getInt("id"),
//                     resultado.getDate("fecha"),
//                     resultado.getTime("hora"),
//                 );

//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } finally {
//             conexion.close();
//         }
//         return cita;
//     }

//    public static ArrayList<Cita> getCitas() {
//         final String QUERY = "SELECT * FROM cita\n" +
//                              "WHERE persona_id=?";  

//         final ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

//         Connection conexion = Conexion.getConexion();
        
//         try {
//             PreparedStatement sentencia = conexion.prepareStatement(QUERY);
//             ResultSet resultado = sentencia.executeQuery();
            
//             while (resultado.next())
//                 citas.add(
//                     new Citas(
//                         resultado.getInt("id"),
//                         resultado.getDate("fecha"),
//                         resultado.getTime("hora")
//                 );
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } finally {
//             conexion.close();
//         }
//         return citas;
//    }

// public static int crearCita(Cita cita) {
//         if(cita == null) return -1;
//         final String QUERY_1 = "INSERT INTO persona VALUES (?,?)";
//         final String QUERY_2 = "INSERT INTO paciente VALUES (?,(\n" + 
//                                "SELECT id FROM persona WHERE usuario=?))";
        
//         MessageDigest digest = MessageDigest.getInstance("SHA-256");        
//         byte[] hash = digest.digest(paciente.getContrasenia().getBytes(StandardCharsets.UTF_8));
        
//         Connection conexion = Conexion.getConexion();
        
//         try {
//             PreparedStatement sentencia = conexion.prepareStatement(QUERY_1);
            
//             sentencia.setDate(1,cita.getFecha());
//             sentencia.setTime(2,cita.getHora());
//             sentencia.executeUpdate();
//             sentencia.close();

//             sentencia = conexion.prepareStatement(QUERY_2);
//             sentencia.setInt(1, cita.getNumeroPaciente());
//             sentencia.setString(2, cita.getUsuario());
//             sentencia.executeUpdate();
            
//             conexion.close();
//             return 0;
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } finally {
//             conexion.close();
//         }
//         return -1;
//     }
    
//   public static int actualizarCita(Cita cita) {
//         if(cita == null) return -1;
//         final String QUERY_1 = "UPDATE cita SET \n" +
//                                 "fecha=?, \n" +
//                                 "hora=?, \n" +
//                                 "WHERE id=?";
//         final String QUERY_2 = "UPDATE cita SET numeroCita=?\n" + 
//                                 "WHERE persona_id=?";
        
//         MessageDigest digest = MessageDigest.getInstance("SHA-256");        
//         byte[] hash = digest.digest(paciente.getContrasenia().getBytes(StandardCharsets.UTF_8));
        
//         Connection conexion = Conexion.getConexion();
        
//         try {
//             PreparedStatement sentencia = conexion.prepareStatement(QUERY_1, Statement.RETURN_GENERATED_KEYS);
            
//             sentencia.setDate(1, cita.getDate());
//             sentencia.setTime(2, cita.getTime());
//             sentencia.setString(3, hash.toString());
//             sentencia.setInt(4, cita.getId());
//             int idCita = sentencia.executeUpdate();
//             sentencia.close();

//             sentencia = conexion.prepareStatement(QUERY_2);
//             sentencia.setInt(1, cita.getNumeroCita());
//             sentencia.setInt(2, cita.getId());
//             sentencia.executeUpdate();
            
//             conexion.close();
//             return 0;
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } finally {
//             conexion.close();
//         }
//         return -1;
//   }
//         public static int borrarCita(int id) {
//         final String QUERY = "DELETE FROM cita WHERE persona_id=?";

//         Connection conexion = Conexion.getConexion();

//         try {
//             PreparedStatement sentencia = conexion.prepareStatement(QUERY);

//             sentencia.setInt(id);
//             sentencia.executeUpdate();
            
//             conexion.close();
//             return 0;
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } finally {
//             conexion.close();
//         }
//         return -1;
//     }
}
  