/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.actionforms;

import java.io.File;

/**
 *
 * @author daniel.bonillausam
 */
public class ActionFormUpload extends org.apache.struts.action.Action {
    
    private Integer idConfiguracion;
    //private File file;
    private String action;
    private String mensaje;
/*
    public File getFile() {
        return file;
    }
*/
    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    
    /*
    public void setFile(File file) {
        this.file = file;
    }
*/
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
