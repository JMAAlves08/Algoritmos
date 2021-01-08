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
   
      return(resp);
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
	 *Metodo para pegar todos os atributos de uma partida de uma so vez
	 *@param arquivo a ser aberto 
	 *@param linha inicial
	 */
   void get_partida(String file/*, int linha*/){
   
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
            //MyIO.println("ETAPA");
            linha=Arq.readLine();//ler mais uma linha
         
         
           // MyIO.println("ETAPA: "+linha);
            while(!(linha.charAt(c)=='b' && linha.charAt(c+1)=='>'&& linha.charAt(c+2)!='<')){ c++; }//encontrar inicio da etapa
         
            c+=2;
         
            while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//pegar o atributo
            c=0;//zerar contador
         
            set_etapa(tmp);
         
            Final=Equals(tmp, "FINAL") || Equals(tmp, "FASE FINAL");//se final, sair da repeticao	
         
            tmp="";//apagar String
            while(l==0){
            //MyIO.println(l);
            
            // ================= DIA/MES ============================================
               //MyIO.println("DIA/MES");
               while(!(Contains(linha, "<tr>")==true || Equals(linha, "<tr>")==true)){ linha=Arq.readLine(); }//encontrar <tr>
            
               linha=Arq.readLine();//linha do atributo
               if(Contains(linha, "colspan")==false){
                  if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente
               
                 // MyIO.println("DIA/MES: "+linha);
                  while(!((linha.charAt(c)== '"' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<') || (linha.charAt(c)=='d' && linha.charAt(c+1)=='>' && linha.charAt(c+2)!='<'))){//percorrer linha ate encontrar o padrao " "> " ou " d> "
                     c++;//encontrar ">
                  }//while
                  c+=2;
                  tmp+=linha.charAt(c); c++;
                  tmp+=linha.charAt(c);//pegar dia
               //MyIO.println(tmp);
                  set_dia(Integer.parseInt(tmp));
               
               //pegar mes
                  tmp="";
                  c+=2;
                  if(linha.charAt(c)!='0'){ tmp+=linha.charAt(c); }//if
                  c++;
                  tmp+=linha.charAt(c);
               //MyIO.println(tmp);
                  set_mes(Integer.parseInt(tmp));
                  tmp="";
                  c=0;
               
               // ================== TIME1 ===============================
                  //MyIO.println("TIME1");
                  linha=Arq.readLine();
                 // MyIO.println("TIME1: "+linha);
                  if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente
               
                  while(!(linha.charAt(c)=='>' && linha.charAt(c+1)!='<')){ c++; }//while
                  c++;
                  while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while
               //System.out.println(tmp);
                  set_time1(tmp);
               
                  c=0;
                  tmp="";
               
               // ===============PLACAR1 ===================================
                  //MyIO.println("PLACAR1");
                  linha=Arq.readLine();
                  if(Equals(linha, "     ")==true){ linha=Arq.readLine();}//if linha vazia, ler novamente
                 // MyIO.println("PLACAR1: "+linha);
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
               //MyIO.println(linha);
               //MyIO.println(tmp);
                  set_placar1(Integer.parseInt(tmp));
               
                  tmp="";
               
               // ============ PLACAR2 =======================================
                  //MyIO.println("PLACAR2");
                 // MyIO.println("PLACAR2: "+linha);
               //MyIO.println(linha.charAt(c));
                  if(linha.charAt(c)=='x'){ c++; }//if
                  if(linha.charAt(c)>='0' && linha.charAt(c)<='9'){ tmp+=linha.charAt(c);}//if
                  c++;
               //MyIO.println(linha.charAt(c));
                  tmp+=linha.charAt(c);
               //MyIO.println(tmp);
                  set_placar2(Integer.parseInt(tmp));
                  c=0;
                  tmp="";
               
               // ======================= TIME 2 =================================
                  //MyIO.println("TIME2");
                  linha=Arq.readLine();
                  //MyIO.println("TIME2: "+linha);
                  while(!(linha.charAt(c)=='>')){ c++; }//while
                  c++;
                  while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while
               //MyIO.println(tmp);
                  set_time2(tmp);
                  c=0;
                  tmp="";
               
               //================== LOCAL =====================================
                  //MyIO.println("LOCAL");
                  linha=Arq.readLine();
                 // MyIO.println("LOCAL: "+linha);
               
                  while(!(linha.charAt(c)=='>')){ c++; }//while
                  c++;
                  while(!(linha.charAt(c)=='<')){ tmp+=linha.charAt(c); c++; }//while
               //MyIO.println(tmp);
                  set_local(tmp);
                  c=0;
                  tmp="";
               //================================================================
               
                  Print();
               
               //MyIO.println(linha);
                  if(Final==false){
                     while(/*Equals(linha, "  </tr>")*/linha.contains("</tr>")==false){
                     //MyIO.println("WHILE"); 
                        linha=Arq.readLine();
                     }//while
                  }//if
                  else{ 
                     if(Equals(get_etapa(), "FASE FINAL")==false){ 
                        l++; end++;
                     } 
                     else{  }}//else
                     //MyIO.println("CONTAINS: "+linha);
                  linha=Arq.readLine();
             //  MyIO.println("CONTAINS: "+linha);
                  tmp=linha;
                  if(Contains(linha, "bgcolor")==true){
                     if(Contains(linha, "#000000")==true){ end++;}
                     else{
                    // MyIO.println("BGCOLOR");
                        l++;
                     }//else
                  }//if
                  else if(linha.isEmpty()	){ 
                  //MyIO.println("LINHA VAZIA");
                     l++;
                     linha=Arq.readLine();
                  }//if
                  else if(Contains(linha, "<")==false){ l++; linha=Arq.readLine();}//else if
                  else{
                  //MyIO.println("ELSE");
                     linha=tmp;
                     tmp="";
                  }//else	
                  //MyIO.println("WHILE: "+linha);
               }//if
               else{  l++; end++; Final=true; }//else
            }//while
             
         }//while
      
      }//while
   
   
   
   
   
   
   }//get_partida()

	/**
	 *Metodo para printar uma Partida
	 */
   void Print(){
   
      System.out.println("[COPA "+copa+"] - "+etapa+" - "+dia+'/'+mes+" - "+time1+" ("+placar1+") x ("+placar2+") "+time2+"  - "+local);
   }//Print()

   String Printday(int dia){
      String x = Integer.toString(dia);
      String day="";
      day=day+x.charAt(0)+x.charAt(1);
      String month="";
      if(x.charAt(2)=='0'){
         month=month+x.charAt(3);
      }//if
      else{
         month=month+x.charAt(2)+x.charAt(3);
      }//else
      return(day+'/'+month);
   }//print()



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


}//class

public class TP01P2Q01{


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


   public static void main(String [] args){
   
      Partida c1 = new Partida();
      String arquivo="";
      String et="";
      int c=0;
      int c0=0;
      int c2=0;
      int l=0;
      int q1=0;
      int controle=0;
   
      for(arquivo=MyIO.readLine(); Equals(arquivo, "0")==false; arquivo=MyIO.readLine()){
      
         c1.get_partida(arquivo);
      	//c1.Print();
      
      	//			int q=c1.Quantidade("/tmp/copa/"+arquivo+".html");
      
      	//			et="";
      	/*
      	   do{
      
      	   if(Equals(et, "FINAL")==false){
      
      	   l=c1.Grupo("/tmp/copa/"+arquivo+".html", c);//quantidade de etapas
      	   q1=c1.Quantidade2("/tmp/copa/"+arquivo+".html", l);//quantidade de <tr>
      	   q1+=c0;
      	   c1.set_etapa  (c1.get_etapa  (arquivo+".html", l));
      	   et=c1.get_etapa();
      
      	   do{
      
      	   c2=c1.Tag(arquivo+".html",c0);
      	   c1.set_copa   (c1.get_copa   (arquivo+".html"));
      	   c1.set_placar1(c1.get_placar1("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_placar2(c1.get_placar2("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_dia    (c1.get_dia    ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_mes    (c1.get_mes    ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_time1  (c1.get_time1  ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_time2  (c1.get_time2  ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_local  (c1.get_local  ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.Print();
      	   c0++;
      	   }while(c0<q1 );
      
      	   }//if
      	   controle=0;
      	   c++;
      
      	   }while(c<q-1 );
      
      
      
      	   c=0; c0=0;
      	 */
      }//for
   
   
   
   }//main

}//class


