package utils;

/**
 * Interface que define o comportamento de constru��o de um objecto.
 *
 */
public interface BuildBehavior {

	/**
	 * Cria um objeto conforme a implementa��o especificada e devolve-o.
	 * @param o cont�m a informa��o essencial � constru��o do objecto final
	 * @param b define se o objecto deve poder ser alter�vel ou n�o.
	 * @return objeto final
	 */
Object init(Object o,boolean b);
	
}
