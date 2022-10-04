package trucaoUFOP;


/**
 * Nessa classe e criada a carta, utilizando o ENUM Naipe, Carta e e atribuido um
 * valor a ela.
 **/

public class Carta {
	private String naipe;
	private String nome;
	private int valor;
	
	/**
	 * Para se gerar a carta e necessario passar o valor, naipe e nome para o seu
	 * construtor.
	 * 
	 * @param valor
	 * @param naipe
	 * @param nome
	 */
	public Carta(int valor, String naipe, String nome){
		this.naipe=naipe;
		this.nome=nome;
		this.valor=valor;
	}
	
	/**
	 * Retorna o valor da carta.
	 * @return valor
	 */

	public int getValor() {
		return valor;
	}
	
	/**
	 * Modifica o valor da carta
	 * @param valor
	 */

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * Retorna o Naipe da carta
	 * @return naipe
	 */

	public String getNaipe() {
		return naipe;
	}
	
	/**
	 * Retorna o nome da carta
	 * @return nome
	 */

	public String getNome() {
		return nome;
	}
}