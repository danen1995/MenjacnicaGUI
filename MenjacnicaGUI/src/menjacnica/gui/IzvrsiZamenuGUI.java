package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfkupovni;
	private JTextField tfprodajni;
	private JTextField tfiznos;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			}
		});
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kupovni kurs");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(30, 11, 120, 14);
		panel.add(lblNewLabel);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProdajniKurs.setBounds(290, 11, 109, 14);
		panel.add(lblProdajniKurs);
		
		JLabel lblIznos = new JLabel("Iznos");
		lblIznos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIznos.setBounds(30, 107, 46, 14);
		panel.add(lblIznos);
		
		JLabel lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		lblVrstaTransakcije.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVrstaTransakcije.setBounds(277, 88, 109, 14);
		panel.add(lblVrstaTransakcije);
		
		JRadioButton rbtnProdajna = new JRadioButton("Prodajna");
		buttonGroup.add(rbtnProdajna);
		rbtnProdajna.setFont(new Font("Tahoma", Font.BOLD, 11));
		rbtnProdajna.setBounds(277, 133, 109, 23);
		panel.add(rbtnProdajna);
		
		JRadioButton rdbtnKupovna = new JRadioButton("Kupovna");
		buttonGroup.add(rdbtnKupovna);
		rdbtnKupovna.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnKupovna.setBounds(277, 107, 109, 23);
		panel.add(rdbtnKupovna);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
		comboBox.setBounds(158, 40, 92, 20);
		panel.add(comboBox);
		
		tfkupovni = new JTextField();
		tfkupovni.setEditable(false);
		tfkupovni.setBounds(30, 40, 86, 20);
		panel.add(tfkupovni);
		tfkupovni.setColumns(10);
		
		tfprodajni = new JTextField();
		tfprodajni.setEditable(false);
		tfprodajni.setColumns(10);
		tfprodajni.setBounds(290, 40, 86, 20);
		panel.add(tfprodajni);
		
		tfiznos = new JTextField();
		tfiznos.setBounds(30, 132, 151, 20);
		panel.add(tfiznos);
		tfiznos.setColumns(10);
		
		JButton btnNewButton = new JButton("Izvrsi zamenu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vrstaTransakcije = "";
				if(rdbtnKupovna.isSelected()){
					vrstaTransakcije = rdbtnKupovna.getText();
				}else
				if(rbtnProdajna.isSelected()){
					vrstaTransakcije = rbtnProdajna.getText();
				}else {
					JOptionPane.showMessageDialog(null, "Morate izabrati vrstu transakcije.", "Greska", JOptionPane.ERROR_MESSAGE );
					return;
				}
				String iznos = tfiznos.getText();
				if(iznos.isEmpty()){
					JOptionPane.showMessageDialog(null, "Morate uneti iznos.", "Greska", JOptionPane.ERROR_MESSAGE );
					return;
				}
				String valuta = comboBox.getSelectedItem().toString();
				String s ="Naziv valute: "+valuta+ ", Vrsta transakcije: "+vrstaTransakcije + ", Iznos: "+iznos;
				GUIKontroler.getMenjacnica().ispisiStatus(s);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(30, 227, 173, 23);
		panel.add(btnNewButton);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOdustani.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOdustani.setBounds(226, 227, 173, 23);
		panel.add(btnOdustani);
		
		JSlider slider = new JSlider();
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tfiznos.setText(slider.getValue()+"");
			}
		});
	
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(10);
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		slider.setBounds(30, 163, 369, 53);
		panel.add(slider);
	}
}
