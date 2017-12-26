package ParkhausAutoSoftware.Fenster;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ParkhausAutoSoftware.Kunde;
import ParkhausAutoSoftware.Parkhaus;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class KundenFenster extends JFrame {

	private JPanel contentPane;
	private JTextField tbxKundenId;
	private Parkhaus p;
	private JTextField tbxTicketautomat;
	private JFrame jf = null;

	
	/**
	 * Create the frame.
	 */
	public KundenFenster(Parkhaus p) {
		setTitle("Kundeninterface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.p = p;
		jf = this;
		JButton btnReinfahren = new JButton("Reinfahren");
		btnReinfahren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbxKundenId.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jf, "Das Textfeld für\r\ndie Kundennummer ist leer. \r\nBitte tragen sie etwas ein!","Textfeld leer", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(tbxTicketautomat.getText().equals(""))
					{
						JOptionPane.showMessageDialog(jf, "Das Textfeld für\r\ndie Ticketautomatennummer ist leer. \r\nBitte tragen sie etwas ein!","Textfeld leer", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						p.einfahren(Integer.parseInt(tbxKundenId.getText()), Integer.parseInt(tbxTicketautomat.getText()));
					}
				}
			}
		});
		btnReinfahren.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReinfahren.setBounds(450, 57, 150, 35);
		contentPane.add(btnReinfahren);
		
		tbxKundenId = new JTextField();
		tbxKundenId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxKundenId.setBounds(210, 57, 230, 35);
		contentPane.add(tbxKundenId);
		tbxKundenId.setColumns(10);
		
		JLabel lblKundennummer = new JLabel("Kundennummer:");
		lblKundennummer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKundennummer.setBounds(74, 58, 138, 23);
		contentPane.add(lblKundennummer);
		
		JLabel lblTicketautomatennummer = new JLabel("Ticketautomatennummer:");
		lblTicketautomatennummer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTicketautomatennummer.setBounds(20, 17, 171, 23);
		contentPane.add(lblTicketautomatennummer);
		
		tbxTicketautomat = new JTextField();
		tbxTicketautomat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxTicketautomat.setColumns(10);
		tbxTicketautomat.setBounds(210, 11, 230, 35);
		contentPane.add(tbxTicketautomat);
	}
}
