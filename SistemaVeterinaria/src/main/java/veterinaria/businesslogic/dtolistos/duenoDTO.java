package veterinaria.businesslogic.dtolistos;

public class duenoDTO {
    private int idDuenio;
    private String telefono;
    private String nombreCompleto;
    private String email;

    public duenoDTO() {}

    public duenoDTO(int idDuenio, String telefono, String nombreCompleto, String email) {
        this.idDuenio = idDuenio;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public int getIdDuenio() { return idDuenio; }
    public void setIdDuenio(int idDuenio) { this.idDuenio = idDuenio; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }
    
    
    
}