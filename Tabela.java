import java.util.*;

public class Tabela {
	Formula phi;
	Atomica[] atomica;

	Tabela (Formula form, Atomica[] at) {
		this.phi = form;
		this.atomica = at;

		inicializar();
	} 
	
	void inicializar() {
		for (int i = 0; i < atomica.length; i++) atomica[i].escolherBitPos(i); // a posicao da prop at no array corresponde a sua pos no num bin
	}

	void mostrarCabecalho() {
		for (int i = atomica.length-1; i >= 0; i--) System.out.print( atomica[i]+"\t"); // 0 corresponde ao LBS (menos sig); atomica.length-1 ao MBS (mais sig)
		System.out.println(phi);
	}
	// mostra os val verd das prop atomicas e da formula 
	void mostrarLinha() {
		for (int i = atomica.length-1; i >= 0; i--) System.out.print( atomica[i].obterValor()+"\t");
		System.out.println(phi.obterValor());
	}

	void incrementarValoresAt() {
		for (Atomica prop : atomica) prop.incrementar(); // incrementa o contador das prop at, uma por uma
	}

	void verificarValoresAt() {
		for (Atomica prop : atomica)
		{
			if (prop.obterContador() == prop.obterContMax()) // troca os valores das prop at cujo esteja com o contador no limite
			{
				prop.zerarCont();
				prop.trocarValor();
			}
		}
	}

	void gerarTabela() {
		int linha, qtdTotalLinhas;
			
		linha = 1;
		qtdTotalLinhas = 2 * atomica[ atomica.length-1 ].obterContMax(); // o total de linhas da tab verd corresponde a 2 elevado a pos do MSB;
		
		mostrarCabecalho();

		while (linha <= qtdTotalLinhas)
		{
			mostrarLinha();
			
			incrementarValoresAt();
			
			verificarValoresAt();
			
			linha++;
		}
	}
}