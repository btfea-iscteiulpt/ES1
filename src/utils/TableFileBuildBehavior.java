package utils;

import java.io.File;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Implementa o comportamento de construção para tabelas.
 */
public class TableFileBuildBehavior implements BuildBehavior {
	
	@Override
	public Object init(Object o,boolean editable) {		
		DefaultTableModel model;
		try {
			model = new MyTableModel(editable);
			File file = (File) o;
			Scanner s = new Scanner(file);
			while(s.hasNextLine()){
				Rule rule = new Rule(s.nextLine());
				model.addRow(new Object[]{rule.getRule(),rule.getValue()});
			}
			s.close();
			return new JTable(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException();
	}
}
