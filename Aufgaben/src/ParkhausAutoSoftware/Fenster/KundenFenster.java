package ParkhausAutoSoftware.Fenster;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ParkhausAutoSoftware.Parkhaus;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KundenFenster extends JFrame {

	private JPanel contentPane;
	private JTextField tbxKundenId;
	private Parkhaus p;

	
	/**
	 * Create the frame.
	 */
	public KundenFenster(Parkhaus p) {
		setTitle("Kundeninterface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.p = p;
		JButton btnNewButton = new JButton("Kunde f\u00E4hrt ein");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(345, 43, 150, 35);
		contentPane.add(btnNewButton);
		
		tbxKundenId = new JTextField();
		tbxKundenId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbxKundenId.setBounds(65, 43, 230, 35);
		contentPane.add(tbxKundenId);
		tbxKundenId.setColumns(10);
	}

}
