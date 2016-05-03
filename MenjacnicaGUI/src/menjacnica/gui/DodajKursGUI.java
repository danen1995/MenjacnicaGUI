package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Kurs;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfsifra;
	private JTextField tfnaziv;
	private JTextField tfprodajni;
	private JTextField tfkupovni;
	private JTextField tfsrednji;
	private JTextField tfskraceni;

	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sifra");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(9, 5, 183, 14);
		lblNewLabel.setPreferredSize(new Dimension(200, 14));
		lblNewLabel.setMinimumSize(new Dimension(100, 14));
		lblNewLabel.setMaximumSize(new Dimension(100, 14));
		panel.add(lblNewLabel);
		
		JLabel lblSifra = new JLabel("Naziv");
		lblSifra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSifra.setBounds(214, 5, 183, 14);
		lblSifra.setPreferredSize(new Dimension(200, 14));
		lblSifra.setMinimumSize(new Dimension(100, 14));
		lblSifra.setMaximumSize(new Dimension(100, 14));
		panel.add(lblSifra);
		
		tfsifra = new JTextField();
		tfsifra.setBounds(9, 34, 183, 26);
		panel.add(tfsifra);
		tfsifra.setColumns(10);
		
		tfnaziv = new JTextField();
		tfnaziv.setColumns(10);
		tfnaziv.setBounds(214, 34, 183, 26);
		panel.add(tfnaziv);
		
		tfprodajni = new JTextField();
		tfprodajni.setColumns(10);
		tfprodajni.setBounds(9, 100, 183, 26);
		panel.add(tfprodajni);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProdajniKurs.setPreferredSize(new Dimension(200, 14));
		lblProdajniKurs.setMinimumSize(new Dimension(100, 14));
		lblProdajniKurs.setMaximumSize(new Dimension(100, 14));
		lblProdajniKurs.setBounds(9, 71, 183, 14);
		panel.add(lblProdajniKurs);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKupovniKurs.setPreferredSize(new Dimension(200, 14));
		lblKupovniKurs.setMinimumSize(new Dimension(100, 14));
		lblKupovniKurs.setMaximumSize(new Dimension(100, 14));
		lblKupovniKurs.setBounds(214, 71, 183, 14);
		panel.add(lblKupovniKurs);
		
		tfkupovni = new JTextField();
		tfkupovni.setColumns(10);
		tfkupovni.setBounds(214, 100, 183, 26);
		panel.add(tfkupovni);
		
		tfsrednji = new JTextField();
		tfsrednji.setColumns(10);
		tfsrednji.setBounds(9, 168, 183, 24);
		panel.add(tfsrednji);
		
		JLabel lblSrednjiKurs = new JLabel("Srednji kurs");
		lblSrednjiKurs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSrednjiKurs.setPreferredSize(new Dimension(200, 14));
		lblSrednjiKurs.setMinimumSize(new Dimension(100, 14));
		lblSrednjiKurs.setMaximumSize(new Dimension(100, 14));
		lblSrednjiKurs.setBounds(9, 137, 183, 14);
		panel.add(lblSrednjiKurs);
		
		JLabel lblSkraceniNaziv = new JLabel("Skraceni naziv");
		lblSkraceniNaziv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSkraceniNaziv.setPreferredSize(new Dimension(200, 14));
		lblSkraceniNaziv.setMinimumSize(new Dimension(100, 14));
		lblSkraceniNaziv.setMaximumSize(new Dimension(100, 14));
		lblSkraceniNaziv.setBounds(214, 137, 183, 14);
		panel.add(lblSkraceniNaziv);
		
		tfskraceni = new JTextField();
		tfskraceni.setColumns(10);
		tfskraceni.setBounds(214, 168, 183, 24);
		panel.add(tfskraceni);
		
		JButton btndodaj = new JButton("Dodaj");
		btndodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kurs k = new Kurs(Double.parseDouble(tfprodajni.getText()),
								  Double.parseDouble(tfkupovni.getText()),
								  Double.parseDouble(tfsrednji.getText()), 
								  tfsifra.getText(), tfnaziv.getText(),
								  tfskraceni.getText());
				GUIKontroler.dodajUListu(k);
				GUIKontroler.dodajUTabeluIUStatus(k);
				
				dispose();
			}
		});
		btndodaj.setBounds(9, 217, 183, 23);
		panel.add(btndodaj);
		
		JButton btnodustani = new JButton("Odustani");
		btnodustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnodustani.setBounds(214, 217, 183, 23);
		panel.add(btnodustani);
	}
}
