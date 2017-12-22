package utils;

import java.io.File;
import java.util.Scanner;

import gui.ConfigPanel;

/**
 * Usado para cálculo dos FP's e FN's. Só deve ser criado quando o ficheiro rules já está preenchido com
 * os pesos para uma certa configuração. Sempre que é carregada uma nova configuração deve ser criado outro
 * objeto deste tipo.
 *
 */
public class RulesEvaluation {

	private static final int THRESHOLD = 5;
	
	/**
	 * Lê o ficheiro ham/spam e define se é spam ou não com base no que está no hashmap de regra/peso.
	 * @param f
	 */
	public static int FileScanner (File f) {
		Scanner s = null;
		int spam = 0;
		int notSpam = 0;
		try {
			s = new Scanner(f); 
			while (s.hasNextLine()) {
				double count=0;
				String a = s.nextLine();
				String[] b = a.split("\\s");
				for (int i = 1 ; i < b.length; i++) {
					if (ConfigPanel.getRegras().containsKey(b[i]))
						count += ConfigPanel.getRegras().get(b[i]);
				}
				if (count > THRESHOLD)
					spam++;
				else 
					notSpam++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(s!=null)
				s.close();
		}
		if (f.getName().equals("ham.log.txt"))
			return spam;
		else
			return notSpam;
	}

}
