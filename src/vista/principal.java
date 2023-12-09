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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;
import modelo.Devolucion;
import modelo.Fabricacion;
import modelo.Proveedores;
import modelo.Serviciocancelado;
import modelo.Servicios;
import modelo.Usuario;

    public class principal extends javax.swing.JFrame {
        
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
    Servicios servicios = new Servicios();
    ServiciosDAO serviciosD = new ServiciosDAO();
    TableRowSorter trs;
   
    public principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Pantalla completa del programa
        txtIdAlm.setVisible(false);  //Ocultar el TextField del Id
        txtIdCl.setVisible(false);   //Ocultar el TextField del Id
        txtIdTrb.setVisible(false);
        txtIduser.setVisible(false);
        IdDevoluciones.setVisible(false);
        txtidservicio.setVisible(false);
        txtIdFab.setVisible(false);
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
        model = (DefaultTableModel) TableServCan.getModel();
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
        TableServCan.setModel(model);
    }
    
     public void ListarFabricacion(){
        TablaFbr.setDefaultRenderer(Object.class, new RenderImage());
        List<Fabricacion> ListarFab = fbrD.ListarFabricacion();
        model = (DefaultTableModel) TablaFbr.getModel();
        Object[] ob = new Object[7];
        for(int i = 0; i < ListarFab.size(); i++){
            ob[0] = ListarFab.get(i).getId_fabricacion();
            ob[1] = ListarFab.get(i).getNumero_tablero();
            ob[2] = ListarFab.get(i).getNombre_producto();
            ob[3] = ListarFab.get(i).getCantidad();
            ob[4] = ListarFab.get(i).getFecha_fabricacion();
            ob[5] = ListarFab.get(i).getTamanio();
            ob[6] = ListarFab.get(i).getTrabajador_fabricacion();
            model.addRow(ob);
        }
        TablaFbr.setModel(model);
    }
    
    public void ListarServicios(){
        List<Servicios> listarServicios = serviciosD.listarServicios();
        model = (DefaultTableModel) TablaServicios.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < listarServicios.size(); i++) {
            ob[0] = listarServicios.get(i).getIdServicio();
            ob[1] = listarServicios.get(i).getLugar();
            ob[2] = listarServicios.get(i).getTipoServicio();
            ob[3] = listarServicios.get(i).getFechaInicio();
            ob[4] = listarServicios.get(i).getTrabajador();
            ob[5] = listarServicios.get(i).getRucSer();
            ob[6] = listarServicios.get(i).getNuBole();
            ob[7] = listarServicios.get(i).getMaterial();
            model.addRow(ob);
        }
        TablaServicios.setModel(model);
    }
    
    public void ListarDevolucion(){
        List<Devolucion> listarDevoluciones = devD.listarDevoluciones();
        model = (DefaultTableModel) TablaDevoluciones.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < listarDevoluciones.size(); i++) {
            ob[0] = listarDevoluciones.get(i).getIdDevolucion();
            ob[1] = listarDevoluciones.get(i).getNombre();
            ob[2] = listarDevoluciones.get(i).getDatos();
            ob[3] = listarDevoluciones.get(i).getFecha();
            ob[4] = listarDevoluciones.get(i).getCantidad();
            ob[5] = listarDevoluciones.get(i).getProducto();
            ob[6] = listarDevoluciones.get(i).getTip_cantidad();
            model.addRow(ob);
        }
        TablaDevoluciones.setModel(model);
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
        jLabel30 = new javax.swing.JLabel();
        txtBusAlm = new javax.swing.JTextField();
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
        jLabel31 = new javax.swing.JLabel();
        txtBusCl = new javax.swing.JTextField();
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
        jLabel32 = new javax.swing.JLabel();
        txtBusTrb = new javax.swing.JTextField();
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
        jLabel33 = new javax.swing.JLabel();
        txtBusUs = new javax.swing.JTextField();
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
        btneditarserv = new javax.swing.JButton();
        btneliminarserv = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        TableServCan = new javax.swing.JTable();
        btnañadirserv = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtBusSerCan = new javax.swing.JTextField();
        txtid_serviciocancelado = new javax.swing.JTextField();
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
        jLabel35 = new javax.swing.JLabel();
        txtBusProv = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        txtNumFab = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbTamanio = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        txtFechaFab = new javax.swing.JTextField();
        AñadirFab = new javax.swing.JButton();
        EliminarFab = new javax.swing.JButton();
        EditarFab = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFbr = new javax.swing.JTable();
        txtNombreFab = new javax.swing.JTextField();
        txtCantFab = new javax.swing.JTextField();
        txtIdFab = new javax.swing.JTextField();
        txtTrabajadorFab = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtBusFab = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtNombreEm = new javax.swing.JTextField();
        txtRUCDev = new javax.swing.JTextField();
        txtFechaDev = new javax.swing.JTextField();
        txtCantDev = new javax.swing.JTextField();
        txtProductoDev = new javax.swing.JTextField();
        AñadirDev = new javax.swing.JButton();
        EditarDev = new javax.swing.JButton();
        EliminarDev = new javax.swing.JButton();
        IdDevoluciones = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        TablaDevoluciones = new javax.swing.JTable();
        cbTipoDev = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtBusDev = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnañadirservicio = new javax.swing.JButton();
        btneditarservicio = new javax.swing.JButton();
        btneliminarservicio = new javax.swing.JButton();
        txtlugarservicio = new javax.swing.JTextField();
        txttrabajadorservicio = new javax.swing.JTextField();
        txtFechaServ = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        TablaServicios = new javax.swing.JTable();
        txtidservicio = new javax.swing.JTextField();
        cbTipoServ = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtRucServ = new javax.swing.JTextField();
        txtMaterial = new javax.swing.JTextField();
        txtNuBol = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtBusSev = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

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
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });

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
        btnDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionesActionPerformed(evt);
            }
        });

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
                .addContainerGap(67, Short.MAX_VALUE))
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        labelProducto.setText("Producto");

        labelMarca.setText("Marca");

        labelPrecio.setText("Precio");

        labelCantidad.setText("Cantidad");

        btnAñadirAlm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAñadirAlm.setText("Añadir");
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
        btnEditarAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAlmActionPerformed(evt);
            }
        });

        btnEliminarAlm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEliminarAlm.setText("Eliminar");
        btnEliminarAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlmActionPerformed(evt);
            }
        });

        jLabel30.setText("Buscar por marca:");

        txtBusAlm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusAlmKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtProducto)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addGap(52, 52, 52)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMarca)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addGap(75, 75, 75)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPrecioAlm)
                                .addGap(27, 27, 27))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addGap(75, 75, 75)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addComponent(txtCantidadAlm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                        .addComponent(txtIdAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBusAlm, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addGap(314, 314, 314)
                                .addComponent(btnAñadirAlm, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarAlm, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarAlm, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2)
                .addGap(21, 21, 21))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAñadirAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarAlm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addGap(167, 167, 167))
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

        jLabel31.setText("Buscar por RUC");

        txtBusCl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusClKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBusCl)
                            .addComponent(labelNombreC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreC, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRucC, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(labelRucC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(151, 151, 151)
                                        .addComponent(txtIdCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(367, 367, 367)
                                .addComponent(btnAñadirCl, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarCl, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarCl, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addGap(52, 52, 52))))))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRucC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAñadirCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarCl)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addGap(191, 191, 191))
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

        jLabel32.setText("Buscar por apellido:");

        txtBusTrb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusTrbKeyTyped(evt);
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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbCargoT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(labelNombreT)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNombreT, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelCargoT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidoT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(labelApellidosT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtBusTrb))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDniT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDniT, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefonoT, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(labelTelefonoT))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtCorreoT, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                        .addGap(71, 71, 71))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(labelCorreoT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(btnAgregarT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42))))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                .addGap(22, 22, 22))
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCargoT)
                    .addComponent(jLabel32))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCargoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusTrb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarT)
                    .addComponent(btnEditarT)
                    .addComponent(btnEliminarT))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addGap(86, 86, 86)
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
        Tableuser.setEnabled(false);
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

        jLabel33.setText("Buscar por cargo:");

        txtBusUs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusUsKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtIduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBusUs, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuarioU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cdCargou, 0, 115, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtcontraseñau, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(390, 390, 390))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(357, 357, 357)
                                .addComponent(btnAgregarU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(49, 49, 49))))))
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
                    .addComponent(txtcontraseñau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarU)
                    .addComponent(btnEditarU)
                    .addComponent(btnEliminarU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(720, 720, 720))
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

        TableServCan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lugar", "Tipo de Servicio", "RUC" , "Fecha de Cancelacion","Trabajador"
            }
        ));
        TableServCan.setEnabled(false);
        TableServCan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableServCanMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TableServCan);
        TableServCan.getAccessibleContext().setAccessibleName("");

        btnañadirserv.setText("Añadir");
        btnañadirserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadirservActionPerformed(evt);
            }
        });

        jLabel34.setText("Buscar por lugar:");

        txtBusSerCan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusSerCanKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtBusSerCan)
                        .addComponent(txtlugar, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttiposervicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrucs, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfechacancelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(382, 382, 382))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnañadirserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditarserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminarserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(243, 243, 243))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txttrabajadors, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(txtid_serviciocancelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane8)
                .addGap(212, 212, 212))
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btneditarserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneliminarserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnañadirserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel34)
                        .addGap(4, 4, 4)
                        .addComponent(txtBusSerCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178)
                .addComponent(txtid_serviciocancelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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

        jLabel35.setText("Buscar por producto");

        txtBusProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusProvKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane7))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtproductop)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBusProv))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txtfechap, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtempresap, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(txtrucp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(431, 431, 431)
                                .addComponent(btnagregarp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btneditarp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btneliminarp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)))
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtproductop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtempresap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfechap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtrucp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btneditarp)
                            .addComponent(btneliminarp)
                            .addComponent(btnagregarp))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addGap(221, 221, 221))
        );

        jTabbedPane.addTab("Proveedores", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        txtNumFab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumFabActionPerformed(evt);
            }
        });

        jLabel17.setText("Numero de Tablero");

        jLabel18.setText("Producto");

        cbTamanio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grande", "Mediano", "Pequeño", " " }));

        jLabel20.setText("Cantidad");

        AñadirFab.setText("Añadir");
        AñadirFab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirFabActionPerformed(evt);
            }
        });

        EliminarFab.setText("Eliminar");
        EliminarFab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarFabActionPerformed(evt);
            }
        });

        EditarFab.setText("Editar");
        EditarFab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarFabActionPerformed(evt);
            }
        });

        TablaFbr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Numero de Tablero", "Producto", "Cantidad", "Fecha", "Tamaño", "Trabajador"
            }
        ));
        TablaFbr.setEnabled(false);
        TablaFbr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaFbrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaFbr);

        jLabel19.setText("Fecha");

        jLabel36.setText("Tamaño");

        jLabel37.setText("Trabajador");

        jLabel38.setText("Buscar por tamaño:");

        txtBusFab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusFabKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtBusFab, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(407, 407, 407)
                        .addComponent(AñadirFab, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditarFab, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EliminarFab, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(txtNumFab, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreFab, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantFab, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaFab, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTrabajadorFab, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1)
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrabajadorFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AñadirFab)
                    .addComponent(EditarFab)
                    .addComponent(EliminarFab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(235, 235, 235))
        );

        jTabbedPane.addTab("Fabricación", jPanel8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Empresa");

        jLabel22.setText("RUC");

        jLabel23.setText("Fecha");

        jLabel24.setText("Cantidad");

        jLabel25.setText("Producto");

        AñadirDev.setText("Añadir");
        AñadirDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirDevActionPerformed(evt);
            }
        });

        EditarDev.setText("Editar");
        EditarDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarDevActionPerformed(evt);
            }
        });

        EliminarDev.setText("Eliminar");
        EliminarDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarDevActionPerformed(evt);
            }
        });

        TablaDevoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "RUC", "Fecha" , "Cantidad", "Producto", "Tipo"
            }
        ));
        TablaDevoluciones.setEnabled(false);
        TablaDevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDevolucionesMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(TablaDevoluciones);

        cbTipoDev.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidades", "Mayor" }));

        jLabel26.setText("Tipo");

        jLabel39.setText("jLabel39");

        txtBusDev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusDevKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusDev, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AñadirDev, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditarDev, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EliminarDev)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreEm, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(txtRUCDev, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaDev, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(jLabel23))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantDev, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProductoDev, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jLabel25)))
                            .addComponent(IdDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoDev, 0, 72, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                        .addGap(31, 31, 31))))
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
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRUCDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductoDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AñadirDev, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditarDev)
                            .addComponent(EliminarDev)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(IdDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
        );

        txtNombreEm.getAccessibleContext().setAccessibleDescription("");
        txtProductoDev.getAccessibleContext().setAccessibleName("");

        jTabbedPane.addTab("Devoluciones", jPanel10);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("Lugar");

        jLabel15.setText("Fecha de Servicio");

        jLabel16.setText("Trabajador");

        jLabel21.setText("Tipo de servicio");

        btnañadirservicio.setText("Añadir");
        btnañadirservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadirservicioActionPerformed(evt);
            }
        });

        btneditarservicio.setText("Editar");
        btneditarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarservicioActionPerformed(evt);
            }
        });

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

        TablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lugar", "Tipo de Servicio", "Fecha" , "Trabajador", "RUC", "Número Boleta", "Material"
            }));
            TablaServicios.setEnabled(false);
            TablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    TablaServiciosMouseClicked(evt);
                }
            });
            jScrollPane9.setViewportView(TablaServicios);

            cbTipoServ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            jLabel27.setText("RUC");

            jLabel28.setText("Material");

            jLabel29.setText("Número de Boleta");

            jLabel40.setText("Buscar por trabajador:");

            txtBusSev.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtBusSevKeyTyped(evt);
                }
            });

            javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
            jPanel9.setLayout(jPanel9Layout);
            jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNuBol)
                        .addComponent(jLabel14)
                        .addComponent(txtlugarservicio, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addComponent(jLabel29))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMaterial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbTipoServ, javax.swing.GroupLayout.Alignment.LEADING, 0, 108, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(txttrabajadorservicio, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtBusSev)
                                .addComponent(jLabel40))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaServ, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRucServ, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(btnañadirservicio, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btneditarservicio, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btneliminarservicio, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))))
                    .addGap(60, 60, 60)
                    .addComponent(txtidservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jScrollPane9)
                    .addGap(17, 17, 17))
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
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(jLabel27))))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtlugarservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttrabajadorservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFechaServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbTipoServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRucServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addGap(5, 5, 5)
                                    .addComponent(txtNuBol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel28)
                                        .addComponent(jLabel40))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnañadirservicio)
                                            .addComponent(btneditarservicio)
                                            .addComponent(btneliminarservicio))
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBusSev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(27, 27, 27)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(txtidservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(179, Short.MAX_VALUE))
            );

            txttrabajadorservicio.getAccessibleContext().setAccessibleName("");

            jTabbedPane.addTab("Servicios", jPanel9);

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 849, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 864, Short.MAX_VALUE)
            );

            jTabbedPane.addTab("Venta", jPanel1);

            javax.swing.GroupLayout PanelServiciosLayout = new javax.swing.GroupLayout(PanelServicios);
            PanelServicios.setLayout(PanelServiciosLayout);
            PanelServiciosLayout.setHorizontalGroup(
                PanelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelServiciosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 851, Short.MAX_VALUE)
                    .addContainerGap())
            );
            PanelServiciosLayout.setVerticalGroup(
                PanelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelServiciosLayout.createSequentialGroup()
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 890, Short.MAX_VALUE)
                    .addGap(30, 30, 30))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(PanelServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 917, Short.MAX_VALUE))
                .addComponent(PanelServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents
    // Métodos para el módulo Almacen 
    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarAlmacen(); //Llama al método Listar Clientes para mostrarlo en la tabla Almacen
        jTabbedPane.setSelectedIndex(0); // Cambia a la pestaña "Almacenamiento" (index 1)
        btnAlmacen.setFocusable(false); 
    }//GEN-LAST:event_btnAlmacenActionPerformed

    //Métodos para el módulo Clientes
    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarCliente(); //Llama al método Listar Clientes para mostrarlo en la tabla Almacen
        jTabbedPane.setSelectedIndex(1); // Cambia a la pestaña "Cliente" (index 2)
        btnAlmacen.setFocusable(false); 
    }//GEN-LAST:event_btnClientesActionPerformed

    //Método para el módulo Trabajadores
    private void btnTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajadoresActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarTrabajador(); //Llama al método Listar Clientes para mostrarlo en la tabla Almacen
        jTabbedPane.setSelectedIndex(2); // Cambia a la pestaña "Trabajadores" (index 3)
        btnTrabajadores.setFocusable(false); 
    }//GEN-LAST:event_btnTrabajadoresActionPerformed

    //Método para el módulo Usuarios
    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarUsuario(); //Llama al método Listar usuario para mostrarlo en la tabla usuario
        jTabbedPane.setSelectedIndex(3); // Cambia a la pestaña "Usuario" (index 4)
        btnUsuarios.setFocusable(false); 
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarProveedores();
        jTabbedPane.setSelectedIndex(5); // Cambia a la pestaña "Proveedores"
        btnProveedores.setFocusable(false);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnServCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServCanActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarServiciocancelado();
        jTabbedPane.setSelectedIndex(4); // Cambia a la pestaña "Serviciocancelado"
        btnServCan.setFocusable(false);
    }//GEN-LAST:event_btnServCanActionPerformed
    //Métodos para el módulo de Fabricación
    private void btnFabricacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFabricacionActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarFabricacion();
        jTabbedPane.setSelectedIndex(6); // Cambia a la pestaña "Fabricación"
        btnFabricacion.setFocusable(false);
    }//GEN-LAST:event_btnFabricacionActionPerformed

    
    private void btnDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionesActionPerformed
        LimpiarTabla(); //Limpia la tabla para que no se repitan los datos
        ListarDevolucion(); //Llama al método Listar Clientes para mostrarlo en la tabla Almacen
        jTabbedPane.setSelectedIndex(7); // Cambia a la pestaña "Trabajadores" (index 3)
        btnTrabajadores.setFocusable(false);
    }//GEN-LAST:event_btnDevolucionesActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
        LimpiarTabla();
        ListarServicios();
        jTabbedPane.setSelectedIndex(8);
        btnServicios.setFocusable(false);
    }//GEN-LAST:event_btnServiciosActionPerformed

    private void TablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaServiciosMouseClicked
        //Llamar los valores de la Tabla a los jFields
        int fila = TablaServicios.rowAtPoint(evt.getPoint());
        txtidservicio.setText(TablaServicios.getValueAt(fila,0).toString());
        txtlugarservicio.setText(TablaServicios.getValueAt(fila, 1).toString());
        cbTipoServ.setSelectedItem(TablaServicios.getValueAt(fila, 2).toString());
        txtFechaServ.setText(TablaServicios.getValueAt(fila, 3).toString());
        txttrabajadorservicio.setText(TablaServicios.getValueAt(fila, 4).toString());
        txtRucServ.setText(TablaServicios.getValueAt(fila,5).toString());
        txtNuBol.setText(TablaServicios.getValueAt(fila,6).toString());
        txtMaterial.setText(TablaServicios.getValueAt(fila,7).toString());
    }//GEN-LAST:event_TablaServiciosMouseClicked

    private void txtlugarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugarservicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugarservicioActionPerformed

    private void btneliminarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarservicioActionPerformed
        if(!"".equals(txtidservicio.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar al Servicio?");
            if (confirmacion == 0){
                int id = Integer.parseInt(txtidservicio.getText());
                serviciosD.eliminarServicio(id);
                LimpiarTabla();
                LimpiarFieldservicios();
                ListarServicios();
            }
        }
    }//GEN-LAST:event_btneliminarservicioActionPerformed

    private void btneditarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarservicioActionPerformed
        if("".equals(txtidservicio.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtlugarservicio.getText())|| !"".equals(cbTipoServ.getSelectedItem()) || !"".equals(txttrabajadorservicio.getText()) || !"".equals(txtFechaServ.getText()) || !"".equals(txtRucServ.getText()) || !"".equals(txtNuBol.getText()) || !"".equals(txtMaterial.getText())){
                servicios.setLugar(txtlugarservicio.getText());
                servicios.setTipoServicio((String)cbTipoServ.getSelectedItem());
                servicios.setTrabajador(txttrabajadorservicio.getText());
                servicios.setFechaInicio(txtFechaServ.getText());
                servicios.setRucSer(txtRucServ.getText());
                servicios.setNuBole(txtNuBol.getText());
                servicios.setMaterial(txtMaterial.getText());
                servicios.setIdServicio(Integer.parseInt(txtidservicio.getText()));
                serviciosD.EditarServicio(servicios);
                LimpiarTabla();
                LimpiarFieldservicios();
                ListarServicios();
            }
        }
    }//GEN-LAST:event_btneditarservicioActionPerformed

    private void btnañadirservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnañadirservicioActionPerformed
        if(!"".equals(txtlugarservicio.getText()) || !"".equals(cbTipoServ.getSelectedItem()) || !"".equals(txttrabajadorservicio.getText()) || !"".equals(txtFechaServ.getText())){
            servicios.setLugar(txtlugarservicio.getText());
            servicios.setTipoServicio((String)cbTipoServ.getSelectedItem());
            servicios.setTrabajador(txttrabajadorservicio.getText());
            servicios.setFechaInicio(txtFechaServ.getText());
            servicios.setRucSer(txtRucServ.getText());
            servicios.setNuBole(txtNuBol.getText());
            servicios.setMaterial(txtMaterial.getText());

            serviciosD.agregarServicio(servicios);
            LimpiarTabla();
            LimpiarFieldservicios();
            ListarServicios();
            JOptionPane.showMessageDialog(null, "Servicio registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_btnañadirservicioActionPerformed

    private void TablaDevolucionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDevolucionesMouseClicked
        int fila = TablaDevoluciones.rowAtPoint(evt.getPoint());
        IdDevoluciones.setText(TablaDevoluciones.getValueAt(fila,0).toString());
        txtNombreEm.setText(TablaDevoluciones.getValueAt(fila, 1).toString());
        txtRUCDev.setText(TablaDevoluciones.getValueAt(fila, 2).toString());
        txtFechaDev.setText(TablaDevoluciones.getValueAt(fila, 3).toString());
        txtCantDev.setText(TablaDevoluciones.getValueAt(fila, 4).toString());
        txtProductoDev.setText(TablaDevoluciones.getValueAt(fila,5).toString());
    }//GEN-LAST:event_TablaDevolucionesMouseClicked

    private void EliminarDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarDevActionPerformed
        if(!"".equals(IdDevoluciones.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar la Devolucion?");
            if (confirmacion == 0){
                int id = Integer.parseInt(IdDevoluciones.getText());
                devD.eliminarDevolucion(id);
                LimpiarTabla();
                LimpiarFielddev();
                ListarDevolucion();
            }
        }
    }//GEN-LAST:event_EliminarDevActionPerformed

    private void EditarDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarDevActionPerformed
        if("".equals(IdDevoluciones.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtNombreEm.getText())|| !"".equals(txtRUCDev.getText()) || !"".equals(txtFechaDev.getText()) || !"".equals(txtCantDev.getText()) || !"".equals(txtProductoDev.getText()) || !"".equals(cbTipoDev.getSelectedItem())){
                dev.setNombre(txtNombreEm.getText());
                dev.setDatos(txtRUCDev.getText());
                dev.setFecha(txtFechaDev.getText());
                dev.setCantidad(txtCantDev.getText());
                dev.setProducto(txtProductoDev.getText());
                dev.setTip_cantidad((String)cbTipoDev.getSelectedItem());
                devD.editarDevolucion(dev);
                LimpiarTabla();
                LimpiarFielddev();
                ListarDevolucion();
            }
        }
    }//GEN-LAST:event_EditarDevActionPerformed

    private void AñadirDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirDevActionPerformed
        if(!"".equals(txtNombreEm.getText()) || !"".equals(txtRUCDev.getText()) || !"".equals(txtFechaDev.getText()) || !"".equals(txtCantDev.getText()) || !"".equals(txtProductoDev.getText()) || !"".equals(cbTipoDev.getSelectedItem())){
            dev.setNombre(txtNombreEm.getText());
            dev.setDatos(txtRUCDev.getText());
            dev.setFecha(txtFechaDev.getText());
            dev.setCantidad(txtCantDev.getText());
            dev.setProducto(txtProductoDev.getText());
            dev.setTip_cantidad((String)cbTipoDev.getSelectedItem());
            devD.agregarDevolucion(dev);
            LimpiarTabla();
            LimpiarFielddev();
            ListarDevolucion();
            JOptionPane.showMessageDialog(null, "Servicio registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_AñadirDevActionPerformed

    private void EditarFabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarFabActionPerformed
        if("".equals(txtIdFab.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtNumFab.getText())|| !"".equals(txtNombreFab.getText()) || !"".equals(txtCantFab.getText()) || !"".equals(txtFechaFab.getText()) || !"".equals(cbTamanio.getSelectedItem()) || !"".equals(txtTrabajadorFab.getText())){
                fbr.setNumero_tablero(txtNumFab.getText());
                fbr.setNombre_producto(txtNombreFab.getText());
                fbr.setCantidad(Integer.parseInt(txtCantFab.getText()));
                fbr.setFecha_fabricacion(txtFechaFab.getText());
                fbr.setTamanio((String)cbTamanio.getSelectedItem());
                fbr.setTrabajador_fabricacion(txtTrabajadorFab.getText());
                fbr.setId_fabricacion(Integer.parseInt(txtIdFab.getText()));
                fbrD.EditarFabricacion(fbr);
                LimpiarTabla();
                LimpiarFieldFab();
                ListarFabricacion();
            }
        }
    }//GEN-LAST:event_EditarFabActionPerformed

    private void AñadirFabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirFabActionPerformed
        if (!"".equals(txtNumFab.getText()) || !"".equals(txtNombreFab.getText()) || !"".equals(txtCantFab.getText())){
            fbr.setNumero_tablero(txtNumFab.getText());
            fbr.setNombre_producto(txtNombreFab.getText());
            fbr.setCantidad(Integer.parseInt(txtCantFab.getText()));
            fbr.setFecha_fabricacion(txtFechaFab.getText());
            fbr.setTamanio((String)cbTamanio.getSelectedItem());
            fbr.setTrabajador_fabricacion(txtTrabajadorFab.getText());
            fbrD.AgregarFabricacion(fbr);
            LimpiarTabla();
            LimpiarFieldFab();
            ListarFabricacion();
            JOptionPane.showMessageDialog(null, "Fabricación registrada");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos está vacios");
        }
    }//GEN-LAST:event_AñadirFabActionPerformed

    private void txtNumFabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumFabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumFabActionPerformed

    private void txtBusProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusProvKeyTyped
        txtBusProv.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusProv.getText(), 1));
            }
        });
        trs = new TableRowSorter(model);
        TableProveedores.setRowSorter(trs);
    }//GEN-LAST:event_txtBusProvKeyTyped

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

    private void txtBusSerCanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusSerCanKeyTyped
        txtBusSerCan.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusSerCan.getText(),1));
            }
        });
        trs = new TableRowSorter(model);
        TableServCan.setRowSorter(trs);
    }//GEN-LAST:event_txtBusSerCanKeyTyped

    //METODOS PARA SERVICIOSCANCELADOS 
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

    private void TableServCanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableServCanMouseClicked
        //Llamar los valores de la Tabla a los jFields
        int fila = TableServCan.rowAtPoint(evt.getPoint());
        txtid_serviciocancelado.setText(TableServCan.getValueAt(fila,0).toString());
        txtlugar.setText(TableServCan.getValueAt(fila, 1).toString());
        txttiposervicio.setText(TableServCan.getValueAt(fila, 2).toString());
        txtrucs.setText(TableServCan.getValueAt(fila, 3).toString());
        txtfechacancelacion.setText(TableServCan.getValueAt(fila, 4).toString());
        txttrabajadors.setText(TableServCan.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableServCanMouseClicked

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

    private void txtfechacancelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechacancelacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechacancelacionActionPerformed

    private void txtrucsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrucsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrucsActionPerformed

    private void txttiposervicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttiposervicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttiposervicioActionPerformed

    private void txtlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugarActionPerformed

    private void txtBusUsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusUsKeyTyped
        txtBusUs.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusUs.getText(),2));
            }
        });
        trs = new TableRowSorter(model);
        Tableuser.setRowSorter(trs);
    }//GEN-LAST:event_txtBusUsKeyTyped

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

    private void txtBusTrbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusTrbKeyTyped
        txtBusTrb.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusTrb.getText(),3));
            }
        });
        trs = new TableRowSorter(model);
        TableTrb.setRowSorter(trs);
    }//GEN-LAST:event_txtBusTrbKeyTyped

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

    private void txtApellidoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoTActionPerformed

    private void cbCargoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoTActionPerformed

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

    private void txtBusClKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusClKeyTyped
        txtBusCl.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusCl.getText(),2));
            }
        });
        trs = new TableRowSorter(model);
        TableCl.setRowSorter(trs);
    }//GEN-LAST:event_txtBusClKeyTyped

    private void TableClMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClMouseClicked
        //Llamar los valores de la Tabla a los jFields de la Tabla de Clientes
        int fila = TableCl.rowAtPoint(evt.getPoint());
        txtIdCl.setText(TableCl.getValueAt(fila,0).toString());
        txtNombreC.setText(TableCl.getValueAt(fila, 1).toString());
        txtDireccionC.setText(TableCl.getValueAt(fila, 2).toString());
        txtRucC.setText(TableCl.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TableClMouseClicked

    private void txtNombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCActionPerformed

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

    private void txtBusAlmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusAlmKeyTyped
        txtBusAlm.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusAlm.getText(), 2));
            }
        });
        trs = new TableRowSorter(model);
        TableAlm.setRowSorter(trs);
    }//GEN-LAST:event_txtBusAlmKeyTyped

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

    private void TableAlmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAlmMouseClicked
        //Llamar los valores de la Tabla a los jFields
        int fila = TableAlm.rowAtPoint(evt.getPoint());
        txtIdAlm.setText(TableAlm.getValueAt(fila,0).toString());
        txtProducto.setText(TableAlm.getValueAt(fila, 1).toString());
        txtMarca.setText(TableAlm.getValueAt(fila, 2).toString());
        txtPrecioAlm.setText(TableAlm.getValueAt(fila, 3).toString());
        txtCantidadAlm.setText(TableAlm.getValueAt(fila,4).toString());
    }//GEN-LAST:event_TableAlmMouseClicked

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

    private void EliminarFabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarFabActionPerformed
        if(!"".equals(txtIdFab.getText())){
            int confirmacion = JOptionPane.showConfirmDialog(null,"¿Estás seguro de querer eliminar la Devolucion?");
            if (confirmacion == 0){
                int id = Integer.parseInt(txtIdFab.getText());
                fbrD.EliminarFabricacion(id);
                LimpiarTabla();
                LimpiarFieldFab();
                ListarFabricacion();
            }
        }
    }//GEN-LAST:event_EliminarFabActionPerformed

    private void TablaFbrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaFbrMouseClicked
        int fila = TablaFbr.rowAtPoint(evt.getPoint());
        txtIdFab.setText(TablaFbr.getValueAt(fila,0).toString());
        txtNumFab.setText(TablaFbr.getValueAt(fila,1).toString());
        txtNombreFab.setText(TablaFbr.getValueAt(fila, 2).toString());
        txtCantFab.setText(TablaFbr.getValueAt(fila, 3).toString());
        txtFechaFab.setText(TablaFbr.getValueAt(fila, 4).toString());
        cbTamanio.setSelectedItem(TablaFbr.getValueAt(fila,5));
        txtTrabajadorFab.setText(TablaFbr.getValueAt(fila, 6).toString());

    }//GEN-LAST:event_TablaFbrMouseClicked

    private void txtBusFabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusFabKeyTyped
        txtBusFab.addKeyListener(new KeyAdapter(){
        @Override
        public void keyReleased(KeyEvent ke){
            trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusFab.getText(), 6));
        }
        }); 
        trs = new TableRowSorter(model);
        TablaFbr.setRowSorter(trs);
    }//GEN-LAST:event_txtBusFabKeyTyped

    private void txtBusDevKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusDevKeyTyped
        txtBusDev.addKeyListener(new KeyAdapter(){
        @Override
        public void keyReleased(KeyEvent ke){
            trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusDev.getText(), 6));
        }
        }); 
        trs = new TableRowSorter(model);
        TablaDevoluciones.setRowSorter(trs);
    }//GEN-LAST:event_txtBusDevKeyTyped

    private void txtBusSevKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusSevKeyTyped
        txtBusSev.addKeyListener(new KeyAdapter(){
        @Override
        public void keyReleased(KeyEvent ke){
            trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusSev.getText(), 4));
        }
        }); 
        trs = new TableRowSorter(model);
        TablaServicios.setRowSorter(trs);
    }//GEN-LAST:event_txtBusSevKeyTyped

   
    public static void main(String args[]) {
      
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñadirDev;
    private javax.swing.JButton AñadirFab;
    private javax.swing.JButton EditarDev;
    private javax.swing.JButton EditarFab;
    private javax.swing.JButton EliminarDev;
    private javax.swing.JButton EliminarFab;
    private javax.swing.JTextField IdDevoluciones;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelServicios;
    private javax.swing.JTable TablaDevoluciones;
    private javax.swing.JTable TablaFbr;
    private javax.swing.JTable TablaServicios;
    private javax.swing.JTable TableAlm;
    private javax.swing.JTable TableCl;
    private javax.swing.JTable TableProveedores;
    private javax.swing.JTable TableServCan;
    private javax.swing.JTable TableTrb;
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
    private javax.swing.JComboBox<String> cbCargoT;
    private javax.swing.JComboBox<String> cbTamanio;
    private javax.swing.JComboBox<String> cbTipoDev;
    private javax.swing.JComboBox<String> cbTipoServ;
    private javax.swing.JComboBox<String> cdCargou;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
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
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel labelApellidosT;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCargoT;
    private javax.swing.JLabel labelCorreoT;
    private javax.swing.JLabel labelDireccionC;
    private javax.swing.JLabel labelDniT;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelNombreC;
    private javax.swing.JLabel labelNombreT;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelProducto;
    private javax.swing.JLabel labelRucC;
    private javax.swing.JLabel labelTelefonoT;
    private javax.swing.JLabel labelUTI;
    private javax.swing.JTextField txtApellidoT;
    private javax.swing.JTextField txtBusAlm;
    private javax.swing.JTextField txtBusCl;
    private javax.swing.JTextField txtBusDev;
    private javax.swing.JTextField txtBusFab;
    private javax.swing.JTextField txtBusProv;
    private javax.swing.JTextField txtBusSerCan;
    private javax.swing.JTextField txtBusSev;
    private javax.swing.JTextField txtBusTrb;
    private javax.swing.JTextField txtBusUs;
    private javax.swing.JTextField txtCantDev;
    private javax.swing.JTextField txtCantFab;
    private javax.swing.JTextField txtCantidadAlm;
    private javax.swing.JTextField txtCorreoT;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtDniT;
    private javax.swing.JTextField txtFechaDev;
    private javax.swing.JTextField txtFechaFab;
    private javax.swing.JTextField txtFechaServ;
    private javax.swing.JTextField txtIdAlm;
    private javax.swing.JTextField txtIdCl;
    private javax.swing.JTextField txtIdFab;
    private javax.swing.JTextField txtIdTrb;
    private javax.swing.JTextField txtIduser;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombreEm;
    private javax.swing.JTextField txtNombreFab;
    private javax.swing.JTextField txtNombreT;
    private javax.swing.JTextField txtNuBol;
    private javax.swing.JTextField txtNumFab;
    private javax.swing.JTextField txtPrecioAlm;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtProductoDev;
    private javax.swing.JTextField txtRUCDev;
    private javax.swing.JTextField txtRucC;
    private javax.swing.JTextField txtRucServ;
    private javax.swing.JTextField txtTelefonoT;
    private javax.swing.JTextField txtTrabajadorFab;
    private javax.swing.JTextField txtUsuarioU;
    private javax.swing.JTextField txtcontraseñau;
    private javax.swing.JTextField txtempresap;
    private javax.swing.JTextField txtfechacancelacion;
    private javax.swing.JTextField txtfechap;
    private javax.swing.JTextField txtid_serviciocancelado;
    private javax.swing.JTextField txtidproveedor;
    private javax.swing.JTextField txtidservicio;
    private javax.swing.JTextField txtlugar;
    private javax.swing.JTextField txtlugarservicio;
    private javax.swing.JTextField txtproductop;
    private javax.swing.JTextField txtrucp;
    private javax.swing.JTextField txtrucs;
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
        if (cbCargoT.getItemCount() > 0) {
        cbCargoT.setSelectedIndex(0);
        }
    }
    private void LimpiarFieldUser(){
        txtIduser.setText("");
        txtUsuarioU.setText("");
        txtcontraseñau.setText("");
        if (cdCargou.getItemCount() > 0) {
        cdCargou.setSelectedIndex(0);
        }
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
    
   private void LimpiarFieldservicios(){
        txtidservicio.setText("");
        txtlugarservicio.setText("");
        txttrabajadorservicio.setText("");
        txtFechaServ.setText("");
        txtRucServ.setText("");
        txtNuBol.setText("");
        txtMaterial.setText("");
        if (cbTipoServ.getItemCount() > 0) {
        cbTipoServ.setSelectedIndex(0);
    }
    }
   
   private void LimpiarFieldFab(){
        txtIdFab.setText(""); 
        txtNumFab.setText("");
        txtNombreFab.setText("");
        txtCantFab.setText("");
        txtFechaFab.setText("");
        txtTrabajadorFab.setText("");
        if (cbTamanio.getItemCount() > 0) {
        cbTamanio.setSelectedIndex(0);
    }
   }
   
   private void LimpiarFielddev(){
        IdDevoluciones.setText("");
        txtNombreEm.setText("");
        txtRUCDev.setText("");
        txtFechaDev.setText("");
        txtCantDev.setText("");
        txtProductoDev.setText("");
        if (cbTipoDev.getItemCount() > 0) {
        cbTipoDev.setSelectedIndex(0);
    }
    }
   
   
}

