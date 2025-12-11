package Interfaces;

import Conexion.CursoDAO;
import Conexion.MatriculaDAO;
import Conexion.UsuarioDAO;
import Conexion.PeriodoAcademicoDAO;
import Conexion.SeccionDAO;
import Conexion.conexionBd;
import Objeto.Curso;
import Objeto.Matricula;
import Objeto.PeriodoAcademico;
import Objeto.Usuario;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leand
 */
public final class Administrador extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Administrador.class.getName());
    
    UsuarioDAO Udao= new UsuarioDAO();
    PeriodoAcademicoDAO Pdao = new PeriodoAcademicoDAO();
    CursoDAO Cdao= new CursoDAO();
    MatriculaDAO Mdao= new MatriculaDAO();
    SeccionDAO Sdao= new SeccionDAO();
    DefaultTableModel modeloUsuario,modeloUsuarioFiltrado,modeloPeriodoAcademico, modeloCurso,modeloMatricula,modeloSeccion;
    conexionBd co = new conexionBd();
    ResultSet rs;
    
    public Administrador() {
        initComponents();
        txtCodigoUsuario.setVisible(false);
        txtCodCurso.setVisible(false);
        txtCodMatricula.setVisible(false);
        listarUsuarios();
        listarPeriodoAcademico(); 
        listarCursos();
        listarMatriculas();
        listarSecciones();
        cargarAlumnosMatricula();
        cargarCursosMatricula();
        cargarPeriodosMatricula();
        
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
        tblPeriodo = new javax.swing.JTable();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNombreCurso = new javax.swing.JTextField();
        txtHorasSemanalesCurso = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        btnRegistrarCurso = new javax.swing.JButton();
        btnLimpiarCurso = new javax.swing.JButton();
        btnModificarCurso = new javax.swing.JButton();
        btnEliminarCurso = new javax.swing.JButton();
        cbxCiclo = new javax.swing.JComboBox<>();
        txtCodCurso = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtCodMatricula = new javax.swing.JTextField();
        cbxAlumnoMatricula = new javax.swing.JComboBox<>();
        cbxCursoMatricula = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMatricula = new javax.swing.JTable();
        btnRegistroMatricula = new javax.swing.JButton();
        btnLimpiarMatricula = new javax.swing.JButton();
        btnModificarMatricula = new javax.swing.JButton();
        btnEliminarMatricula = new javax.swing.JButton();
        cbxPeriodoMatricula = new javax.swing.JComboBox<>();
        txtFiltroMatricula = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCodSeccion = new javax.swing.JTextField();
        cbxCursoSeccion = new javax.swing.JComboBox<>();
        cbxPeriodoSeccion = new javax.swing.JComboBox<>();
        cbxProfesorSeccion = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnRegistroSeccion = new javax.swing.JButton();
        btnLimpiarSeccion = new javax.swing.JButton();
        btnModificarSeccion = new javax.swing.JButton();
        btnEliminarSeccion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 28)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE USUARIOS");

        tblUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Email", "Contraseña", "Nombre Completo", "DNI", "Rol", "Estado", "Fecha Creacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setHeaderValue("Codigo");
            tblUsuarios.getColumnModel().getColumn(1).setHeaderValue("Email");
            tblUsuarios.getColumnModel().getColumn(2).setHeaderValue("Contraseña");
            tblUsuarios.getColumnModel().getColumn(3).setHeaderValue("Nombre Completo");
            tblUsuarios.getColumnModel().getColumn(4).setHeaderValue("DNI");
            tblUsuarios.getColumnModel().getColumn(5).setHeaderValue("Rol");
            tblUsuarios.getColumnModel().getColumn(6).setHeaderValue("Estado");
            tblUsuarios.getColumnModel().getColumn(7).setHeaderValue("Fecha Creacion");
        }

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
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

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
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtBuscaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(465, 465, 465))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(txtContrasena))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(txtDNI))))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(48, 48, 48)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegistrarUsuario)
                                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btbLimpiarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(89, 89, 89)
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
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Usuarios", jPanel6);

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 28)); // NOI18N
        jLabel9.setText("MANTENIMIENTO DE PERIODOS ACADEMICOS");

        tblPeriodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Fecha Inicio", "Fecha Fin", "Estado", "Fecha Creacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeriodoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPeriodo);

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

        btnRegistroPeriodo.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnRegistroPeriodo.setText("Registrar");
        btnRegistroPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroPeriodoActionPerformed(evt);
            }
        });

        btnLimpiarPeriodo.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnLimpiarPeriodo.setText("Limpiar");
        btnLimpiarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPeriodoActionPerformed(evt);
            }
        });

        btnActualizarPeriodo.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnActualizarPeriodo.setText("Modificar");
        btnActualizarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPeriodoActionPerformed(evt);
            }
        });

        btnEliminarPeriodo.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
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
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigoPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(txtFechaInicio)
                                    .addComponent(txtFechaFin)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegistroPeriodo)
                                    .addComponent(btnActualizarPeriodo))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(btnEliminarPeriodo))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(btnLimpiarPeriodo)))))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(313, Short.MAX_VALUE))
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

        jLabel14.setFont(new java.awt.Font("Georgia", 1, 28)); // NOI18N
        jLabel14.setText("MANTENIMIENTO DE CURSOS");

        jLabel15.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel15.setText("Nombre");

        jLabel16.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel16.setText("Horas Semanales:");

        jLabel17.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel17.setText("Ciclo: ");

        txtNombreCurso.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        txtHorasSemanalesCurso.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo Curso", "Nombre", "Horas Semanales", "Nº de Ciclo", "Fecha Crecion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCursoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCurso);

        btnRegistrarCurso.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnRegistrarCurso.setText("Registrar");
        btnRegistrarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCursoActionPerformed(evt);
            }
        });

        btnLimpiarCurso.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnLimpiarCurso.setText("Limpiar");
        btnLimpiarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCursoActionPerformed(evt);
            }
        });

        btnModificarCurso.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnModificarCurso.setText("Modificar");
        btnModificarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCursoActionPerformed(evt);
            }
        });

        btnEliminarCurso.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        btnEliminarCurso.setText("Eliminar");
        btnEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCursoActionPerformed(evt);
            }
        });

        cbxCiclo.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        cbxCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(92, 92, 92)
                                .addComponent(txtNombreCurso))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHorasSemanalesCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarCurso)
                            .addComponent(btnModificarCurso))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpiarCurso)
                            .addComponent(btnEliminarCurso))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtHorasSemanalesCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarCurso)
                            .addComponent(btnLimpiarCurso))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarCurso)
                            .addComponent(btnModificarCurso))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        jTabbedPane2.addTab("Cursos", jPanel8);

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

        jTabbedPane1.addTab("Mantenimiento", jPanel1);

        jPanel11.setToolTipText("");

        jLabel18.setFont(new java.awt.Font("Georgia", 1, 28)); // NOI18N
        jLabel18.setText("REGISTRO DE MATRICULAS");

        jLabel19.setText("Nombre Alumno:");

        jLabel20.setText("Nombre Curso: ");

        jLabel21.setText("Periodo Academico: ");

        cbxAlumnoMatricula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxCursoMatricula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo Matricula", "Nombre Alumno", "Curso", "Periodo", "Fecha Creacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMatriculaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblMatricula);

        btnRegistroMatricula.setText("Registrar");
        btnRegistroMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroMatriculaActionPerformed(evt);
            }
        });

        btnLimpiarMatricula.setText("Limpiar");
        btnLimpiarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMatriculaActionPerformed(evt);
            }
        });

        btnModificarMatricula.setText("Modificar");
        btnModificarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMatriculaActionPerformed(evt);
            }
        });

        btnEliminarMatricula.setText("Eliminar");
        btnEliminarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMatriculaActionPerformed(evt);
            }
        });

        cbxPeriodoMatricula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPeriodoMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxPeriodoMatriculaMouseClicked(evt);
            }
        });

        txtFiltroMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroMatriculaKeyReleased(evt);
            }
        });

        jLabel22.setText("Buscador de Matriculas:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel18)
                        .addGap(232, 232, 232)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(txtCodMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(btnRegistroMatricula))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(btnModificarMatricula))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(246, 246, 246)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnLimpiarMatricula)
                                            .addComponent(btnEliminarMatricula)))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxAlumnoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxCursoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxPeriodoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(108, 108, 108)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbxPeriodoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbxAlumnoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbxCursoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistroMatricula)
                    .addComponent(btnLimpiarMatricula))
                .addGap(45, 45, 45)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarMatricula)
                    .addComponent(btnEliminarMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jTabbedPane3.addTab("Matricula", jPanel11);

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 28)); // NOI18N
        jLabel23.setText("REGISTRO DE SECCIONES");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo Seccion", "Profesor", "Curso", "Periodo Academico", "Fecha Creada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        cbxCursoSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxPeriodoSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxProfesorSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel24.setText("Periodo Academico: ");

        jLabel25.setText("Curso: ");

        jLabel26.setText("Profesor: ");

        btnRegistroSeccion.setText("Registrar");

        btnLimpiarSeccion.setText("Limpiar");
        btnLimpiarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSeccionActionPerformed(evt);
            }
        });

        btnModificarSeccion.setText("Modificar");

        btnEliminarSeccion.setText("Eliminar");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(269, 269, 269)
                                    .addComponent(txtCodSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(245, 245, 245)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cbxPeriodoSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxCursoSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxProfesorSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegistroSeccion)
                                    .addComponent(jLabel24)
                                    .addComponent(btnModificarSeccion))
                                .addGap(122, 122, 122)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLimpiarSeccion)
                                    .addComponent(btnEliminarSeccion))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(jLabel25)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxPeriodoSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCursoSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxProfesorSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistroSeccion)
                            .addComponent(btnLimpiarSeccion))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificarSeccion)
                            .addComponent(btnEliminarSeccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );

        jTabbedPane3.addTab("Seccion", jPanel12);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("Registro", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1565, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1565, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1565, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Login l = new Login();
        this.dispose();
        l.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursoActionPerformed
        if (txtCodCurso.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un Curso de la tabla para eliminar.");
            return;
        }

        String codCurso = txtCodCurso.getText();
        String nombreCurso = txtNombreCurso.getText();

        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar el curso '" + nombreCurso + "'?",
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (Cdao.eliminarCurso(codCurso)) {
                JOptionPane.showMessageDialog(this, "Curso eliminado exitosamente.");
                listarCursos();
                cargarCursosMatricula();
                LimpiarCamposCursos();
            }
        }
    }//GEN-LAST:event_btnEliminarCursoActionPerformed

    private void btnModificarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCursoActionPerformed
        if (txtCodCurso.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un Curso de la tabla para modificar.");
            return;
        }

        if(validarCamposCurso()){
            try {
                String codigo = txtCodCurso.getText();
                String nombre = txtNombreCurso.getText();
                int horas = Integer.parseInt(txtHorasSemanalesCurso.getText());
                int ciclo = Integer.parseInt(cbxCiclo.getSelectedItem().toString());

                Curso cursoModificado = new Curso(codigo, nombre, horas, ciclo);

                if (Cdao.actualizarCurso(cursoModificado)) {
                    JOptionPane.showMessageDialog(this, "Curso modificado exitosamente.");
                    listarCursos();
                    cargarCursosMatricula();
                    LimpiarCamposCursos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al modificar. Revise el valor ingresado.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Verifique que Horas y Ciclo sean números.");
            }
        }
    }//GEN-LAST:event_btnModificarCursoActionPerformed

    private void btnLimpiarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCursoActionPerformed
        LimpiarCamposCursos();
    }//GEN-LAST:event_btnLimpiarCursoActionPerformed

    private void btnRegistrarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCursoActionPerformed
        if(validarCamposCurso()){
            try {
                String codigo = txtCodCurso.getText();
                String nombre = txtNombreCurso.getText();
                int horas = Integer.parseInt(txtHorasSemanalesCurso.getText());
                int ciclo = Integer.parseInt(cbxCiclo.getSelectedItem().toString());

                // Crear Objeto
                Curso nuevoCurso = new Curso(codigo, nombre, horas, ciclo);

                if (Cdao.registrarCurso(nuevoCurso)) {
                    JOptionPane.showMessageDialog(this, "Curso registrado correctamente.");
                    listarCursos();
                    cargarCursosMatricula();
                    LimpiarCamposCursos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al registrar. Revise si el código ya existe.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Horas o Ciclo deben ser valores numéricos válidos.");
            }
        }
    }//GEN-LAST:event_btnRegistrarCursoActionPerformed

    private void tblCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursoMouseClicked
        int fila = tblCurso.getSelectedRow();
        if (fila >= 0) {
            String codigo = tblCurso.getValueAt(fila, 0).toString();
            obtenerDatosCursoPorCodigo(codigo);
            txtCodCurso.setText(codigo);
            txtNombreCurso.setText(tblCurso.getValueAt(fila, 1).toString());
            txtHorasSemanalesCurso.setText(tblCurso.getValueAt(fila, 2).toString());
            cbxCiclo.setSelectedItem(tblCurso.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tblCursoMouseClicked

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
                cargarPeriodosMatricula();
                LimpiarCamposPeriodos();
            }
        }
    }//GEN-LAST:event_btnEliminarPeriodoActionPerformed

    private void btnActualizarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPeriodoActionPerformed
        if (txtCodigoPeriodo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un Periodo de la tabla para modificar.");
            return;
        }

        if(validarCamposPeriodo()){
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
                cargarPeriodosMatricula();
                LimpiarCamposPeriodos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar. Revise fechas o código duplicado.");
            }
        }
    }//GEN-LAST:event_btnActualizarPeriodoActionPerformed

    private void btnLimpiarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPeriodoActionPerformed
        LimpiarCamposPeriodos();
        txtCodigoPeriodo.setEditable(true);
    }//GEN-LAST:event_btnLimpiarPeriodoActionPerformed

    private void btnRegistroPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroPeriodoActionPerformed
        if(validarCamposPeriodo()){
            String codigo = txtCodigoPeriodo.getText();
            String fechaInicio = txtFechaInicio.getText();
            String fechaFin = txtFechaFin.getText();
            boolean activo = cbxEstadoPeriodoAcademico.getSelectedItem().toString().equalsIgnoreCase("activo");

            PeriodoAcademico nuevoPeriodo = new PeriodoAcademico(codigo, fechaInicio, fechaFin, activo);
            
            try{
                Pdao.registrarPeriodo(nuevoPeriodo);
                JOptionPane.showMessageDialog(this, "Periodo Registrado correctamente.");

                listarPeriodoAcademico();
                cargarPeriodosMatricula();
                LimpiarCamposPeriodos();
            }catch(HeadlessException e){
                JOptionPane.showMessageDialog(this, "Error al registrar. Revise formato de fechas o código duplicado.");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnRegistroPeriodoActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void tblPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeriodoMouseClicked
        txtCodigoPeriodo.setEditable(false);
        int fila = tblPeriodo.getSelectedRow();
        if (fila >= 0) {
            String codigo = tblPeriodo.getValueAt(fila, 0).toString();
            obtenerDatosPeriodoPorCodigo(codigo);
            txtCodigoPeriodo.setText(codigo);
            txtFechaInicio.setText(tblPeriodo.getValueAt(fila, 1).toString());
            txtFechaFin.setText(tblPeriodo.getValueAt(fila, 2).toString());
            cbxEstadoPeriodoAcademico.setSelectedItem(tblPeriodo.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tblPeriodoMouseClicked

    private void txtBuscaUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaUsuariosKeyReleased
        buscarUsuario(txtBuscaUsuarios.getText());
    }//GEN-LAST:event_txtBuscaUsuariosKeyReleased

    private void txtCodigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoUsuarioActionPerformed

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
                cargarAlumnosMatricula();
                LimpiarCamposUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar alumno. Verifique que no tenga matrículas asociadas");
            }
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

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
                    cargarAlumnosMatricula();
                    LimpiarCamposUsuarios();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar Usuario");
                }
            }
        }
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

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
                cargarAlumnosMatricula();
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

    private void cbxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void btnRegistroMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroMatriculaActionPerformed
        if (!validarCamposMatricula()) { 
            return; 
        }

        String nombreAlumno = (String) cbxAlumnoMatricula.getSelectedItem();
        String nombreCurso = (String) cbxCursoMatricula.getSelectedItem();
        String codigoPeriodo = (String) cbxPeriodoMatricula.getSelectedItem();

        try {
            int idAlumno = Udao.obtenerIdAlumnoPorNombre(nombreAlumno);
            int idCurso = Cdao.obtenerIdCursoPorNombre(nombreCurso);
            int idPeriodo = Pdao.obtenerIdPeriodoPorCodigo(codigoPeriodo);

            Matricula ma = new Matricula(idAlumno, idCurso, idPeriodo);
            
            if (idAlumno == -1 || idCurso == -1 || idPeriodo == -1) {
                JOptionPane.showMessageDialog(this, "Error al obtener IDs de selección. Verifique que los datos existan.", "Error de ID", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!Pdao.esPeriodoActivo(idPeriodo)) {
                JOptionPane.showMessageDialog(this, "ERROR: No se puede registrar la matrícula. El periodo académico seleccionado (" + codigoPeriodo + ") está inactivo.", "Restricción de Período", JOptionPane.ERROR_MESSAGE);
                return; 
            }

            if (Mdao.registrarMatricula(ma)) {
                JOptionPane.showMessageDialog(this, "Matrícula registrada con éxito.");
                listarMatriculas();
                LimpiarCamposMatricula();
            } else {
                JOptionPane.showMessageDialog(this, "Error: La matrícula no se pudo registrar. Ya existe una matrícula para este alumno, curso y período.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos al registrar: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistroMatriculaActionPerformed

    private void btnModificarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMatriculaActionPerformed
        if (txtCodMatricula.equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione una Matrícula de la tabla para modificar.");
            return;
        }

        if (!validarCamposMatricula()) { 
            return;
        }

        // Obtener los nuevos valores seleccionados (incluyendo Alumno)
        String nombreAlumno = cbxAlumnoMatricula.getSelectedItem().toString(); // Nuevo: Alumno
        String nombreCurso = cbxCursoMatricula.getSelectedItem().toString();
        String codigoPeriodo = cbxPeriodoMatricula.getSelectedItem().toString();

        try {
            String codMatricula = txtCodMatricula.getText();
            int nuevoIdAlumno = Udao.obtenerIdAlumnoPorNombre(nombreAlumno); 
            int nuevoIdCurso = Cdao.obtenerIdCursoPorNombre(nombreCurso);
            int nuevoIdPeriodo = Pdao.obtenerIdPeriodoPorCodigo(codigoPeriodo);
            Matricula ma = new Matricula(codMatricula, nuevoIdAlumno, nuevoIdCurso,nuevoIdPeriodo);
            
            if (nuevoIdAlumno == -1 || nuevoIdCurso == -1 || nuevoIdPeriodo == -1) {
                JOptionPane.showMessageDialog(this, "Error al obtener IDs del nuevo Alumno, Curso o Periodo.");
                return;
            }

            // 2. Llamar al DAO para ejecutar la modificación con los cuatro IDs
            if (Mdao.modificarMatricula(ma)) {
                JOptionPane.showMessageDialog(this, "Matrícula modificada exitosamente.");
                listarMatriculas();
                LimpiarCamposMatricula();
            } else {
                // El error de unicidad es manejado por el DAO y muestra un JOptionPane
                // Si el DAO retorna false, es por violación de unicidad o error de conexión.
                JOptionPane.showMessageDialog(this, "Error al modificar la matrícula. Verifique que la combinación no exista.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos al modificar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarMatriculaActionPerformed

    private void btnEliminarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMatriculaActionPerformed
        if (txtCodMatricula.equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione una Matrícula de la tabla para eliminar.");
            return;
        }

        String codigoMatricula = txtCodMatricula.getText(); // Muestra el código legible para el usuario
        
        // 2. Pedir confirmación al usuario
        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar la matrícula " + codigoMatricula + "? Esta acción es irreversible.",
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // 3. Llamar al DAO para eliminar usando el ID interno
            if (Mdao.eliminarMatricula(codigoMatricula)) {
                JOptionPane.showMessageDialog(this, "Matrícula eliminada exitosamente.");
                listarMatriculas();
                LimpiarCamposMatricula();
            } 
        }
    }//GEN-LAST:event_btnEliminarMatriculaActionPerformed

    private void cbxPeriodoMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxPeriodoMatriculaMouseClicked

    }//GEN-LAST:event_cbxPeriodoMatriculaMouseClicked

    private void btnLimpiarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMatriculaActionPerformed
        cbxPeriodoMatricula.setEnabled(true);
        LimpiarCamposMatricula();
    }//GEN-LAST:event_btnLimpiarMatriculaActionPerformed

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

    private void tblMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMatriculaMouseClicked
        cbxPeriodoMatricula.setEnabled(false);
        int fila = tblMatricula.getSelectedRow();
        if (fila >= 0) {
            String codigo = tblMatricula.getValueAt(fila, 0).toString();
            obtenerDatosMatriculaPorCodigo(codigo);
            txtCodMatricula.setText(codigo);
            cbxPeriodoMatricula.setSelectedItem(tblMatricula.getValueAt(fila, 3).toString());
            cbxAlumnoMatricula.setSelectedItem(tblMatricula.getValueAt(fila, 1).toString());
            cbxCursoMatricula.setSelectedItem(tblMatricula.getValueAt(fila, 2).toString());
        }
    }//GEN-LAST:event_tblMatriculaMouseClicked

    private void txtFiltroMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroMatriculaKeyReleased
        buscarMatricula(txtFiltroMatricula.getText());
    }//GEN-LAST:event_txtFiltroMatriculaKeyReleased

    private void btnLimpiarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSeccionActionPerformed
        LimpiarCamposSeccion();
    }//GEN-LAST:event_btnLimpiarSeccionActionPerformed


    
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
                Object[] fila = new Object[8];
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
                fila[7]=rs.getString("fecha_usuario");
                
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
    
    private void buscarUsuario(String texto) {
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
        try (PreparedStatement psu = co.getConnection().prepareStatement(sql)){
            
            String filtro = "%" + texto + "%";
            psu.setString(1, filtro); 
            psu.setString(2, filtro); 
            psu.setString(3, filtro);
            psu.setString(4, filtro);


            rs = psu.executeQuery();
            
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
        modeloPeriodoAcademico = (DefaultTableModel) tblPeriodo.getModel();
        modeloPeriodoAcademico.setRowCount(0);
        rs = Pdao.listarPeriodos();
        try {
            while (rs.next()) {
                Object[] fila = new Object[5];
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
                fila[4] = rs.getString("fecha_periodo");
                
                modeloPeriodoAcademico.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar Periodo: " + e.getMessage());
        }
    }
    
    boolean validarCamposPeriodo() {
        if (txtCodigoPeriodo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el Codigo del Periodo");
            txtCodigoPeriodo.requestFocus();
            return false;
        }
        if (txtFechaInicio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la Fecha de Inicio");
            txtFechaInicio.requestFocus();
            return false;
        }
        if (txtFechaFin.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el Fecha Final");
            txtFechaFin.requestFocus();
            return false;
        }
        if (cbxEstadoPeriodoAcademico.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese el Estado del periodo");
            cbxEstadoPeriodoAcademico.requestFocus();
            return false;
        }
        return true;
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
    
    
    //Metodos para Gestion de Datos (Cursos)
    
    void LimpiarCamposCursos(){
        txtCodCurso.setText("");
        txtNombreCurso.setText("");
        txtHorasSemanalesCurso.setText("");
        cbxCiclo.setSelectedIndex(0);
    }
    
    boolean validarCamposCurso() {
        if (txtNombreCurso.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del Curso");
            txtNombreCurso.requestFocus();
            return false;
        }
        if (txtHorasSemanalesCurso.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese las horas semanales");
            txtHorasSemanalesCurso.requestFocus();
            return false;
        }
        if (cbxCiclo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese el Ciclo del Curso");
            cbxEstadoPeriodoAcademico.requestFocus();
            return false;
        }
        return true;
    }
    
    void listarCursos(){
        modeloCurso = (DefaultTableModel) tblCurso.getModel();
        modeloCurso.setRowCount(0);

        try {
            ResultSet rs = Cdao.listarCursos();
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getString("codigoCurso");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("horas_semanales");
                fila[3] = rs.getString("ciclo");
                fila[4] = rs.getString("fecha_curso");
                
                modeloCurso.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar alumnos: " + e.getMessage());
        }
    }
    
    void obtenerDatosCursoPorCodigo(String codigo){
        try {
            rs = Cdao.listarCursos();
            while (rs.next()) {
                if (rs.getString("codigoCurso").equals(codigo)) {
                    rs.close();
                    return;
                }
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + e.getMessage());
        }
    }
    
    
    
    
    //Metodos para Gestion de Matriculas
    void LimpiarCamposMatricula(){
        cbxPeriodoMatricula.setSelectedIndex(0);
        cbxAlumnoMatricula.setSelectedIndex(0);
        cbxCursoMatricula.setSelectedIndex(0);
        txtCodMatricula.setText("");
    }
    
    boolean validarCamposMatricula() {
        if (cbxPeriodoMatricula.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese el Periodo Academico");
            cbxPeriodoMatricula.requestFocus();
            return false;
        }
        if (cbxAlumnoMatricula.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese el Alumno a Matricular");
            cbxAlumnoMatricula.requestFocus();
            return false;
        }
        if (cbxCursoMatricula.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese el Curso a Matricular");
            cbxCursoMatricula.requestFocus();
            return false;
        }
        return true;
    }
    
    void listarMatriculas(){
        modeloMatricula = (DefaultTableModel) tblMatricula.getModel();
        modeloMatricula.setRowCount(0);
        
        ResultSet rs = null;
        try {
            rs = Mdao.listarMatriculas();

            while (rs.next()) {
                Object[] fila = new Object[8]; 

                fila[0] = rs.getString("codigoMatricula"); 
                fila[1] = rs.getString("alumno_nombre");  
                fila[2] = rs.getString("curso_nombre");      
                fila[3] = rs.getString("periodo_codigo"); 
                fila[4] = rs.getString("fecha_matricula");
                fila[5] = rs.getInt("idMatriculas");     
                fila[6] = rs.getInt("alumno_id");      
                fila[7] = rs.getInt("curso_id");        

                modeloMatricula.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar matrículas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                logger.log(java.util.logging.Level.SEVERE, "Error al cerrar ResultSet: ", ex);
            }
        }
    }
   
    void cargarAlumnosMatricula(){
        cbxAlumnoMatricula.removeAllItems();
        cbxAlumnoMatricula.addItem("Seleccione");
        try (ResultSet rs = Udao.listarAlumnosParaCombo()) {
            while (rs.next()) {
                cbxAlumnoMatricula.addItem(rs.getString("nombre_completo")); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar alumnos para matrícula: " + e.getMessage());
        }    
    }
    
    void cargarCursosMatricula(){
        cbxCursoMatricula.removeAllItems();
        cbxCursoMatricula.addItem("Seleccione");
        try (ResultSet rs = Cdao.listarCursosParaCombo()) { // Usa el DAO de Curso
            while (rs.next()) {
                // Se añade el nombre del curso, como solicitaste
                cbxCursoMatricula.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar cursos para matrícula: " + e.getMessage());
        }
    }
    
    void cargarPeriodosMatricula(){
        cbxPeriodoMatricula.removeAllItems();
        cbxPeriodoMatricula.addItem("Seleccione");
        try (ResultSet rs = Pdao.listarPeriodosParaCombo()) { 
            while (rs.next()) {
                // Se añade el codigoPeriodo, como solicitaste
                cbxPeriodoMatricula.addItem(rs.getString("codigoPeriodo")); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar periodos para matrícula: " + e.getMessage());
        }
    }
    
    void obtenerDatosMatriculaPorCodigo(String codigo){
        try {
            rs = Mdao.listarMatriculas();
            while (rs.next()) {
                if (rs.getString("codigoMatricula").equals(codigo)) {
                    rs.close();
                    return;
                }
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + e.getMessage());
        }
    }
      
    private void buscarMatricula(String texto) {
        String sql = """
                     SELECT m.idMatriculas, m.codigoMatricula, 
                            u.nombre_completo AS alumno_nombre, 
                            c.nombre AS curso_nombre, 
                            pa.codigoPeriodo AS periodo_codigo, 
                            m.alumno_id, m.curso_id, m.periodo_id
                     FROM matriculas m 
                     JOIN usuarios u ON m.alumno_id = u.idUsuarios 
                     JOIN cursos c ON m.curso_id = c.idCursos 
                     JOIN periodos_academicos pa ON m.periodo_id = pa.idPeriodoAcademico
                     WHERE 
                         (m.codigoMatricula ILIKE ?
                         OR u.nombre_completo ILIKE ?
                         OR c.nombre ILIKE ?
                         OR pa.codigoPeriodo ILIKE ?
                         )
                     ORDER BY m.idMatriculas DESC
                     """;

        ResultSet rs = null;

        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            String filtro = "%" + texto + "%";

            // Asignar el mismo filtro (texto) a las 4 condiciones del WHERE
            ps.setString(1, filtro); // Filtra por codigoMatricula
            ps.setString(2, filtro); // Filtra por nombre_completo (alumno)
            ps.setString(3, filtro); // Filtra por nombre (curso)
            ps.setString(4, filtro); // Filtra por codigoPeriodo

            rs = ps.executeQuery();

            // 1. Crear el nuevo modelo para el resultado de la búsqueda
            DefaultTableModel modeloMatriculaFiltrado = new DefaultTableModel(
                    new Object[]{"Codigo Matricula", "Nombre Alumno", "Curso", "Periodo", "ID Mat", "ID Alum", "ID Curso"},
                    0
            );

            // 2. Llenar el modelo con los resultados
            while (rs.next()) {
                modeloMatriculaFiltrado.addRow(new Object[]{
                    // Columnas visibles (0-3)
                    rs.getString("codigoMatricula"),
                    rs.getString("alumno_nombre"),
                    rs.getString("curso_nombre"),
                    rs.getString("periodo_codigo"),
                    // Columnas ocultas (4-6) - IDs internos para el CRUD
                    rs.getInt("idMatriculas"),
                    rs.getInt("alumno_id"),
                    rs.getInt("curso_id")
                });
            }

            // 3. Establecer el nuevo modelo en la tabla
            tblMatricula.setModel(modeloMatriculaFiltrado);

            // 4. Asegurar que las columnas de IDs se mantengan ocultas (reaplicar configuración)
            ocultarColumnasIDsMatricula(); 

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar matrículas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet en caso de éxito
            try {
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                logger.log(java.util.logging.Level.SEVERE, "Error al cerrar ResultSet: ", ex);
            }
        }
    }
    
    void ocultarColumnasIDsMatricula() {
        if (tblMatricula.getColumnModel().getColumnCount() > 4) {
            tblMatricula.getColumnModel().getColumn(4).setMaxWidth(0);
            tblMatricula.getColumnModel().getColumn(4).setMinWidth(0);
            tblMatricula.getColumnModel().getColumn(4).setPreferredWidth(0);
        }
        if (tblMatricula.getColumnModel().getColumnCount() > 5) {
            tblMatricula.getColumnModel().getColumn(5).setMaxWidth(0);
            tblMatricula.getColumnModel().getColumn(5).setMinWidth(0);
            tblMatricula.getColumnModel().getColumn(5).setPreferredWidth(0);
        }
        if (tblMatricula.getColumnModel().getColumnCount() > 6) {
            tblMatricula.getColumnModel().getColumn(6).setMaxWidth(0);
            tblMatricula.getColumnModel().getColumn(6).setMinWidth(0);
            tblMatricula.getColumnModel().getColumn(6).setPreferredWidth(0);
        }
    }

    
    //Metodos para Gestion de Secciones
    
    void LimpiarCamposSeccion(){
        cbxPeriodoSeccion.setSelectedIndex(0);
        cbxCursoSeccion.setSelectedIndex(0);
        cbxProfesorSeccion.setSelectedIndex(0);
        txtCodSeccion.setText("");
    }
    
    void listarSecciones(){
        modeloSeccion = (DefaultTableModel) tblMatricula.getModel();
        modeloSeccion.setRowCount(0);
        
        ResultSet rs = null;
        try {
            rs = Sdao.listarSecciones();

            while (rs.next()) {
                Object[] fila = new Object[8]; 

                fila[0] = rs.getString("codigoSeccion"); 
                fila[1] = rs.getString("profesor_nombre");  
                fila[2] = rs.getString("curso_nombre");      
                fila[3] = rs.getString("periodo_codigo"); 
                fila[4] = rs.getString("fecha_seccion");
                fila[5] = rs.getInt("idseccion");     
                fila[6] = rs.getInt("idProfesor");      
                fila[7] = rs.getInt("idCursos");        

                modeloMatricula.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar matrículas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                logger.log(java.util.logging.Level.SEVERE, "Error al cerrar ResultSet: ", ex);
            }
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
    private javax.swing.JButton btnEliminarCurso;
    private javax.swing.JButton btnEliminarMatricula;
    private javax.swing.JButton btnEliminarPeriodo;
    private javax.swing.JButton btnEliminarSeccion;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnLimpiarCurso;
    private javax.swing.JButton btnLimpiarMatricula;
    private javax.swing.JButton btnLimpiarPeriodo;
    private javax.swing.JButton btnLimpiarSeccion;
    private javax.swing.JButton btnModificarCurso;
    private javax.swing.JButton btnModificarMatricula;
    private javax.swing.JButton btnModificarSeccion;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnRegistrarCurso;
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnRegistroMatricula;
    private javax.swing.JButton btnRegistroPeriodo;
    private javax.swing.JButton btnRegistroSeccion;
    private javax.swing.JComboBox<String> cbxAlumnoMatricula;
    private javax.swing.JComboBox<String> cbxCiclo;
    private javax.swing.JComboBox<String> cbxCursoMatricula;
    private javax.swing.JComboBox<String> cbxCursoSeccion;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxEstadoPeriodoAcademico;
    private javax.swing.JComboBox<String> cbxPeriodoMatricula;
    private javax.swing.JComboBox<String> cbxPeriodoSeccion;
    private javax.swing.JComboBox<String> cbxProfesorSeccion;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTable tblMatricula;
    private javax.swing.JTable tblPeriodo;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBuscaUsuarios;
    private javax.swing.JTextField txtCodCurso;
    private javax.swing.JTextField txtCodMatricula;
    private javax.swing.JTextField txtCodSeccion;
    private javax.swing.JTextField txtCodigoPeriodo;
    private javax.swing.JTextField txtCodigoUsuario;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtFiltroMatricula;
    private javax.swing.JTextField txtHorasSemanalesCurso;
    private javax.swing.JTextField txtNombreCurso;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
