package ParkhausAutoSoftware.Fenster;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ParkhausAutoSoftware.Kunde;
import ParkhausAutoSoftware.NewZeit;
import ParkhausAutoSoftware.Ticket;

import javax.swing.JButton;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AktuellerPreisFenster extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JFrame jf;
	private JPanel contentPane;
	private JTextField tbxPreis;
	private Thread th;
	private Kunde k;
//	private boolean isRunning;

//	try {
//		AkutellerPreisFenster frame = new AkutellerPreisFenster();
//		frame.setVisible(true);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
	
	public AktuellerPreisFenster(Kunde k) {
		this.k = k;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Kundennummer: "+k.getId());
		jf = this;
//		isRunning = true;
		
/*		WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
               this
            }
        };*/
		
		JButton btnSchliessen = new JButton("Schlie\u00DFen");
		btnSchliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jf.dispose();
			}
		});
		btnSchliessen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSchliessen.setBounds(306, 105, 118, 23);
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

/*	public int setRunning(boolean isRunning) {
		this.isRunning = isRunning;
		return 0;
	}*/

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
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
