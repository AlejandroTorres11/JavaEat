/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableRowSorter;
import static org.example.Informacion.listaEmpresas;
import static org.example.Informacion.listaParticulares;
import static org.example.Informacion.listaRestaurantes;

/**
 * Parte mia
 *
 * @author david
 */
public final class VentanaInfoRestaurante extends javax.swing.JFrame {

    private String mensajeEmpresa;
    private int indiceSeleccionado;
    private Comida precioInicial;
    TableRowSorter<DefaultTableModel> sorter;
    DefaultTableModel mt = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter2;
    DefaultTableModel nt = new DefaultTableModel();

    ArrayList<Comida> carrito = new ArrayList<Comida>();

    Comida servicioCamareros = new Comida("Camareros", "servicio de camareros", 800.0);
    Comida decoracion = new Comida("Decoracion", "servicio de decoracion", 500.0);
    Comida cocineros = new Comida("Cocineros", "servicio de cocineros", 1000.0);
    Comida espacioPropio = new Comida("Espacio Propio", "Lugar de evento privado", 1000.0);

    Restaurante restaurante;

    /**
     * Creates new form VentanaInfoRestaurante
     */
    public Restaurante sacar(int indiceSeleccionado) {
        this.indiceSeleccionado = indiceSeleccionado;
        System.out.println(indiceSeleccionado);
        initComponents();
        restaurante = listaRestaurantes.get(indiceSeleccionado);
        return restaurante;
    }

    public VentanaInfoRestaurante(int indiceSeleccionado) {
        this.indiceSeleccionado = indiceSeleccionado;
        initComponents();
        restaurante = listaRestaurantes.get(indiceSeleccionado);

        PrecioTotalLabel.setText("0.00€");
        String nombre = restaurante.getNombre();
        String especialidad = restaurante.getEspecialidad();
        Direccion direccion = restaurante.getDireccion();
        int tiempoEnvio = restaurante.getTiempoEnvio();
        double gastoEnvio = restaurante.getGastosEnvio();
        double calificacion = restaurante.getCalificacion();
        Boolean catering = restaurante.getCatering().isTieneCatering();
        double precioCatering = restaurante.getCatering().getPrecio();
        String comidaCatering = restaurante.getCatering().getComidaCatering();

        precioInicial = new Comida("Precio Inicial", "Precio base catering", precioCatering);

        String tipoUsuario = UsuarioActual.getTipoUsuario();

        if (tipoUsuario != null && tipoUsuario.equals("Empresa") && catering) {
            jPanelCatering.setVisible(true);
        } else {
            jPanelCatering.setVisible(false);
        }

        txtComidaCatering.setText(comidaCatering);
        txtPrecioCatering.setText(String.valueOf(precioCatering));

        String idsCarrito[] = {"Nombre", "cantidad", "precio"}; //Dirección es un objeto
        nt.setColumnIdentifiers(idsCarrito);
        jTable2.setModel(nt);
        jTable2.setAutoCreateRowSorter(true);
        sorter2 = new TableRowSorter<>(nt);
        jTable2.setRowSorter(sorter2);

        String idsMenu[] = {"Nombre", "Ingredientes", "precio"}; //Dirección es un objeto
        mt.setColumnIdentifiers(idsMenu);
        jTable1.setModel(mt);
        jTable1.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(mt);
        jTable1.setRowSorter(sorter);
        txtNombreRestaurante.setText(nombre);
        txtDireccion.setText(direccion.toString());
        txtTiempoEnvio.setText(Integer.toString(tiempoEnvio));
        txtGastosEnvio.setText(Double.toString(gastoEnvio));
        txtEspecialidad.setText(especialidad);
        txtCalificacion.setText(Double.toString(calificacion));
        System.out.println(restaurante);
        List<Comida> carta = restaurante.getListaComidas();
        for (Comida comida : carta) {
            String nombreComida = comida.getTitulo();
            String ingredientes = comida.getIngredientes();
            Double precio = comida.getPrecioVenta();
            System.out.println(comida);
            mt.addRow(new Object[]{nombreComida, ingredientes, precio + "€"});

        }

    }
    // Crea un editor de celdas personalizado que no permite la edición
    TableCellEditor nonEditableEditor = new DefaultCellEditor(new JTextField()) {
        @Override
        public boolean isCellEditable(EventObject e) {
            return false;
        }

    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreRestaurante = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        txtGastosEnvio = new javax.swing.JLabel();
        txtTiempoEnvio = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JLabel();
        jPanelCatering = new javax.swing.JPanel();
        txtCatering = new javax.swing.JLabel();
        txtServicio = new javax.swing.JLabel();
        camareroBox = new javax.swing.JCheckBox();
        cocineroBox = new javax.swing.JCheckBox();
        decoracionBox = new javax.swing.JCheckBox();
        espacioPropioBox = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtComidaCatering = new javax.swing.JLabel();
        txtPrecioCatering = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        PrecioTotalLabel = new javax.swing.JLabel();
        botonRealizarBoton = new javax.swing.JButton();
        botonVaciarCesta = new javax.swing.JButton();
        mensajeDescuentoTxt = new javax.swing.JLabel();
        Carrito = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jTable2.setEnabled(false);
        jScrollPane2.setViewportView(jTable2);

        jTable1.setDefaultEditor(Object.class, null);
        jScrollPane1.setViewportView(jTable1);

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Restaurante:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Especialidad:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Direccion:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Gastos Envio:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tiempo de Envio:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Calificacion:");

        txtNombreRestaurante.setText("Nombre de Restaurante");

        txtEspecialidad.setText("Especialidad");

        txtDireccion.setText("Direccion");

        txtGastosEnvio.setText("Gastos de envio");

        txtTiempoEnvio.setText("Tiempo de envio");

        txtCalificacion.setText("Calificacion");

        txtCatering.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCatering.setText("Catering");

        txtServicio.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtServicio.setText("Servicio a prestar");

        camareroBox.setText("Camareros(+800€)");
        camareroBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camareroBoxActionPerformed(evt);
            }
        });

        cocineroBox.setText("Cocinero (+1000€)");
        cocineroBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cocineroBoxActionPerformed(evt);
            }
        });

        decoracionBox.setText("Decoración (+500€)");
        decoracionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decoracionBoxActionPerformed(evt);
            }
        });

        espacioPropioBox.setText("Espacio Propio (+1000€)");
        espacioPropioBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espacioPropioBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Comida:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Precio Inicial:");

        txtComidaCatering.setText("txtComida");

        txtPrecioCatering.setText("txtPrecio");

        javax.swing.GroupLayout jPanelCateringLayout = new javax.swing.GroupLayout(jPanelCatering);
        jPanelCatering.setLayout(jPanelCateringLayout);
        jPanelCateringLayout.setHorizontalGroup(
            jPanelCateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCateringLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(espacioPropioBox)
                    .addGroup(jPanelCateringLayout.createSequentialGroup()
                        .addGroup(jPanelCateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCateringLayout.createSequentialGroup()
                                .addComponent(camareroBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(104, 104, 104))
                            .addComponent(cocineroBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(decoracionBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanelCateringLayout.createSequentialGroup()
                        .addGroup(jPanelCateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCatering)
                            .addComponent(txtServicio))
                        .addGap(32, 32, 32)
                        .addGroup(jPanelCateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCateringLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecioCatering))
                            .addGroup(jPanelCateringLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtComidaCatering))))))
        );
        jPanelCateringLayout.setVerticalGroup(
            jPanelCateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCateringLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCatering)
                    .addComponent(jLabel7)
                    .addComponent(txtComidaCatering))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServicio)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecioCatering))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(camareroBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cocineroBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decoracionBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(espacioPropioBox)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEspecialidad)
                            .addComponent(txtNombreRestaurante)
                            .addComponent(txtDireccion)
                            .addComponent(txtGastosEnvio)
                            .addComponent(txtCalificacion)
                            .addComponent(txtTiempoEnvio)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelCatering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreRestaurante))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEspecialidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGastosEnvio))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTiempoEnvio))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCalificacion))
                .addGap(27, 27, 27)
                .addComponent(jPanelCatering, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Precio total:");

        PrecioTotalLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PrecioTotalLabel.setText("jLabel7");

        botonRealizarBoton.setBackground(new java.awt.Color(255, 204, 51));
        botonRealizarBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonRealizarBoton.setText("Realizar Pedido");
        botonRealizarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarBotonActionPerformed(evt);
            }
        });

        botonVaciarCesta.setBackground(new java.awt.Color(255, 102, 102));
        botonVaciarCesta.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        botonVaciarCesta.setForeground(new java.awt.Color(255, 255, 255));
        botonVaciarCesta.setText("Vaciar cesta");
        botonVaciarCesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVaciarCestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PrecioTotalLabel))
                                    .addComponent(botonVaciarCesta)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(botonRealizarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(mensajeDescuentoTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(botonVaciarCesta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecioTotalLabel)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonRealizarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensajeDescuentoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Carrito.setBackground(new java.awt.Color(255, 204, 51));
        Carrito.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Carrito.setText("Añadir al carrito");
        Carrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonVolver)
                        .addGap(349, 349, 349)
                        .addComponent(Carrito)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver)
                    .addComponent(Carrito, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void camareroBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camareroBoxActionPerformed
        if (camareroBox.isSelected()) {

            anadirComida(servicioCamareros);
        } else {
            quitarComida(servicioCamareros);

        }
        actualizarPrecioInicial();
    }//GEN-LAST:event_camareroBoxActionPerformed

    private void CarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarritoActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        //Restaurante restaurante = listaRestaurantes.get(indiceSeleccionado);
        List<Comida> comidas = restaurante.getListaComidas();
        Comida comidaComprada = comidas.get(selectedRow);
        anadirComida(comidaComprada);
        for(Comida c: carrito){
            System.out.println("\n"+c);
        }
    }//GEN-LAST:event_CarritoActionPerformed
    public double precioTotalVenta;
    int rowCount = nt.getRowCount();
    int indice;
    public int detectorFila(Comida comida){
         // Obtener el número de filas en la tabla
         
    for (int i = 0; i < rowCount; i++) {
        Object dato= nt.getValueAt(i,1); // Obtener el valor de una celda en una fila específica (columna es el índice de la columna deseada)
        if(dato.equals(comida.getTitulo())){
                indice=i;
                break;
            }
        }
    return indice;
    }
    public int contadorCantidades(Comida comida, ArrayList<Comida> carrito) {
        int cantidad = 0;
        for (Comida c : carrito) {
            if (c.equals(comida)) {
                cantidad += 1;
            }
        }
        System.out.println("cantidad en funcion " +cantidad);
        return cantidad;
    }
    public ArrayList<Comida> listaIntermedia= new ArrayList<Comida>();
    public double anadirComida(Comida comida) {
        listaIntermedia.add(comida);
        if(carrito.contains(comida)){
            int cantidad= contadorCantidades(comida,listaIntermedia);
            int rowIndex = carrito.indexOf(comida); // Índice de la fila que deseas actualizar

            // Actualizar los datos en las columnas de la fila seleccionada
            nt.setValueAt(cantidad, rowIndex, 1); // Columna 0
            // Notificar al modelo que la fila ha sido modificada   
            nt.fireTableRowsUpdated(rowIndex, rowIndex);
        }
        else{
            carrito.add(comida);
            nt.addRow(new Object[]{comida.getTitulo(), contadorCantidades(comida,listaIntermedia), comida.getPrecioVenta() + "€"});
        }
        precioTotalVenta+=comida.getPrecioVenta();
        PrecioTotalLabel.setText(Double.toString(precioTotalVenta) + "€");
        return precioTotalVenta;
        /*
        if (carrito.contains(comida)) {
            int indiceFila = detectorFila(comida);
            System.out.println("\n el indice es" + indiceFila);
            
            nt.removeRow(indiceFila);
           
        }
        carrito.add(comida);
        nt.addRow(new Object[]{comida.getTitulo(), contadorCantidades(comida, carrito), comida.getPrecioVenta() + "€"});

        System.out.print("cantidad" + contadorCantidades(comida, carrito));
        
        precioTotalVenta += comida.getPrecioVenta();
        PrecioTotalLabel.setText(Double.toString(precioTotalVenta) + "€");
        return precioTotalVenta;
        */
    }

    public double quitarComida(Comida comida) {
        int indice = carrito.indexOf(comida);
        precioTotalVenta -= comida.getPrecioVenta();
        PrecioTotalLabel.setText(Double.toString(precioTotalVenta) + "€");
        carrito.remove(comida);
        nt.removeRow(indice);
        //System.out.println("el indice al sacar" + indice);
        return precioTotalVenta;
    }


    private void decoracionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decoracionBoxActionPerformed
        if (decoracionBox.isSelected()) {

            anadirComida(decoracion);
        } else {
            quitarComida(decoracion);
            //nt.removeRow(fila);
        }
        actualizarPrecioInicial();
    }//GEN-LAST:event_decoracionBoxActionPerformed

    private void cocineroBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cocineroBoxActionPerformed
        if (cocineroBox.isSelected()) {

            anadirComida(cocineros);
        } else {
            quitarComida(cocineros);
            //nt.removeRow(fila);
        }
        actualizarPrecioInicial();
    }//GEN-LAST:event_cocineroBoxActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        System.out.println(UsuarioActual.getTipoUsuario());
        if ("Empresa".equals(UsuarioActual.getTipoUsuario())) {
            VentanaPrincipalEmpresa ventana = new VentanaPrincipalEmpresa();
            ventana.setVisible(true);
            dispose();
        }
        if ("Particular".equals(UsuarioActual.getTipoUsuario())) {
            VentanaPrincipalParticular ventana = new VentanaPrincipalParticular();
            ventana.setVisible(true);
            dispose();

        }
        if ("Administrador".equals(UsuarioActual.getTipoUsuario())) {
            VentanaAdministrador ventana = new VentanaAdministrador();
            ventana.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonRealizarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRealizarBotonActionPerformed
        String correoUsuario = UsuarioActual.getCorreo();
        String tipoUsuario = UsuarioActual.getTipoUsuario();
        String numeroTarjetaCensurado = "";
        Direccion direccion;
        String nombreUsuario;
        if ("Particular".equals(tipoUsuario)) { // ("Particular".equals(tipoUsuario))
            // Buscar el cliente particular por su correo en la lista de particulares
            for (Particular particular : listaParticulares) {
                if (correoUsuario.equals(particular.getCorreo())) {
                    TarjetaCredito tarjeta = particular.getTarjeta();
                    int numeroTarjeta = tarjeta.getNumeroTarjeta();
                    numeroTarjetaCensurado = "**** **** **** " + numeroTarjeta % 10000; // Obtener los 4 últimos dígitos
                    break;
                }
            }
        } else if ("Empresa".equals(tipoUsuario)) {
            // Buscar el cliente empresa por su correo en la lista de empresas
            for (Empresa empresa : listaEmpresas) {
                if (correoUsuario.equals(empresa.getCorreo())) { //correoUsuario.equals(empresa.getCorreo())
                    TarjetaCredito tarjeta = empresa.getTarjeta();
                    int numeroTarjeta = tarjeta.getNumeroTarjeta();
                    numeroTarjetaCensurado = "**** **** **** " + numeroTarjeta % 10000; // Obtener los 4 últimos dígitos
                    precioTotalVenta = precioTotalVenta * 0.9;
                    String mensajeDescuento = "10% Descuento por empresa";
                    mensajeDescuentoTxt.setText(mensajeDescuento);
                    break;
                }
            }
        }
        if ("Empresa".equals(tipoUsuario)) {
            mensajeEmpresa = "\n ¡Descuento de 10% por empresa!";
        }
        if (mensajeEmpresa == null) {
            mensajeEmpresa = "";
        }
        String mensaje = "¿Estás seguro de que quieres realizar la compra?\nSe realizará con la tarjeta: " + numeroTarjetaCensurado + "\nY costara un total de:" + precioTotalVenta + mensajeEmpresa;
        int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Confirmar compra", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "mu bien ala ya has comprao");
            int numRows = nt.getRowCount();
            for (int i = numRows - 1; i >= 0; i--) {
                Comida comida = carrito.get(i);
                quitarComida(comida);
            }
            camareroBox.setSelected(false);
            cocineroBox.setSelected(false);
            decoracionBox.setSelected(false);
            espacioPropioBox.setSelected(false);
            Venta venta = new Venta(restaurante, carrito, conseguirNombre(correoUsuario), conseguirDireccion(correoUsuario), correoUsuario, numeroTarjetaCensurado);
            VentanaVenta ventanaVenta = new VentanaVenta(venta);
            ventanaVenta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Que entre la china");
        }
    }//GEN-LAST:event_botonRealizarBotonActionPerformed
    public String conseguirNombre(String correoUsuario) {
        String nombreUsuario = null;
        if (UsuarioActual.getCorreo() != null) {
            correoUsuario = UsuarioActual.getCorreo();
            for (Particular particular : listaParticulares) {
                if (correoUsuario != null && correoUsuario.equals(particular.getCorreo())) {

                    nombreUsuario = particular.getNombre();
                    break;
                }
            }
        }
        return nombreUsuario;
    }

    public Direccion conseguirDireccion(String correoUsuario) {
        Direccion direccion = null;
        if (UsuarioActual.getCorreo() != null) {
            correoUsuario = UsuarioActual.getCorreo();
            for (Particular particular : listaParticulares) {
                if (correoUsuario != null && correoUsuario.equals(particular.getCorreo())) {
                    direccion = particular.getDireccion();
                    break;
                }
            }
        }
        return direccion;
    }

    private void botonVaciarCestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVaciarCestaActionPerformed
        int numRows = nt.getRowCount();
        for (int i = numRows - 1; i >= 0; i--) {
            Comida comida = carrito.get(i);
            quitarComida(comida);
        }
        camareroBox.setSelected(false);
        cocineroBox.setSelected(false);
        decoracionBox.setSelected(false);
        espacioPropioBox.setSelected(false);

    }//GEN-LAST:event_botonVaciarCestaActionPerformed

    private void espacioPropioBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espacioPropioBoxActionPerformed
        if (espacioPropioBox.isSelected()) {

            anadirComida(espacioPropio);
        } else {
            quitarComida(espacioPropio);
            //nt.removeRow(fila);
        }
        actualizarPrecioInicial();
    }//GEN-LAST:event_espacioPropioBoxActionPerformed
    private boolean comidaAgregada = false;

    private void actualizarPrecioInicial() {
        boolean algunoSeleccionado = cocineroBox.isSelected() || camareroBox.isSelected() || decoracionBox.isSelected() || espacioPropioBox.isSelected();

        if (algunoSeleccionado && !comidaAgregada) {
            anadirComida(precioInicial);
            comidaAgregada = true;
        } else if (!algunoSeleccionado && comidaAgregada) {
            quitarComida(precioInicial);
            comidaAgregada = false;
        }
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
            java.util.logging.Logger.getLogger(VentanaInfoRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInfoRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInfoRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInfoRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new VentanaInfoRestaurante(indiceSeleccionado).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Carrito;
    private javax.swing.JLabel PrecioTotalLabel;
    private javax.swing.JButton botonRealizarBoton;
    private javax.swing.JButton botonVaciarCesta;
    private javax.swing.JButton botonVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox camareroBox;
    private javax.swing.JCheckBox cocineroBox;
    private javax.swing.JCheckBox decoracionBox;
    private javax.swing.JCheckBox espacioPropioBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCatering;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel mensajeDescuentoTxt;
    private javax.swing.JLabel txtCalificacion;
    private javax.swing.JLabel txtCatering;
    private javax.swing.JLabel txtComidaCatering;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JLabel txtEspecialidad;
    private javax.swing.JLabel txtGastosEnvio;
    private javax.swing.JLabel txtNombreRestaurante;
    private javax.swing.JLabel txtPrecioCatering;
    private javax.swing.JLabel txtServicio;
    private javax.swing.JLabel txtTiempoEnvio;
    // End of variables declaration//GEN-END:variables

}
