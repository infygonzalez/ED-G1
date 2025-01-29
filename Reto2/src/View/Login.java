package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import Controller.Gestor;
import Model_Pojos.Agencia;
import View.Registrar;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JPasswordField passwordContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInicio.setVisible(false);
			}
		});
		btnInicio.setIcon(new ImageIcon(Login.class.getResource("/img/istockphoto-155439315-612x612.jpg")));
		btnInicio.setBounds(-12, 0, 645, 355);
		contentPane.add(btnInicio);

		lblTitulo = new JLabel("Viajes Erreka-Mari");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblTitulo.setBounds(171, 11, 269, 68);
		contentPane.add(lblTitulo);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblUsuario.setBounds(87, 100, 91, 25);
		contentPane.add(lblUsuario);

		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblContraseña.setBounds(87, 176, 91, 25);
		contentPane.add(lblContraseña);

		JTextField textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textUsuario.setBounds(246, 100, 178, 25);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);

		passwordContraseña = new JPasswordField();
		passwordContraseña.setEchoChar('*');
		passwordContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordContraseña.setBounds(246, 178, 178, 25);
		contentPane.add(passwordContraseña);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textUsuario.getText();
				char[] passwordArray = passwordContraseña.getPassword();
				String password = new String(passwordArray);

				Agencia agencia = Gestor.comprobarAgencias(usuario, password);

				if (agencia != null) {
					System.out.println("Login exitoso: " + agencia.getNombre());
					dispose();
				} else {
					System.out.println("Usuario o contraseña incorrectos.");
				}

			}
		});
		btnLogin.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnLogin.setBounds(87, 274, 130, 23);
		contentPane.add(btnLogin);

		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Agencia nuevaAgencia = new Agencia();
				 * nuevaAgencia.setNombre(textNombreAgencia.getText());
				 * nuevaAgencia.setLogo(textLogo.getText());
				 * nuevaAgencia.setColorMarca(textColorMarca.getText());
				 * nuevaAgencia.setNumeroEmpleados(Integer.parseInt(textNumeroEmpleados.getText(
				 * ))); nuevaAgencia.setTipoAgencia(textTipoAgencia.getText());
				 * nuevaAgencia.setContraseña(new String(passwordContraseña.getPassword()));
				 * 
				 * // Llamar a la función de creación de agencia
				 * Gestor.crearAgencia(nuevaAgencia);
				 */

				Registrar frame = new Registrar();
				frame.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnRegistrar.setBounds(394, 274, 130, 23);
		contentPane.add(btnRegistrar);
	}
}
