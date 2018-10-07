/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.LinkedList;
import java.util.List;
import sci.mantenimientos.ComprasMantenimiento;
import sci.persistencia.Compras;
import sci.persistencia.Contactos;
import sci.persistencia.Iva;

/**
 *
 * @author DanyDanny
 */
public class N_Documento {

    public List unirListas() {
        ComprasMantenimiento cm = new ComprasMantenimiento();

        try {
           List<String> nDocs = cm.consultarTodoComprasGrup();
        System.out.println("ver nDoccumentos " + nDocs);

        int tamano = nDocs.size();
        System.out.println(" tamaño " + tamano);
        String ndo = nDocs.get(0).substring(0);
        String ndo2 = nDocs.get(1).substring(0);
        String ndo3 = nDocs.get(2).substring(0);

        System.out.println(ndo);
        System.out.println(ndo2);
        System.out.println(ndo3);

        String nd = "";
        List<Compras> listaCompras = new LinkedList<>();
        Compras compras;
        Contactos contactos;
        Iva iva;
        for (int i = 0; i < tamano; i++) {
            nd = nDocs.get(i).substring(0);
            List<Compras> lista = cm.consultaNDocumento(nd);
          
            compras = new Compras(lista.get(0).getIdCompra());
            compras.setnDocumento(lista.get(0).getnDocumento());
            compras.setFechaCompra(lista.get(0).getFechaCompra());
            //-------------
            contactos = new Contactos(lista.get(0).getContactos().getIdContacto());
            contactos.setNombreContacto(lista.get(0).getContactos().getNombreContacto());
            compras.setContactos(contactos);
            //-------------
            iva = new Iva(lista.get(0).getIva().getIdIva());
            iva.setTotalTransaccion(lista.get(0).getIva().getTotalTransaccion());
            iva.setSubTotalTransaccion(lista.get(0).getIva().getSubTotalTransaccion());
            iva.setIvaPagado(lista.get(0).getIva().getIvaPagado());
            compras.setIva(iva);
            
            listaCompras.add(compras);
        }
        return listaCompras;
        } catch (Exception e) {
            System.out.println(" error porqe "+e);
            return null;
        }
    }

    public static void main(String[] args) {
        N_Documento n = new N_Documento();
        List<Compras> lisaCompras = n.unirListas();
        System.out.println("Lista "+lisaCompras);
        ComprasMantenimiento cm = new ComprasMantenimiento();
        
        
       double tt = cm.consultarComprasId(40).getIva().getTotalTransaccion();
        System.out.println(tt);
        
        System.exit(0);
    }
}
