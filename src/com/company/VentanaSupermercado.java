package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

public class VentanaSupermercado implements ActionListener, MouseListener {

    private JPanel rootPanel;
    private JTextArea textAreaCarrito;
    private JTextField textFieldBuscar;
    private JTable tablaProducto;
    private JButton buttonAgregar;
    private JButton buttonEliminar;
    private JButton buttonFormarCarrito;
    private JButton buttonbuscar;
    private JButton buttonCobrar;
    private JLabel JLabelNumCajero;
    private JLabel JLabelNombCajero;
    private JLabel JLabelNumCarrito;
    private JLabel JLabelNumeroCajero;
    private JLabel JLabelNombreCajero;
    private JLabel JLabelCarritosFormados;
    private JLabel JLabelProducto;
    private JLabel JLabelCarrito;
    private JLabel LabelBuscarCodigo;
    private JScrollPane JScrollPanelProducto;
    private JScrollPane JScrollPanelCarrito;
    private JTabbedPane tabbedPane1;
    private JScrollPane JScrollPaneProducto;
    private JTextArea textAreaProducto;
    private JComboBox comboBoxNumeroCaja;

    private int filaSeleccionada;

    private Vector<Producto> listaproducto;
    private ArrayList<Integer> cantpend = new ArrayList<>();
    private ArrayList<Integer> cantpend2 = new ArrayList<>();
    private ArrayList<Integer> cantpend3 = new ArrayList<>();

    private Carrito carrito = new Carrito();
    public Caja caja = new Caja();
    public Caja caja2 = new Caja();
    public Caja caja3 = new Caja();
    private String op = "";


    public VentanaSupermercado() {

        JFrame frame = new JFrame("Consulta Supermercado");
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        iniciarComponentes();
        creartabla();
    }

    public void iniciarComponentes() {

        textAreaCarrito.setColumns(0);
        textAreaCarrito.setRows(10);

        buttonbuscar.addActionListener(this);
        buttonAgregar.addActionListener(this);
        buttonEliminar.addActionListener(this);
        buttonFormarCarrito.addActionListener(this);
        buttonCobrar.addActionListener(this);

        textAreaProducto.setColumns(10);
        textAreaProducto.setRows(10);

        comboBoxNumeroCaja.addItem("Seleccione caja");
        comboBoxNumeroCaja.addItem("Caja 1");
        comboBoxNumeroCaja.addItem("Caja 2");
        comboBoxNumeroCaja.addItem("Caja 3");
        comboBoxNumeroCaja.setSelectedIndex(0);
        comboBoxNumeroCaja.addActionListener(this);

        tablaProducto.addMouseListener(this);

        caja.setNombrecajero("Anthony Stark");
        caja.setNumeroCaja(1038051);

        caja2.setNombrecajero("Matt Murdock");
        caja2.setNumeroCaja(1038052);

        caja3.setNombrecajero("Peter Paker");
        caja3.setNumeroCaja(1038053);
    }

    private void creartabla() {

        listaproducto = agregarProducto();

        String informacion[][] = new String[listaproducto.size()][4];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][0] = listaproducto.get(x).getCodigo() + "";
            informacion[x][1] = listaproducto.get(x).getNombre() + "";
            informacion[x][2] = listaproducto.get(x).getPrecio() + "";
            informacion[x][3] = listaproducto.get(x).getExistencias() + "";
        }

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
                informacion,
                new String[]{
                        "Codigo", "Nombre", "Precio", "Existencias"
                }
        ));

        tablaProducto.getColumnModel().getColumn(0).setPreferredWidth(90);
        tablaProducto.getColumnModel().getColumn(1).setPreferredWidth(300);
        tablaProducto.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaProducto.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private Vector<Producto> agregarProducto() {
        Vector<Producto> lista = new Vector<>();
        lista.add(new Producto(1, "Jack Daniel's", 425, 10));
        lista.add(new Producto(2, "Jack Daniel's Gentleman", 705, 10));
        lista.add(new Producto(3, "Jack Daniel's Tennessee Honey", 459, 10));
        lista.add(new Producto(4, "Jack Daniel's Single Barrel", 1174, 10));
        lista.add(new Producto(5, "Red lavel", 335, 10));
        lista.add(new Producto(6, "Black lavel", 845, 10));
        lista.add(new Producto(7, "Double Black", 955, 10));
        lista.add(new Producto(8, "Gold Lavel", 1299, 10));
        lista.add(new Producto(9, "Green lavel", 1225, 10));
        lista.add(new Producto(10, "Platinum 18 Años", 1955, 10));
        lista.add(new Producto(11, "Blue lavel", 5499, 10));
        return lista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonbuscar) {
            String valor = textFieldBuscar.getText();
            boolean bandera = false;
            for (int i = 0; i < tablaProducto.getRowCount(); i++) {
                if (tablaProducto.getValueAt(i, 0).equals(valor)) {
                    tablaProducto.changeSelection(i, 0, false, false);
                    bandera = true;
                }
            }
            if (!bandera) {
                JOptionPane.showMessageDialog(null, "No existe producto");
            }
        }

        if (e.getSource() == buttonAgregar) {

            Producto producto;
            producto = new Producto(listaproducto.elementAt(filaSeleccionada).getCodigo(),
                    listaproducto.elementAt(filaSeleccionada).getNombre(),
                    listaproducto.elementAt(filaSeleccionada).getPrecio(),
                    listaproducto.elementAt(filaSeleccionada).getExistencias());

            carrito.setPila(carrito.push(carrito.getPila(), producto));

            textAreaCarrito.setText("");
            textAreaCarrito.setText(carrito.toString(carrito.getPila()));

        }

        if (e.getSource() == buttonEliminar) {

            carrito.setPila(carrito.pop(carrito.getPila()));

            textAreaCarrito.setText("");
            textAreaCarrito.setText(carrito.toString(carrito.getPila()));

        }

        if (e.getSource() == buttonFormarCarrito) {

            String input = JOptionPane.showInputDialog(null, "Ingrese el numero de caja donde se desea formar: \n" +
                    "1, 2 o 3");
            switch (input) {
                case "1":
                    cantpend.add(1);
                    caja.setCola(caja.push(caja.getCola(), carrito));
                    carrito = new Carrito();
                    break;
                case "2":
                    cantpend2.add(1);
                    caja2.setCola(caja2.push(caja2.getCola(), carrito));
                    carrito = new Carrito();
                    break;
                case "3":
                    cantpend3.add(1);
                    caja3.setCola(caja3.push(caja3.getCola(), carrito));
                    carrito = new Carrito();
                    break;

                default:
            }
            textAreaCarrito.setText("");

        }

        if (e.getSource() == buttonCobrar) {

            switch (op) {
                case "Seleccione caja":
                    JOptionPane.showMessageDialog(null, "seleccione caja");
                    break;
                case "Caja 1":
                    cantpend.remove(0);
                    int total = 0;
                    for (int i = 0; i < cantpend.size(); i++) {
                        total += cantpend.get(i);
                    }
                    caja.setNumeroCarritoFormado(total);
                    caja.setCola(caja.pop(caja.getCola()));
                    textAreaProducto.setText(caja.toString(caja.getCola()));
                    JLabelNumCarrito.setText(String.valueOf(caja.getNumeroCarritoFormado()));
                    JOptionPane.showMessageDialog(null, caja.ticket(caja.getPrimero()));

                    break;

                case "Caja 2":
                    cantpend2.remove(0);
                    int total2 = 0;
                    for (int i = 0; i < cantpend2.size(); i++) {
                        total2 += cantpend2.get(i);
                    }
                    caja2.setNumeroCarritoFormado(total2);
                    caja2.setCola(caja2.pop(caja2.getCola()));
                    textAreaProducto.setText(caja2.toString(caja2.getCola()));
                    JLabelNumCarrito.setText(String.valueOf(caja2.getNumeroCarritoFormado()));
                    JOptionPane.showMessageDialog(null, caja2.ticket(caja2.getPrimero()));
                    break;
                case "Caja 3":
                    cantpend3.remove(0);
                    int total3 = 0;
                    for (int i = 0; i < cantpend3.size(); i++) {
                        total3 += cantpend3.get(i);
                    }
                    caja3.setNumeroCarritoFormado(total3);
                    caja3.setCola(caja3.pop(caja3.getCola()));
                    textAreaProducto.setText(caja3.toString(caja3.getCola()));
                    JLabelNumCarrito.setText(String.valueOf(caja3.getNumeroCarritoFormado()));
                    JOptionPane.showMessageDialog(null, caja3.ticket(caja3.getPrimero()));
                default:
                    break;
            }

        }

        if (e.getSource() == comboBoxNumeroCaja) {

            JComboBox cb = (JComboBox) e.getSource();
            op = String.valueOf(cb.getSelectedItem());

            switch (op) {
                case "Seleccione caja":
                    JLabelNumCajero.setText("\n");
                    JLabelNombCajero.setText("\n");
                    JLabelNumCarrito.setText("\n");
                    textAreaProducto.setText("\n");

                    break;
                case "Caja 1":
                    int total = 0;
                    for (int i = 0; i < cantpend.size(); i++) {
                        total += cantpend.get(i);
                    }
                    caja.setNumeroCarritoFormado(total);
                    JLabelNumCajero.setText(String.valueOf(caja.getNumeroCaja()));
                    JLabelNombCajero.setText(String.valueOf(caja.getNombrecajero()));
                    JLabelNumCarrito.setText(String.valueOf(caja.getNumeroCarritoFormado()));
                    textAreaProducto.setText(caja.toString(caja.getCola()));
                    break;
                case "Caja 2":
                    int total2 = 0;
                    for (int i = 0; i < cantpend2.size(); i++) {
                        total2 += cantpend2.get(i);
                    }
                    caja2.setNumeroCarritoFormado(total2);
                    JLabelNumCajero.setText(String.valueOf(caja2.getNumeroCaja()));
                    JLabelNombCajero.setText(String.valueOf(caja2.getNombrecajero()));
                    JLabelNumCarrito.setText(String.valueOf(caja2.getNumeroCarritoFormado()));
                    textAreaProducto.setText(caja2.toString(caja2.getCola()));
                    break;
                case "Caja 3":
                    int total3 = 0;
                    for (int i = 0; i < cantpend3.size(); i++) {
                        total3 += cantpend3.get(i);
                    }
                    caja3.setNumeroCarritoFormado(total3);
                    JLabelNumCajero.setText(String.valueOf(caja3.getNumeroCaja()));
                    JLabelNombCajero.setText(String.valueOf(caja3.getNombrecajero()));
                    JLabelNumCarrito.setText(String.valueOf(caja3.getNumeroCarritoFormado()));
                    textAreaProducto.setText(caja3.toString(caja3.getCola()));
                default:
                    break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        filaSeleccionada = tablaProducto.rowAtPoint(e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}