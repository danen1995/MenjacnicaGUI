package menjacnica.tableModels;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import menjacnica.Kurs;
public class MenjacnicaTableModel extends AbstractTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] kolone = new String[]{"Sifra","Skraceni naziv","Prodajni","Srednji","Kupovni","Naziv"};
	private LinkedList<Kurs> kursevi;
	public MenjacnicaTableModel(LinkedList<Kurs> kursevi) {
		if(kursevi == null){
			this.kursevi = new LinkedList<>();
		}else{
			this.kursevi=kursevi;
		}
	}
	@Override
	public int getRowCount() {
		return kursevi.size();
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kurs k= new Kurs();
		k = kursevi.get(rowIndex);
		switch(columnIndex){
		case 0: return k.getSifra();
		case 1: return k.getSkraceniNaziv();
		case 2: return k.getProdajniKurs();
		case 3: return k.getSrednjiKurs();
		case 4: return k.getKupovniKurs();
		case 5: return k.getNaziv();
		default: return "";
		}
	}	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
	public void ucitajKurseve(LinkedList<Kurs> kursevi) {
		this.kursevi = kursevi;
		fireTableDataChanged();
	}

	
	
}
