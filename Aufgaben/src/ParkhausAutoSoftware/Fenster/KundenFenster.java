package ParkhausAutoSoftware.Fenster;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ParkhausAutoSoftware.Etage;
import ParkhausAutoSoftware.Kunde;
import ParkhausAutoSoftware.Parkhaus;
import ParkhausAutoSoftware.Ticket;
import ParkhausAutoSoftware.NewZeit;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class KundenFenster extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tbxKundenId;
	private Parkhaus p;
	private JTextField tbxTicketautomat;
	private JFrame jf = null;
	private JButton btnRausfahren;
	private JButton btnTicketEntwerten;
	private JTextField tbxPreis;
	private JComboBox<String> cmbxEtage;

	
	/**
	 * Create the frame.
	 */
	public KundenFenster(Start s) {
		setTitle("Kundeninterface");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 626, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		this.p = s.p;
		jf = this;
		JButton btnReinfahren = new JButton("Reinfahren");
		btnReinfahren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbxKundenId.getText().equals("") || tbxTicketautomat.getText().equals("") || cmbxEtage.getSelectedItem().toString().equals("(Auswählen)"))
				{
					JOptionPane.showMessageDialog(jf, "Bitte überprüfen sie Ihre Eingaben!","Eingaben leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(p.getKunde(Integer.parseInt(tbxKundenId.getText())) != null)
					{
						if(!p.getKunde(Integer.parseInt(tbxKundenId.getText())).getParkt())
						{
							if(p.getTicketautomat(Integer.parseInt(tbxTicketautomat.getText())) != null)
							{
								if(p.getEtagen().stream().mapToInt(x -> x.getPlaetze()).sum() != p.getEtagen().stream().mapToInt(x -> x.getBelegt()).sum())
								{
									if(p.getEtage(cmbxEtage.getSelectedItem().toString()).parkplatzBelegen())
									{
										p.einfahren(Integer.parseInt(tbxKundenId.getText()), Integer.parseInt(tbxTicketautomat.getText()),p.getEtage(cmbxEtage.getSelectedItem().toString()));
										try {
											AktuellerPreisFenster frame = new AktuellerPreisFenster(p.getKunde(Integer.parseInt(tbxKundenId.getText())));
											frame.setVisible(true);
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
									else
									{
										JOptionPane.showMessageDialog(jf, "Die Etage ist bereits belegt. Bitte wählen sie eine andere!","Etage belegt", JOptionPane.ERROR_MESSAGE);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(jf, "Das Parkhaus ist leider vollständig belegt!","Parkhaus belegt", JOptionPane.ERROR_MESSAGE);
								}
							}
							else
							{
								if(p.getTicketautomaten().size() == 0)
								{
									JOptionPane.showMessageDialog(jf, "Es gibt keinen Ticketautomaten im Parkhaus","Ticketautomaten nicht vorhanden", JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									JOptionPane.showMessageDialog(jf, "Der Ticketautomat ist nicht vorhanden","Ticketautomat nicht vorhanden", JOptionPane.ERROR_MESSAGE);
								}
								
							}
						}
						else
						{
							JOptionPane.showMessageDialog(jf, "Sie parken bereits im Parkhaus","Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						if(p.getTicketautomat(Integer.parseInt(tbxTicketautomat.getText())) != null)
						{
							if(p.getEtagen().stream().mapToInt(x -> x.getPlaetze()).sum() != p.getEtagen().stream().mapToInt(x -> x.getBelegt()).sum())
							{
								if(p.getEtage(cmbxEtage.getSelectedItem().toString()).parkplatzBelegen())
								{
									p.einfahren(Integer.parseInt(tbxKundenId.getText()), Integer.parseInt(tbxTicketautomat.getText()),p.getEtage(cmbxEtage.getSelectedItem().toString()));
									try {
										AktuellerPreisFenster frame = new AktuellerPreisFenster(p.getKunde(Integer.parseInt(tbxKundenId.getText())));
										frame.setVisible(true);
									} catch (Exception ex) {
										ex.printStackTrace();
									}
								}
								else
								{
									JOptionPane.showMessageDialog(jf, "Die Etage ist bereits belegt. Bitte wählen sie eine andere!","Etage belegt", JOptionPane.ERROR_MESSAGE);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(jf, "Das Parkhaus ist leider vollständig belegt!","Parkhaus belegt", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							if(p.getTicketautomaten().size() == 0)
							{
								JOptionPane.showMessageDialog(jf, "Es gibt keinen Ticketautomaten im Parkhaus","Ticketautomaten nicht vorhanden", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(jf, "Der Ticketautomat ist nicht vorhanden","Ticketautomat nicht vorhanden", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						
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
		lblKundennummer.setBounds(74, 63, 138, 23);
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
				if(tbxKundenId.getText().equals("") || tbxTicketautomat.getText().equals("") || cmbxEtage.getSelectedItem().toString().equals("(Auswählen)"))
				{
					JOptionPane.showMessageDialog(jf,  "Bitte überprüfen sie Ihre Eintgaben!","Eingaben leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Kunde k = p.getKunde(Integer.parseInt(tbxKundenId.getText())); 
					if(k == null || k.getParkt())
					{
						if(k.getTicket().getEntwertet())
						{
							if(p.getEtage(k.getParkEtage().getName()).parkplatzEntbelegen())
							{
								k.setParkt(false);
								k.setParkEtage(null);
							}
							else
							{
								JOptionPane.showMessageDialog(jf, "Fehler des Programmes! Bitte Programmierer kontaktieren.","Etage ist leer", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(jf, "Ticket wurde noch nicht entwertet!","Ticket entwerten", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(jf, "Sie parken nicht im Parkhaus","Error", JOptionPane.ERROR_MESSAGE);
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
				if(tbxKundenId.getText().equals("") || tbxTicketautomat.getText().equals("") || cmbxEtage.getSelectedItem().toString().equals("(Auswählen)"))
				{
					JOptionPane.showMessageDialog(jf, "Bitte überprüfen sie Ihre Eingaben!","Eingaben leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Kunde k = p.getKunde(Integer.parseInt(tbxKundenId.getText()));
					if(k != null)
					{
						if(p.getTicketautomat(Integer.parseInt(tbxTicketautomat.getText())) != null)
						{
							Ticket t = k.getTicket();							
							if(k.getParkt())
							{
								if(!t.getEntwertet())
								{
									String erg = Ticketentwerten(t);
									tbxPreis.setText(erg+"€");
									s.plusGeld(Float.parseFloat(erg));
									//Start.plusGeld(Float.parseFloat(erg));
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
							if(p.getTicketautomaten().size() == 0)
							{
								JOptionPane.showMessageDialog(jf, "Es gibt keinen Ticketautomaten im Parkhaus","Ticketautomaten nicht vorhanden", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(jf, "Der Ticketautomat ist nicht vorhanden","Ticketautomat nicht vorhanden", JOptionPane.ERROR_MESSAGE);
							}
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
		btnTicketEntwerten.setBounds(450, 203, 150, 35);
		contentPane.add(btnTicketEntwerten);
		
		tbxPreis = new JTextField();
		tbxPreis.setEditable(false);
		tbxPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxPreis.setColumns(10);
		tbxPreis.setBounds(210, 203, 230, 35);
		contentPane.add(tbxPreis);
		
		cmbxEtage = new JComboBox<String>();
		cmbxEtage.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				cmbxEtage.removeAllItems();
				cmbxEtage.addItem("(Auswählen)");
				List<Etage> listeEtage = p.getEtagen();
				for(Etage et : listeEtage)
				{
					cmbxEtage.addItem(et.getName());
				}
			}
		});
		cmbxEtage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbxEtage.setBounds(210, 103, 230, 35);
		cmbxEtage.addItem("(Auswählen)");
		contentPane.add(cmbxEtage);
		
		JLabel lblEtage = new JLabel("Etage:");
		lblEtage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEtage.setBounds(137, 109, 49, 23);
		contentPane.add(lblEtage);
		
		JButton btnFehlerMelden = new JButton("Fehler melden");
		btnFehlerMelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FehlerMeldungsFenster frame = new FehlerMeldungsFenster(p, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnFehlerMelden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFehlerMelden.setBounds(20, 250, 150, 35);
		contentPane.add(btnFehlerMelden);
	}
	
	public String Ticketentwerten(Ticket t)
	{
		float preis = t.getPreiseinfahrt();
		int sekunden = NewZeit.differenzinSekunden(t.getEinfahrt(), t.ausfahrt());
		int h = (int)sekunden/3600;
		int min = sekunden-h*3600;
		int sec = (sekunden-h*3600)-min*60;
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(getLocale());
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator('.'); 
		DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
		float x = (h*preis + min* (preis/60) + sec *(preis/3600));
		
		return df.format(x).toString();
	}
}
