/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_bd;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author lv1013
 */
public interface ConnectionFactory {
    Connection getConnection() throws SQLException;
}
