/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import proyecto1_bd.ConnectionFactory;
import proyecto1_bd.Socio;
import proyecto1_bd.SocioDAO;

/**
 *
 * @author lv1013
 */
public class SocioDAOImpl implements SocioDAO {

    private final ConnectionFactory connectionFactory;

    public SocioDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    
    @Override
    public Socio find(int id) throws Exception {
        final String sql = "SELECT id, nombre, direccion " +
            "FROM socio WHERE id = ?";
        
        try (Connection connection = this.connectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Socio(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("direccion"),
                            resultSet.getString("Age")
                    );
                }
                
                return null;
            }
        }
    }

    @Override
    public List<Socio> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Socio socio) throws Exception {
        final String sql = "INSERT INTO socio (nombre, direccion) " +
            "VALUES (?, ?)";
        try (
            Connection connection = this.connectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, socio.getNombre());
            statement.setString(2, socio.getAge());
            int id = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            socio.setId(id);
        }
    }

    @Override
    public void update(Socio socio) throws Exception {
        Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE SOCIO SET id='"+socio.getId()+"', nombre='"+socio.getNombre()+"', direccion='"+socio.getDireccion()+"', años='"+socio.getAge();
		try {
			connect=MySQLConnectionFactory.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método actualizar");
			e.printStackTrace();
		}		
		
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
