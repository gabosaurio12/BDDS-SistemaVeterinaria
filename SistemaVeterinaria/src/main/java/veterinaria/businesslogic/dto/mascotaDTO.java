package veterinaria.businesslogic.dto;

import java.sql.Date;

public class mascotaDTO {
    private int idMascota;
    private String nombre;
    private Date fechaDeNacimiento;
    private String color;
    private Double peso;
    private int idDuenio;

    public mascotaDTO() {}

    public mascotaDTO(int idMascota, String nombre, Date fechaDeNacimiento, String color, Double peso, int idDuenio) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.color = color;
        this.peso = peso;
        this.idDuenio = idDuenio;
    }

    // Getters y Setters
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }
}