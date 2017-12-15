package gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import utils.RulesEvaluation;


public class UserMenu { 
	private JPanel manual_config;
	private JPanel auto_config;
	private JFrame frame;
	private List<File> file_list = new ArrayList<File>();
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e){
			e.printStackTrace();
		}
	//	new UserMenu("c:/users/Miguel/downloads/rules.cf").init();
		new UserMenu().init();
	}
	
	void init(){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				gui();			
			}
		});
	}
	

	public void gui(){
		frame = new JFrame("Anti-Spam Filtering");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel files_config = new TopPanel(this);
		
		manual_config = new ConfigPanel(true);
		manual_config.setVisible(false);
		
		auto_config = new ConfigPanel(false);
		auto_config.setVisible(false);
				
		frame.add(files_config);
		frame.add(manual_config);
		frame.add(auto_config);
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
	public JPanel getManual_config() {
		return manual_config;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JPanel getAuto_config() {
		return auto_config;
	}
	
	public void fillTables(File f){
			((ConfigPanel)auto_config).content(f);
			((ConfigPanel)manual_config).content(f);
	}
	
	public List<File> getFile_list() {
		return file_list;
	}
	
}
