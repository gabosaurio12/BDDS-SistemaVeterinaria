package veterinaria.businesslogic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import veterinaria.businesslogic.dto.direccionVeterinarioDTO;
import veterinaria.dataaccess.DBConnection;

public class direccionVeterinarioDAO {

    public boolean insertarDireccionVeterinario(direccionVeterinarioDTO direccionVeterinario) {
        String sql = "INSERT INTO direccion_veterinario (numeroDeCasa, calle, colonia, cedula) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, direccionVeterinario.getNumeroDeCasa());
            pstmt.setString(2, direccionVeterinario.getCalle());
            pstmt.setString(3, direccionVeterinario.getColonia());
            pstmt.setObject(4, direccionVeterinario.getCedula());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar dirección de veterinario: " + e.getMessage());
            return false;
        }
    }

    public direccionVeterinarioDTO seleccionarDireccionVeterinarioPorNumeroDeCasa(int numeroDeCasa) {
        String sql = "SELECT * FROM direccion_veterinario WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, numeroDeCasa);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new direccionVeterinarioDTO(
                            rs.getInt("numeroDeCasa"),
                            rs.getString("calle"),
                            rs.getString("colonia"),
                            (Integer) rs.getObject("cedula")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar dirección de veterinario por número de casa: " + e.getMessage());
        }
        return null;
    }

    public List<direccionVeterinarioDTO> seleccionarTodasLasDireccionesVeterinario() {
        List<direccionVeterinarioDTO> listaDirecciones = new ArrayList<>();
        String sql = "SELECT * FROM direccion_veterinario";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                listaDirecciones.add(new direccionVeterinarioDTO(
                        rs.getInt("numeroDeCasa"),
                        rs.getString("calle"),
                        rs.getString("colonia"),
                        (Integer) rs.getObject("cedula")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar todas las direcciones de veterinario: " + e.getMessage());
        }
        return listaDirecciones;
    }

    public boolean actualizarDireccionVeterinario(direccionVeterinarioDTO direccionVeterinario) {
        String sql = "UPDATE direccion_veterinario SET calle = ?, colonia = ?, cedula = ? WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, direccionVeterinario.getCalle());
            pstmt.setString(2, direccionVeterinario.getColonia());
            pstmt.setObject(3, direccionVeterinario.getCedula());
            pstmt.setInt(4, direccionVeterinario.getNumeroDeCasa());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar dirección de veterinario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarDireccionVeterinario(int numeroDeCasa) {
        String sql = "DELETE FROM direccion_veterinario WHERE numeroDeCasa = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, numeroDeCasa);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar dirección de veterinario: " + e.getMessage());
            return false;
        }
    }
}