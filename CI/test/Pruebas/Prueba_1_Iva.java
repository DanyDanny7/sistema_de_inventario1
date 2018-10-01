/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.util.List;
import sci.mantenimientos.EmpresaMantenimiento;
import sci.mantenimientos.IvaMantenimiento;
import sci.mantenimientos.ProductosMantenimiento;
import sci.persistencia.Empresa;


/**
 *
 * @author Admin105
 */
public class Prueba_1_Iva {

    public static void main(String[] args) {

        IvaMantenimiento eman = new IvaMantenimiento();
        ProductosMantenimiento pman = new ProductosMantenimiento();

        //-------------------------------------------
        
//insertar
       
        int idIva = 0;
        double ivaTasa = 1;
        double ivaRetenido = 1;
        double ivaPagado = 1;
        double ivaTotal = 1;
        double subTotalTransaccion = 1;
        double totalTransaccion = 1;
        

        int respuesta = eman.guardarIva(ivaTasa, ivaRetenido, ivaPagado, ivaTotal, subTotalTransaccion, totalTransaccion);
        System.exit(0);
        
        //-----













//insertar
        /*
        int idEmpresa = 0;
        String nombreEmpresa = "empresa 2";
        String ncr = "45645-c ";
        String nit = "0614-1234-123-0";
        String direccionEmpresa = "San City";
        String telefonoEmpresa = "5555-6666";
        String encargadoEmpresa = "el joto";
        String emailEmpresa = "Empresa abc";

        int respuesta = eman.guardarEmpresa(idEmpresa, nombreEmpresa, ncr, nit, direccionEmpresa, telefonoEmpresa, encargadoEmpresa, emailEmpresa);
        System.exit(0);
        */
        //-------------------------------------------------
        //eliminar
        /*
        int idEmpresa =  2;
        int respuesta = eman.eliminarEmpresa(idEmpresa);
        System.out.println(respuesta);
        System.exit(0);
         */
        //-------------------------------------------------
        //modificar
        /*
        int idEmpresa = 3;
        String nombreEmpresa = "empresa 3";
        String direccionEmpresa = "San City";
        String telefonoEmpresa = "5555-6666";
        String encargadoEmpresa = "el joto";

        int respuesta = eman.modificarEmpresa(idEmpresa, nombreEmpresa, direccionEmpresa, telefonoEmpresa, encargadoEmpresa);
        System.exit(0);
         */
        //---------------------------------------------------------
        //consultar id
        /*
        int idContacto = 1;
        List<Empresa> listaEmpresa = null;
        listaEmpresa = eman.consultarEmpresaId(idContacto);
        System.out.println(listaEmpresa);
        System.exit(0);
         */
        //-----------------------------------------------
        // consultar
    }

}
