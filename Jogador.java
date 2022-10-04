package trucaoUFOP;

/**
 * Na classe Jogador e criado um jogador generico para qualquer jogo.
 */

public class Jogador {
	private String nome;
	
	/**
	 * Seu construtor exige um nome.
	 * @param nome
	 */
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	/**
	 * E atraves desse metodo e possevel saber o nome do jogador
	 * @return nome
	 */
	
	public String getNome() {
		return this.nome;
	}
}
