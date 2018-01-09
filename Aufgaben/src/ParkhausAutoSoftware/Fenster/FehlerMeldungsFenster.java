package ParkhausAutoSoftware.Fenster;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ParkhausAutoSoftware.ErrorMeldung;
import ParkhausAutoSoftware.Parkhaus;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FehlerMeldungsFenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Parkhaus p;
	private JTextArea tbxFehlermeldung;

	/**
	 * Create the frame.
	 */
	public FehlerMeldungsFenster(Parkhaus p) {
		this.p = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tbxFehlermeldung.getText().equals(""))
				{
					p.getErrors().add(new ErrorMeldung(tbxFehlermeldung.getText()));
				}
			}
		});
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSpeichern.setBounds(428, 331, 150, 35);
		contentPane.add(btnSpeichern);
		
		tbxFehlermeldung = new JTextArea();
		tbxFehlermeldung.setBounds(43, 44, 485, 276);
		contentPane.add(tbxFehlermeldung);
		
		JLabel lblFehlermeldung = new JLabel("Fehlermeldung:");
		lblFehlermeldung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFehlermeldung.setBounds(43, 11, 105, 23);
		contentPane.add(lblFehlermeldung);
	}
}
