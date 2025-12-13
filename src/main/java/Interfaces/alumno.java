/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.NotaDAO;
import java.sql.SQLException;
/**
 *
 * @author leand
 */
public class Alumno extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Alumno.class.getName());

    private int nuevoAlumno;
    NotaDAO Ndao = new NotaDAO();
    public Alumno(int idAlumno) {
        initComponents();
        this.nuevoAlumno=idAlumno;
        this.txtIdAlumno.setText(String.valueOf(this.nuevoAlumno));
        ListarCursosAlumnoPorId(Integer.parseInt(txtIdAlumno.getText()));
        txtIdAlumno.setVisible(false);
    }
    
    private void ListarCursosAlumnoPorId(int idAlumno){
        
        cbxCursosAlumno.removeAllItems();
        cbxCursosAlumno.addItem("Seleccione");
        try (ResultSet rs = Ndao.listarCursosPorAlumno(idAlumno)) { // Usa el DAO de Curso
            while (rs.next()) {
                // Se añade el nombre del curso, como solicitaste
                cbxCursosAlumno.addItem(rs.getString("curso"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar cursos para matrícula: " + e.getMessage());
        }
    }
    private void ListarNotasAlumnoporId(int idAlumno, String nombreCurso) {
    try {
        try (ResultSet rs = Ndao.listarNotasAlumno(idAlumno, nombreCurso)) {
            
            // Mover el cursor a la primera (y única) fila
            if (rs.next()) { 
                // Si encontramos la nota, la cargamos
                txtPC1.setText(rs.getString("PC1"));
                txtPC2.setText(rs.getString("PC2"));
                txtPC3.setText(rs.getString("PC3"));
                txtPA.setText(rs.getString("PA"));
                txtEF.setText(rs.getString("EF"));
                txtPromedioFinal.setText(rs.getString("promedio_final"));
                txtEstadoNota.setText(rs.getString("estado"));
            } else {
                // Si no encontramos la nota (debería ser raro, pero es posible si no hay notas registradas)
                JOptionPane.showMessageDialog(null, "No se encontraron notas para el curso seleccionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                // Limpiar los campos para evitar confusión
                limpiarCamposNotas(); 
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error SQL al obtener notas: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar notas del alumno: " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        cbxCursosAlumno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPC1 = new javax.swing.JTextField();
        txtEF = new javax.swing.JTextField();
        txtPA = new javax.swing.JTextField();
        txtPC3 = new javax.swing.JTextField();
        txtPC2 = new javax.swing.JTextField();
        txtPromedioFinal = new javax.swing.JTextField();
        txtIdAlumno = new javax.swing.JTextField();
        txtEstadoNota = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTextField7.setText("jTextField7");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxCursosAlumno.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        cbxCursosAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Base de Datos", " " }));
        cbxCursosAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursosAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(cbxCursosAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 210, 50));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel1.setText("Sus Cursos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setText("PC1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 45, -1, -1));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel3.setText("PC2");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 112, -1, -1));

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel4.setText("PC3");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 168, -1, -1));

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel5.setText("EF");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 261, -1, -1));

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel6.setText("PA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 213, -1, -1));

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 373, -1, -1));

        txtPC1.setEditable(false);
        txtPC1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        txtPC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPC1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtPC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 123, -1));

        txtEF.setEditable(false);
        txtEF.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jPanel1.add(txtEF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 266, 123, -1));

        txtPA.setEditable(false);
        txtPA.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jPanel1.add(txtPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 217, 123, -1));

        txtPC3.setEditable(false);
        txtPC3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jPanel1.add(txtPC3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 163, 123, -1));

        txtPC2.setEditable(false);
        txtPC2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jPanel1.add(txtPC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 106, 123, -1));

        txtPromedioFinal.setEditable(false);
        txtPromedioFinal.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        txtPromedioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPromedioFinalActionPerformed(evt);
            }
        });
        jPanel1.add(txtPromedioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 101, 53));
        jPanel1.add(txtIdAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        txtEstadoNota.setEditable(false);
        txtEstadoNota.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jPanel1.add(txtEstadoNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 127, 38));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 153, 330, -1));

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel8.setText("NOTAS ACADEMICAS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 37, -1, -1));

        jMenu1.setText("Inicio");

        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPC1ActionPerformed

    private void cbxCursosAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursosAlumnoActionPerformed
       String curso = (String) cbxCursosAlumno.getSelectedItem();
    
    // Validar si el elemento seleccionado es el placeholder
    if (curso != null && !curso.equals("Seleccione")) {
        // Ejecutar la búsqueda de notas solo si se seleccionó un curso real
        ListarNotasAlumnoporId(Integer.parseInt(txtIdAlumno.getText()), curso);
    } else {
        // Si selecciona "Seleccione" o es nulo (puede pasar al remover items)
        limpiarCamposNotas();
    }
    }//GEN-LAST:event_cbxCursosAlumnoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtPromedioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPromedioFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPromedioFinalActionPerformed

    private void limpiarCamposNotas() {
        txtPC1.setText("0.00");
        txtPC2.setText("0.00");
        txtPC3.setText("0.00");
        txtPA.setText("0.00");
        txtEF.setText("0.00");
        txtPromedioFinal.setText("0.00");
    }
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Alumno(DO_NOTHING_ON_CLOSE).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCursosAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField txtEF;
    private javax.swing.JTextField txtEstadoNota;
    private javax.swing.JTextField txtIdAlumno;
    private javax.swing.JTextField txtPA;
    private javax.swing.JTextField txtPC1;
    private javax.swing.JTextField txtPC2;
    private javax.swing.JTextField txtPC3;
    private javax.swing.JTextField txtPromedioFinal;
    // End of variables declaration//GEN-END:variables
}
