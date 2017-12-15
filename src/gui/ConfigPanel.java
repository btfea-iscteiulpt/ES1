package gui;

import java.awt.Dimension;
import java.io.File;

import javax.swing.*;

import utils.BuildBehavior;
import utils.TableFileBuildBehavior;

public class ConfigPanel extends JPanel {
private BuildBehavior behavior= new TableFileBuildBehavior();
private boolean editable;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5973344758120539378L;

	
	public ConfigPanel(boolean editable){
		this.editable=editable;
	}
	
	public void content(File path){
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		JTable table = (JTable) behavior.init(path,editable);
		table.setPreferredScrollableViewportSize(new Dimension(table.getPreferredSize().width,table.getRowHeight()*5));
		JScrollPane scroll = new JScrollPane(table);
		left.add(config(editable));
		left.add(scroll);
		left.add(labels());
		this.add(left);
		JTextArea evaluation = new JTextArea("[Add evaluation]");
		this.add(evaluation);
	}
	
	private static JLabel config(boolean b){
		String s;
		if(b)
			s="Configuração manual";
		else
			s="Configuração automática";
			return new JLabel(s);
		}
	
	private static JPanel labels(){
		JPanel pane = new JPanel();
		pane.add(new JLabel("FP = "));
		pane.add(new JLabel("FN = "));
		return pane;
	}
}
