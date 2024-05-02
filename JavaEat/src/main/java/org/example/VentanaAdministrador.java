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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableRowSorter;
import static org.example.Informacion.cargarDatos;
import static org.example.Informacion.listaRestaurantes;

/**
 *
 * @author david
 */
public class VentanaAdministrador extends javax.swing.JFrame {

    DefaultTableModel rt = new DefaultTableModel();
    DefaultTableModel pt = new DefaultTableModel();
    DefaultTableModel et = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> rtSorter;
    TableRowSorter<DefaultTableModel> ptSorter;
    TableRowSorter<DefaultTableModel> etSorter;

    /**
     * Creates new form VentanaPrincipalParticulares
     */
    //List<Restaurante> listaRestaurantes = new ArrayList<>();
    public VentanaAdministrador() {
        initComponents();

        String idsRestaurantes[] = {"Nombre", "CIF", "Especialidad", "Calificacion", "Gastos de envío", "Tiempo de envío", "Catering", "Dirección", "Menu"}; //Dirección es un objeto
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

// Asociar el TableModelListener al modelo de la tabla
        rt.addTableModelListener(tableModelListenerRT);

        String idsParticulares[] = {"Nombre", "DNI", "Correo", "Clave", "Dirección", "Tarjeta de Crédito"}; //Dirección es un objeto y tarjeta tmb
        pt.setColumnIdentifiers(idsParticulares);
        jTableParticulares.setModel(pt);
        jTableParticulares.setAutoCreateRowSorter(true);
        ptSorter = new TableRowSorter<>(pt);
        jTableParticulares.setRowSorter(ptSorter);
        // Crear el TableModelListener ESTO ES LO QUE GUARDA LAS MODIFICACIONES DE LOS RESTAURANTES
        TableModelListener tableModelListenerPT = new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int fila = e.getFirstRow();
                    int columna = e.getColumn();

                    if (fila != -1 && columna != -1) {
                        // Obtener los datos modificados de la tabla
                        String nombreModificado = pt.getValueAt(fila, 0).toString();
                        String dniModificado = pt.getValueAt(fila, 1).toString();
                        String correoModificado = pt.getValueAt(fila, 2).toString();
                        String claveModificado = pt.getValueAt(fila, 3).toString();
                        // Obtener la instancia de Restaurante correspondiente
                        Particular particular = Informacion.listaParticulares.get(fila);
                        // Actualizar los atributos individuales del particular
                        particular.setNombre(nombreModificado);
                        particular.setDni(dniModificado);
                        particular.setCorreo(correoModificado);
                        particular.setClave(claveModificado);

                        // Guardar los datos actualizados
                        Informacion.guardarDatos();
                        System.out.println("Se han guardado los particulares.");
                    }
                }

            }
        };
        // Asociar el TableModelListener al modelo de la tabla
        pt.addTableModelListener(tableModelListenerPT);

        String idsEmpresas[] = {"Nombre", "CIF", "Correo", "Clave", "Dirección", "Tarjeta de Crédito", "Web"}; //Dirección es un objeto y tarjeta tmb
        et.setColumnIdentifiers(idsEmpresas);
        jTableEmpresas.setModel(et);
        jTableEmpresas.setAutoCreateRowSorter(true);
        etSorter = new TableRowSorter<>(et);
        jTableEmpresas.setRowSorter(etSorter);
        // Crear el TableModelListener ESTO ES LO QUE GUARDA LAS MODIFICACIONES DE LOS RESTAURANTES
        TableModelListener tableModelListenerET = new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int fila = e.getFirstRow();
                    int columna = e.getColumn();

                    if (fila != -1 && columna != -1) {
                        // Obtener los datos modificados de la tabla
                        String nombreModificado = et.getValueAt(fila, 0).toString();
                        String cifModificado = et.getValueAt(fila, 1).toString();
                        String correoModificado = et.getValueAt(fila, 2).toString();
                        String claveModificado = et.getValueAt(fila, 3).toString();
                        // Obtener la instancia de Restaurante correspondiente
                        Empresa empresa = Informacion.listaEmpresas.get(fila);
                        // Actualizar los atributos individuales del particular
                        empresa.setNombre(nombreModificado);
                        empresa.setCif(cifModificado);
                        empresa.setCorreo(correoModificado);
                        empresa.setClave(claveModificado);

                        // Guardar los datos actualizados
                        Informacion.guardarDatos();
                        System.out.println("Se han guardado los empresas.");
                    }
                }

            }
        };
        // Asociar el TableModelListener al modelo de la tabla
        et.addTableModelListener(tableModelListenerET);

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
            rt.addRow(new Object[]{nombre, CIF, especialidad, calificacion, gastosEnvio, tiempoEnvio, catering, direccion, listaComidas});

        }
        List<Particular> tablaParticulares = Informacion.getListaParticulares();

        for (Particular particular : tablaParticulares) {
            String nombreParticular = particular.getNombre();
            String correoParticular = particular.getCorreo();
            String claveParticular = particular.getClave();

            String ciudadParticular = particular.getDireccion().getCiudad();
            int cpParticular = particular.getDireccion().getCp();
            String calleParticular = particular.getDireccion().getCalle();
            int numeroParticular = particular.getDireccion().getNumero();
            Direccion direccionParticular = new Direccion(calleParticular, numeroParticular, cpParticular, ciudadParticular);

            int numeroTarjetaParticular = particular.getTarjeta().getNumeroTarjeta();
            String caducidadParticular = particular.getTarjeta().getFechaExpiracion();
            int cvvParticular = particular.getTarjeta().getCodigoSeguridad();
            TarjetaCredito tarjetaCreditoParticular = new TarjetaCredito(numeroTarjetaParticular, caducidadParticular, cvvParticular);
            String DniParticular = particular.getDni();

            pt.addRow(new Object[]{nombreParticular, DniParticular, correoParticular, claveParticular, direccionParticular, tarjetaCreditoParticular});
            //"Nombre", "DNI", "Correo", "Clave", "Dirección", "Tarjeta de Crédito"   
        }

        List<Empresa> tablaEmpresas = Informacion.getListaEmpresas();

        for (Empresa empresa : tablaEmpresas) {
            String nombreEmpresa = empresa.getNombre();
            String correoEmpresa = empresa.getCorreo();
            String claveEmpresa = empresa.getClave();

            String ciudadEmpresa = empresa.getDireccion().getCiudad();
            int cpEmpresa = empresa.getDireccion().getCp();
            String calleEmpresa = empresa.getDireccion().getCalle();
            int numeroEmpresa = empresa.getDireccion().getNumero();
            Direccion direccionEmpresa = new Direccion(calleEmpresa, numeroEmpresa, cpEmpresa, ciudadEmpresa);

            int numeroTarjetaEmpresa = empresa.getTarjeta().getNumeroTarjeta();
            String caducidadEmpresa = empresa.getTarjeta().getFechaExpiracion();
            int cvvEmpresa = empresa.getTarjeta().getCodigoSeguridad();
            TarjetaCredito tarjetaCreditoEmpresa = new TarjetaCredito(numeroTarjetaEmpresa, caducidadEmpresa, cvvEmpresa);
            String CifEmpresa = empresa.getCif();
            String webEmpresa = empresa.getWeb();
            et.addRow(new Object[]{nombreEmpresa, CifEmpresa, correoEmpresa, claveEmpresa, direccionEmpresa, tarjetaCreditoEmpresa, webEmpresa});
            //"Nombre", "CIF", "Correo", "Clave", "Dirección", "Tarjeta de Crédito", "Web"

// Crea un editor de celdas personalizado que no permite la edición
            TableCellEditor nonEditableEditor = new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject e) {
                    return false;
                }
            };

        }
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
        jPanel1 = new javax.swing.JPanel();
        botonActualizar = new javax.swing.JButton();
        tab = new javax.swing.JTabbedPane();
        FondoParticulares = new javax.swing.JPanel();
        panelInfoClientes = new javax.swing.JPanel();
        botonAnadirParticulares = new javax.swing.JButton();
        botonBorrarParticulares = new javax.swing.JButton();
        txtCorreo = new javax.swing.JLabel();
        txtClave = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JLabel();
        txtCIF1 = new javax.swing.JLabel();
        fieldNombreParticulares = new javax.swing.JTextField();
        fieldCorreoParticulares = new javax.swing.JTextField();
        fieldClaveParticulares = new javax.swing.JTextField();
        fieldDniParticulares = new javax.swing.JTextField();
        txtCiudad1 = new javax.swing.JLabel();
        txtCP1 = new javax.swing.JLabel();
        txtCalle1 = new javax.swing.JLabel();
        txtNumero1 = new javax.swing.JLabel();
        fieldCalleParticulares = new javax.swing.JTextField();
        fieldCiudadParticulares = new javax.swing.JTextField();
        fieldNumeroParticulares = new javax.swing.JTextField();
        fieldCPParticulares = new javax.swing.JTextField();
        txtBuscador1 = new javax.swing.JLabel();
        fieldBuscadorParticulares = new javax.swing.JTextField();
        txtCiudad2 = new javax.swing.JLabel();
        txtCiudad3 = new javax.swing.JLabel();
        txtCiudad4 = new javax.swing.JLabel();
        fieldTarjetaParticulares = new javax.swing.JTextField();
        fieldCVVParticulares = new javax.swing.JTextField();
        fieldCaducidadParticulares = new javax.swing.JTextField();
        panelListaRestaurantes1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableParticulares = new javax.swing.JTable();
        FondoEmpresas = new javax.swing.JPanel();
        panelInfoClientes1 = new javax.swing.JPanel();
        botonAnadirEmpresas = new javax.swing.JButton();
        botonBorrarEmpresas = new javax.swing.JButton();
        txtCorreo1 = new javax.swing.JLabel();
        txtClave1 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JLabel();
        txtCIF2 = new javax.swing.JLabel();
        fieldNombreEmpresas = new javax.swing.JTextField();
        fieldCorreoEmpresas = new javax.swing.JTextField();
        fieldClaveEmpresas = new javax.swing.JTextField();
        fieldCifEmpresas = new javax.swing.JTextField();
        fieldWebEmpresas = new javax.swing.JTextField();
        txtCiudad5 = new javax.swing.JLabel();
        txtCP2 = new javax.swing.JLabel();
        txtCalle2 = new javax.swing.JLabel();
        txtNumero2 = new javax.swing.JLabel();
        fieldCalleEmpresas = new javax.swing.JTextField();
        fieldCiudadEmpresas = new javax.swing.JTextField();
        fieldNumeroEmpresas = new javax.swing.JTextField();
        fieldCPEmpresas = new javax.swing.JTextField();
        txtBuscador2 = new javax.swing.JLabel();
        fieldBuscadorEmpresas = new javax.swing.JTextField();
        txtWeb1 = new javax.swing.JLabel();
        txtCiudad6 = new javax.swing.JLabel();
        txtCiudad7 = new javax.swing.JLabel();
        txtCiudad8 = new javax.swing.JLabel();
        fieldTarjetaEmpresas = new javax.swing.JTextField();
        fieldCVVEmpresas = new javax.swing.JTextField();
        fieldCaducidadEmpresas = new javax.swing.JTextField();
        panelListaRestaurantes2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEmpresas = new javax.swing.JTable();
        Fondo = new javax.swing.JPanel();
        panelInfoRestaurantes = new javax.swing.JPanel();
        botonAnadir = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        txtGastosEnvio = new javax.swing.JLabel();
        txtTiempoEnvio = new javax.swing.JLabel();
        txtCatering = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JLabel();
        txtCIF = new javax.swing.JLabel();
        cbEspecialidad = new javax.swing.JComboBox<>();
        fieldNombre = new javax.swing.JTextField();
        fieldGastosEnvio = new javax.swing.JTextField();
        fieldTiempoEnvio = new javax.swing.JTextField();
        fieldCIF = new javax.swing.JTextField();
        botonCatering = new javax.swing.JCheckBox();
        txtCiudad = new javax.swing.JLabel();
        txtCP = new javax.swing.JLabel();
        txtCalle = new javax.swing.JLabel();
        txtNumero = new javax.swing.JLabel();
        fieldCalle = new javax.swing.JTextField();
        fieldCiudad = new javax.swing.JTextField();
        fieldNumero = new javax.swing.JTextField();
        fieldCP = new javax.swing.JTextField();
        txtBuscador = new javax.swing.JLabel();
        fieldBuscador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        precio1TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreProducto2TextField = new javax.swing.JTextField();
        ingredientes1TextField = new javax.swing.JTextField();
        precio2TextField = new javax.swing.JTextField();
        ingredientes2TextField = new javax.swing.JTextField();
        nombreProducto1TextField = new javax.swing.JTextField();
        nombreProducto3TextField = new javax.swing.JTextField();
        precio3TextField = new javax.swing.JTextField();
        ingredientes3TextField = new javax.swing.JTextField();
        precio4TextField = new javax.swing.JTextField();
        nombreProducto4TextField = new javax.swing.JTextField();
        ingredientes4TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        precioComidaField = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comidaCateringField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        precioComida = new javax.swing.JTextField();
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
        cateringCheckbox = new javax.swing.JRadioButtonMenuItem();
        jMenu29 = new javax.swing.JMenu();
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

        botonAnadirParticulares.setBackground(new java.awt.Color(255, 204, 51));
        botonAnadirParticulares.setText("Añadir");
        botonAnadirParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirParticularesActionPerformed(evt);
            }
        });

        botonBorrarParticulares.setBackground(new java.awt.Color(255, 204, 51));
        botonBorrarParticulares.setText("Borrar");
        botonBorrarParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarParticularesActionPerformed(evt);
            }
        });

        txtCorreo.setText("Correo");

        txtClave.setText("Clave");

        txtNombre1.setText("Nombre");

        txtCIF1.setText("DNI");

        fieldNombreParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreParticularesActionPerformed(evt);
            }
        });

        fieldCorreoParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCorreoParticularesActionPerformed(evt);
            }
        });

        fieldClaveParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldClaveParticularesActionPerformed(evt);
            }
        });

        fieldDniParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDniParticularesActionPerformed(evt);
            }
        });

        txtCiudad1.setText("Ciudad");

        txtCP1.setText("Código Postal");

        txtCalle1.setText("Calle");

        txtNumero1.setText("Numero");

        fieldCiudadParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCiudadParticularesActionPerformed(evt);
            }
        });

        fieldCPParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCPParticularesActionPerformed(evt);
            }
        });

        txtBuscador1.setText("Buscador");

        fieldBuscadorParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBuscadorParticularesActionPerformed(evt);
            }
        });
        fieldBuscadorParticulares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldBuscadorParticularesKeyReleased(evt);
            }
        });

        txtCiudad2.setText("NºTarjeta");

        txtCiudad3.setText("Caducidad");

        txtCiudad4.setText("CVV");

        fieldTarjetaParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTarjetaParticularesActionPerformed(evt);
            }
        });

        fieldCVVParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCVVParticularesActionPerformed(evt);
            }
        });

        fieldCaducidadParticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCaducidadParticularesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoClientesLayout = new javax.swing.GroupLayout(panelInfoClientes);
        panelInfoClientes.setLayout(panelInfoClientesLayout);
        panelInfoClientesLayout.setHorizontalGroup(
            panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoClientesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoClientesLayout.createSequentialGroup()
                        .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAnadirParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBorrarParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCIF1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldDniParticulares, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(fieldClaveParticulares)
                    .addComponent(fieldCorreoParticulares)
                    .addComponent(fieldNombreParticulares))
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoClientesLayout.createSequentialGroup()
                        .addComponent(txtCP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldCPParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoClientesLayout.createSequentialGroup()
                        .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelInfoClientesLayout.createSequentialGroup()
                                .addComponent(txtCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldCalleParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCiudad4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldCVVParticulares, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoClientesLayout.createSequentialGroup()
                                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscador1)
                                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumeroParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldBuscadorParticulares)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoClientesLayout.createSequentialGroup()
                                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInfoClientesLayout.createSequentialGroup()
                                        .addComponent(txtCiudad1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldCiudadParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCiudad2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCiudad3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldTarjetaParticulares, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(fieldCaducidadParticulares))))
                        .addGap(0, 42, Short.MAX_VALUE))))
        );
        panelInfoClientesLayout.setVerticalGroup(
            panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoClientesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNombreParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre1)
                    .addComponent(txtCiudad1)
                    .addComponent(fieldCiudadParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad2)
                    .addComponent(fieldTarjetaParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo)
                    .addComponent(fieldCorreoParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCP1)
                    .addComponent(fieldCPParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad3)
                    .addComponent(fieldCaducidadParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAnadirParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave)
                    .addComponent(fieldClaveParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCalle1)
                    .addComponent(fieldCalleParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad4)
                    .addComponent(fieldCVVParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDniParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCIF1)
                    .addComponent(txtNumero1)
                    .addComponent(fieldNumeroParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBorrarParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscador1)
                    .addComponent(fieldBuscadorParticulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableParticulares.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableParticulares);

        javax.swing.GroupLayout panelListaRestaurantes1Layout = new javax.swing.GroupLayout(panelListaRestaurantes1);
        panelListaRestaurantes1.setLayout(panelListaRestaurantes1Layout);
        panelListaRestaurantes1Layout.setHorizontalGroup(
            panelListaRestaurantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRestaurantes1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelListaRestaurantes1Layout.setVerticalGroup(
            panelListaRestaurantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRestaurantes1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FondoParticularesLayout = new javax.swing.GroupLayout(FondoParticulares);
        FondoParticulares.setLayout(FondoParticularesLayout);
        FondoParticularesLayout.setHorizontalGroup(
            FondoParticularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoParticularesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
            .addComponent(panelListaRestaurantes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FondoParticularesLayout.setVerticalGroup(
            FondoParticularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoParticularesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(panelListaRestaurantes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Particulares", FondoParticulares);

        botonAnadirEmpresas.setBackground(new java.awt.Color(255, 204, 51));
        botonAnadirEmpresas.setText("Añadir");
        botonAnadirEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirEmpresasActionPerformed(evt);
            }
        });

        botonBorrarEmpresas.setBackground(new java.awt.Color(255, 204, 51));
        botonBorrarEmpresas.setText("Borrar");
        botonBorrarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarEmpresasActionPerformed(evt);
            }
        });

        txtCorreo1.setText("Correo");

        txtClave1.setText("Clave");

        txtNombre2.setText("Nombre");

        txtCIF2.setText("CIF");

        fieldNombreEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreEmpresasActionPerformed(evt);
            }
        });

        fieldCorreoEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCorreoEmpresasActionPerformed(evt);
            }
        });

        fieldClaveEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldClaveEmpresasActionPerformed(evt);
            }
        });

        fieldCifEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCifEmpresasActionPerformed(evt);
            }
        });

        txtCiudad5.setText("Ciudad");

        txtCP2.setText("Código Postal");

        txtCalle2.setText("Calle");

        txtNumero2.setText("Numero");

        fieldCiudadEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCiudadEmpresasActionPerformed(evt);
            }
        });

        fieldCPEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCPEmpresasActionPerformed(evt);
            }
        });

        txtBuscador2.setText("Buscador");

        fieldBuscadorEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBuscadorEmpresasActionPerformed(evt);
            }
        });
        fieldBuscadorEmpresas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldBuscadorEmpresasKeyReleased(evt);
            }
        });

        txtWeb1.setText("Web (Empresas)");

        txtCiudad6.setText("NºTarjeta");

        txtCiudad7.setText("Caducidad");

        txtCiudad8.setText("CVV");

        fieldTarjetaEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTarjetaEmpresasActionPerformed(evt);
            }
        });

        fieldCVVEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCVVEmpresasActionPerformed(evt);
            }
        });

        fieldCaducidadEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCaducidadEmpresasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoClientes1Layout = new javax.swing.GroupLayout(panelInfoClientes1);
        panelInfoClientes1.setLayout(panelInfoClientes1Layout);
        panelInfoClientes1Layout.setHorizontalGroup(
            panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoClientes1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoClientes1Layout.createSequentialGroup()
                        .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonBorrarEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAnadirEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCIF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtWeb1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                    .addComponent(txtClave1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldCifEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(fieldClaveEmpresas)
                    .addComponent(fieldCorreoEmpresas)
                    .addComponent(fieldNombreEmpresas)
                    .addComponent(fieldWebEmpresas))
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoClientes1Layout.createSequentialGroup()
                        .addComponent(txtCP2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldCPEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoClientes1Layout.createSequentialGroup()
                        .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelInfoClientes1Layout.createSequentialGroup()
                                .addComponent(txtCalle2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldCalleEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCiudad8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldCVVEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoClientes1Layout.createSequentialGroup()
                                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscador2)
                                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumeroEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldBuscadorEmpresas)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoClientes1Layout.createSequentialGroup()
                                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInfoClientes1Layout.createSequentialGroup()
                                        .addComponent(txtCiudad5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldCiudadEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCiudad6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCiudad7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldTarjetaEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(fieldCaducidadEmpresas))))
                        .addGap(0, 42, Short.MAX_VALUE))))
        );
        panelInfoClientes1Layout.setVerticalGroup(
            panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoClientes1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNombreEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre2)
                    .addComponent(txtCiudad5)
                    .addComponent(fieldCiudadEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad6)
                    .addComponent(fieldTarjetaEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo1)
                    .addComponent(fieldCorreoEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCP2)
                    .addComponent(fieldCPEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad7)
                    .addComponent(fieldCaducidadEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAnadirEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave1)
                    .addComponent(fieldClaveEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCalle2)
                    .addComponent(fieldCalleEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad8)
                    .addComponent(fieldCVVEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCifEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCIF2)
                    .addComponent(txtNumero2)
                    .addComponent(fieldNumeroEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBorrarEmpresas))
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldWebEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWeb1)
                    .addComponent(txtBuscador2)
                    .addComponent(fieldBuscadorEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableEmpresas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableEmpresas);

        javax.swing.GroupLayout panelListaRestaurantes2Layout = new javax.swing.GroupLayout(panelListaRestaurantes2);
        panelListaRestaurantes2.setLayout(panelListaRestaurantes2Layout);
        panelListaRestaurantes2Layout.setHorizontalGroup(
            panelListaRestaurantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRestaurantes2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        panelListaRestaurantes2Layout.setVerticalGroup(
            panelListaRestaurantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRestaurantes2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FondoEmpresasLayout = new javax.swing.GroupLayout(FondoEmpresas);
        FondoEmpresas.setLayout(FondoEmpresasLayout);
        FondoEmpresasLayout.setHorizontalGroup(
            FondoEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfoClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
            .addGroup(FondoEmpresasLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panelListaRestaurantes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FondoEmpresasLayout.setVerticalGroup(
            FondoEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfoClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(panelListaRestaurantes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Empresas", FondoEmpresas);

        botonAnadir.setBackground(new java.awt.Color(255, 204, 51));
        botonAnadir.setText("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        botonBorrar.setBackground(new java.awt.Color(255, 204, 51));
        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        txtGastosEnvio.setText("Gastos de envío");

        txtTiempoEnvio.setText("Tiempo de envío");

        txtCatering.setText("Catering");

        txtNombre.setText("Nombre");

        txtEspecialidad.setText("Especialidad");

        txtCIF.setText("CIF");

        cbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Española", "Mexicana", "Asiática", "Americana", "Italiana", "Turca" }));
        cbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecialidadActionPerformed(evt);
            }
        });

        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });

        fieldGastosEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldGastosEnvioActionPerformed(evt);
            }
        });

        fieldCIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCIFActionPerformed(evt);
            }
        });

        botonCatering.setSelected(true);
        botonCatering.setText("Tiene catering");
        botonCatering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCateringActionPerformed(evt);
            }
        });

        txtCiudad.setText("Ciudad");

        txtCP.setText("Código Postal");

        txtCalle.setText("Calle");

        txtNumero.setText("Numero");

        fieldCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCalleActionPerformed(evt);
            }
        });

        fieldCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCiudadActionPerformed(evt);
            }
        });

        fieldCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCPActionPerformed(evt);
            }
        });

        txtBuscador.setText("Buscador");

        fieldBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBuscadorActionPerformed(evt);
            }
        });
        fieldBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldBuscadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBuscadorKeyTyped(evt);
            }
        });

        jLabel1.setText("Nombre producto");

        precio1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio1TextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Precio");

        jLabel3.setText("Ingredientes");

        nombreProducto2TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProducto2TextFieldActionPerformed(evt);
            }
        });

        ingredientes1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientes1TextFieldActionPerformed(evt);
            }
        });

        ingredientes2TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientes2TextFieldActionPerformed(evt);
            }
        });

        nombreProducto1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProducto1TextFieldActionPerformed(evt);
            }
        });

        precio3TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio3TextFieldActionPerformed(evt);
            }
        });

        precio4TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio4TextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Añade las comidas ");

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setText("Acceder ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Comida catering");

        comidaCateringField.setText("  ");
        comidaCateringField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comidaCateringFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Precio inicial (Solo comida)");

        javax.swing.GroupLayout precioComidaFieldLayout = new javax.swing.GroupLayout(precioComidaField);
        precioComidaField.setLayout(precioComidaFieldLayout);
        precioComidaFieldLayout.setHorizontalGroup(
            precioComidaFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(precioComidaFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(precioComidaFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(precioComidaFieldLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(precioComidaFieldLayout.createSequentialGroup()
                        .addComponent(comidaCateringField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(precioComida, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(436, Short.MAX_VALUE))
        );
        precioComidaFieldLayout.setVerticalGroup(
            precioComidaFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(precioComidaFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(precioComidaFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(precioComidaFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comidaCateringField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelInfoRestaurantesLayout = new javax.swing.GroupLayout(panelInfoRestaurantes);
        panelInfoRestaurantes.setLayout(panelInfoRestaurantesLayout);
        panelInfoRestaurantesLayout.setHorizontalGroup(
            panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(precioComidaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ingredientes2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingredientes1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingredientes3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingredientes4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precio1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoRestaurantesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoRestaurantesLayout.createSequentialGroup()
                                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonBorrar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonAnadir, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(4, 4, 4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGastosEnvio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoRestaurantesLayout.createSequentialGroup()
                                .addComponent(txtCatering)
                                .addGap(43, 43, 43))
                            .addComponent(txtTiempoEnvio, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldGastosEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldTiempoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoRestaurantesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCatering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addComponent(txtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscador)
                            .addComponent(txtCIF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fieldCIF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(fieldBuscador, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreProducto1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addComponent(nombreProducto2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreProducto3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreProducto4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInfoRestaurantesLayout.setVerticalGroup(
            panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre)
                    .addComponent(txtCiudad)
                    .addComponent(fieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEspecialidad)
                    .addComponent(txtCP)
                    .addComponent(fieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(botonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle)
                    .addComponent(fieldCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreProducto1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingredientes1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldGastosEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGastosEnvio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonBorrar)
                        .addComponent(txtTiempoEnvio)
                        .addComponent(fieldTiempoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumero)
                        .addComponent(fieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreProducto2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ingredientes2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(precio2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCIF)
                    .addComponent(nombreProducto3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingredientes3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCatering)
                    .addComponent(botonCatering))
                .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(panelInfoRestaurantesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelInfoRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscador)
                            .addComponent(nombreProducto4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingredientes4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(precioComidaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelListaRestaurantesLayout.setVerticalGroup(
            panelListaRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRestaurantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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
                .addGap(12, 12, 12)
                .addComponent(panelListaRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        cateringCheckbox.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        cateringCheckbox.setText("Servicio de catering");
        cateringCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cateringCheckboxActionPerformed(evt);
            }
        });
        jMenu28.add(cateringCheckbox);

        jMenu2.add(jMenu28);

        jMenuBar1.add(jMenu2);

        jMenu29.setText("Ajustes");

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

    private void cateringCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cateringCheckboxActionPerformed
        boolean selected = cateringCheckbox.isSelected();
        filterTableByCatering(selected, rt, jTableRestaurantes);
    }//GEN-LAST:event_cateringCheckboxActionPerformed

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

    private void fieldCaducidadParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCaducidadParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCaducidadParticularesActionPerformed

    private void fieldCVVParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCVVParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCVVParticularesActionPerformed

    private void fieldTarjetaParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTarjetaParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTarjetaParticularesActionPerformed

    private void fieldBuscadorParticularesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscadorParticularesKeyReleased
        filtrar(fieldBuscadorParticulares.getText());
    }//GEN-LAST:event_fieldBuscadorParticularesKeyReleased

    private void fieldBuscadorParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBuscadorParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBuscadorParticularesActionPerformed

    private void fieldCPParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCPParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCPParticularesActionPerformed

    private void fieldCiudadParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCiudadParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCiudadParticularesActionPerformed

    private void fieldDniParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDniParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDniParticularesActionPerformed

    private void fieldClaveParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldClaveParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldClaveParticularesActionPerformed

    private void fieldCorreoParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCorreoParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCorreoParticularesActionPerformed

    private void fieldNombreParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreParticularesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreParticularesActionPerformed

    private void botonBorrarParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarParticularesActionPerformed
        int selectedRow = jTableParticulares.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableParticulares.convertRowIndexToModel(selectedRow);
            Particular particular = Informacion.listaParticulares.get(modelRow);
            Informacion.listaParticulares.remove(particular);
            pt.removeRow(modelRow);
            Informacion.guardarDatosParticular();

        } else {
            JOptionPane.showMessageDialog(this, "No has seleccionado una fila.");
        }
    }//GEN-LAST:event_botonBorrarParticularesActionPerformed

    private void botonAnadirParticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirParticularesActionPerformed
        String nombreParticular = fieldNombreParticulares.getText(); // obtener el correo electrónico ingresado
        String correoParticular = fieldCorreoParticulares.getText(); // obtener la clave ingresada
        String claveParticular = fieldClaveParticulares.getText();
        String DniParticular = fieldDniParticulares.getText();
        String ciudadParticular = fieldCiudadParticulares.getText();
        int cpParticular = Integer.parseInt(fieldCPParticulares.getText());
        String calleParticular = fieldCalleParticulares.getText();
        int numeroParticular = Integer.parseInt(fieldNumeroParticulares.getText());
        Direccion direccionParticular = new Direccion(calleParticular, numeroParticular, cpParticular, ciudadParticular);

        int numeroTarjetaParticular = Integer.parseInt(fieldTarjetaParticulares.getText());
        String caducidadParticular = fieldCaducidadParticulares.getText();
        int cvvParticular = Integer.parseInt(fieldCVVParticulares.getText());
        TarjetaCredito tarjetaParticular = new TarjetaCredito(numeroTarjetaParticular, caducidadParticular, cvvParticular);

        Particular particular = new Particular(nombreParticular, correoParticular, claveParticular, DniParticular, direccionParticular, tarjetaParticular);
        Informacion.anadirParticular(particular);

        pt.addRow(new Object[]{nombreParticular, DniParticular, correoParticular, claveParticular, direccionParticular, tarjetaParticular});
        //"Nombre", "Correo", "Clave", "DNI/CIF", "Dirección", "Tarjeta de Crédito","WEB" 
        Informacion.guardarDatosParticular();

        fieldNombreParticulares.setText("");
        fieldCorreoParticulares.setText("");
        fieldClaveParticulares.setText("");
        fieldDniParticulares.setText("");
        fieldCiudadParticulares.setText("");
        fieldCPParticulares.setText("");
        fieldCalleParticulares.setText("");
        fieldNumeroParticulares.setText("");
        fieldTarjetaParticulares.setText("");
        fieldCaducidadParticulares.setText("");
        fieldCVVParticulares.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_botonAnadirParticularesActionPerformed

    private void botonTodosMenuRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTodosMenuRestauranteActionPerformed

        rtSorter.setRowFilter(null);
        desmarcarTodasLasEspecialidades();
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTodosMenuRestauranteActionPerformed

    private void botonAnadirEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirEmpresasActionPerformed
        String nombreEmpresa = fieldNombreEmpresas.getText(); // obtener el correo electrónico ingresado
        String correoEmpresa = fieldCorreoEmpresas.getText(); // obtener la clave ingresada
        String claveEmpresa = fieldClaveEmpresas.getText();
        String CifEmpresa = fieldCifEmpresas.getText();
        String webEmpresa = fieldWebEmpresas.getText();
        String ciudadEmpresa = fieldCiudadEmpresas.getText();
        int cpEmpresa = Integer.parseInt(fieldCPEmpresas.getText());
        String calleEmpresa = fieldCalleEmpresas.getText();
        int numeroEmpresa = Integer.parseInt(fieldNumeroEmpresas.getText());
        Direccion direccionEmpresa = new Direccion(calleEmpresa, numeroEmpresa, cpEmpresa, ciudadEmpresa);

        int numeroTarjetaEmpresa = Integer.parseInt(fieldTarjetaEmpresas.getText());
        String caducidadEmpresa = fieldCaducidadEmpresas.getText();
        int cvvEmpresa = Integer.parseInt(fieldCVVEmpresas.getText());
        TarjetaCredito tarjetaEmpresa = new TarjetaCredito(numeroTarjetaEmpresa, caducidadEmpresa, cvvEmpresa);

        Empresa empresa = new Empresa(nombreEmpresa, correoEmpresa, claveEmpresa, CifEmpresa, direccionEmpresa, tarjetaEmpresa, webEmpresa);
        Informacion.anadirEmpresa(empresa);

        et.addRow(new Object[]{nombreEmpresa, CifEmpresa, correoEmpresa, claveEmpresa, direccionEmpresa, tarjetaEmpresa, webEmpresa});
        //"Nombre", "Correo", "Clave", "DNI/CIF", "Dirección", "Tarjeta de Crédito","WEB" 
        Informacion.guardarDatosEmpresa();

        fieldNombreEmpresas.setText("");
        fieldCorreoEmpresas.setText("");
        fieldClaveEmpresas.setText("");
        fieldCifEmpresas.setText("");
        fieldCiudadEmpresas.setText("");
        fieldCPEmpresas.setText("");
        fieldCalleEmpresas.setText("");
        fieldNumeroEmpresas.setText("");
        fieldTarjetaEmpresas.setText("");
        fieldCaducidadEmpresas.setText("");
        fieldCVVEmpresas.setText("");
        fieldWebEmpresas.setText("");

        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_botonAnadirEmpresasActionPerformed

    private void botonBorrarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarEmpresasActionPerformed

        int selectedRow = jTableEmpresas.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableEmpresas.convertRowIndexToModel(selectedRow);
            Empresa empresa = Informacion.listaEmpresas.get(modelRow);
            Informacion.listaEmpresas.remove(empresa);
            et.removeRow(modelRow);
            Informacion.guardarDatosEmpresa();

        } else {
            JOptionPane.showMessageDialog(this, "No has seleccionado una fila.");
        }
    }//GEN-LAST:event_botonBorrarEmpresasActionPerformed

    private void fieldNombreEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreEmpresasActionPerformed

    private void fieldCorreoEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCorreoEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCorreoEmpresasActionPerformed

    private void fieldClaveEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldClaveEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldClaveEmpresasActionPerformed

    private void fieldCifEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCifEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCifEmpresasActionPerformed

    private void fieldCiudadEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCiudadEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCiudadEmpresasActionPerformed

    private void fieldCPEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCPEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCPEmpresasActionPerformed

    private void fieldBuscadorEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBuscadorEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBuscadorEmpresasActionPerformed

    private void fieldBuscadorEmpresasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscadorEmpresasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBuscadorEmpresasKeyReleased

    private void fieldTarjetaEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTarjetaEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTarjetaEmpresasActionPerformed

    private void fieldCVVEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCVVEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCVVEmpresasActionPerformed

    private void fieldCaducidadEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCaducidadEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCaducidadEmpresasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing


    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int indiceSeleccionado = obtenerIndiceSeleccionado();
        System.out.println(indiceSeleccionado);
        VentanaInfoRestaurante ventana = new VentanaInfoRestaurante(indiceSeleccionado);
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void precio3TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio3TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precio3TextFieldActionPerformed

    private void ingredientes2TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientes2TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingredientes2TextFieldActionPerformed

    private void ingredientes1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientes1TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingredientes1TextFieldActionPerformed

    private void nombreProducto2TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProducto2TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProducto2TextFieldActionPerformed

    private void precio1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio1TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precio1TextFieldActionPerformed

    private void fieldBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscadorKeyTyped

    }//GEN-LAST:event_fieldBuscadorKeyTyped

    private void fieldBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscadorKeyReleased
        filtrar(fieldBuscador.getText());
    }//GEN-LAST:event_fieldBuscadorKeyReleased

    private void fieldBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBuscadorActionPerformed

    private void fieldCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCPActionPerformed

    private void fieldCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCiudadActionPerformed

    private void fieldCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCalleActionPerformed

    private void botonCateringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCateringActionPerformed
        boolean catering = botonCatering.isSelected();
        if (botonCatering.isSelected()) {
            precioComidaField.setVisible(true);  // Mostrar el panel si el botón está pulsado
        } else {
            precioComidaField.setVisible(false); // Ocultar el panel si el botón no está pulsado
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCateringActionPerformed

    private void fieldCIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCIFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCIFActionPerformed

    private void fieldGastosEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldGastosEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldGastosEnvioActionPerformed

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreActionPerformed

    private void cbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecialidadActionPerformed

    /*/
    public void MostrarRestaurantes(){
        List<Restaurante> listaRestaurantes = new ArrayList<>();
        listaRestaurantes= Informacion.getListaRestaurantes();

        for ( Restaurante restaurante: listaRestaurantes){
            mt.addRow(new Object[]{restaurante.getNombre(),restaurante.getCif(),restaurante.getEspecialidad(), restaurante.getCalificacion(), restaurante.getGastosEnvio(), restaurante.getTiempoEnvio(), restaurante.isCatering(), restaurante.getDireccion() });
        }
    }
    /*/
    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        int selectedRow = jTableRestaurantes.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableRestaurantes.convertRowIndexToModel(selectedRow);
            Restaurante restaurante = listaRestaurantes.get(modelRow);
            listaRestaurantes.remove(restaurante);
            rt.removeRow(modelRow);
            Informacion.guardarDatosRestaurante();

        } else {
            JOptionPane.showMessageDialog(this, "No has seleccionado una fila.");
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed

        String nombre = fieldNombre.getText(); // obtener el correo electrónico ingresado
        String especialidad = cbEspecialidad.getSelectedItem().toString(); // obtener la clave ingresada
        double calificacion = 0.0;
        double gastosEnvio = Double.valueOf(fieldGastosEnvio.getText());
        int tiempoEnvio = Integer.parseInt(fieldTiempoEnvio.getText());
        String CIF = fieldCIF.getText();
        String ciudad = fieldCiudad.getText();
        int cp = Integer.parseInt(fieldCP.getText());
        String calle = fieldCalle.getText();
        int numero = Integer.parseInt(fieldNumero.getText());
        Direccion direccion = new Direccion(calle, numero, cp, ciudad);
        boolean tieneCatering = botonCatering.isSelected();
        String comidaCatering = comidaCateringField.getText();
        Double precioComidaText = Double.valueOf(precioComida.getText());

        /*
        } else{
            String comidaCatering = "";
            boolean tieneServicioCamareros = false;
            boolean tieneServicioCocineros = false;
            boolean tieneServicioDecoracion = false;
            boolean tieneEspacioPrivado = false;
            double precioInicialComida = 0.0;
            Catering catering = new Catering(tieneCatering, comidaCatering, tieneServicioCamareros, tieneServicioCocineros, tieneServicioDecoracion, tieneEspacioPrivado, precioInicialComida);    
        }*/
        //Añadir productos
        ArrayList<Comida> listaComidasCreada = new ArrayList<>();
        String nombreProducto1 = nombreProducto1TextField.getText();
        double precio1 = Double.parseDouble(precio1TextField.getText());
        String ingredientes1 = ingredientes1TextField.getText();

        String nombreProducto2 = nombreProducto2TextField.getText();
        double precio2 = Double.parseDouble(precio2TextField.getText());
        String ingredientes2 = ingredientes2TextField.getText();

        String nombreProducto3 = nombreProducto3TextField.getText();
        double precio3 = Double.parseDouble(precio3TextField.getText());
        String ingredientes3 = ingredientes3TextField.getText();

        String nombreProducto4 = nombreProducto4TextField.getText();
        double precio4 = Double.parseDouble(precio4TextField.getText());
        String ingredientes4 = ingredientes4TextField.getText();
        Comida comida1 = new Comida(nombreProducto1, ingredientes1, precio1);
        Comida comida2 = new Comida(nombreProducto2, ingredientes2, precio2);
        Comida comida3 = new Comida(nombreProducto3, ingredientes3, precio3);
        Comida comida4 = new Comida(nombreProducto4, ingredientes4, precio4);
        listaComidasCreada.add(comida1);
        listaComidasCreada.add(comida2);
        listaComidasCreada.add(comida3);
        listaComidasCreada.add(comida4);

        Catering catering = new Catering(tieneCatering, comidaCatering, precioComidaText);
        if (tieneCatering) {
            rt.addRow(new Object[]{nombre, CIF, especialidad, calificacion, gastosEnvio, tiempoEnvio, catering, direccion, listaComidasCreada});
        } else {
             comidaCatering = "";
             precioComidaText = 0.0;
            rt.addRow(new Object[]{nombre, CIF, especialidad, calificacion, gastosEnvio, tiempoEnvio, new Catering(tieneCatering, comidaCatering, precioComidaText), direccion, listaComidasCreada});
        }

        Restaurante restaurante = new Restaurante(CIF, nombre, new Direccion(calle, numero, cp, ciudad), especialidad, calificacion, gastosEnvio, tiempoEnvio, catering, listaComidasCreada,0.0, 0);
        Informacion.anadirRestaurante(restaurante);
        Informacion.guardarDatosRestaurante();

        fieldNombre.setText("");
        fieldGastosEnvio.setText("");
        fieldTiempoEnvio.setText("");
        fieldCIF.setText("");
        fieldCiudad.setText("");
        fieldCP.setText("");
        fieldCalle.setText("");
        fieldNumero.setText("");
        comidaCateringField.setText("");
        precioComida.setText("");
        nombreProducto1TextField.setText("");
        precio1TextField.setText("");
        ingredientes1TextField.setText("");

        nombreProducto2TextField.setText("");
        precio2TextField.setText("");
        ingredientes2TextField.setText("");

        nombreProducto3TextField.setText("");
        precio3TextField.setText("");
        ingredientes3TextField.setText("");

        nombreProducto4TextField.setText("");
        precio4TextField.setText("");
        ingredientes4TextField.setText("");

    }//GEN-LAST:event_botonAnadirActionPerformed

    private void precio4TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio4TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precio4TextFieldActionPerformed

    private void nombreProducto1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProducto1TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProducto1TextFieldActionPerformed

    private void comidaCateringFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comidaCateringFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comidaCateringFieldActionPerformed

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
        TableRowSorter<DefaultTableModel> ptSorter = new TableRowSorter<>(pt);
        TableRowSorter<DefaultTableModel> etSorter = new TableRowSorter<>(pt);
        jTableRestaurantes.setRowSorter(rtSorter);
        jTableParticulares.setRowSorter(ptSorter);
        jTableParticulares.setRowSorter(etSorter);
        RowFilter<DefaultTableModel, Object> rtFilter = RowFilter.regexFilter(texto);
        RowFilter<DefaultTableModel, Object> ptFilter = RowFilter.regexFilter(texto);
        RowFilter<DefaultTableModel, Object> etFilter = RowFilter.regexFilter(texto);
        rtSorter.setRowFilter(rtFilter);
        ptSorter.setRowFilter(ptFilter);
        etSorter.setRowFilter(etFilter);
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
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdministrador().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel FondoEmpresas;
    private javax.swing.JPanel FondoParticulares;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonAnadirEmpresas;
    private javax.swing.JButton botonAnadirParticulares;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBorrarEmpresas;
    private javax.swing.JButton botonBorrarParticulares;
    private javax.swing.JCheckBox botonCatering;
    private javax.swing.JRadioButtonMenuItem botonTodosMenuRestaurante;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButtonMenuItem cateringCheckbox;
    private javax.swing.JRadioButtonMenuItem cbAmericana;
    private javax.swing.JRadioButtonMenuItem cbAsiatica;
    private javax.swing.JRadioButtonMenuItem cbCerrarSesion;
    private javax.swing.JRadioButtonMenuItem cbEspanola;
    private javax.swing.JComboBox<String> cbEspecialidad;
    private javax.swing.JRadioButtonMenuItem cbFiltrarCercania;
    private javax.swing.JRadioButtonMenuItem cbItaliana;
    private javax.swing.JRadioButtonMenuItem cbMexicana;
    private javax.swing.JRadioButtonMenuItem cbTurca;
    private javax.swing.JTextField comidaCateringField;
    private javax.swing.JTextField fieldBuscador;
    private javax.swing.JTextField fieldBuscadorEmpresas;
    private javax.swing.JTextField fieldBuscadorParticulares;
    private javax.swing.JTextField fieldCIF;
    private javax.swing.JTextField fieldCP;
    private javax.swing.JTextField fieldCPEmpresas;
    private javax.swing.JTextField fieldCPParticulares;
    private javax.swing.JTextField fieldCVVEmpresas;
    private javax.swing.JTextField fieldCVVParticulares;
    private javax.swing.JTextField fieldCaducidadEmpresas;
    private javax.swing.JTextField fieldCaducidadParticulares;
    private javax.swing.JTextField fieldCalle;
    private javax.swing.JTextField fieldCalleEmpresas;
    private javax.swing.JTextField fieldCalleParticulares;
    private javax.swing.JTextField fieldCifEmpresas;
    private javax.swing.JTextField fieldCiudad;
    private javax.swing.JTextField fieldCiudadEmpresas;
    private javax.swing.JTextField fieldCiudadParticulares;
    private javax.swing.JTextField fieldClaveEmpresas;
    private javax.swing.JTextField fieldClaveParticulares;
    private javax.swing.JTextField fieldCorreoEmpresas;
    private javax.swing.JTextField fieldCorreoParticulares;
    private javax.swing.JTextField fieldDniParticulares;
    private javax.swing.JTextField fieldGastosEnvio;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldNombreEmpresas;
    private javax.swing.JTextField fieldNombreParticulares;
    private javax.swing.JTextField fieldNumero;
    private javax.swing.JTextField fieldNumeroEmpresas;
    private javax.swing.JTextField fieldNumeroParticulares;
    private javax.swing.JTextField fieldTarjetaEmpresas;
    private javax.swing.JTextField fieldTarjetaParticulares;
    private javax.swing.JTextField fieldTiempoEnvio;
    private javax.swing.JTextField fieldWebEmpresas;
    private javax.swing.JTextField ingredientes1TextField;
    private javax.swing.JTextField ingredientes2TextField;
    private javax.swing.JTextField ingredientes3TextField;
    private javax.swing.JTextField ingredientes4TextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableEmpresas;
    private javax.swing.JTable jTableParticulares;
    private javax.swing.JTable jTableRestaurantes;
    private javax.swing.JTextField nombreProducto1TextField;
    private javax.swing.JTextField nombreProducto2TextField;
    private javax.swing.JTextField nombreProducto3TextField;
    private javax.swing.JTextField nombreProducto4TextField;
    private javax.swing.JPanel panelInfoClientes;
    private javax.swing.JPanel panelInfoClientes1;
    private javax.swing.JPanel panelInfoRestaurantes;
    private javax.swing.JPanel panelListaRestaurantes;
    private javax.swing.JPanel panelListaRestaurantes1;
    private javax.swing.JPanel panelListaRestaurantes2;
    private javax.swing.JTextField precio1TextField;
    private javax.swing.JTextField precio2TextField;
    private javax.swing.JTextField precio3TextField;
    private javax.swing.JTextField precio4TextField;
    private javax.swing.JTextField precioComida;
    private javax.swing.JPanel precioComidaField;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JLabel txtBuscador;
    private javax.swing.JLabel txtBuscador1;
    private javax.swing.JLabel txtBuscador2;
    private javax.swing.JLabel txtCIF;
    private javax.swing.JLabel txtCIF1;
    private javax.swing.JLabel txtCIF2;
    private javax.swing.JLabel txtCP;
    private javax.swing.JLabel txtCP1;
    private javax.swing.JLabel txtCP2;
    private javax.swing.JLabel txtCalle;
    private javax.swing.JLabel txtCalle1;
    private javax.swing.JLabel txtCalle2;
    private javax.swing.JLabel txtCatering;
    private javax.swing.JLabel txtCiudad;
    private javax.swing.JLabel txtCiudad1;
    private javax.swing.JLabel txtCiudad2;
    private javax.swing.JLabel txtCiudad3;
    private javax.swing.JLabel txtCiudad4;
    private javax.swing.JLabel txtCiudad5;
    private javax.swing.JLabel txtCiudad6;
    private javax.swing.JLabel txtCiudad7;
    private javax.swing.JLabel txtCiudad8;
    private javax.swing.JLabel txtClave;
    private javax.swing.JLabel txtClave1;
    private javax.swing.JLabel txtCorreo;
    private javax.swing.JLabel txtCorreo1;
    private javax.swing.JLabel txtEspecialidad;
    private javax.swing.JLabel txtGastosEnvio;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombre1;
    private javax.swing.JLabel txtNombre2;
    private javax.swing.JLabel txtNumero;
    private javax.swing.JLabel txtNumero1;
    private javax.swing.JLabel txtNumero2;
    private javax.swing.JLabel txtTiempoEnvio;
    private javax.swing.JLabel txtWeb1;
    // End of variables declaration//GEN-END:variables
}
