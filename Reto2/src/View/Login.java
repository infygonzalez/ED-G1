package View;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

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

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 863, 569);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crear el botón
        JButton btnInicial = new JButton("");

        // Cargar la imagen desde el paquete 'img'
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/ImagenFondo.jfif"));

        // Obtener la imagen y redimensionarla al tamaño del botón
        Image img = icon.getImage();  // Obtener la imagen original
        Image scaledImg = img.getScaledInstance(847, 530, Image.SCALE_SMOOTH); // Redimensionar la imagen

        // Crear un nuevo ImageIcon con la imagen redimensionada
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        // Establecer la imagen redimensionada como el ícono del botón
        btnInicial.setIcon(scaledIcon);

        // Establecer las dimensiones del botón
        btnInicial.setBounds(0, 0, 847, 530); // Ajusta el tamaño del botón a las dimensiones deseadas

        contentPane.add(btnInicial);

        // Acción cuando se presiona el botón
        btnInicial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica de lo que debe hacer el login al hacer click en el botón
            }
        });
    }
}
