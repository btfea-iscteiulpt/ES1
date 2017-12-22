package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gui.ConfigPanel;

/**
 * Usado para c�lculo dos FP's e FN's.
 */
public final class RulesEvaluation {

	private static final int THRESHOLD = 5;
	
	/**
	 * L� o ficheiro ham/spam e define se � spam ou n�o com base no que est� no hashmap de regra/peso.
	 * @param f
	 */
	public static int FileScanner (File f,ConfigPanel panel) {
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
					if (panel.getRegras().containsKey(b[i]))
						count += panel.getRegras().get(b[i]);
				}
				if (count <= THRESHOLD && count>= (-THRESHOLD))
					notSpam++;
				else 
					spam++;
			}
			
		} catch (FileNotFoundException  e) {
			System.out.println("Caminho para o ficheiro n�o encontrado.");
		} finally {
			if(s!=null)
				s.close();
		}
		if (f.getAbsolutePath().endsWith("ham.log"))
			return spam;
		else
			return notSpam;
	}

}
