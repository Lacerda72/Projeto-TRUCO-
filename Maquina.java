package trucaoUFOP;

import java.util.ArrayList;

/**
 * Nessa classe e criada a maquina com a qual iremos jogar contra.
 *
 */

public class Maquina extends Jogador_Truco {
	private ArrayList<Carta> mao;
	private static float esperanca = 0;
	
	/**
	 * Maquina e Filha de Jogador_Truco, entao por convencao ela tambem recebe um
	 * nome.
	 */

	public Maquina(String nome) {
		super(nome);
	}
	
	/**
	 * Metodo que retorna a mao da Maquina
	 * return mao
	 */

	public ArrayList<Carta> getMao() {
		return mao;
	}
	
	/**
	 * Metodo que remove uma carta da mao da maquina
	 */
	
	public void remove_carta(int i) {
		mao.remove(i);
	}
	
	/**
	 * Metodo que modifica a mao da maquina
	 */

	public void setMao(ArrayList<Carta> mao) {
		this.mao = mao;
	}
	
	/**
	 * Metodo que retorna a esperanca da maquina, espepranca � a variavel com a
	 * qual a maquina toma suas decisaes.
	 * return Maquina.esperanca
	 */
	
	public float getEsperanca() {
		return Maquina.esperanca;
	}
	
	/**
	 * Atraves desse metodo a maquina decide qual carta jogar. Baseando-se no
	 * valor da esperanca.
	 * @return opcao
	 */
	
	public int jogar() {
		int opcao = 0;
		esperanca = 0;
		for(int i = 0; i<mao.size(); i++) {
			if(mao.get(i).getValor()>10) {
				esperanca+=0.3;
			}
			if(mao.get(i).getValor()==14) {
				esperanca+=0.4;
			}
		}
		
		if(esperanca>0.5 & Jogo.mao_de_dez == false) {
			opcao = 3;
		}else {
			opcao = 0;
		}
		
		return opcao;
	}
	
	/**
	 * Atraves desse metodo a maquina joga suas cartas apos trucar
	 * @return opcao
	 */
	
	public int maquina_trucou() {
		int opcao = 0,i, maior = 0;
		for(i=0; i<mao.size(); i++) {
			if(mao.get(i).getValor()>mao.get(maior).getValor()) {
				maior = i;
			}
		}
		
		opcao = maior;
		return opcao;
	}
	
	/**
	 * Metodo usado para adicionar valores e variavel esperanca
	 */
	
	public void addEsperanca(double d) {
		esperanca+=d;
	}
	
	/**
	 * Baseando-se na esperanca a maquina reage quando e trucada,
	 * retornando 1 caso queira seis, 2 caso queira aceitar e 3 caso queira correr
	 * @return int
	 */
	
	public int reagir_truco() {
		if(esperanca>0.6) {
			return 1;
		}else if(esperanca>0.4) {
			return 2;
		}else {
			return 3;
		}
	}
	
	/**
	 * Nesse metodo a maquina reage ao truco, baseando-se na variavel esperanca
	 * @return int
	 */
	
	public int reagir_seis() {
		if(esperanca>0.6) {
			return 1;
		}else {
			return 2;
		}
	}

}
