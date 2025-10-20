/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.CitaController;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;
import modelo.AgendaService;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author PC
 */
public class ConsolaVista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AgendaService servicio = new AgendaService();
        CitaController ctrl = new CitaController(servicio);

        System.out.println("=== Registrar Cita Medica ===");
        Paciente paciente = null;
        while (paciente == null) {
            System.out.print("Ingrese NSS: ");
            String nss = sc.nextLine().trim();
            paciente = ctrl.validarPaciente(nss);
            if (paciente == null) {
                System.out.println("NSS no encontrado, intente de nuevo.\n");
            }
        }

        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("\nMedicos disponibles:");
        ctrl.mostrarMedicos();

        Medico medico = null;
        while (medico == null) {
            System.out.print("\nSeleccione ID del medico: ");
            String idMedico = sc.nextLine().trim();
            medico = ctrl.seleccionarMedico(idMedico);
            if (medico == null) {
                System.out.println("Medico no encontrado, intente nuevamente.");
            }
        }

        String fecha = leerFechaValida(sc);
        String hora = leerHoraValida(sc);

        Cita cita = ctrl.crearCita(paciente, medico, fecha, hora);
        System.out.println("\n" + cita);
    }

    private static String leerFechaValida(Scanner sc) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        while (true) {
            System.out.print("Fecha (dd/MM/uuuu): ");
            String s = sc.nextLine().trim();
            try {
                LocalDate.parse(s, f);
                return s;
            } catch (Exception e) {
                System.out.println("Fecha invalida, use formato dd/MM/uuuu.");
            }
        }
    }

    private static String leerHoraValida(Scanner sc) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm").withResolverStyle(ResolverStyle.STRICT);
        while (true) {
            System.out.print("Hora (HH:mm): ");
            String s = sc.nextLine().trim();
            try {
                LocalTime.parse(s, f);
                return s;
            } catch (Exception e) {
                System.out.println("Hora invalida, use formato HH:mm (24h).");
            }
        }
    }
}