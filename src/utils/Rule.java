package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Rule {
private Integer value;
private String rule;

public Rule(String rule) {
	value= 0;
	this.rule=rule;
}

public String getRule() {
	return rule;
}

public Integer getValue() {
	return value;
}

public class MyTextField extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyTextField() {
		AddListeners();
	}
	
	@Override
	public String toString() {
		return this.getText();
	}
	
	public void AddListeners(){
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Enter key pressed");
				//juntar valor ao file
			}
		});
	}
}
}
