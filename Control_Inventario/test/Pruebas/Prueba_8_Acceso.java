package Pruebas;

import java.util.List;
import sci.mantenimientos.AccesoMantenimiento;
import sci.persistencia.Acceso;


public class Prueba_8_Acceso {

    public static void main(String[] args) {

        AccesoMantenimiento aman = new AccesoMantenimiento();

        //-------------------------------------------
        //insertar
        /*
        int idAcceso = 1;
        int idEmpresa = 4;
        String nombreAcceso = "acceso 2";
        String apellidoAcceso = "apellido acceso 2";
        String usuario = " usuario 1";
        String fechaRegistroAcceso = "hoy no";
        String contrasena = "la pass";
        String email = "el email";
        String tipoAcceso = "inaccesible";

        int respuesta = aman.guardarAcceso(idAcceso, idEmpresa, nombreAcceso, apellidoAcceso, usuario, fechaRegistroAcceso, contrasena, email, tipoAcceso);
        System.exit(0);
        */
        //-------------------------------------------------
        //eliminar
        /*
        int idAcceso = 8;
        int respuesta = aman.eliminarAcceso(idAcceso);
        System.out.println(respuesta);
        System.exit(0);
         */
        //-------------------------------------------------
        //modificar
        
        int idAcceso = 2;
        int idEmpresa = 1;
        String nombreAcceso = "acceso 3";
        String apellidoAcceso = "apellido acceso 3";
        String usuario = " usuario 1";
        String fechaRegistroAcceso = "hoy si";
        String contrasena = "la pass";
        String email = "el email";
        String tipoAcceso = "inaccesible";

        int respuesta = aman.modificarAcceso(idAcceso, idEmpresa, nombreAcceso, apellidoAcceso, usuario, fechaRegistroAcceso, contrasena, email, tipoAcceso);
        System.exit(0);
        
        //---------------------------------------------------------
        //consultar id
        /*
        int idContacto = 8;
        Acceso acceso = null;
        acceso = aman.consultarAccesoId(idContacto);
        System.out.println(acceso.getApellidoAcceso());
        System.exit(0);
         */
        //-----------------------------------------------
        // consultar
        /*
        List<Acceso> listaAcceso = null;
        
        listaAcceso = aman.consultarTodoAcceso();
        
        System.out.println(listaAcceso);
        System.exit(0);
         */
        //---------------------------------------------------------
        //consultar login
        /*
        String usuario = "periquito";
        String contrasena = "tito tito ";
        //Acceso acceso = null;
        
        int respuesta =  aman.loginAcceso(usuario, contrasena);
        System.out.println(respuesta);
        System.exit(0);
        */
    }

}
