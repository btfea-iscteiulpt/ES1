package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Usado para cálculo dos FP's e FN's. Só deve ser criado quando o ficheiro rules já está preenchido com
 * os pesos para uma certa configuração. Sempre que é carregada uma nova configuração deve ser criado outro
 * objeto deste tipo.
 * @author Miguel
 *
 */
public class RulesEvaluation {
	private Map<String, Integer> regras = new HashMap<String, Integer>();

	/**
	 * Lê o ficheiro rules.cf após a configuração dos pesos. Este método preenche o HashMap de regra/peso
	 * para calculo dos FP´s e FN´s. DEPRECATED.
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
	 * Lê o ficheiro ham/spam e define se é spam ou não com base no que está no hashmap de regra/peso.
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
					System.out.println("é spam!!!");
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
