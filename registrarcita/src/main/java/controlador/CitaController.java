/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.AgendaService;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author PC
 */


public class CitaController {
    private AgendaService servicio;

    public CitaController(AgendaService servicio) {
        this.servicio = servicio;
    }

    public Paciente validarPaciente(String nss) {
        return servicio.validarNSS(nss);
    }

    public void mostrarMedicos() {
        for (Medico m : servicio.listarMedicos()) {
            System.out.println(m);
        }
    }

    public Medico seleccionarMedico(String id) {
        return servicio.obtenerMedicoPorId(id);
    }

    public Cita crearCita(Paciente p, Medico m, String fecha, String hora) {
        return servicio.registrarCita(p, m, fecha, hora);
    }
}