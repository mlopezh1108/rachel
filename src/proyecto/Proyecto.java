/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

import proyecto.entity.Horario;
import proyecto.dao.HorarioDAO;

/**
 *
 * @author rachelruvalcaba
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Horario horario = HorarioDAO.getHorario(1);
        System.out.println(horario);
    }
    
}
