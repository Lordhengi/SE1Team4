package ParkhausAutoSoftware.Fenster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class ParkhausAnlegen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame jf = null;
	private JPanel contentPane;
	private JTextField tbxParkhausName;
	private JTextField tbxManagerName;
	private JTextField tbxPreis;
	private String Parkhausname;
	private String Managername;
	private float Preis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkhausAnlegen frame = new ParkhausAnlegen();
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
	public ParkhausAnlegen() {
		setTitle("Parkhaus anlegen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jf = this;
		
		JButton btnAnlegen = new JButton("Anlegen");
		btnAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tbxParkhausName.getText().equals("") || !tbxManagerName.getText().equals("") || !tbxPreis.getText().equals(""))
				{
					try {
					Parkhausname = tbxParkhausName.getText();
					Managername = tbxManagerName.getText();
					Preis = Float.parseFloat(tbxPreis.getText());
					dispose();
					}catch(NumberFormatException ex)
					{
						Parkhausname = null;
						Managername = null;
						Preis = 0;
						JOptionPane.showMessageDialog(jf, "Bitte kontrollieren sie nochmals alle Textfelder auf ihre Werte !","Textfeld leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(jf, "Bitte kontrollieren sie nochmals alle Textfelder auf ihre Werte !","Textfeld leer oder ungültiger Wert", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAnlegen.setBounds(335, 121, 89, 23);
		contentPane.add(btnAnlegen);
		
		tbxParkhausName = new JTextField();
		tbxParkhausName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxParkhausName.setBounds(153, 14, 218, 23);
		contentPane.add(tbxParkhausName);
		tbxParkhausName.setColumns(10);
		
		tbxManagerName = new JTextField();
		tbxManagerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxManagerName.setColumns(10);
		tbxManagerName.setBounds(153, 48, 218, 23);
		contentPane.add(tbxManagerName);
		
		tbxPreis = new JTextField();
		tbxPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxPreis.setColumns(10);
		tbxPreis.setBounds(153, 82, 218, 23);
		contentPane.add(tbxPreis);
		
		JLabel lblParkhausname = new JLabel("Parkhausname");
		lblParkhausname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParkhausname.setBounds(26, 14, 111, 23);
		contentPane.add(lblParkhausname);
		
		JLabel lblManagername = new JLabel("Managername");
		lblManagername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblManagername.setBounds(26, 48, 111, 23);
		contentPane.add(lblManagername);
		
		JLabel lblTicketpreis = new JLabel("Ticketpreis");
		lblTicketpreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTicketpreis.setBounds(26, 82, 111, 23);
		contentPane.add(lblTicketpreis);
	}

	public String getParkhausname() {
		return Parkhausname;
	}

	public String getManagername() {
		return Managername;
	}

	public float getPreis() {
		return Preis;
	}
	
	
}
