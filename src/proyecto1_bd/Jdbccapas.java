/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_bd;

import proyecto1_bd.SocioDAOImpl;

/**
 *
 * @author lv1013
 */
public class Jdbccapas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConnectionFactory connectionFactory = 
            new MySQLConnectionFactory(
                "localhost", "club_nautico", 3306, "root", "1234");
        
        SocioDAO socioDAO = new SocioDAOImpl(connectionFactory);
    }
    
}
