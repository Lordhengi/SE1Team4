package ParkhausAutoSoftware.Fenster;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ParkhausAutoSoftware.Kunde;
import ParkhausAutoSoftware.Parkhaus;
import ParkhausAutoSoftware.Ticket;
import ParkhausAutoSoftware.NewZeit;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class KundenFenster extends JFrame {

	private JPanel contentPane;
	private JTextField tbxKundenId;
	private Parkhaus p;
	private JTextField tbxTicketautomat;
	private JFrame jf = null;
	private JButton btnRausfahren;
	private JButton btnTicketEntwerten;
	private JTextField tbxPreis;

	
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
				if(tbxKundenId.getText().equals("") || tbxTicketautomat.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jf, "Bitte überprüfen sie die Werte der Textfelder!","Textfeld leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(p.getKunde(Integer.parseInt(tbxKundenId.getText())) != null)
					{
						if(!p.getKunde(Integer.parseInt(tbxKundenId.getText())).getParkt())
						{
							p.einfahren(Integer.parseInt(tbxKundenId.getText()), Integer.parseInt(tbxTicketautomat.getText()));
						}
						else
						{
							JOptionPane.showMessageDialog(jf, "Sie parken bereits im Parkhaus","Error", JOptionPane.ERROR_MESSAGE);
						}
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
		
		btnRausfahren = new JButton("Rausfahren");
		btnRausfahren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbxKundenId.getText().equals("") || tbxTicketautomat.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jf, "Bitte überprüfen sie die Werte der Textfelder!","Textfeld leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Kunde k = p.getKunde(Integer.parseInt(tbxKundenId.getText())); 
					if(k.getTicket().getEntwertet())
					{
						k.setParkt(false);
					}
					else
					{
						JOptionPane.showMessageDialog(jf, "Ticket wurde noch nicht entwertet!","Ticket entwerten", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnRausfahren.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRausfahren.setBounds(450, 11, 150, 35);
		contentPane.add(btnRausfahren);
		
		btnTicketEntwerten = new JButton("Ticket entwerten");
		btnTicketEntwerten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbxKundenId.getText().equals("") || tbxTicketautomat.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jf, "Bitte überprüfen sie die Werte der Textfelder!","Textfeld leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Kunde k = p.getKunde(Integer.parseInt(tbxKundenId.getText()));
					if(k != null)
					{
						Ticket t = k.getTicket();
						if(k.getParkt())
						{
							if(!t.getEntwertet())
							{
								float preis = t.getPreiseinfahrt();
								int minuten = NewZeit.differenzinMinuten(t.getEinfahrt(), t.getAusfahrt());
								if(minuten > 0)
								{
									int h = (int)minuten/60;
									int min = minuten-h*60;
									DecimalFormat df = new DecimalFormat("0.00");
									tbxPreis.setText(df.format(h*preis + min* (preis/60)).toString()+"€");
								}
								else
								{
									DecimalFormat df = new DecimalFormat("0.00");
									tbxPreis.setText(df.format(preis/60).toString()+"€");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(jf, "Ticket wurde bereits entwertet!","Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(jf, "Kunde parkt nicht im Parkhaus","Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(jf, "Kunde existiert nicht, bitte Werte überprüfen!","Kunde nicht vorhanden", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnTicketEntwerten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTicketEntwerten.setBounds(450, 103, 150, 35);
		contentPane.add(btnTicketEntwerten);
		
		tbxPreis = new JTextField();
		tbxPreis.setEditable(false);
		tbxPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxPreis.setColumns(10);
		tbxPreis.setBounds(210, 122, 230, 35);
		contentPane.add(tbxPreis);
	}
}
