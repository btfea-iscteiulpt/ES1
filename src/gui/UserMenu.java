package gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


/**
 * Cria o menu com o qual o utilizador pode interagir(escolher caminho dos ficheiros, 
 * escolher a configura��o,etc.).
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
	 * Arranca o m�todo GUI que constr�i a janela e mostra-a no ecr�.
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
	 * Constr�i a janela do utilizador e faz o display da mesma.
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
	 * Getter do painel de configura��o manual.
	 * @return NULL caso ainda n�o tenha sido criada a janela.
	 */
	public JPanel getManual_config() {
		return manual_config;
	}
	
	/**
	 * Getter da frame sobre a qual est�o construidos os JComponents restantes.
	 * @return NULL caso ainda n�o tenha sido criada a janela.
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Getter do painel de configura��o autom�tica.
	 * @return NULL caso ainda n�o tenha sido criada a janela.
	 */
	public JPanel getAuto_config() {
		return auto_config;
	}
	
	/**
	 * Preenche ambas as tabelas de configura��o com base no cont�udo do ficheiro.
	 * @param f Ficheiro a ser utilizado para preencher as tabelas.
	 */
	public void fillTables(File f){
		if(f==null)
			throw new IllegalArgumentException();
			((ConfigPanel)auto_config).content(f);
			((ConfigPanel)manual_config).content(f);
	}
	
	/**
	 * Getter da lista de ficheiros que s�o utilizados durante o funcionmanento da aplica��o.
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
		throw new IllegalArgumentException("Ficheiro n�o existente na lista de ficheiros carregados.");
	}
	
}
