public class Atomica extends Formula implements Binario {
	private String nome;
	private boolean valor;
	private int bitPos, cont;

	Atomica (String nome, boolean valor) {
		this.valor = valor;
		this.nome = nome;
	}

	boolean obterValor() {
		return this.valor;
	}

	public void escolherBitPos(int pos) {
		this.bitPos = pos;
	}

	public void incrementar() {
		this.cont++;
	}

	public int obterContador() {
		return this.cont;
	}

	public void zerarCont() {
		this.cont = 0;
	}
	
	public int obterContMax() {
		return (int)Math.pow(2, bitPos);
	}

	public void trocarValor() {
		valor = !valor;
	}

	public String toString() {
		return this.nome;
	}
}