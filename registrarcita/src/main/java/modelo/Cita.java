/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */


public class Cita {
    private Paciente paciente;
    private Medico medico;
    private String fecha;
    private String hora;

    public Cita(Paciente paciente, Medico medico, String fecha, String hora) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Cita registrada:\nPaciente: " + paciente.getNombre() + 
               "\nMedico: " + medico.getNombre() +
               "\nEspecialidad: " + medico.getEspecialidad() +
               "\nConsultorio: " + medico.getConsultorio() +
               "\nFecha: " + fecha + 
               "\nHora: " + hora;
    }
}
