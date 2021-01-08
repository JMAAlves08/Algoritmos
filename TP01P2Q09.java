/**
 *@author João Marcos Aguiar Alves
 *Matricula: 600092
 */
import java.io.*;

class Partida{


	//atributos
	private int copa;
	private int placar1;
	private int placar2;
	private int dia;
	private int mes;
	private String etapa;
	private String time1;
	private String time2;
	private String local;


	private int aux;//variavel para auxiliar na leitura dos arquivos

	/*   METODOS AUXILIARES  */

	/**
	 *Metodo para verificar se uma String esta contida dentro de outra
	 *@param String onde sera feita a busca
	 *@param String a ser procurada
	 *return true ou false
	 */
	public static boolean Contains(String a, String b){
		//MyIO.println("CONTAINS");
		int i=0, f=b.length();
		boolean resp=false;
		int c=0;
		//MyIO.println(a+" --- "+b);
		//MyIO.println(i+" -- "+f);
		while(f<a.length() && resp==false){//enquanto String 'a' puder ser subdividida
			String piece="";

			for(c=i; c<f; c++){//criar String com o "pedaco" de 'a'
				piece+=a.charAt(c);
			}//for
			//MyIO.println(i+"  "+f);
			//MyIO.println(piece+" --- "+b);
			resp=Equals(b, piece);
			i++;
			f++;
		}//while
		return(resp);
	}//contains()






	/**
	 *Metodo para verificar se duas String são iguais
	 *@author Joao Marcos Aguiar Alves
	 *@Param a - String
	 *@param b - String
	 *@return resposta
	 */
	public static boolean Equals(String a, String b){
		boolean resposta=true;
		if(a.length()!=b.length()){// se Strings de tamanhos diferentes, não são iguais
			resposta=false;}

		else{
			for(int contador=0; contador<a.length(); contador++){//percorrer uma String por completo
				if(a.charAt(contador)!=b.charAt(contador)){//se encontrado um caractere diferente, sair do metodo
					resposta=false;
					contador= a.length();}

			}//for

		}//else

		return(resposta);
	}//Equals()



	/*    METODOS SET */

	void set_copa(int copa){
		this.copa=copa;
	}//()

	void set_placar1(int placar){
		this.placar1=placar;
	}//()

	void set_placar2(int placar){
		this.placar2=placar;
	}//()

	void set_dia(int dia){
		this.dia=dia;
	}//()

	void set_mes(int mes){
		this.mes=mes;
	}//()

	void set_etapa(String etapa){
		this.etapa=etapa;
	}//()

	void set_time1(String time){
		this.time1=time;
	}//()

	void set_time2(String time){
		this.time2=time;
	}//()

	void set_local(String local){
		this.local=local;
	}//()
	void set_aux(int aux){
		this.aux=aux;
	}






	/*         METODOS GET          */

	/**
	 *Metodos para retornar um dos atributos do objeto Partida
	 */


	int get_copa(){
		return(this.copa);
	}//get_copa()

	int get_placar1(){
		return(this.placar1);
	}//getplacar

	int get_placar2(){
		return(this.placar2);
	}//getplacar2

	int get_dia(){
		return(this.dia);
	}//getdia

	int get_mes(){
		return(this.mes);
	}//getmes

	String get_etapa(){
		return(this.etapa);
	}//getetapa

	String get_time1(){
		return(this.time1);
	}//gettime1

	String get_time2(){
		return(this.time2);
	}//gettime2

	String get_local(){
		return(this.local);
	}//getlocal


	/*         METODOS gET          */

	/**
	 *Metodos para buscar o valor de um dos atributos do objeto Partida
	 *@param nome do arquivo a ser analisado
	 */


	/**
	 *Metodo para encontrar a quantidade de padroes "bgcolor"
	 *@param arquivo a ser aberto
	 *return quantidade encontrada
	 */
	int Quantidade(String file){
		//MyIO.println("METODO QUANTIDADE");
		String linha="";
		int q=0;
		Arq.openRead(file, "ISO8859-1");//abrir arquivo

		while(Arq.hasNext()){//enquanto houverem linhas a serem lidas

			linha=Arq.readLine();
			if(Contains(linha, "bgcolor")==true){//caso encontre o padrao, somar 1 a resposta
				q++;
			}//if
		}//while
		return(q);
	}//quantidade()

	/**
	 *Metodo para identificar as etapas e retornar a linha em que começam
	 *(A linha contendo as etapas esta abaixo da que contem "bgcolor")
	 *@param arquio html a ser aberto
	 *@param quantidade de vezes que padrao deve ser encontrado
	 *@return numero da linha
	 */
	int Grupo(String file, int achar){

		int resp=0;
		int c=0;
		String linha="";

		Arq.openRead(file, "ISO8859-1");//abrir arquivo


		while(c<=achar){//encontrar o padrao n vezes
			do{//ler linhas ate encontrar a linha que contem a tag "bgcolor"
				linha=Arq.readLine();

				resp++;

			}while(Contains(linha,"bgcolor")==false);


			c++;
		}//while

		return(resp+1);
	}//Grupo()



	/**
	 *Metodo que retorna a posicao de uma tag <tr> por vez
	 *Metodos get funcionarão baseados no retorno desse metodo
	 *@param arquivo a ser aberto
	 *@param quantidade de vezes que padrao deve ser encontrado
	 *@return posicao do ultimo padrao encontrado 
	 */
	int Tag(String file, int achar){

		int resp=0;
		int c=0;
		String linha="";

		Arq.openRead(file, "ISO8859-1");//abrir arquivo


		while(c<=achar){
			do{//ler linhas ate encontrar a linha que contem o atributo "etapa"
				linha=Arq.readLine();

				resp++;

			}while(!(Contains(linha,"<tr>")==true || Equals(linha, "<tr>")==true));

			c++;
		}//while

		return(resp);
	}//Grupo()





	/**
	 *Metodo para identificar a quantidade de tags "<tr>" em um arquivo .html
	 *@param arquivo a ser aberto
	 *@param posicao inicial da leitura
	 *return Quantidade
	 */
	int Quantidade2(String file, int pos){

		int resp=0;
		int p=0;
		String linha="";
		Arq.openRead(file, "ISO8859-1"); 

		for(int c=0; c<pos; c++){//ler linhas do arquivo ate chegar na posicao inicial
			linha=Arq.readLine();
		}//for

		while(!(Contains(linha, "<tr bgcolor=")==true)){//repetição garantirá que ele so encontre as tags que estao dentro de uma etapa por vez
			linha=Arq.readLine();


			if(Contains(linha, "<tr>") || Equals(linha, "<tr>")){

				resp++;
			}
		}//while

		return(resp);
	}//Final()






	/**
	 *Metodo para encontrar o atributo "copa" em um arquivo .html
	 *pega o nome do arquivo
	 */

	int get_copa(String file){

		String resp="";
		for(int c=0; c<file.length()-5; c++){
			resp+=file.charAt(c);
		}//for
		//this.copa=Integer.parseInt(resp);
		return(Integer.parseInt(resp));
	}//set_copa


	/**
	 *Metodo para encontrar o atributo "placar" em um arquivo .html
	 *Primeiro e encontrada a linha que contem "GRUPO", "SEMIFINAL", "FINAL"
	 *Depois é encontrada a tag "<tr>"
	 *È feita a leitura de mais 3 linhas ate chegar a linha que contem o placar
	 *@param String contendo o nome do arquivo
	 *@param linha inicial a ser procurada
	 *return atributo
	 */
	int get_placar1(String file, int p){

		String linha="";
		int c=0;
		int pos=0;

		Arq.openRead(file,"ISO8859-1");/*abrir arquivo para leitura*/


		for(c=0; c<p; c++){//ler arquivo ate alcancar numero da linha passado como parametro
			linha=Arq.readLine();
		}//for

		c=0;//zerar contador
		while(c<3){//ler 3 linhas do arquivo 
			linha=Arq.readLine();
			if(Equals(linha, "     ")==true){//se alguma linha for vazia, ler mais uma vez
				c--;
			}//if
			c++;
		}//while

		c=0;//zerando contador

		while(!(linha.charAt(c)=='>' && (linha.charAt(c+1)>='0' && linha.charAt(c+1)<='9'))){//percorrer cada caractere da linha ate encontrar o padrao ">"+numero	
			c++;
		}//while
		c+=1;

		String numero="";
		numero=numero+linha.charAt(c);
		if(linha.charAt(c+1)>='0' && linha.charAt(c+1)<='9'){//concatenar o placar em uma String
			numero=numero+linha.charAt(c+1);
		}//if


		return(Integer.parseInt(numero));//retornar String convertida em inteiro
	}//get_placar1()



	/**
	 *Metodo para encontrar o atributo "placar" em um arquivo .html
	 *Primeiro e encontrada a linha que contem "GRUPO", "SEMIFINAL", "FINAL"
	 *Depois é encontrada a tag "<tr>"
	 *È feita a leitura de mais 3 linhas ate chegar a linha que contem o placar
	 *@param String contendo o nome do arquivo
	 *return atributo
	 */
	int get_placar2(String file, int p){

		String linha="";
		int c=0;
		int pos=0;
		//MyIO.println("Arquivo: "+file);
		Arq.openRead(file,"ISO8859-1");/*abrir arquivo para leitura*/

		for(c=0; c<p; c++){
			linha=Arq.readLine();
		}//for

		c=0;//zerar contador

		while(c<3){//ler 3 linhas do arquivo
			linha=Arq.readLine();
			if(Equals(linha, "     ")==true){//se linha for vazia, realizar mais uma leitura
				c--;
			}//if
			c++;
		}//while

		c=linha.length()-1;//mover contador para o final da linha

		while(!(linha.charAt(c)=='<' && (linha.charAt(c-1)>='0' && linha.charAt(c-1)<='9') )){//percorrer cada caractere da linha inversamente ate encontrar o padrao "numero" "<"

			c--;
		}//while	
		c--;
		String numero="";

		numero=numero+linha.charAt(c);
		c--;
		if(linha.charAt(c)>='0' && linha.charAt(c)<='9'){//concatenar os valores do placar em uma String
			numero=numero+linha.charAt(c);
		}

		return(Integer.parseInt(numero));//retornar String convertida para inteiro
	}//get_placar2()


	/**
	 *Metodo para encontrar o atributo "dia" em um arquivo .html
	 *@param Arquivo a ser aberto
	 *@param posicao da linha inicial de pesquisa
	 *@return dia
	 */
	int get_dia(String file, int p){
		//dados
		String linha="";
		int c=0;
		int pos=0;
		//


		Arq.openRead(file,"ISO8859-1");/*abrir arquivo para leitura*/

		for(c=0; c<p; c++){//ler linhas do arquivo ate chegar ao numero passado como parametro
			linha=Arq.readLine();
		}//for

		linha=Arq.readLine();

		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente

		c=0;//zerar contador
		while(!((linha.charAt(c)== '"' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<') || (linha.charAt(c)=='d' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<'))){//percorrer linha ate encontrar o padrao " "> " ou " d> "
			c++;
		}//while

		String dia="";
		dia=dia+linha.charAt(c+2)+linha.charAt(c+3);

		return(Integer.parseInt(dia));

	}//get_dia()


	/**
	 *Metodo para encontrar o atributo "mes" em um arquivo .html
	 *@param Arquivo a ser aberto
	 *@param posicao da linha inicial de pesquisa
	 *@return mes
	 */

	int get_mes(String file, int p){

		//dados
		String linha="";
		int c=0;
		int pos=0;
		//

		//MyIO.println("Arquivo: "+file);
		Arq.openRead(file,"ISO8859-1");/*abrir arquivo para leitura*/

		for(c=0; c<p; c++){//ler arquivo ate chegar a linha passada como parametro
			linha=Arq.readLine();
		}//for

		linha=Arq.readLine();

		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente

		c=0;//zerar contador

		while(!((linha.charAt(c)== '"' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<') || (linha.charAt(c)=='d' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<'))){//procurar na linha o padrao "> ou d>
			c++;
		}//while

		String mes="";

		if(!(linha.charAt(c+5)=='0')){//se mes menor que 10, pegar apenas o segundo caractere
			mes=mes+linha.charAt(c+5)+linha.charAt(c+6);
		}//if
		else{
			mes=mes+linha.charAt(c+6);
		}//else

		return(Integer.parseInt(mes));


	}//get_mes()


	/**
	 *Metodo para encontrar o atributo "etapa" em um arquivo .html
	 *@param arquivo a ser aberto
	 *@param posicao inicial de pesquisa
	 *return etapa
	 */
	String get_etapa(String file, int p){

		String linha="";
		String etapa="";
		int c=0;
		int pos=0;
		//

		//MyIO.println("Arquivo: "+file);
		Arq.openRead(file,"ISO8859-1");/*abrir arquivo para leitura*/

		for(c=0; c<p; c++){//ler ate chegar na linha parametro
			linha=Arq.readLine();
		}//for

		c=0;//zerar contador

		while(!((linha.charAt(c)=='<' && linha.charAt(c+1)=='b' && linha.charAt(c+2)=='>') && linha.charAt(c+3)!='<')){//procurar padrao <b>
			c++;
		}//while
		c+=3;

		while(!(linha.charAt(c)=='<')){//concatenar todos os caracteres ate encontrar <
			etapa = etapa+linha.charAt(c);
			c++;
		}//while

		return(etapa);
	}//get_etapa()



	/**
	 *Metodo para encontrar o atributo "time" de um arquivo .html
	 *@param arquivo a ser aberto
	 *@param posicao inicial de pesquisa
	 *@return time
	 */
	String get_time1(String file, int p){

		String linha="";
		String time="";
		int c=0;
		int pos=0;

		Arq.openRead(file,"ISO8859-1");/*abrir arquivo para leitura*/

		for(c=0; c<p; c++){//ler ate encontrar linha inicial
			linha=Arq.readLine();
		}//for



		//ler duas linhas do arquivo, se linha for vazia, ler novamente
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if

		c=0;
		while(!(linha.charAt(c)=='>' && linha.charAt(c+1)!='<')){//encontrar > na linha
			c++;
		}//while
		c++;
		while(!(linha.charAt(c)=='<')){// concatenar todos os caracteres ate encontrar <
			time = time+linha.charAt(c);
			c++;
		}//while
		return(time);
	}//get_time()





	/**
	 *Metodo para encontrar o atributo "time" de um arquivo .html
	 *@param arquivo a ser aberto
	 *@param posicao inicial de pesquisa
	 *@return time
	 */
	String get_time2(String file, int p){

		String linha="";
		String time="";
		int c=0;
		int pos=0;
		//MyIO.println("Arquivo: "+file);
		Arq.openRead(file,"ISO8859-1");/*abrir arquivo para leitura*/

		for(c=0; c<p; c++){//ler ate linha inicial
			linha=Arq.readLine();
		}//for



		//ler 4 linhas do arquivo. Se linha vazia, ler novamente
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if

		c=0;//zerar contador
		while(!(linha.charAt(c)=='>')){//encontrar > na linha
			c++;
		}//while
		c++;
		while(!(linha.charAt(c)=='<')){//concatenar os caracteres ate encontrar <
			time = time+linha.charAt(c);
			c++;
		}//while
		return(time);
	}//get_time()


	/**
	 *Metodo para encontrar o atributo "local" em um arquivo .html
	 *@param arquivo a ser aberto
	 *@param posicao inicial de pesquisa
	 *@return local
	 */
	String get_local(String file, int p){

		String linha="";
		String local="";
		int c=0;
		int pos=0;

		Arq.openRead(file,"ISO8859-1");/*abrir arquivo para leitura*/

		for(c=0; c<p; c++){//ler ate posicao inicial
			linha=Arq.readLine();
		}//for



		//ler 5 linhas do arquivo. Se linha vazia, ler novamente
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if
		linha=Arq.readLine();
		if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if
		linha=Arq.readLine();

		c=0;//zerar contador
		while(!(linha.charAt(c)=='>')){//encontrar > na linha
			c++;
		}//while
		c++;
		while(!(linha.charAt(c)=='<')){//concatenar caracteres ate encontrar <
			local = local+linha.charAt(c);
			c++;
		}//while
		return(local);
	}//get_local()



	/**
	 *Metodo para printar uma Partida
	 */
	void Print(){

		MyIO.println("[COPA "+copa+"] - "+etapa+" - "+dia+'/'+mes+" - "+time1+" ("+placar1+") x ("+placar2+") "+time2+"  - "+local);
	}//Print()



	/**
	 *Metodo para clonar uma Partida
	 *@param Partida a ser clonada
	 */
	void Clone(Partida p){

		this.copa=p.get_copa();
		this.placar1=p.get_placar1();
		this.placar2=p.get_placar2();
		this.dia=p.get_dia();
		this.mes=p.get_mes();
		this.etapa=p.get_etapa();
		this.time1=p.get_time1();
		this.time2=p.get_time2();
		this.local=p.get_local();

	}//Clone()




	/*    CONSTRUTORES      */


	/**
	 *Construtor da class Partida
	 *Nao possui parametros
	 *Cria um objeto com todos os valores vazios
	 */
	public Partida(){

		this.copa=0;
		this.placar1=0;
		this.placar2=0;
		this.dia=0;
		this.mes=0;
		this.etapa="";
		this.time1="";
		this.time2="";
		this.local="";

		aux=0;

	}//partida()

	/**
	 *Construtor da class Partida
	 *recebe todos os parametros necessarios
	 */
	public Partida(int copa, int placar1, int placar2, int dia, int mes, String etapa, String time1, String time2, String local){

		this.copa=copa;
		this.placar1=placar1;
		this.placar2=placar2;
		this.dia=dia;
		this.mes=mes;
		this.etapa=etapa;
		this.time1=time1;
		this.time2=time2;
		this.local=local;

		aux=0;

	}//partida



	/**
	 *Metodo para pegar todos os atributos de uma partida de uma so vez
	 *@param arquivo a ser aberto 
	 *@param Numero da partida a ser pega
	 */
	void get_partida(String file, int vez){

		String linha="";
		String tmp="";
		int c=0; 
		int l=0;
		int n=0;
		int end=0;
		boolean Final=false;
		boolean empty=false;

		Arq.openRead("/tmp/copa/"+file+".html", "ISO8859-1");//abrir arquivo

		set_copa(Integer.parseInt(file));//pegar ano da copa do nome do arquivo
		if(aux==0){

			while(Contains(linha, "bgcolor")==false){//achar bg color
				aux++;
				linha=Arq.readLine();
			}//while
		}
		else{
			for(c=0; c<aux; c++){ linha=Arq.readLine(); }
		}
		while(n<vez){//enquanto nao chegar a partida numero 'vez'


			//=================== ETAPA ============================================
			tmp=""; c=0; l=0;

			linha=Arq.readLine();//ler mais uma linha

			while(!(linha.charAt(c)=='b' && linha.charAt(c+1)=='>'&& linha.charAt(c+2)!='<')){ c++; }//encontrar inicio da etapa         
			c+=2;

			while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//pegar o atributo
			c=0;//zerar contador

			set_etapa(tmp);

			Final=Equals(tmp, "FINAL") || Equals(tmp, "FASE FINAL");//se etapa final, executar mais uma vez e sair da repeticao	

			tmp="";//apagar String

			while(l==0){


				// ================= DIA/MES ============================================

				while(!(Contains(linha, "<tr>")==true || Equals(linha, "<tr>")==true)){ linha=Arq.readLine(); }//encontrar <tr>

				linha=Arq.readLine();//linha do atributo
				if(Contains(linha, "colspan")==false){//tags depois do barramento sao seguidas de uma linha com "colspan" se for o caso, nao tentar pegar a Partida
					if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente


					while(!((linha.charAt(c)== '"' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<') || (linha.charAt(c)=='d' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<'))){//percorrer linha ate encontrar o padrao " "> " ou " d> "
						c++;//encontrar ">
					}//while
					c+=2;
					tmp+=linha.charAt(c); c++;
					tmp+=linha.charAt(c);//pegar dia

					set_dia(Integer.parseInt(tmp));

					//pegar mes
					tmp="";
					c+=2;
					if(linha.charAt(c)!='0'){ tmp+=linha.charAt(c); }//if
					c++;
					tmp+=linha.charAt(c);

					set_mes(Integer.parseInt(tmp));
					tmp="";
					c=0;

					// ================== TIME1 ===============================
					linha=Arq.readLine();

					if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente

					while(!(linha.charAt(c)=='>' && linha.charAt(c+1)!='<')){ c++; }//while
					c++;
					while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while

					set_time1(tmp);

					c=0;
					tmp="";

					// ===============PLACAR1 ===================================
					linha=Arq.readLine();
					if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente

					while(!(linha.charAt(c)=='>' && (linha.charAt(c+1)>='0' && linha.charAt(c+1)<='9'))){//percorrer cada caractere da linha ate encontrar o padrao 			">"+numero	
						c++;
					}//while
					c++;
					tmp+=linha.charAt(c);
					c++;
					if(linha.charAt(c)>='0' && linha.charAt(c)<='9'){//concatenar o placar em uma String
						tmp+=linha.charAt(c);
					}//if
					c+=2;

					set_placar1(Integer.parseInt(tmp));

					tmp="";

					// ============ PLACAR2 =======================================
					if(linha.charAt(c)=='x'){ c++; }//se contador estiver uma posicao antes, somar mais 1
					if(linha.charAt(c)>='0' && linha.charAt(c)<='9'){ tmp+=linha.charAt(c);}//se numero de dois digitos
					c++;

					tmp+=linha.charAt(c);

					set_placar2(Integer.parseInt(tmp));
					c=0;
					tmp="";

					// ======================= TIME 2 =================================
					linha=Arq.readLine();

					while(!((linha.charAt(c)=='>') && (linha.charAt(c+1)!='<'))){ c++; }//while
					c++;
					while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while

					set_time2(tmp);
					c=0;
					tmp="";

					//================== LOCAL =====================================
					linha=Arq.readLine();


					while(!(linha.charAt(c)=='>')){ c++; }//while
					c++;
					while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while

					set_local(tmp);
					c=0;
					tmp="";
					//================================================================
					n++;

					if(Final==false){//caso nao seja fase final, procurar tag que indica proxima partida(</tr>)
						while(linha.contains("</tr>")==false){
							linha=Arq.readLine();
						}//while
					}//if

					else{ //caso ultima etapa seja "FASE FINAL", contem mais de uma partida
						if(Equals(get_etapa(), "FASE FINAL")==false){ 
							l++;
							end++;
						}//if 
					}//else

					linha=Arq.readLine();//ler mais uma linha

					tmp=linha;
					if(Contains(linha, "bgcolor")==true){//se linha for barramento
						if(Contains(linha, "#000000")==true){ end++;}
						else{

							l++;
							// n++;
						}//else
					}//if

					else if(linha.isEmpty()	){ //se linha for vazia indica que etapa acabou

						l++;

						linha=Arq.readLine();
					}//if

					else if(!(n<vez)){ l++; }//if quantidade ja foi alcançada, sair da repeticao

					else if(Contains(linha, "<")==false){ l++; linha=Arq.readLine();}//else if

					else{

						linha=tmp;
						tmp="";
					}//else	

				}//if
				else{  l++;  end++; Final=true; }//else

			}//while 

		}//while

	}//get_partida()


	/**
	 *Metodo para pegar todos os atributos de uma partida de uma so vez
	 *Metodo igual ao anterior, porem pega todas as partidas de uma so vez
	 *@param arquivo a ser aberto 
	 */
	void get_partida(String file){

		String linha="";
		String tmp="";
		int c=0; 
		int l=0;
		int end=0;
		boolean Final=false;
		boolean empty=false;

		Arq.openRead("/tmp/copa/"+file+".html", "ISO8859-1");//abrir arquivo

		set_copa(Integer.parseInt(file));//pegar ano da copa do nome do arquivo

		while(Contains(linha, "bgcolor")==false){//achar bg color
			linha=Arq.readLine();
		}//while

		while(Final==false){//enquanto nao chegar ao fim das partidas
			while(end==0){

				//=================== ETAPA ============================================
				tmp=""; c=0; l=0;

				linha=Arq.readLine();//ler mais uma linha

				while(!(linha.charAt(c)=='b' && linha.charAt(c+1)=='>'&& linha.charAt(c+2)!='<')){ c++; }//encontrar inicio da etapa

				c+=2;

				while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//pegar o atributo
				c=0;//zerar contador

				set_etapa(tmp);

				Final=Equals(tmp, "FINAL") || Equals(tmp, "FASE FINAL");//se final, sair da repeticao	

				tmp="";//apagar String
				while(l==0){


					// ================= DIA/MES ============================================
					while(!(Contains(linha, "<tr>")==true || Equals(linha, "<tr>")==true)){ linha=Arq.readLine(); }//encontrar <tr>

					linha=Arq.readLine();//linha do atributo
					if(Contains(linha, "colspan")==false){
						if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente


						while(!((linha.charAt(c)== '"' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<') || (linha.charAt(c)=='d' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<'))){//percorrer linha ate encontrar o padrao " "> " ou " d> "
							c++;//encontrar ">
						}//while
						c+=2;
						tmp+=linha.charAt(c); c++;
						tmp+=linha.charAt(c);//pegar dia

						set_dia(Integer.parseInt(tmp));

						//pegar mes
						tmp="";
						c+=2;
						if(linha.charAt(c)!='0'){ tmp+=linha.charAt(c); }//if
						c++;
						tmp+=linha.charAt(c);

						set_mes(Integer.parseInt(tmp));
						tmp="";
						c=0;

						// ================== TIME1 ===============================
						linha=Arq.readLine();

						if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente

						while(!(linha.charAt(c)=='>' && linha.charAt(c+1)!='<')){ c++; }//while
						c++;
						while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while

						set_time1(tmp);

						c=0;
						tmp="";

						// ===============PLACAR1 ===================================
						linha=Arq.readLine();
						if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente

						while(!(linha.charAt(c)=='>' && (linha.charAt(c+1)>='0' && linha.charAt(c+1)<='9'))){//percorrer cada caractere da linha ate encontrar o padrao 			">"+numero	
							c++;
						}//while
						c++;
						tmp+=linha.charAt(c);
						c++;
						if(linha.charAt(c)>='0' && linha.charAt(c)<='9'){//concatenar o placar em uma String
							tmp+=linha.charAt(c);
						}//if
						c+=2;

						set_placar1(Integer.parseInt(tmp));

						tmp="";

						// ============ PLACAR2 =======================================
						if(linha.charAt(c)=='x'){ c++; }//if
						if(linha.charAt(c)>='0' && linha.charAt(c)<='9'){ tmp+=linha.charAt(c);}//if
						c++;

						tmp+=linha.charAt(c);

						set_placar2(Integer.parseInt(tmp));
						c=0;
						tmp="";

						// ======================= TIME 2 =================================
						linha=Arq.readLine();

						while(!(linha.charAt(c)=='>')){ c++; }//while
						c++;
						while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while

						set_time2(tmp);
						c=0;
						tmp="";

						//================== LOCAL =====================================
						linha=Arq.readLine();


						while(!(linha.charAt(c)=='>')){ c++; }//while
						c++;
						while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while

						set_local(tmp);
						c=0;
						tmp="";
						//================================================================

						Print();


						if(Final==false){
							while(/*Equals(linha, "  </tr>")*/linha.contains("</tr>")==false){

								linha=Arq.readLine();
							}//while
						}//if
						else{ 
							if(Equals(get_etapa(), "FASE FINAL")==false){ 
								l++; end++;
							} 
							else{  }}//else

						linha=Arq.readLine();

						tmp=linha;
						if(Contains(linha, "bgcolor")==true){
							if(Contains(linha, "#000000")==true){ end++;}
							else{

								l++;
							}//else
						}//if
						else if(linha.isEmpty()	){ 

							l++;
							linha=Arq.readLine();
						}//if
						else if(Contains(linha, "<")==false){ l++; linha=Arq.readLine();}//else if
						else{

							linha=tmp;
							tmp="";
						}//else	

					}//if
					else{  l++; end++; Final=true; }//else
				}//while

			}//while

		}//while

	}//get_partida()





}//class



class Time extends Partida{

	//atributos
	private String pais;
	private int pontos;
	private int jogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int golsP;
	private int golsC;
	private int saldo;


	//construtores
	public Time(){
		pais    = "";
		pontos  = -1;
		jogos   = -1;
		vitorias= -1;
		empates = -1;
		derrotas= -1;
		golsP   = -1;
		golsC   = -1;
		saldo   = -1;
	}
	public Time(String pais, int pontos, int jogos, int vitorias, int empates, int derrotas, int golsP, int golsC, int saldo){
		this.pais=pais;//metodo interno
		this.pontos=pontos;
		this.jogos=jogos;
		this.vitorias=vitorias;
		this.empates=empates;
		this.derrotas=derrotas;
		this.golsP=golsP;
		this.golsC=golsC;
		this.saldo=saldo;

	}


	//metodos set
	void set_pais(String pais){
		this.pais=pais;
	}

	void set_pontos(int pontos){
		this.pontos=pontos;
	}

	void set_jogos(int jogos){
		this.jogos=jogos;
	}

	void set_vitorias(int vitorias){
		this.vitorias=vitorias;
	}

	void set_empates(int empates){
		this.empates=empates;
	}

	void set_derrotas(int derrotas){
		this.derrotas=derrotas;
	}

	void set_golsP(int gols){
		golsP=gols;
	}

	void set_golsC(int gols){
		golsC=gols;
	}

	void set_saldo(int saldo){
		this.saldo=saldo;
	}



	//metodos get


	String get_pais(){
		return(pais);
	}

	int get_pontos(){
		return(pontos);
	}

	int get_jogos(){
		return(jogos);
	}
	int get_vitorias(){
		return(vitorias);
	}
	int get_empates(){
		return(empates);
	}
	int get_derrotas(){
		return(derrotas);
	}
	int get_golsP(){
		return(golsP);
	}
	int get_golsC(){
		return(golsC);
	}
	int get_saldo(){
		return(saldo);
	}

	/**
	 *metodo para encontrar o atributo pais
	 *@param Partida de onde sera retirada o valor
	 *@param participante da partida desejado(1 ou 2)
	 *@return pais
	 */
	String find_pais(Partida p, int m){

		String resp="";
		if(m==1){ resp=p.get_time1(); }
		else{ resp=p.get_time2(); }
		return(resp);


	}//pais

	/**
	 *Metodo para pegar a quantidade de pontos de um time em uma partida
	 *@param partida a ser analisada
	 *@param time escolhido (1 ou 2)
	 */
	int find_pontos(Partida p, int m){
		int resp=0;
		if(m==1){
			if(p.get_placar1()==p.get_placar2()){//se empate
				resp=1;
			}
			else if(p.get_placar1()>p.get_placar2()){
				resp=3;
			}

		}//if

		else{
			if(p.get_placar1()==p.get_placar2()){//se empate
				resp=1;
			}
			else if(p.get_placar2()>p.get_placar1()){
				resp=3;
			}

		}//if

		return(resp);
	}//pontos

	int find_vitorias(Partida p, int t){

		int resp=0;

		if(t==1){
			if(p.get_placar1()>p.get_placar2()){ resp=1; }//if
		}
		else{
			if(p.get_placar2()>p.get_placar1()){ resp=1; }//if
		}
		return(resp);
	}//vitoria


	int find_derrotas(Partida p, int t){

		int resp=0;

		if(t==1){
			if(p.get_placar1()<p.get_placar2()){ resp=1; }//if
		}
		else{
			if(p.get_placar2()<p.get_placar1()){ resp=1; }//if
		}
		return(resp);
	}//derrotas


	int find_empates(Partida p){

		int resp=0;

		if(p.get_placar1()==p.get_placar2()){ resp=1; }//if


		return(resp);
	}//empates

	int find_golsP(Partida p, int t){
		int resp=0;

		if(t==1){ resp=p.get_placar1(); }//if
		else{ resp=p.get_placar2(); }//else
		return(resp);
	}

	int find_golsC(Partida p, int t){
		int resp=0;
		if(t==1){ resp=p.get_placar2(); }
		else { resp=p.get_placar1(); }
		return(resp);
	}



	/**
	 *Metodo para pegar todos os dados do objeto time
	 *@param Partida a ser analisada
	 *@param time a ser buscado
	 */
	void find_time(Partida p, int t){

		if(t==1){ 
			if(Equals(p.get_time1(), "Alemanha Ocidental")){
				pais="Alemanha";
			}
			else if(Equals(p.get_time1(), "União Soviética")){
				pais="Rússia";
			}//else if
			else if(Equals(p.get_time1(), "Tchecoslováquia")){
				pais="República Tcheca";
			}//else if
			else if(Equals(p.get_time1(), "Iugoslávia")){
				pais="Sérvia";
			}//else if
			else if(p.get_time1().equals("Sérvia e Montenegro")){
				pais="Sérvia";
			}
			else{
				pais=p.get_time1(); 
			}//else
		}//if
		else{ 
			if(Equals(p.get_time2(), "Alemanha Ocidental")){
				pais="Alemanha";
			}
			else if(Equals(p.get_time2(), "União Soviética")){
				pais="Rússia";
			}//else if
			else if(Equals(p.get_time2(), "Tchecoslováquia")){
				pais="República Tcheca";
			}//else if
			else if(Equals(p.get_time2(), "Iugoslávia")){
				pais="Sérvia";
			}//else if
			else if(p.get_time2().equals("Sérvia e Montenegro")){
				pais="Sérvia";
			}
			else{
				pais=p.get_time2(); 
			}//else
			//if(pais==""){ MyIO.println(p.get_time1()+" "+p.get_time2()); }
		}
		pontos=find_pontos(p,t);
		jogos=1;
		vitorias=find_vitorias(p, t);
		empates=find_empates(p);
		derrotas=find_derrotas(p, t);
		golsP=find_golsP(p, t);
		golsC=find_golsC(p, t);
		saldo=golsP-golsC;
	}//time

	/**
	 *Metodo para clonar um Time
	 *@param Time a ser clonada
	 */
	void Clone(Time p){

		this.pais=p.get_pais();
		this.pontos=p.get_pontos();
		this.jogos=p.get_jogos();
		this.vitorias=p.get_vitorias();
		this.empates=p.get_empates();
		this.derrotas=p.get_derrotas();
		this.golsP=p.get_golsP();
		this.golsC=p.get_golsC();
		this.saldo=p.get_saldo();

	}//Clone()

	/**
	 *Metodo para printar o objeto time
	 */
	void Print(){

		MyIO.println(pais+" "+"pg("+pontos+") j("+jogos+") v("+vitorias+") e("+empates+") d("+derrotas+") gp("+golsP+") gc("+golsC+") sg("+saldo+")");

	}//print


}//class

class Ranking extends Time{
	//atributos
	private int n;//tamanho da lista
	private Time[] vetor;
	private int comp;
	//construtores
	public Ranking(){
		vetor= new Time[0];
		n=0;
	}

	public Ranking(int tamanho){
		vetor= new Time[tamanho];
		n=0;
		comp=0;
		for(int c=0; c< tamanho; c++){ vetor[c] = new Time(); }
	}

	//metodos

	//=============METODOS DE INSERCAO==========================================================
	/**
	 *Metodo para inserir um valor no inicio da lista
	 *@param Partida a ser inserida
	 */
	void inserirInicio(Time t1){

		Time t2= new Time();
		t2.Clone(t1);
		if(n==vetor.length-1){ //se verdadeiro, nao ha como movimentar elementos
			MyIO.println("ERRO INSERIRINICIO");
		}


		else if(n==0){    //se vetor vazio, inserir na primeira posicao
			vetor[0]=t2;
			n++;
		}


		else{

			//mover elementos para frente
			for(int c=n; c>0; c--){


				vetor[c]=vetor[c-1];

			}

			vetor[0]=t2;//inserir
			n++;
		}
	}//inseririnicio()

	/**
	 *Metodo para inserir uma Partida no fim do arranjo
	 *@param Partida a ser inserida
	 */
	void inserirFim(Time t1){


		Time t2= new Time();
		t2.Clone(t1);
		//t2.Print();
		if(n==vetor.length-1){
			System.out.println("ERRO INSERIRFIM");
		}

		else{

			//if(vetor[n]!=null) vetor[n].Print();

			vetor[n]=t2;

			n++;

		}
	}//inserirFim()


	/**
	 *Metodo para inserir uma Partida em uma determinada posicao
	 *@param Partida a ser inserida
	 *@param posicao - local do vetor para insercao
	 */

	void inserir(Time t1, int posicao){

		Time t2=new Time();
		Time t3=new Time();

		t2.Clone(t1);

		if(n==vetor.length-1 || posicao < 0 || posicao>n || posicao>vetor.length){
			System.out.println("ERRO INSERIR NA POSICAO "+posicao+" COM N= "+n); // se vetor cheio ou posicao invalida
		}

		else{

			//movimentar elementos para liberar posicao
			n++;
			for(int c=n; c>posicao; c--){
				t3=vetor[c-1];

				vetor[c]=t3;
			}

			vetor[posicao]=t2;

		}
	}//inserir()
	//======================================================================================================



	//=============METODOS DE REMOCAO==========================================================================

	/**
	 *metodo que remove o primeiro elemento do arranjo
	 *return Partida removida
	 */

	Time removerInicio(){

		//dados
		Time t1 = new Time();
		if(n==0){ MyIO.println ("ERRO REMOVER INICIO"); }//if

		else{
			t1.Clone(vetor[0]);
			for(int c=0; c<n-1; c++){

				vetor[c]=vetor[c+1];//realocando elementos

			}//for

			n--;
		}//else
		return(t1);

	}//removerInicio()

	/**
	 *metodo para remover o ultimo elemento do vetor
	 *return Partida removida
	 */

	Time removerFim(){

		Time t1= new Time();

		t1=vetor[n-1];//pegando valor da ultima posicao

		vetor[n-1]=null; //apagando o valor da posicao
		n--;

		return(t1);
	}//removerFim()

	/**
	 *metodo para remover um valor em qualquer posicao do arranjo
	 *@param posicao a ser removida
	 *return Partida removida
	 */
	Time remover(int posicao){

		Time t1= new Time();

		if(posicao<0 || posicao>n-1 ){
			MyIO.println("Posicao "+posicao+" invalida");
		}

		else{

			if(posicao==0){ //caso primeira posicao, chamar o metodo removerInicio()

				t1=removerInicio();

			}

			else if(posicao == n-1){

				t1=removerFim(); // caso ultima posicao, chamar o metodo removerFim()

			}

			else{

				t1=vetor[posicao];

				for(int c=posicao; c<n-1; c++){

					vetor[c]=vetor[c+1];
				}

			}
			n--;
		}

		return(t1);

	}//remover()

	//==============================================================================================================

	/**
	 *metodo para imprimir o vetor
	 */

	void imprimirL(){

		int contador=0;

		while(contador<n){

			vetor[contador].Print();
			contador++;
		}

	}//imprimirL()

	/**
	 *Metodo que verifica se um time ja esta no ranking
	 *@param pais a ser buscado
	 *@return se esta contido ou nao
	 */
	boolean registrado(String pais){

		boolean resp=false;
		int p=0;
		while(p<n){
			resp=Equals(vetor[p].get_pais(), pais);
			//System.out.println(vetor[p].get_pais()+" === "+pais+" : "+resp);
			p++;
			if(resp==true){p=n;}
		}//while
		return(resp);
	}//registrado

	/**
	 *Metodo para atualizar os atributos de um membro do ranking
	 *@param pais a ser alterado
	 *@param time com novos atributos
	 */
	void atualizar(String pais, Time t1){

		//econtrar posicao do vetor
		int p=0;
		while(Equals(vetor[p].get_pais(), pais)==false){ p++; }//while

		vetor[p].set_pontos  (vetor[p].get_pontos()+t1.get_pontos());
		vetor[p].set_jogos   (vetor[p].get_jogos()+1);
		vetor[p].set_vitorias(vetor[p].get_vitorias()+t1.get_vitorias());
		vetor[p].set_empates (vetor[p].get_empates()+t1.get_empates());
		vetor[p].set_derrotas(vetor[p].get_derrotas()+t1.get_derrotas());
		vetor[p].set_golsP   (vetor[p].get_golsP()+t1.get_golsP());
		vetor[p].set_golsC   (vetor[p].get_golsC()+t1.get_golsC());
		vetor[p].set_saldo   (vetor[p].get_golsP()-vetor[p].get_golsC());

	}//atualizar

	/**
	 *Metodo para trocar os valores de duas posicoes do vetor
	 *@param posicao 1
	 *@param posicao 2
	 */
	void swap(int p1, int p2){

		Time tmp1=new Time();
		Time tmp2=new Time();

		tmp1.Clone(vetor[p1]);
		tmp2.Clone(vetor[p2]);

		vetor[p1].Clone(tmp2);
		vetor[p2].Clone(tmp1);

	}//swap

	//============ METODOS DE PESQUISA ======================
	/**
	 *Metodo para comparar duas Strings 
	 *@param Strings a serem comparadas
	 *@return se String menor, igual, ou maior(-1, 0, 1)
	 */
	int compare(String a, String b){
		//MyIO.println("COMPARE: "+a+" COM "+b);
		int c=0;
		int p=0;
		int resp=0;
		int c1=0, c2=0;
		if(a.length()>b.length()){ resp=1; }
		else if(b.length()>a.length()){ resp=-1; }

		while(c==0){

			if(p<b.length() && p<a.length() ){
				c1=(int)a.charAt(p);
				c2=(int)b.charAt(p);
				//MyIO.println(c1+"   "+c2);
				if(c1==195){ c1=65; }//se 'Á'
				if(c2==195){ c2=65; }

				if(c1<c2){
					resp=-1;
					c++;
				}//if
				else if(c1>c2){
					resp=1;
					c++;
				}///else if
				else{
					p++;
				}//else
			}
			else{ c++; }
		}//while

		return(resp);
	}//compare



	/**
	 *Metodo de ordenacao por selecao
	 */
	void selecao(){
		//MyIO.println("N :"+n);
		for (int i = 0; i < (n - 1); i++) {
			int menor = i;
			//MyIO.println("I :"+i);
			for (int j = (i + 1); j < n; j++){
				//MyIO.println("J: "+j);

				if (compare	(vetor[menor].get_pais(),vetor[j].get_pais())==1){
					menor = j;
				}
			}
			swap(menor, i);
		}
	}//Selecao

	/**
	 *Metodo de ordenacao parcial por selecao
	 *@param posicao onde comecar ordenação
	 *@param posicao onde terminar ordenação
	 */
	void selecaoP(int i, int f){
		//MyIO.println("N :"+n);
		if(i<f && i<n && f<n){
			for (i = i; i < (f-1); i++) {
				int menor = i;
				//MyIO.println("I :"+i);
				for (int j = (i + 1); j < f; j++){
					//MyIO.println("J: "+j);

					if (compare	(vetor[menor].get_pais(),vetor[j].get_pais())==1){
						menor = j;
					}
				}
				swap(menor, i);
			}
		}//if
	}//Selecao

	/**
	 *Metodo de ordenacao por selecao recursivo
	 */
	void selecaoR(int menor, int pos){
		MyIO.println("MENOR: "+menor+" POS: "+pos);
		while(menor<(n-1)){
			MyIO.println("WHILE");

			if (compare(vetor[menor].get_pais(),vetor[pos].get_pais())==1){
				swap(menor, pos);      

			}
			if(pos+1==n){
				MyIO.println(n+"   "+pos+1+"  "+menor);
				MyIO.println("PRIMEIRO IF");
				selecaoR(menor+1, menor+2);
			}
			selecaoR(pos, pos+1);

		}//while

	}//selecao

	/**
	 *Metodo de ordenacao por insercao
	 */
	void insercao(){

		Time t=new Time();
		//Time t2= new Time();
		//Time t3=new Time();

		int c=0;
		int p=0;
		int ct=0;
		int y=0;
		int x=0;
		boolean mov=false;//variavel que vai indicar se deve fazr movimentações ou não

		Time tmp= new Time();

		while(c<n-1){

			p=c+1;//pegar posicao do primeiro elemento nao ordenado do vetor
			x=p-1;
			while(x>=0){ 
				if(vetor[p].get_vitorias()<vetor[x].get_vitorias()){ mov=true; y=x; }
				x--; 

			}//percorrer o ranking ate encontrar um elemento fora da ordem ou terminar o vetor
			if(mov){ for(ct=p; ct>y; ct--){ swap(ct, ct-1); }}// trocar posicao dos elementos ate a posicao correta
			c++;
			mov=false;
		}//while
//imprimirL();
//	MyIO.println("SUB ORDENAÇAO");
		//ordenar alfabeticamente atributos iguais
		p=vetor[0].get_vitorias();
		x=0;
		for(c=1; c<n; c++){
			if(vetor[c].get_vitorias()!=p){ 
				selecaoP(x, c-1);
				p=vetor[c].get_vitorias();
				x=c;
			}//if
		}//for
//imprimirL();
	}//insercao



	/**
	 *Metodo para ordenar o ranking em ordem alfabetica
	 */
	void ordenar(){

		selecao();

	}//ordenar

	/**
	 *Metodo que realiza pesquisa sequencial no ranking
	 *@param pais a ser buscado
	 *@return SIM ou NAO
	 */
	String pesquisaseq(String pais){
		boolean resp=false;
		String x="";
		int p=0;
		while(p<n && resp==false){ resp=Equals(vetor[p].get_pais(), pais); comp++; p++; }//while

		if(resp==true){ x="SIM";}
		else{ x="NÃO"; }

		return(x);
	}//pesquisa


	/**
	 *Metodo que realiza pesquisa binaria no ranking
	 *@param pais a ser pesquisado
	 *@return SIM ou NAO
	 */
	String pesquisabin(String pais){
		int e=0, d=n;

		boolean x=false;
		String resp="";
		while(e+1!=d){
			int m=e+(d-e)/2;
			String base=vetor[m].get_pais();
			if(compare(pais,base)==0){//se encontrar
				x=true;
				e=d-1;
			}
			else if(compare(pais,base)==1){//se pais maior
				e=m;
			}
			else if(compare(pais,base)==-1){//se pais menor
				d=m;
			}
		}//while
		if(x){ resp="SIM";}
		else{ resp="NÃO"; }
		return(resp);
	}//pesquisabin

	int  get_comp(){
		return(comp);
	}

}//class

public class TP01P2Q09{


	/**
	 *@author Joao Marcos Aguiar Alves
	 *@Param a - String
	 *@param b - String
	 *@return resposta
	 */
	public static boolean Equals(String a, String b){
		boolean resposta=true;
		if(a.length()!=b.length()){
			resposta=false;}

		else{
			for(int contador=0; contador<a.length(); contador++){
				if(a.charAt(contador)!=b.charAt(contador)){
					resposta=false;
					contador= a.length();}

			}//for

		}//else

		return(resposta);
	}//Equals()


	/**
	 *Metodo para verificar se uma String esta contida dentro de outra
	 *@param String onde sera feita a busca
	 *@param String a ser procurada
	 *return true ou false
	 */
	public static boolean Contains(String a, String b){

		int i=0, f=b.length();
		boolean resp=false;
		int c=0;

		while(f<a.length() && resp==false){//enquanto String 'a' puder ser subdividida
			String piece="";

			for(c=i; c<f; c++){//criar String com o "pedaco" de 'a'
				piece+=a.charAt(c);
			}//for

			resp=Equals(b, piece);
			i++;
			f++;
		}//while
		return(resp);
	}//contains()

	/**
	 *Metodo que retorna a quantidadee de partidas contidas no arquivo html
	 *@param arquivo a ser aberto
	 *@return quantidade de partidas
	 */
	public static int QP(String arquivo){

		int q=0;
		String linha="";
		Arq.openRead("/tmp/copa/"+arquivo+".html", "ISO8859-1");//abrir arquivo

		while(Contains(linha, "bgcolor")==false){ linha=Arq.readLine(); }//while

		while(Contains(linha, "bgcolor="+'"'+"#000000")==false){//enquanto nao chegar ao fim das partidas

			linha=Arq.readLine();

			if(linha.contains("<tr>")==true){//se encontrar padrao

				if(!(Contains(linha, "GRUPO")) && !(Contains(linha, "FASE FINAL")) && !(Contains(linha, "FINAL")) && !(Contains(linha, "lugar")) && !(Contains(linha, "bgcolor"))){
					q++; 
				} //se padrao encontrado nao estiver junto da "etapa"

			}//if

		}//while
		return(q);
	}//QP



	public static void main (String [] args){

		//MyIO.println((int)'Á');
		Ranking r1= new Ranking(1000);
		Time t1= new Time();
		Partida p1 = new Partida();

		String arquivo="";

		int c=0;
		int p=0;//ponteiro
		int t=1;
		int comp=0;
		long time=0;
		//ler todas as entradas
		for(arquivo=MyIO.readLine(); Equals(arquivo, "0")==false; arquivo=MyIO.readLine()){

			int q=QP(arquivo);//quantidade de partidas no arquivo

			//pegar partidas do arquivo
			for(c=1; c<=q; c++){
				p1.get_partida(arquivo, c);
				//p1.Print();
				//pegar dois Times da partida
				while(t<3){
					t1.find_time(p1, t);

					//se time no vetor
					if(!(r1.registrado(t1.get_pais()))){
						r1.inserirFim(t1);


					}//if
					else{
						r1.atualizar(t1.get_pais(), t1);
					}//else
					t++;

				}//while
				t=1;
			}//for
			p1.set_aux(0);

		}//for
		//  r1.imprimirL();
		r1.insercao();
		//MyIO.println("|||||||||||||||||||||||||||||||||||||");
		r1.imprimirL();

	}//main
}//class
