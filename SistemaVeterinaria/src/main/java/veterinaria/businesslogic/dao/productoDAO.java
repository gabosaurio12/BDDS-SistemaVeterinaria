package veterinaria.businesslogic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import veterinaria.businesslogic.dto.ProductoDTO;
import veterinaria.dataaccess.DBConnection;

public class productoDAO {

    public boolean insertarProducto(ProductoDTO producto) {
        String sql = "INSERT INTO productos (idProducto, nombre, existencia, marca, precio, tipo, especie) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, producto.getIdProducto());
            pstmt.setString(2, producto.getNombre());
            pstmt.setObject(3, producto.getExistencia());
            pstmt.setString(4, producto.getMarca());
            pstmt.setBigDecimal(5, producto.getPrecio());
            pstmt.setString(6, producto.getTipo());
            pstmt.setString(7, producto.getEspecie());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    public ProductoDTO seleccionarProductoPorId(int idProducto) {
        String sql = "SELECT * FROM productos WHERE idProducto = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new ProductoDTO(
                            rs.getInt("idProducto"),
                            rs.getString("nombre"),
                            (Integer) rs.getObject("existencia"),
                            rs.getString("marca"),
                            rs.getBigDecimal("precio"),
                            rs.getString("tipo"),
                            rs.getString("especie")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar producto por ID: " + e.getMessage());
        }
        return null;
    }

    public static List<ProductoDTO> seleccionarTodosLosProductos() {
        List<ProductoDTO> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                listaProductos.add(new ProductoDTO(
                        rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        (Integer) rs.getObject("existencia"),
                        rs.getString("marca"),
                        rs.getBigDecimal("precio"),
                        rs.getString("tipo"),
                        rs.getString("especie")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar todos los productos: " + e.getMessage());
        }
        return listaProductos;
    }

    public boolean actualizarProducto(ProductoDTO producto) {
        String sql = "UPDATE productos SET nombre = ?, existencia = ?, marca = ?, precio = ?, tipo = ?, especie = ? WHERE idProducto = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setObject(2, producto.getExistencia());
            pstmt.setString(3, producto.getMarca());
            pstmt.setBigDecimal(4, producto.getPrecio());
            pstmt.setString(5, producto.getTipo());
            pstmt.setString(6, producto.getEspecie());
            pstmt.setInt(7, producto.getIdProducto());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
        String sql = "DELETE FROM productos WHERE idProducto = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
}