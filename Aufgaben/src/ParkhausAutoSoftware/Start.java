package ParkhausAutoSoftware;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.thoughtworks.xstream.XStream;

import ParkhausAutoSoftware.Fenster.AktuellerPreisFenster;
import ParkhausAutoSoftware.Fenster.KundenFenster;
import ParkhausAutoSoftware.Fenster.ParkhausAnlegen;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Start extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Parkhaus p;
	private ParkhausAnlegen frame = null;
	private JTable tblKunden;
	private JTable tblTicketautomaten;
	private JTable tblEtagen;
	private JTextField tbxEtagenname;
	private JTextField tbxEtagenplaetzte;
	private JButton btnTicketautomatenerstellen;
	private JButton btnParkhausAnlegen;
	private JButton btnKundenanzeigen;
	private JButton btnTicketautomatenAnzeigen;
	private JButton btnEtageErstellen;
	private JButton btnEtagenAnzeigen;
	private JFrame jf;
	private JButton btnSpeichern;
	private JButton btnLaden;
	private JTextField tbxHeute;
	private JTextField tbxWoche;
	private JLabel lblTag;
	private JLabel lblWoche;
	private float tag;
	private float woche;
	private float gesamt;
	private static SimpleDateFormat formata;
	private static String akt;
	private XStream xstream = new XStream();
	private JTextField tbxPreis;
	private Thread th;
	private LocalTime neu = LocalTime.of(0, 0);
	private JTextField tbxGesamt;
	private JLabel lblGesamt;
	private Start sthis;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
					formata = new SimpleDateFormat("EEEE, dd.MMMM yyyy");
					formata.setTimeZone(TimeZone.getTimeZone("CET"));
					
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
		setBounds(100, 100, 689, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		jf = this;
		sthis = this;
		tag = 0;
		woche = 0;
		gesamt = 0;
		
		btnParkhausAnlegen = new JButton("Parkhaus anlegen");
		btnParkhausAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
					frame = new ParkhausAnlegen();
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent we)
						{
							p = new Parkhaus(frame.getParkhausname(), frame.getManagername(), frame.getPreis());
							
							btnTicketautomatenerstellen.setEnabled(true);
							btnEtageErstellen.setEnabled(true);
							btnSpeichern.setEnabled(true);
							btnLaden.setEnabled(false);
							btnParkhausAnlegen.setEnabled(false);
							tbxEtagenname.setEnabled(true);
							tbxEtagenplaetzte.setEnabled(true);
							tbxPreis.setEnabled(true);
							tbxPreis.setText(Float.toString(p.getManager().getPreis()));
							try {
								KundenFenster frame = new KundenFenster(sthis);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnParkhausAnlegen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnParkhausAnlegen.setBounds(10, 11, 167, 23);
		contentPane.add(btnParkhausAnlegen);
		
		DefaultTableModel m = new DefaultTableModel();
		tblKunden = new JTable(m);
		tblKunden.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"KundenId", "Tickets","Parkt"
			}
		));
		tblKunden.setBounds(10, 231, 653, 393);
		contentPane.add(tblKunden);
		
		btnKundenanzeigen = new JButton("Kunden anzeigen");
		btnKundenanzeigen.setEnabled(false);
		btnKundenanzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Set<Thread> threads = Thread.getAllStackTraces().keySet();
//				 int q = 0;
//				for (Thread t : threads) {
//				   q++; 
//				}
//				System.out.println(q);
				
				tblKunden.setVisible(true);
				tblEtagen.setVisible(false);
				tblTicketautomaten.setVisible(false);
				List<Kunde> kunden = p.getKunden();
				Kunde[] oids = new Kunde[kunden.size()];
				oids = kunden.toArray(oids);
				((DefaultTableModel) tblKunden.getModel()).getDataVector().removeAllElements();
				Object[] rowColumnName = new Object[3];
				rowColumnName[0] = "Kundennummer";
				rowColumnName[1] = "Ticketanzahl";
				rowColumnName[2] = "Geparkt";
				((DefaultTableModel) tblKunden.getModel()).addRow(rowColumnName);
				
				for(int i = 0; i < oids.length; i++)
				{
					Object[] row = new Object[3];
					row[0] = oids[i].getId();
					row[1] = oids[i].getTickets().size();
					row[2] = oids[i].getParkt();
					((DefaultTableModel) tblKunden.getModel()).addRow(row);
				}
				revalidate();
			}
		});
		btnKundenanzeigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKundenanzeigen.setBounds(10, 45, 167, 23);
		contentPane.add(btnKundenanzeigen);
		
		btnTicketautomatenerstellen = new JButton("Ticketautomaten erstellen");
		btnTicketautomatenerstellen.setEnabled(false);
		btnTicketautomatenerstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.addTicketautomat();
				btnKundenanzeigen.setEnabled(true);
				btnTicketautomatenAnzeigen.setEnabled(true);
			}
		});
		btnTicketautomatenerstellen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTicketautomatenerstellen.setBounds(10, 79, 200, 23);
		contentPane.add(btnTicketautomatenerstellen);
		
		DefaultTableModel dtmTicketautomat = new DefaultTableModel();
		tblTicketautomaten = new JTable(dtmTicketautomat);
		tblTicketautomaten.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"TicketautomatenId"
				}
			));
		tblTicketautomaten.setBounds(10, 231, 653, 393);
		contentPane.add(tblTicketautomaten);
		
		
		btnTicketautomatenAnzeigen = new JButton("Ticketautomaten anzeigen");
		btnTicketautomatenAnzeigen.setEnabled(false);
		btnTicketautomatenAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblKunden.setVisible(false);
				tblEtagen.setVisible(false);
				tblTicketautomaten.setVisible(true);
				List<Ticketautomat> listeTa = p.getTicketautomaten();
				Ticketautomat[] oids = new Ticketautomat[listeTa.size()];
				oids = listeTa.toArray(oids);
				((DefaultTableModel) tblTicketautomaten.getModel()).getDataVector().removeAllElements();
				Object[] rowColumnName = new Object[1];
				rowColumnName[0] = "Ticketautomatennummer";
				((DefaultTableModel) tblTicketautomaten.getModel()).addRow(rowColumnName);
				
				for(int i = 0; i < oids.length; i++)
				{
					Object[] row = new Object[1];
					row[0] = i;
					((DefaultTableModel) tblTicketautomaten.getModel()).addRow(row);
				}
				revalidate();
			}
		});
		btnTicketautomatenAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTicketautomatenAnzeigen.setBounds(223, 45, 200, 23);
		contentPane.add(btnTicketautomatenAnzeigen);
		
		btnEtageErstellen = new JButton("Etage erstellen");
		btnEtageErstellen.setEnabled(false);
		btnEtageErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbxEtagenname.getText().equals("") || tbxEtagenplaetzte.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jf, "Bitte überprüfen sie die Werte der Textfelder!","Textfeld leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					p.addEtage(tbxEtagenname.getText(), Integer.parseInt(tbxEtagenplaetzte.getText()));
					btnEtagenAnzeigen.setEnabled(true);
				}
			}
		});
		btnEtageErstellen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEtageErstellen.setBounds(10, 185, 200, 23);
		contentPane.add(btnEtageErstellen);
		
		tbxEtagenname = new JTextField();
		tbxEtagenname.setEnabled(false);
		tbxEtagenname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxEtagenname.setColumns(10);
		tbxEtagenname.setBounds(145, 113, 176, 20);
		contentPane.add(tbxEtagenname);
		
		JLabel lblEtagenname = new JLabel("Etagenname:");
		lblEtagenname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEtagenname.setBounds(10, 113, 143, 23);
		contentPane.add(lblEtagenname);
		
		JLabel lblEtagenparkpltze = new JLabel("Etagenparkpl\u00E4tze:");
		lblEtagenparkpltze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEtagenparkpltze.setBounds(10, 147, 143, 23);
		contentPane.add(lblEtagenparkpltze);
		
		tbxEtagenplaetzte = new JTextField();
		tbxEtagenplaetzte.setEnabled(false);
		tbxEtagenplaetzte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxEtagenplaetzte.setColumns(10);
		tbxEtagenplaetzte.setBounds(145, 147, 176, 20);
		contentPane.add(tbxEtagenplaetzte);
		

		if(th == null)
		{
			th = new Thread(this);
			th.start();
		}
		
		DefaultTableModel dtmEtagen= new DefaultTableModel();
		tblEtagen = new JTable(dtmEtagen);
		tblEtagen.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Etagenname","Plaetze","belegtePlaetze"
				}
			));
		tblEtagen.setBounds(10, 231, 653, 393);
		contentPane.add(tblEtagen);
		
		btnEtagenAnzeigen = new JButton("Etagen anzeigen");
		btnEtagenAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tblKunden.setVisible(false);
				tblEtagen.setVisible(true);
				tblTicketautomaten.setVisible(false);
				List<Etage> etage = p.getEtagen();
				Etage[] oids = new Etage[etage.size()];
				oids = etage.toArray(oids);
				((DefaultTableModel) tblEtagen.getModel()).getDataVector().removeAllElements();
				Object[] rowColumnName = new Object[3];
				rowColumnName[0] = "Etagenname";
				rowColumnName[1] = "Parkplaetze";
				rowColumnName[2] = "belegte Parkplaetze";
				((DefaultTableModel) tblEtagen.getModel()).addRow(rowColumnName);
				
				for(int i = 0; i < oids.length; i++)
				{
					Object[] row = new Object[3];
					row[0] = oids[i].getName();
					row[1] = oids[i].getPlaetze();
					row[2] = oids[i].getBelegt();
					((DefaultTableModel) tblEtagen.getModel()).addRow(row);
				}
				revalidate();
				
			}
		});
		btnEtagenAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEtagenAnzeigen.setEnabled(false);
		btnEtagenAnzeigen.setBounds(463, 45, 200, 23);
		contentPane.add(btnEtagenAnzeigen);
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				save();
			}
		});
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSpeichern.setEnabled(false);
		btnSpeichern.setBounds(501, 185, 162, 23);
		contentPane.add(btnSpeichern);
		btnLaden = new JButton("Laden");
		btnLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		btnLaden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLaden.setBounds(332, 185, 162, 23);
		contentPane.add(btnLaden);
		
		tbxPreis = new JTextField();
		tbxPreis.setHorizontalAlignment(SwingConstants.CENTER);
		tbxPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxPreis.setEnabled(false);
		tbxPreis.setColumns(10);
		tbxPreis.setBounds(291, 14, 84, 20);
		contentPane.add(tbxPreis);
		
		JLabel lblPreis = new JLabel("Preis:");
		lblPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreis.setBounds(250, 11, 48, 23);
		contentPane.add(lblPreis);
		
		JButton btnBtnpreisspeichern = new JButton("Preis speichern");
		btnBtnpreisspeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					p.getManager().setPreis(Float.parseFloat(tbxPreis.getText()));
				}catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(jf, "Dieser Wert ist ungültig!","ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnBtnpreisspeichern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBtnpreisspeichern.setBounds(397, 11, 167, 23);
		contentPane.add(btnBtnpreisspeichern);
		
		lblTag = new JLabel("Einnahmen heute:");
		lblTag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTag.setBounds(374, 79, 112, 23);
		contentPane.add(lblTag);
		
		lblWoche = new JLabel("Einnahmen diese Woche:");
		lblWoche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWoche.setBounds(330, 112, 155, 23);
		contentPane.add(lblWoche);
		
		tbxHeute = new JTextField(Float.toString(tag));
		tbxHeute.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxHeute.setEditable(false);
		tbxHeute.setBounds(501, 82, 143, 17);
		contentPane.add(tbxHeute);

		tbxWoche = new JTextField(Float.toString(woche));
		tbxWoche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxWoche.setEditable(false);
		tbxWoche.setBounds(501, 112, 143, 23);
		contentPane.add(tbxWoche);
		
		tbxGesamt = new JTextField(Float.toString(gesamt));
		tbxGesamt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxGesamt.setEditable(false);
		tbxGesamt.setBounds(501, 148, 143, 20);
		contentPane.add(tbxGesamt);
		
		lblGesamt = new JLabel();
		lblGesamt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGesamt.setText("Insgesamt:");
		lblGesamt.setBounds(420, 148, 74, 20);
		contentPane.add(lblGesamt);

		
	}
	
	public float getTag() {
		return tag;
	}

	public void setTag(float tag) {
		this.tag = tag;
	}

	public float getWoche() {
		return woche;
	}

	public void setWoche(float woche) {
		this.woche = woche;
	}

	public float getGesamt() {
		return gesamt;
	}

	public void setGesamt(float gesamt) {
		this.gesamt = gesamt;
	}

	public LocalTime getNeu() {
		return neu;
	}

	public void setNeu(LocalTime neu) {
		this.neu = neu;
	}

	public String save() {
		p.setgKohle(gesamt);
		p.setTkohle(tag);
		p.setWkohle(woche);
		p.setEnde(NewZeit.aktuelleZeit());
		xstream.processAnnotations(p.getClass());
		String file = "ParkhausSave.xml";
		try {
			xstream.toXML(p, new FileWriter(file));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return xstream.toXML(p);
	}
	
	public void load() {
		NewZeit jetzt = NewZeit.aktuelleZeit();
		XStream xstream = new XStream();
		String file = "ParkhausSave.xml";
		try {
			p = (Parkhaus) xstream.fromXML(new FileReader(file));
			btnEtageErstellen.setEnabled(true);
			btnEtagenAnzeigen.setEnabled(true);
			btnKundenanzeigen.setEnabled(true);
			btnLaden.setEnabled(false);
			btnSpeichern.setEnabled(true);
			btnParkhausAnlegen.setEnabled(false);
			btnTicketautomatenAnzeigen.setEnabled(true);
			btnTicketautomatenerstellen.setEnabled(true);
			tbxEtagenname.setEnabled(true);
			tbxEtagenplaetzte.setEnabled(true);
			tbxPreis.setEnabled(true);
			tbxPreis.setText(Float.toString(p.getManager().getPreis()));
			gesamt = p.getgKohle();
			int dit = NewZeit.differenzinTagen(jetzt, p.getEnde());
			if(dit > 1) {
				tag = 0;
				akt = formata.format(new Date());
				akt = akt.substring(0, 2);
				int t;
				if(akt.equals("Mo")) {
					t = 0;
				} else if(akt.equals("Di")) {
					t = 1;
				} else if(akt.equals("Mi")) {
					t = 2;
				} else if(akt.equals("Do")) {
					t = 3;
				} else if(akt.equals("Fr")) {
					t = 4;
				} else if(akt.equals("Sa")) {
					t = 5;
				} else {
					t = 6;
				}
				if(dit < t) {
					woche = p.getWkohle();
				} else {
					woche = 0;
				}
			} else {
				tag = p.getTkohle();
				woche = p.getWkohle();
			}
			try {
				KundenFenster frame = new KundenFenster(this);
				frame.setVisible(true);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			for(Kunde k : p.getKunden())
			{
				if(k.getParkt())
				{
					try {
						AktuellerPreisFenster frame = new AktuellerPreisFenster(k);
						frame.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	public void newTag() {
		tag = 0;
		akt = formata.format(new Date());
		akt = akt.substring(0, 2);
		if(akt.equals("Mo")) {
			woche = 0;
		}
	}
	
	public void plusGeld(float f) {
		this.tag += f;
		this.woche += f;
		this.gesamt += f;
	}

	@Override
	public void run() {
		
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tbxHeute.setText(Float.toString(tag));
			tbxWoche.setText(Float.toString(woche));
			tbxGesamt.setText(Float.toString(gesamt));
			if(java.lang.Math.toIntExact(ChronoUnit.MILLIS.between(neu, LocalTime.now())) < 2000)
			{
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				newTag();
			}
		}
		
	}
}
