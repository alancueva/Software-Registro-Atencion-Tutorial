/**
 *
 * @author Alan Cueva
 */
package Vistas.instrumento;

import Vistas.Mensajes.Acercade;
import Vistas.Incio_sesion.InicioSesion;
import Controladores.Area;
import Controladores.Atencion;
import Controladores.ExportarExcel;
import Controladores.Ficha;
import Controladores.GuardarAlumno;
import Controladores.Motivo;
import Controladores.ProgramaDeEstudio;
import Controladores.Usuario;
import Controladores.Tiempo;
import Vistas.Mensajes.estrategias;
import Vistas.Mensajes.ima_profe_1;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Instrumento extends javax.swing.JFrame {

    private final DefaultTableModel tdatos1 = new DefaultTableModel();
    private final DefaultTableModel tdatos2 = new DefaultTableModel();
    private final DefaultComboBoxModel combo4 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo5 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo6 = new DefaultComboBoxModel();
    private final DefaultListModel listModel3 = new DefaultListModel();
    private final ProgramaDeEstudio pro = new ProgramaDeEstudio();
    private final Area ar = new Area();
    private final Motivo mo = new Motivo();
    private final Tiempo fecha = new Tiempo();
    private final Ficha fi = new Ficha();
    private final Atencion ate = new Atencion();
    private final GuardarAlumno alum = new GuardarAlumno();
    private final Usuario re = new Usuario();
    private boolean camposEditables = false;
    private String nombreApellido;
    private int codigo;
    JPopupMenu popupMenu = new JPopupMenu();
    JSeparator separar = new JSeparator();
    // Crear los ítems del menú
    JMenuItem opciones = new JMenuItem("Opciones");
    JMenuItem copiarItem = new JMenuItem("Copiar");
    JMenuItem cortarItem = new JMenuItem("Cortar");
    JMenuItem pegarItem = new JMenuItem("Pegar");
    private final ImageIcon iconoalumno = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/tab_client_icon-icons.png")));
    private final ImageIcon iconofecha = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/icons8-fecha-48.png")));
    private final ImageIcon iconolista = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/icons8-lista-corta-30.png")));

    public Instrumento() {
        initComponents();
        setExtendedState(Instrumento.MAXIMIZED_BOTH);
        setDefaultCloseOperation(Instrumento.EXIT_ON_CLOSE);
        this.setTitle("Registro de Atención Tutorial");
        this.setVisible(true);
        /*
        * Validación para leer fecha posterior
        * Si hay una fecha posterior saldra un mensaje en el label
        * Agregar un PropertyChangeListener para detectar cambios en la fecha seleccionada
         */
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

        lstalumnos.setModel(listModel3);
        lstalumnos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        txtobs.setEditable(false);
        txtobs.setEnabled(false);
        cbomotivo.setModel(combo5);
        ar.area(combo4);
        cboarea.setModel(combo4);
        cboatencion.setModel(combo6);
        ate.atencion(combo6);
        cbomotivo.setEnabled(false);
        //tabla historial
        tbldatos_Historial.setModel(tdatos2);
        String TitulosHistorial[] = {"Nombre y Apellido", "Área", "Motivo", "Obseración", "Fecha", "Atención", "Fecha-Hora"};
        tdatos2.setColumnIdentifiers(TitulosHistorial);
        tbldatos_Historial.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbldatos_Historial.getColumnModel().getColumn(1).setPreferredWidth(40);
        tbldatos_Historial.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbldatos_Historial.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbldatos_Historial.getColumnModel().getColumn(4).setPreferredWidth(20);
        tbldatos_Historial.getColumnModel().getColumn(5).setPreferredWidth(25);
        tbldatos_Historial.getColumnModel().getColumn(6).setPreferredWidth(40);
        tbldatos_Historial.setDefaultEditor(Object.class, null);
        // Deshabilitar el arrastre de columnas
        tbldatos_Historial.getTableHeader().setReorderingAllowed(false);
        // Permitir la selección de filas
        tbldatos_Historial.setRowSelectionAllowed(true);
        tbldatos_Historial.setColumnSelectionAllowed(false);
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

//        tbldato.getTableHeader().setResizingAllowed(false);
//        tbldatos_Historial.getTableHeader().setResizingAllowed(false);
//        tbldatos_Historial.setAutoResizeMode(tbldatos_Historial.AUTO_RESIZE_OFF); // Desactiva el ajuste automático del ancho de las columnas
//        tbldatos_Historial.setPreferredScrollableViewportSize(new Dimension(4000, 1000)); 
//        selectAllItems(seleccionar.isSelected());
        updateCharacterCount(txtobs.getText().length());

        cboarea.setFocusable(false);
        cboarea.setVisible(false);
        cbomotivo.setFocusable(false);
        cbomotivo.setVisible(false);
        cboatencion.setFocusable(false);
        cboatencion.setVisible(false);
        txtfecha.setFocusable(false);
        txtpro.setFocusable(false);
        paneHistorial.setVisible(true);
        panelficha.setVisible(false);
        configuracion.setVisible(false);
        paneHistorial.setVisible(false);
        //Cambiar contraseña
        jLabel16.setVisible(false);
        jLabel18.setVisible(false);
        jLabel19.setVisible(false);
        txtcontraantigua.setVisible(false);
        txtcontranueva.setVisible(false);
        chkmostrar1.setVisible(false);
        chlmostrar2.setVisible(false);
        btncambio.setVisible(false);
        lblmensaje2.setVisible(false);
        lblmensaje1.setVisible(false);
//        jLabel1.setComponentPopupMenu(null);
        //editar nombre apellido dni correo
        txtdni.setEditable(false);
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txtcorreo.setEditable(false);
        Cambios_Perfil.setVisible(false);
        // Configurar el diseño del JMenuBar
        jMenuBar1.setLayout(new BoxLayout(jMenuBar1, BoxLayout.X_AXIS));
        // Añadir JMenu1 a la izquierda
        jMenuBar1.add(tutoria);
        // Agregar espacio flexible para centrar los JMenu2 y JMenu3
        jMenuBar1.add(Box.createHorizontalGlue());
        // Añadir JMenu2 centrado
        jMenuBar1.add(menuinicio);
        // Añadir JMenu3 centrado
        jMenuBar1.add(menuficha);
        // Añadir espacio flexible a la derecha
        jMenuBar1.add(Box.createHorizontalGlue());
        // Añadir JMenu4 a la derecha
        jMenuBar1.add(ima);
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

        actualizarSaludoAsync();
        String titulo_a_v_d = "<html>"
                + "<body>"
                + "<h1>¿A quién va dirigido?<h1>"
                + "</body>"
                + "</html>";

        String t = "<html>"
                + "<body>Dirigido a cada uno de nuestros estudiantes de los ocho programas <br> "
                + "académicos que designan a sus docentes tutores."
                + "</body></html>";
        String msge = "<html>"
                + "<body>LA TUTORIA ES EL ACOMPAÑAMIENTO PERMANENTE QUE REALIZA EL DOCENTE A SUS ALUMNOS,DESDE QUE ESTOS <br> "
                + "INGRESAN HASTA QUE EGRESAN(MINEDU)."
                + "</body></html>";
        lbltutoria.setText(msge);
        String rpt_benficio = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; }"
                + "h2 { text-align: center; margin-top: 0; }"
                + "p { text-align: justify; margin: 0; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h2>¿CUÁLES SON LOS BENEFICIOS DEL REGISTRO Y LA ATENCIÓN?</h2>"
                + "<p>A la Institución nos ayuda a conocer las causas por las cuales <br>"
                + "nuestros alumnos: faltan, rinden por debajo de la media, <br>"
                + "desertan o abandonan los estudios, ya sea por salud, trabajo, <br>"
                + "problemas familiares, etc.</p>"
                + "</body></html>";
        lbl_txt_a_q_v_d.setText(rpt_benficio);
        limpiartablaHistorial();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/t.png"));
        return retValue;
    }

    private void actualizarSaludoAsync() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                actualizarSaludo();
                return null;
            }
        };

        worker.execute();
    }

    private void actualizarSaludo() {
        SwingUtilities.invokeLater(() -> {
            TimeZone timeZone = TimeZone.getDefault();
            Calendar calendar = new GregorianCalendar(timeZone);
            int hora = calendar.get(Calendar.HOUR_OF_DAY);
            String saludo;
            if (hora >= 0 && hora < 12) {
                saludo = "Buenos Días";
            } else if (hora >= 12 && hora < 19) {
                saludo = "Buenas Tardes";
            } else {
                saludo = "Buenas Noches";
            }
            lblsaludo.setText(saludo);
        });
    }

    /* Metodos Publicos
    * Reciben desde el inicio de sesion que recoge 
    * desde la base de datos para mostrar informacion de los docente
     */
    public void codigo(String id) {
        codigo = Integer.parseInt(id);
    }

    public void mostrarprograma(String Programa) {
        txt_programa.setText(Programa);
        lbl_programa_estudio.setText(Programa);

//        String progra = txt_programa.getText();
//        cboturno.removeAllItems();
//        tur.Turno_nom(combo2, progra);
    }

    public void mostrardni(String dni) {
        txtdni.setText(dni);
    }

    public void MostarCorreo(String Correo) {
        txtcorreo.setText(Correo);
    }

    public void mostrarBienvenidaDocente(String Bienvenida) {
        lblmsg.setText("Bienvenido, " + Bienvenida);
    }

    public void mostrarNombreDocente(String nombre) {
        txtnombre.setText(nombre);

        ima.setText(nombre);
        ima.updateUI();
    }

    public void mostrarApelledioDocente(String apellido) {
        txtapellido.setText(apellido);
    }

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
        lbltutor.setText(tutor);
        nombreApellido = nombre + " " + apellido;
    }

    public void mostrarNomApeDocente(String tutor) {

        lbl_docente.setText(tutor);
    }

    public void Mostrar_turno(String turno) {
        lbl_turno.setText(turno);
        txt_turnos.setText(turno);
    }

    public void Mostrar_ciclo(String ciclo) {
        lbl_ciclo.setText(ciclo);
        txt_ciclo.setText(ciclo);
    }

    /**
     * **** Metodos Private ******
     */
    private void limpiartabla1() {
        int x = tdatos1.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos1.removeRow(0);
        }
    }

    private void limpiartablaHistorial() {
        int x = tdatos2.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos2.removeRow(0);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        menuNuevo = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblsaludo = new javax.swing.JLabel();
        txtpro = new javax.swing.JTextField();
        btn_expo = new rojeru_san.complementos.RSButtonHover();
        panelGeneral = new javax.swing.JPanel();
        panelprincipal = new javax.swing.JPanel();
        panelRound1 = new Controladores.PanelRound();
        lblmsg = new javax.swing.JLabel();
        panel_abajo = new Controladores.PanelRound();
        panelRound2 = new Controladores.PanelRound();
        lbltutoria = new javax.swing.JLabel();
        btn_ima_a_p = new rojeru_san.complementos.RSButtonHover();
        panelRound3 = new Controladores.PanelRound();
        lbl_txt_a_q_v_d = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_ima_estra = new rojeru_san.complementos.RSButtonHover();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        titulo_tutoria = new javax.swing.JLabel();
        titulo_csr = new javax.swing.JLabel();
        panelficha = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstalumnos = new com.icm.components.metro.ListMetroICM();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtobs = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtarea = new javax.swing.JTextField();
        txtmotivo = new javax.swing.JTextField();
        cbomotivo = new com.icm.components.metro.ComboboxMetroICM();
        cboarea = new com.icm.components.metro.ComboboxMetroICM();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboatencion = new com.icm.components.metro.ComboboxMetroICM();
        txtatencion = new javax.swing.JTextField();
        txtcontador = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldato = new rojeru_san.complementos.RSTableMetro();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbltutor = new javax.swing.JLabel();
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
        configuracion = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        chkmostrar1 = new javax.swing.JCheckBox();
        chlmostrar2 = new javax.swing.JCheckBox();
        btncambio = new javax.swing.JButton();
        lblmensaje1 = new javax.swing.JLabel();
        txtcontraantigua = new javax.swing.JPasswordField();
        txtcontranueva = new javax.swing.JPasswordField();
        jSeparator5 = new javax.swing.JSeparator();
        lblmensaje2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblmensaje3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        Editar_Usuario = new com.icm.components.metro.LinkMetroICM();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        Cambios_Perfil = new javax.swing.JButton();
        cambiar_clave = new com.icm.components.metro.LinkMetroICM();
        paneHistorial = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbldatos_Historial = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbl_programa_estudio = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_docente = new javax.swing.JLabel();
        lbl_turno = new javax.swing.JLabel();
        lbl_ciclo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        tutoria = new javax.swing.JMenu();
        menuinicio = new javax.swing.JMenu();
        menuficha = new javax.swing.JMenu();
        ima = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        historial = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-opciones-30.png"))); // NOI18N
        jMenu1.setText(" Opciones");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        menuNuevo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        menuNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-nueva-hoja-de-cálculo-30.png"))); // NOI18N
        menuNuevo.setText("Nuevo                         ");
        menuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(menuNuevo);

        jMenuItem3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-cuadrado-de-información-30.png"))); // NOI18N
        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-cerrar-sesión-30.png"))); // NOI18N
        jMenuItem7.setText("Cerrar Seción");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator1);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-x-25.png"))); // NOI18N
        menuSalir.setText("Salir                            ");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jLabel12.setText("jLabel12");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Profesor");

        lblsaludo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblsaludo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtpro.setEditable(false);
        txtpro.setBackground(new java.awt.Color(255, 255, 255));

        btn_expo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/microsoft_office_excel_logo_icon_145720 (1).png"))); // NOI18N
        btn_expo.setText("Exportar");
        btn_expo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_expoActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());

        panelGeneral.setBackground(new java.awt.Color(0, 153, 204));
        panelGeneral.setLayout(new javax.swing.BoxLayout(panelGeneral, javax.swing.BoxLayout.LINE_AXIS));

        panelprincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelprincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelprincipalMouseClicked(evt);
            }
        });
        panelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(java.awt.SystemColor.activeCaption);
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblmsg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblmsg.setForeground(new java.awt.Color(255, 255, 255));
        lblmsg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblmsg.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblmsg.setVerifyInputWhenFocusTarget(false);
        panelRound1.add(lblmsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 500, 50));

        panelprincipal.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 550, 50));

        panel_abajo.setBackground(java.awt.SystemColor.activeCaption);
        panel_abajo.setRoundBottomLeft(100);
        panel_abajo.setRoundTopRight(100);
        panel_abajo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltutoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbltutoria.setText("tutoria");
        lbltutoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound2.add(lbltutoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 21, 886, 50));

        btn_ima_a_p.setBackground(new java.awt.Color(232, 233, 232));
        btn_ima_a_p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-tutoring-70.png"))); // NOI18N
        btn_ima_a_p.setColorHover(java.awt.SystemColor.activeCaption);
        btn_ima_a_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ima_a_pActionPerformed(evt);
            }
        });
        panelRound2.add(btn_ima_a_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 126, 60));

        panel_abajo.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 1280, 90));

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_txt_a_q_v_d.setBackground(new java.awt.Color(0, 102, 204));
        lbl_txt_a_q_v_d.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_txt_a_q_v_d.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_txt_a_q_v_d.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound3.add(lbl_txt_a_q_v_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 620, 170));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRound3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 23, 340));

        jLabel22.setBackground(new java.awt.Color(0, 153, 204));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Estrategias de Intervención Tutorial");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 460, 40));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Classroom-cuate (1).png"))); // NOI18N
        jLabel23.setText("IMAGEN");
        panelRound3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, -10, 500, 400));

        btn_ima_estra.setBackground(java.awt.SystemColor.activeCaption);
        btn_ima_estra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-task-70.png"))); // NOI18N
        btn_ima_estra.setColorHover(java.awt.SystemColor.scrollbar);
        btn_ima_estra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ima_estraActionPerformed(evt);
            }
        });
        panelRound3.add(btn_ima_estra, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 80, 60));
        panelRound3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 650, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cansado.png"))); // NOI18N
        panelRound3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 210, 120));

        panel_abajo.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1280, 340));

        panelprincipal.add(panel_abajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1330, 490));

        titulo_tutoria.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        titulo_tutoria.setForeground(new java.awt.Color(153, 0, 0));
        titulo_tutoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_tutoria.setText("TUTORÍA EN EL IESTP");
        panelprincipal.add(titulo_tutoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1310, -1));

        titulo_csr.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titulo_csr.setForeground(new java.awt.Color(0, 153, 204));
        titulo_csr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_csr.setText(" “CARLOS SALAZAR ROMERO”");
        panelprincipal.add(titulo_csr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 1300, -1));

        panelGeneral.add(panelprincipal);

        panelficha.setBackground(new java.awt.Color(255, 255, 255));
        panelficha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelfichaMouseClicked(evt);
            }
        });
        panelficha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstalumnos.setVisibleRowCount(32);
        jScrollPane2.setViewportView(lstalumnos);

        panelficha.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 30, 270, 360));

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

        cbomotivo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbomotivoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panelficha.add(cbomotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 300, 30));

        cboarea.setMaximumRowCount(10);
        cboarea.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboareaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panelficha.add(cboarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, 30));

        jLabel10.setText("Motivo");
        panelficha.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, 10));

        jLabel9.setText("Area");
        panelficha.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 10));

        txtfecha.setBackground(new java.awt.Color(255, 255, 255));
        txtfecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtfecha.setDateFormatString("y-MM-d");
        panelficha.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 150, 30));

        jLabel11.setText("Lista de Alumnos");
        panelficha.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 180, 20));

        jLabel5.setText("Programa de Estudio");
        panelficha.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel6.setText("Turno");
        panelficha.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabel7.setText("Semestre");
        panelficha.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel8.setText("Atención");
        panelficha.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        cboatencion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        jScrollPane1.setViewportView(tbldato);

        panelficha.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1320, 420));

        jLabel15.setText("Fecha");
        panelficha.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        jLabel21.setText("Tutor");
        panelficha.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        lbltutor.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        lbltutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelficha.add(lbltutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 280, 50));

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
        panelficha.add(seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 390, -1, -1));

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
        btn_alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alumnosActionPerformed(evt);
            }
        });
        panelficha.add(btn_alumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 130, 40));

        panelGeneral.add(panelficha);

        configuracion.setBackground(new java.awt.Color(255, 255, 255));
        configuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configuracionMouseClicked(evt);
            }
        });
        configuracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        configuracion.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 600, 10));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setText(" Perfil");
        configuracion.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Contraseña:");
        configuracion.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 100, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        configuracion.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Contraseña Antigua");
        configuracion.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Contraseña Nueva");
        configuracion.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));

        chkmostrar1.setText("Mostrar Contraseña");
        chkmostrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkmostrar1ActionPerformed(evt);
            }
        });
        configuracion.add(chkmostrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, -1, -1));

        chlmostrar2.setText("Mostrar Contraseña");
        chlmostrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chlmostrar2ActionPerformed(evt);
            }
        });
        configuracion.add(chlmostrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, -1, -1));

        btncambio.setText("Cambiar contraseña");
        btncambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambioActionPerformed(evt);
            }
        });
        configuracion.add(btncambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 220, 30));
        configuracion.add(lblmensaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 220, 20));
        configuracion.add(txtcontraantigua, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 220, 30));
        configuracion.add(txtcontranueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 220, 30));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        configuracion.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1370, 10));
        configuracion.add(lblmensaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 510, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("DNI:");
        configuracion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));
        configuracion.add(lblmensaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 220, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Nombre:");
        configuracion.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Apellido:");
        configuracion.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Datos de Usuario");
        configuracion.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 30));

        jLabel26.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Nuestra misión es proporcionar una Tutoria gratuita de clase mundial para cualquier persona en cualquier lugar");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        configuracion.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 1280, 30));

        txtnombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        configuracion.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 220, 30));

        txtapellido.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        configuracion.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 230, 30));

        txtdni.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        configuracion.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 220, 30));

        txtcorreo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        configuracion.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 230, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Correo:");
        configuracion.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        Editar_Usuario.setText("Editar");
        Editar_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Editar_UsuarioMouseClicked(evt);
            }
        });
        configuracion.add(Editar_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, 30));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        configuracion.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1370, 10));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        configuracion.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 600, 10));

        Cambios_Perfil.setText("Confirmar Cambios");
        Cambios_Perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cambios_PerfilActionPerformed(evt);
            }
        });
        configuracion.add(Cambios_Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 330, 160, -1));

        cambiar_clave.setText("Cambiar clave");
        cambiar_clave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiar_claveMouseClicked(evt);
            }
        });
        configuracion.add(cambiar_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 30));

        panelGeneral.add(configuracion);

        paneHistorial.setBackground(new java.awt.Color(255, 255, 255));
        paneHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        paneHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneHistorialMouseClicked(evt);
            }
        });
        paneHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Historial");
        paneHistorial.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        tbldatos_Historial.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldatos_Historial.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbldatos_Historial.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbldatos_Historial.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbldatos_Historial.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(tbldatos_Historial);

        paneHistorial.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1280, 700));

        jLabel1.setText("Programa de Estudio:");
        paneHistorial.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel29.setText("Turno:");
        paneHistorial.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jLabel30.setText("Ciclo:");
        paneHistorial.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 20));
        paneHistorial.add(lbl_programa_estudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 560, 20));

        jLabel32.setText("Docente:");
        paneHistorial.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));
        paneHistorial.add(lbl_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 560, 20));
        paneHistorial.add(lbl_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 130, 20));
        paneHistorial.add(lbl_ciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 100, 20));

        panelGeneral.add(paneHistorial);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(340, 50));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(340, 60));
        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
        });

        tutoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cropped-cropped (1).png"))); // NOI18N
        tutoria.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        tutoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tutoriaMouseClicked(evt);
            }
        });
        jMenuBar1.add(tutoria);

        menuinicio.setBackground(new java.awt.Color(255, 255, 255));
        menuinicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-cucha-45.png"))); // NOI18N
        menuinicio.setText("Inicio");
        menuinicio.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        menuinicio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        menuinicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuinicioMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuinicio);

        menuficha.setBackground(new java.awt.Color(255, 255, 255));
        menuficha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-documento-45.png"))); // NOI18N
        menuficha.setText("Registro");
        menuficha.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        menuficha.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        menuficha.setMinimumSize(new java.awt.Dimension(73, 40));
        menuficha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menufichaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuficha);

        ima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-usuario-masculino-en-círculo-45.png"))); // NOI18N
        ima.setText("Docente");
        ima.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        ima.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imaMouseClicked(evt);
            }
        });

        jMenuItem2.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-ajustes-30.png"))); // NOI18N
        jMenuItem2.setText("Configuarción");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        ima.add(jMenuItem2);

        historial.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-pasado-30.png"))); // NOI18N
        historial.setText("Historial");
        historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialActionPerformed(evt);
            }
        });
        ima.add(historial);

        jMenuItem4.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-cierre-de-sesión-redondeado-hacia-abajo-30.png"))); // NOI18N
        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        ima.add(jMenuItem4);

        jMenuBar1.add(ima);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoActionPerformed
        lstalumnos.setListData(new String[0]);
        lstalumnos.repaint();
        txtpro.setText("");
        txtarea.setText("");
        cboarea.setSelectedItem("Seleccionar");
        cbomotivo.setSelectedItem("Seleccionar");
        txtmotivo.setText("");
        cboatencion.setSelectedItem("Seleccionar");
        txtfecha.setDate(null);
        txtobs.setText("");
        txtatencion.setText("");
        txtobs.setEnabled(false);
        Clear_Table1();
        String Titulos[] = {"Nombre", "ID", "Area", "Motivo", "OBS", "Fecha", "ID", "Atencion", "ID", "P.E.", "Turno", "Ciclo", "Tutor"};
        tdatos1.setColumnIdentifiers(Titulos);
        tbldato.setModel(tdatos1);
        tbldato.setEnabled(false);
        tbldato.getColumnModel().getColumn(0).setPreferredWidth(50);//Tamaño columnas
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
    }//GEN-LAST:event_menuNuevoActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void cboatencionPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboatencionPopupMenuWillBecomeInvisible
        String valor22 = (String) cboatencion.getSelectedItem();
        if (valor22.equals("Seleccionar")) {
            txtatencion.setText("");
        } else {
            txtatencion.setText(valor22);
        }
    }//GEN-LAST:event_cboatencionPopupMenuWillBecomeInvisible

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
            mo.motivo1(combo5, valor1);
        }
    }//GEN-LAST:event_cboareaPopupMenuWillBecomeInvisible

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

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        dispose();
        InicioSesion is = new InicioSesion();
        is.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Acercade ace = new Acercade(this, true);
        ace.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menufichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menufichaMouseClicked
        panelficha.setVisible(true);
        cboarea.setVisible(true);
        cbomotivo.setVisible(true);
        cboatencion.setVisible(true);
        panelprincipal.setVisible(false);
        btn_ima_estra.setVisible(false);
        btn_ima_a_p.setVisible(false);
        configuracion.setVisible(false);
        paneHistorial.setVisible(false);
        limpiartablaHistorial();
        txtcontraantigua.setFocusable(false);
        txtcontranueva.setFocusable(false);
    }//GEN-LAST:event_menufichaMouseClicked

    private void menuinicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuinicioMouseClicked
        panelprincipal.setVisible(true);
        btn_ima_estra.setVisible(true);
        btn_ima_a_p.setVisible(true);
        paneHistorial.setVisible(false);
        limpiartablaHistorial();
        panelficha.setVisible(false);
        configuracion.setVisible(false);
        paneHistorial.setVisible(false);

    }//GEN-LAST:event_menuinicioMouseClicked
    private void Clear_Table1() {
        for (int i = 0; i < tbldato.getRowCount(); i++) {
            tdatos1.removeRow(i);
            i -= 1;
        }
    }
    private void btncambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambioActionPerformed
        String dni = txtdni.getText();
        String clave1 = new String(txtcontraantigua.getPassword());
        String clave2 = new String(txtcontranueva.getPassword());
        if (dni.length() != 8) {
            lblmensaje3.setText("El DNI debe tener 8 dígitos");
            lblmensaje3.setForeground(java.awt.Color.BLACK);
        }
        if (clave1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese su antigua Clave", "Atencion", JOptionPane.ERROR_MESSAGE);
            txtcontraantigua.requestFocus();
            return;
        }
        if (clave2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese La Nueva Clave", "Atencion", JOptionPane.ERROR_MESSAGE);
            txtcontranueva.requestFocus();
            return;
        }
        if (clave1.length() > 6) {
            lblmensaje1.setText("La clave parece buena, Trate de NO OLVIDARSE!");
            lblmensaje1.setForeground(java.awt.Color.BLACK);
        }
        if (clave2.length() > 8) {
            lblmensaje2.setText("La clave parece buena, Trate de NO OLVIDARSE!");
            lblmensaje2.setForeground(java.awt.Color.BLACK);
        }
        if (re.verificarContraseñaAntigua(dni, clave1)) {
            boolean cambioExitoso = re.cambiarContraseñaDocente(dni, clave2);
            if (cambioExitoso) {
                int opcion = JOptionPane.showConfirmDialog(this, "Contraseña cambiada exitosamente.\n¿Deseas mantener la sesión?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.NO_OPTION) {
                    InicioSesion ventanaInicioSesion = new InicioSesion();
                    ventanaInicioSesion.setVisible(true);
                    this.dispose();
                } else {
//                    txtdni.setText("");
                    txtcontraantigua.setText("");
                    txtcontranueva.setText("");
                    chkmostrar1.setSelected(false);
                    chlmostrar2.setSelected(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña. Inténtalo de nuevo.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Contraseña antigua incorrecta. Inténtalo de nuevo.");
        }
    }//GEN-LAST:event_btncambioActionPerformed

    private void chkmostrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkmostrar1ActionPerformed
        if (chkmostrar1.isSelected()) {
            txtcontraantigua.setEchoChar((char) 0); // Mostrar caracteres
        } else {
            txtcontraantigua.setEchoChar('*'); // Ocultar caracteres
        }
        String c = new String(txtcontraantigua.getPassword());
        if (c.isEmpty()) {
            txtcontraantigua.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_chkmostrar1ActionPerformed

    private void chlmostrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chlmostrar2ActionPerformed
        if (chlmostrar2.isSelected()) {
            txtcontranueva.setEchoChar((char) 0); // Mostrar caracteres
        } else {
            txtcontranueva.setEchoChar('*'); // Ocultar caracteres
        }
        String c = new String(txtcontraantigua.getPassword());
        if (c.isEmpty()) {
            txtcontranueva.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_chlmostrar2ActionPerformed

    private void imaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imaMouseClicked
    }//GEN-LAST:event_imaMouseClicked

    private void jMenuBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseClicked

    }//GEN-LAST:event_jMenuBar1MouseClicked

    private void panelfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelfichaMouseClicked

    }//GEN-LAST:event_panelfichaMouseClicked

    private void paneHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHistorialMouseClicked

    }//GEN-LAST:event_paneHistorialMouseClicked

    private void tutoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tutoriaMouseClicked
        Acercade ace = new Acercade(this, rootPaneCheckingEnabled);
        ace.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_tutoriaMouseClicked

    private void btn_ima_a_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ima_a_pActionPerformed
        Vistas.Mensajes.ima_profe_1 m = new ima_profe_1(this, true);
        m.setVisible(true);
    }//GEN-LAST:event_btn_ima_a_pActionPerformed

    private void btn_ima_estraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ima_estraActionPerformed
        Vistas.Mensajes.estrategias m = new estrategias(this, true);
        m.setVisible(true);
    }//GEN-LAST:event_btn_ima_estraActionPerformed

    private void panelprincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelprincipalMouseClicked

    }//GEN-LAST:event_panelprincipalMouseClicked

    private void configuracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configuracionMouseClicked

    }//GEN-LAST:event_configuracionMouseClicked

    private void Editar_UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Editar_UsuarioMouseClicked
        if (!camposEditables) {
            // Hacer los campos editables
            txtdni.setEditable(false);
            txtnombre.setEditable(true);
            txtapellido.setEditable(true);
            txtcorreo.setEditable(true);
            Cambios_Perfil.setVisible(true);
            camposEditables = true; // Establecer el estado de edición como verdadero
        } else {
            // Hacer los campos no editables
            txtdni.setEditable(false);
            txtnombre.setEditable(false);
            txtapellido.setEditable(false);
            txtcorreo.setEditable(false);
            Cambios_Perfil.setVisible(false);
            camposEditables = false; // Establecer el estado de edición como falso
        }
    }//GEN-LAST:event_Editar_UsuarioMouseClicked

    private void Cambios_PerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cambios_PerfilActionPerformed
        String nom = txtnombre.getText();
        String ape = txtapellido.getText();
        String dni = txtdni.getText();
        String correo = txtcorreo.getText();
        if (nom.isEmpty() || ape.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete los campos por favor.", "Faltan llenar Campos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validación de formato de correo electrónico
        if (!correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un correo electrónico válido.", "Formato de Correo Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?", "Modificar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            boolean cambioExitoso = re.actualizar_usuario(nom, ape, dni, correo);
            if (cambioExitoso) {
                JOptionPane.showConfirmDialog(this, "Datos Modificados Exitosamente.", "Datos Modificados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al cambiar la Datos. Inténtalo de nuevo.");
            }
        }
    }//GEN-LAST:event_Cambios_PerfilActionPerformed

    private void cambiar_claveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiar_claveMouseClicked
        if (!camposEditables) {
            jLabel18.setVisible(true);
            jLabel16.setVisible(true);
            txtcontraantigua.setVisible(true);
            txtcontranueva.setVisible(true);
            chkmostrar1.setVisible(true);
            chlmostrar2.setVisible(true);
            btncambio.setVisible(true);
            lblmensaje2.setVisible(true);
            lblmensaje1.setVisible(true);
            jLabel19.setVisible(true);
            camposEditables = true;
        } else {
            jLabel18.setVisible(false);
            jLabel16.setVisible(false);
            txtcontraantigua.setVisible(false);
            txtcontranueva.setVisible(false);
            chkmostrar1.setVisible(false);
            chlmostrar2.setVisible(false);
            btncambio.setVisible(false);
            lblmensaje2.setVisible(false);
            lblmensaje1.setVisible(false);
            jLabel19.setVisible(false);
            camposEditables = false;
        }
    }//GEN-LAST:event_cambiar_claveMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//        estra.setVisible(false);
        panelprincipal.setVisible(false);
        btn_ima_estra.setVisible(false);
        btn_ima_a_p.setVisible(false);
        panelficha.setVisible(false);
        paneHistorial.setVisible(false);
        limpiartablaHistorial();
        //        txtdni.setFocusable(true);
        //        txtdni.setVisible(false);
        configuracion.setVisible(true);
        txtcontraantigua.setFocusable(true);
        //        txtcontraantigua.setVisible(false);
        txtcontranueva.setFocusable(true);
        //        txtcontranueva.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialActionPerformed
//        estra.setVisible(false);
        panelprincipal.setVisible(false);
        btn_ima_estra.setVisible(false);
        btn_ima_a_p.setVisible(false);
        panelficha.setVisible(false);
        configuracion.setVisible(false);
        txtcontraantigua.setFocusable(false);
        txtcontranueva.setFocusable(false);

        paneHistorial.setVisible(true);
        limpiartablaHistorial();
        // Crear un hilo para cargar los datos en segundo plano
        Thread cargaDatosThread = new Thread(() -> {
            int id = codigo;
            fi.mostrarHistorial(tdatos2, id);
        });
        // Iniciar el hilo
        cargaDatosThread.start();
    }//GEN-LAST:event_historialActionPerformed

    private void btn_expoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_expoActionPerformed
        if (tbldatos_Historial == null || tbldatos_Historial.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Faltan datos. La tabla está vacía.", "Tabla vacía", JOptionPane.WARNING_MESSAGE);
        } else {
            ExportarExcel obj;
            try {
                obj = new ExportarExcel();
                obj.exportarExcel(tbldatos_Historial);
            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
        }
    }//GEN-LAST:event_btn_expoActionPerformed

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

    private void btn_alumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alumnosActionPerformed
        String progra = (String) txt_programa.getText();
        String turno = (String) txt_turnos.getText();
        String ciclo = (String) txt_ciclo.getText();
        BuscarAlumno bu = new BuscarAlumno(this, true);
        bu.setVisible(true);
        listModel3.clear();
        seleccionar.setSelected(false);
        alum.mostraralu(listModel3, progra, turno, ciclo);
    }//GEN-LAST:event_btn_alumnosActionPerformed

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

        int guardar = JOptionPane.showConfirmDialog(this, "Deseas Grabar", "Grabar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {

            Thread cargaDatosThread = new Thread(() -> {
                SwingUtilities.invokeLater(() -> {
                    btn_grabar.setEnabled(false);
                    btn_grabar.setText("Cargando...");
                });
                int id = codigo;
                Mostar_En_Tabla();
                boolean exito = guardar_Tabla();
                if (exito) {
//                    SwingUtilities.invokeLater(() -> {
                        lbl_guardado_exito.setText("Registro Guardado Exitosamente");
                        lbl_guardado_exito.setForeground(new Color(64, 64, 64));
//                    });
                } else {
                    System.err.println("Error al guardar los datos ");
                }
                int conteoLista = lstalumnos.getModel().getSize();
                limpiartabla1();
                
//                SwingUtilities.invokeLater(() -> {
                    fi.mostrar(tdatos1, id, conteoLista);
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
//                });
                
            });
            // Iniciar el hilo
            cargaDatosThread.start();
        }
    }//GEN-LAST:event_btn_grabarActionPerformed

    private void btn_grabarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_grabarMouseEntered
        if (!btn_grabar.isEnabled()) {
            lbl_msg_boton.setText("Limpia para nuevo registro");
        }
    }//GEN-LAST:event_btn_grabarMouseEntered

    private void btn_grabarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_grabarMouseExited
        lbl_msg_boton.setText("");
    }//GEN-LAST:event_btn_grabarMouseExited

    private void txtobsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtobsMousePressed
        maybeShowPopup(evt);
    }//GEN-LAST:event_txtobsMousePressed

    private void txtobsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtobsMouseReleased
        maybeShowPopup(evt);
    }//GEN-LAST:event_txtobsMouseReleased
    private void maybeShowPopup(MouseEvent e) {
        if (e.isPopupTrigger() && txtobs.isEnabled()) {
            //            // Verificar si el JTextArea está vacío
            //            boolean textNotEmpty = !txtobs.getText().isEmpty();
            //            copiarItem.setEnabled(textNotEmpty);
            //            cortarItem.setEnabled(textNotEmpty);
            //            // Mostrar el menú contextual
            //            popupMenu.show(e.getComponent(), e.getX(), e.getY());

//            // Verificar si el JTextArea está vacío
//            boolean textNotEmpty = !txtobs.getText().isEmpty();
//            // Verificar si hay texto seleccionado
//            boolean textSelected = txtobs.getSelectedText() != null;
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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instrumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Instrumento().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cambios_Perfil;
    private com.icm.components.metro.LinkMetroICM Editar_Usuario;
    private rojeru_san.complementos.RSButtonHover btn_alumnos;
    private rojeru_san.complementos.RSButtonHover btn_expo;
    private rojeru_san.complementos.RSButtonHover btn_grabar;
    private rojeru_san.complementos.RSButtonHover btn_ima_a_p;
    private rojeru_san.complementos.RSButtonHover btn_ima_estra;
    private rojeru_san.complementos.RSButtonHover btn_nuevo;
    private javax.swing.JButton btncambio;
    private com.icm.components.metro.LinkMetroICM cambiar_clave;
    private com.icm.components.metro.ComboboxMetroICM cboarea;
    private com.icm.components.metro.ComboboxMetroICM cboatencion;
    private com.icm.components.metro.ComboboxMetroICM cbomotivo;
    private javax.swing.JCheckBox chkmostrar1;
    private javax.swing.JCheckBox chlmostrar2;
    private javax.swing.JPanel configuracion;
    private javax.swing.JMenuItem historial;
    private javax.swing.JMenu ima;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbl_ciclo;
    private javax.swing.JLabel lbl_docente;
    private javax.swing.JLabel lbl_guardado_exito;
    private javax.swing.JLabel lbl_msg_boton;
    private javax.swing.JLabel lbl_programa_estudio;
    private javax.swing.JLabel lbl_turno;
    private javax.swing.JLabel lbl_txt_a_q_v_d;
    private javax.swing.JLabel lblfechaposterior;
    private javax.swing.JLabel lblmensaje1;
    private javax.swing.JLabel lblmensaje2;
    private javax.swing.JLabel lblmensaje3;
    private javax.swing.JLabel lblmsg;
    private javax.swing.JLabel lblp;
    private javax.swing.JLabel lblsaludo;
    private javax.swing.JLabel lbltutor;
    private javax.swing.JLabel lbltutoria;
    public static com.icm.components.metro.ListMetroICM lstalumnos;
    private javax.swing.JMenuItem menuNuevo;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenu menuficha;
    private javax.swing.JMenu menuinicio;
    private javax.swing.JPanel paneHistorial;
    private javax.swing.JPanel panelGeneral;
    private Controladores.PanelRound panelRound1;
    private Controladores.PanelRound panelRound2;
    private Controladores.PanelRound panelRound3;
    private Controladores.PanelRound panel_abajo;
    private javax.swing.JPanel panelficha;
    private javax.swing.JPanel panelprincipal;
    private com.icm.components.metro.switchButtonMetroICM seleccionar;
    private rojeru_san.complementos.RSTableMetro tbldato;
    private rojeru_san.complementos.RSTableMetro tbldatos_Historial;
    private javax.swing.JLabel titulo_csr;
    private javax.swing.JLabel titulo_tutoria;
    private javax.swing.JMenu tutoria;
    public static app.bolivia.swing.JCTextField txt_ciclo;
    public static app.bolivia.swing.JCTextField txt_programa;
    public static app.bolivia.swing.JCTextField txt_turnos;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtarea;
    private javax.swing.JTextField txtatencion;
    private javax.swing.JLabel txtciclo;
    private javax.swing.JLabel txtcontador;
    private javax.swing.JPasswordField txtcontraantigua;
    private javax.swing.JPasswordField txtcontranueva;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdni;
    private com.toedter.calendar.JDateChooser txtfecha;
    private javax.swing.JTextField txtmotivo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextArea txtobs;
    private javax.swing.JTextField txtpro;
    private javax.swing.JLabel txtturno;
    // End of variables declaration//GEN-END:variables
}
