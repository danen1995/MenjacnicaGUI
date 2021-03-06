package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Kurs;

public class GUIKontroler  {

	private JPanel contentPane;
	private static MenjacnicaGUI menjacnica;
	public static MenjacnicaGUI getMenjacnica() {
		return menjacnica;
	}
	public static void setMenjacnica(MenjacnicaGUI menjacnica) {
		GUIKontroler.menjacnica = menjacnica;
	}
	public static DodajKursGUI getDodajKursGui() {
		return dodajKursGui;
	}
	public static void setDodajKursGui(DodajKursGUI dodajKursGui) {
		GUIKontroler.dodajKursGui = dodajKursGui;
	}
	public static IzvrsiZamenuGUI getIzvrsiZamenu() {
		return izvrsiZamenu;
	}
	public static void setIzvrsiZamenu(IzvrsiZamenuGUI izvrsiZamenu) {
		GUIKontroler.izvrsiZamenu = izvrsiZamenu;
	}
	private static DodajKursGUI dodajKursGui;
	private static IzvrsiZamenuGUI izvrsiZamenu;
	static LinkedList<Kurs> kursevi = new LinkedList<>();
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
				String s = "Ucitan fajl: " + file.getAbsolutePath(); 
				menjacnica.ispisiStatus(s);
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
				String s = "Sacuvan fajl: " + file.getAbsolutePath(); 
				menjacnica.ispisiStatus(s);
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
	public static void otvoriDodajStudenta() {
		dodajKursGui = new DodajKursGUI();
		dodajKursGui.setVisible(true);
		dodajKursGui.setLocationRelativeTo(null);
		
	}
	public static void dodajUTabeluIUStatus(Kurs k) {
		String kursString = k.toString();
		menjacnica.ispisiStatus(kursString);
		menjacnica.osveziTabelu();
		
	}
	public static LinkedList<Kurs> vratiSveKurseve(){
		return kursevi;
	}
	public static void dodajUListu(Kurs k) {
		kursevi.add(k);
		
	}
	public static void izbrisiRed() {
		try{
			int selektovaniRed = menjacnica.vratiSelektovaniRed();
			if(selektovaniRed == -1) {
				JOptionPane.showMessageDialog(menjacnica.getContentPane(), "Niste selektovali red", "Greska", JOptionPane.ERROR_MESSAGE);
			}else{
				int opcija = JOptionPane.showConfirmDialog(menjacnica.getContentPane(), "Da li ste sigurni da zelite da izbrisete red?", "Brisanje reda", JOptionPane.YES_NO_OPTION);
				if(opcija == JOptionPane.YES_OPTION){
					kursevi.remove(selektovaniRed);
					menjacnica.osveziTabelu();
					
					JOptionPane.showMessageDialog(menjacnica.getContentPane(), "Uspesno ste obrisali red", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					String s = "Izbrisali ste red " + selektovaniRed;
					menjacnica.ispisiStatus(s);
				}
				
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(menjacnica, "Doslo je do greske prilikom brisanja reda", "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void otvoriProzorIzvrsiZamenu() {
		izvrsiZamenu = new IzvrsiZamenuGUI();
		izvrsiZamenu.setVisible(true);
		izvrsiZamenu.setLocationRelativeTo(null);
		
	}

	
}
