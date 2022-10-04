package trucaoUFOP;

import java.util.ArrayList;


/**  A classe Baralho e a classe Pai de todos os possiveis baralhos a serem utilizados
 **/

public class Baralho {
	private ArrayList<Carta> baralho = new ArrayList<Carta>();
	
	
	/**
	 * O metodo tem a funcao de criar as 52 cartas do Baralho convencional
	 * atraves de dois ENUMs, e gerar valores a elas.
	 */
	private void cria_Baralho() {
		int i=1;
		String nome, naipe;
		for(BaralhoENUM criando : BaralhoENUM.values()) {
			nome = criando.toString();
			for(Naipes construindo : Naipes.values()) {
				naipe = construindo.toString();
				Carta cards = new Carta(i, naipe, nome);
				baralho.add(cards);
			}
			i++;
		}
	}
	
	/**
	 * Com esse metodo e possivel obter o baralho gerado.
	 * @return baralho
	 */
	public ArrayList<Carta> getBaralho(){
		cria_Baralho();
		return baralho;
	}
	
	
	
}
