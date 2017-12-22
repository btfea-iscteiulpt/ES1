package gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


/**
 * Cria o menu com o qual o utilizador pode interagir(escolher caminho dos ficheiros, 
 * escolher a configuração,etc.).
 *
 */
public class UserMenu { 
	private JPanel manual_config;
	private JPanel auto_config;
	private JFrame frame = new JFrame("Anti-Spam Filtering");
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
	
	/**
	 * Arranca o método GUI que constrói a janela e mostra-a no ecrã.
	 */
	public void init(){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				gui();			
			}
		});
	}
	
	/**
	 * Constrói a janela do utilizador e faz o display da mesma.
	 */
	private void gui(){
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TopPanel files_config = new TopPanel(this);
		files_config.addContent();
		
		manual_config = new ConfigPanel(true,this);
		manual_config.setVisible(false);
		
		auto_config = new ConfigPanel(false,this);
		auto_config.setVisible(false);
				
		frame.add(files_config);
		frame.add(manual_config);
		frame.add(auto_config);
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Getter do painel de configuração manual.
	 * @return NULL caso ainda não tenha sido criada a janela.
	 */
	public JPanel getManual_config() {
		return manual_config;
	}
	
	/**
	 * Getter da frame sobre a qual estão construidos os JComponents restantes.
	 * @return NULL caso ainda não tenha sido criada a janela.
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Getter do painel de configuração automática.
	 * @return NULL caso ainda não tenha sido criada a janela.
	 */
	public JPanel getAuto_config() {
		return auto_config;
	}
	
	/**
	 * Preenche ambas as tabelas de configuração com base no contéudo do ficheiro.
	 * @param f Ficheiro a ser utilizado para preencher as tabelas.
	 */
	public void fillTables(File f){
		if(f==null)
			throw new IllegalArgumentException();
			((ConfigPanel)auto_config).content(f);
			((ConfigPanel)manual_config).content(f);
	}
	
	/**
	 * Getter da lista de ficheiros que são utilizados durante o funcionmanento da aplicação.
	 * @return Lista de ficheiros existente.
	 */
	public List<File> getFile_list() {
		return file_list;
	}
	
	public File getEvaluationFile(String name){
		for (File file : file_list) {
			System.out.println(file);
			if(file.getAbsolutePath().endsWith(name))
			return file;
		}
		throw new IllegalArgumentException("Ficheiro não existente na lista de ficheiros carregados.");
	}
	
}
