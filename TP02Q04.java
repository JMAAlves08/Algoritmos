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



class Celula extends Time{

	private Time elemento;//valor guardado na celula
	private Celula prox, ant;

	//construtores
	public Celula(){
		elemento=new Time();
		prox=null;
		ant=null;
	}

	public Celula(Time t){
		elemento=new Time();
		elemento.Clone(t);
		prox=null;
		ant=null;
	}
	//

	//get/set
	Time get_elemento(){
		return(elemento);
	}

	void set_elemento(Time p){
		elemento.Clone(p);
	}

	Celula get_prox(){
		return(prox);
	}

	void set_prox(Celula c){
		prox=c;
	}

	Celula get_ant(){
		return(ant);
	}

	void set_ant(Celula c){
		ant=c;
	}

}//celula

class Lista extends Celula{

	//aributos

	private int n; //quantidade de elementos
	private Celula p, u;//ponteiro que aponta para o proximo elemento

	//


	//construtores

	public Lista(){

		p=new Celula();
		u=p;
	}



	//=============METODOS DE INSERCAO==========================================================
	/**
	 *Metodo para inserir um valor no inicio da lista simples
	 *@param Partida a ser inserida
	 */
	void inserirInicio(Time p1){
		//	   MyIO.println("INSERIR INICIO");
		Time p2= new Time();
		p2.Clone(p1);

		if(n==0){    //se vetor vazio, inserir na primeira posicao
			p.set_prox(new Celula(p2));
			u=p.get_prox();
			u.set_ant(p);
			n++;
		}


		else{

			Celula tmp=new Celula(p2);
			tmp.set_prox(p.get_prox());
			tmp.set_ant(p);
			p.set_prox(tmp);
			tmp=null;
			n++;         
		}

	}//inseririnicio()

	/**
	 *Metodo para inserir uma Partida no fim do arranjo
	 *@param Partida a ser inserida
	 */
	void inserirFim(Time p1){
		//	   MyIO.println("INSERIR FIM");

		Time p2=new Time();
		p2.Clone(p1);  

		u.set_prox(new Celula(p2));
		u.get_prox().set_ant(u);                                       
		u=u.get_prox();

		n++;

	}//inserirFim()


	/**
	 *Metodo para inserir uma Partida em uma determinada posicao
	 *@param Partida a ser inserida
	 *@param posicao - local do vetor para insercao
	 */

	void inserir(Time p1, int posicao){
		// MyIO.println("INSERIR");
		Time p2=new Time();
		Celula c=p.get_prox();

		p2.Clone(p1);


		Celula tmp=new Celula(p2);
		for(int x=0; x<posicao && c.get_prox()!=null; x++, c.set_prox(c.get_prox())){ if(c.get_prox()==null){ MyIO.println("ERRO"); }}
		tmp.set_prox(c);
		tmp.set_ant(c.get_ant());
		c.get_ant().set_prox(tmp);	
		c.set_ant(tmp);
		tmp=null;
		c=null;
		n++;

	}//inserir()
	//======================================================================================================



	//=============METODOS DE REMOCAO==========================================================================

	/**
	 *metodo que remove o primeiro elemento do arranjo
	 *return Partida removida
	 */

	Time removerInicio(){
		//MyIO.println("REMOVER INICIO");
		//dados
		Time p1 = new Time();
		if(n==0){ MyIO.println ("ERRO REMOVER INICIO"); }//if

		else{
			p1.Clone(p.get_prox().get_elemento());
			Celula tmp;
			tmp=p.get_prox();
			p.set_prox(tmp.get_prox());
			p.get_prox().set_ant(p);

			tmp.set_prox(null);
			tmp.set_ant(null);
			tmp=null;

			n--;
		}//else
		return(p1);

	}//removerInicio()

	/**
	 *metodo para remover o ultimo elemento do vetor
	 *return Partida removida
	 */

	Time removerFim(){
		// MyIO.println("REMOVER FIM");
		Time p1= new Time();

		Celula tmp=p;
		while(tmp.get_prox()!=u){ tmp=tmp.get_prox(); }
		p1.Clone(u.get_elemento());
		u.set_ant(null);
		u=tmp;
		tmp=null;
		u.set_prox(null);
		n--;

		return(p1);
	}//removerFim()

	/**
	 *metodo para remover um valor em qualquer posicao do arranjo
	 *@param posicao a ser removida
	 *return Partida removida
	 */
	Time remover(int posicao){
		//MyIO.println("REMOVER");
		Time p1=new Time();

		if(posicao<0 || posicao>n-1 ){
			MyIO.println("Posicao "+posicao+" invalida");
		}

		else{

			if(posicao==0){ //caso primeira posicao, chamar o metodo removerInicio()

				p1=removerInicio();

			}

			else if(posicao == n-1){

				p1=removerFim(); // caso ultima posicao, chamar o metodo removerFim()

			}

			else{

				Celula c=p.get_prox();
				for(int x=0; x<posicao && c.get_prox()!=null; x++, c.set_prox(c.get_prox())){ if(c.get_prox()==null){ MyIO.println("ERRO"); }}

				Celula tmp=c.get_ant();
				p1.Clone(c.get_elemento());
				tmp.set_prox(c.get_prox());
				tmp.get_prox().set_ant(tmp);
				c.set_ant(null);
				c.set_prox(null);
				tmp=null;
				c=null;
				n--;
			}
			//         n--;
		}

		return(p1);

	}//remover()


/**
  *metodo para selecionar o pivo para a ordenação quicksort
  *@param celulas que demarcam o intervalo de busca
  *@return maior valor entre elas/2
  */
int get_pivo(Celula a, Celula b){
int maior=a.get_elemento().get_golsP();
Celula tmp=a.get_prox();
while(tmp!=b){
if(tmp.get_elemento().get_golsP()>maior){ maior=tmp.get_elemento().get_golsP(); }//if
tmp=tmp.get_prox();
}//while
MyIO.println("PIVO: "+maior/2);
return(maior/2);
}//get_maior()
	/**
	 *Metodo de ordenaçao quicksort
	 *Inicia o metodo recursivo
	 */
	void quicksort(){
		quicksort(p.get_prox(), u, get_pivo(p, u));
	}//quicksort

	/**
	 *Metodo de ordenação quicksort recursivo
	 *@param celula da esquerda
	 *@param celula da direita
	 */
	private void quicksort(Celula esq, Celula dir, int pivo){
		//MyIO.println("QUICKSORT");
		Celula e=esq;//i
		Celula d=dir;//j
		//Celula pivo;
		int c=0;
		int x=0;
		boolean menor=false;
		boolean a=false;//esq<d
		boolean b=false;//e<dir

        //pegar pivo
		//for(Celula tmp=e; tmp!=dir; tmp=tmp.get_prox()){ c++; }//for
		//for(x=0, pivo=e; x<c/2 && pivo!=dir; x++, pivo=pivo.get_prox());
		//
		while(!menor){

			while(e.get_elemento().get_golsP()<=pivo){ 
				//MyIO.println(e.get_elemento().get_golsP()+" MENOR QUE "+pivo);
				e=e.get_prox(); 
				if(e.get_ant()==d){menor=true; }
				if(e==dir){ b=true; }
			}//while
			//MyIO.println(e.get_elemento().get_golsP()+"  NAO MENOR QUE "+pivo);
			while(d.get_elemento().get_golsP()>pivo){ 
				//MyIO.println(d.get_elemento().get_golsP()+" MAIOR QUE "+pivo.get_elemento().get_golsP());
				d=d.get_ant();
				if(esq==d){a=true; }
				if(e.get_ant()==d){menor=true; }
			}//while
			//MyIO.println(d.get_elemento().get_golsP()+" NAO MAIOR QUE "+pivo);
			if(!menor){
				swap(e, d);
				e=e.get_prox();
				d=d.get_ant();
			}//if
			if(e.get_ant()==d){ menor=true; }//i>j
			if(esq==d){ a=true; }
			if(e==dir){ b=true; }
			
		}//while

		if(a!=true){ quicksort(esq, d, get_pivo(esq, d)); }
		if(b!=true){ quicksort(e, dir, get_pivo(e, dir)); }

	}//quicksort


	/**
	 *Metodo para trocar o valor de duas celulas
	 *@param Celulas
	 */
	void swap(Celula a, Celula b){

		Time t1=new Time();
		Time t2=new Time();

		t1.Clone(a.get_elemento());
		t2.Clone(b.get_elemento());

		a.set_elemento(t2);
		b.set_elemento(t1);

	}//swap


	/**
	 *Metodo que verifica se um time ja esta no ranking
	 *@param pais a ser buscado
	 *@return se esta contido ou nao
	 */
	boolean registrado(String pais){

		boolean resp=false;
		int c=0;
		Celula m=p.get_prox();
		
		do{
			if(m!=null){
			resp=Equals(m.get_elemento().get_pais(), pais);
			//System.out.println(vetor[p].get_pais()+" === "+pais+" : "+resp);
			c++;
			m=m.get_prox();
			if(resp==true){ c=n; }
			}//if
		}while(c<n /*&& m.get_prox()!=null*/ );
		
		m=null;
		return(resp);
	}//registrado

	/**
	 *Metodo para atualizar os atributos de um membro do ranking
	 *@param pais a ser alterado
	 *@param time com novos atributos
	 */
	void atualizar(String pais, Time t1){

		//econtrar posicao do vetor
		int c=0;
		Celula m=p.get_prox();
		while(Equals(m.get_elemento().get_pais(), pais)==false && m.get_prox()!=null){ m=m.get_prox(); }//while

		m.get_elemento().set_pontos  (m.get_elemento().get_pontos()+t1.get_pontos());
		m.get_elemento().set_jogos   (m.get_elemento().get_jogos()+1);
		m.get_elemento().set_vitorias(m.get_elemento().get_vitorias()+t1.get_vitorias());
		m.get_elemento().set_empates (m.get_elemento().get_empates()+t1.get_empates());
		m.get_elemento().set_derrotas(m.get_elemento().get_derrotas()+t1.get_derrotas());
		m.get_elemento().set_golsP   (m.get_elemento().get_golsP()+t1.get_golsP());
		m.get_elemento().set_golsC   (m.get_elemento().get_golsC()+t1.get_golsC());
		m.get_elemento().set_saldo   (m.get_elemento().get_golsP()-m.get_elemento().get_golsC());
		m=null;
	}//atualizar



	//==============================================================================================================

	/**
	 *metodo para imprimir o vetor
	 */

	void imprimirL(){

		int contador=0;
		Celula tmp=p.get_prox();
		while(contador<n){

			tmp.get_elemento().Print();
			contador++;
			tmp=tmp.get_prox();
		}

	}//imprimirL()


	/**
	 *metodo para imprimir o vetor de remocoes
	 /

	 void imprimirLR(){

	 int contador=0;
	 Celula tmp=p.get_prox();
	 while(contador<n){

	 MyIO.println("(R) "+tmp.get_elemento().get_copa()+" - "+tmp.get_elemento().get_etapa()+" - "+tmp.get_elemento().get_time1()+"  x "+tmp.get_elemento().get_time2()+" ");
	 contador++;
	 tmp=tmp.get_prox();
	 }

	 }//imprimirL()
	 */


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

}//class

public class TP02Q04{


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

	//========================================================================================================================

	//========================================================================================================================

	public static void main (String [] args){

		//dados
		Lista r1 = new Lista();   
		Partida p1 = new Partida();
		Time t1=new Time();

		String arquivo="";

		int t=1;//
		int c=0;//
		int c0=0;//

		//============= INSERÇÃO INICIAL NA LISTA ==============================================//

		//
		for(arquivo=MyIO.readLine(); Equals(arquivo, "0")==false; arquivo=MyIO.readLine()){
			c0=QP(arquivo); 
			for(c=1; c<=c0; c++){ 
				p1.get_partida(arquivo, c);
				//MyIO.println("PEGOU PARTIDA");
				while(t<3){
					t1.find_time(p1, t);
					//MyIO.print("PEGOU TIME "); t1.Print();
					//MyIO.println(Equals("Alemanha Ocidental", teste));
					
					//se time no vetor
					if(!(r1.registrado(t1.get_pais()))){
						r1.inserirFim(t1);
						//MyIO.print("INSERIR "); t1.Print();
						//MyIO.println("INSERIU");
					}//if
					else{
						r1.atualizar(t1.get_pais(), t1);
						//MyIO.print("ATT "); t1.Print();
					}//else
					t++;
					//MyIO.println("ZZZZZ");
				}//while
				t=1;
				//p1.Print();


			}//for
			//v1.imprimirL();												//
		}//for//===============================================================================	//
		Arq.close();
        //r1.imprimirL();
		r1.quicksort();
		r1.imprimirL(); //imprimir lista de Times

	}//main()

}//class
