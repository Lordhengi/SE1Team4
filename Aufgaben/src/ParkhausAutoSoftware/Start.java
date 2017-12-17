package ParkhausAutoSoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setTitle("Parkhaus-Automatisierungssystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnParkhausAnlegen = new JButton("Parkhaus anlegen");
		btnParkhausAnlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnParkhausAnlegen.setBounds(235, 24, 167, 23);
		contentPane.add(btnParkhausAnlegen);
		
		JLabel lblAnzahlParkpltze = new JLabel("Anzahl Parkpl\u00E4tze");
		lblAnzahlParkpltze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnzahlParkpltze.setBounds(108, 75, 111, 23);
		contentPane.add(lblAnzahlParkpltze);
		
		JButton btnAutoEinfahrt = new JButton("Auto f\u00E4hrt rein");
		btnAutoEinfahrt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAutoEinfahrt.setBounds(235, 77, 167, 23);
		contentPane.add(btnAutoEinfahrt);
		
		JButton btnAutoAusfahrt = new JButton("Auto f\u00E4hrt raus");
		btnAutoAusfahrt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAutoAusfahrt.setBounds(235, 111, 167, 23);
		contentPane.add(btnAutoAusfahrt);
	}
}
