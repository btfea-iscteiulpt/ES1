package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import utils.BuildBehavior;
import utils.RulesEvaluation;
import utils.TableFileBuildBehavior;

/**
 * Subclasse de JPanel usada nas configurações automática e manual.
 *
 */
public class ConfigPanel extends JPanel {
private boolean editable;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5973344758120539378L;

	private static Map<String, Integer> regras = new HashMap<String, Integer>();
	
	public static Map<String, Integer> getRegras() {
		return regras;
	}
	
	/**
	 * Construtor da classe ConfigPanel.
	 * @param editable booleano que indica se a coluna de pesos poderá ser alterada.
	 */
	public ConfigPanel(boolean editable){
		this.editable=editable;
	}
	
	/**
	 * Constrói e mostra no ecrá o contéudo do painel, incluindo a tabela da configuração que é preenchida
	 * com base no ficheiro dado nos argumentos.
	 * @param path Ficheiro a partir do qual se vai preencher a tabela de configuração.
	 */
	public void content(File path){
		if(path==null)
			throw new IllegalArgumentException();
		BuildBehavior behavior= new TableFileBuildBehavior();
		JTable table = (JTable) behavior.init(path,editable);
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		table.setPreferredScrollableViewportSize(new Dimension(table.getPreferredSize().width,table.getRowHeight()*5));
		JScrollPane scroll = new JScrollPane(table);
		left.add(config(editable));
		left.add(scroll);
		JPanel pane = new JPanel();
		JLabel fp = new JLabel("FP = ");
		JLabel fn = new JLabel("FN = ");
		pane.add(fp);
		pane.add(fn);
		left.add(pane);
		this.add(left);
		JTextArea evaluation = new JTextArea("[Add evaluation]");
		this.add(evaluation);
		JButton button = new JButton("Test");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < table.getRowCount(); i++)
					regras.put((String) table.getValueAt(i, 0), (int) table.getValueAt(i, 1));
				fp.setText("FP = " + RulesEvaluation.FileScanner(new File("ham.log.txt")));
				fn.setText("FN = " + RulesEvaluation.FileScanner(new File("spam.log.txt")));
			}
		});
		this.add(button);
	}
	
	/**
	 * Cria label com o nome da configuração escolhida.
	 * @param b True para configuração manual. False para configuração automática.
	 * 
	 * @return
	 */
	private static JLabel config(boolean b){
		String s;
		if(b)
			s="Configuração manual";
		else
			s="Configuração automática";
			return new JLabel(s);
		}
	
	
}