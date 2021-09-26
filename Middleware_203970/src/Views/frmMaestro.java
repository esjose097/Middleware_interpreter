/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Objetos.*;
import datos.Sentpack;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JSpinner;

/**
 *
 * @author Casal
 */
public class frmMaestro extends javax.swing.JFrame implements Runnable{
    private ArrayList<Alumno> listaAlumno;    
    /**
     * Creates new form frmMaestro
     */
    public frmMaestro() {
        initComponents();
        ((JSpinner.DefaultEditor) this.spinEdad.getEditor()).getTextField().setEditable(false);
        this.txtAAlumnos.setEditable(false);
        this.setLocationRelativeTo(null);
        //Lista de alumnos.
        this.listaAlumno = new ArrayList<Alumno>();
        //Hilo para recibir datos.
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtMateria = new javax.swing.JTextField();
        spinEdad = new javax.swing.JSpinner();
        btnEnviar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAAlumnos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profesor");

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Profesor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jLabel2.setText("Nombre:");

        jLabel3.setText("Edad:");

        jLabel4.setText("ID:");

        jLabel5.setText("Materia:");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel6.setText("Lista de alumnos");

        txtAAlumnos.setColumns(20);
        txtAAlumnos.setRows(5);
        jScrollPane1.setViewportView(txtAAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEnviar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre)
                                .addComponent(txtID)
                                .addComponent(txtMateria)
                                .addComponent(spinEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                    .addComponent(btnSalir))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(spinEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if(this.validaSalida() == true)
        {            
            this.enviarPaquete();
        }
    }//GEN-LAST:event_btnEnviarActionPerformed
    
    /**
     * Este método se encarga enviar el paquete por el puerto 5555 al
     * servidor.
     */
    private void enviarPaquete(){
        String datos = this.formatoDON();
        try
        {
        //Envia los datos.
            Socket socket = new Socket("localhost", 5555);
            Sentpack paqueteEnvio = new Sentpack(datos, "profesor");
            ObjectOutputStream enviarDatos = new ObjectOutputStream(socket.getOutputStream());
            enviarDatos.writeObject(paqueteEnvio);
            socket.close();
        }
        catch(Exception e){
            System.err.println(e);
        }        
    }
    /**
     * Método encargado de validar los datos del formulario.
     * @return boolean
     */
    private Boolean validaSalida(){
        int edad = (int) this.spinEdad.getValue();
        if(this.txtNombre.getText().isEmpty()==true||
                this.txtID.getText().isEmpty() == true||
                this.txtMateria.getText().isEmpty() == true||
                edad <= 0){
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     * Método encargado de convertir los datos del formulario
     * a formatoDON.
     * @return String.
     */
    private String formatoDON(){
        String nombre = this.txtNombre.getText();
        String id = this.txtID.getText();
        int edad = (int) this.spinEdad.getValue();
        String clase = this.txtMateria.getText();
        
        //Formato
        String paquete = nombre+","+id+","+edad+","+clase;                        
        return paquete;
    }
    
    /**
     * Método encargado de interpretar los datos recibidos por el servidor
     * y instanciar un objeto de tipo Alumno.
     * @param mensaje
     * @return 
     */
    private Alumno convierteAlumno(String mensaje){
        String datos[] = mensaje.split(",");
        Alumno alumno = new Alumno(datos[0], Integer.parseInt(datos[1]), datos[2]);
        return alumno;
    }
    /**
     * Método encargado de actualizar el textArea.
     */
    private void actualizaTextArea(){
        this.txtAAlumnos.setText("");
        for(Alumno a:this.listaAlumno)
        {
            this.txtAAlumnos.append("Nombre: "+a.getNombre()+" ID: "+a.getId()+" Edad: "+a.getEdad()+"\n");
        }
    }
    
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
            java.util.logging.Logger.getLogger(frmMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMaestro().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinEdad;
    private javax.swing.JTextArea txtAAlumnos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMateria;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    /**
     * Método run del hilo para recibir datos.
     */
    @Override
    public void run() {
        try
        {
            ServerSocket servidor = new ServerSocket(3312);
            while(true)
            {
                Socket mySocket = servidor.accept();
                ObjectInputStream recibeDatos = new ObjectInputStream(mySocket.getInputStream());
                Sentpack paqueteRecibido = (Sentpack) recibeDatos.readObject();
                this.txtAAlumnos.append(paqueteRecibido.getMensaje()+"\n");
                Alumno alumno = this.convierteAlumno(paqueteRecibido.getMensaje());
                this.listaAlumno.add(alumno);
                this.actualizaTextArea();
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
}