package veterinaria;

import java.sql.Date;
import veterinaria.businesslogic.dao.MascotaDAO;
import veterinaria.businesslogic.dto.mascotaDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author gabosaurio
 */
public class SistemaVeterinaria {

    public static void main(String[] args) {
        mascotaDTO mascota = new mascotaDTO(1,
                "Micky", new Date(1935, 04, 22), "negro", 0.250, 1);
        new MascotaDAO().insertar(mascota);
    }
}
