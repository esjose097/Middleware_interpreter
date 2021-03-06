/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.net.ServerSocket;
import java.net.Socket;
import Interpreter.*;
import datos.Sentpack;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Casal
 */
public class servidor extends javax.swing.JFrame implements Runnable {

    private ArrayList<Socket> clientes;        
    /**
     * Creates new form servidor
     */
    public servidor() {
        initComponents();
        this.txtAPaquetes.setEditable(false);
        setLocationRelativeTo(null);
        //Se intancea el hilo del servidor.
        Thread hilo = new Thread(this);
        hilo.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAPaquetes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor(Middleware)");

        txtAPaquetes.setColumns(20);
        txtAPaquetes.setRows(5);
        jScrollPane1.setViewportView(txtAPaquetes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAPaquetes;
    // End of variables declaration//GEN-END:variables

    /**
     * M??todo run del hilo.
     */
    @Override
    public void run() {
        try
        {
            ServerSocket servidor = new ServerSocket(5555);            
            while(true)
            {                
                //Recibe datos
                Socket mySocket = servidor.accept();
                ObjectInputStream recibeDatos = new ObjectInputStream(mySocket.getInputStream());
                Sentpack paqueteRecibido = (Sentpack)recibeDatos.readObject();
                this.txtAPaquetes.append("Recibiendo paquete de: "+paqueteRecibido.getRemitente()+
                        "  Mensaje: "+paqueteRecibido.getMensaje()+"\n");
                
                //Identifica el remitente y por inersia identifica al destinatario
                if(paqueteRecibido.getRemitente().equalsIgnoreCase("alumno"))
                {
                    try
                    {                        
                        this.txtAPaquetes.append("Convirtiendo de CON a DON"+"\n");
                        Context context = new Context(paqueteRecibido.getMensaje(), FormatEnums.DON, FormatEnums.CON);
                        String mensajeConvertido = InterpreterClient.interpretar(context);
                        Socket socketProfe = new Socket("localhost", 3312);
                        Sentpack paqueteEnvio = new Sentpack(mensajeConvertido, "Alumno");
                        ObjectOutputStream enviaDatos = new ObjectOutputStream(socketProfe.getOutputStream());
                        enviaDatos.writeObject(paqueteEnvio);
                        socketProfe.close();
                    }
                    catch(IOException e){
                        System.err.println(e);
                    }
                    
                }
                else if(paqueteRecibido.getRemitente().equalsIgnoreCase("profesor"))
                {
                    this.txtAPaquetes.append("Convirtiendo de DON a CON"+"\n");
                    Context context = new Context(paqueteRecibido.getMensaje(), FormatEnums.CON, FormatEnums.DON);
                    String mensajeConvertido = InterpreterClient.interpretar(context);
                    Socket socketAlumno = new Socket("localhost", 4444);
                    Sentpack paqueteEnvio = new Sentpack(mensajeConvertido, "profesor");
                    ObjectOutputStream enviaDatos = new ObjectOutputStream(socketAlumno.getOutputStream());
                    enviaDatos.writeObject(paqueteEnvio);
                    socketAlumno.close();
                }                                               
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
    
    public void identificarDestino(){
        
    }
}
