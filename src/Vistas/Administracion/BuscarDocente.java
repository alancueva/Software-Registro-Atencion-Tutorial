package Vistas.Administracion;
import Controladores.ControladorDocentes;
import javax.swing.table.DefaultTableModel;

public class BuscarDocente extends javax.swing.JDialog {

    private final DefaultTableModel tdatos1 = new DefaultTableModel();
    private final ControladorDocentes cdoc = new ControladorDocentes();
    private final AsignarTutoria at = new AsignarTutoria();
    private String nombre;
    private String codigo;
    private String programa;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
//    private final Administrador a = new Administrador();

    public BuscarDocente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Buscar Docente");
        setSize(840, 355);
        setLocationRelativeTo(null);
//        setDefaultCloseOperation(BuscarDocente.EXIT_ON_CLOSE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);

        String Titulos[] = {"codigo", "nombre", "Apellido","Programa"};
        tdatos1.setColumnIdentifiers(Titulos);
        tbl_datos.setModel(tdatos1);

        tbl_datos.setDefaultEditor(Object.class, null);
        // Deshabilitar el arrastre de columnas
        tbl_datos.getTableHeader().setReorderingAllowed(false);
        // Permitir la selección de filas
        tbl_datos.setRowSelectionAllowed(true);
        tbl_datos.setColumnSelectionAllowed(false);

    }

    private void limpiartabla1() {
        int x = tdatos1.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos1.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new com.icm.components.metro.TableMetroICM();
        txt_busqueda = new app.bolivia.swing.JCTextField();
        btn_buscar = new rojeru_san.complementos.RSButtonHover();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_datos.setBackground(new java.awt.Color(0, 0, 0));
        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_datos.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tbl_datos.setGridColor(new java.awt.Color(102, 102, 102));
        tbl_datos.setSelectionBackground(new java.awt.Color(0, 102, 204));
        tbl_datos.setShowGrid(true);
        tbl_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_datos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 790, 190));
        jPanel1.add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 320, 40));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-búsqueda-30.png"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 60, -1));

        jLabel11.setText("Busqueda Docente");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String bus = txt_busqueda.getText();
        if (bus.trim().isEmpty()) {
            limpiartabla1();
            cdoc.mostrarVentanaDocente(tdatos1);
        } else {
            limpiartabla1();
            cdoc.BucarVentanaDocente(tdatos1, bus);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tbl_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_datosMouseClicked
//        Administrador a = new Administrador();
        int pos = tbl_datos.getSelectedRow();
//        String codigo = (String) tbl_datos.getValueAt(pos, 0);
//        String nom = (String) tbl_datos.getValueAt(pos, 1) + " "+ tbl_datos.getValueAt(pos, 2);
//        String programa = (String) tbl_datos.getValueAt(pos, 3);
        
        codigo = (String) tbl_datos.getValueAt(pos, 0);
        nombre = (String) tbl_datos.getValueAt(pos, 1) + " "+ tbl_datos.getValueAt(pos, 2);
        programa = (String) tbl_datos.getValueAt(pos, 3);
       
//        a.setValores(codigo, nombre, programa);
//        System.out.println("Jdialog: "+ codigo+" " +nom+" "+ programa);
        
        this.dispose();
    }//GEN-LAST:event_tbl_datosMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            BuscarDocente dialog = new BuscarDocente(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_buscar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.icm.components.metro.TableMetroICM tbl_datos;
    private app.bolivia.swing.JCTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
