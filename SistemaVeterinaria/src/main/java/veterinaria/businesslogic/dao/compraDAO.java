package veterinaria.businesslogic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import veterinaria.businesslogic.dto.compraDTO;
import veterinaria.dataaccess.DBConnection;

public class compraDAO {
    private static final Logger logger = LogManager.getLogger(compraDAO.class);

    public boolean insertarCompra(compraDTO compra) {
        String sql = "INSERT INTO compra (idDuenio, idProducto) VALUES (?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, compra.getIdDuenio());
            pstmt.setInt(2, compra.getIdProducto());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar compra: " + e.getMessage());
            return false;
        }
    }

    public compraDTO seleccionarCompraPorIds(int idDuenio, int idProducto) {
        String sql = "SELECT * FROM compra WHERE idDuenio = ? AND idProducto = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDuenio);
            pstmt.setInt(2, idProducto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new compraDTO(
                            rs.getInt("idDuenio"),
                            rs.getInt("idProducto")
                    );
                }
            }
        } catch (SQLException e) {
            logger.error("Error al seleccionar compra por IDs", e);
            System.err.println("Error occurred at: " + java.time.LocalDateTime.now());
            System.err.println("Error al seleccionar compra por IDs: " + e.getMessage());
        }
        return null;
    }

    public List<compraDTO> seleccionarTodasLasCompras() {
        List<compraDTO> listaCompras = new ArrayList<>();
        String sql = "SELECT * FROM compra";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                listaCompras.add(new compraDTO(
                        rs.getInt("idDuenio"),
                        rs.getInt("idProducto")
                ));
            }
        } catch (SQLException e) {
            logger.error("Error al seleccionar todas las compras", e);
        }
        return listaCompras;
    }

    public boolean eliminarCompra(int idDuenio, int idProducto) {
        String sql = "DELETE FROM compra WHERE idDuenio = ? AND idProducto = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDuenio);
            pstmt.setInt(2, idProducto);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            logger.error("Error al eliminar compra", e);
            return false;
        }
    }
}