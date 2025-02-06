package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Modelo_Gestor.Gestor;
import Modelo_Pojos.Agencia;
import Controlador.Controlador;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField password;



	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblUsuario.setBounds(209, 94, 122, 66);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblContraseña.setBounds(209, 185, 122, 66);
		contentPane.add(lblContraseña);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textUsuario.setBounds(451, 116, 161, 28);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setBounds(451, 207, 161, 28);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("INICIAR SESIÓN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String usuario = textUsuario.getText().trim();  
		        char[] passwordChars = password.getPassword();
		        String contraseña = new String(passwordChars).trim(); 
		      

		        Agencia agencia = Controlador.comprobarAgencias(usuario, contraseña);

		        if (agencia == null) {
		            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error de Login", JOptionPane.ERROR_MESSAGE);
		        } else {
		            PestañaPrincipal pestañaPrincipal = new PestañaPrincipal(agencia);
		            pestañaPrincipal.setVisible(true);
		            dispose();
		        }
		    }
		});
		btnLogin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		btnLogin.setBounds(91, 329, 185, 76);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("CREAR CUENTA");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register registrar = new Register();
				registrar.setVisible(true);
				dispose();
			}
		});
		btnRegister.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		btnRegister.setBounds(550, 329, 185, 76);
		contentPane.add(btnRegister);
		
		
	}
}
