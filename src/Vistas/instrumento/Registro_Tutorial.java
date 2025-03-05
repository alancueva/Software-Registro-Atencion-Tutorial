package Vistas.instrumento;

import Controladores.Area;
import Controladores.Atencion;
import Controladores.Ficha;
import Controladores.GuardarAlumno;
import Controladores.Motivo;
import Controladores.ProgramaDeEstudio;
import Controladores.Tiempo;
import Modelo.inicio_sesion;
import Vistas.Pruebas.BuscarAlumnos;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan Cueva
 */
public class Registro_Tutorial extends javax.swing.JPanel {

    private final DefaultTableModel tdatos1 = new DefaultTableModel();
    private final DefaultComboBoxModel combo4 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo5 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo6 = new DefaultComboBoxModel();
    DefaultListModel listModel3 = new DefaultListModel();
    private final ProgramaDeEstudio pro = new ProgramaDeEstudio();
    private final Area ar = new Area();
    private final Motivo mo = new Motivo();
    private final Tiempo fecha = new Tiempo();
    private final Ficha fi = new Ficha();
    Atencion ate;
    private final GuardarAlumno alum = new GuardarAlumno();
    private String nombreApellido;
    private int codigo;
    JPopupMenu popupMenu = new JPopupMenu();
    JSeparator separar = new JSeparator();
    // Crear los ítems del menú
    JMenuItem opciones = new JMenuItem("Opciones");
    JMenuItem copiarItem = new JMenuItem("Copiar");
    JMenuItem cortarItem = new JMenuItem("Cortar");
    JMenuItem pegarItem = new JMenuItem("Pegar");
    //
    JMenuItem Vistaprevia = new JMenuItem("Vista Previa");
    JMenuItem vista = new JMenuItem("Mostar Selección");

    private final ImageIcon iconoalumno = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/tab_client_icon-icons.png")));
    private final ImageIcon iconofecha = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/icons8-fecha-48.png")));
    private final ImageIcon iconolista = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/icons8-lista-corta-30.png")));

    public Registro_Tutorial() {
        initComponents();
        ate = new Atencion();
        lstalumnos.setModel(listModel3);
//        lstalumnos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        txtobs.setEditable(false);
        txtobs.setEnabled(false);
        cbomotivo.setModel(combo5);
        ar.area(combo4);
        cboarea.setModel(combo4);
        cboatencion.setModel(combo6);
        ate.atencion(combo6);
        cbomotivo.setEnabled(false);
        txtfecha.getDateEditor().addPropertyChangeListener("date", (PropertyChangeEvent e) -> {
            Date selectedDate = txtfecha.getDate();
            Date currentDate = new Date();
            if (selectedDate != null && selectedDate.after(currentDate)) {
                txtfecha.setBackground(Color.RED);
                txtfecha.setForeground(java.awt.Color.RED);
                lblfechaposterior.setText("No se permite fecha posterior");
                lblfechaposterior.setForeground(java.awt.Color.RED);
            } else {
                txtfecha.setForeground(java.awt.Color.BLACK);
                txtfecha.setBackground(Color.WHITE);
                lblfechaposterior.setText("");
            }
        });

        //tabla de registro
        String Titulos[] = {"Nombre", "ID", "Área", "Motivo", "OBS", "Fecha", "ID", "Atención", "ID", "P.E.", "Turno", "Semestre", "Tutor", "ID"};
        tdatos1.setColumnIdentifiers(Titulos);
        tbldato.setModel(tdatos1);
        tbldato.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbldato.getColumnModel().getColumn(1).setPreferredWidth(5);
        tbldato.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbldato.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbldato.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbldato.getColumnModel().getColumn(5).setPreferredWidth(20);
        tbldato.getColumnModel().getColumn(6).setPreferredWidth(5);
        tbldato.getColumnModel().getColumn(7).setPreferredWidth(20);
        tbldato.getColumnModel().getColumn(8).setPreferredWidth(5);
        tbldato.getColumnModel().getColumn(9).setPreferredWidth(80);
        tbldato.getColumnModel().getColumn(10).setPreferredWidth(30);
        tbldato.getColumnModel().getColumn(11).setPreferredWidth(30);
        tbldato.getColumnModel().getColumn(12).setPreferredWidth(50);
        tbldato.getColumnModel().getColumn(13).setPreferredWidth(50);
        tbldato.setDefaultEditor(Object.class, null);
        // Deshabilitar el arrastre de columnas
        tbldato.getTableHeader().setReorderingAllowed(false);
        // Permitir la selección de filas
        tbldato.setRowSelectionAllowed(true);
        tbldato.setColumnSelectionAllowed(false);

        mostrar();
        updateCharacterCount(txtobs.getText().length());
        /////////////////////////////////////////////////////////////////
        opciones.setEnabled(false);
        separar.setEnabled(false);
        // Añadir los ítems al menú
        popupMenu.add(opciones);
        popupMenu.add(separar);
        popupMenu.add(copiarItem);
        popupMenu.add(cortarItem);
        popupMenu.add(pegarItem);

        copiarItem.addActionListener((ActionEvent e) -> {
            txtobs.copy();
        });

        cortarItem.addActionListener((ActionEvent e) -> {
            txtobs.cut();
        });

        pegarItem.addActionListener((ActionEvent e) -> {
            txtobs.paste();
        });
    }

    /* Metodos Publicos
    * Reciben desde el inicio de sesion que recoge 
    * desde la base de datos para mostrar informacion de los docente
     */
    public void MostrarNomApe(String nombre, String apellido) {
        String tutor = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; text-align: center; }"
                + "p { font-size: 14px; color: #000;}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<p>" + nombre + "</p>"
                + "<p>" + apellido + "</p>"
                + "</body>"
                + "</html>";
//        lbltutor.setText(tutor);
        nombreApellido = nombre + " " + apellido;
    }

    /**
     * **** Metodos Private ******
     */
    private void mostrar() {
        txt_programa.setText(inicio_sesion.programa);
        txt_turnos.setText(inicio_sesion.turno);
        txt_ciclo.setText(inicio_sesion.ciclo);
        codigo = Integer.parseInt(inicio_sesion.idusuario);
        nombreApellido = inicio_sesion.nombre + " " + inicio_sesion.apellido;
    }

    private void limpiartabla1() {
        int x = tdatos1.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos1.removeRow(0);
        }
    }

    private void Clear_Table1() {
        for (int i = 0; i < tbldato.getRowCount(); i++) {
            tdatos1.removeRow(i);
            i -= 1;
        }
    }

    private void selectAllItems(boolean selected) {
        if (selected) {
            if (listModel3 != null && !listModel3.isEmpty()) {
                lstalumnos.setSelectionInterval(0, listModel3.getSize() - 1);
            } else {
                System.out.println("La lista de alumnos está vacía o no está inicializada.");
            }
        } else {
            lstalumnos.clearSelection();
        }
    }

    /*
    * Capturamos el contenido de la tabla en nuestro modelo con el metodo Llenar()
     */
    private void llenar(Modelo.Instrumento i, int fila) {
        i.setNom(tbldato.getValueAt(fila, 0).toString());
        i.setIdarea(tbldato.getValueAt(fila, 1).toString());
        i.setArea(tbldato.getValueAt(fila, 2).toString());
        i.setMotivo(tbldato.getValueAt(fila, 3).toString());
        i.setOsb(tbldato.getValueAt(fila, 4).toString());
        i.setFecha(tbldato.getValueAt(fila, 5).toString());
        i.setIdAtencion(tbldato.getValueAt(fila, 6).toString());
        i.setAtencion(tbldato.getValueAt(fila, 7).toString());
        i.setIdpe(tbldato.getValueAt(fila, 8).toString());
        i.setPe(tbldato.getValueAt(fila, 9).toString());
        i.setTurno(tbldato.getValueAt(fila, 10).toString());
        i.setCiclo(tbldato.getValueAt(fila, 11).toString());
        i.setTutor(tbldato.getValueAt(fila, 12).toString());
        String valorCelda = (String) tbldato.getValueAt(fila, 13);
        i.setIdusu(Integer.parseInt((String) valorCelda));
    }

    /*
    * Recorremos cada fila de la tabla
     */
    private boolean guardar_Tabla() {
        List<Modelo.Instrumento> instrumentos = new ArrayList<>();
        for (int filaa = 0; filaa < tbldato.getRowCount(); filaa++) {
            Modelo.Instrumento i = new Modelo.Instrumento();
            llenar(i, filaa); // Llenar el objeto Instrumento con los datos de la fila actual
            instrumentos.add(i); // Agregar el objeto Instrumento a la lista
        }
        boolean exito = fi.guardar(instrumentos);
        return exito;
    }

    /*
    * Mostramos en tabla 
     */
    private void Mostar_En_Tabla() {
        String valorar = (String) cboarea.getSelectedItem();
        String are = txtarea.getText();
        String moti = txtmotivo.getText();
        String osb = txtobs.getText();
        String fe = fecha.getFecha(txtfecha);
        String at = (String) cboatencion.getSelectedItem();
        String aten = txtatencion.getText();
        String valorpro = txt_programa.getText();
        String prog = txt_programa.getText();
        String turn = txt_turnos.getText();
        String cic = txt_ciclo.getText();
        String profes = nombreApellido;
        String id = String.valueOf(codigo);
        tdatos1.setRowCount(0);

        List<String> selectedItems = lstalumnos.getSelectedValuesList();

        for (String selectedItem : selectedItems) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(selectedItem); // Elemento seleccionado
            rowData.add(ar.capturacod(valorar));
            rowData.add(are);
            rowData.add(moti);
            rowData.add(osb);
            rowData.add(fe);
            rowData.add(ate.capturacod(at));
            rowData.add(aten);
            rowData.add(pro.capturacod(valorpro));
            rowData.add(prog);
            rowData.add(turn);
            rowData.add(cic);
            rowData.add(profes);
            rowData.add(id);
            tdatos1.addRow(rowData);
        }
    }

    private void maybeShowPopup(MouseEvent e) {
        if (e.isPopupTrigger() && txtobs.isEnabled()) {
            boolean textSelected = txtobs.getSelectedText() != null && !txtobs.getSelectedText().isEmpty();
            copiarItem.setEnabled(textSelected);
            cortarItem.setEnabled(textSelected);
            pegarItem.setEnabled(!textSelected);
            // Mostrar el menú contextual
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    private void updateCharacterCount(int currentLength) {
        int remainingCharacters = 150 - currentLength;
        txtcontador.setText("Caracteres restantes: " + remainingCharacters);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelficha = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstalumnos = new com.icm.components.metro.ListMetroICM();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtobs = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtarea = new javax.swing.JTextField();
        txtmotivo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtatencion = new javax.swing.JTextField();
        txtcontador = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldato = new rojeru_san.complementos.RSTableMetro();
        jLabel15 = new javax.swing.JLabel();
        txt_ciclo = new app.bolivia.swing.JCTextField();
        lblp = new javax.swing.JLabel();
        txtturno = new javax.swing.JLabel();
        txtciclo = new javax.swing.JLabel();
        lbl_guardado_exito = new javax.swing.JLabel();
        lbl_msg_boton = new javax.swing.JLabel();
        lblfechaposterior = new javax.swing.JLabel();
        txt_programa = new app.bolivia.swing.JCTextField();
        txt_turnos = new app.bolivia.swing.JCTextField();
        seleccionar = new com.icm.components.metro.switchButtonMetroICM();
        btn_grabar = new rojeru_san.complementos.RSButtonHover();
        btn_nuevo = new rojeru_san.complementos.RSButtonHover();
        btn_alumnos = new rojeru_san.complementos.RSButtonHover();
        cboarea = new com.icm.components.metro.ComboboxMetroICM();
        cbomotivo = new com.icm.components.metro.ComboboxMetroICM();
        cboatencion = new com.icm.components.metro.ComboboxMetroICM();

        setBackground(new java.awt.Color(0, 153, 204));
        setLayout(new java.awt.GridBagLayout());

        panelficha.setBackground(new java.awt.Color(255, 255, 255));
        panelficha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelfichaMouseClicked(evt);
            }
        });
        panelficha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstalumnos.setVisibleRowCount(32);
        jScrollPane2.setViewportView(lstalumnos);

        panelficha.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 30, 290, 360));

        txtobs.setColumns(8);
        txtobs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtobs.setRows(2);
        txtobs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtobsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtobsMouseReleased(evt);
            }
        });
        txtobs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtobsKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtobs);

        panelficha.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 550, 110));

        jLabel3.setText("Observación");
        panelficha.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 10));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelficha.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 130));

        txtarea.setEditable(false);
        txtarea.setBackground(new java.awt.Color(255, 255, 255));
        panelficha.add(txtarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 230, -1));

        txtmotivo.setEditable(false);
        txtmotivo.setBackground(new java.awt.Color(255, 255, 255));
        panelficha.add(txtmotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 300, -1));

        jLabel10.setText("Motivo");
        panelficha.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, 10));

        jLabel9.setText("Área");
        panelficha.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 10));

        txtfecha.setBackground(new java.awt.Color(255, 255, 255));
        txtfecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtfecha.setDateFormatString("y-MM-d");
        panelficha.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 150, 30));

        jLabel11.setText("Lista de Alumnos");
        panelficha.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 180, 20));

        jLabel5.setText("Programa de Estudio");
        panelficha.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel6.setText("Turno");
        panelficha.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabel7.setText("Semestre");
        panelficha.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel8.setText("Atención");
        panelficha.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        txtatencion.setEditable(false);
        txtatencion.setBackground(new java.awt.Color(255, 255, 255));
        panelficha.add(txtatencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 150, -1));
        panelficha.add(txtcontador, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 200, 20));

        tbldato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", " ", "", "", "", "", "", "", ""
            }
        ));
        tbldato.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbldato.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbldato.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tbldato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbldatoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbldato);

        panelficha.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1320, 420));

        jLabel15.setText("Fecha");
        panelficha.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        txt_ciclo.setEditable(false);
        txt_ciclo.setBackground(new java.awt.Color(255, 255, 255));
        txt_ciclo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_ciclo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ciclo.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_ciclo.setSelectionColor(new java.awt.Color(153, 204, 255));
        panelficha.add(txt_ciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 110, -1));
        panelficha.add(lblp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 260, 20));
        panelficha.add(txtturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 160, 20));
        panelficha.add(txtciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 100, 20));
        panelficha.add(lbl_guardado_exito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 480, 50));
        panelficha.add(lbl_msg_boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 180, 30));
        panelficha.add(lblfechaposterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 180, 20));

        txt_programa.setEditable(false);
        txt_programa.setBackground(new java.awt.Color(255, 255, 255));
        txt_programa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_programa.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        txt_programa.setSelectionColor(new java.awt.Color(153, 204, 255));
        panelficha.add(txt_programa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 330, -1));

        txt_turnos.setEditable(false);
        txt_turnos.setBackground(new java.awt.Color(255, 255, 255));
        txt_turnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_turnos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_turnos.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_turnos.setSelectionColor(new java.awt.Color(153, 204, 255));
        panelficha.add(txt_turnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 140, -1));

        seleccionar.setText("Seleccionar Todo");
        seleccionar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        seleccionar.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
        seleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarMouseClicked(evt);
            }
        });
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });
        panelficha.add(seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 390, -1, -1));

        btn_grabar.setText("Guardar");
        btn_grabar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_grabarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_grabarMouseExited(evt);
            }
        });
        btn_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabarActionPerformed(evt);
            }
        });
        panelficha.add(btn_grabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 180, -1));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        panelficha.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, 180, -1));

        btn_alumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-búsqueda-30.png"))); // NOI18N
        btn_alumnos.setText("Alumnos");
        btn_alumnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_alumnos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_alumnosMouseClicked(evt);
            }
        });
        panelficha.add(btn_alumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 130, 40));

        cboarea.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboareaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panelficha.add(cboarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 240, -1));

        cbomotivo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbomotivoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panelficha.add(cbomotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 290, -1));

        cboatencion.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboatencionPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panelficha.add(cboatencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 11, 18);
        add(panelficha, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtobsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtobsMousePressed
        maybeShowPopup(evt);
    }//GEN-LAST:event_txtobsMousePressed

    private void txtobsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtobsMouseReleased
        maybeShowPopup(evt);
    }//GEN-LAST:event_txtobsMouseReleased

    private void txtobsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtobsKeyTyped
        char c = evt.getKeyChar();
        if (txtobs.getText().length() >= 150) {
            evt.consume();
        } else {
            int maxCharactersPerLine = 50;
            String text = txtobs.getText();
            int caretPosition = txtobs.getCaretPosition();
            int lineStart = text.lastIndexOf('\n', caretPosition) + 1;
            int lineEnd = text.indexOf('\n', caretPosition);
            if (lineEnd == -1) {
                lineEnd = text.length();
            }
            int currentLineLength = lineEnd - lineStart;
            // Reformatear línea si se alcanza el límite de caracteres
            if (currentLineLength >= maxCharactersPerLine && c != '\n') {
                int wordBoundary = lineStart + maxCharactersPerLine;
                while (wordBoundary < lineEnd && !Character.isWhitespace(text.charAt(wordBoundary))) {
                    wordBoundary++;
                }
                String wrappedText = text.substring(0, wordBoundary) + "\n" + text.substring(wordBoundary);
                txtobs.setText(wrappedText);
            }
        }
        updateCharacterCount(txtobs.getText().length());
    }//GEN-LAST:event_txtobsKeyTyped

    private void seleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarMouseClicked

    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed
        if (listModel3.isEmpty()) {
            seleccionar.setSelected(false);
        } else {
            selectAllItems(seleccionar.isSelected());
        }
    }//GEN-LAST:event_seleccionarActionPerformed

    private void btn_grabarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_grabarMouseEntered
        if (!btn_grabar.isEnabled()) {
            if (btn_grabar.getText().equals("Cargando...")) {
                lbl_msg_boton.setText("Espere por favor!");
            } else {
                lbl_msg_boton.setText("Limpia para nuevo registro");
            }
        }
    }//GEN-LAST:event_btn_grabarMouseEntered

    private void btn_grabarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_grabarMouseExited
        lbl_msg_boton.setText("");
    }//GEN-LAST:event_btn_grabarMouseExited

    private void btn_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabarActionPerformed
        String data2 = txtarea.getText();
        String dato14 = (String) lstalumnos.getSelectedValue();
        // Verificamos primero si la lista está vacía
        if (lstalumnos.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "La lista de alumnos está vacía", "Vacio", JOptionPane.ERROR_MESSAGE, iconolista);
            return;
        }

        // Luego verificamos si no hay una selección hecha
        if (dato14 == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione alumnos de la lista", "Falta Datos", JOptionPane.ERROR_MESSAGE, iconoalumno);
            return;
        }

        // Validación de la fecha actual o anterior
        Date fechaActual = new Date();
        Date fechaSeleccionada = txtfecha.getDate();

        if (fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha.", "Falta Datos", JOptionPane.ERROR_MESSAGE, iconofecha);
            return;
        }

        if (fechaSeleccionada.after(fechaActual)) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha actual o anterior.", "Fecha Inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String moti = txtmotivo.getText();
        if (moti.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, Seleccione un Motivo.", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String aten = txtatencion.getText();
        if (aten.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, Seleccione la Atención.", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int conteo = lstalumnos.getModel().getSize();

        if (conteo == 1 && aten.equals("Atención Grupal")) {
            JOptionPane.showMessageDialog(null, "Ojo: Solo hay un alumno, esto vendría a ser una atención individual.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (conteo > 1 && aten.equals("Atención Individual")) {
            JOptionPane.showMessageDialog(null, "Ojo: Hay más de un alumno, esto vendría a ser una atención grupal.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (data2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String obs1 = txtobs.getText();
        if (obs1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, Escriba su Observación", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int guardar = JOptionPane.showConfirmDialog(this, "¿Deseas Grabar la información?", "Grabar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {

            Thread cargaDatosThread = new Thread(() -> {
                SwingUtilities.invokeLater(() -> {
                    btn_grabar.setEnabled(false);
                    btn_grabar.setText("Cargando...");
                    btn_nuevo.setEnabled(false);
                });

                int id = codigo;
                Mostar_En_Tabla();
                boolean exito = guardar_Tabla();
                if (exito) {
//                    SwingUtilities.invokeLater(() -> {
                    lbl_guardado_exito.setText("Registro Guardado Exitosamente");
                    lbl_guardado_exito.setForeground(new Color(64, 64, 64));
                    int conteoLista = lstalumnos.getModel().getSize();
                    limpiartabla1();
                    fi.mostrar(tdatos1, id, conteoLista);
                    btn_nuevo.setEnabled(true);
                    SwingUtilities.invokeLater(() -> {

                        btn_grabar.setText("Listo");
                        String Titulos2[] = {"Nombre y Apellido", "Area", "Motivo", "Obsr", "Fecha", "Atencion", "P.E.", "Turno", "Semestre", "Tutor"};
                        tdatos1.setColumnIdentifiers(Titulos2);
                        tbldato.getColumnModel().getColumn(0).setPreferredWidth(20);
                        tbldato.getColumnModel().getColumn(1).setPreferredWidth(40);
                        tbldato.getColumnModel().getColumn(2).setPreferredWidth(20);
                        tbldato.getColumnModel().getColumn(3).setPreferredWidth(100);
                        tbldato.getColumnModel().getColumn(4).setPreferredWidth(20);
                        tbldato.getColumnModel().getColumn(5).setPreferredWidth(25);
                        tbldato.getColumnModel().getColumn(6).setPreferredWidth(40);
                        tbldato.getColumnModel().getColumn(7).setPreferredWidth(5);
                        tbldato.getColumnModel().getColumn(8).setPreferredWidth(2);
                        tbldato.getColumnModel().getColumn(9).setPreferredWidth(30);
                    });
//                    });
                } else {
                    System.err.println("Error al guardar los datos ");
                }

            });
            // Iniciar el hilo
            cargaDatosThread.start();
        }
    }//GEN-LAST:event_btn_grabarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea Limpiar los campos?", "Limpiar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            lbl_guardado_exito.setText("");
            btn_grabar.setEnabled(true);
            btn_grabar.setText("Guardar");
            lstalumnos.setListData(new String[0]);
            lstalumnos.repaint();
            txtarea.setText("");
            cboarea.setSelectedItem("Seleccionar");
            cbomotivo.setSelectedItem("Seleccionar");
            cbomotivo.setEnabled(false);
            txtmotivo.setText("");
            cboatencion.setSelectedItem("Seleccionar");
            txtfecha.setDate(null);
            txtobs.setText("");
            updateCharacterCount(0);
            txtatencion.setText("");
            seleccionar.setSelected(false);
            txtobs.setEnabled(false);
            Clear_Table1();
            //tabla de registro
            String Titulos[] = {"Nombre", "ID", "Área", "Motivo", "OBS", "Fecha", "ID", "Atención", "ID", "P.E.", "Turno", "Semestre", "Tutor", "ID"};
            tdatos1.setColumnIdentifiers(Titulos);
            tbldato.setModel(tdatos1);
            tbldato.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbldato.getColumnModel().getColumn(1).setPreferredWidth(5);
            tbldato.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbldato.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbldato.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbldato.getColumnModel().getColumn(5).setPreferredWidth(20);
            tbldato.getColumnModel().getColumn(6).setPreferredWidth(5);
            tbldato.getColumnModel().getColumn(7).setPreferredWidth(20);
            tbldato.getColumnModel().getColumn(8).setPreferredWidth(5);
            tbldato.getColumnModel().getColumn(9).setPreferredWidth(80);
            tbldato.getColumnModel().getColumn(10).setPreferredWidth(30);
            tbldato.getColumnModel().getColumn(11).setPreferredWidth(30);
            tbldato.getColumnModel().getColumn(12).setPreferredWidth(50);
            tbldato.getColumnModel().getColumn(13).setPreferredWidth(50);
        } else {
        }
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void panelfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelfichaMouseClicked
//        jPopupMenu1.setVisible(false);
    }//GEN-LAST:event_panelfichaMouseClicked

    private void cboareaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboareaPopupMenuWillBecomeInvisible
        String valor1 = (String) cboarea.getSelectedItem();
        if (valor1.equals("Seleccionar")) {
            cbomotivo.setEnabled(false);
            cbomotivo.setSelectedItem("Seleccionar");
            txtfecha.setFocusable(false);
            txtarea.setText("");
            txtmotivo.setText("");
            txtobs.setEditable(false);
            txtobs.setEnabled(false);
            txtobs.setText("");
            txtfecha.setFocusable(false);
        } else {
            cbomotivo.setSelectedItem("Seleccionar");
            cbomotivo.removeAllItems();
            cbomotivo.setEnabled(true);
            txtarea.setText(valor1);
            txtmotivo.setText("");
            txtobs.setText("");
            SwingUtilities.invokeLater(() -> {
                mo.motivo1(combo5, valor1);
            });
        }
    }//GEN-LAST:event_cboareaPopupMenuWillBecomeInvisible

    private void cbomotivoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbomotivoPopupMenuWillBecomeInvisible
        String valor24 = (String) cbomotivo.getSelectedItem();
        if (valor24.equals("Seleccionar")) {
            txtmotivo.setText("");
            txtobs.setEditable(false);
            txtobs.setEnabled(false);
            txtobs.setText("");
        } else {
            txtmotivo.setText(valor24);
            txtobs.setEditable(true);
            txtobs.setEnabled(true);
            txtobs.requestFocus();
        }
    }//GEN-LAST:event_cbomotivoPopupMenuWillBecomeInvisible

    private void cboatencionPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboatencionPopupMenuWillBecomeInvisible
        String valor22 = (String) cboatencion.getSelectedItem();
        if (valor22.equals("Seleccionar")) {
            txtatencion.setText("");
        } else {
            txtatencion.setText(valor22);
        }
    }//GEN-LAST:event_cboatencionPopupMenuWillBecomeInvisible

    private void btn_alumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_alumnosMouseClicked

        String progra = (String) txt_programa.getText();
        String turno = (String) txt_turnos.getText();
        String ciclo = (String) txt_ciclo.getText();
        BuscarAlumnos bu = new BuscarAlumnos(null, true);

        bu.setVisible(true);
        seleccionar.setSelected(false);
        listModel3.clear();

        alum.mostraralu(listModel3, progra, turno, ciclo);
    }//GEN-LAST:event_btn_alumnosMouseClicked

    private void tbldatoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldatoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbldatoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_alumnos;
    private rojeru_san.complementos.RSButtonHover btn_grabar;
    private rojeru_san.complementos.RSButtonHover btn_nuevo;
    private com.icm.components.metro.ComboboxMetroICM cboarea;
    private com.icm.components.metro.ComboboxMetroICM cboatencion;
    private com.icm.components.metro.ComboboxMetroICM cbomotivo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_guardado_exito;
    private javax.swing.JLabel lbl_msg_boton;
    private javax.swing.JLabel lblfechaposterior;
    private javax.swing.JLabel lblp;
    public static com.icm.components.metro.ListMetroICM lstalumnos;
    private javax.swing.JPanel panelficha;
    private com.icm.components.metro.switchButtonMetroICM seleccionar;
    private rojeru_san.complementos.RSTableMetro tbldato;
    public static app.bolivia.swing.JCTextField txt_ciclo;
    public static app.bolivia.swing.JCTextField txt_programa;
    public static app.bolivia.swing.JCTextField txt_turnos;
    private javax.swing.JTextField txtarea;
    private javax.swing.JTextField txtatencion;
    private javax.swing.JLabel txtciclo;
    private javax.swing.JLabel txtcontador;
    private com.toedter.calendar.JDateChooser txtfecha;
    private javax.swing.JTextField txtmotivo;
    private javax.swing.JTextArea txtobs;
    private javax.swing.JLabel txtturno;
    // End of variables declaration//GEN-END:variables
}
