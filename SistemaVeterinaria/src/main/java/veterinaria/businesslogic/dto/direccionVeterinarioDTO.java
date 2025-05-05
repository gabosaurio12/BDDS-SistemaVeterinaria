package veterinaria.businesslogic.dto;

public class direccionVeterinarioDTO {
    private int numeroDeCasa;
    private String calle;
    private String colonia;
    private Integer cedula;

    public direccionVeterinarioDTO() {
    }

    public direccionVeterinarioDTO(int numeroDeCasa, String calle, String colonia, Integer cedula) {
        this.numeroDeCasa = numeroDeCasa;
        this.calle = calle;
        this.colonia = colonia;
        this.cedula = cedula;
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

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
}