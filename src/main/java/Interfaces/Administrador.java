/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Conexion.UsuarioDAO;
import Conexion.PeriodoAcademicoDAO;
import Conexion.conexionBd;
import Objeto.PeriodoAcademico;
import Objeto.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leand
 */
public class Administrador extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Administrador.class.getName());
    
    UsuarioDAO Udao= new UsuarioDAO();
    PeriodoAcademicoDAO Pdao = new PeriodoAcademicoDAO();
    DefaultTableModel modeloUsuario,modeloUsuarioFiltrado,modeloPeriodoAcademico;
    Connection con;
    conexionBd co = new conexionBd();
    PreparedStatement ps;
    ResultSet rs;
    
    public Administrador() {
        initComponents();
        txtCodigoUsuario.setVisible(false);
        listarUsuarios();
        listarPeriodoAcademico(); 
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        cbxRol = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        btnRegistrarUsuario = new javax.swing.JButton();
        btbLimpiarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        txtCodigoUsuario = new javax.swing.JTextField();
        txtBuscaUsuarios = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPeriodosAcademicos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoPeriodo = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        cbxEstadoPeriodoAcademico = new javax.swing.JComboBox<>();
        btnRegistroPeriodo = new javax.swing.JButton();
        btnLimpiarPeriodo = new javax.swing.JButton();
        btnActualizarPeriodo = new javax.swing.JButton();
        btnEliminarPeriodo = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 28)); // NOI18N
        jLabel1.setText("REGISTRO DE USUARIOS");

        tblUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Email", "Contraseña", "Nombre Completo", "DNI", "Rol", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel3.setText("Correo:");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel4.setText("Nombre Completo: ");

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setText("DNI: ");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel5.setText("Rol: ");

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel6.setText("Estado: ");

        txtCorreo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        txtNombres.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        txtDNI.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        cbxRol.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "administrador", "profesor", "alumno" }));
        cbxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolActionPerformed(evt);
            }
        });

        cbxEstado.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "activo", "inactivo" }));

        btnRegistrarUsuario.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnRegistrarUsuario.setText("Registrar");
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });

        btbLimpiarUsuario.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btbLimpiarUsuario.setText("Limpiar");
        btbLimpiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbLimpiarUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel7.setText("Contraseña:");

        txtContrasena.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        txtCodigoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoUsuarioActionPerformed(evt);
            }
        });

        txtBuscaUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaUsuariosKeyReleased(evt);
            }
        });

        jLabel8.setText("Buscador de Usuarios: ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegistrarUsuario)
                                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btbLimpiarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2))
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cbxRol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbxEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 142, Short.MAX_VALUE))
                                                .addGap(66, 66, 66))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(4, 4, 4))
                                                    .addComponent(txtContrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(48, 48, 48)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(465, 465, 465))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btbLimpiarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Usuarios", jPanel6);

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 28)); // NOI18N
        jLabel9.setText("REGISTRO DE PERIODOS ACADEMICOS");

        tblPeriodosAcademicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Fecha Inicio", "Fecha Fin", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPeriodosAcademicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeriodosAcademicosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPeriodosAcademicos);

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel10.setText("Codigo: ");

        jLabel11.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel11.setText("Fecha Inicio:");

        jLabel12.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel12.setText("Fecha Fin:");

        jLabel13.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel13.setText("Estado:");

        txtCodigoPeriodo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        txtFechaInicio.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });

        txtFechaFin.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        cbxEstadoPeriodoAcademico.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cbxEstadoPeriodoAcademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "activo", "inactivo" }));

        btnRegistroPeriodo.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        btnRegistroPeriodo.setText("Registrar");
        btnRegistroPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroPeriodoActionPerformed(evt);
            }
        });

        btnLimpiarPeriodo.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        btnLimpiarPeriodo.setText("Limpiar");
        btnLimpiarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPeriodoActionPerformed(evt);
            }
        });

        btnActualizarPeriodo.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        btnActualizarPeriodo.setText("Modificar");
        btnActualizarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPeriodoActionPerformed(evt);
            }
        });

        btnEliminarPeriodo.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        btnEliminarPeriodo.setText("Eliminar");
        btnEliminarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel9))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(70, 70, 70)
                                .addComponent(cbxEstadoPeriodoAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCodigoPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(txtFechaInicio)
                                    .addComponent(txtFechaFin)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnActualizarPeriodo)
                                    .addComponent(btnRegistroPeriodo))
                                .addGap(69, 69, 69)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLimpiarPeriodo)
                                    .addComponent(btnEliminarPeriodo))))
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCodigoPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(cbxEstadoPeriodoAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(137, 137, 137)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnActualizarPeriodo)
                                    .addComponent(btnEliminarPeriodo))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLimpiarPeriodo)
                                    .addComponent(btnRegistroPeriodo))
                                .addGap(162, 162, 162))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane2.addTab("Periodos Academicos", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Cursos", jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab4", jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab5", jPanel10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("Gestion de Datos", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1419, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1419, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1419, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1419, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel5);

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
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolActionPerformed

    private void btbLimpiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbLimpiarUsuarioActionPerformed
        LimpiarCamposUsuarios();
    }//GEN-LAST:event_btbLimpiarUsuarioActionPerformed

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        if(validarCamposUsuario()){
            
            String correo = txtCorreo.getText();
            String contra = txtContrasena.getText();
            String nombre = txtNombres.getText();
            String dni = txtDNI.getText();
            String rol= cbxRol.getSelectedItem().toString();
            String estado= cbxEstado.getSelectedItem().toString();
            boolean estadofinal;
            if(estado.equals("activo")) estadofinal=true;
            else if(estado.equals("inactivo"))estadofinal=false;
            else {
                JOptionPane.showMessageDialog(this, "Error al insertar Estado");
                return;
            }
            
            Usuario nuevoUsuario= new Usuario(correo,contra,nombre,dni,rol,estadofinal);
            
            if(Udao.registrarUsuario(nuevoUsuario)){
                JOptionPane.showMessageDialog(this, "Usuario Registrado correctamente.");
                listarUsuarios();
                LimpiarCamposUsuarios();
            } else {
                JOptionPane.showMessageDialog(this, """
                                                    Error al registrar Usuario,posible razones:
                                                    -DNI o Correo duplicado
                                                    -Valores incorrectos(DNI)
                                                    -No ingreso un correo valido
                                                    """);
            }
        }
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        int fila = tblUsuarios.getSelectedRow();
        if (fila >= 0) {
            String correo = tblUsuarios.getValueAt(fila, 1).toString();
            obtenerDatosUsuarioPorCorreo(correo);
            txtCorreo.setText(correo);
            txtContrasena.setText(tblUsuarios.getValueAt(fila, 2).toString());
            txtNombres.setText(tblUsuarios.getValueAt(fila, 3).toString());
            txtDNI.setText(tblUsuarios.getValueAt(fila, 4).toString());
            cbxRol.setSelectedItem(tblUsuarios.getValueAt(fila, 5).toString());
            cbxEstado.setSelectedItem(tblUsuarios.getValueAt(fila, 6).toString());
            txtCodigoUsuario.setText(tblUsuarios.getValueAt(fila,0).toString());
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void txtCodigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        if (txtCodigoUsuario.getText().trim().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Seleccione un Usuario de la tabla para modificar");
            LimpiarCamposUsuarios();
            return;
        }
        
        if(validarCamposUsuario()){
            
            String correo = txtCorreo.getText();
            String contra = txtContrasena.getText();
            String nombre = txtNombres.getText();
            String dni = txtDNI.getText();
            String rol= cbxRol.getSelectedItem().toString();
            String estado= cbxEstado.getSelectedItem().toString();
            boolean estadofinal;
            if(estado.equals("activo")) estadofinal=true;
            else if(estado.equals("inactivo"))estadofinal=false;
            else {
                JOptionPane.showMessageDialog(this, "Error en el campo Estado");
                return;
            }
            String codUsuario=txtCodigoUsuario.getText();
            
            Usuario nuevoUsuario= new Usuario(codUsuario, correo, contra, nombre, dni, rol, estadofinal);
            int confirm = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro de modificar este Usuario?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (Udao.actualizarUsuario(nuevoUsuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente");
                    listarUsuarios();
                    LimpiarCamposUsuarios();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar Usuario");
                }
            }
        }
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void txtBuscaUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaUsuariosKeyReleased
        buscarMatriculas(txtBuscaUsuarios.getText());
    }//GEN-LAST:event_txtBuscaUsuariosKeyReleased

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        if (txtCodigoUsuario.getText().trim().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Seleccione un Usuario de la tabla para modificar");
            LimpiarCamposUsuarios();
            return;
        }
        
        String codigo=txtCodigoUsuario.getText();
        String nombre=txtNombres.getText();

        int confirm = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de eliminar al Usuario " + nombre + "?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (Udao.eliminarUsuario(codigo)) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado exitosamente");
                listarUsuarios();
                LimpiarCamposUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar alumno. Verifique que no tenga matrículas asociadas");
            }
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnLimpiarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPeriodoActionPerformed
        LimpiarCamposPeriodos();
    }//GEN-LAST:event_btnLimpiarPeriodoActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void btnRegistroPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroPeriodoActionPerformed
        String codigo = txtCodigoPeriodo.getText();
        String fechaInicio = txtFechaInicio.getText();
        String fechaFin = txtFechaFin.getText();
        boolean activo = cbxEstadoPeriodoAcademico.getSelectedItem().toString().equalsIgnoreCase("activo");


        PeriodoAcademico nuevoPeriodo = new PeriodoAcademico(codigo, fechaInicio, fechaFin, activo);

        if (Pdao.registrarPeriodo(nuevoPeriodo)) {
            JOptionPane.showMessageDialog(this, "Periodo Registrado correctamente.");

            listarPeriodoAcademico(); 
            LimpiarCamposPeriodos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar. Revise formato de fechas o código duplicado.");
        }
    }//GEN-LAST:event_btnRegistroPeriodoActionPerformed

    private void btnActualizarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPeriodoActionPerformed
        if (txtCodigoPeriodo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un Periodo de la tabla para modificar.");
            return;
        }


        String codigo = txtCodigoPeriodo.getText();
        String fechaInicio = txtFechaInicio.getText(); 
        String fechaFin = txtFechaFin.getText();
        
        String activo= cbxEstadoPeriodoAcademico.getSelectedItem().toString();
        boolean activoFinal;
        if(activo.equals("activo")) activoFinal=true;
        else if(activo.equals("inactivo"))activoFinal=false;
        else{
            JOptionPane.showMessageDialog(this, "Error en el campo Estado");
            return;
            }
        PeriodoAcademico periodoModificado = new PeriodoAcademico(codigo, fechaInicio, fechaFin, activoFinal);

        if (Pdao.actualizarPeriodo(codigo, periodoModificado)) {
            JOptionPane.showMessageDialog(this, "Periodo modificado exitosamente.");
            listarPeriodoAcademico();
            LimpiarCamposPeriodos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar. Revise fechas o código duplicado.");
        }
    }//GEN-LAST:event_btnActualizarPeriodoActionPerformed

    private void btnEliminarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeriodoActionPerformed
        if (txtCodigoPeriodo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un Periodo de la tabla para eliminar.");
            return;
        }

        String codigo = txtCodigoPeriodo.getText(); // Para la confirmación visual

        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar el Periodo " + codigo + "?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (Pdao.eliminarPeriodo(codigo)) {
                JOptionPane.showMessageDialog(this, "Periodo eliminado exitosamente.");
                listarPeriodoAcademico();
                LimpiarCamposPeriodos();
            } 
        }
    }//GEN-LAST:event_btnEliminarPeriodoActionPerformed

    private void tblPeriodosAcademicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeriodosAcademicosMouseClicked
        int fila = tblPeriodosAcademicos.getSelectedRow();
        if (fila >= 0) {
            String codigo = tblPeriodosAcademicos.getValueAt(fila, 0).toString();
            obtenerDatosPeriodoPorCodigo(codigo);
            txtCodigoPeriodo.setText(codigo);
            txtFechaInicio.setText(tblPeriodosAcademicos.getValueAt(fila, 1).toString());
            txtFechaFin.setText(tblPeriodosAcademicos.getValueAt(fila, 2).toString());
            cbxEstadoPeriodoAcademico.setSelectedItem(tblPeriodosAcademicos.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tblPeriodosAcademicosMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Login l = new Login();
        this.dispose();
        l.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    //Metodos para Gestion de Datos (Usuarios)
    
    void LimpiarCamposUsuarios(){
        txtCodigoUsuario.setText("");
        txtCorreo.setText("");
        txtContrasena.setText("");
        txtNombres.setText("");
        txtDNI.setText("");
        cbxRol.setSelectedIndex(0);
        cbxEstado.setSelectedIndex(0);
    }
    
    void listarUsuarios() {
        modeloUsuario = (DefaultTableModel) tblUsuarios.getModel();
        modeloUsuario.setRowCount(0);

        try {
            ResultSet rs = Udao.listarUsuarios();
            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getString("codigo");
                fila[1] = rs.getString("email");
                fila[2] = rs.getString("contrasena");
                fila[3] = rs.getString("nombre_completo");
                fila[4] = rs.getString("dni");
                fila[5] = rs.getString("rol");
                boolean estado = rs.getBoolean("estado");

                if (estado == true) {
                    fila[6] = "activo";
                } else if (estado == false) {
                    fila[6] = "inactivo";
                } else {
                    fila[6] = "desconocido";
                }
                modeloUsuario.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar alumnos: " + e.getMessage());
        }
    }
    
    boolean validarCamposUsuario() {
        if (txtCorreo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el correo del Usuario");
            txtCorreo.requestFocus();
            return false;
        }
        if (txtContrasena.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la contraseña del Usuario");
            txtContrasena.requestFocus();
            return false;
        }
        if (txtNombres.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre completo del Usuario");
            txtNombres.requestFocus();
            return false;
        }
        if (txtDNI.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el DNI del Usuario");
            txtDNI.requestFocus();
            return false;
        }
        if (cbxRol.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese el Rol del Usuario");
            cbxRol.requestFocus();
            return false;
        }
        if (cbxEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese el Estado del Usuario");
            cbxEstado.requestFocus();
            return false;
        }
        return true;
    }

    private void obtenerDatosUsuarioPorCorreo(String correo) {
        try {
            rs = Udao.listarUsuarios();
            while (rs.next()) {
                if (rs.getString("email").equals(correo)) {
                    rs.close();
                    return;
                }
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + e.getMessage());
        }
    }
    
    private void buscarMatriculas(String texto) {
        String sql = """
                    SELECT codigo, email,contrasena,nombre_completo,dni,rol,estado
                            FROM usuarios
                            WHERE
                                (codigo ILIKE ?
                                OR email ILIKE ?
                                OR nombre_completo ILIKE ?
                                OR dni ILIKE ?
                                )
                            ORDER BY codigo ASC
                        """;
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)){
            
            String filtro = "%" + texto + "%";
            ps.setString(1, filtro); 
            ps.setString(2, filtro); 
            ps.setString(3, filtro);
            ps.setString(4, filtro);


            rs = ps.executeQuery();
            
            modeloUsuarioFiltrado = new DefaultTableModel(
                    new Object[]{"Codigo", "Email", "Contraseña", "Nombre Completo", "DNI","Rol","Estado"},
                    0
            );

            while (rs.next()) {
                boolean estado= rs.getBoolean("estado");
                
                String estadoFinal=estado?"activo":"inactivo";
                
                modeloUsuarioFiltrado.addRow(new Object[]{
                    rs.getString("codigo"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getString("nombre_completo"),
                    rs.getString("dni"),
                    rs.getString("rol"),
                    estadoFinal
                });
            }

            tblUsuarios.setModel(modeloUsuarioFiltrado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage());
        }
    }
    
    
    
    //Metodos para Gestion de Datos (Periodo Academico)
    
   void listarPeriodoAcademico() {
        modeloPeriodoAcademico = (DefaultTableModel) tblPeriodosAcademicos.getModel();
        modeloPeriodoAcademico.setRowCount(0);

        try {
            ResultSet rs = Pdao.listarPeriodos();
            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getString("codigoPeriodo");
                fila[1] = rs.getString("fecha_inicio");
                fila[2] = rs.getString("fecha_fin");

                boolean estado = rs.getBoolean("activo");

                if (estado == true) {
                    fila[3] = "activo";
                } else if (estado == false) {
                    fila[3] = "inactivo";
                } else {
                    fila[3] = "desconocido";
                }
                modeloPeriodoAcademico.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar alumnos: " + e.getMessage());
        }
    }
    
    void LimpiarCamposPeriodos(){
        txtCodigoPeriodo.setText("");
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
        cbxEstadoPeriodoAcademico.setSelectedIndex(0);
    }
    
    void obtenerDatosPeriodoPorCodigo(String codigo){
        try {
            rs = Pdao.listarPeriodos();
            while (rs.next()) {
                if (rs.getString("codigoPeriodo").equals(codigo)) {
                    rs.close();
                    return;
                }
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + e.getMessage());
        }
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
        java.awt.EventQueue.invokeLater(() -> new Administrador().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbLimpiarUsuario;
    private javax.swing.JButton btnActualizarPeriodo;
    private javax.swing.JButton btnEliminarPeriodo;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnLimpiarPeriodo;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnRegistroPeriodo;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxEstadoPeriodoAcademico;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblPeriodosAcademicos;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBuscaUsuarios;
    private javax.swing.JTextField txtCodigoPeriodo;
    private javax.swing.JTextField txtCodigoUsuario;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
