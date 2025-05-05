package veterinaria.businesslogic.dto;

public class secretariaDTO {
    private int numeroDeINE;
    private String nombreCompleto;
    private Integer telefono;
    private String nombreDeUsuario;
    private String contrasenia;

    public secretariaDTO(int numeroDeINE, String nombreCompleto, Integer telefono, String nombreDeUsuario, String contrasenia) {
        this.numeroDeINE = numeroDeINE;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasenia = contrasenia;
    }
    
    public int getNumeroDeINE() {
        return numeroDeINE;
    }

    public void setNumeroDeINE(int numeroDeINE) {
        this.numeroDeINE = numeroDeINE;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}