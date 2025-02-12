package Vista;

import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo_Pojos.Agencia;
import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.IATAS;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Pais;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import Controlador.Controlador;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class NuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JComboBox<String> comboBoxTipo;
	private JTextField textCodigoVueloIda;
	private JTextField textAerolineaIda;
	private JTextField textHorarioSalida;
	private JTextField textDuracion;
	private JTextField textPrecio;
	private JTextField txtCodigoVueloVuelta;
	private JTextField textAerolineaVuelta;
	private JTextField textHorarioVuelta;
	private JTextField textDuracionVuelta;
	private JPanel panelVueloVuelta;
	private JPanel panelVuelo;
	private JTextField textOtroPrecio;
	private JTextField textOtroDescripcion;
	private JPanel panelOtros;
	private JDateChooser dateChooserOtro;
	private JComboBox comboBoxTrayecto;

	/**
	 * Create the frame.
	 */
	public NuevoEvento(Viaje viaje, Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 602);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelVuelo = new JPanel();
		panelVuelo.setBounds(0, 88, 749, 394);
		contentPane.add(panelVuelo);
		panelVuelo.setVisible(false);
		panelVuelo.setLayout(null);

		comboBoxTrayecto = new JComboBox();
		comboBoxTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoSeleccionado = (String) comboBoxTrayecto.getSelectedItem();
				switch (tipoSeleccionado) {
				case "Ida": {
					panelVueloVuelta.setVisible(false);
					break;
				}
				case "Ida y vuelta": {
					panelVueloVuelta.setVisible(true);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + tipoSeleccionado);
				}
			}
		});
		comboBoxTrayecto.setModel(new DefaultComboBoxModel(new String[] { "Ida", "Ida y vuelta" }));
		comboBoxTrayecto.setBounds(164, 7, 186, 22);
		panelVuelo.add(comboBoxTrayecto);

		JLabel lblTrayecto = new JLabel("Trayecto");
		lblTrayecto.setBounds(23, 11, 131, 14);
		panelVuelo.add(lblTrayecto);

		JLabel lblAeropuertoorigne = new JLabel("Aeropuerto origen");
		lblAeropuertoorigne.setBounds(23, 45, 131, 14);
		panelVuelo.add(lblAeropuertoorigne);

		JLabel lblAeropuertoDestino = new JLabel("Aeropuerto destino");
		lblAeropuertoDestino.setBounds(23, 82, 131, 14);
		panelVuelo.add(lblAeropuertoDestino);

		JComboBox comboBoxAeropuertoOrigen = new JComboBox();
		comboBoxAeropuertoOrigen.setBounds(164, 41, 106, 22);
		panelVuelo.add(comboBoxAeropuertoOrigen);

		

		JComboBox comboBoxAeropuertoDestino = new JComboBox();
		comboBoxAeropuertoDestino.setBounds(164, 78, 106, 22);
		panelVuelo.add(comboBoxAeropuertoDestino);

		JButton btnBuscarVuelo = new JButton("Buscar Vuelo");
		btnBuscarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.booking.com"));
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "No se pudo abrir el navegador.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnBuscarVuelo.setBounds(328, 61, 186, 23);
		panelVuelo.add(btnBuscarVuelo);

		JLabel lblFechaIda = new JLabel("Fecha Ida");
		lblFechaIda.setBounds(23, 116, 131, 14);
		panelVuelo.add(lblFechaIda);

		JLabel lblCodigoVuelo = new JLabel("Codigo Vuelo");
		lblCodigoVuelo.setBounds(23, 150, 131, 14);
		panelVuelo.add(lblCodigoVuelo);

		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(23, 187, 131, 14);
		panelVuelo.add(lblAerolinea);

		JLabel lblHorarioSalida = new JLabel("Horario salida");
		lblHorarioSalida.setBounds(23, 225, 131, 14);
		panelVuelo.add(lblHorarioSalida);

		JLabel lblDuracin = new JLabel("Duración");
		lblDuracin.setBounds(23, 263, 131, 14);
		panelVuelo.add(lblDuracin);

		JDateChooser dateChooserIda = new JDateChooser();
		dateChooserIda.setBounds(164, 111, 106, 20);
		panelVuelo.add(dateChooserIda);

		textCodigoVueloIda = new JTextField();
		textCodigoVueloIda.setColumns(10);
		textCodigoVueloIda.setBounds(164, 147, 106, 20);
		panelVuelo.add(textCodigoVueloIda);

		textAerolineaIda = new JTextField();
		textAerolineaIda.setColumns(10);
		textAerolineaIda.setBounds(164, 184, 106, 20);
		panelVuelo.add(textAerolineaIda);

		textHorarioSalida = new JTextField();
		textHorarioSalida.setColumns(10);
		textHorarioSalida.setBounds(164, 222, 106, 20);
		panelVuelo.add(textHorarioSalida);

		textDuracion = new JTextField();
		textDuracion.setColumns(10);
		textDuracion.setBounds(164, 260, 106, 20);
		panelVuelo.add(textDuracion);

		panelVueloVuelta = new JPanel();
		panelVueloVuelta.setBounds(328, 95, 351, 202);
		panelVuelo.add(panelVueloVuelta);
		panelVueloVuelta.setLayout(null);

		JLabel lblFechaIda_1 = new JLabel("Fecha Vuelta");
		lblFechaIda_1.setBounds(10, 21, 131, 14);
		panelVueloVuelta.add(lblFechaIda_1);

		JLabel lblCodigoVueloVuelta = new JLabel("Codigo Vuelo");
		lblCodigoVueloVuelta.setBounds(10, 56, 131, 14);
		panelVueloVuelta.add(lblCodigoVueloVuelta);

		JLabel lblAerolineavuelta = new JLabel("AerolineaVuelta");
		lblAerolineavuelta.setBounds(10, 92, 131, 14);
		panelVueloVuelta.add(lblAerolineavuelta);

		JLabel lblHorarioSalida_1 = new JLabel("Horario salida");
		lblHorarioSalida_1.setBounds(10, 127, 131, 14);
		panelVueloVuelta.add(lblHorarioSalida_1);

		JLabel lblDuracinVuelta = new JLabel("Duración Vuelta");
		lblDuracinVuelta.setBounds(10, 164, 131, 14);
		panelVueloVuelta.add(lblDuracinVuelta);

		JDateChooser dateChooserVuelta = new JDateChooser();
		dateChooserVuelta.setBounds(116, 15, 106, 20);
		panelVueloVuelta.add(dateChooserVuelta);

		txtCodigoVueloVuelta = new JTextField();
		txtCodigoVueloVuelta.setColumns(10);
		txtCodigoVueloVuelta.setBounds(116, 53, 106, 20);
		panelVueloVuelta.add(txtCodigoVueloVuelta);

		textAerolineaVuelta = new JTextField();
		textAerolineaVuelta.setColumns(10);
		textAerolineaVuelta.setBounds(116, 89, 106, 20);
		panelVueloVuelta.add(textAerolineaVuelta);

		textHorarioVuelta = new JTextField();
		textHorarioVuelta.setColumns(10);
		textHorarioVuelta.setBounds(116, 124, 106, 20);
		panelVueloVuelta.add(textHorarioVuelta);

		textDuracionVuelta = new JTextField();
		textDuracionVuelta.setColumns(10);
		textDuracionVuelta.setBounds(116, 161, 106, 20);
		panelVueloVuelta.add(textDuracionVuelta);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(23, 298, 131, 14);
		panelVuelo.add(lblPrecio);

		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(164, 295, 106, 20);
		panelVuelo.add(textPrecio);
		panelVueloVuelta.setVisible(false);

		JLabel lblNombre = new JLabel("Nombre evento");
		lblNombre.setBounds(23, 27, 131, 14);
		contentPane.add(lblNombre);

		JLabel lblTipoDeEvento = new JLabel("Tipo de evento");
		lblTipoDeEvento.setBounds(23, 67, 131, 14);
		contentPane.add(lblTipoDeEvento);

		textNombre = new JTextField();
		textNombre.setBounds(164, 24, 183, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		comboBoxTipo = new JComboBox<>();
		comboBoxTipo.setModel(new DefaultComboBoxModel<>(new String[] { "", "Vuelo", "Alojamiento", "Otros" }));
		comboBoxTipo.setBounds(164, 63, 183, 22);
		contentPane.add(comboBoxTipo);

		JButton btnCrearEvento = new JButton("CREAR EVENTO");

		btnCrearEvento.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		btnCrearEvento.setBounds(205, 480, 131, 57);
		contentPane.add(btnCrearEvento);

		JButton btnVolver = new JButton("CANCELAR");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PestañaPrincipal pestañaPrincipal = new PestañaPrincipal(agencia);
				pestañaPrincipal.setVisible(true);
				dispose();
			}

		});
		btnVolver.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		btnVolver.setBounds(391, 480, 131, 57);
		contentPane.add(btnVolver);

		panelOtros = new JPanel();
		panelOtros.setBounds(10, 96, 502, 309);
		contentPane.add(panelOtros);
		panelOtros.setLayout(null);
		panelOtros.setVisible(false);

		JLabel lblOtroDescripcion = new JLabel("Descripción");
		lblOtroDescripcion.setBounds(10, 22, 131, 14);
		panelOtros.add(lblOtroDescripcion);

		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setBounds(10, 103, 131, 14);
		panelOtros.add(lblPrecio_1);

		JLabel lblOtroFecha = new JLabel("Fecha");
		lblOtroFecha.setBounds(10, 140, 131, 14);
		panelOtros.add(lblOtroFecha);

		textOtroPrecio = new JTextField();
		textOtroPrecio.setColumns(10);
		textOtroPrecio.setBounds(156, 100, 183, 20);
		panelOtros.add(textOtroPrecio);

		textOtroDescripcion = new JTextField();
		textOtroDescripcion.setColumns(10);
		textOtroDescripcion.setBounds(156, 19, 300, 70);
		panelOtros.add(textOtroDescripcion);

		dateChooserOtro = new JDateChooser();
		dateChooserOtro.setBounds(156, 140, 183, 20);
		panelOtros.add(dateChooserOtro);

		
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoSeleccionado = (String) comboBoxTipo.getSelectedItem();
				switch (tipoSeleccionado) {
				case "Vuelo": {
					panelVuelo.setVisible(true);
					if (comboBoxTrayecto.equals("Ida")) {
						panelVueloVuelta.setVisible(false);

					} else if (comboBoxTrayecto.equals("Ida y vuelta")) {
						panelVueloVuelta.setVisible(true);

					}
					/* panelAlojamiento.setVisible(false); */
					panelOtros.setVisible(false);

					break;
				}
				case "Alojamiento": {
					panelVuelo.setVisible(false);
					/* panelAlojamiento.setVisible(true); */
					panelOtros.setVisible(false);
					break;
				}
				case "Otros": {
					panelVuelo.setVisible(false);
					/* panelAlojamiento.setVisible(false); */
					panelOtros.setVisible(true);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + tipoSeleccionado);
				}

			}
		});
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eleccion = (String) comboBoxTipo.getSelectedItem();

				switch (eleccion) {
				case "Otros": {
					Otros otro = new Otros();
					String nombre = textNombre.getText().trim();
					Float precio = Float.parseFloat(textOtroPrecio.getText());
					String descripcion = textOtroDescripcion.getText().trim();
					Date fecha = dateChooserOtro.getDate();

					String fechaFormateada = fechaFormato(fecha);

					if (nombre.isEmpty() || precio == null || descripcion.isEmpty() || fechaFormateada.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos para 'Otros'.",
								"Error", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						otro.setNombre(nombre);
						otro.setPrecio(precio);
						otro.setDescripcion(descripcion);
						otro.setFecha(fechaFormateada);
						boolean resultado = Controlador.crearOtro(viaje, otro);

						if (resultado) {
							JOptionPane.showMessageDialog(null, "Evento 'Otros' creado con éxito.", "Éxito",
									JOptionPane.INFORMATION_MESSAGE);
							PestañaPrincipal pestañaPrincipal = new PestañaPrincipal(agencia);
							pestañaPrincipal.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null,
									"Hubo un error al crear el evento. Intenta nuevamente.");
						}
					}
					break;
				}
				case "Vuelo": {
	                String trayecto = (String) comboBoxTrayecto.getSelectedItem();
	                String aeropuertoOrigen = (String) comboBoxAeropuertoOrigen.getSelectedItem();
	                String aeropuertoDestino = (String) comboBoxAeropuertoDestino.getSelectedItem();
	                String aerolinea = textAerolineaIda.getText().trim();
	                float precio = Float.parseFloat(textPrecio.getText().trim());
	                String codigoVuelo = textCodigoVueloIda.getText().trim();
	                Date fechaIda = dateChooserIda.getDate();
	                String fechaSalida = fechaFormato(fechaIda);
	                String horaSalida = textHorarioSalida.getText().trim();
	                String duracion = textDuracion.getText().trim();

	                if (trayecto.equals("Ida")) {
	                    VuelosIda vueloIda = new VuelosIda();
	                    vueloIda.setNombre("Vuelo Ida");
	                    vueloIda.setAerolinea(aerolinea);
	                    vueloIda.setCodigoVuelo(Integer.parseInt(codigoVuelo));
	                    vueloIda.setPrecio(precio);
	                    vueloIda.setFechaSalida(fechaSalida);
	                    vueloIda.setHoraSalida(horaSalida);
	                    vueloIda.setDuracion(duracion);
	                    vueloIda.setSalida(new IATAS(aeropuertoOrigen));
	                    vueloIda.setDestino(new IATAS(aeropuertoDestino));
	                    vueloIda.setViajes(viaje);

	                    boolean resultado = Controlador.crearVueloIda(viaje, vueloIda);

	                    if (resultado) {
	                        JOptionPane.showMessageDialog(null, "Vuelo de ida creado con éxito.", "Éxito",
	                                JOptionPane.INFORMATION_MESSAGE);
	                        PestañaPrincipal pestañaPrincipal = new PestañaPrincipal(agencia);
	                        pestañaPrincipal.setVisible(true);
	                        dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error al crear el vuelo. Intenta nuevamente.");
	                    }
	                } else if (trayecto.equals("Ida y vuelta")) {
	                    String fechaVuelta = fechaFormato(dateChooserVuelta.getDate());
	                    String horaVuelta = textHorarioVuelta.getText().trim();
	                    String duracionVuelta = textDuracionVuelta.getText().trim();

	                    VuelosVuelta vueloVuelta = new VuelosVuelta();
	                    vueloVuelta.setNombre("Vuelo Ida y Vuelta");
	                    vueloVuelta.setAerolinea(aerolinea);
	                    vueloVuelta.setCodigoVuelo(Integer.parseInt(codigoVuelo));
	                    vueloVuelta.setPrecio(precio);
	                    vueloVuelta.setFechaSalida(fechaSalida);
	                    vueloVuelta.setHoraSalida(horaSalida);
	                    vueloVuelta.setDuracion(duracion);
	                    vueloVuelta.setSalida(new IATAS(aeropuertoOrigen));
	                    vueloVuelta.setDestino(new IATAS(aeropuertoDestino));
	                    vueloVuelta.setFechaVuelta(fechaVuelta);
	                    vueloVuelta.setHoraVuelta(horaVuelta);
	                    vueloVuelta.setDuracionVuelta(duracionVuelta);
	                    vueloVuelta.setViajes(viaje);

	                    boolean resultado = Controlador.crearVueloVuelta(viaje, vueloVuelta);

	                    if (resultado) {
	                        JOptionPane.showMessageDialog(null, "Vuelo de ida y vuelta creado con éxito.", "Éxito",
	                                JOptionPane.INFORMATION_MESSAGE);
	                        PestañaPrincipal pestañaPrincipal = new PestañaPrincipal(agencia);
	                        pestañaPrincipal.setVisible(true);
	                        dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error al crear el vuelo. Intenta nuevamente.");
	                    }
	                }
	                break;
	            }

	            default:
	                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de evento válido.", "Error",
	                        JOptionPane.ERROR_MESSAGE);
	                break;
	        }
	    }
	});
		
		ArrayList<IATAS> listaAeropuertos = Controlador.obtenerAeropuerto();

		for (IATAS iata : listaAeropuertos) {
			comboBoxAeropuertoOrigen.addItem(iata.getCodigo());
			comboBoxAeropuertoDestino.addItem(iata.getCodigo());
		}

	}

	public static String fechaFormato(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaFormateada = sdf.format(fecha);
		return fechaFormateada;
	}

}
