/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableRowSorter;
import static org.example.Informacion.cargarDatos;
import static org.example.Informacion.listaParticulares;
import static org.example.Informacion.listaRestaurantes;

/**
 *
 * @author david
 */
public class VentanaPrincipalParticular extends javax.swing.JFrame {

    private int cpUsuario;
    DefaultTableModel rt = new DefaultTableModel();

    TableRowSorter<DefaultTableModel> rtSorter;

    /**
     * Creates new form VentanaPrincipalParticulares
     */
    //List<Restaurante> listaRestaurantes = new ArrayList<>();
    public VentanaPrincipalParticular() {
        initComponents();

        String idsRestaurantes[] = {"Nombre", "CIF", "Especialidad", "Calificacion", "Gastos de envío", "Tiempo de envío", "Catering", "Dirección", "Codigo Postal", "Menu"}; //Dirección es un objeto
        rt.setColumnIdentifiers(idsRestaurantes);
        jTableRestaurantes.setModel(rt);
        jTableRestaurantes.setAutoCreateRowSorter(true);
        rtSorter = new TableRowSorter<>(rt);
        jTableRestaurantes.setRowSorter(rtSorter);
        // Crear el TableModelListener ESTO ES LO QUE GUARDA LAS MODIFICACIONES DE LOS RESTAURANTES
        TableModelListener tableModelListenerRT = new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int fila = e.getFirstRow();
                    int columna = e.getColumn();

                    if (fila != -1 && columna != -1) {
                        // Obtener los datos modificados de la tabla
                        String nombreModificado = rt.getValueAt(fila, 0).toString();
                        String especialidadModificada = rt.getValueAt(fila, 2).toString();
                        double gastosEnvioModificados = Double.parseDouble(rt.getValueAt(fila, 4).toString());
                        int tiempoEnvioModificado = Integer.parseInt(rt.getValueAt(fila, 5).toString());
                        String cifModificado = rt.getValueAt(fila, 1).toString();

                        // Obtener la instancia de Restaurante correspondiente
                        Restaurante restaurante = listaRestaurantes.get(fila);

                        // Actualizar los atributos individuales del restaurante
                        restaurante.setNombre(nombreModificado);
                        restaurante.setEspecialidad(especialidadModificada);

                        restaurante.setGastosEnvio(gastosEnvioModificados);
                        restaurante.setTiempoEnvio(tiempoEnvioModificado);
                        restaurante.setCif(cifModificado);

                        // Guardar los datos actualizados
                        Informacion.guardarDatos();
                        System.out.println("Se han guardado los restaurantes.");
                    }
                }

            }

        };
        String mensajeBienvenida = "";
        String correoUsuario = "";

        if (UsuarioActual.getCorreo() != null) {
            correoUsuario = UsuarioActual.getCorreo();

            for (Particular particular : listaParticulares) {
                if (correoUsuario != null && correoUsuario.equals(particular.getCorreo())) {
                    Direccion direccion = particular.getDireccion();
                    int cpUsuario = direccion.getCp();
                    String nombreUsuario = particular.getNombre();

                    mensajeBienvenida = "¡Bienvenido " + nombreUsuario + ", Dios te tenga en su seno!";
                    txtBienvenida.setText(mensajeBienvenida);

                    break;
                }
            }
        }

// Asociar el TableModelListener al modelo de la tabla
        rt.addTableModelListener(tableModelListenerRT);

        List<Restaurante> tablaRestaurantes = Informacion.getListaRestaurantes();

        for (Restaurante restaurante : tablaRestaurantes) {
            String nombre = restaurante.getNombre();
            String especialidad = restaurante.getEspecialidad();
            double calificacion = restaurante.getCalificacion();
            double gastosEnvio = restaurante.getGastosEnvio();
            int tiempoEnvio = restaurante.getTiempoEnvio();
            String CIF = restaurante.getCif();

            boolean tieneCatering = restaurante.getCatering().isTieneCatering();
            String comidaCatering = restaurante.getCatering().getComidaCatering();
            double precioInicialComida = restaurante.getCatering().getPrecio();

            Catering catering = new Catering(tieneCatering, comidaCatering, precioInicialComida);
            String ciudad = restaurante.getDireccion().getCiudad();
            int cp = restaurante.getDireccion().getCp();
            String calle = restaurante.getDireccion().getCalle();
            int numero = restaurante.getDireccion().getNumero();
            Direccion direccion = new Direccion(calle, numero, cp, ciudad);

            List<Comida> listaComidas = restaurante.getListaComidas();
            System.out.println("Nombre:" + nombre);
            rt.addRow(new Object[]{nombre, CIF, especialidad, calificacion, gastosEnvio, tiempoEnvio, catering, direccion, cp, listaComidas});

// Crea un editor de celdas personalizado que no permite la edición
            TableCellEditor nonEditableEditor = new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject e) {
                    return false;
                }
            };

        }
    }

    public int getCpParticularActual() {
        String correoUsuario = "";
        int cpUsuario = 0; // Declarar la variable cpUsuario fuera del bloque if

        if (UsuarioActual.getCorreo() != null) {
            correoUsuario = UsuarioActual.getCorreo();

            for (Particular particular : listaParticulares) {
                if (correoUsuario != null && correoUsuario.equals(particular.getCorreo())) {
                    Direccion direccion = particular.getDireccion();
                    cpUsuario = direccion.getCp(); // Asignar el valor a cpUsuario dentro del if
                }
            }
        }
        return cpUsuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu8 = new javax.swing.JMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jFileChooser1 = new javax.swing.JFileChooser();
        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu18 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        jMenuBar8 = new javax.swing.JMenuBar();
        jMenu20 = new javax.swing.JMenu();
        jMenu21 = new javax.swing.JMenu();
        jMenuBar9 = new javax.swing.JMenuBar();
        jMenu22 = new javax.swing.JMenu();
        jMenu23 = new javax.swing.JMenu();
        jMenuBar10 = new javax.swing.JMenuBar();
        jMenu24 = new javax.swing.JMenu();
        jMenu25 = new javax.swing.JMenu();
        jMenuBar11 = new javax.swing.JMenuBar();
        jMenu26 = new javax.swing.JMenu();
        jMenu27 = new javax.swing.JMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        botonActualizar = new javax.swing.JButton();
        tab = new javax.swing.JTabbedPane();
        Fondo = new javax.swing.JPanel();
        panelInfoRestaurantes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtBienvenida = new javax.swing.JLabel();
        botoAnadirResena = new javax.swing.JButton();
        panelListaRestaurantes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRestaurantes = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu28 = new javax.swing.JMenu();
        botonTodosMenuRestaurante = new javax.swing.JRadioButtonMenuItem();
        cbFiltrarCercania = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        cbTurca = new javax.swing.JRadioButtonMenuItem();
        cbEspanola = new javax.swing.JRadioButtonMenuItem();
        cbItaliana = new javax.swing.JRadioButtonMenuItem();
        cbAmericana = new javax.swing.JRadioButtonMenuItem();
        cbAsiatica = new javax.swing.JRadioButtonMenuItem();
        cbMexicana = new javax.swing.JRadioButtonMenuItem();
        jMenu29 = new javax.swing.JMenu();
        jMenu30 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        cbCambiarCorreo = new javax.swing.JMenuItem();
        cbDireccion = new javax.swing.JMenuItem();
        cbTarjeta = new javax.swing.JMenuItem();
        cbCerrarSesion = new javax.swing.JRadioButtonMenuItem();

        jMenu1.setText("jMenu1");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("jMenu7");

        jMenu8.setText("jMenu8");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu4.setText("File");
        jMenuBar3.add(jMenu4);

        jMenu9.setText("Edit");
        jMenuBar3.add(jMenu9);

        jMenu10.setText("File");
        jMenuBar4.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar4.add(jMenu11);

        jMenu12.setText("jMenu12");

        jMenu13.setText("File");
        jMenuBar5.add(jMenu13);

        jMenu14.setText("Edit");
        jMenuBar5.add(jMenu14);

        jMenu15.setText("File");
        jMenuBar6.add(jMenu15);

        jMenu16.setText("Edit");
        jMenuBar6.add(jMenu16);

        jMenu17.setText("jMenu17");

        jMenu18.setText("File");
        jMenuBar7.add(jMenu18);

        jMenu19.setText("Edit");
        jMenuBar7.add(jMenu19);

        jMenu20.setText("File");
        jMenuBar8.add(jMenu20);

        jMenu21.setText("Edit");
        jMenuBar8.add(jMenu21);

        jMenu22.setText("File");
        jMenuBar9.add(jMenu22);

        jMenu23.setText("Edit");
        jMenuBar9.add(jMenu23);

        jMenu24.setText("File");
        jMenuBar10.add(jMenu24);

        jMenu25.setText("Edit");
        jMenuBar10.add(jMenu25);

        jMenu26.setText("File");
        jMenuBar11.add(jMenu26);

        jMenu27.setText("Edit");
        jMenuBar11.add(jMenu27);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        botonActualizar.setText("Cargar datos");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Acceder ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtBienvenida.setText("Bienvenido");

        botoAnadirResena.setBackground(new java.awt.Color(255, 153, 153));
        botoAnadirResena.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botoAnadirResena.setText("Añadir Reseña");
        botoAnadirResena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoAnadirResenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoRestaurantesLayout = new javax.swing.GroupLayout(panelInfoRestaurantes);
        panelInfoRestaurantes.setLayout(panelInfoRestaurantesLayout);
        panelInfoRestaurantesLayout.setHorizontalGroup(
            panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botoAnadirResena, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        panelInfoRestaurantesLayout.setVerticalGroup(
            panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botoAnadirResena)
                    .addComponent(txtBienvenida))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTableRestaurantes.setDefaultEditor(Object.class, null);
        jTableRestaurantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableRestaurantes);

        javax.swing.GroupLayout panelListaRestaurantesLayout = new javax.swing.GroupLayout(panelListaRestaurantes);
        panelListaRestaurantes.setLayout(panelListaRestaurantesLayout);
        panelListaRestaurantesLayout.setHorizontalGroup(
            panelListaRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRestaurantesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelListaRestaurantesLayout.setVerticalGroup(
            panelListaRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRestaurantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelListaRestaurantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInfoRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(panelInfoRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelListaRestaurantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Restaurantes", Fondo);

        jMenu2.setText("Filtro");

        jMenu28.setText("Restaurantes");

        botonTodosMenuRestaurante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        botonTodosMenuRestaurante.setText("Quitar filtros");
        botonTodosMenuRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTodosMenuRestauranteActionPerformed(evt);
            }
        });
        jMenu28.add(botonTodosMenuRestaurante);

        cbFiltrarCercania.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cbFiltrarCercania.setSelected(true);
        cbFiltrarCercania.setText("Solo Cercanos");
        cbFiltrarCercania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltrarCercaniaActionPerformed(evt);
            }
        });
        jMenu28.add(cbFiltrarCercania);

        jMenu3.setText("Especialidad");

        cbTurca.setText("Turca");
        cbTurca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurcaActionPerformed(evt);
            }
        });
        jMenu3.add(cbTurca);

        cbEspanola.setText("Española");
        cbEspanola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspanolaActionPerformed(evt);
            }
        });
        jMenu3.add(cbEspanola);

        cbItaliana.setText("Italiana");
        cbItaliana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbItalianaActionPerformed(evt);
            }
        });
        jMenu3.add(cbItaliana);

        cbAmericana.setText("Americana");
        cbAmericana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAmericanaActionPerformed(evt);
            }
        });
        jMenu3.add(cbAmericana);

        cbAsiatica.setText("Asiática");
        cbAsiatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAsiaticaActionPerformed(evt);
            }
        });
        jMenu3.add(cbAsiatica);

        cbMexicana.setText("Mexicana");
        cbMexicana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMexicanaActionPerformed(evt);
            }
        });
        jMenu3.add(cbMexicana);

        jMenu28.add(jMenu3);

        jMenu2.add(jMenu28);

        jMenuBar1.add(jMenu2);

        jMenu29.setText("Ajustes");

        jMenu30.setText("Cambiar Datos perfil");

        jMenuItem2.setText("Cambiar contraseña");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu30.add(jMenuItem2);

        cbCambiarCorreo.setText("Cambiar correo");
        cbCambiarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCambiarCorreoActionPerformed(evt);
            }
        });
        jMenu30.add(cbCambiarCorreo);

        cbDireccion.setText("Cambiar dirección");
        cbDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDireccionActionPerformed(evt);
            }
        });
        jMenu30.add(cbDireccion);

        cbTarjeta.setText("Cambiar tarjeta");
        cbTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTarjetaActionPerformed(evt);
            }
        });
        jMenu30.add(cbTarjeta);

        jMenu29.add(jMenu30);

        cbCerrarSesion.setText("Cerrar Sesion");
        cbCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCerrarSesionActionPerformed(evt);
            }
        });
        jMenu29.add(cbCerrarSesion);

        jMenuBar1.add(jMenu29);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 430, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(666, 666, 666))
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

    }//GEN-LAST:event_botonActualizarActionPerformed

    private void cbTurcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurcaActionPerformed

        boolean selected = cbTurca.isSelected();
        filterTableByEspecialidad("Turca", selected, rtSorter);
        desmarcarTodasLasEspecialidades();
    }//GEN-LAST:event_cbTurcaActionPerformed

    private void cbEspanolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspanolaActionPerformed

        boolean selected = cbEspanola.isSelected();
        filterTableByEspecialidad("Española", selected, rtSorter);
        desmarcarTodasLasEspecialidades();
    }//GEN-LAST:event_cbEspanolaActionPerformed

    private void cbItalianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbItalianaActionPerformed

        boolean selected = cbItaliana.isSelected();
        filterTableByEspecialidad("Italiana", selected, rtSorter);
        desmarcarTodasLasEspecialidades();
        // TODO add your handling code here:
    }//GEN-LAST:event_cbItalianaActionPerformed

    private void cbAmericanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAmericanaActionPerformed

        boolean selected = cbAmericana.isSelected();
        filterTableByEspecialidad("Americana", selected, rtSorter);
        desmarcarTodasLasEspecialidades();
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAmericanaActionPerformed

    private void cbAsiaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAsiaticaActionPerformed

        boolean selected = cbAsiatica.isSelected();
        filterTableByEspecialidad("Asiática", selected, rtSorter);
        desmarcarTodasLasEspecialidades();
    }//GEN-LAST:event_cbAsiaticaActionPerformed

    private void cbMexicanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMexicanaActionPerformed

        boolean selected = cbMexicana.isSelected();
        filterTableByEspecialidad("Mexicana", selected, rtSorter);
        desmarcarTodasLasEspecialidades();
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMexicanaActionPerformed

    private void botonTodosMenuRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTodosMenuRestauranteActionPerformed

        rtSorter.setRowFilter(null);
        desmarcarTodasLasEspecialidades();
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTodosMenuRestauranteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing


    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int indiceSeleccionado = obtenerIndiceSeleccionado();
        System.out.println(indiceSeleccionado);
        VentanaInfoRestaurante ventana = new VentanaInfoRestaurante(indiceSeleccionado);
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbFiltrarCercaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltrarCercaniaActionPerformed
        if (cbFiltrarCercania.isSelected()) {
            // Obtener el código postal del usuario actual
            int cpUsuario = getCpParticularActual();

            // Crear un RowFilter para filtrar las filas basado en los códigos postales
            RowFilter<Object, Object> filtroCercania = new RowFilter<Object, Object>() {
                @Override
                public boolean include(Entry<?, ?> entry) {
                    Object cpRestauranteObj = entry.getValue(8); // Índice 8 representa la columna de los códigos postales en jTableRestaurantes

                    if (cpRestauranteObj != null) {
                        String cpRestaurante = cpRestauranteObj.toString();

                        if (cpRestaurante.length() >= 4) {
                            String cpRestaurantePrimeraParte = cpRestaurante.substring(0, 4);

                            String cpUsuarioStr = String.valueOf(cpUsuario);

                            return cpUsuarioStr.startsWith(cpRestaurantePrimeraParte);
                        }
                    }

                    return false;
                }
            };

            // Aplicar el filtro al TableRowSorter
            rtSorter.setRowFilter(filtroCercania);
        } else {
            // Si el botón no está seleccionado, quitar cualquier filtro existente
            rtSorter.setRowFilter(null);
        }
    }//GEN-LAST:event_cbFiltrarCercaniaActionPerformed

    private void cbCambiarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCambiarCorreoActionPerformed
        String correoUsuario = UsuarioActual.getCorreo();

        for (Particular particular : listaParticulares) {
            if (correoUsuario.equals(particular.getCorreo())) {
                String nuevoCorreo = JOptionPane.showInputDialog(this, "Ingrese el nuevo correo electrónico:");

                if (nuevoCorreo != null) {
                    particular.setCorreo(nuevoCorreo);
                    Informacion.guardarDatos();
                    JOptionPane.showMessageDialog(this, "El correo electrónico ha sido actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se ingresó ningún correo electrónico. No se realizaron cambios.");
                }

                break;
            }
        }

    }//GEN-LAST:event_cbCambiarCorreoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ContrasenaOlvidadaParticular ventana = new ContrasenaOlvidadaParticular();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cbCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCerrarSesionActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de que quieres cerrar sesion?", "Confirmar compra", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            VentanaInicioSesion ventana = new VentanaInicioSesion();
            ventana.setVisible(true);
            dispose();
        } else {
            cbCerrarSesion.setSelected(false);

        }
    }//GEN-LAST:event_cbCerrarSesionActionPerformed

    private void cbDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDireccionActionPerformed
        String correoUsuario = UsuarioActual.getCorreo();

        for (Particular particular : listaParticulares) {
            if (correoUsuario.equals(particular.getCorreo())) {
                // Crear los componentes para el JOptionPane
                JTextField txtCalle = new JTextField(particular.getDireccion().getCalle());
                JTextField txtNumero = new JTextField(String.valueOf(particular.getDireccion().getNumero()));
                JTextField txtCP = new JTextField(String.valueOf(particular.getDireccion().getCp()));
                JTextField txtCiudad = new JTextField(particular.getDireccion().getCiudad());

                // Crear el panel para agregar los componentes
                JPanel panel = new JPanel();
                panel.add(new JLabel("Calle:"));
                panel.add(txtCalle);
                panel.add(new JLabel("Número:"));
                panel.add(txtNumero);
                panel.add(new JLabel("Código Postal:"));
                panel.add(txtCP);
                panel.add(new JLabel("Ciudad:"));
                panel.add(txtCiudad);

                // Mostrar el JOptionPane y obtener la opción seleccionada
                int opcion = JOptionPane.showConfirmDialog(this, panel, "Actualizar Dirección", JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {
                    // Obtener los valores ingresados por el usuario
                    String calle = txtCalle.getText();
                    int numero = Integer.parseInt(txtNumero.getText());
                    int cp = Integer.parseInt(txtCP.getText());
                    String ciudad = txtCiudad.getText();

                    // Crear una nueva instancia de Direccion con los valores actualizados
                    Direccion nuevaDireccion = new Direccion(calle, numero, cp, ciudad);
                    particular.setDireccion(nuevaDireccion);
                    Informacion.guardarDatos();
                    JOptionPane.showMessageDialog(this, "La dirección ha sido actualizada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se realizaron cambios en la dirección.");
                }

                break;
            }
        }
    }//GEN-LAST:event_cbDireccionActionPerformed

    private void cbTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTarjetaActionPerformed
 String correoUsuario = UsuarioActual.getCorreo();

    for (Particular particular : listaParticulares) {
        if (correoUsuario.equals(particular.getCorreo())) {
            // Crear los componentes para el JOptionPane
            JTextField txtNumeroTarjeta = new JTextField(String.valueOf(particular.getTarjeta().getNumeroTarjeta()));
            JTextField txtFechaExpiracion = new JTextField(particular.getTarjeta().getFechaExpiracion());
            JTextField txtCVV = new JTextField(String.valueOf(particular.getTarjeta().getCodigoSeguridad()));

            // Crear el panel para agregar los componentes
            JPanel panel = new JPanel();
            panel.add(new JLabel("Número de Tarjeta:"));
            panel.add(txtNumeroTarjeta);
            panel.add(new JLabel("Fecha de Expiración:"));
            panel.add(txtFechaExpiracion);
            panel.add(new JLabel("CVV:"));
            panel.add(txtCVV);

            // Mostrar el JOptionPane y obtener la opción seleccionada
            int opcion = JOptionPane.showConfirmDialog(this, panel, "Actualizar Tarjeta", JOptionPane.OK_CANCEL_OPTION);

            if (opcion == JOptionPane.OK_OPTION) {
                // Obtener los valores ingresados por el usuario
                int numeroTarjeta = Integer.parseInt(txtNumeroTarjeta.getText());
                String fechaExpiracion = txtFechaExpiracion.getText();
                int cvv = Integer.parseInt(txtCVV.getText());

                // Crear una nueva instancia de Tarjeta con los valores actualizados
                TarjetaCredito nuevaTarjeta = new TarjetaCredito(numeroTarjeta, fechaExpiracion, cvv);
                particular.setTarjeta(nuevaTarjeta);
                Informacion.guardarDatos();
                JOptionPane.showMessageDialog(this, "La tarjeta ha sido actualizada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se realizaron cambios en la tarjeta.");
            }

            break;
        }
    }

    }//GEN-LAST:event_cbTarjetaActionPerformed

    private void botoAnadirResenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoAnadirResenaActionPerformed
        // Obtener la fila seleccionada en el jTableRestaurantes
        int filaSeleccionada = jTableRestaurantes.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener el nombre del restaurante de la columna "Nombre"
            String nombreRestaurante = (String) rt.getValueAt(filaSeleccionada, 0); // El número 0 corresponde a la primera columna (Nombre)

            // Buscar el restaurante correspondiente en la lista de restaurantes
            Restaurante restauranteSeleccionado = null;
            for (Restaurante restaurante : Informacion.listaRestaurantes) {
                if (restaurante.getNombre().equals(nombreRestaurante)) {
                    restauranteSeleccionado = restaurante;
                    break;
                }
            }

            if (restauranteSeleccionado != null) {
                // Obtener el valor de la columna "Calificacion" como Double
                Double calificacion = (Double) rt.getValueAt(filaSeleccionada, 3); // El número 3 corresponde a la cuarta columna (Calificacion)

                // Mostrar cuadro de diálogo para ingresar la calificación
                String calificacionStr = JOptionPane.showInputDialog(this, "Ingrese la calificación (0-5):");

                try {
                    double nuevaCalificacion = Double.parseDouble(calificacionStr);

                    // Verificar que la calificación esté en el rango válido
                    if (nuevaCalificacion < 0 || nuevaCalificacion > 5) {
                        JOptionPane.showMessageDialog(this, "La calificación debe estar entre 0 y 5.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Agregar la nueva calificación a la lista de reseñas del restaurante
                        restauranteSeleccionado.agregarReseña(nuevaCalificacion);

                        // Calcular la nueva calificación promedio
                        double calificacionPromedio = restauranteSeleccionado.obtenerCalificacionPromedio();

                        JOptionPane.showMessageDialog(this, "Reseña agregada.\nCalificación promedio: " + calificacionPromedio, "Información", JOptionPane.INFORMATION_MESSAGE);

                        // Actualizar el valor en el modelo de la tabla
                        rt.setValueAt(calificacionPromedio, filaSeleccionada, 3); // El número 3 corresponde a la cuarta columna (Calificacion)
                        // Actualizar la calificación en el objeto Restaurante
                        restauranteSeleccionado.setCalificacion(calificacionPromedio);
                        // Guardar los datos actualizados

                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Ingrese una calificación válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Restaurante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un restaurante.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        Informacion.guardarDatos();
    }//GEN-LAST:event_botoAnadirResenaActionPerformed

    private void desmarcarTodasLasEspecialidades() {
        cbTurca.setSelected(false);
        cbEspanola.setSelected(false);
        cbItaliana.setSelected(false);
        cbAmericana.setSelected(false);
        cbAsiatica.setSelected(false);
        cbMexicana.setSelected(false);
    }

    private void filterTableByCatering(boolean selected, DefaultTableModel tableModel, JTable JTableRestaurantes) {
        TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) jTableRestaurantes.getRowSorter();
        if (!selected) {
            rowSorter.setRowFilter(null); // Si no está seleccionado, mostrar todas las filas
        } else {
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("true", 6);
            rowSorter.setRowFilter(rowFilter);
        }
    }

    private void filterTableByEspecialidad(String especialidad, boolean selected, TableRowSorter<DefaultTableModel> sorter) {
        if (!selected) {
            sorter.setRowFilter(null); // Si no está seleccionado, mostrar todas las filas
        } else {
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter(especialidad, 2);
            sorter.setRowFilter(rowFilter);
        }
    }

    private void filtrar(String texto) {
        TableRowSorter<DefaultTableModel> rtSorter = new TableRowSorter<>(rt);
        jTableRestaurantes.setRowSorter(rtSorter);
        RowFilter<DefaultTableModel, Object> rtFilter = RowFilter.regexFilter(texto);
        rtSorter.setRowFilter(rtFilter);

    }

    public int obtenerIndiceSeleccionado() {
        return jTableRestaurantes.getSelectedRow();
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalParticular.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalParticular.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalParticular.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalParticular.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalParticular().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton botoAnadirResena;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JRadioButtonMenuItem botonTodosMenuRestaurante;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButtonMenuItem cbAmericana;
    private javax.swing.JRadioButtonMenuItem cbAsiatica;
    private javax.swing.JMenuItem cbCambiarCorreo;
    private javax.swing.JRadioButtonMenuItem cbCerrarSesion;
    private javax.swing.JMenuItem cbDireccion;
    private javax.swing.JRadioButtonMenuItem cbEspanola;
    private javax.swing.JRadioButtonMenuItem cbFiltrarCercania;
    private javax.swing.JRadioButtonMenuItem cbItaliana;
    private javax.swing.JRadioButtonMenuItem cbMexicana;
    private javax.swing.JMenuItem cbTarjeta;
    private javax.swing.JRadioButtonMenuItem cbTurca;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu26;
    private javax.swing.JMenu jMenu27;
    private javax.swing.JMenu jMenu28;
    private javax.swing.JMenu jMenu29;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu30;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar10;
    private javax.swing.JMenuBar jMenuBar11;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JMenuBar jMenuBar8;
    private javax.swing.JMenuBar jMenuBar9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRestaurantes;
    private javax.swing.JPanel panelInfoRestaurantes;
    private javax.swing.JPanel panelListaRestaurantes;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JLabel txtBienvenida;
    // End of variables declaration//GEN-END:variables
}
