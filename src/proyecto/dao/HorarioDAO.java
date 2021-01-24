package proyecto.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proyecto.db.Conexion;
import proyecto.entity.Horario;

public class HorarioDAO {

    public static Horario getHorario(final int id) {
         final String QUERY = "SELECT * FROM poo_horario\n" +
                                "WHERE doctor.id=?";

    final Connection conexion = Conexion.getConexion();

        Horario horario = null;

            try {
             final PreparedStatement sentencia = conexion.prepareStatement(QUERY);
             sentencia.setInt(1, id);
             final ResultSet resultado = sentencia.executeQuery();

             if(resultado.next())
                 horario = new Horario(
                     resultado.getInt("id"),
                     resultado.getTime("horaInicio"),
                     resultado.getTime("horaTermino"),
                     resultado.getInt("doctor_id")
                 );
            } catch (final SQLException e) {
               System.out.println(e.getMessage());
            } 
            return horario;
    }


    public static ArrayList<Horario> getHorarios() {
        final String QUERY = "SELECT * FROM poo_horario";

        final ArrayList<Horario> horarios = new ArrayList<Horario>();

        final Connection conexion = Conexion.getConexion();
        
        try {
            final PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            final ResultSet resultado = sentencia.executeQuery();

            
            while (resultado.next()){
                horarios.add(new Horario(
                    resultado.getInt("id"),
                    resultado.getTime("horaInicio"),
                    resultado.getTime("horaTermino"),
                    resultado.getInt("doctor_id")
                ));
            }
        } catch (final SQLException e) {
            System.out.println(e.getMessage());
        } 
        return horarios;
    }


public static int crearHorario(final Horario horario) {
    if(horario== null) return -1;
    final String QUERY_1 = "INSERT INTO poo_horario VALUES (?,?,?)";
   
    final Connection conexion = Conexion.getConexion();
   
    try {
        final PreparedStatement sentencia = conexion.prepareStatement(QUERY_1);
        sentencia.setTime(1, horario.getHoraInicio());
        sentencia.setTime(2, horario.getHoraTermino());
        sentencia.setInt(3, horario.getDoctor_id());
        sentencia.executeUpdate();
        sentencia.close();
       
        conexion.close();
        return 0;
    } catch (final SQLException e) {
        System.out.println(e.getMessage());
    } 
    return -1;
}


public static int actualizarHorario(final Horario horario) {
     if(horario == null) return -1;
     final String QUERY_1 = "UPDATE poo_horario SET \n" +
                            "horaInicio=?, \n" +
                            "horaTermino=?, \n" +
                            "WHERE id=?";
                           
     final Connection conexion = Conexion.getConexion();

    try {
        final PreparedStatement sentencia = conexion.prepareStatement(QUERY_1, Statement.RETURN_GENERATED_KEYS);

        sentencia.setTime(1, horario.getHoraInicio());
        sentencia.setTime(2, horario.getHoraTermino());
        sentencia.setInt(3, horario.getId());

        sentencia.close();
        conexion.close();
        return 0;
    } catch (final SQLException e) {  
        System.out.println(e.getMessage());
    }
    return -1;
}
}