package veterinaria.businesslogic.daolistos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import veterinaria.businesslogic.dtolistos.duenoDTO;
import veterinaria.dataaccess.DBConnection;

public class duenoDAO {
    private static final Logger logger = LogManager.getLogger(duenoDAO.class);
    
    public int insertar(duenoDTO dueno) throws Exception {
        String sql = "INSERT INTO dueno (telefono, nombreCompleto, email) VALUES (?, ?, ?)";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, dueno.getTelefono());
            stmt.setString(2, dueno.getNombreCompleto());
            stmt.setString(3, dueno.getEmail());

            int filasAfectadas = stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    dueno.setIdDuenio(rs.getInt(1));
                }
            } catch (SQLException e) {
                logger.error("Error al obtener clave generada en DuenoDAO.insertar", e);
            }

            return filasAfectadas;
        } catch (SQLException e) {
            logger.error("Error en DuenoDAO.insertar", e);
        }
        
        return 1;
    }

    public int actualizar(duenoDTO dueno) throws Exception {
        String sql = "UPDATE dueno SET telefono = ?, nombreCompleto = ?, telefono = ? WHERE idDuenio = ?";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, dueno.getTelefono());
            stmt.setString(2, dueno.getNombreCompleto());
            stmt.setString(3, dueno.getEmail());
            stmt.setInt(4, dueno.getIdDuenio());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error en DuenoDAO.actualizar", e);
        }
        
        return 1;
    }

    public int eliminar(int idDuenio) throws Exception {
        String sql = "DELETE FROM dueno WHERE idDuenio = ?";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, idDuenio);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error en DuenoDAO.eliminar", e);
        }
        
        return 1;
    }

    public List<duenoDTO> obtenerTodos() throws Exception {
        String sql = "SELECT * FROM dueno";
        List<duenoDTO> lista = new ArrayList<>();
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                duenoDTO dueno = new duenoDTO();
                dueno.setIdDuenio(rs.getInt("idDuenio"));
                dueno.setTelefono(rs.getString("telefono"));
                dueno.setNombreCompleto(rs.getString("nombreCompleto"));
                dueno.setEmail(rs.getString("email"));
                lista.add(dueno);
            }
        } catch (SQLException e) {
            logger.error("Error en DuenoDAO.obtenerTodos", e);
        }
        return lista;
    }

    public duenoDTO obtenerPorId(int id) throws Exception {
        String sql = "SELECT * FROM dueno WHERE idDuenio = ?";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    duenoDTO dueno = new duenoDTO();
                    dueno.setIdDuenio(rs.getInt("idDuenio"));
                    dueno.setTelefono(rs.getString("telefono"));
                    dueno.setNombreCompleto(rs.getString("nombreCompleto"));
                    dueno.setEmail(rs.getString("email"));
                    return dueno;
                }
            } catch (SQLException e) {
                logger.error("Error al obtener resultados en DuenoDAO.obtenerPorId", e);
            }
        } catch (SQLException e) {
            logger.error("Error en DuenoDAO.obtenerPorId", e);
        }
        return null;
    }
    
    public int obtenerDuenoPorTelefono(String telefono) {
        String query = "SELECT idDuenio FROM Dueno WHERE telefono = ?;";
        int id = 0;
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setString(1, telefono);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (SQLException e) {
                logger.error("Error al obtener resultados en DuenoDAO.obtenerDuenoPorTelefono", e);
            }
        } catch (SQLException e) {
            logger.error("Error en DuenoDAO.obtenerDuenoPorTelefono", e);
        }
        
        return id;
    }
}