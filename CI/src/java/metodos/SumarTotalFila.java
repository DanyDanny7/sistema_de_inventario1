package metodos;

import java.util.List;
import sci.mantenimientos.FacturaDetalleMantenimiento;
import sci.persistencia.FacturaDetalle;

/**
 *
 * @author DanyDanny
 */
public class SumarTotalFila {

    public Double sumarTotalFila(int idFacturaEncabezado) {
        //suma la columna de "TotalFila" dentro de Factura Detalle tras recibir un id de Factura Encabezado.
        FacturaDetalleMantenimiento fdman = new FacturaDetalleMantenimiento();
        double suma = 0.0;

        try {
            List<FacturaDetalle> listaFactura = fdman.consultaFacturaEspecifica(idFacturaEncabezado);
            //System.out.println("lista "+listaFactura.toString());
            //System.out.println("ver "+listaFactura.size());
            if (listaFactura.size() > 0) {
                for (int i = 0; i < listaFactura.size(); i++) {
                    suma += listaFactura.get(i).getTotalFila();
                }
            }
        } catch (Exception e) {
            System.out.println("error en el catch de sumar total fila "+e);
            suma = 0.0;
        }
        return suma;
    }

    public static void main(String[] args) {

        SumarTotalFila su = new SumarTotalFila();
        double suma = su.sumarTotalFila(22);
        System.out.println("Ver resultado final suma " + suma);

    }
}
