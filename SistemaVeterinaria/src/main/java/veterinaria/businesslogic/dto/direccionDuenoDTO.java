package veterinaria.businesslogic.dto;

public class direccionDuenoDTO {
    private int numeroDeCasa;
    private String calle;
    private String colonia;
    private int idDuenio;

    public direccionDuenoDTO() {}

    public direccionDuenoDTO(int numeroDeCasa, String calle, String colonia, int idDuenio) {
        this.numeroDeCasa = numeroDeCasa;
        this.calle = calle;
        this.colonia = colonia;
        this.idDuenio = idDuenio;
    }

    // Getters y Setters
    public int getNumeroDeCasa() {
        return numeroDeCasa;
    }

    public void setNumeroDeCasa(int numeroDeCasa) {
        this.numeroDeCasa = numeroDeCasa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }
}