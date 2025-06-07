package veterinaria.businesslogic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import veterinaria.businesslogic.dto.veterinarioDTO;
import veterinaria.dataaccess.DBConnection;

public class veterinarioDAO {

    public boolean insertarVeterinario(veterinarioDTO veterinario) {
        String sql = "INSERT INTO veterinarios (cedula, nombreCompleto, telefono, nombreDeUsuario, contrasenia) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, veterinario.getCedula());
            pstmt.setString(2, veterinario.getNombreCompleto());
            pstmt.setObject(3, veterinario.getTelefono());
            pstmt.setString(4, veterinario.getNombreDeUsuario());
            pstmt.setString(5, veterinario.getContrasenia());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar veterinario: " + e.getMessage());
            return false;
        }
    }

    public veterinarioDTO seleccionarVeterinarioPorCedula(int cedula) {
        String sql = "SELECT * FROM veterinarios WHERE cedula = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cedula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new veterinarioDTO(
                            rs.getInt("cedula"),
                            rs.getString("nombreCompleto"),
                            (Integer) rs.getObject("telefono"),
                            rs.getString("nombreDeUsuario"),
                            rs.getString("contrasenia")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar veterinario por cédula: " + e.getMessage());
        }
        return null;
    }

    public List<veterinarioDTO> seleccionarTodosLosVeterinarios() {
        List<veterinarioDTO> listaVeterinarios = new ArrayList<>();
        String sql = "SELECT * FROM veterinarios";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                listaVeterinarios.add(new veterinarioDTO(
                        rs.getInt("cedula"),
                        rs.getString("nombreCompleto"),
                        (Integer) rs.getObject("telefono"),
                        rs.getString("nombreDeUsuario"),
                        rs.getString("contrasenia")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar todos los veterinarios: " + e.getMessage());
        }
        return listaVeterinarios;
    }

    public boolean actualizarVeterinario(veterinarioDTO veterinario) {
        String sql = "UPDATE veterinarios SET nombreCompleto = ?, telefono = ?, nombreDeUsuario = ?, contrasenia = ? WHERE cedula = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, veterinario.getNombreCompleto());
            pstmt.setObject(2, veterinario.getTelefono());
            pstmt.setString(3, veterinario.getNombreDeUsuario());
            pstmt.setString(4, veterinario.getContrasenia());
            pstmt.setInt(5, veterinario.getCedula());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar veterinario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarVeterinario(int cedula) {
        String sql = "DELETE FROM veterinarios WHERE cedula = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cedula);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar veterinario: " + e.getMessage());
            return false;
        }
    }
}