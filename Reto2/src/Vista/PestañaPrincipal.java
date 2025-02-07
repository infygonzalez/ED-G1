package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;

import Modelo_Pojos.Agencia;
import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;
import Controlador.Controlador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PestañaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableEventos;
	private JScrollPane scrollViajes;
	private JScrollPane scrollEventos;
	private JTable tableViajes;

	public PestañaPrincipal(Agencia agencia) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 493);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mntmDesconectar.setHorizontalAlignment(SwingConstants.CENTER);
		mntmDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Viaje");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoViaje nuevoViaje = new NuevoViaje(agencia);
	            nuevoViaje.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmNewMenuItem);

		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		JMenuItem mntmNuevoEvento = new JMenuItem("Nuevo Evento");
		mntmNuevoEvento.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmNuevoEvento);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue_1);

		JMenuItem mntmOfertaCliente = new JMenuItem("Oferta Cliente");
		mntmOfertaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmOfertaCliente);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue_2);
		menuBar.add(mntmDesconectar);

		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollViajes = new JScrollPane();
		scrollViajes.setBounds(212, 142, 552, 99);
		contentPane.add(scrollViajes);

		tableViajes = new JTable();
		tableViajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = tableViajes.getSelectedRow();
				if (filaSeleccionada != -1) {
					int viajeId = Integer.parseInt(tableViajes.getValueAt(filaSeleccionada, 0).toString());
					Viaje viaje = new Viaje();
					viaje.setId(viajeId);

					actualizarEventos(viaje);
				}
			}
		});
		tableViajes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Viajes", "Tipo", "Dias", "Fecha Inicio", "Fecha Fin", "Pais" }));
		scrollViajes.setViewportView(tableViajes);

		scrollEventos = new JScrollPane();
		scrollEventos.setBounds(212, 316, 552, 99);
		contentPane.add(scrollEventos);

		tableEventos = new JTable();
		tableEventos.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nombre Evento", "Tipo", "Fecha", "Precio" }));
		scrollEventos.setViewportView(tableEventos);

		JLabel lblViajes = new JLabel("VIAJES");
		lblViajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblViajes.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblViajes.setBounds(426, 77, 122, 66);
		contentPane.add(lblViajes);

		JLabel lblEventos = new JLabel("EVENTOS");
		lblEventos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventos.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblEventos.setBounds(426, 253, 122, 66);
		contentPane.add(lblEventos);

		JButton btnBorrarViajes = new JButton("");
		btnBorrarViajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tableViajes.getSelectedRow();
				if (filaSeleccionada != -1) {
					int viajeId = Integer.parseInt(tableViajes.getValueAt(filaSeleccionada, 0).toString());
					int opcion = JOptionPane.showConfirmDialog(null,
							"¿Estás seguro de que quieres eliminar este viaje y sus eventos asociados?",
							"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (opcion == JOptionPane.YES_OPTION) {
						boolean eventosEliminados = Controlador.borrarEventosPorViaje(viajeId);

						if (eventosEliminados) {
							boolean viajeEliminado = Controlador.borrarViaje(viajeId);
							if (viajeEliminado) {
								DefaultTableModel modelo = (DefaultTableModel) tableViajes.getModel();
								modelo.removeRow(filaSeleccionada); 
								JOptionPane.showMessageDialog(null, "Viaje y eventos eliminados correctamente.");
							} else {
								JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el viaje.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Hubo un error al eliminar los eventos asociados.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona un viaje para eliminar.");
				}
			}
		});
		btnBorrarViajes.setBounds(774, 145, 33, 31);
		contentPane.add(btnBorrarViajes);
		ImageIcon iconViajes = new ImageIcon(BotonInicio.class.getResource("/img/Papelera.png"));
		Image imageViajes = iconViajes.getImage();
		Image resizedViajes = imageViajes.getScaledInstance(btnBorrarViajes.getWidth(), btnBorrarViajes.getHeight(),
				Image.SCALE_SMOOTH);
		btnBorrarViajes.setIcon(new ImageIcon(resizedViajes));

		JButton btnBorrarEventos = new JButton("");
		btnBorrarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tableEventos.getSelectedRow();
				if (filaSeleccionada != -1) {
					int eventoId = Integer.parseInt(tableEventos.getValueAt(filaSeleccionada, 0).toString());
					String tipoEvento = tableEventos.getValueAt(filaSeleccionada, 2).toString();
																									
					int opcion = JOptionPane.showConfirmDialog(null,
							"¿Estás seguro de que quieres eliminar este evento?", "Confirmar eliminación",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (opcion == JOptionPane.YES_OPTION) {
						DefaultTableModel modelo = (DefaultTableModel) tableEventos.getModel();
						modelo.removeRow(filaSeleccionada);
						boolean eliminado = Controlador.borrarEvento(eventoId, tipoEvento); 
						if (eliminado) {
							JOptionPane.showMessageDialog(null, "Evento eliminado correctamente.");
						} else {
							JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el evento.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecciona un evento para eliminar.");
				}
			}
		});
		btnBorrarEventos.setBounds(774, 324, 33, 31);
		contentPane.add(btnBorrarEventos);
		ImageIcon iconEventos = new ImageIcon(BotonInicio.class.getResource("/img/Papelera.png"));
		Image imageEventos = iconEventos.getImage();
		Image resizedImageEventos = imageEventos.getScaledInstance(btnBorrarEventos.getWidth(),
				btnBorrarEventos.getHeight(), Image.SCALE_SMOOTH);
		btnBorrarEventos.setIcon(new ImageIcon(resizedImageEventos));

		JLabel lblHolaX = new JLabel("HOLA " + agencia.getNombre().toUpperCase() + "!");
		lblHolaX.setHorizontalAlignment(SwingConstants.CENTER);
		lblHolaX.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblHolaX.setBounds(10, 42, 250, 66);
		contentPane.add(lblHolaX);
		
		
		
		
		String logoUrl = agencia.getLogo();
		URL imgUrl = null;
		try {
		    imgUrl = new URL(logoUrl);
		} catch (MalformedURLException e) {
		    e.printStackTrace();
		}

		ImageIcon image = new ImageIcon(imgUrl);
		Image img = image.getImage();  // Obtener la imagen original
		Image resizedImg = img.getScaledInstance(163, 149, Image.SCALE_SMOOTH);  // Redimensionar la imagen

		JLabel lblNewLabel = new JLabel(new ImageIcon(resizedImg));  // Usar la imagen redimensionada en el JLabel
		lblNewLabel.setBounds(10, 142, 163, 149);  // Establecer el tamaño del JLabel
		contentPane.add(lblNewLabel);

		contentPane.revalidate();  // Forzar la validación de los componentes
		contentPane.repaint();    // Redibujar el panel



		

		actualizarViajes(agencia);

	}

	public void actualizarViajes(Agencia agencia) {
		ArrayList<Viaje> viajes = Controlador.obtenerViajesPorAgencia(agencia);
		DefaultTableModel modelo = (DefaultTableModel) tableViajes.getModel();
		modelo.setRowCount(0);
		for (Viaje viaje : viajes) {
			String[] fila = new String[7];
			String id = String.valueOf(viaje.getId());
			fila[0] = id;
			fila[1] = viaje.getNombreViaje();
			fila[2] = viaje.getTipoViaje();
			fila[3] = viaje.getDuracionViaje();
			fila[4] = viaje.getFechaInicio();
			fila[5] = viaje.getFechaFin();
			fila[6] = viaje.getPais() != null ? viaje.getPais().getPais() : "N/A"; // Actualizado para que sea el país
																					// directamente
			modelo.addRow(fila);
		}
	}

	public void actualizarEventos(Viaje viaje) {
		ArrayList<Alojamiento> alojamientos = Controlador.obtenerAlojamientosPorAgencia(viaje);
		ArrayList<Otros> otros = Controlador.obtenerOtrosPorAgencia(viaje);
		ArrayList<VuelosIda> vuelosIda = Controlador.obtenerVuelosIdaPorAgencia(viaje);
		ArrayList<VuelosVuelta> vuelosVuelta = Controlador.obtenerVuelosVueltaPorAgencia(viaje);

		DefaultTableModel modelo = (DefaultTableModel) tableEventos.getModel();
		modelo.setRowCount(0);

		// Alojamiento
		for (Alojamiento alojamiento : alojamientos) {
			String[] fila = new String[5];
			String id = String.valueOf(alojamiento.getId());
			fila[0] = id;
			fila[1] = alojamiento.getNombreHotel();
			fila[2] = "Alojamiento";
			fila[3] = alojamiento.getFechaEntrada();
			String precio = String.valueOf(alojamiento.getPrecio());
			fila[4] = precio;
			modelo.addRow(fila);
		}

		// Otros
		for (Otros otro : otros) {
			String[] fila = new String[5];
			String id = String.valueOf(otro.getId());
			fila[0] = id;
			fila[1] = otro.getNombre();
			fila[2] = "Otros";
			fila[3] = otro.getFecha();
			String precio = String.valueOf(otro.getPrecio());
			fila[4] = precio;
			modelo.addRow(fila);
		}

		// Vuelos de Ida
		for (VuelosIda vueloIda : vuelosIda) {
			String[] fila = new String[5];
			String id = String.valueOf(vueloIda.getCodigoVuelo());
			fila[0] = id;
			fila[1] = vueloIda.getNombre();
			fila[2] = "Vuelo Ida";
			fila[3] = vueloIda.getFechaSalida();
			String precio = String.valueOf(vueloIda.getPrecio());
			fila[4] = precio;
			modelo.addRow(fila);
		}

		// Vuelos de Vuelta
		for (VuelosVuelta vueloVuelta : vuelosVuelta) {
			String[] fila = new String[5];
			String id = String.valueOf(vueloVuelta.getCodigoVuelo());
			fila[0] = id;
			fila[1] = vueloVuelta.getNombre();
			fila[2] = "Vuelo Vuelta";
			fila[3] = vueloVuelta.getFechaSalida();
			String precio = String.valueOf(vueloVuelta.getPrecio());
			fila[4] = precio;
			modelo.addRow(fila);
		}
	}
}
