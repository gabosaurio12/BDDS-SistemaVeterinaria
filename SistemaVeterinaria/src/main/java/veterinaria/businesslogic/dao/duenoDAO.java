package veterinaria.businesslogic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import veterinaria.businesslogic.dto.duenoDTO;
import veterinaria.dataaccess.DBConnection;

public class duenoDAO {
    
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
            }

            return filasAfectadas;
        }
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
        }
    }

    public int eliminar(int idDuenio) throws Exception {
        String sql = "DELETE FROM dueno WHERE idDuenio = ?";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, idDuenio);
            return stmt.executeUpdate();
        }
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
            }
        }
        return null;
    }
}