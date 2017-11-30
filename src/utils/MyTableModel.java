package utils;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
private boolean editable;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyTableModel(boolean editable) {
		this.editable=editable;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if(editable){
		if(column==1)
			return true;
	}
	return false;
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return getValueAt(0, arg0).getClass();
	}
/*
	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		//String value = ((JTextField) arg0).getText();
		//super.setValueAt(value, arg1, arg2);
		System.out.println("changed");
	}*/

	@Override
	public int getColumnCount() {
		return 2;
	}
	
	@Override
	public String getColumnName(int column) {
		if(column==0)
			return "Lista de regras";
			return "Pesos";
	}

}
