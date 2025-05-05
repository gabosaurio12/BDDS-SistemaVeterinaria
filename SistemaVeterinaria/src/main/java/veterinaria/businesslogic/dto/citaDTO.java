package veterinaria.businesslogic.dto;

public class citaDTO {
    private int idCita;
    private String tratamiento;
    private String motivoDeConsulta;
    private String estadoDeCita;
    private int numeroDeINE;
    private int idMascota;
    private int cedula;

    public citaDTO() {}

    public citaDTO(int idCita, String tratamiento, String motivoDeConsulta, String estadoDeCita, int numeroDeINE, int idMascota, int cedula) {
        this.idCita = idCita;
        this.tratamiento = tratamiento;
        this.motivoDeConsulta = motivoDeConsulta;
        this.estadoDeCita = estadoDeCita;
        this.numeroDeINE = numeroDeINE;
        this.idMascota = idMascota;
        this.cedula = cedula;
    }

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getMotivoDeConsulta() {
        return motivoDeConsulta;
    }

    public void setMotivoDeConsulta(String motivoDeConsulta) {
        this.motivoDeConsulta = motivoDeConsulta;
    }

    public String getEstadoDeCita() {
        return estadoDeCita;
    }

    public void setEstadoDeCita(String estadoDeCita) {
        this.estadoDeCita = estadoDeCita;
    }

    public int getNumeroDeINE() {
        return numeroDeINE;
    }

    public void setNumeroDeINE(int numeroDeINE) {
        this.numeroDeINE = numeroDeINE;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}