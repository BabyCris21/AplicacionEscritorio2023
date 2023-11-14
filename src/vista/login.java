package vista;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import modelo.LoginDAO;
public class login extends javax.swing.JFrame {
    modelo.Login lg = new modelo.Login();
    LoginDAO login = new LoginDAO(); 
    public login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void validar(){
        String usuario = txtUsuario.getText();
        String pass = String.valueOf(txtPass.getPassword());
        if(!"".equals(usuario) ||  !"".equals(pass)){
            
            lg = login.log(usuario, pass);
            if(lg.getUsuario()!= null && lg.getPass()!= null){
                principal sis = new principal();
                sis.setVisible(true);
                dispose();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta ");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLeft = new javax.swing.JPanel();
        labelUTI = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelBottom = new javax.swing.JLabel();
        jPanelRight = new javax.swing.JPanel();
        jLabelSesion = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelLeft.setBackground(new java.awt.Color(5, 59, 80));
        jPanelLeft.setMinimumSize(new java.awt.Dimension(257, 269));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(414, 330));
        jPanelLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUTI.setFont(new java.awt.Font("Dialog", 1, 52)); // NOI18N
        labelUTI.setForeground(new java.awt.Color(238, 238, 238));
        labelUTI.setText("UTI");
        jPanelLeft.add(labelUTI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jPanelLeft.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, 89));

        jSeparator1.setBackground(new java.awt.Color(238, 238, 238));
        jPanelLeft.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 115, 10));

        jLabelBottom.setForeground(new java.awt.Color(238, 238, 238));
        jLabelBottom.setText("Técnicos e Ingenieros");
        jPanelLeft.add(jLabelBottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        jPanelRight.setBackground(new java.awt.Color(255, 255, 255));

        jLabelSesion.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelSesion.setForeground(new java.awt.Color(5, 59, 80));
        jLabelSesion.setText("Inicio de Sesión");

        jLabelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N

        jLabelPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/password.png"))); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtUsuario.setBorder(null);

        btnIniciar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.setBorder(null);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        txtPass.setBorder(null);

        javax.swing.GroupLayout jPanelRightLayout = new javax.swing.GroupLayout(jPanelRight);
        jPanelRight.setLayout(jPanelRightLayout);
        jPanelRightLayout.setHorizontalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabelSesion))
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jSeparator3)
                .addGap(110, 110, 110))
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jSeparator2)
                .addGap(110, 110, 110))
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addGap(238, 238, 238))
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario))
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addComponent(jLabelPass, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPass)))
                .addGap(86, 86, 86))
        );
        jPanelRightLayout.setVerticalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(62, 62, 62)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsuario)
                    .addComponent(txtUsuario))
                .addGap(8, 8, 8)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGap(145, 145, 145))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(428, 428, 428)
                .addComponent(jPanelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // Crea una instancia de la clase principal
        validar();         
    }//GEN-LAST:event_btnIniciarActionPerformed
    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabelBottom;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelSesion;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelUTI;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
