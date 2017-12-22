package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * representa um par regra e o seu peso correspondente. (DEPRECATED)
 *
 */
public class Rule {
private Integer value;
private String rule;

public Rule(String rule) {
	if(rule==null)
		throw new IllegalArgumentException();
	value= 0;
	this.rule=rule;
}

/**
 * Getter para o nome da regra.
 * @return nome da regra.
 */
public String getRule() {
	return rule;
}

/**
 * Getter para o peso da regra.
 * @return peso da regra.
 */
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
