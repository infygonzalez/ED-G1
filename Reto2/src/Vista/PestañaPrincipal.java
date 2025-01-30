package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JCheckBox;

public class PestañaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableEventos;

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
		
		JScrollPane scrollViajes = new JScrollPane();
		scrollViajes.setBounds(187, 98, 452, 99);
		contentPane.add(scrollViajes);
		
		JTable tableViajes = new JTable();
		tableViajes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Viajes", "Tipo", "Dias", "Fecha Inicio", "FechaFin", "Pais"
			}
		));
		scrollViajes.setViewportView(tableViajes);
		
		JScrollPane scrollEventos = new JScrollPane();
		scrollEventos.setBounds(187, 272, 452, 99);
		contentPane.add(scrollEventos);
		
		tableEventos = new JTable();
		tableEventos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre Evento", "Tipo", "Fecha", "Precio"
			}
		));
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
	}
}
