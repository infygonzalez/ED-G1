package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Controlador.Controlador;
import Modelo_Pojos.Agencia;
import Modelo_Pojos.Pais;
import Modelo_Pojos.Viaje;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class NuevoViaje extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombreViaje;
    private JTextField textTipoViaje;
    private JTextField textDias;
    private JTextField textDescripcion;
    private JTextField textServiciosNoIncluidos;

    public NuevoViaje(Agencia agencia) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 816, 493);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Labels
        JLabel lblNombreViaje = new JLabel("Nombre Viaje");
        lblNombreViaje.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblNombreViaje.setBounds(23, 25, 122, 47);
        contentPane.add(lblNombreViaje);

        JLabel lblTipoDeViaje = new JLabel("Tipo de Viaje");
        lblTipoDeViaje.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblTipoDeViaje.setBounds(23, 91, 122, 47);
        contentPane.add(lblTipoDeViaje);

        JLabel lblInicioViaje = new JLabel("Inicio Viaje");
        lblInicioViaje.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblInicioViaje.setBounds(23, 168, 122, 47);
        contentPane.add(lblInicioViaje);

        JLabel lblFinViaje = new JLabel("Fin Viaje");
        lblFinViaje.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblFinViaje.setBounds(23, 234, 122, 47);
        contentPane.add(lblFinViaje);

        JLabel lblDias = new JLabel("Dias");
        lblDias.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblDias.setBounds(23, 310, 122, 47);
        contentPane.add(lblDias);

        // Text Fields
        textNombreViaje = new JTextField();
        textNombreViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textNombreViaje.setColumns(10);
        textNombreViaje.setBounds(139, 34, 161, 28);
        contentPane.add(textNombreViaje);

        textTipoViaje = new JTextField();
        textTipoViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textTipoViaje.setColumns(10);
        textTipoViaje.setBounds(139, 100, 161, 28);
        contentPane.add(textTipoViaje);

        textDias = new JTextField();
        textDias.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textDias.setColumns(10);
        textDias.setBounds(197, 319, 51, 28);
        textDias.setEditable(false); // Deshabilitar edición manual
        contentPane.add(textDias);

        textDescripcion = new JTextField();
        textDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
        textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textDescripcion.setColumns(10);
        textDescripcion.setBounds(414, 155, 337, 97);
        contentPane.add(textDescripcion);

        textServiciosNoIncluidos = new JTextField();
        textServiciosNoIncluidos.setHorizontalAlignment(SwingConstants.LEFT);
        textServiciosNoIncluidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textServiciosNoIncluidos.setColumns(10);
        textServiciosNoIncluidos.setBounds(414, 310, 337, 97);
        contentPane.add(textServiciosNoIncluidos);

        // ComboBox para País
        JComboBox comboBoxPais = new JComboBox();
        comboBoxPais.setBounds(547, 38, 204, 22);
        contentPane.add(comboBoxPais);

        // Obtener la lista de países desde el controlador
        ArrayList<Pais> listaPaises = Controlador.obtenerPaises();

        // Rellenar el ComboBox con los nombres de los países
        for (Pais pais : listaPaises) {
            comboBoxPais.addItem(pais.getNombre());  // Agregar el objeto Pais completo
        }

        // JDateChoosers
        JDateChooser dateChooserInicio = new JDateChooser();
        dateChooserInicio.setBounds(139, 180, 161, 20);
        dateChooserInicio.setDateFormatString("dd/MM/yyyy");  // Establecer el formato Día/Mes/Año
        contentPane.add(dateChooserInicio);

        JDateChooser dateChooserFin = new JDateChooser();
        dateChooserFin.setBounds(139, 246, 161, 20);
        dateChooserFin.setDateFormatString("dd/MM/yyyy");  // Establecer el formato Día/Mes/Año
        contentPane.add(dateChooserFin);

        // Botones
        JButton btnCrearViaje = new JButton("CREAR VIAJE");
        btnCrearViaje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 String nombreViaje = textNombreViaje.getText();
                 String tipoViaje = textTipoViaje.getText();
                 Date fechaInicio = dateChooserInicio.getDate();
                 Date fechaFin = dateChooserFin.getDate();
                 String dias = textDias.getText();
                 String paisSeleccionado = (String) comboBoxPais.getSelectedItem();
                 String descripcion = textDescripcion.getText();
                 String serviciosNoIncluidos = textServiciosNoIncluidos.getText();

                 // Verificación de campos vacíos
                 if (nombreViaje.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del viaje.");
                     return;
                 }
                 if (tipoViaje.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Por favor, ingrese el tipo de viaje.");
                     return;
                 }
                 if (fechaInicio == null || fechaFin == null) {
                     JOptionPane.showMessageDialog(null, "Por favor, selecciona las fechas de inicio y fin del viaje.");
                     return;
                 }
                 if (fechaFin.before(fechaInicio)) {
                     JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser anterior a la fecha de inicio.");
                     return;
                 }
                 if (paisSeleccionado == null || paisSeleccionado.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Por favor, seleccione un país.");
                     return;
                 }
                 if (descripcion.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Por favor, ingrese una descripción para el viaje.");
                     return;
                 }
                 if (serviciosNoIncluidos.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Por favor, ingrese los servicios no incluidos.");
                     return;
                 }

                 // Si todo está válido, crear el viaje
                 Pais pais = new Pais();
                 pais.setPais(paisSeleccionado);

                 Viaje viaje = new Viaje();
                 viaje.setNombreViaje(nombreViaje);
                 viaje.setTipoViaje(tipoViaje);
                 viaje.setDescripcion(descripcion);
                 viaje.setServiciosNoIncluidos(serviciosNoIncluidos);
                 viaje.setPais(pais);

                 // Formatear las fechas al formato "dd/MM/yyyy"
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                 String fechaInicioFormateada = sdf.format(fechaInicio);
                 String fechaFinFormateada = sdf.format(fechaFin);

                 viaje.setFechaInicio(fechaInicioFormateada);
                 viaje.setFechaFin(fechaFinFormateada);
                 viaje.setDuracionViaje(dias);

                 boolean resultado = Controlador.crearViaje(viaje, agencia);

                 if (resultado) {
                     JOptionPane.showMessageDialog(null, "Viaje creado exitosamente.");
                     PestañaPrincipal pestañaPrincipal = new PestañaPrincipal(agencia);
                     pestañaPrincipal.setVisible(true);
                     dispose();
                 } else {
                     JOptionPane.showMessageDialog(null, "Hubo un error al crear el viaje. Intenta nuevamente.");
                 }
            }
        });
        btnCrearViaje.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
        btnCrearViaje.setBounds(23, 386, 122, 57);
        contentPane.add(btnCrearViaje);

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PestañaPrincipal pestañaPrincipal = new PestañaPrincipal(agencia);
                pestañaPrincipal.setVisible(true);
                dispose();
            }
        });
        btnCancelar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
        btnCancelar.setBounds(217, 386, 122, 57);
        contentPane.add(btnCancelar);
        
        JLabel lblPais = new JLabel("Pais");
        lblPais.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblPais.setBounds(414, 25, 122, 47);
        contentPane.add(lblPais);
        
        JLabel lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblDescripcion.setBounds(414, 108, 122, 47);
        contentPane.add(lblDescripcion);
        
        JLabel lblServiciosNoIncluidos = new JLabel("Servicios No Incluidos");
        lblServiciosNoIncluidos.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblServiciosNoIncluidos.setBounds(414, 263, 161, 47);
        contentPane.add(lblServiciosNoIncluidos);

        // Listener para asegurar que la fecha de fin no sea menor que la fecha de inicio
        dateChooserInicio.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (dateChooserInicio.getDate() != null) {
                    dateChooserFin.setMinSelectableDate(dateChooserInicio.getDate());
                    actualizarDias(dateChooserInicio.getDate(), dateChooserFin.getDate());
                }
            }
        });

        dateChooserFin.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (dateChooserFin.getDate() != null && dateChooserInicio.getDate() != null) {
                    actualizarDias(dateChooserInicio.getDate(), dateChooserFin.getDate());
                }
            }
        });
    }

    private void actualizarDias(Date inicio, Date fin) {
        if (inicio != null && fin != null) {
            long diferencia = fin.getTime() - inicio.getTime();
            long dias = diferencia / (1000 * 60 * 60 * 24);
            textDias.setText(String.valueOf(dias));
        }
    }
}