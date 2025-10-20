/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
import java.util.ArrayList;
import java.util.List;

public class AgendaService {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();

    public AgendaService() {
        pacientes.add(new Paciente("123", "Juan Perez"));
        pacientes.add(new Paciente("456", "Maria Lopez"));

        medicos.add(new Medico("1", "Dr. Ramirez", "Cardiologia", "A1"));
        medicos.add(new Medico("2", "Dra. Torres", "Pediatria", "B2"));
    }

    public Paciente validarNSS(String nss) {
        for (Paciente p : pacientes) {
            if (p.getNss().equals(nss)) {
                return p;
            }
        }
        return null;
    }

    public List<Medico> listarMedicos() {
        return medicos;
    }

    public Medico obtenerMedicoPorId(String id) {
        for (Medico m : medicos) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public Cita registrarCita(Paciente paciente, Medico medico, String fecha, String hora) {
        return new Cita(paciente, medico, fecha, hora);
    }
}
