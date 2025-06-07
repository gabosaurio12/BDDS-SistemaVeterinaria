package veterinaria.businesslogic.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import veterinaria.businesslogic.dto.direccionSecretariaDTO;
import veterinaria.dataaccess.DBConnection;

public class direccionSecretariaDAO {

    public boolean insertarDireccionSecretaria(direccionSecretariaDTO direccionSecretaria) {
        String sql = "INSERT INTO direccion_secretaria (numeroDeCasa, calle, colonia, numeroDeINE) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, direccionSecretaria.getNumeroDeCasa());
            pstmt.setString(2, direccionSecretaria.getCalle());
            pstmt.setString(3, direccionSecretaria.getColonia());
            pstmt.setObject(4, direccionSecretaria.getNumeroDeINE());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar dirección de secretaría: " + e.getMessage());
            return false;
        }
    }

    public direccionSecretariaDTO seleccionarDireccionSecretariaPorNumeroDeCasa(int numeroDeCasa) {
        String sql = "SELECT * FROM direccion_secretaria WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, numeroDeCasa);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new direccionSecretariaDTO(
                            rs.getInt("numeroDeCasa"),
                            rs.getString("calle"),
                            rs.getString("colonia"),
                            (Integer) rs.getObject("numeroDeINE")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar dirección de secretaría por número de casa: " + e.getMessage());
        }
        return null;
    }

    public List<direccionSecretariaDTO> seleccionarTodasLasDireccionesSecretaria() {
        List<direccionSecretariaDTO> listaDirecciones = new ArrayList<>();
        String sql = "SELECT * FROM direccion_secretaria";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                listaDirecciones.add(new direccionSecretariaDTO(
                        rs.getInt("numeroDeCasa"),
                        rs.getString("calle"),
                        rs.getString("colonia"),
                        (Integer) rs.getObject("numeroDeINE")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar todas las direcciones de secretaría: " + e.getMessage());
        }
        return listaDirecciones;
    }

    public boolean actualizarDireccionSecretaria(direccionSecretariaDTO direccionSecretaria) {
        String sql = "UPDATE direccion_secretaria SET calle = ?, colonia = ?, numeroDeINE = ? WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, direccionSecretaria.getCalle());
            pstmt.setString(2, direccionSecretaria.getColonia());
            pstmt.setObject(3, direccionSecretaria.getNumeroDeINE());
            pstmt.setInt(4, direccionSecretaria.getNumeroDeCasa());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar dirección de secretaría: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarDireccionSecretaria(int numeroDeCasa) {
        String sql = "DELETE FROM direccion_secretaria WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, numeroDeCasa);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar dirección de secretaría: " + e.getMessage());
            return false;
        }
    }
}