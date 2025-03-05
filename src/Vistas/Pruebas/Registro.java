package Vistas.Pruebas;

import Controladores.Area;
import Controladores.Atencion;
import Controladores.Ciclo;
import Controladores.Ficha;
import Controladores.GuardarAlumno;
import Controladores.Internet;
import Controladores.Motivo;
import Controladores.ProgramaDeEstudio;
import Controladores.Usuario;
import Controladores.Tiempo;
import Controladores.Turno;
import Modelo.Conexion;
import Vistas.Administracion.BuscarAlumno_admin;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class Registro extends javax.swing.JPanel {

    DefaultTableModel tdatos1 = new DefaultTableModel();
    DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo2 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo3 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo4 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo5 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo6 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo7 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo8 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo9 = new DefaultComboBoxModel();
    DefaultListModel listModel3 = new DefaultListModel();
    ProgramaDeEstudio pro = new ProgramaDeEstudio();
    Conexion ocon = new Conexion();
    Turno tur = new Turno();
    Ciclo ci = new Ciclo();
    Internet a = new Internet();
    Area ar = new Area();
    Motivo mo = new Motivo();
    Tiempo fecha = new Tiempo();
    Ficha fi = new Ficha();
    Atencion ate = new Atencion();
    int fila;
    int valor;
    int contador = 0;
    GuardarAlumno alum = new GuardarAlumno();
    Usuario re = new Usuario();
    private final ImageIcon iconoalumno = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/tab_client_icon-icons.png")));
    private final ImageIcon iconofecha = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/icons8-fecha-48.png")));

    public Registro() {
        initComponents();

        lstalumnos.setModel(listModel3);
        
        cboprograma.setModel(combo1);
        pro.programa(combo1);

        cboturno.setModel(combo2);
        cbociclo.setModel(combo3);
        txtobs.setEditable(false);
        txtobs.setEnabled(false);
        cbomotivo.setModel(combo5);
        ar.area(combo4);
        cboarea.setModel(combo4);
        cboatencion.setModel(combo6);
        ate.atencion(combo6);
//        cboturno.setEnabled(false);
        cbociclo.setEnabled(false);
        cbomotivo.setEnabled(false);
        String Titulos[] = {"Nombre", "ID", "Area", "Motivo", "OBS", "Fecha", "ID", "Atencion", "ID", "P.E.", "Turno", "Ciclo", "Tutor","ID"};
        tdatos1.setColumnIdentifiers(Titulos);
        tbldato.setModel(tdatos1);
        tbldato.setEnabled(false);
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

        String pgm = txtprograma.getText();
        if (pgm.isEmpty()) {
            cboturno.setFocusable(false);
            cboturno.setEnabled(false);
            cbociclo.setSelectedIndex(-1);
            cbociclo.setEnabled(false);
            cbociclo.setSelectedItem("Seleccionar");
        } else {
            cboturno.setFocusable(true);
            cboturno.setEnabled(true);
        }

        // Limitar el número máximo de caracteres
        txtobs.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (txtobs.getText().length() > 150) {
                    txtobs.setText(txtobs.getText().substring(0, 150));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    public void mostrarprograma(String Programa) {
        txtprograma.setText(Programa);
        txtprograma.updateUI();
        String progra = txtprograma.getText();
        cboturno.removeAllItems();
        tur.Turno_nom(combo2, progra);
    }

    public void mostrarNomApeDocente(String tutor) {
//        lbltutor.setText(tutor);
//        lbltutor.updateUI();

    }

    private void Clear_Table1() {
        for (int i = 0; i < tbldato.getRowCount(); i++) {
            tdatos1.removeRow(i);
            i -= 1;
        }
    }

    private void limpiartabla1() {
        int x = tdatos1.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos1.removeRow(0);
        }
    }

    private void selectAllItems(boolean selected) {
        if (selected) {
            lstalumnos.setSelectionInterval(0, listModel3.size() - 1);
        } else {
            lstalumnos.clearSelection();
        }
    }

    private void llenar(Modelo.Instrumento i, int fila) {
//        int filaSeleccionada = tbldato.getSelectedRow();
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
        i.setIdusu((int) tbldato.getValueAt(fila, 13));
    }

    private void guardar_Tabla() {
        Modelo.Instrumento i = new Modelo.Instrumento();
        List<Modelo.Instrumento> instrumentos = new ArrayList<>();

        for (int filaa = 0; filaa < tbldato.getRowCount(); filaa++) {
            llenar(i, filaa); // Llenar el objeto Instrumento con los datos de la fila actual
            instrumentos.add(i); // Agregar el objeto Instrumento a la lista
        }
//        fi.guardar(instrumentos); // Guardar los datos en la base de datos
    }

    private void Mostar_En_Tabla() {
        String valorar = (String) cboarea.getSelectedItem();
        String are = txtarea.getText();
        String moti = txtmotivo.getText();
        String osb = txtobs.getText();
        String fe = fecha.getFecha(txtfecha);
        String at = (String) cboatencion.getSelectedItem();
        String aten = txtatencion.getText();
        String valorpro = (String) cboprograma.getSelectedItem();
        String prog = (String) cboprograma.getSelectedItem();
        String turn = (String) cboturno.getSelectedItem();
        String cic = (String) cbociclo.getSelectedItem();
        tdatos1.setRowCount(0);
        List<String> selectedItems = lstalumnos.getSelectedValuesList();
        for (int i = 0; i < selectedItems.size(); i++) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(selectedItems.get(i)); // Elemento seleccionado
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
//            rowData.add(profes);
            tdatos1.addRow(rowData);
        }
    }

    private void updateCharacterCount(int currentLength) {
        int remainingCharacters = 150 - currentLength;
        txtcontador.setText("Caracteres restantes: " + remainingCharacters);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        txtprograma = new app.bolivia.swing.JCTextField();
        panelficha = new javax.swing.JPanel();
        btnalumnos = new com.icm.components.metro.ButtonMetroICM();
        chktodos = new com.icm.components.metro.CheckBoxMetroICM();
        btngrabar = new com.icm.components.metro.ButtonMetroICM();
        btnnuevo = new com.icm.components.metro.ButtonMetroICM();
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
        cbociclo = new com.icm.components.metro.ComboboxMetroICM();
        cboturno = new com.icm.components.metro.ComboboxMetroICM();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboatencion = new com.icm.components.metro.ComboboxMetroICM();
        txtatencion = new javax.swing.JTextField();
        txtcontador = new javax.swing.JLabel();
        cboprograma = new com.icm.components.metro.ComboboxMetroICM();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldato = new rojeru_san.complementos.RSTableMetro();
        jLabel15 = new javax.swing.JLabel();
        lblp = new javax.swing.JLabel();
        txtturno = new javax.swing.JLabel();
        txtciclo = new javax.swing.JLabel();
        lbl_guardado_exito = new javax.swing.JLabel();
        lbl_msg_boton = new javax.swing.JLabel();

        txtprograma.setEditable(false);
        txtprograma.setBackground(new java.awt.Color(255, 255, 255));
        txtprograma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtprograma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtprograma.setSelectionColor(new java.awt.Color(153, 204, 255));

        setBackground(new java.awt.Color(0, 153, 204));
        setLayout(new java.awt.GridBagLayout());

        panelficha.setBackground(new java.awt.Color(255, 255, 255));
        panelficha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelfichaMouseClicked(evt);
            }
        });
        panelficha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnalumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-búsqueda-30.png"))); // NOI18N
        btnalumnos.setText(" Alumnos:");
        btnalumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnalumnosMouseClicked(evt);
            }
        });
        btnalumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalumnosActionPerformed(evt);
            }
        });
        panelficha.add(btnalumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 100, 40));

        chktodos.setText("Seleccionar todo");
        chktodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chktodosActionPerformed(evt);
            }
        });
        panelficha.add(chktodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 390, -1, 39));

        btngrabar.setText("Guardar");
        btngrabar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btngrabar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btngrabarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btngrabarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btngrabarMouseExited(evt);
            }
        });
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });
        panelficha.add(btngrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 180, -1));

        btnnuevo.setText("Nuevo");
        btnnuevo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnnuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnnuevoMouseClicked(evt);
            }
        });
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        panelficha.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 180, -1));

        lstalumnos.setVisibleRowCount(32);
        jScrollPane2.setViewportView(lstalumnos);

        panelficha.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 30, 270, 360));

        txtobs.setColumns(8);
        txtobs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtobs.setRows(2);
        txtobs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtobsKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtobs);

        panelficha.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 530, 110));

        jLabel3.setText("Observación");
        panelficha.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 10));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelficha.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 130));

        txtarea.setEditable(false);
        txtarea.setBackground(new java.awt.Color(255, 255, 255));
        panelficha.add(txtarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 230, -1));

        txtmotivo.setEditable(false);
        txtmotivo.setBackground(new java.awt.Color(255, 255, 255));
        panelficha.add(txtmotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 280, -1));

        cbomotivo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbomotivoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panelficha.add(cbomotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 280, 30));

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

        jLabel11.setText("Alumnos");
        panelficha.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 180, 20));

        cbociclo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbocicloPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbociclo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbocicloMouseClicked(evt);
            }
        });
        panelficha.add(cbociclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 120, -1));

        cboturno.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboturnoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cboturno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboturnoMouseClicked(evt);
            }
        });
        panelficha.add(cboturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 160, -1));

        jLabel5.setText("Programa de Estudio");
        panelficha.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel6.setText("Turnos");
        panelficha.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel7.setText("Semestre");
        panelficha.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

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
        panelficha.add(txtcontador, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 200, 20));

        cboprograma.setMaximumRowCount(10);
        cboprograma.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboprogramaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panelficha.add(cboprograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 290, -1));

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
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tbldato.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbldato.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbldato.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tbldato);

        panelficha.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1290, 420));

        jLabel15.setText("Fecha");
        panelficha.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, -1, -1));
        panelficha.add(lblp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 260, 20));
        panelficha.add(txtturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 160, 20));
        panelficha.add(txtciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 100, 20));
        panelficha.add(lbl_guardado_exito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 480, 80));
        panelficha.add(lbl_msg_boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 180, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 14, 21);
        add(panelficha, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnalumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnalumnosMouseClicked
        String progra = (String) cboprograma.getSelectedItem();
        String turn = (String) cboturno.getSelectedItem();
        String cic = (String) cbociclo.getSelectedItem();
        if (progra.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Programa de Estudio!");
            return;
        }
        if (progra.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta que cargue el Programa de Estudio", "Campo Vacio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (turn.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Turno");
            txtturno.setText("Seleccione un Turno");
            txtturno.setForeground(java.awt.Color.RED);
            return;
        }
        if (cic.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Ciclo");
            txtciclo.setText("Seleccione un ciclo");
            txtciclo.setForeground(java.awt.Color.RED);
        } else {
            BuscarAlumno_admin bu = new BuscarAlumno_admin(null, true);
            bu.setVisible(true);
            listModel3.clear();
//            seleccionar.setSelected(false);
            alum.mostraralu(listModel3, progra, turn, cic);

        }
    }//GEN-LAST:event_btnalumnosMouseClicked

    private void chktodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chktodosActionPerformed
        selectAllItems(chktodos.isSelected());
    }//GEN-LAST:event_chktodosActionPerformed

    private void btngrabarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btngrabarMouseClicked
        String data12 = (String) cbociclo.getSelectedItem();
        String data2 = txtarea.getText();
        String dato14 = (String) lstalumnos.getSelectedValue();
        if (dato14 == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Faltan seleccionar todos los alumnos", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtfecha.getDate() == null || txtfecha.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Seleccione una fecha.", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String data3 = txtmotivo.getText();
        if (data3.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, Seleccione un Motivo.", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String aten = (String) cboatencion.getSelectedItem();
        if (aten.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, Seleccione la Atención.", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (data2.isEmpty() || data12.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String obs1 = txtobs.getText();
        if (obs1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, Escriba su Observación", "Falta Datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int guardar = JOptionPane.showConfirmDialog(null, "Deseas Grabar", "Grabar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            btngrabar.setEnabled(false);
            Thread operacionesThread = new Thread(() -> {
//                String p = lbltutor.getText();
                Mostar_En_Tabla();
                String g = "<html>"
                        + "<body>"
                        + "<h1>Registro Guardado Exitosamente!<h1>"
                        + "<p>Te recordamos que es una prueba <p>"
                        + "<p>No guardaremos en la Base de Datos. <p>"
                        + "</body>"
                        + "</html>";
                lbl_guardado_exito.setText(g);
                lbl_guardado_exito.setForeground(new Color(64, 64, 64));
//                limpiartabla1();
//                //                lstalumnos.clearSelection();
////                fi.mostrar(tdatos1,p);
//                String Titulos[] = {"Nombre y Apellido", "Area", "Motivo", "Obsr", "Fecha", "Atencion", "P.E.", "Turno", "Ciclo", "Tutor"};
//                tdatos1.setColumnIdentifiers(Titulos);
//                tbldato.getColumnModel().getColumn(0).setPreferredWidth(20);
//                tbldato.getColumnModel().getColumn(1).setPreferredWidth(40);
//                tbldato.getColumnModel().getColumn(2).setPreferredWidth(20);
//                tbldato.getColumnModel().getColumn(3).setPreferredWidth(100);
//                tbldato.getColumnModel().getColumn(4).setPreferredWidth(20);
//                tbldato.getColumnModel().getColumn(5).setPreferredWidth(25);
//                tbldato.getColumnModel().getColumn(6).setPreferredWidth(40);
//                tbldato.getColumnModel().getColumn(7).setPreferredWidth(5);
//                tbldato.getColumnModel().getColumn(8).setPreferredWidth(2);
//                tbldato.getColumnModel().getColumn(9).setPreferredWidth(30);
            });
            // Iniciar el hilo
            operacionesThread.start();
        }
    }//GEN-LAST:event_btngrabarMouseClicked

    private void btngrabarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btngrabarMouseEntered
        if (!btngrabar.isEnabled()) {
            // Mostrar el mensaje cuando el mouse entra en el área del botón
            lbl_msg_boton.setText("Limpia para nuevo registro");
        }
    }//GEN-LAST:event_btngrabarMouseEntered

    private void btngrabarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btngrabarMouseExited
        lbl_msg_boton.setText("");
    }//GEN-LAST:event_btngrabarMouseExited

    private void btnnuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevoMouseClicked
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea Limpiar los campos?", "Limpiar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            lbl_guardado_exito.setText("");
            btngrabar.setEnabled(true);
            lstalumnos.setListData(new String[0]);
            lstalumnos.repaint();
//            txtprofe.setText("");
            txtarea.setText("");
            cboarea.setSelectedItem("Seleccionar");
            cbomotivo.setSelectedIndex(-1);
            txtmotivo.setText("");
            cboatencion.setSelectedItem("Seleccionar");
            txtfecha.setDate(null);
            txtobs.setText("");
            updateCharacterCount(0);
            txtatencion.setText("");
            chktodos.setSelected(false);
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
        } else {
        }
    }//GEN-LAST:event_btnnuevoMouseClicked

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnnuevoActionPerformed

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
            txtfecha.setFocusable(false);
        } else {
            //            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            //                @Override
            //                protected Void doInBackground() throws Exception {
            //                    // Realizar la operación en segundo plano
            //                    mo.motivo1(combo5, valor1);
            //                    return null;
            //                }
            //
            //                @Override
            //                protected void done() {
            //                    try {
            // Actualizar la interfaz de usuario en el hilo de despacho de eventos de Swing (EDT)
            cbomotivo.setSelectedItem("Seleccionar");
            cbomotivo.removeAllItems();
            cbomotivo.setEnabled(true);
            txtarea.setText(valor1);
            txtmotivo.setText("");
            mo.motivo1(combo5, valor1);
            //                    } catch (Exception ex) {
            //                        ex.printStackTrace();
            //                    }
            //                }
            //            };
            //            worker.execute(); // Ejecutar el SwingWorker en segundo plano
        }
    }//GEN-LAST:event_cboareaPopupMenuWillBecomeInvisible

    private void cbocicloPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbocicloPopupMenuWillBecomeInvisible
        String valor17 = (String) cbociclo.getSelectedItem();
        if (valor17.equals("Seleccionar")) {
            txtfecha.setFocusable(false);
            //            txtbuscarprofe.setEnabled(false);
            //            txtbuscarprofe.setText("");
        } else {
            //            txtbuscarprofe.setEnabled(true);
            //            txtbuscarprofe.setText("");
            //            txtbuscarprofe.requestFocus();
        }
    }//GEN-LAST:event_cbocicloPopupMenuWillBecomeInvisible

    private void cbocicloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbocicloMouseClicked
        txtciclo.setText("");
    }//GEN-LAST:event_cbocicloMouseClicked

    private void cboturnoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboturnoPopupMenuWillBecomeInvisible
        String valor16 = (String) cboturno.getSelectedItem();
        if (valor16.equals("Seleccionar")) {
            cbociclo.setEnabled(false);
            cbociclo.setSelectedItem("Seleccionar");
            txtfecha.setFocusable(false);
            ////            txtturno.setText("");
            ////            txtci.setText("");
        } else {
            cbociclo.removeAllItems();
            cbociclo.setEnabled(true);
            cbociclo.setSelectedItem("Seleccionar");
            Thread operacionesThread = new Thread(() -> {
                ci.ciclo(combo3);
            });
            operacionesThread.start();

        }
    }//GEN-LAST:event_cboturnoPopupMenuWillBecomeInvisible

    private void cboturnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboturnoMouseClicked
        txtturno.setText("");
    }//GEN-LAST:event_cboturnoMouseClicked

    private void cboatencionPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboatencionPopupMenuWillBecomeInvisible
        String valor22 = (String) cboatencion.getSelectedItem();
        if (valor22.equals("Seleccionar")) {
            txtatencion.setText("");
        } else {
            txtatencion.setText(valor22);
        }
    }//GEN-LAST:event_cboatencionPopupMenuWillBecomeInvisible

    private void panelfichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelfichaMouseClicked
//        jPopupMenu1.setVisible(false);
    }//GEN-LAST:event_panelfichaMouseClicked

    private void cboprogramaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboprogramaPopupMenuWillBecomeInvisible
        String valor15 = (String) cboprograma.getSelectedItem();
        if (valor15.equals("Seleccionar")) {

            cboturno.setSelectedItem("Seleccionar");
            cbociclo.setSelectedItem("Seleccionar");
            cboturno.setEnabled(false);
            cbociclo.setEnabled(false);
            txtturno.setText("");
            txtfecha.setFocusable(false);
            chktodos.setSelected(false);
            selectAllItems(chktodos.isSelected());
        } else {

            cboturno.removeAllItems();
            cboturno.setSelectedItem("Seleccionar");
            tur.Turno(combo2, valor15);
            cbociclo.setEnabled(false);
            cbociclo.setSelectedItem("Seleccionar");
            cboturno.setEnabled(true);
            txtturno.setText("");
            lstalumnos.setListData(new String[0]);
            lstalumnos.repaint();
            chktodos.setSelected(false);
            selectAllItems(chktodos.isSelected());
        }
    }//GEN-LAST:event_cboprogramaPopupMenuWillBecomeInvisible

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        String data2 = txtarea.getText();
        String dato14 = (String) lstalumnos.getSelectedValue();
        if (dato14 == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Faltan seleccionar todos los alumnos", "Falta Datos", JOptionPane.ERROR_MESSAGE, iconoalumno);
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

        int guardar = JOptionPane.showConfirmDialog(null, "Deseas Grabar", "Grabar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            btngrabar.setEnabled(false);
//            String p = lbltutor.getText();
            Mostar_En_Tabla();
            String g = "<html>"
                    + "<body>"
                    + "<p>Registro Guardado Exitosamente!"
                    + "<br>"
                    + "Te recordamos que es una prueba"
                    + "<br>"
                    + "No guardaremos en la Base de Datos. </p>"
                    + "</body>"
                    + "</html>";
            lbl_guardado_exito.setText(g);
            lbl_guardado_exito.setForeground(new Color(64, 64, 64));

        }
    }//GEN-LAST:event_btngrabarActionPerformed

    private void btnalumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnalumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.icm.components.metro.ButtonMetroICM btnalumnos;
    private com.icm.components.metro.ButtonMetroICM btngrabar;
    private com.icm.components.metro.ButtonMetroICM btnnuevo;
    private com.icm.components.metro.ComboboxMetroICM cboarea;
    private com.icm.components.metro.ComboboxMetroICM cboatencion;
    public static com.icm.components.metro.ComboboxMetroICM cbociclo;
    private com.icm.components.metro.ComboboxMetroICM cbomotivo;
    public static com.icm.components.metro.ComboboxMetroICM cboprograma;
    public static com.icm.components.metro.ComboboxMetroICM cboturno;
    public static com.icm.components.metro.CheckBoxMetroICM chktodos;
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
    private javax.swing.JLabel lblp;
    public static com.icm.components.metro.ListMetroICM lstalumnos;
    private javax.swing.JPanel panelficha;
    private rojeru_san.complementos.RSTableMetro tbldato;
    private javax.swing.JTextField txtarea;
    private javax.swing.JTextField txtatencion;
    private javax.swing.JLabel txtciclo;
    private javax.swing.JLabel txtcontador;
    private com.toedter.calendar.JDateChooser txtfecha;
    private javax.swing.JTextField txtmotivo;
    private javax.swing.JTextArea txtobs;
    public static app.bolivia.swing.JCTextField txtprograma;
    private javax.swing.JLabel txtturno;
    // End of variables declaration//GEN-END:variables
}
