package proyecto.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyecto.db.Conexion;
import proyecto.entity.Paciente;

public class LoginDAO { 
    public static Paciente encontrarUsuario (String usuario, String contrasenia){
        final String QUERY = "select PS.id, PS.nombre, PS.apellidopaterno,\n" + 
                             "PS.apellidomaterno, PS.fechanacimiento,\n" + 
                             "PS.telefono, PS.correoelectronico, PS.usuario,\n" +
                             "PC.numeropaciente from poo_paciente PC\n" +
                             "inner join poo_persona PS on PS.id = PC.persona_id\n" +
                             "where PS.usuario = ? and PS.contrasenia= ?";

        Paciente paciente = null;


        Connection conexion = Conexion.getConexion();

        try{         
            PreparedStatement sentencia = conexion.prepareStatement(QUERY);
            sentencia.setString(1, usuario);
            sentencia.setString(2, contrasenia);            
            ResultSet resultado = sentencia.executeQuery();

            if(resultado.next()){
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

            }


        } catch(SQLException e){
            System.out.println(e.getMessage());
        } 
        return paciente;
    }
    
} 