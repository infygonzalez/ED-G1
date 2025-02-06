package Vista;

import java.awt.EventQueue;

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
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

import Modelo_Pojos.Agencia;
import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.Evento;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;
import Controlador.Controlador;

public class PestañaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableEventos;
	private JScrollPane scrollViajes;
	private JScrollPane scrollEventos;
	private JTable tableViajes;


	/**
	 * Create the frame.
	 */
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
		tableViajes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {"ID", "Viajes", "Tipo", "Dias", "Fecha Inicio", "Fecha Fin", "Pais" }));
		scrollViajes.setViewportView(tableViajes);

		scrollEventos = new JScrollPane();
		scrollEventos.setBounds(212, 316, 552, 99);
		contentPane.add(scrollEventos);

		tableEventos = new JTable();
		tableEventos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] {"ID", "Nombre Evento", "Tipo", "Fecha", "Precio" }));
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
			                "¿Estás seguro de que quieres eliminar este viaje?", 
			                "Confirmar eliminación", 
			                JOptionPane.YES_NO_OPTION, 
			                JOptionPane.WARNING_MESSAGE);
			            
			            if (opcion == JOptionPane.YES_OPTION) {
			                DefaultTableModel modelo = (DefaultTableModel) tableViajes.getModel();
			                modelo.removeRow(filaSeleccionada);
			                
			                
			                boolean eliminado = Controlador.borrarViajes(viajeId);
			                if (eliminado) {
			                    JOptionPane.showMessageDialog(null, "Viaje eliminado correctamente.");
			                } else {
			                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el viaje.");
			                }
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Por favor, selecciona un viaje para eliminar.");
			        }

			}
		});
		btnBorrarViajes.setBounds(774, 145, 33, 31);
		contentPane.add(btnBorrarViajes);
		ImageIcon icon = new ImageIcon(BotonInicio.class.getResource("/img/Papelera.png"));
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(btnBorrarViajes.getWidth(), btnBorrarViajes.getHeight(),
				Image.SCALE_SMOOTH);
		btnBorrarViajes.setIcon(new ImageIcon(resizedImage));

		JButton btnBorrarEventos = new JButton("");
		btnBorrarEventos.setBounds(774, 324, 33, 31);
		contentPane.add(btnBorrarEventos);

		ImageIcon iconEventos = new ImageIcon(BotonInicio.class.getResource("/img/Papelera.png"));
		Image imageEventos = iconEventos.getImage();
		Image resizedImageEventos = imageEventos.getScaledInstance(btnBorrarEventos.getWidth(),
				btnBorrarEventos.getHeight(), Image.SCALE_SMOOTH);
		btnBorrarEventos.setIcon(new ImageIcon(resizedImageEventos));
		
		JLabel lblNewLabel = new JLabel("Imagen");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 166, 154, 153);
		contentPane.add(lblNewLabel);
		
		JLabel lblHolaX = new JLabel("HOLA (NOMBRE)!");
		lblHolaX.setHorizontalAlignment(SwingConstants.CENTER);
		lblHolaX.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblHolaX.setBounds(10, 42, 250, 66);
		contentPane.add(lblHolaX);

		actualizarViajes();
		actualizarEventos();

	}

	public void actualizarViajes() {
		ArrayList<Viaje> viajes = Controlador.actualizarViajes();
		DefaultTableModel modelo = (DefaultTableModel) tableViajes.getModel();
		modelo.setRowCount(0);
		for (Viaje viaje : viajes) {
			String[] fila = new String[7];
			String id = String.valueOf(viaje.getId()) ;
			fila[0] = id;
			fila[1] = viaje.getNombreViaje();
			fila[2] = viaje.getTipoViaje();
			fila[3] = viaje.getDuracionViaje();
			fila[4] = viaje.getFechaInicio();
			fila[5] = viaje.getFechaFin();
			fila[6] = viaje.getPais() != null ? viaje.getPais().getPais() : "N/A";
			modelo.addRow(fila);
		}

	}

	public void actualizarEventos() {
		ArrayList<Alojamiento> alojamientos = Controlador.actualizarAlojamiento();
		ArrayList<Otros> otros = Controlador.actualizarOtros();
		ArrayList<VuelosIda> vuelosIda = Controlador.actualizarVuelosIda();
		ArrayList<VuelosVuelta> vuelosVuelta = Controlador.actualizarVuelosVuelta();

		DefaultTableModel modelo = (DefaultTableModel) tableEventos.getModel();
		modelo.setRowCount(0);

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
