package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class NuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreViaje;
	private JTextField textTipoViaje;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public NuevoViaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 493);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblPais.setBounds(460, 25, 122, 47);
		contentPane.add(lblPais);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblDescripcion.setBounds(460, 102, 122, 66);
		contentPane.add(lblDescripcion);
		
		JLabel lblServiciosNoIncliidos = new JLabel("Servicios no Incluidos");
		lblServiciosNoIncliidos.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblServiciosNoIncliidos.setBounds(460, 250, 191, 66);
		contentPane.add(lblServiciosNoIncliidos);
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(197, 319, 51, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(460, 155, 291, 97);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(460, 310, 291, 97);
		contentPane.add(textField_2);
		
		JComboBox comboBoxPais = new JComboBox();
		comboBoxPais.setBounds(547, 38, 204, 22);
		contentPane.add(comboBoxPais);
	}
}
