package veterinaria.businesslogic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import veterinaria.businesslogic.dto.secretariaDTO;
import veterinaria.dataaccess.DBConnection;

public class secretariaDAO {
    
    public int insertar(secretariaDTO secretaria) throws SQLException {
        String sql = "INSERT INTO secretaria (numeroDeINE, nombreCompleto, telefono, nombreDeUsuario, contrasenia) VALUES (?, ?, ?, ?, ?)";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, secretaria.getNumeroDeINE());
            stmt.setString(2, secretaria.getNombreCompleto());
            stmt.setInt(3, secretaria.getTelefono());
            stmt.setString(4, secretaria.getNombreDeUsuario());
            stmt.setString(5, secretaria.getContrasenia());

            return stmt.executeUpdate();
        }
    }

    // UPDATE
    public int actualizar(secretariaDTO secretaria) throws SQLException {
        String sql = "UPDATE secretaria SET nombreCompleto = ?, telefono = ?, nombreDeUsuario = ?, contrasenia = ? WHERE numeroDeINE = ?";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, secretaria.getNombreCompleto());
            stmt.setInt(2, secretaria.getTelefono());
            stmt.setString(3, secretaria.getNombreDeUsuario());
            stmt.setString(4, secretaria.getContrasenia());
            stmt.setInt(5, secretaria.getNumeroDeINE());

            return stmt.executeUpdate();
        }
    }

    // DELETE
    public int eliminar(int numeroDeINE) throws SQLException {
        String sql = "DELETE FROM secretaria WHERE numeroDeINE = ?";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, numeroDeINE);
            return stmt.executeUpdate();
        }
    }

    // SELECT ALL
    public List<secretariaDTO> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM secretaria";
        List<secretariaDTO> lista = new ArrayList<>();
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                secretariaDTO secretaria = new secretariaDTO(
                    rs.getInt("numeroDeINE"),
                    rs.getString("nombreCompleto"),
                    rs.getInt("telefono"),
                    rs.getString("nombreDeUsuario"),
                    rs.getString("contrasenia")
                );
                lista.add(secretaria);
            }
        }
        return lista;
    }

    // SELECT BY ID
    public secretariaDTO obtenerPorINE(int numeroDeINE) throws SQLException {
        String sql = "SELECT * FROM secretaria WHERE numeroDeINE = ?";
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, numeroDeINE);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new secretariaDTO(
                        rs.getInt("numeroDeINE"),
                        rs.getString("nombreCompleto"),
                        rs.getInt("telefono"),
                        rs.getString("nombreDeUsuario"),
                        rs.getString("contrasenia")
                    );
                }
            }
        }
        return null;
    }
}