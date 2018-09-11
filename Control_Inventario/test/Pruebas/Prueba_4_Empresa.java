/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.util.List;
import sci.mantenimientos.EmpresaMantenimiento;
import sci.mantenimientos.ProductosMantenimiento;
import sci.persistencia.Empresa;


/**
 *
 * @author Admin105
 */
public class Prueba_4_Empresa {

    public static void main(String[] args) {

        EmpresaMantenimiento eman = new EmpresaMantenimiento();
        ProductosMantenimiento pman = new ProductosMantenimiento();

        //-------------------------------------------
        
//insertar
       
        int idFabricantes = 1;
        String nombreProducto = "45645-c ";
        double precioUnitario = 0.0;
        String descripcionPRoducto = "San City";
        String modelo = "5555-6666";

        int respuesta = pman.guardarProductos(idFabricantes, nombreProducto, precioUnitario, descripcionPRoducto, modelo);
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
        
        List<Empresa> listaEmpresa = null;
        
        listaEmpresa = eman.consultarTodosEmpresa();
        
        System.out.println(listaEmpresa);
        System.exit(0);
         
    }

}
