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
    public static Doctor getDoctor(int id) {
        final String QUERY =    "select PER.id, PER.nombre, PER.apellidopaterno,\n" +
                                "PER.apellidomaterno, PER.fechanacimiento,\n" +
                                "PER.telefono, PER.correoelectronico, PER.usuario,\n" +
                                "EMP.numeroempleado, EMP.salario, EMP.fechaingreso,\n" + 
                                "EMP.clinica_id, DR.cedula, DR.especialidad	from poo_doctor DR\n" + 
                                "inner join poo_empleado EMP on DR.empleado_id = EMP.id\n" +
                                "inner join poo_persona PER on PER.id = EMP.persona_id\n" + 
                                "WHERE DR.cedula = ?";

        
        Connection conexion = Conexion.getConexion();

        Doctor doctor = null;
        
        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();

            if(resultado.next())
                doctor = new Doctor(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("apellidoPaterno"),
                    resultado.getString("apellidoMaterno"),
                    resultado.getDate("fechaNacimiento"),
                    resultado.getString("telefono"),
                    resultado.getString("correoElectronico"),
                    resultado.getString("usuario"),"",
                    resultado.getInt("numeroEmpleado"),
                    resultado.getFloat("salario"),
                    resultado.getDate("fechaIngreso"),
                    resultado.getInt("clinica_id"),
                    resultado.getInt("cedula"),
                    resultado.getString("especialidad")
                );
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return doctor;
    }

    public static ArrayList<Doctor> getDoctores() {
        final String QUERY =    "select PER.id, PER.nombre, PER.apellidopaterno,\n" +
                                "PER.apellidomaterno, PER.fechanacimiento,\n" +
                                "PER.telefono, PER.correoelectronico, PER.usuario,\n" +
                                "EMP.numeroempleado, EMP.salario, EMP.fechaingreso,\n" + 
                                "EMP.clinica_id, DR.cedula, DR.especialidad	from poo_doctor DR\n" + 
                                "inner join poo_empleado EMP on DR.empleado_id = EMP.id\n" +
                                "inner join poo_persona PER on PER.id = EMP.persona_id";

        
        Connection conexion = Conexion.getConexion();

        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        
        try {
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            ResultSet resultado = sentencia.executeQuery();

            while(resultado.next())
                doctores.add(new Doctor(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("apellidoPaterno"),
                    resultado.getString("apellidoMaterno"),
                    resultado.getDate("fechaNacimiento"),
                    resultado.getString("telefono"),
                    resultado.getString("correoElectronico"),
                    resultado.getString("usuario"), "",
                    resultado.getInt("numeroEmpleado"),
                    resultado.getFloat("salario"),
                    resultado.getDate("fechaIngreso"),
                    resultado.getInt("clinica_id"),
                    resultado.getInt("cedula"),
                    resultado.getString("especialidad")
                ));
            System.out.println(doctores);
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return doctores;
    }
}
