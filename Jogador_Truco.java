package trucaoUFOP;

/**
 * Aqui e criado o Jogador do jogo de truco, e uma classe filha da classe Jogador
 */

import java.util.ArrayList;

public class Jogador_Truco extends Jogador {
	private ArrayList<Carta> mao;
	
	/**
	 * Para se criar um jogador e necessario saber o nome, entao o construtor exige
	 * esse parametro
	 */
	public Jogador_Truco(String nome){
		super(nome);
	}
	
	/**
	 * e possivel remover uma carta da mao do jogador
	 * @param i
	 */
	
	public void remove_carta(int i) {
		mao.remove(i);
	}
	
	/**
	 * Retorna a mao do jogador, que e um ArrayList do tipo Carta.
	 * @return mao
	 */

	public ArrayList<Carta> getMao() {
		return mao;
	}
	
	/**
	 * Adiciona uma nova mao de cartas ao jogador
	 * @param mao2
	 */

	public void setMao(ArrayList<Carta> mao2) {
		this.mao = mao2;
	}
}
