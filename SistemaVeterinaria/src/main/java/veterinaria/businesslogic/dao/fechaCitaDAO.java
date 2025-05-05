package veterinaria.businesslogic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import veterinaria.businesslogic.dto.fechaCitaDTO;
import veterinaria.dataaccess.DBConnection;

public class fechaCitaDAO {

    public boolean insertarFechaCita(fechaCitaDTO fechaCita) {
        String sql = "INSERT INTO fechascitas (idCita, dia, mes, anio, hora) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, fechaCita.getIdCita());
            pstmt.setObject(2, fechaCita.getDia());
            pstmt.setObject(3, fechaCita.getMes());
            pstmt.setObject(4, fechaCita.getAnio());
            pstmt.setTime(5, fechaCita.getHora());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar fecha de cita: " + e.getMessage());
            return false;
        }
    }

    public fechaCitaDTO seleccionarFechaCitaPorId(int idCita) {
        String sql = "SELECT * FROM fechascitas WHERE idCita = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idCita);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new fechaCitaDTO(
                            rs.getInt("idCita"),
                            (Integer) rs.getObject("dia"),
                            (Integer) rs.getObject("mes"),
                            (Integer) rs.getObject("anio"),
                            rs.getTime("hora")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar fecha de cita por ID: " + e.getMessage());
        }
        return null;
    }

    public List<fechaCitaDTO> seleccionarTodasLasFechasCitas() {
        List<fechaCitaDTO> listaFechasCitas = new ArrayList<>();
        String sql = "SELECT * FROM fechascitas";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                listaFechasCitas.add(new fechaCitaDTO(
                        rs.getInt("idCita"),
                        (Integer) rs.getObject("dia"),
                        (Integer) rs.getObject("mes"),
                        (Integer) rs.getObject("anio"),
                        rs.getTime("hora")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar todas las fechas de citas: " + e.getMessage());
        }
        return listaFechasCitas;
    }

    public boolean actualizarFechaCita(fechaCitaDTO fechaCita) {
        String sql = "UPDATE fechascitas SET dia = ?, mes = ?, anio = ?, hora = ? WHERE idCita = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, fechaCita.getDia());
            pstmt.setObject(2, fechaCita.getMes());
            pstmt.setObject(3, fechaCita.getAnio());
            pstmt.setTime(4, fechaCita.getHora());
            pstmt.setInt(5, fechaCita.getIdCita());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar fecha de cita: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarFechaCita(int idCita) {
        String sql = "DELETE FROM fechascitas WHERE idCita = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idCita);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar fecha de cita: " + e.getMessage());
            return false;
        }
    }
}