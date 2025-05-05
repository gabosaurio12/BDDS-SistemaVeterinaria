package veterinaria.businesslogic.dto;

import java.sql.Time;

public class fechaCitaDTO {
    private int idCita;
    private Integer dia;
    private Integer mes;
    private Integer anio;
    private Time hora;

    public fechaCitaDTO() {}

    public fechaCitaDTO(int idCita, Integer dia, Integer mes, Integer anio, Time hora) {
        this.idCita = idCita;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
    }

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}