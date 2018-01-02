package ParkhausAutoSoftware.Fenster;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import ParkhausAutoSoftware.Kunde;
import ParkhausAutoSoftware.NewZeit;
import ParkhausAutoSoftware.Parkhaus;
import ParkhausAutoSoftware.Ticket;

import javax.swing.JButton;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.UUID;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AkutellerPreisFenster extends JFrame implements Runnable {

	private JFrame jf;
	private JPanel contentPane;
	private JTextField tbxPreis;
	private Thread th;
	private Kunde k;

//	try {
//		AkutellerPreisFenster frame = new AkutellerPreisFenster();
//		frame.setVisible(true);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
	
	public AkutellerPreisFenster(Kunde k) {
		this.k = k;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Kundennummer: "+k.getId());
		jf = this;
		
		
		JButton btnSchliessen = new JButton("Schlie\u00DFen");
		btnSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jf.dispose();
			}
		});
		btnSchliessen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSchliessen.setBounds(321, 105, 89, 23);
		contentPane.add(btnSchliessen);
		
		JLabel lblPreis = new JLabel("Preis:");
		lblPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreis.setBounds(81, 45, 55, 23);
		contentPane.add(lblPreis);
		
		tbxPreis = new JTextField();
		tbxPreis.setEditable(false);
		tbxPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxPreis.setBounds(123, 41, 137, 32);
		contentPane.add(tbxPreis);
		tbxPreis.setColumns(10);
		
		if(th == null)
		{
			th = new Thread(this);
			th.start();
		}
		
		
	}

	@Override
	public void run() {
		while(true)
		{
			Ticket t = k.getTicket();
			float preis = t.getPreiseinfahrt();
			int sekunden = NewZeit.differenzinSekunden(t.getEinfahrt(), NewZeit.aktuelleZeit());
			int h = (int)sekunden/3600;
			int min = sekunden-h*3600;
			int sec = (sekunden-h*3600)-min*60;
			DecimalFormat df = new DecimalFormat("0.00");
			tbxPreis.setText(df.format(h*preis + min* (preis/60) + sec *(preis/3600)).toString()+"€");
			if(t.getAusfahrt() != null)
			{
				this.dispose();
			}
		}
	}
}
