package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;

public class NuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;


	/**
	 * Create the frame.
	 */
	public NuevoEvento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de evento");
		lblNewLabel.setBounds(10, 11, 271, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 40, 400, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de evento");
		lblNewLabel_1.setBounds(10, 63, 400, 21);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Vuelo", "Alojamiento", "Actividad"}));
		comboBox.setBounds(10, 82, 400, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha ida");
		lblNewLabel_2.setBounds(10, 103, 400, 21);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 126, 265, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha vuelta");
		lblNewLabel_3.setBounds(10, 147, 400, 21);
		contentPane.add(lblNewLabel_3);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(10, 166, 265, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblNewLabel_4 = new JLabel("Trayecto");
		lblNewLabel_4.setBounds(10, 188, 400, 21);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Ida", "Ida y Vuelta"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(10, 208, 400, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Aeropuerto origen");
		lblNewLabel_5.setBounds(10, 249, 112, 21);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Alicante (ALC)", "Asturias (OVD)", "Barcelona (BCN)", "Córdoba (ODB)", "Gerona (GRO)", "Granada (GRX)", "Ibiza (IBZ)", "La Coruña (LCG)", "Lanzarote (ACE)", "Madrid (MAD)", "Mahón (MAH)", "Murcia (MJV)", "Pamplona (PNA)", "Salamanca (SLM)", "Santa Cruz de la Palma (SPC)", "Santiago de Compostela (SCQ)", "Valencia (VLC)", "Vigo (VGO)", "Zaragoza (ZAZ)", "Badajoz (BJZ)", "Bilbao (BIO)", "Vitoria (VIT)", "Tenerife Norte (TFN)", "Tenerife Sur (TFS)", "Santander (SDR)", "San Sebastián (EAS)", "Reus (REU)", "Palma de Mallorca (PMI)", "Málaga (AGP)", "Jerez de la Frontera (XRY)", "Gran Canaria (LPA)", "Fuerteventura (FUE)", "Hierro (VDE)", "La Gomera (GMZ)", "Montreal, Québec (YMQ)", "Ottawa, Ontario, Canadá (YOW)", "Toronto, Ontario, Canadá (YTO)", "Vancouver, Canadá (YVR)", "Boston (BOS)", "Houston (HOU)", "Miami (MIA)", "Los Angeles (LAX)", "Nueva York (JFK)", "Detroit (DTT)", "Philadelphia (PHL)", "San Francisco (SFO)", "Seattle (SEA)", "Washington (WAS)", "Santo Domingo, República Dominicana (SDQ)", "Kingston, Jamaica (KIN)", "Buenos Aires (BUE)", "Río de Janeiro, Brasil (RIO)", "São Paulo, Brasil (SAO)", "Bogotá, Colombia (BOG)", "Lima, Perú (LIM)", "Caracas, Venezuela (CCS)", "Viena, Austria (VIE)", "Praga, República Checa (PRG)", "Helsinki, Finlandia (HEL)", "Lyon, Francia (LYS)", "París, Francia (aeropuerto Charles de Gaulle) (CDG)", "Le Bourget, Francia (LBG)", "Orly, Francia (ORY)", "Marsella, Francia (MRS)", "Berlín, Alemania (BER)", "Düsseldorf, Alemania (DUS)", "Frankfurt, Alemania (FRA)", "Múnich, Alemania (MUC)", "Hamburgo, Alemania (HAM)", "Atenas, Grecia (ATH)", "Dublín, Irlanda (DUB)", "Milán, Italia (MIL)", "México D.F., México (MEX)", "Acapulco, México (ACA)", "Brasilia, Brasil (BSB)", "Stuttgart, Alemania (STR)", "Copenhague, Dinamarca (CPH)", "Bruselas, Bélgica (BRU)", "Ámsterdam, Países Bajos (AMS)", "Oslo, Noruega (OSL)", "Varsovia, Polonia (WAW)", "Lisboa, Portugal (LIS)", "Estocolmo, Suecia (STO)", "Moscú, Rusia (MOW)", "Ginebra, Suiza (GVA)", "Zúrich, Suiza (ZRH)", "Estambul, Turquía (IST)", "Londres, Gatwick (LGH)", "Londres, Heathrow (LHR)", "Londres, Stansted (STN)", "El Cairo, Egipto (CAI)", "Nairobi, Kenia (NBO)", "Casablanca, Marruecos (CAS)", "Marrakech, Marruecos (RAK)", "Túnez (TUN)", "Ammán, Jordania (AMM)", "Bangkok, Tailandia (BKK)", "Melbourne, Australia (MEL)", "Sídney, Australia (SYD)"}));
		comboBox_2.setBounds(132, 249, 354, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_6 = new JLabel("Aeropuerto destino");
		lblNewLabel_6.setBounds(10, 281, 112, 21);
		contentPane.add(lblNewLabel_6);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Alicante (ALC)", "Asturias (OVD)", "Barcelona (BCN)", "Córdoba (ODB)", "Gerona (GRO)", "Granada (GRX)", "Ibiza (IBZ)", "La Coruña (LCG)", "Lanzarote (ACE)", "Madrid (MAD)", "Mahón (MAH)", "Murcia (MJV)", "Pamplona (PNA)", "Salamanca (SLM)", "Santa Cruz de la Palma (SPC)", "Santiago de Compostela (SCQ)", "Valencia (VLC)", "Vigo (VGO)", "Zaragoza (ZAZ)", "Badajoz (BJZ)", "Bilbao (BIO)", "Vitoria (VIT)", "Tenerife Norte (TFN)", "Tenerife Sur (TFS)", "Santander (SDR)", "San Sebastián (EAS)", "Reus (REU)", "Palma de Mallorca (PMI)", "Málaga (AGP)", "Jerez de la Frontera (XRY)", "Gran Canaria (LPA)", "Fuerteventura (FUE)", "Hierro (VDE)", "La Gomera (GMZ)", "Montreal, Québec (YMQ)", "Ottawa, Ontario, Canadá (YOW)", "Toronto, Ontario, Canadá (YTO)", "Vancouver, Canadá (YVR)", "Boston (BOS)", "Houston (HOU)", "Miami (MIA)", "Los Angeles (LAX)", "Nueva York (JFK)", "Detroit (DTT)", "Philadelphia (PHL)", "San Francisco (SFO)", "Seattle (SEA)", "Washington (WAS)", "Santo Domingo, República Dominicana (SDQ)", "Kingston, Jamaica (KIN)", "Buenos Aires (BUE)", "Río de Janeiro, Brasil (RIO)", "São Paulo, Brasil (SAO)", "Bogotá, Colombia (BOG)", "Lima, Perú (LIM)", "Caracas, Venezuela (CCS)", "Viena, Austria (VIE)", "Praga, República Checa (PRG)", "Helsinki, Finlandia (HEL)", "Lyon, Francia (LYS)", "París, Francia (aeropuerto Charles de Gaulle) (CDG)", "Le Bourget, Francia (LBG)", "Orly, Francia (ORY)", "Marsella, Francia (MRS)", "Berlín, Alemania (BER)", "Düsseldorf, Alemania (DUS)", "Frankfurt, Alemania (FRA)", "Múnich, Alemania (MUC)", "Hamburgo, Alemania (HAM)", "Atenas, Grecia (ATH)", "Dublín, Irlanda (DUB)", "Milán, Italia (MIL)", "México D.F., México (MEX)", "Acapulco, México (ACA)", "Brasilia, Brasil (BSB)", "Stuttgart, Alemania (STR)", "Copenhague, Dinamarca (CPH)", "Bruselas, Bélgica (BRU)", "Ámsterdam, Países Bajos (AMS)", "Oslo, Noruega (OSL)", "Varsovia, Polonia (WAW)", "Lisboa, Portugal (LIS)", "Estocolmo, Suecia (STO)", "Moscú, Rusia (MOW)", "Ginebra, Suiza (GVA)", "Zúrich, Suiza (ZRH)", "Estambul, Turquía (IST)", "Londres, Gatwick (LGH)", "Londres, Heathrow (LHR)", "Londres, Stansted (STN)", "El Cairo, Egipto (CAI)", "Nairobi, Kenia (NBO)", "Casablanca, Marruecos (CAS)", "Marrakech, Marruecos (RAK)", "Túnez (TUN)", "Ammán, Jordania (AMM)", "Bangkok, Tailandia (BKK)", "Melbourne, Australia (MEL)", "Sídney, Australia (SYD)"}));
		comboBox_3.setBounds(132, 280, 354, 21);
		contentPane.add(comboBox_3);
		
		JButton btnNewButton = new JButton("Buscar viaje");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(514, 249, 177, 53);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Codigo vuelo (ida)");
		lblNewLabel_7.setBounds(10, 341, 354, 21);
		contentPane.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 366, 271, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Codigo vuelo (vuelta)");
		lblNewLabel_8.setBounds(371, 341, 171, 21);
		contentPane.add(lblNewLabel_8);
		
		textField_2 = new JTextField();
		textField_2.setBounds(371, 366, 271, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Aerolinea (ida)");
		lblNewLabel_9.setBounds(10, 398, 237, 21);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Aerolinea (vuelta)");
		lblNewLabel_9_1.setBounds(371, 398, 237, 21);
		contentPane.add(lblNewLabel_9_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 418, 271, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(371, 418, 271, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Horario salida (ida)");
		lblNewLabel_10.setBounds(10, 450, 271, 21);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Horario salida (vuelta)");
		lblNewLabel_11.setBounds(371, 450, 261, 21);
		contentPane.add(lblNewLabel_11);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 470, 271, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(371, 470, 271, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Duracion (ida)");
		lblNewLabel_12.setBounds(10, 502, 171, 21);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Duracion (vuelta)");
		lblNewLabel_13.setBounds(371, 505, 225, 21);
		contentPane.add(lblNewLabel_13);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 521, 271, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(371, 521, 276, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Precio");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setBounds(10, 597, 64, 30);
		contentPane.add(lblNewLabel_14);
		
		textField_9 = new JTextField();
		textField_9.setBounds(84, 594, 112, 41);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
	}
}