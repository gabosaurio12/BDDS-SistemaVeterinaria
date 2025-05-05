package veterinaria.businesslogic.dto;

public class enfermedadDTO {
    private int idEnfermedad;
    private String nombreDeEnfermedad;
    private String clasificacionDeEspecie;

    public enfermedadDTO() {}

    public enfermedadDTO(int idEnfermedad, String nombreDeEnfermedad, String clasificacionDeEspecie) {
        this.idEnfermedad = idEnfermedad;
        this.nombreDeEnfermedad = nombreDeEnfermedad;
        this.clasificacionDeEspecie = clasificacionDeEspecie;
    }

    // Getters y Setters
    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombreDeEnfermedad() {
        return nombreDeEnfermedad;
    }

    public void setNombreDeEnfermedad(String nombreDeEnfermedad) {
        this.nombreDeEnfermedad = nombreDeEnfermedad;
    }

    public String getClasificacionDeEspecie() {
        return clasificacionDeEspecie;
    }

    public void setClasificacionDeEspecie(String clasificacionDeEspecie) {
        this.clasificacionDeEspecie = clasificacionDeEspecie;
    }
}