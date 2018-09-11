/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.util.List;
import sci.mantenimientos.ConfiguracionMantenimiento;


/**
 *
 * @author Admin105
 */
public class Prueba_9_Configuracion {

    public static void main(String[] args) {

        ConfiguracionMantenimiento cman = new ConfiguracionMantenimiento();

        //-------------------------------------------
        //insertar
        /*
        int idConfiguracion = 0;
        int idAcceso = 2;
        int idEmpresa = 1;
        byte[] logo = null;
        String simboloMoneda = "E";
        String nombreMoneda = "Euro";
        String codigoMoneda = "ERU";
        double iva = 0.15;
        String zonaHoraria = "CA";

        int respuesta = cman.guardarConfiguracion(idAcceso, idEmpresa, simboloMoneda, nombreMoneda, codigoMoneda, iva, zonaHoraria);
        System.exit(0);
        */
        //-------------------------------------------------
        //eliminar
        /*
        int idConfiguracion = 2;
        int respuesta = cman.eliminarConfiguracion(idConfiguracion);
        System.out.println(respuesta);
        System.exit(0);
        */
        //-------------------------------------------------
        //modificar
        /*
        int idConfiguracion = 3;
        int idAcceso = 2;
        int idEmpresa = 1;
        byte[] logo = null;
        String simboloMoneda = "#";
        String nombreMoneda = "Euro";
        String codigoMoneda = "ERU";
        double iva = 0.15;
        String zonaHoraria = "CA";

        int respuesta = cman.modificarConfiguracion(idConfiguracion, idAcceso, idEmpresa, logo, simboloMoneda, nombreMoneda, codigoMoneda, iva, zonaHoraria);
        System.exit(0);
         */
        //---------------------------------------------------------
        //consultar id
        /*
        int idContacto = 3;
        List<Configuracion> listaConfiguracion = null;
        listaConfiguracion = cman.consultarConfiguarionId(idContacto); 
        System.out.println(listaConfiguracion);
        System.exit(0);
         */
        //-----------------------------------------------
        // consultar
        /*
        List<Configuracion> listaConfiguracion = null;
        
        listaConfiguracion = cman.consultarTodosConfiguracion();
        
        System.out.println(listaConfiguracion);
        System.exit(0);
        */
    }

}
