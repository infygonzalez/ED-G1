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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PestañaPrincipal frame = new PestañaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PestañaPrincipal() {
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
		scrollViajes.setBounds(187, 98, 452, 99);
		contentPane.add(scrollViajes);

		tableViajes = new JTable();
		tableViajes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Viajes", "Tipo", "Dias", "Fecha Inicio", "Fecha Fin", "Pais" }));
		scrollViajes.setViewportView(tableViajes);

		scrollEventos = new JScrollPane();
		scrollEventos.setBounds(187, 272, 452, 99);
		contentPane.add(scrollEventos);

		tableEventos = new JTable();
		tableEventos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre Evento", "Tipo", "Fecha", "Precio" }));
		scrollEventos.setViewportView(tableEventos);

		JLabel lblViajes = new JLabel("VIAJES");
		lblViajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblViajes.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblViajes.setBounds(345, 21, 122, 66);
		contentPane.add(lblViajes);

		JLabel lblEventos = new JLabel("EVENTOS");
		lblEventos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventos.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblEventos.setBounds(345, 195, 122, 66);
		contentPane.add(lblEventos);

		JButton btnBorrarViajes = new JButton("");
		btnBorrarViajes.setBounds(661, 98, 33, 31);
		contentPane.add(btnBorrarViajes);
		ImageIcon icon = new ImageIcon(BotonInicio.class.getResource("/img/Papelera.png"));
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(btnBorrarViajes.getWidth(), btnBorrarViajes.getHeight(),
				Image.SCALE_SMOOTH);
		btnBorrarViajes.setIcon(new ImageIcon(resizedImage));

		JButton btnBorrarEventos = new JButton("");
		btnBorrarEventos.setBounds(661, 275, 33, 31);
		contentPane.add(btnBorrarEventos);

		ImageIcon iconEventos = new ImageIcon(BotonInicio.class.getResource("/img/Papelera.png"));
		Image imageEventos = iconEventos.getImage();
		Image resizedImageEventos = imageEventos.getScaledInstance(btnBorrarEventos.getWidth(),
				btnBorrarEventos.getHeight(), Image.SCALE_SMOOTH);
		btnBorrarEventos.setIcon(new ImageIcon(resizedImageEventos));

		actualizarViajes();
		actualizarEventos();

	}

	public void actualizarViajes() {
		ArrayList<Viaje> viajes = Controlador.actualizarViajes();
		DefaultTableModel modelo = (DefaultTableModel) tableViajes.getModel();
		modelo.setRowCount(0);
		for (Viaje viaje : viajes) {
			String[] fila = new String[6];
			fila[0] = viaje.getNombreViaje();
			fila[1] = viaje.getTipoViaje();
			fila[2] = viaje.getDuracionViaje();
			fila[3] = viaje.getFechaInicio();
			fila[4] = viaje.getFechaFin();
			fila[5] = viaje.getPais() != null ? viaje.getPais().getPais() : "N/A";
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
		    String[] fila = new String[4];
		    fila[0] = alojamiento.getNombreHotel();
		    fila[1] = "Alojamiento";
		    fila[2] = alojamiento.getFechaEntrada();
		    String precio = String.valueOf(alojamiento.getPrecio());  
		    fila[3] = precio;
		    modelo.addRow(fila);
		}
		
		for (Otros otro : otros) {
		    String[] fila = new String[4];
		    fila[0] = otro.getNombre();
		    fila[1] = "Otros";
		    fila[2] = otro.getFecha();
		    String precio = String.valueOf(otro.getPrecio());  
		    fila[3] = precio;
		    modelo.addRow(fila);
		}
		
		for (VuelosIda vueloIda : vuelosIda) {
		    String[] fila = new String[4];
		    fila[0] = vueloIda.getNombre();
		    fila[1] = "Vuelo Ida";
		    fila[2] = vueloIda.getFechaSalida();
		    String precio = String.valueOf(vueloIda.getPrecio());  
		    fila[3] = precio;
		    modelo.addRow(fila);
		}
		
		 for (VuelosVuelta vueloVuelta : vuelosVuelta) { 
		        String[] fila = new String[4];
		        fila[0] = vueloVuelta.getNombre();
		        fila[1] = "Vuelo Vuelta"; 
		        fila[2] = vueloVuelta.getFechaSalida();
		        String precio = String.valueOf(vueloVuelta.getPrecio());
		        fila[3] = precio;
		        modelo.addRow(fila);
		    }
		
		

	}

}
