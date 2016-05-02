package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.nio.channels.ShutdownChannelGroupException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIKontroler  {

	private JPanel contentPane;
	private static MenjacnicaGUI menjacnica;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new MenjacnicaGUI();
					menjacnica.setVisible(true);
					menjacnica.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void izbaciDijalogZaUcitavanje() {
		try {
			JFileChooser jfc = new JFileChooser();
			int vrednost = jfc.showOpenDialog(menjacnica.getContentPane());
			if(vrednost == jfc.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				menjacnica.ispisZaUcitajFajl(file.getAbsolutePath());
			}
		} catch (Exception e) {
			
		}
	}
	public static void izbaciSacuvajDijalog() {
		try {
			JFileChooser jfc = new JFileChooser();
			int vrednost = jfc.showOpenDialog(menjacnica.getContentPane());
			if(vrednost == jfc.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				menjacnica.ispisZaSacuvajFajl(file.getAbsolutePath());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(menjacnica.getContentPane(), "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_CANCEL_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public static void ispisiPodatkeOAutoru() {
		JOptionPane.showMessageDialog(menjacnica.getContentPane(), "Dane Nikolic, 44/14.");
	}
}
