package trucaoUFOP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A classe Novo_Jogo e responsavel por criar toda a jogabilidade do truco
 *
 */

public class Novo_Jogo {
	private Jogo novo = new Jogo();
	private Jogador_Truco jogador1 = null;
	private Maquina maquina = new Maquina("Maquina");
	private Baralho_Truco baralho = new Baralho_Truco();
	ArrayList<Carta> cards = baralho.getBaralho();
	ArrayList<Carta> mao = new ArrayList<Carta>();
	ArrayList<Carta> mao_maquina = new ArrayList<Carta>();
	private Scanner input;
	private static int rodada_jogador = 0;
	private static int rodada_maquina = 0;
	private static int turno = 0;
	private int opcao = 0;
	private int opcao_maquina = 0;
	private int aceita;
	private int resposta;
	
	/**
	 * Para se criar um novo jogo e necessario informar o nome do jogador que ira
	 * jogar
	 * @param nome
	 */
	
	public Novo_Jogo(String nome) {
		jogador1 = new Jogador_Truco(nome);
		novo_jogo();
	}
	
	/**
	 * O metodo novo_jogo embaralha as cartas para a rodada inicial.
	 */
	
	private void novo_jogo() {
		cards = novo.embaralha(cards);
		System.out.println("OLA, SEJA BEM VINDO AO TRUCAO DA UFOP");
	}
	
	/**
	 * Esse metodo distribui as cartas para a mquina e para o jogador
	 */
	
	public void distribui_cartas() {
		mao = new ArrayList<Carta>();
		mao_maquina = new ArrayList<Carta>();
		for(int i = 0; i<3; i++) {
			mao.add(cards.get(i));
			cards.remove(mao.get(i));
		}
		jogador1.setMao(mao);
		
		for(int i = 0; i<3; i++) {
			mao_maquina.add(cards.get(i));
			cards.remove(mao_maquina.get(i));
		}
		maquina.setMao(mao_maquina);
		cards = baralho.getBaralho();
		
	}
	
	/**
	 * Esse metodo exibe na tela a mao atual do jogador
	 */
	
	public void ver_mao() {
		ArrayList<Carta> minha_mao = jogador1.getMao();
		for(int i = 0; i < minha_mao.size(); i++) {
			System.out.println("\n("+i+")"+minha_mao.get(i).getNome() + " de " + minha_mao.get(i).getNaipe());
		}
	}
	
	/**
	 * Esse metodo cria a rodada em si. Nele e criado a opcao de jogar a carta
	 * Trucar, correr, aceitar, e pedir seis. Aqui tambam e feito parte
	 * da atribuicao do placar.
	 */
	
	public void rodada() {
		if(novo.isTruco()==true) {
			novo.setTruco();
		}
		resposta = 0;
		float j=0;
		novo.setSeis(false);
		rodada_jogador = 0;
		rodada_maquina = 0;
		Jogo.mao_de_dez = false;
		System.out.println("Placar: Jogador "+Jogo.jogador1_placar+" x "+Jogo.getMaquina_placar()+" Maquina");
		System.out.println("Suas Cartas sao:");
		distribui_cartas();
		opcao = 0;
		for(int i = 0; i < 6; i++) {
			if(turno%2==0) {
				if(novo.isTruco()==false) {
					System.out.print("Digite o numero correspondente a carta que deseja jogar, ou Digite 3 para trucar:");
				}else {
					System.out.print("Digite o numero correspondente a carta que deseja jogar");
				}
				ver_mao();
				System.out.print("\nENTRADA: ");
				try {
					input = new Scanner(System.in);
					opcao = input.nextInt();
					if(opcao==3) {
						if(novo.isMaodedez() == true) {
							novo.vitoria(2);
							break;
						}
						resposta = maquina.reagir_truco();
					}
					else if(j>1) {
						while(opcao>mao.size()) {
							System.out.println("\nOpcao invalida, Digite uma opcao valida:");
							opcao = input.nextInt();
						}
					}
					if(novo.isTruco() == true & opcao > 2) {
						while(opcao>2) {
							System.out.println("\nopcao invalida, Digite uma opcao valida:");
							opcao = input.nextInt();
						}
					}
					if(resposta==1) {
						System.out.println("A maquina aceitou o truco");
						System.out.print("Digite o numero correspondente a carta que deseja jogar");
						ver_mao();
						novo.setTruco();
						System.out.print("\nENTRADA: ");
						opcao = input.nextInt();
						if(opcao>2) {
							throw new ArithmeticException("Erro");
						}
					}else if(resposta == 2) {
						System.out.println("A MAQUINA PEDIU 6!");
						System.out.println("Digite 1 para aceitar ou 2 para correr:");
						aceita = input.nextInt();
						if(aceita == 1) {
							opcao_maquina = maquina.maquina_trucou();
							novo.setSeis(true);
						}else {
							novo.vitoria(2);
							break;
						}
						
						if(opcao>2) {
							throw new ArithmeticException("Erro");
						}
					}else if(resposta==3) {
						System.out.println("A maquina nao aceitou o truco");
						novo.vitoria(1);
						break;
					}
					if(opcao>3) {
						throw new ArithmeticException("Erro");
					}
					
				}catch(Exception ex) {
					System.out.println("Voce Digitou uma opcao invalida! Digite uma opcao valida:");
					while(opcao>3) {
						opcao = input.nextInt();
					}
				}
				turno++;
				j+=0.5;
			}else {
				opcao_maquina = maquina.jogar();
				if(opcao_maquina == 3) {
					System.out.println("MAQUINA ESTA TRUCANDO, EAI?");
					System.out.println("Digite 1 para aceitar ou 2 para correr ou 3 para pedir 6:");
					aceita = input.nextInt();
					if(aceita == 1) {
						opcao_maquina = maquina.maquina_trucou();
					}else if(aceita == 3) {
						resposta = maquina.reagir_seis();
						if(resposta==1) {
							System.out.println("A maquina aceitou o truco");
							System.out.print("Digite o numero correspondente a carta que deseja jogar");
							ver_mao();
							novo.setSeis(true);
							System.out.print("\nENTRADA: ");
							opcao = input.nextInt();
							if(opcao>2) {
								throw new ArithmeticException("Erro");
							}
						}else if(resposta==3) {
							System.out.println("A maquina nao aceitou o truco");
							novo.vitoria(1);
							break;
						}
					}else{
						novo.vitoria(2);
						break;
					}
				}
				System.out.println("Maquina Jogou: "+ maquina.getMao().get(opcao_maquina).getNome() + " de " + maquina.getMao().get(opcao_maquina).getNaipe());
				turno++;
				j+=0.5;
				
			}
			if(j==1|j==2|j==3) {
				vencedor(opcao, opcao_maquina);
				if(maquina.getMao().size()>1)
					maquina.remove_carta(opcao_maquina);
				if(jogador1.getMao().size()>1)
					jogador1.remove_carta(opcao);
			}
			
			if(rodada_jogador==2) {
				novo.vitoria(1);
			}else if(rodada_maquina==2) {
				novo.vitoria(2);
			}
			
			if(rodada_jogador == 2 | rodada_maquina == 2) {
				break;
			}
			
		}
	}
	
	/**
	 * Esse metodo compara a carta jogada pela maquina e pelo jogador e decide
	 * qual a de maior valor, decidindo assim o vencedor.
	 * 
	 * @param i
	 * @param j
	 */
	
	public void vencedor(int i, int j) {
		ArrayList<Carta> minha_mao = jogador1.getMao();
		ArrayList<Carta> maquina_mao = maquina.getMao();
		
		if(minha_mao.get(i).getValor()>maquina_mao.get(j).getValor()) {
			Novo_Jogo.rodada_jogador++;
			maquina.addEsperanca(-0.2);
			System.out.println("Jogador ganhou a mao");
			//System.out.println(minha_mao.get(i).getValor()+">"+maquina_mao.get(j).getValor());
		}else if(minha_mao.get(i).getValor()<maquina_mao.get(j).getValor()){
			Novo_Jogo.rodada_maquina++;
			maquina.addEsperanca(0.2);
			System.out.println("Maquina ganhou a mao");
			//System.out.println(minha_mao.get(i).getValor()+"<"+maquina_mao.get(j).getValor());
		}else {
			if(Novo_Jogo.rodada_jogador == 1) {
				Novo_Jogo.rodada_jogador++;
				maquina.addEsperanca(-0.2);
				System.out.println("Jogador ganhou a mao");
			}else if(Novo_Jogo.rodada_maquina == 1) {
				Novo_Jogo.rodada_maquina++;
				maquina.addEsperanca(0.2);
				System.out.println("Maquina ganhou a mao");
			}
		}
		
	}
	
	/**
	 * Nesse metodo e feito a juncao de alguns metodos para criar uma nova Queda.
	 */
	
	public void Nova_Queda() {
		while(novo.jogador1_placar<12 & novo.getMaquina_placar()<12) {
			rodada();
		}
		if(novo.jogador1_placar>novo.getMaquina_placar()) {
			System.out.println("Parabens, voce Venceu");
			Jogo.jogador_queda++;
		}else {
			System.out.println("A maquina venceu, voce precisa treinar mais!");
			Jogo.maquina_queda++;
		}
		
	}
}
