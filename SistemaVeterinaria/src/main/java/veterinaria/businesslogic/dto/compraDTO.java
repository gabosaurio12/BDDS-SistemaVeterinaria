package veterinaria.businesslogic.dto;

public class compraDTO {
    private int idDuenio;
    private int idProducto;

    public compraDTO() {
    }

    public compraDTO(int idDuenio, int idProducto) {
        this.idDuenio = idDuenio;
        this.idProducto = idProducto;
    }

    // Getters y Setters
    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    // Opcional: Sobrescribir equals() y hashCode() para claves primarias compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        compraDTO compraDTO = (compraDTO) o;
        return idDuenio == compraDTO.idDuenio &&
               idProducto == compraDTO.idProducto;
    }

    @Override
    public int hashCode() {
        int result = idDuenio;
        result = 31 * result + idProducto;
        return result;
    }
}