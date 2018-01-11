package ParkhausAutoSoftware.Fenster;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ParkhausAutoSoftware.Kunde;
import ParkhausAutoSoftware.NewZeit;
import ParkhausAutoSoftware.Ticket;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.awt.event.ActionEvent;

public class KundenTicketsFenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblTickets;

	public KundenTicketsFenster(Kunde k) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 795, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		DefaultTableModel dtmTickets= new DefaultTableModel();
		tblTickets = new JTable(dtmTickets);
		tblTickets.setEnabled(false);
		tblTickets.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"TicketId", "Einfahrtszeit", "Ausfahrtszeit", "Preis zur Einfahrt", "Bezahlter Preis"
				}
			));
		tblTickets.setBounds(10, 11, 759, 316);
		contentPane.add(tblTickets);
		
		JButton button = new JButton("Schlie\u00DFen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(651, 349, 118, 23);
		contentPane.add(button);
		
		if(k != null)
		{
			setTitle("KundenId: "+k.getId());
			List<Ticket> listeTickets = k.getTickets();
			Ticket[] oids = new Ticket[listeTickets.size()];
			oids = listeTickets.toArray(oids);
			((DefaultTableModel) tblTickets.getModel()).getDataVector().removeAllElements();
			Object[] rowColumnName = new Object[5];
			rowColumnName[0] = "TicketId";
			rowColumnName[1] = "Einfahrtszeit";
			rowColumnName[2] = "Ausfahrtszeit";
			rowColumnName[3] = "Preis zur Einfahrt";
			rowColumnName[4] = "Bezahlter Preis";
			((DefaultTableModel) tblTickets.getModel()).addRow(rowColumnName);
			
			for(int i = 0; i < oids.length; i++)
			{
				Object[] row = new Object[5];
				row[0] = oids[i].getId();
				row[1] = oids[i].getEinfahrt().toString();
				if(oids[i].getAusfahrt() != null)
				{
					row[2] = oids[i].getAusfahrt().toString();
					float preis = oids[i].getPreiseinfahrt();
					int sekunden = NewZeit.differenzinSekunden(oids[i].getEinfahrt(), oids[i].getAusfahrt());
					int h = (int)sekunden/3600;
					int min = sekunden-h*3600;
					int sec = (sekunden-h*3600)-min*60;
					DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(getLocale());
					otherSymbols.setDecimalSeparator('.');
					otherSymbols.setGroupingSeparator('.'); 
					DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
					float x = (h*preis + min* (preis/60) + sec *(preis/3600));
					row[4] = df.format(x).toString();
				}
				else
				{
					row[2] = "parkt noch";
					row[4] = "--";
				}
				row[3] = oids[i].getPreiseinfahrt();
				((DefaultTableModel) tblTickets.getModel()).addRow(row);
			}								
			revalidate();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Kunde nicht vorhanden","ungültiger Kunde", JOptionPane.ERROR_MESSAGE);
		}
	}
}
