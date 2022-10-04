package trucaoUFOP;

import java.util.ArrayList;

/**
 * Interface com algumas regras e necessidades do jogo.
 *
 */

public interface Regras {
	
	public void vitoria(int i);
	public ArrayList<Carta> embaralha(ArrayList<Carta> baralho);
}
