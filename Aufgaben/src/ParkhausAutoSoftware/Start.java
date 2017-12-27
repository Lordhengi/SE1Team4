package ParkhausAutoSoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ParkhausAutoSoftware.Fenster.KundenFenster;
import ParkhausAutoSoftware.Fenster.ParkhausAnlegen;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class Start extends JFrame {

	private JPanel contentPane;
	private Parkhaus p;
	private ParkhausAnlegen frame = null;
	private JList listeDaten = null;
	private JTable tblKunden;
	private JTable tblTicketautomaten;

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
		setBounds(100, 100, 689, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnzahlParkpltze = new JLabel("Anzahl Parkpl\u00E4tze");
		lblAnzahlParkpltze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnzahlParkpltze.setBounds(223, 11, 111, 23);
		contentPane.add(lblAnzahlParkpltze);
		
		JButton btnParkhausAnlegen = new JButton("Parkhaus anlegen");
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
							p.addTicketautomat();
							p.einfahren(0,0);
							p.einfahren(1,0);
							p.einfahren(2,0);
							
							try {
								KundenFenster frame = new KundenFenster(p);
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
		
		JButton btnKundenanzeigen = new JButton("Kunden anzeigen");
		btnKundenanzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tblKunden.setVisible(true);
				tblTicketautomaten.setVisible(false);
				List<Kunde> kunden = p.getKunden();
				Kunde[] oids = new Kunde[kunden.size()];
				oids = kunden.toArray(oids);
				((DefaultTableModel) tblKunden.getModel()).getDataVector().removeAllElements();
				Object[] rowColumnName = new Object[oids.length];
				rowColumnName[0] = "Kundennummer";
				rowColumnName[1] = "Ticketanzahl";
				rowColumnName[2] = "Geparkt";
				((DefaultTableModel) tblKunden.getModel()).addRow(rowColumnName);
				
				for(int i = 0; i < oids.length; i++)
				{
					Object[] row = new Object[oids.length];
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
		
		JButton btnTicketautomatenerstellen = new JButton("Ticketautomaten erstellen");
		btnTicketautomatenerstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.addTicketautomat();
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
		
		
		JButton btnTicketautomatenAnzeigen = new JButton("Ticketautomaten anzeigen");
		btnTicketautomatenAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblKunden.setVisible(false);
				tblTicketautomaten.setVisible(true);
				List<Ticketautomat> listeTa = p.getTicketautomaten();
				Ticketautomat[] oids = new Ticketautomat[listeTa.size()];
				oids = listeTa.toArray(oids);
				((DefaultTableModel) tblTicketautomaten.getModel()).getDataVector().removeAllElements();
				Object[] rowColumnName = new Object[oids.length];
				rowColumnName[0] = "Ticketautomatennummer";
				((DefaultTableModel) tblTicketautomaten.getModel()).addRow(rowColumnName);
				
				for(int i = 0; i < oids.length; i++)
				{
					Object[] row = new Object[oids.length];
					row[0] = i;
					((DefaultTableModel) tblTicketautomaten.getModel()).addRow(row);
				}
				revalidate();
			}
		});
		btnTicketautomatenAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTicketautomatenAnzeigen.setBounds(220, 47, 200, 23);
		contentPane.add(btnTicketautomatenAnzeigen);
		
		

	}
}
