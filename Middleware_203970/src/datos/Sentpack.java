/**
 * Clase creada con el objetivo de empaquetar los datos antes de enviarlos.
 */
package datos;

import java.io.Serializable;

/**
 *
 * @author Casal
 */
public class Sentpack implements Serializable{
    private String mensaje;
    private String remitente;

    public Sentpack(String mensaje, String remitente) {
        this.mensaje = mensaje;
        this.remitente = remitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }        
}
