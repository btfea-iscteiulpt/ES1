package utils;

/**
 * Interface que define o comportamento de construção de um objecto.
 *
 */
public interface BuildBehavior {

	/**
	 * Cria um objeto conforme a implementação especificada e devolve-o.
	 * @param o contém a informação essencial à construção do objecto final
	 * @param b define se o objecto deve poder ser alterável ou não.
	 * @return objeto final
	 */
Object init(Object o,boolean b);
	
}
