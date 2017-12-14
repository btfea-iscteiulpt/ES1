package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Usado para c�lculo dos FP's e FN's. S� deve ser criado quando o ficheiro rules j� est� preenchido com
 * os pesos para uma certa configura��o. Sempre que � carregada uma nova configura��o deve ser criado outro
 * objeto deste tipo.
 * @author Miguel
 *
 */
public class RulesEvaluation {
	private Map<String, Integer> regras = new HashMap<String, Integer>();

	/**
	 * L� o ficheiro rules.cf ap�s a configura��o dos pesos. Este m�todo preenche o HashMap de regra/peso
	 * para calculo dos FP�s e FN�s. DEPRECATED.
	 */
	public void FileScannerRules() {
		Scanner s=null;
		try {
			s = new Scanner(new File("rules.cf"));
			while (s.hasNextLine()) {
				String[] str = s.nextLine().split(" ");
				regras.put(str[0], Integer.valueOf(str[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(s!=null)
			s.close();
		}

	}

	/**
	 * L� o ficheiro ham/spam e define se � spam ou n�o com base no que est� no hashmap de regra/peso.
	 * @param f
	 */
	public void FileScanner (File f) {
		Scanner s = null;
		try {
			s = new Scanner(f); 
			while (s.hasNextLine()) {
				double count=0;
				String [] a = s.nextLine().split(" ");
				for (int i =1 ; i<a.length; i++){
					count += regras.get(a[i]);
				}
				if (count > 5 || count < -10)
					System.out.println("� spam!!!");
				else 
					System.out.println("not spam!!!");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(s!=null)
				s.close();
		}
	}

}
