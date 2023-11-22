package vista;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Almacen;
import controlador.AlmacenDAO;
import modelo.Cliente;
import controlador.ClienteDAO;
import controlador.DevolucionDAO;
import controlador.FabricacionDAO;
import controlador.ProveedoresDAO;
import controlador.ServiciocanceladoDAO;
import controlador.ServiciosDAO;
import modelo.Trabajador;
import controlador.TrabajadorDAO;
import controlador.UsuarioDAO;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Devolucion;
import modelo.Fabricacion;
import modelo.Proveedores;
import modelo.Serviciocancelado;
import modelo.Servicios;
import modelo.Usuario;


    public class principal extends javax.swing.JFrame {
         String ruta = "";
    Almacen alm = new Almacen();
    AlmacenDAO almD = new AlmacenDAO();
    Cliente cl = new Cliente();
    ClienteDAO clD = new ClienteDAO();
    Trabajador trb = new Trabajador();
    TrabajadorDAO trbD = new TrabajadorDAO();
    Usuario usr = new Usuario();
    UsuarioDAO usrD = new UsuarioDAO(); 
    DefaultTableModel model = new DefaultTableModel();
    Proveedores pro = new Proveedores();
    ProveedoresDAO proD = new ProveedoresDAO();
    Serviciocancelado serv = new Serviciocancelado();
    ServiciocanceladoDAO servD = new ServiciocanceladoDAO();
    Fabricacion fbr = new Fabricacion();
    FabricacionDAO fbrD = new FabricacionDAO();
    Devolucion dev = new Devolucion();
    DevolucionDAO devD = new DevolucionDAO();



    
    public principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Pantalla completa del programa
        txtIdAlm.setVisible(false);  //Ocultar el TextField del Id
        txtIdCl.setVisible(false);   //Ocultar el TextField del Id
        txtIdTrb.setVisible(false);
        txtIduser.setVisible(false);
        txtid_serviciocancelado.setVisible(false);
    }
    
    
    
    //Método para que aparezca la base de datos en la tabla Almacen
    public void ListarAlmacen(){
        List<Almacen> ListarAlm = almD.ListarAlmacen();
        model = (DefaultTableModel) TableAlm.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListarAlm.size(); i++) {
            ob[0] = ListarAlm.get(i).getId_producto();
            ob[1] = ListarAlm.get(i).getProducto();
            ob[2] = ListarAlm.get(i).getMarca();
            ob[3] = ListarAlm.get(i).getPrecio();
            ob[4] = ListarAlm.get(i).getCantidad();
            model.addRow(ob);
        }
        TableAlm.setModel(model);
    }
    
    // Método para que aparezca la base de datos en la tabla Clientes
    public void ListarCliente(){
        List<Cliente> ListarC = clD.ListarClientes();
        model = (DefaultTableModel) TableCl.getModel();
        Object[] ob = new Object[4];
        for(int i = 0; i < ListarC.size(); i++){
            ob[0] = ListarC.get(i).getId_cliente();
            ob[1] = ListarC.get(i).getNombreC();
            ob[2] = ListarC.get(i).getDireccionC();
            ob[3] = ListarC.get(i).getRuc();
            model.addRow(ob);
        }
        TableCl.setModel(model);
    }
    
    // Método para que aparezca la base de datos en la tabla Trabajador
    public void ListarTrabajador(){
        List<Trabajador> ListarT = trbD.ListarTrabajadores();
        model = (DefaultTableModel) TableTrb.getModel();
        Object[] ob = new Object[7];
        for(int i = 0; i < ListarT.size(); i++){
            ob[0] = ListarT.get(i).getId_trabajador();
            ob[1] = ListarT.get(i).getNombreT();
            ob[2] = ListarT.get(i).getApellidoT();
            ob[3] = ListarT.get(i).getDniT();
            ob[4] = ListarT.get(i).getCelularT();
            ob[5] = ListarT.get(i).getCorreoT();
            ob[6] = ListarT.get(i).getCargoT();
            model.addRow(ob);
        }
        TableTrb.setModel(model);
    }
    
    // Método para que aparezca la base de datos en la tabla Usuario
    public void ListarUsuario(){
        List<Usuario> ListarU = usrD.ListarUsuario();
        model = (DefaultTableModel) Tableuser.getModel();
        Object[] ob = new Object[5];
        for(int i = 0; i < ListarU.size(); i++){
            ob[0] = ListarU.get(i).getId_usuarioU();
            ob[1] = ListarU.get(i).getUsuarioU();
            ob[2] = ListarU.get(i).getCargoU();
            ob[3] = ListarU.get(i).getContraseñaU();
            model.addRow(ob);
        }
        Tableuser.setModel(model);
    }
    // Método para que aparezca la base de datos en la tabla Proveedores
    public void ListarProveedores(){
        List<Proveedores> ListarP = proD.ListarProveedor();
        model = (DefaultTableModel) TableProveedores.getModel();
        Object[] ob = new Object[5];
        for(int i = 0; i < ListarP.size(); i++){
            ob[0] = ListarP.get(i).getId_proveedor();
            ob[1] = ListarP.get(i).getProductoP();
            ob[2] = ListarP.get(i).getFechaentregap();
            ob[3] = ListarP.get(i).getNombre_empresap();
            ob[4] = ListarP.get(i).getRUCp();
            model.addRow(ob);
        }
        TableProveedores.setModel(model);
    }
        // Método para que aparezca la base de datos en la tabla Serviciocancelado
    public void ListarServiciocancelado(){
        List<Serviciocancelado> ListarServ = servD.ListarServiciocancelado();
        model = (DefaultTableModel) Tableserv.getModel();
        Object[] ob = new Object[6];
        for(int i = 0; i < ListarServ.size(); i++){
            ob[0] = ListarServ.get(i).getId_serviciocancelado();
            ob[1] = ListarServ.get(i).getLugars();
            ob[2] = ListarServ.get(i).getTiposervicio();
            ob[3] = ListarServ.get(i).getRUCs();
            ob[4] = ListarServ.get(i).getFechacancelacion();
            ob[5] = ListarServ.get(i).getTrabajador();
            model.addRow(ob);
        }
        Tableserv.setModel(model);
    }
    
    public void ListarFabricacion(){
        TableFbr.setDefaultRenderer(Object.class, new RenderImage());
        List<Fabricacion> ListarFab = fbrD.ListarFabricacion();
        model = (DefaultTableModel) TableFbr.getModel();
        Object[] ob = new Object[5];
        for(int i = 0; i < ListarFab.size(); i++){
            
           
            ob[0] = ListarFab.get(i).getId_fabricacion();
            ob[1] = ListarFab.get(i).getNum_tablero();
            ob[2] = ListarFab.get(i).getTablero();
            ob[3] = ListarFab.get(i).getFoto_tablero();
            ob[4] = ListarFab.get(i).getMaterial();
            model.addRow(ob);
        }
        TableFbr.setModel(model);
    }
    
    public void LimpiarTabla(){
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBotones = new javax.swing.JPanel();
        btnVenta = new javax.swing.JButton();
        btnAlmacen = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnFabricacion = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnTrabajadores = new javax.swing.JButton();
        btnServCan = new javax.swing.JButton();
        btnDevoluciones = new javax.swing.JButton();
        labelUTI = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelBottom = new javax.swing.JLabel();
        PanelServicios = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelProducto = new javax.swing.JLabel();
        labelMarca = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPrecioAlm = new javax.swing.JTextField();
        txtCantidadAlm = new javax.swing.JTextField();
        btnAñadirAlm = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAlm = new javax.swing.JTable();
        txtIdAlm = new javax.swing.JTextField();
        btnEditarAlm = new javax.swing.JButton();
        btnEliminarAlm = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnAñadirCl = new javax.swing.JButton();
        btnEditarCl = new javax.swing.JButton();
        btnEliminarCl = new javax.swing.JButton();
        labelNombreC = new javax.swing.JLabel();
        labelDireccionC = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        txtDireccionC = new javax.swing.JTextField();
        txtRucC = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableCl = new javax.swing.JTable();
        txtIdCl = new javax.swing.JTextField();
        labelRucC = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableTrb = new javax.swing.JTable();
        cbCargoT = new javax.swing.JComboBox<>();
        labelNombreT = new javax.swing.JLabel();
        labelApellidosT = new javax.swing.JLabel();
        labelDniT = new javax.swing.JLabel();
        labelTelefonoT = new javax.swing.JLabel();
        labelCorreoT = new javax.swing.JLabel();
        labelCargoT = new javax.swing.JLabel();
        txtNombreT = new javax.swing.JTextField();
        txtApellidoT = new javax.swing.JTextField();
        txtDniT = new javax.swing.JTextField();
        txtTelefonoT = new javax.swing.JTextField();
        txtCorreoT = new javax.swing.JTextField();
        btnAgregarT = new javax.swing.JButton();
        btnEditarT = new javax.swing.JButton();
        btnEliminarT = new javax.swing.JButton();
        txtIdTrb = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tableuser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuarioU = new javax.swing.JTextField();
        cdCargou = new javax.swing.JComboBox<>();
        btnAgregarU = new javax.swing.JButton();
        btnEditarU = new javax.swing.JButton();
        btnEliminarU = new javax.swing.JButton();
        txtIduser = new javax.swing.JTextField();
        txtcontraseñau = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtlugar = new javax.swing.JTextField();
        txttiposervicio = new javax.swing.JTextField();
        txtrucs = new javax.swing.JTextField();
        txtfechacancelacion = new javax.swing.JTextField();
        txttrabajadors = new javax.swing.JTextField();
        txtid_serviciocancelado = new javax.swing.JTextField();
        btnañadirserv = new javax.swing.JButton();
        btneditarserv = new javax.swing.JButton();
        btneliminarserv = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        Tableserv = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnagregarp = new javax.swing.JButton();
        btneditarp = new javax.swing.JButton();
        btneliminarp = new javax.swing.JButton();
        txtproductop = new javax.swing.JTextField();
        txtfechap = new javax.swing.JTextField();
        txtempresap = new javax.swing.JTextField();
        txtrucp = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableProveedores = new javax.swing.JTable();
        txtidproveedor = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableFbr = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnImagen = new javax.swing.JButton();
        labelImagen = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        nombreDevoluciones = new javax.swing.JTextField();
        datosDevoluciones = new javax.swing.JTextField();
        fechaDevoluciones = new javax.swing.JTextField();
        cantidadDevoluciones = new javax.swing.JTextField();
        motivoDevoluciones = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnañadirservicio = new javax.swing.JButton();
        btneditarservicio = new javax.swing.JButton();
        btneliminarservicio = new javax.swing.JButton();
        txtlugarservicio = new javax.swing.JTextField();
        txttipo_servicio = new javax.swing.JTextField();
        txttrabajadorservicio = new javax.swing.JTextField();
        txtfecha_inicioservicio = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelBotones.setBackground(new java.awt.Color(5, 59, 80));

        btnVenta.setBackground(new java.awt.Color(23, 107, 135));
        btnVenta.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnVenta.setForeground(new java.awt.Color(241, 239, 239));
        btnVenta.setText("Venta");
        btnVenta.setBorder(null);
        btnVenta.setMaximumSize(new java.awt.Dimension(60, 24));
        btnVenta.setMinimumSize(new java.awt.Dimension(60, 24));

        btnAlmacen.setBackground(new java.awt.Color(23, 107, 135));
        btnAlmacen.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAlmacen.setForeground(new java.awt.Color(241, 239, 239));
        btnAlmacen.setText("Almacen");
        btnAlmacen.setBorder(null);
        btnAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(23, 107, 135));
        btnClientes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(241, 239, 239));
        btnClientes.setText("Clientes");
        btnClientes.setBorder(null);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedores.setBackground(new java.awt.Color(23, 107, 135));
        btnProveedores.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(241, 239, 239));
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorder(null);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnServicios.setBackground(new java.awt.Color(23, 107, 135));
        btnServicios.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnServicios.setForeground(new java.awt.Color(241, 239, 239));
        btnServicios.setText("Servicios");
        btnServicios.setBorder(null);

        btnFabricacion.setBackground(new java.awt.Color(23, 107, 135));
        btnFabricacion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnFabricacion.setForeground(new java.awt.Color(241, 239, 239));
        btnFabricacion.setText("Fabricación");
        btnFabricacion.setBorder(null);
        btnFabricacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFabricacionActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(23, 107, 135));
        btnUsuarios.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(241, 239, 239));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(null);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnTrabajadores.setBackground(new java.awt.Color(23, 107, 135));
        btnTrabajadores.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnTrabajadores.setForeground(new java.awt.Color(241, 239, 239));
        btnTrabajadores.setText("Trabajadores");
        btnTrabajadores.setBorder(null);
        btnTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajadoresActionPerformed(evt);
            }
        });

        btnServCan.setBackground(new java.awt.Color(23, 107, 135));
        btnServCan.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnServCan.setForeground(new java.awt.Color(241, 239, 239));
        btnServCan.setText("Servicios Cancelados");
        btnServCan.setBorder(null);
        btnServCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServCanActionPerformed(evt);
            }
        });

        btnDevoluciones.setBackground(new java.awt.Color(23, 107, 135));
        btnDevoluciones.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnDevoluciones.setForeground(new java.awt.Color(241, 239, 239));
        btnDevoluciones.setText("Devoluciones");
        btnDevoluciones.setBorder(null);

        labelUTI.setFont(new java.awt.Font("Dialog", 1, 52)); // NOI18N
        labelUTI.setForeground(new java.awt.Color(238, 238, 238));
        labelUTI.setText("UTI");

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(238, 238, 238));

        jLabelBottom.setForeground(new java.awt.Color(238, 238, 238));
        jLabelBottom.setText("Técnicos e Ingenieros");

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(labelLogo)
                .addGap(5, 5, 5)
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUTI)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBottom))
                .addContainerGap(52, Short.MAX_VALUE))
            .addComponent(btnServicios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnServCan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDevoluciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFabricacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelBotonesLayout.createSequentialGroup()
                        .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUTI)
                            .addGroup(PanelBotonesLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabelBottom)))
                .addGap(18, 18, 18)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnServCan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
        );

        PanelServicios.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1233, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Venta", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        labelProducto.setText("Producto");

        labelMarca.setText("Marca");

        labelPrecio.setText("Precio");

        labelCantidad.setText("Cantidad");

        btnAñadirAlm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAñadirAlm.setText("Añadir");
        btnAñadirAlm.setBorder(null);
        btnAñadirAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirAlmActionPerformed(evt);
            }
        });

        TableAlm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Marca", "Precio", "Cantidad"
            }
        ));
        TableAlm.setEnabled(false);
        TableAlm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAlmMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableAlm);

        btnEditarAlm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEditarAlm.setText("Editar");
        btnEditarAlm.setBorder(null);
        btnEditarAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAlmActionPerformed(evt);
            }
        });

        btnEliminarAlm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEliminarAlm.setText("Eliminar");
        btnEliminarAlm.setBorder(null);
        btnEliminarAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtProducto)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
                            .addComponent(txtMarca))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioAlm)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addGap(32, 32, 32)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(txtCantidadAlm))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnAñadirAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(txtIdAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProducto)
                    .addComponent(labelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadirAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
        );

        jTabbedPane.addTab("Almacen", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnAñadirCl.setText("Añadir");
        btnAñadirCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirClActionPerformed(evt);
            }
        });

        btnEditarCl.setText("Editar");
        btnEditarCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClActionPerformed(evt);
            }
        });

        btnEliminarCl.setText("Eliminar");
        btnEliminarCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClActionPerformed(evt);
            }
        });

        labelNombreC.setText("Nombre");

        labelDireccionC.setText("Dirección");

        txtNombreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCActionPerformed(evt);
            }
        });

        TableCl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección", "RUC"
            }
        ));
        TableCl.setEnabled(false);
        TableCl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableCl);

        labelRucC.setText("RUC");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombreC)
                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtRucC, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnAñadirCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarCl, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelRucC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(txtIdCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombreC)
                            .addComponent(labelDireccionC)
                            .addComponent(labelRucC)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIdCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAñadirCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRucC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(619, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Clientes", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        TableTrb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellidos", "DNI", "Teléfono", "Correo", "Cargo"
            }
        ));
        TableTrb.setEnabled(false);
        TableTrb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableTrbMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableTrb);

        cbCargoT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trabajador", "Vendedor" }));
        cbCargoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargoTActionPerformed(evt);
            }
        });

        labelNombreT.setText("Nombre");

        labelApellidosT.setText("Apellidos");

        labelDniT.setText("DNI");

        labelTelefonoT.setText("Teléfono");

        labelCorreoT.setText("Correo");

        labelCargoT.setText("Cargo");

        txtApellidoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoTActionPerformed(evt);
            }
        });

        btnAgregarT.setText("Añadir");
        btnAgregarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTActionPerformed(evt);
            }
        });

        btnEditarT.setText("Editar");
        btnEditarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTActionPerformed(evt);
            }
        });

        btnEliminarT.setText("Eliminar");
        btnEliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelCargoT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbCargoT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(labelNombreT)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNombreT, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidoT)
                            .addComponent(labelApellidosT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDniT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDniT))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoT)
                            .addComponent(labelTelefonoT))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtCorreoT)
                                .addGap(71, 71, 71))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(labelCorreoT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregarT, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarT, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarT, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 584, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdTrb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(411, 411, 411))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreT)
                    .addComponent(labelApellidosT)
                    .addComponent(labelDniT)
                    .addComponent(labelTelefonoT)
                    .addComponent(labelCorreoT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCargoT)
                .addGap(4, 4, 4)
                .addComponent(cbCargoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarT)
                    .addComponent(btnEditarT)
                    .addComponent(btnEliminarT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 422, Short.MAX_VALUE)
                .addComponent(txtIdTrb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );

        jTabbedPane.addTab("Trabajadores", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        Tableuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Cargo", "Contraseña"
            }
        ));
        Tableuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableuserMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Tableuser);

        jLabel1.setText("Usuario");

        jLabel2.setText("Cargo");

        jLabel3.setText("Contraseña");

        cdCargou.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Trabajador", "Gerente", "Tecnico", "Ingeniero" }));

        btnAgregarU.setText("Añadir");
        btnAgregarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUActionPerformed(evt);
            }
        });

        btnEditarU.setText("Editar");
        btnEditarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUActionPerformed(evt);
            }
        });

        btnEliminarU.setText("Eliminar");
        btnEliminarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuarioU, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cdCargou, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtcontraseñau, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(btnAgregarU, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarU, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarU, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addGap(49, 49, 49))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuarioU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdCargou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontraseñau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarU)
                    .addComponent(btnEditarU)
                    .addComponent(btnEliminarU))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                .addComponent(txtIduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        jTabbedPane.addTab("Usuario", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Lugar");

        jLabel9.setText("Tipo de Servicio");

        jLabel10.setText("RUC");

        jLabel11.setText("Fecha de Cancelacion");

        jLabel12.setText("Trabajador");

        txtlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlugarActionPerformed(evt);
            }
        });

        txttiposervicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttiposervicioActionPerformed(evt);
            }
        });

        txtrucs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrucsActionPerformed(evt);
            }
        });

        txtfechacancelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechacancelacionActionPerformed(evt);
            }
        });

        btnañadirserv.setText("Añadir");
        btnañadirserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadirservActionPerformed(evt);
            }
        });

        btneditarserv.setText("Editar");
        btneditarserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarservActionPerformed(evt);
            }
        });

        btneliminarserv.setText("Eliminar");
        btneliminarserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarservActionPerformed(evt);
            }
        });

        Tableserv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lugar", "Tipo de Servicio", "RUC" , "Fecha de Cancelacion","Trabajador"
            }
        ));
        Tableserv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableservMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(Tableserv);
        Tableserv.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(78, 78, 78))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(21, 21, 21))
                            .addComponent(txttiposervicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrucs, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfechacancelacion)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(448, 448, 448))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txttrabajadors, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnañadirserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btneditarserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminarserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(265, 265, 265)
                        .addComponent(txtid_serviciocancelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(670, 670, 670))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane8)
                        .addGap(334, 334, 334))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttiposervicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrucs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechacancelacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttrabajadors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnañadirserv)
                    .addComponent(btneditarserv)
                    .addComponent(btneliminarserv)
                    .addComponent(txtid_serviciocancelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(314, 314, 314))
        );

        jTabbedPane.addTab("Servicios Cancelados", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Producto");

        jLabel5.setText("Fecha de Entrega");

        jLabel6.setText("Nombre de Empresa");

        jLabel7.setText("RUC");

        btnagregarp.setText("Añadir");
        btnagregarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarpActionPerformed(evt);
            }
        });

        btneditarp.setText("Editar");
        btneditarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarpActionPerformed(evt);
            }
        });

        btneliminarp.setText("Eliminar");
        btneliminarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarpActionPerformed(evt);
            }
        });

        txtfechap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechapActionPerformed(evt);
            }
        });

        txtempresap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtempresapActionPerformed(evt);
            }
        });

        TableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Fecha de Entrega", "Empresa" , "RUC"
            }
        ));
        TableProveedores.setEnabled(false);
        TableProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProveedoresMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TableProveedores);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnagregarp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(79, 79, 79)
                .addComponent(btneditarp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(69, 69, 69)
                .addComponent(btneliminarp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(809, 809, 809))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(104, 104, 104))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtproductop)
                        .addGap(41, 41, 41)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtfechap)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(82, 82, 82)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtempresap)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(94, 94, 94)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(txtidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtrucp)
                                .addGap(384, 384, 384))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(482, 482, 482))))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane7)
                .addGap(358, 358, 358))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproductop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtempresap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrucp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregarp)
                    .addComponent(btneditarp)
                    .addComponent(btneliminarp))
                .addGap(237, 237, 237))
        );

        jTabbedPane.addTab("Proveedores", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel17.setText("Numero de Tablero");

        jLabel18.setText("Tablero");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("Foto Tablero");

        jLabel20.setText("Material");

        TableFbr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Número de Tablero", "Tablero", "Foto de Tablero", "Material"
            }
        ));
        TableFbr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableFbrMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TableFbr);

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");

        jButton3.setText("Editar");

        btnImagen.setText("Añadir Imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnImagen)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(labelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImagen)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(549, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Fabricación", jPanel8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Nombre");

        jLabel22.setText("Datos");

        jLabel23.setText("Fecha");

        jLabel24.setText("Cantidad");

        jLabel25.setText("Motivo");

        jButton4.setText("Añadir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Editar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable2.setAutoCreateColumnsFromModel(false);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(datosDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(motivoDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datosDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motivoDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(590, Short.MAX_VALUE))
        );

        nombreDevoluciones.getAccessibleContext().setAccessibleDescription("");
        motivoDevoluciones.getAccessibleContext().setAccessibleName("");

        jTabbedPane.addTab("Devoluciones", jPanel10);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("Lugar");

        jLabel15.setText("Fecha de Inicio");

        jLabel16.setText("Trabajador");

        jLabel21.setText("Tipo de servicio");

        btnañadirservicio.setText("Añadir");
        btnañadirservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadirservicioActionPerformed(evt);
            }
        });

        btneditarservicio.setText("Editar");

        btneliminarservicio.setText("Eliminar");
        btneliminarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarservicioActionPerformed(evt);
            }
        });

        txtlugarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlugarservicioActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lugar", "Tipo de Servicio", "Trabajador" , "Fecha de Inicio"
            }));
            jTable1.setShowGrid(false);
            jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTable1MouseClicked(evt);
                }
            });
            jScrollPane9.setViewportView(jTable1);

            javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
            jPanel9.setLayout(jPanel9Layout);
            jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(txtlugarservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txttipo_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txttrabajadorservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(txtfecha_inicioservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(btnañadirservicio)
                            .addGap(18, 18, 18)
                            .addComponent(btneditarservicio)
                            .addGap(18, 18, 18)
                            .addComponent(btneliminarservicio))
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 42, Short.MAX_VALUE))
            );
            jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel14))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtlugarservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttipo_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttrabajadorservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfecha_inicioservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnañadirservicio)
                        .addComponent(btneditarservicio)
                        .addComponent(btneliminarservicio))
                    .addGap(477, 477, 477))
            );

            txttrabajadorservicio.getAccessibleContext().setAccessibleName("");

            jTabbedPane.addTab("Servicios", jPanel9);

            javax.swing.GroupLayout PanelServiciosLayout = new javax.swing.GroupLayout(PanelServicios);
            PanelServicios.setLayout(PanelServiciosLayout);
            PanelServiciosLayout.setHorizontalGroup(
                PanelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelServiciosLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 851, Short.MAX_VALUE))
            );
            PanelServiciosLayout.setVerticalGroup(
                PanelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(PanelServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(PanelServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 824, Short.MAX_VALUE))
                        .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 852, Short.MAX_VALUE))
                    .addGap(0, 0, 0))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents
    // Métodos para el módulo Almacen 
    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarAlmacen(); //Llama al método Listar Clientes para mostrarlo en la tabla Almacen
        jTabbedPane.setSelectedIndex(1); // Cambia a la pestaña "Almacenamiento" (index 1)
        btnAlmacen.setFocusable(false); 
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void btnEliminarAlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlmActionPerformed
        if(!"".equals(txtIdAlm.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar el producto?");
            if (confirmacion == 0){
                int id = Integer.parseInt(txtIdAlm.getText());
                almD.EliminarAlmacen(id);
                LimpiarTabla();
                LimpiarFieldAlm();
                ListarAlmacen();
            }
        }
    }//GEN-LAST:event_btnEliminarAlmActionPerformed

    private void btnEditarAlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAlmActionPerformed
        if("".equals(txtIdAlm.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtProducto.getText())|| !"".equals(txtMarca.getText()) || !"".equals(txtPrecioAlm.getText()) || !"".equals(txtCantidadAlm.getText())){
                alm.setProducto(txtProducto.getText());
                alm.setMarca(txtMarca.getText());
                alm.setPrecio(Double.parseDouble(txtPrecioAlm.getText()));
                alm.setCantidad(Integer.parseInt(txtCantidadAlm.getText()));
                alm.setId_producto(Integer.parseInt(txtIdAlm.getText()));
                almD.EditarAlmacen(alm);
                LimpiarTabla();
                LimpiarFieldAlm();
                ListarAlmacen();
            }
        }
    }//GEN-LAST:event_btnEditarAlmActionPerformed

    private void btnAñadirAlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirAlmActionPerformed
        if(!"".equals(txtProducto.getText()) || !"".equals(txtMarca.getText()) || !"".equals(txtPrecioAlm.getText()) || !"".equals(txtCantidadAlm.getText())){
            alm.setProducto(txtProducto.getText());
            alm.setMarca(txtMarca.getText());
            alm.setPrecio(Double.parseDouble(txtPrecioAlm.getText()));
            alm.setCantidad(Integer.parseInt(txtCantidadAlm.getText()));
            almD.AgregarAlmacen(alm);
            LimpiarTabla();
            LimpiarFieldAlm();
            ListarAlmacen();
            JOptionPane.showMessageDialog(null, "Producto registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_btnAñadirAlmActionPerformed

    private void TableAlmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAlmMouseClicked
        //Llamar los valores de la Tabla a los jFields
        int fila = TableAlm.rowAtPoint(evt.getPoint());
        txtIdAlm.setText(TableAlm.getValueAt(fila,0).toString());
        txtProducto.setText(TableAlm.getValueAt(fila, 1).toString());
        txtMarca.setText(TableAlm.getValueAt(fila, 2).toString());
        txtPrecioAlm.setText(TableAlm.getValueAt(fila, 3).toString());
        txtCantidadAlm.setText(TableAlm.getValueAt(fila,4).toString());
    }//GEN-LAST:event_TableAlmMouseClicked

    //Métodos para el módulo Clientes
    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarCliente(); //Llama al método Listar Clientes para mostrarlo en la tabla Almacen
        jTabbedPane.setSelectedIndex(2); // Cambia a la pestaña "Cliente" (index 2)
        btnAlmacen.setFocusable(false); 
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnEliminarClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClActionPerformed
        if(!"".equals(txtIdCl.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar al cliente?");
            if (confirmacion == 0){
                int id = Integer.parseInt(txtIdCl.getText());
                clD.EliminarCliente(id);
                LimpiarTabla();
                LimpiarFieldCl();
                ListarCliente();
            }
        }
    }//GEN-LAST:event_btnEliminarClActionPerformed

    private void btnEditarClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClActionPerformed
        if("".equals(txtIdCl.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila para poder editar los datos");
        } else {
            if (!"".equals(txtNombreC.getText())|| !"".equals(txtDireccionC.getText()) || !"".equals(txtRucC.getText())){
                cl.setNombreC(txtNombreC.getText());
                cl.setDireccionC(txtDireccionC.getText());
                cl.setRuc(txtRucC.getText());
                cl.setId_cliente(Integer.parseInt(txtIdCl.getText()));
                clD.EditarCliente(cl);
                LimpiarTabla();
                LimpiarFieldCl();
                ListarCliente();
            }
        }
    }//GEN-LAST:event_btnEditarClActionPerformed

    private void btnAñadirClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirClActionPerformed
        if(!"".equals(txtNombreC.getText()) || !"".equals(txtDireccionC.getText()) || !"".equals(txtRucC.getText())){
            cl.setNombreC(txtNombreC.getText());
            cl.setDireccionC(txtDireccionC.getText());
            cl.setRuc(txtRucC.getText());
            clD.AgregarCliente(cl);
            LimpiarTabla();
            LimpiarFieldCl();
            ListarCliente();
            JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_btnAñadirClActionPerformed

    private void TableClMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClMouseClicked
        //Llamar los valores de la Tabla a los jFields de la Tabla de Clientes
        int fila = TableCl.rowAtPoint(evt.getPoint());
        txtIdCl.setText(TableCl.getValueAt(fila,0).toString());
        txtNombreC.setText(TableCl.getValueAt(fila, 1).toString());
        txtDireccionC.setText(TableCl.getValueAt(fila, 2).toString());
        txtRucC.setText(TableCl.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TableClMouseClicked

    //Método para el módulo Trabajadores
    private void btnTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajadoresActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarTrabajador(); //Llama al método Listar Clientes para mostrarlo en la tabla Almacen
        jTabbedPane.setSelectedIndex(3); // Cambia a la pestaña "Trabajadores" (index 3)
        btnTrabajadores.setFocusable(false); 
    }//GEN-LAST:event_btnTrabajadoresActionPerformed

     private void btnEliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTActionPerformed
        if(!"".equals(txtIdTrb.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar al trabajador?");
            if (confirmacion == 0){
                int id = Integer.parseInt(txtIdTrb.getText());
                trbD.EliminarTrabajador(id);
                LimpiarTabla();
                LimpiarFieldTrb();
                ListarTrabajador();
            }
        }
    }//GEN-LAST:event_btnEliminarTActionPerformed

    private void btnEditarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTActionPerformed
        if("".equals(txtIdTrb.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila para poder editar los datos");
        } else {
            if (!"".equals(txtNombreT.getText()) || !"".equals(txtApellidoT.getText()) || !"".equals(txtDniT.getText()) || !"".equals(txtTelefonoT.getText()) || !"".equals(txtCorreoT.getText())){
                trb.setNombreT(txtNombreT.getText());
                trb.setApellidoT(txtApellidoT.getText());
                trb.setDniT(txtDniT.getText());
                trb.setCelularT(txtTelefonoT.getText());
                trb.setCorreoT(txtCorreoT.getText());
                trb.setCargoT((String) cbCargoT.getSelectedItem());
                trb.setId_trabajador(Integer.parseInt(txtIdTrb.getText()));
                trbD.EditarTrabajador(trb);
                LimpiarTabla();
                LimpiarFieldTrb();
                ListarTrabajador();
            }
        }
    }//GEN-LAST:event_btnEditarTActionPerformed

    private void btnAgregarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTActionPerformed
        if (!"".equals(txtNombreT.getText()) || !"".equals(txtApellidoT.getText()) || !"".equals(txtDniT.getText()) || !"".equals(txtTelefonoT.getText()) || !"".equals(txtCorreoT.getText()) || !"".equals(cbCargoT.getSelectedIndex())){
            trb.setNombreT(txtNombreT.getText());
            trb.setApellidoT(txtApellidoT.getText());
            trb.setDniT(txtDniT.getText());
            trb.setCelularT(txtCantidadAlm.getText());
            trb.setCorreoT(txtCorreoT.getText());
            trb.setCargoT((String) cbCargoT.getSelectedItem());
            trbD.AgregarTrabajador(trb);
            LimpiarTabla();
            LimpiarFieldTrb();
            ListarTrabajador();
            JOptionPane.showMessageDialog(null, "Producto registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_btnAgregarTActionPerformed

    private void TableTrbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableTrbMouseClicked
        //Llamar los valores de la Tabla a los jFields
        int fila = TableTrb.rowAtPoint(evt.getPoint());
        txtIdTrb.setText(TableTrb.getValueAt(fila,0).toString());
        txtNombreT.setText(TableTrb.getValueAt(fila, 1).toString());
        txtApellidoT.setText(TableTrb.getValueAt(fila, 2).toString());
        txtDniT.setText(TableTrb.getValueAt(fila, 3).toString());
        txtTelefonoT.setText(TableTrb.getValueAt(fila,4).toString());
        txtCorreoT.setText(TableTrb.getValueAt(fila,5).toString());
        cbCargoT.setSelectedItem(TableTrb.getValueAt(fila,6));
    }//GEN-LAST:event_TableTrbMouseClicked

    //Método para el módulo Usuarios
    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarUsuario(); //Llama al método Listar usuario para mostrarlo en la tabla usuario
        jTabbedPane.setSelectedIndex(4); // Cambia a la pestaña "Usuario" (index 4)
        btnUsuarios.setFocusable(false); 
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnEliminarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUActionPerformed
        if(!"".equals(txtIduser.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar al usuario?");
            if (confirmacion == 0){
                int id = Integer.parseInt(txtIduser.getText());
                usrD.EliminarUsuario(id);
                LimpiarTabla();
                LimpiarFieldUser();
                ListarUsuario();
            }
        }
    }//GEN-LAST:event_btnEliminarUActionPerformed

    private void btnEditarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUActionPerformed
        if("".equals(txtIduser.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila para poder editar los datos");
        } else {
            if (!"".equals(txtUsuarioU.getText()) ||!"".equals(txtcontraseñau.getText())){
                usr.setUsuarioU(txtUsuarioU.getText());
                usr.setContraseñaU(txtcontraseñau.getText());
                usr.setCargoU((String) cdCargou.getSelectedItem());
                usr.setId_usuarioU(Integer.parseInt(txtIduser.getText()));
                usrD.EditarUsuario(usr);
                LimpiarTabla();
                LimpiarFieldUser();
                ListarUsuario();
            }
        }
    }//GEN-LAST:event_btnEditarUActionPerformed

    private void btnAgregarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUActionPerformed
        if (!"".equals(txtUsuarioU.getText()) || !"".equals(txtcontraseñau.getText()) || !"".equals(cdCargou.getSelectedIndex())){
            usr.setUsuarioU(txtUsuarioU.getText());
            usr.setContraseñaU(txtcontraseñau.getText());
            usr.setCargoU((String) cdCargou.getSelectedItem());
            usrD.AgregarUsuario(usr);
            LimpiarTabla();
            LimpiarFieldUser();
            ListarUsuario();
            JOptionPane.showMessageDialog(null, "Usuario registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_btnAgregarUActionPerformed

    private void TableuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableuserMouseClicked
        //Llamar los valores de la Tabla a los jFields
        int fila = Tableuser.rowAtPoint(evt.getPoint());
        txtIduser.setText(Tableuser.getValueAt(fila,0).toString());
        txtUsuarioU.setText(Tableuser.getValueAt(fila, 1).toString());
        cdCargou.setSelectedItem(Tableuser.getValueAt(fila,2));
        txtcontraseñau.setText(Tableuser.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TableuserMouseClicked

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarProveedores();
        jTabbedPane.setSelectedIndex(5); // Cambia a la pestaña "Proveedores"
        btnProveedores.setFocusable(false);
    }//GEN-LAST:event_btnProveedoresActionPerformed
//METODO PARA SERVICIOCANCELADO
    private void btneditarservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarservActionPerformed
                if("".equals(txtid_serviciocancelado.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtlugar.getText())|| !"".equals(txttiposervicio.getText()) || !"".equals(txtrucs.getText()) || !"".equals(txtfechacancelacion.getText())|| !"".equals(txttrabajadors.getText())){
                serv.setLugars(txtlugar.getText());
                serv.setTiposervicio(txttiposervicio.getText());
                serv.setRUCs((txtrucs.getText()));
                serv.setFechacancelacion((txtfechacancelacion.getText()));
                serv.setTrabajador((txttrabajadors.getText()));
                serv.setId_serviciocancelado(Integer.parseInt(txtid_serviciocancelado.getText()));
                servD.EditarServiciocancelado(serv);
                LimpiarTabla();
                LimpiarFieldserv();
                ListarServiciocancelado();
            }
        }
    }//GEN-LAST:event_btneditarservActionPerformed

    private void TableservMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableservMouseClicked
            //Llamar los valores de la Tabla a los jFields
        int fila = Tableserv.rowAtPoint(evt.getPoint());
        txtid_serviciocancelado.setText(Tableserv.getValueAt(fila,0).toString());
        txtlugar.setText(Tableserv.getValueAt(fila, 1).toString());
        txttiposervicio.setText(Tableserv.getValueAt(fila, 2).toString());
        txtrucs.setText(Tableserv.getValueAt(fila, 3).toString());
        txtfechacancelacion.setText(Tableserv.getValueAt(fila, 4).toString());
        txttrabajadors.setText(Tableserv.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableservMouseClicked

    private void txtfechacancelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechacancelacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechacancelacionActionPerformed

    private void btnServCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServCanActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarServiciocancelado();
        jTabbedPane.setSelectedIndex(6); // Cambia a la pestaña "Serviciocancelado"
        btnServCan.setFocusable(false);
    }//GEN-LAST:event_btnServCanActionPerformed

    private void btnañadirservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnañadirservActionPerformed
        if(!"".equals(txtlugar.getText()) || !"".equals(txttiposervicio.getText()) || !"".equals(txtrucs.getText()) || !"".equals(txtfechacancelacion.getText())|| !"".equals(txttrabajadors.getText())){
            serv.setLugars(txtlugar.getText());
            serv.setTiposervicio(txttiposervicio.getText());
            serv.setRUCs(txtrucs.getText());
            serv.setFechacancelacion((txtfechacancelacion.getText()));
            serv.setTrabajador((txttrabajadors.getText()));
            servD.AgregarServiciocancelado(serv);
            LimpiarTabla();
            LimpiarFieldserv();
            ListarServiciocancelado();
            JOptionPane.showMessageDialog(null, "Servicio Cancelado registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_btnañadirservActionPerformed

    private void btneliminarservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarservActionPerformed
                if(!"".equals(txtid_serviciocancelado.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar al Servicio?");
            if (confirmacion == 0){
                int id = Integer.parseInt(txtid_serviciocancelado.getText());
                servD.EliminarServiciocancelado(id);
                LimpiarTabla();
                LimpiarFieldserv();
                ListarServiciocancelado();
            }
        }
    }//GEN-LAST:event_btneliminarservActionPerformed
    //Métodos para el módulo de Fabricación
    private void btnFabricacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFabricacionActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarServiciocancelado();
        jTabbedPane.setSelectedIndex(7); // Cambia a la pestaña "Fabricación"
        btnFabricacion.setFocusable(false);
    }//GEN-LAST:event_btnFabricacionActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        JFileChooser buscar = new JFileChooser();
        FileNameExtensionFilter formato = new FileNameExtensionFilter("PNG","JPEG","JPG","GIF","png","jpeg", "jpg", "gif");
        buscar.setFileFilter(formato);
        if (buscar.showOpenDialog(this) ==  JFileChooser.APPROVE_OPTION) {
            ruta = buscar.getSelectedFile().getAbsolutePath();
            Image mImage = new ImageIcon(ruta).getImage();
            ImageIcon mIcon = new ImageIcon(mImage.getScaledInstance(labelImagen.getWidth(),labelImagen.getHeight(),0));
            labelImagen.setIcon(mIcon);
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void txtrucsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrucsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrucsActionPerformed

    private void TableFbrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableFbrMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableFbrMouseClicked

    private void txtNombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCActionPerformed

    private void cbCargoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoTActionPerformed

    private void txtApellidoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoTActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void txttiposervicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttiposervicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttiposervicioActionPerformed

    private void txtlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtlugarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugarservicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugarservicioActionPerformed

    private void btneliminarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarservicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarservicioActionPerformed

    private void btnañadirservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnañadirservicioActionPerformed
        String lugar = txtlugarservicio.getText();
        String tipoServicio = txttipo_servicio.getText();
        String trabajador = txttrabajadorservicio.getText();
        String fechaInicio = txtfecha_inicioservicio.getText();

        // Crea un objeto Servicios con la información obtenida
        Servicios servicio = new Servicios(lugar, tipoServicio, fechaInicio, trabajador);

        // Crea una instancia del DAO de Servicios
        ServiciosDAO servicioDAO = new ServiciosDAO();

        // Llama al método agregarServicio del DAO para agregar el servicio a la base de datos
        boolean exito = servicioDAO.agregarServicio(servicio);

        // Verifica si la operación fue exitosa
        if (exito) {
            // Realiza acciones adicionales si es necesario
            System.out.println("Servicio agregado correctamente a la base de datos.");
            // Puedes limpiar los campos después de agregar el servicio si lo deseas
            limpiarCampos();
        } else {
            // Muestra un mensaje de error si la operación no fue exitosa
            System.out.println("Error al agregar el servicio a la base de datos.");
        }
        }

        // Método para limpiar los campos después de agregar un servicio
        private void limpiarCampos() {
            txtlugarservicio.setText("");
            txttipo_servicio.setText("");
            txttrabajadorservicio.setText("");
            txtfecha_inicioservicio.setText("");
    }//GEN-LAST:event_btnañadirservicioActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         if (!"".equals(nombreDevoluciones.getText()) || !"".equals(datosDevoluciones.getText()) || 
        !"".equals(fechaDevoluciones.getText()) || !"".equals(cantidadDevoluciones.getText()) || 
        !"".equals(motivoDevoluciones.getText())) {
        
        Devolucion devolucion = new Devolucion();
        devolucion.setNombre(nombreDevoluciones.getText());
        devolucion.setDatos(datosDevoluciones.getText());
        devolucion.setFecha(fechaDevoluciones.getText());
        devolucion.setCantidad(cantidadDevoluciones.getText());
        devolucion.setMotivo(motivoDevoluciones.getText());
        
        DevolucionDAO devolucionDAO = new DevolucionDAO();
        devolucionDAO.AgregarDevolucion(devolucion);
        
        LimpiarTablaDevoluciones();
        ListarDevoluciones();
        
        JOptionPane.showMessageDialog(null, "Devolución registrada");
    } else {
        JOptionPane.showMessageDialog(null, "Los campos están vacíos");
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
   
        }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProveedoresMouseClicked
        //Llamar los valores de la Tabla a los jFields
        int fila = TableProveedores.rowAtPoint(evt.getPoint());
        txtidproveedor.setText(TableProveedores.getValueAt(fila,0).toString());
        txtproductop.setText(TableProveedores.getValueAt(fila, 1).toString());
        txtfechap.setText(TableProveedores.getValueAt(fila, 2).toString());
        txtempresap.setText(TableProveedores.getValueAt(fila, 3).toString());
        txtrucp.setText(TableProveedores.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_TableProveedoresMouseClicked

    private void txtempresapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtempresapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtempresapActionPerformed

    private void txtfechapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechapActionPerformed

    }//GEN-LAST:event_txtfechapActionPerformed

    private void btneliminarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarpActionPerformed
        if(!"".equals(txtidproveedor.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar al proveedor?");
            if (confirmacion == 0){
                int id = Integer.parseInt(txtidproveedor.getText());
                proD.EliminarProveedor(id);
                LimpiarTabla();
                LimpiarFieldpro();
                ListarProveedores();
            }
        }
    }//GEN-LAST:event_btneliminarpActionPerformed

    private void btneditarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarpActionPerformed
        if("".equals(txtidproveedor.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtproductop.getText())|| !"".equals(txtfechap.getText()) || !"".equals(txtempresap.getText()) || !"".equals(txtrucp.getText())){
                pro.setProductoP(txtproductop.getText());
                pro.setFechaentregap(txtfechap.getText());
                pro.setEmpresap(txtempresap.getText());
                pro.setRUCp(txtrucp.getText());
                pro.setId_proveedor(Integer.parseInt(txtidproveedor.getText()));
                proD.EditarProveedor(pro);
                LimpiarTabla();
                LimpiarFieldpro();
                ListarProveedores();
            }
        }
    }//GEN-LAST:event_btneditarpActionPerformed

    private void btnagregarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarpActionPerformed
        if(!"".equals(txtproductop.getText()) || !"".equals(txtfechap.getText()) || !"".equals(txtempresap.getText()) || !"".equals(txtrucp.getText())){
            pro.setProductoP(txtproductop.getText());
            pro.setFechaentregap(txtfechap.getText());
            pro.setEmpresap(txtempresap.getText());
            pro.setRUCp((txtrucp.getText()));
            proD.AgregarProveedor(pro);
            LimpiarTabla();
            LimpiarFieldpro();
            ListarProveedores();
            JOptionPane.showMessageDialog(null, "Proveedor registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_btnagregarpActionPerformed

   
    public static void main(String args[]) {
      
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelServicios;
    private javax.swing.JTable TableAlm;
    private javax.swing.JTable TableCl;
    private javax.swing.JTable TableFbr;
    private javax.swing.JTable TableProveedores;
    private javax.swing.JTable TableTrb;
    private javax.swing.JTable Tableserv;
    private javax.swing.JTable Tableuser;
    private javax.swing.JButton btnAgregarT;
    private javax.swing.JButton btnAgregarU;
    private javax.swing.JButton btnAlmacen;
    private javax.swing.JButton btnAñadirAlm;
    private javax.swing.JButton btnAñadirCl;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnDevoluciones;
    private javax.swing.JButton btnEditarAlm;
    private javax.swing.JButton btnEditarCl;
    private javax.swing.JButton btnEditarT;
    private javax.swing.JButton btnEditarU;
    private javax.swing.JButton btnEliminarAlm;
    private javax.swing.JButton btnEliminarCl;
    private javax.swing.JButton btnEliminarT;
    private javax.swing.JButton btnEliminarU;
    private javax.swing.JButton btnFabricacion;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnServCan;
    private javax.swing.JButton btnServicios;
    private javax.swing.JButton btnTrabajadores;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVenta;
    private javax.swing.JButton btnagregarp;
    private javax.swing.JButton btnañadirserv;
    private javax.swing.JButton btnañadirservicio;
    private javax.swing.JButton btneditarp;
    private javax.swing.JButton btneditarserv;
    private javax.swing.JButton btneditarservicio;
    private javax.swing.JButton btneliminarp;
    private javax.swing.JButton btneliminarserv;
    private javax.swing.JButton btneliminarservicio;
    private javax.swing.JTextField cantidadDevoluciones;
    private javax.swing.JComboBox<String> cbCargoT;
    private javax.swing.JComboBox<String> cdCargou;
    private javax.swing.JTextField datosDevoluciones;
    private javax.swing.JTextField fechaDevoluciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBottom;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel labelApellidosT;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCargoT;
    private javax.swing.JLabel labelCorreoT;
    private javax.swing.JLabel labelDireccionC;
    private javax.swing.JLabel labelDniT;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelNombreC;
    private javax.swing.JLabel labelNombreT;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelProducto;
    private javax.swing.JLabel labelRucC;
    private javax.swing.JLabel labelTelefonoT;
    private javax.swing.JLabel labelUTI;
    private javax.swing.JTextField motivoDevoluciones;
    private javax.swing.JTextField nombreDevoluciones;
    private javax.swing.JTextField txtApellidoT;
    private javax.swing.JTextField txtCantidadAlm;
    private javax.swing.JTextField txtCorreoT;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtDniT;
    private javax.swing.JTextField txtIdAlm;
    private javax.swing.JTextField txtIdCl;
    private javax.swing.JTextField txtIdTrb;
    private javax.swing.JTextField txtIduser;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombreT;
    private javax.swing.JTextField txtPrecioAlm;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtRucC;
    private javax.swing.JTextField txtTelefonoT;
    private javax.swing.JTextField txtUsuarioU;
    private javax.swing.JTextField txtcontraseñau;
    private javax.swing.JTextField txtempresap;
    private javax.swing.JTextField txtfecha_inicioservicio;
    private javax.swing.JTextField txtfechacancelacion;
    private javax.swing.JTextField txtfechap;
    private javax.swing.JTextField txtid_serviciocancelado;
    private javax.swing.JTextField txtidproveedor;
    private javax.swing.JTextField txtlugar;
    private javax.swing.JTextField txtlugarservicio;
    private javax.swing.JTextField txtproductop;
    private javax.swing.JTextField txtrucp;
    private javax.swing.JTextField txtrucs;
    private javax.swing.JTextField txttipo_servicio;
    private javax.swing.JTextField txttiposervicio;
    private javax.swing.JTextField txttrabajadors;
    private javax.swing.JTextField txttrabajadorservicio;
    // End of variables declaration//GEN-END:variables
    private void LimpiarFieldAlm(){
        txtIdAlm.setText("");
        txtProducto.setText("");
        txtMarca.setText("");
        txtPrecioAlm.setText("");
        txtCantidadAlm.setText("");
    }
    
    private void LimpiarFieldCl(){
        txtIdCl.setText("");
        txtNombreC.setText("");
        txtDireccionC.setText("");
        txtRucC.setText("");
    }
    
    private void LimpiarFieldTrb(){
        txtIdTrb.setText("");
        txtNombreT.setText("");
        txtApellidoT.setText("");
        txtDniT.setText("");
        txtTelefonoT.setText("");
        txtCorreoT.setText("");
    }
    private void LimpiarFieldUser(){
        txtIduser.setText("");
        txtUsuarioU.setText("");
        txtcontraseñau.setText("");
    }
    private void LimpiarFieldpro(){
        txtidproveedor.setText("");
        txtproductop.setText("");
        txtfechap.setText("");
        txtempresap.setText("");
        txtrucp.setText("");
    }
    private void LimpiarFieldserv(){
        txtid_serviciocancelado.setText("");
        txtlugar.setText("");
        txttiposervicio.setText("");
        txtrucs.setText("");
        txtfechacancelacion.setText("");
        txttrabajadors.setText("");
    }
    
    public void LimpiarFieldDevoluciones() {
    nombreDevoluciones.setText("");
    datosDevoluciones.setText("");
    fechaDevoluciones.setText("");
    cantidadDevoluciones.setText("");
    motivoDevoluciones.setText("");
}

    private void ListarDevoluciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void LimpiarTablaDevoluciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

