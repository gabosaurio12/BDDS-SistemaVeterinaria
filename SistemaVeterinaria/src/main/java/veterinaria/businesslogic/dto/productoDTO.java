package veterinaria.businesslogic.dto;

import java.math.BigDecimal;

public class productoDTO {
    private int idProducto;
    private String nombre;
    private Integer existencia;
    private String marca;
    private BigDecimal precio;
    private String tipo;
    private String especie;

    public productoDTO() {}

    public productoDTO(int idProducto, String nombre, Integer existencia, String marca, BigDecimal precio, String tipo, String especie) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.existencia = existencia;
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
        this.especie = especie;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}