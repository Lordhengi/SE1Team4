package ParkhausAutoSoftware.Fenster;


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
	private JTextArea tbxFehlermeldung;

	/**
	 * Create the frame.
	 */
	public FehlerMeldungsFenster(Parkhaus p,String UUID, String errorText) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if(UUID.equals("") || UUID == null)
		{
			setTitle("Fehlerbericht senden");
		}
		else
		{
			setTitle("ErrorId: " + UUID);
		}
		
		if(errorText.equals("") || errorText == null)
		{
			JButton btnSpeichern = new JButton("Absenden");
			btnSpeichern.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!tbxFehlermeldung.getText().equals(""))
					{
						p.getErrors().add(new ErrorMeldung(tbxFehlermeldung.getText()));
						dispose();
					}
				}
			});
			btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnSpeichern.setBounds(428, 331, 150, 35);
			contentPane.add(btnSpeichern);
		
			tbxFehlermeldung = new JTextArea();
			tbxFehlermeldung.setBounds(43, 44, 485, 276);
			contentPane.add(tbxFehlermeldung);
		}
		else
		{
			JButton btnSpeichern = new JButton("Schlieﬂen");
			btnSpeichern.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();				
				}
			});
			btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnSpeichern.setBounds(428, 331, 150, 35);
			contentPane.add(btnSpeichern);
		
			tbxFehlermeldung = new JTextArea();
			tbxFehlermeldung.setEditable(false);
			tbxFehlermeldung.setBounds(43, 44, 485, 276);
			tbxFehlermeldung.setText(errorText);
			contentPane.add(tbxFehlermeldung);
		}
		
		JLabel lblFehlermeldung = new JLabel("Fehlermeldung:");
		lblFehlermeldung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFehlermeldung.setBounds(43, 11, 105, 23);
		contentPane.add(lblFehlermeldung);
	}
}
