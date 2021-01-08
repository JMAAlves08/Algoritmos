

/**
 *@author João Marcos Aguiar Alves
 *Matricula: 600092
 */
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

		while(Contains(linha, "bgcolor")==false){//achar bg color
			linha=Arq.readLine();
		}//while

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


/**
 * No da arvore binaria
 * @author Max do Val Machado
 */
class No{
	private int elemento;  //Conteudo do no.
	private No esq, dir;    //Filhos da esq e dir e subarvore.
	private No2 sub;        //subarvore
        /*Gets e sets*/
        void set_elemento(int elemento){
            this.elemento=elemento;
        }//set_elemento()
        int get_elemento(){
            return(elemento);
        }//get_elemento()
        
        void set_esq(No no){
            esq=no;
        }
        No get_esq(){
            return(esq);
        }
        
        void set_dir(No no){
            dir=no;
        }
        No get_dir(){
            return(dir);
        }
		
		void set_sub(No2 no){
			sub=no;
		}
		
		No2 get_sub(){
			return(sub);
		}
	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	public No(int elemento) {

		this.elemento = elemento;
                esq=null;
                dir=null;
				sub=null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
	public No(int elemento, No esq, No dir, No2 sub) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.sub=sub;
	}
}//class

class No2 extends Time{

private Time elemento;
private No2 esq, dir;

public No2(){
elemento=null;
esq=dir=null;
}

public No2(Time elemento, No2 esq, No2 dir){
this.elemento=elemento;
this.esq=esq;
this.dir=dir;
}

public No2 (Time t){
elemento=t;
esq=null;
dir=null;
}

void set_elemento(Time t){
elemento.Clone(t);
}//set
Time get_elemento(){ return(elemento); }

void set_esq(No2 no){
esq=no;
}//set
No2 get_esq(){ return(esq); }

void set_dir(No2 no){
dir=no;
}//set
No2 get_dir(){ return(dir); }
}//class

/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */
class ArvoreArvore{
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreArvore () {
		inserir(7);
inserir(3);
inserir(11);
inserir(1);
inserir(5);
inserir(9);
inserir(12);
inserir(0);
inserir(2);
inserir(4);
inserir(6);
inserir(8);
inserir(10);
inserir(13);
inserir(14);

	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String x) {
		return pesquisar(x, raiz.get_sub());
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(String x, No2 i) {
      boolean resp;
		if (i == null) {
         resp = false;

      } else if (compare(x,i.get_elemento().get_pais())==0) {
         resp = true;

      } else if (compare(x, i.get_elemento().get_pais())==-1) {
         resp = pesquisar(x, i.get_esq());

      } else {
         resp = pesquisar(x, i.get_dir());
      }
      return resp;
	}


   /**
     * Metodo publico iterativo para inserir elemento.
     * @param x Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    public void inserir(int x) {
        raiz = inserir(x, raiz);
    }
 
    /**
     * Metodo privado recursivo para inserir elemento.
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */
    private No inserir(int x, No i) {
        if (i == null) {
         i = new No(x);
 
      } else if (x < i.get_elemento()) {
         i.set_esq(inserir(x, i.get_esq()));
 
      } else if (x > i.get_elemento()) {
         i.set_dir(inserir(x, i.get_dir()));
 
      } else {
        
      }
 
        return i;
    }


	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarCentral() {
		System.out.print("[ ");
		mostrarCentral(raiz.get_sub());
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void mostrarC(No i) {
		if (i != null) {
			mostrarC(i.get_esq()); // Elementos da esquerda.
			System.out.print(i.get_elemento()+" "); // Conteudo do no.
			mostrarC(i.get_dir()); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarC() {
		System.out.print("[ ");
		mostrarC(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void mostrarCentral(No2 i) {
		if (i != null) {
			mostrarCentral(i.get_esq()); // Elementos da esquerda.
			System.out.print(i.get_elemento().get_pais() + " "); // Conteudo do no.
			mostrarCentral(i.get_dir()); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarPre() {
		System.out.print("[ ");
		mostrarPre(raiz.get_sub());
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void mostrarPre(No2 i) {
		if (i != null) {
			System.out.print(i.get_elemento() + " "); // Conteudo do no.
			mostrarPre(i.get_esq()); // Elementos da esquerda.
			mostrarPre(i.get_dir()); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarPos() {
		System.out.print("[ ");
		mostrarPos(raiz.get_sub());
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void mostrarPos(No2 i) {
		if (i != null) {
			mostrarPos(i.get_esq()); // Elementos da esquerda.
			mostrarPos(i.get_dir()); // Elementos da direita.
			System.out.print(i.get_elemento() + " "); // Conteudo do no.
		}
	}


	/**
	 * Metodo publico iterativo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(Time x) throws Exception {
//	MyIO.println("inserir "+x.get_pais());
		raiz.set_sub(inserir(x, raiz.get_sub()));
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No2 inserir(Time x, No2 i) throws Exception {
Time y=new Time();
y.Clone(x);

            if (i == null) { 
               i = new No2 (y);

            } else if (compare(y.get_pais(), i.get_elemento().get_pais() ) < 0 ) {//se parametro menor
                i.set_esq(inserir(y, i.get_esq()));//chamar recursividade na parte esquerda

            } else if (compare(y.get_pais(), i.get_elemento().get_pais()) > 0) {//se parametro maior
            i.set_dir(inserir(y, i.get_dir()));//chamar recursividade na parte direita

		     } else {

      		 }
//MyIO.println("INSERIU");
		return i;
	}

	/**
	 * Metodo publico iterativo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover(String x) throws Exception {
		raiz.set_sub(remover(x, raiz.get_sub()));
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private No2 remover(String x, No2 i) throws Exception {


		if (i == null) {
         throw new Exception("Erro ao remover!");

      } else if (compare(x, i.get_elemento().get_pais())== -1) {
         i.set_esq(remover(x, i.get_esq()));

      } else if (compare(x, i.get_elemento().get_pais())== 1) {
         i.set_dir(remover(x, i.get_dir()));

      // Sem no a direita.
      } else if (i.get_dir() == null) {
         i = i.get_esq();

      // Sem no a esquerda.
      } else if (i.get_esq() == null) {
         i = i.get_dir();

      // No a esquerda e no a direita.
      } else {
         i.set_esq(antecessor(i, i.get_esq()));
		}

		return i;
	}

	/**
	 * Metodo para trocar no removido pelo antecessor.
	 * @param i No que teve o elemento removido.
	 * @param j No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	private No2 antecessor(No2 i, No2 j) {

      // Existe no a direita.
		if (j.get_dir() != null) {
         // Caminha para direita.
			j.set_dir(antecessor(i, j.get_dir()));

      // Encontrou o maximo da subarvore esquerda.
		} else {
			i.get_elemento().Clone(j.get_elemento()); // Substitui i por j.
			j = j.get_esq(); // Substitui j por j.ESQ.
		}
		return j;
	}

/*METODOS AUXILIARES*/
/**
  *Metodo para comparar duas Strings 
  *@param Strings a serem comparadas
  *@return se String 'a' menor, igual, ou maior(-1, 0, 1)
  */
   int compare(String a, String b){
   //MyIO.println("COMPARE: "+a+" COM "+b);
      int c=0;
      int p=0;
      int resp=0;
      int c1=0, c2=0;
      while(c==0){ //enquanto caracteres iguais ou fim da String
         //if(p>4){ c++; }
         if(p<a.length()-1){
            c1=(int)a.charAt(p);
            c2=(int)b.charAt(p);
            if(c1==193){ c1=65; }//se 'Á'
            if(c2==193){ c2=65; }
         	//MyIO.println("c1: ("+(char)c1+") = "+c1+" c2: ("+(char)c2+") = "+c2+" p= "+p+" t= "+(a.length()-1));
            if(c1<c2){
               resp=-1;
               c++;
            }//if
            else if(c1>c2){
               resp=1;
               c++;
            }///else if
			else if(p==a.length()-1 && p<b.length()){ resp=-1; c++; }
			else if(p==b.length()-1 &&	 p<a.length()){ resp=1; c++; } 
            else{
               p++;
            }//else
         }
         else{ c++; }
      }//while
      return(resp);
   }//compare


}//class
/**
 *
 * @author joão Marcos Aguiar Alves - 600092
 */
public class TP03Q2 {
	/**
	 *@author Joao Marcos Aguiar Alves
	 *Metodo para determinar se duas Strings sao iguais
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Partida p1=new Partida();
        Time t1=new Time();
        ArvoreArvore a1=new ArvoreArvore();
        String arq="";
        int q=0;
        int c=0;
        int t=1;
        //
        a1.mostrarC();
        for(arq=MyIO.readLine(); Equals(arq, "0")==false; arq=MyIO.readLine()){

            q=QP(arq);//quantidade de partidas
           
			 for(c=1; c<=q; c++){
                p1.get_partida(arq, c);
              
				  while(t<3){

                    t1.find_time(p1,t);
					a1.inserir(t1);
					//a1.mostrarCentral();
                    
					//try{ a1.inserir(t1); } 
                    //catch(Exception Exception){ MyIO.println("Erro de insercao"); a1.mostrarCentral(); }
                    t++;
                }//while
                t=1;
            }//for
        }//for
        for(arq=MyIO.readLine(); Equals(arq, "FIM")==false; arq=MyIO.readLine()){
			if(a1.pesquisar(arq)){ MyIO.println(arq+" -- SIM"); }
			else{ MyIO.println(arq+" -- NÂO"); }
		
		}//for
    }//main
    
}//class
