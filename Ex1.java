/**
 * Celula (pilha, lista e fila dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Celula {
	public int elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.


	/**
	 * Construtor da classe.
	 */
	public Celula() {
		this(0);
	}

	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public Celula(int elemento) {
		this.elemento = elemento;
		this.prox = null;
	}
}//class

/**
 * Lista dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista extends Celula{
	Celula primeiro;
	Celula ultimo;


	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
	}




	/**
	 * Insere um elemento na ultima posicao da lista.
	 * @param x int elemento a ser inserido.
	 */
	public void inserirFim(int x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


	/**
	 * Remove um elemento da primeira posicao da lista.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public int removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

		Celula tmp = primeiro;
		primeiro = primeiro.prox;
		int resp = primeiro.elemento;
		tmp.prox = null;
		tmp = null;
		return resp;
	}


	/**
	 * Remove um elemento da ultima posicao da lista.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public int removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima celula:
		Celula i;
		for(i = primeiro; i.prox != ultimo; i = i.prox);

		int resp = ultimo.elemento; 
		ultimo = i; 
		i = ultimo.prox = null;

		return resp;
	}




	/**
	 * Remove um elemento de uma posicao especifica da lista
	 * considerando que o primeiro elemento valido esta na posicao 0.
	 * @param posicao Meio da remocao.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public int remover(int pos) throws Exception {
		int resp;
		int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

		} else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
		} else if (pos == 0){
			resp = removerInicio();
		} else if (pos == tamanho - 1){
			resp = removerFim();
		} else {
			// Caminhar ate a posicao anterior a insercao
			Celula i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);

			Celula tmp = i.prox;
			resp = tmp.elemento;
			i.prox = tmp.prox;
			tmp.prox = null;
			i = tmp = null;
		}

		return resp;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			if(i.elemento == x){
				resp = true;
				i = ultimo;
			}
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp int tamanho
	 */
	public int tamanho() {
		int tamanho = 0; 
		for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
		return tamanho;
	}
}

class HashI{

	Lista vetor[]; 
	int tamanho;
	final int NULO=-1;

	public HashI(int tamanho){
		this.tamanho=tamanho;
		vetor=new Lista[tamanho];
		for(int i=0; i<tamanho; i++){
			vetor[i]=new Lista();
		}//for


	}//hashi

	public int hash(int valor){
		int pos=valor%tamanho;
		return(pos);
	}//valor

	public void inserir(int valor){
		int neg=0;
		int pos=0;		
		if(valor<0){ 
		neg=valor*-1;
		pos=hash(neg);
		}//if
		else{ pos=hash(valor); }//else
		vetor[pos].inserirFim(valor);


	}//inserir

	public boolean pesquisar(int valor){
		boolean resp=false;

		int pos=hash(valor);
		MyIO.println(pos);
		for(Celula c=vetor[pos].primeiro.prox; c.prox!=null; c=c.prox){
			MyIO.println(c.elemento);
			resp=(c.elemento==valor);
			if(resp) c.prox=null;
		}//for

		return(resp);

	}//pesquisar

	public void mostrar(){
	int c=0;
	while(c<tamanho){ vetor[c].mostrar(); c++; }//while
	}

}//class


public class Ex1{

	public static void main (String []args){

		HashI h1= new HashI(10);
		int x=0;
		while(x!=-1){
			x=MyIO.readInt("Valor a ser inserido");
			if(x!=-1) h1.inserir(x);
			h1.mostrar();

		}//while
		int y=MyIO.readInt("valor a pesquisar: "); MyIO.println(h1.pesquisar(y));
	}//main

}//class


