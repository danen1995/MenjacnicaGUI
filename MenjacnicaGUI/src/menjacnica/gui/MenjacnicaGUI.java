package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import menjacnica.tableModels.MenjacnicaTableModel;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextPane textPane;
	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/ikonice/exchange.png")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.izbaciDijalogZaUcitavanje();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/folder_open_add.png")));
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izbaciSacuvajDijalog();
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/save4.png")));
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmNewMenuItem_2);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.ispisiPodatkeOAutoru();
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(300, 200));
		scrollPane.setMinimumSize(new Dimension(100, 100));
		contentPane.add(scrollPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem mntmDodajKurs = new JMenuItem("Dodaj kurs");
		mntmDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.otvoriDodajStudenta();
			}
		});
		popupMenu.add(mntmDodajKurs);
		
		JMenuItem mntmIzbrisiKurs = new JMenuItem("Izbrisi kurs");
		popupMenu.add(mntmIzbrisiKurs);
		
		JMenuItem mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
		popupMenu.add(mntmIzvrsiZamenu);
		
		table = getTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(120, 10));
		panel.setMinimumSize(new Dimension(120, 10));
		panel.setMaximumSize(new Dimension(120, 10));
		contentPane.add(panel, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("Dodaj kurs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.otvoriDodajStudenta();
			}
		});
		btnNewButton.setPreferredSize(new Dimension(100, 23));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izbrisi kurs");
		btnNewButton_1.setPreferredSize(new Dimension(100, 23));
		panel.add(btnNewButton_1);
		
		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		btnIzvrsiZamenu.setPreferredSize(new Dimension(100, 23));
		panel.add(btnIzvrsiZamenu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, BorderLayout.SOUTH);
		
		textPane = new JTextPane();
		textPane.setPreferredSize(new Dimension(6, 50));
		textPane.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setViewportView(textPane);
	}

	private JTable getTable() {
		if(table == null){
			table = new JTable();
			MenjacnicaTableModel model = new MenjacnicaTableModel(GUIKontroler.kursevi);
			table.setModel(model);
		}
		return table;
	
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void osveziTabelu(){
		MenjacnicaTableModel model = (MenjacnicaTableModel) table.getModel();
		model.ucitajKurseve(GUIKontroler.vratiSveKurseve());
		
	}

	public void ispisZaUcitajFajl(String absolutePath) {
		textPane.setText(textPane.getText()+ "Ucitan fajl: " + absolutePath + "\n");
		
	}

	public void ispisZaSacuvajFajl(String absolutePath) {
		textPane.setText(textPane.getText()+ "Sacuvan fajl: " + absolutePath + "\n");
		
	}

	public void ispisZaDodaj(String k) {
		textPane.setText(textPane.getText()+ k + "\n");
		
	}
}
