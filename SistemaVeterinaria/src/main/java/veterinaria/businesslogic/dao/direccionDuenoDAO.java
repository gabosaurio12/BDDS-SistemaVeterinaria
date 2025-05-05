package veterinaria.businesslogic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import veterinaria.businesslogic.dto.direccionDuenoDTO;
import veterinaria.dataaccess.DBConnection;

public class direccionDuenoDAO {
    private static final Logger logger = LogManager.getLogger(direccionDuenoDAO.class);

    public boolean insertarDireccion(direccionDuenoDTO direccion) {
        String sql = "INSERT INTO direccion_dueno (numeroDeCasa, calle, colonia, idDuenio) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getInstance().getInstance().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, direccion.getNumeroDeCasa());
            stmt.setString(2, direccion.getCalle());
            stmt.setString(3, direccion.getColonia());
            stmt.setInt(4, direccion.getIdDuenio());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error al insertar dirección", e);
            return false;
        }
    }

    public boolean actualizarDireccion(direccionDuenoDTO direccion) {
        String sql = "UPDATE direccion_dueno SET calle = ?, colonia = ?, idDuenio = ? WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, direccion.getCalle());
            stmt.setString(2, direccion.getColonia());
            stmt.setInt(3, direccion.getIdDuenio());
            stmt.setInt(4, direccion.getNumeroDeCasa());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error al actualizar dirección", e);
            return false;
        }
    }

    public boolean eliminarDireccion(int numeroDeCasa) {
        String sql = "DELETE FROM direccion_dueno WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, numeroDeCasa);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error al eliminar dirección", e);
            return false;
        }
    }

    public direccionDuenoDTO obtenerDireccionPorNumero(int numeroDeCasa) {
        String sql = "SELECT * FROM direccion_dueno WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, numeroDeCasa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new direccionDuenoDTO(
                    rs.getInt("numeroDeCasa"),
                    rs.getString("calle"),
                    rs.getString("colonia"),
                    rs.getInt("idDuenio")
                );
            }
        } catch (SQLException e) {
            logger.error("Error al obtener dirección por número", e);
        }
        return null;
    }

    public List<direccionDuenoDTO> obtenerTodasLasDirecciones() {
        List<direccionDuenoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM direccion_dueno";
        try (Connection connection = DBConnection.getInstance().getConnection();
                Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new direccionDuenoDTO(
                    rs.getInt("numeroDeCasa"),
                    rs.getString("calle"),
                    rs.getString("colonia"),
                    rs.getInt("idDuenio")
                ));
            }
        } catch (SQLException e) {
            logger.error("Error al obtener todas las direcciones", e);
        }
        return lista;
    }
}