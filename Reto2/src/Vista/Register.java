package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo_Pojos.Agencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final JOptionPane OptionPane = null;
	private JPanel contentPane;
	private JTextField textNombreAgencia;
	private JTextField textColor;
	private JPanel colorPanel;
	private JTextField textLogo;
	private JPasswordField password;
	private JPasswordField passwordValidar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 531);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreAgencia = new JLabel("Nombre Agencia");
		lblNombreAgencia.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNombreAgencia.setBounds(84, 68, 182, 27);
		contentPane.add(lblNombreAgencia);

		JLabel lblColorDeMarca = new JLabel("Color de Marca");
		lblColorDeMarca.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblColorDeMarca.setBounds(84, 106, 182, 27);
		contentPane.add(lblColorDeMarca);

		JLabel lblNumeroDeEmpleados = new JLabel("Numero de Empleados");
		lblNumeroDeEmpleados.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNumeroDeEmpleados.setBounds(84, 144, 182, 27);
		contentPane.add(lblNumeroDeEmpleados);

		JLabel lblTipoDeAgencia = new JLabel("Tipo de agencia");
		lblTipoDeAgencia.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblTipoDeAgencia.setBounds(84, 182, 182, 27);
		contentPane.add(lblTipoDeAgencia);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblLogo.setBounds(84, 220, 182, 27);
		contentPane.add(lblLogo);

		textNombreAgencia = new JTextField();
		textNombreAgencia.setBounds(297, 69, 214, 27);
		contentPane.add(textNombreAgencia);
		textNombreAgencia.setColumns(10);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblContraseña.setBounds(84, 258, 182, 27);
		contentPane.add(lblContraseña);

		JLabel lblVerificarContraseña = new JLabel("Verifica la Contraseña");
		lblVerificarContraseña.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblVerificarContraseña.setBounds(84, 296, 182, 27);
		contentPane.add(lblVerificarContraseña);

		textColor = new JTextField();
		textColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String hexColor = textColor.getText().trim();

				if (Controlador.validacionColor(hexColor)) {
					// Si el valor es válido, cambiamos el color del panel
					colorPanel.setBackground(Color.decode(hexColor));
				} else {
					// Si no es un color hexadecimal válido, mostramos el color blanco
					colorPanel.setBackground(Color.WHITE);
				}
			}
		});
		textColor.setBounds(297, 107, 140, 27);
		contentPane.add(textColor);
		textColor.setColumns(10);

		colorPanel = new JPanel();
		colorPanel.setBounds(447, 106, 64, 27);
		contentPane.add(colorPanel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Entre 2 y 10 Empleados", "Entre 10 y 100 Empleados", "Entre 100 y 1000 Empleados"}));
		comboBox.setBounds(297, 147, 214, 22);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1
				.setModel(new DefaultComboBoxModel(new String[] { "", "Mayorista", "Minorista", "Mayoria-Minorista" }));
		comboBox_1.setBounds(297, 185, 214, 22);
		contentPane.add(comboBox_1);

		textLogo = new JTextField();
		textLogo.setColumns(10);
		textLogo.setBounds(297, 224, 463, 27);
		contentPane.add(textLogo);

		password = new JPasswordField();
		password.setEchoChar('*');
		password.setBounds(297, 259, 214, 27);
		contentPane.add(password);

		passwordValidar = new JPasswordField();
		passwordValidar.setEchoChar('*');
		passwordValidar.setBounds(297, 300, 214, 27);
		contentPane.add(passwordValidar);

		JButton btnCrearCuenta = new JButton("CREAR CUENTA");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombreAgencia = textNombreAgencia.getText().trim();
				String logo = textLogo.getText().trim();
				String color = textColor.getText().trim();
				String tipoEmpleados = (String) comboBox.getSelectedItem();
				String tipoAgencia = (String) comboBox_1.getSelectedItem();
				String contraseña = new String(password.getPassword()).trim();
				String contraseñaValidar = new String(passwordValidar.getPassword()).trim();

				// Verificar si los campos están vacíos
				if (nombreAgencia.isEmpty() || logo.isEmpty() || color.isEmpty() || tipoEmpleados.isEmpty()
						|| tipoAgencia.isEmpty() || contraseña.isEmpty() || contraseñaValidar.isEmpty()) {
					System.out.println("Error: Todos los campos son obligatorios.");
					return; // Detener la ejecución si hay campos vacíos
				}

				// Llamar al método de validación de contraseñas del controlador
				if (Controlador.validarContraseña(contraseña, contraseñaValidar)) {
					// Si las contraseñas son válidas, proceder con el registro
					Agencia agencia = new Agencia(nombreAgencia, logo, color, tipoEmpleados, tipoAgencia, contraseña);

					if (Controlador.registrarAgencia(agencia)) {
						OptionPane.showMessageDialog(null, "Usuario Creado Correctamente.", "Usuario Creado", JOptionPane.INFORMATION_MESSAGE);
					} else {
						OptionPane.showMessageDialog(null, "Error al Registrar Agencia.", "Error de creacion", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					OptionPane.showMessageDialog(null, "Las Contraseñas NO coinciden.", "Error de contraseñas ", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCrearCuenta.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		btnCrearCuenta.setBounds(81, 362, 185, 76);
		contentPane.add(btnCrearCuenta);

		JButton btnVolverlogin = new JButton("VOLVER AL LOGIN");
		btnVolverlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnVolverlogin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		btnVolverlogin.setBounds(580, 362, 185, 76);
		contentPane.add(btnVolverlogin);
	}
}
