/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import sci.mantenimientos.Extraer;
import sci.mantenimientos.InventarioMantenimiento;

/**
 *
 * @author guillermo.bermudes
 */
public class PRUEBAEXTRAER {
    public static void main(String[] args) {
        InventarioMantenimiento in = new InventarioMantenimiento();
        System.out.println(in.consultarExistenciacero())    ;
    }
}
