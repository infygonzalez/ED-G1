package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Vista.BotonInicio;

public class Launcher extends JFrame {
	public Launcher() {
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotonInicio frame = new BotonInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
