/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

import proyecto.entity.Horario;
import proyecto.entity.Paciente;
import proyecto.dao.HorarioDAO;
import proyecto.dao.LoginDAO;
import proyecto.ui.login.LoginUI;

/**
 *
 * @author rachelruvalcaba
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);
    }
    
}
