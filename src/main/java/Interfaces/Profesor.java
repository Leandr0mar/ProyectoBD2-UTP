/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Conexion.CursoDAO;
import Conexion.MatriculaDAO;
import Conexion.NotaDAO;
import static java.awt.Frame.WAIT_CURSOR;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leand
 */
public class Profesor extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Profesor.class.getName());
      private DefaultTableModel modeloTabla;
      private NotaDAO dao = new NotaDAO();
      CursoDAO cursoDao = new CursoDAO();
      MatriculaDAO matriculaDao = new MatriculaDAO();
      
    private int nuevoId;
      
    public Profesor(int idProfesor) {
        initComponents();
        this.nuevoId=idProfesor;
        this.txtIdProfesor.setText(String.valueOf(this.nuevoId));
        configurarTablaNotas();
        cargarNotasEnTabla();
        cargarCursosEnCombo();
        txtAlumno.setEnabled(false);
    }

    
    
    private void configurarTablaNotas() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{
            "ID Nota", "Alumno", "Curso", "Periodo",
            "PC1", "PC2", "PC3", "PA", "EF",
            "Promedio", "Estado"
        });
        TablaNotas.setModel(modeloTabla);
    }
    
    private void limpiarTablaNotas() {
        if (modeloTabla != null) {
            modeloTabla.setRowCount(0);
        }
    }
    
    
    private void cargarNotasEnTabla() {
        limpiarTablaNotas();
        int idProfesor= Integer.parseInt(txtIdProfesor.getText());
        
        // Llamamos al DAO para obtener la lista de notas
        List<Object[]> lista = dao.listarNotasPorId(idProfesor);

        // Recorremos y agregamos cada fila al modelo de la tabla
        for (Object[] fila : lista) {
            modeloTabla.addRow(fila);
        }
    }
    
    void limpiarCamposNota() {
    txtCodigo_Nota.setText("");
    txtAlumno.setText("");
    txtperiodo.setText("");
    txtpc1.setText("");
    txtpc2.setText("");
    txtpc3.setText("");
    txtpa.setText("");
    txtef.setText("");
    txtEstado.setText("");
    // NO tocar cboCursos aquí
}


    private void cargarCursosEnCombo() {
        cboCursos.removeAllItems();
        cboCursos.addItem("Seleccione curso...");

        for (String nombre : cursoDao.listarCursosParaComboNotas(Integer.parseInt(txtIdProfesor.getText()))) {
            cboCursos.addItem(nombre);
        }
    }
    
    private void filtrarNotasPorCurso() {
    if (cboCursos.getSelectedIndex() <= 0) {
        return;
    }

    String item = cboCursos.getSelectedItem().toString(); // "1 Matemática"
    int idCurso = Integer.parseInt(item.split(" ")[0]);    // → 1

    NotaDAO dao = new NotaDAO();
    List<Object[]> lista = dao.listarNotasPorCursoId(idCurso,Integer.parseInt(txtIdProfesor.getText()));

    DefaultTableModel modelo = (DefaultTableModel) TablaNotas.getModel();
    modelo.setRowCount(0); // Borrar tabla

    for (Object[] fila : lista) {
        modelo.addRow(fila);
    }
}    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo_Nota = new javax.swing.JTextField();
        txtAlumno = new javax.swing.JTextField();
        cboCursos = new javax.swing.JComboBox<>();
        txtperiodo = new javax.swing.JTextField();
        txtpc1 = new javax.swing.JTextField();
        txtpc2 = new javax.swing.JTextField();
        txtpc3 = new javax.swing.JTextField();
        txtpa = new javax.swing.JTextField();
        txtef = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNotas = new javax.swing.JTable();
        txtIdProfesor = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("CODIGO_NOTA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 147, -1, -1));

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel10.setText("ALUMNO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 38, -1, -1));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("CURSO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 84, -1, -1));

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("PERIODO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("PC2 (20%)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setText("PC1 (20%)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel8.setText("PC3 (20%)");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setText("PA (10%)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel11.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel11.setText("EF (30%)");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel9.setText("ESTADO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        txtCodigo_Nota.setEditable(false);
        txtCodigo_Nota.setEnabled(false);
        jPanel1.add(txtCodigo_Nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 72, 175, 40));

        txtAlumno.setEditable(false);
        txtAlumno.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jPanel1.add(txtAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 33, 175, -1));

        cboCursos.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cboCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cursos", " " }));
        cboCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboCursosMouseClicked(evt);
            }
        });
        cboCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCursosActionPerformed(evt);
            }
        });
        jPanel1.add(cboCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 130, 192, 50));

        txtperiodo.setEditable(false);
        txtperiodo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jPanel1.add(txtperiodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 110, -1));

        txtpc1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jPanel1.add(txtpc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 110, -1));

        txtpc2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jPanel1.add(txtpc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 110, -1));

        txtpc3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jPanel1.add(txtpc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 110, -1));

        txtpa.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jPanel1.add(txtpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 110, -1));

        txtef.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jPanel1.add(txtef, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 110, -1));

        txtEstado.setEditable(false);
        txtEstado.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtEstado.setEnabled(false);
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 110, -1));

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, -1, -1));

        TablaNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_Nota", "Alumno", "Curso", "Periodo", "PC1", "PC2", "PC3", "PA", "EF", "Promedio", "Estado"
            }
        ));
        TablaNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaNotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaNotas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 62, 925, 536));
        jPanel1.add(txtIdProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 18, -1, -1));

        jTabbedPane1.addTab("Notas", jPanel1);

        jMenu1.setText("Inicio");

        jMenuItem1.setText("Cerar secion");
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
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaNotasMouseClicked
        // TODO add your handling code here:

        int fila = TablaNotas.getSelectedRow();

        if (fila >= 0) {
            txtCodigo_Nota.setText(TablaNotas.getValueAt(fila, 0).toString()); // idNota
            txtAlumno.setText(TablaNotas.getValueAt(fila, 1).toString());
            txtperiodo.setText(TablaNotas.getValueAt(fila, 3).toString());
            txtpc1.setText(TablaNotas.getValueAt(fila, 4).toString());
            txtpc2.setText(TablaNotas.getValueAt(fila, 5).toString());
            txtpc3.setText(TablaNotas.getValueAt(fila, 6).toString());
            txtpa.setText(TablaNotas.getValueAt(fila, 7).toString());
            txtef.setText(TablaNotas.getValueAt(fila, 8).toString());
            txtEstado.setText(TablaNotas.getValueAt(fila, 10).toString());

            // NUEVO: seleccionar curso en el combo
            String cursoTabla = TablaNotas.getValueAt(fila, 2).toString(); // ej: "Fundamentos de Informatica"

            for (int i = 0; i < cboCursos.getItemCount(); i++) {
                String item = cboCursos.getItemAt(i).toString();
                // si tus items son "1 - INF101 - Fundamentos de Informatica"
                if (item.contains(cursoTabla)) {
                    cboCursos.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_TablaNotasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (txtCodigo_Nota.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecciona una nota para actualizar.");
            return;
        }

        try {
            int idNota = Integer.parseInt(txtCodigo_Nota.getText());

            BigDecimal pc1 = new BigDecimal(txtpc1.getText());
            BigDecimal pc2 = new BigDecimal(txtpc2.getText());
            BigDecimal pc3 = new BigDecimal(txtpc3.getText());
            BigDecimal pa  = new BigDecimal(txtpa.getText());
            BigDecimal ef  = new BigDecimal(txtef.getText());

            NotaDAO dao = new NotaDAO();
            int resultado = dao.actualizarNota(idNota, pc1, pc2, pc3, pa, ef);

            if (resultado == 1) {
                JOptionPane.showMessageDialog(this, "Nota actualizada correctamente.");

                // 1) Recargar las notas del mismo curso seleccionado
            filtrarNotasPorCurso();   // método que usa el combo y NotasDAO.listarNotasPorCurso

            // 2) Limpiar solo los campos, no el combo
        limpiarCamposNota();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar la nota.");
        }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Las notas deben ser números válidos.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboCursosMouseClicked

    }//GEN-LAST:event_cboCursosMouseClicked

    private void cboCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCursosActionPerformed
        cboCursos.addActionListener(e -> filtrarNotasPorCurso());
    }//GEN-LAST:event_cboCursosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        Login lo= new Login();
        lo.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Profesor(DO_NOTHING_ON_CLOSE).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaNotas;
    private javax.swing.JComboBox<String> cboCursos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtCodigo_Nota;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdProfesor;
    private javax.swing.JTextField txtef;
    private javax.swing.JTextField txtpa;
    private javax.swing.JTextField txtpc1;
    private javax.swing.JTextField txtpc2;
    private javax.swing.JTextField txtpc3;
    private javax.swing.JTextField txtperiodo;
    // End of variables declaration//GEN-END:variables
}
