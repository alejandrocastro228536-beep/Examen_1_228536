/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public class Paciente {
    private String nss;
    private String nombre;

    public Paciente(String nss, String nombre) {
        this.nss = nss;
        this.nombre = nombre;
    }

    public String getNss() {
        return nss;
    }

    public String getNombre() {
        return nombre;
    }
}