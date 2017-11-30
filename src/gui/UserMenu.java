package gui;

import java.io.File;

import javax.swing.*;


public class UserMenu { 
	private File path;
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e){
			e.printStackTrace();
		}
		new UserMenu("c:/users/Miguel/downloads/rules.cf").gui();
	}
	
	public UserMenu(String p) {
		path=buildPath(p);
	}
	
	void init(){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				gui();			
			}
		});
	}
	
	public File buildPath(String path){
		System.out.println("okay");
		return new File(path);
	}

	public void gui(){
		JFrame frame = new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel files_config = new TopPanel();
		frame.add(files_config);
		
		JPanel manual_config = new ConfigPanel(path,true);
		frame.add(manual_config);
		
		JPanel auto_config = new ConfigPanel(path,false);
		frame.add(auto_config);
		
		
		frame.pack();
		frame.setVisible(true);
	}
}
