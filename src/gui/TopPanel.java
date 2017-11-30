package gui;

import java.awt.GridLayout;

import javax.swing.*;

public class TopPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TopPanel() {
		this.setLayout(new GridLayout(0, 2));
		addContent();
	}

	private void addContent() {
		JPanel files = new JPanel();
		files.setLayout(new GridLayout(0,2,15,3));
		JLabel spam = new JLabel("spam.log",SwingConstants.RIGHT);
		JLabel log = new JLabel("ham.log",SwingConstants.RIGHT);
		JLabel rules = new JLabel("rules.cf",SwingConstants.RIGHT);
		files.add(rules);
		files.add(new JTextField());
		files.add(log);
		files.add(new JTextField());
		files.add(spam);
		files.add(new JTextField());
		this.add(leftpanel());
		
		
		this.add(files);
	}
	
	public JPanel leftpanel(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(2,0));
		pane.add(new JLabel("Caminho para os ficheiros"));
		JPanel checks = new JPanel(new GridLayout(2, 2));
		JLabel man_config = new JLabel("Configuração manual");
		JLabel auto_config = new JLabel("Configuração automática");
		JCheckBox check_man = new JCheckBox();	
		JCheckBox check_auto = new JCheckBox();
		ButtonGroup check_group = new ButtonGroup();
		checks.add(man_config);
		checks.add(check_man);
		check_group.add(check_auto);
		check_group.add(check_man);
		checks.add(auto_config);
		checks.add(check_auto);
		pane.add(checks);
		return pane;
	}
}
