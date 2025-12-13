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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxCursosAlumno.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        cbxCursosAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Base de Datos", " " }));
        cbxCursosAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursosAlumnoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel1.setText("Sus Cursos:");

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setText("PC1");

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel3.setText("PC2");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel4.setText("PC3");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel5.setText("EF");

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel6.setText("PA");

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        txtPC1.setEditable(false);
        txtPC1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        txtPC1.setText("15");
        txtPC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPC1ActionPerformed(evt);
            }
        });

        txtEF.setEditable(false);
        txtEF.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        txtEF.setText("17");

        txtPA.setEditable(false);
        txtPA.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        txtPA.setText("14");

        txtPC3.setEditable(false);
        txtPC3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        txtPC3.setText("18");

        txtPC2.setEditable(false);
        txtPC2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        txtPC2.setText("12");

        txtPromedioFinal.setEditable(false);
        txtPromedioFinal.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        txtPromedioFinal.setText("15.50");

        txtEstadoNota.setEditable(false);
        txtEstadoNota.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel7)))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtEstadoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPC1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(txtPC2)
                                .addComponent(txtPC3)
                                .addComponent(txtPA)
                                .addComponent(txtEF))
                            .addComponent(txtPromedioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addComponent(txtPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPromedioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEstadoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel8.setText("NOTAS ACADEMICAS");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addComponent(cbxCursosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxCursosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
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
