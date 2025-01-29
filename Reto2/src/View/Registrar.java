package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Gestor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textLogo;
	private JTextField textColor;
	private JTextField textNumeroEmpleados;
	private JPasswordField passwordField;
	private JPasswordField passwordVerificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar frame = new Registrar();
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
	public Registrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Viajes Erreka-Mari");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblTitulo.setBounds(180, 11, 269, 68);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblNombre.setBounds(91, 90, 84, 31);
		contentPane.add(lblNombre);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblLogo.setBounds(91, 132, 84, 31);
		contentPane.add(lblLogo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblColor.setBounds(91, 174, 84, 31);
		contentPane.add(lblColor);
		
		JLabel lblNumeroEmpleados = new JLabel("Numero de Empleados");
		lblNumeroEmpleados.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblNumeroEmpleados.setBounds(91, 216, 153, 31);
		contentPane.add(lblNumeroEmpleados);
		
		JLabel lblTipoAgencia = new JLabel("Tipo de Agencia");
		lblTipoAgencia.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblTipoAgencia.setBounds(91, 258, 153, 31);
		contentPane.add(lblTipoAgencia);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblContraseña.setBounds(91, 300, 84, 31);
		contentPane.add(lblContraseña);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setBounds(291, 97, 175, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textLogo = new JTextField();
		textLogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textLogo.setColumns(10);
		textLogo.setBounds(291, 139, 175, 20);
		contentPane.add(textLogo);
		
		textColor = new JTextField();
		textColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textColor.setColumns(10);
		textColor.setBounds(291, 181, 175, 20);
		contentPane.add(textColor);
		
		textNumeroEmpleados = new JTextField();
		textNumeroEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNumeroEmpleados.setColumns(10);
		textNumeroEmpleados.setBounds(291, 223, 175, 20);
		contentPane.add(textNumeroEmpleados);
		
		JComboBox comboTipoAgencia = new JComboBox();
		comboTipoAgencia.setModel(new DefaultComboBoxModel(new String[] {"", "Mayorista", "Minorista", "Mayoria-Minorista"}));
		comboTipoAgencia.setBounds(291, 264, 175, 22);
		contentPane.add(comboTipoAgencia);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(291, 307, 175, 20);
		contentPane.add(passwordField);
		
		JButton btnCrearCuenta = new JButton("CREAR \r\nCUENTA");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
		        String logo = textLogo.getText();
		        String color = textColor.getText();
		        String numeroEmpleadosStr = textNumeroEmpleados.getText();
		        String tipoAgencia = comboTipoAgencia.getSelectedItem().toString();
		        String contraseña = new String(passwordField.getPassword());

		        if (nombre.isEmpty() || logo.isEmpty() || color.isEmpty() || 
		            numeroEmpleadosStr.isEmpty() || tipoAgencia.isEmpty() || contraseña.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (Gestor.existeAgencia(nombre)) {
		            JOptionPane.showMessageDialog(null, "El nombre de la agencia ya está en uso.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        
			}
		});
		btnCrearCuenta.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnCrearCuenta.setBounds(78, 407, 159, 38);
		contentPane.add(btnCrearCuenta);
		
		JLabel lblVerificaContraseña = new JLabel("Verificar Contraseña\r\n");
		lblVerificaContraseña.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblVerificaContraseña.setBounds(91, 342, 192, 31);
		contentPane.add(lblVerificaContraseña);
		
		passwordVerificar = new JPasswordField();
		passwordVerificar.setBounds(291, 349, 175, 20);
		contentPane.add(passwordVerificar);
	}
}
