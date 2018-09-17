/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.action;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sci.actionforms.ActionFormConfiguracion;
import sci.actionforms.ActionFormUpload;
import sci.mantenimientos.ConfiguracionMantenimiento;

/**
 *
 * @author daniel.bonillausam
 */
public class UploadAction extends org.apache.struts.action.Action{
    
    private static final String UPLOAD  = "irUpload";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ConfiguracionMantenimiento cman = new ConfiguracionMantenimiento();
        
       ActionFormConfiguracion formBean = (ActionFormConfiguracion) form;
        
        Integer idConfiguracion = formBean.getIdConfiguracion();
        Integer idAcceso = formBean.getIdAcceso();
        Integer idEmpresa = formBean.getIdEmpresa();
        String nombreMoneda = formBean.getNombreMoneda();
        Double iva = formBean.getIva();
        String zonaHoraria = "";
        String action = formBean.getAction();
        
        byte[] logo = formBean.getLogo();
        String logo1 = formBean.getLogo1();
        File file = formBean.getFile();
        
        System.out.println("antes ");
        if (action.equals("cargar")) {
            System.out.println("entro´5");
            
        }
        
        
        
        
        
        
        return mapping.findForward(UPLOAD);
    }
    
    
}
