/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
  */
  class Inst{

   //atributos
   private int codigo;
   private String nome;
   private String sigla;
   private int codman;//codigoMantenedora
   private String mant;
   private int categoria;
   private int org;//organizalçao
   private int codmu; //codigomunicipio
   private String municipio;
   private String uf;
   private String regiao;
   private int tecnico;
   private int periodico;
   private int livro;
   private double receita;
   private double transferencia;
   private double outrarec; //outrareceita
   private double despesadoc; //despesadocente
   private double despesatec; //despesatecnico
   private double despesaenc; //despesaencargo
   private double despesacus; //despesacusteio
   private double despesainv; //despesainvestimento
   private double despesapes; //despesapesquisa
   private double despesaout; //despesaoutros
   //

   //GETS
   int get_codigo(){            return(codigo);   }
   int get_codman(){            return(codman);   }
   int get_categoria(){         return(categoria);   }
   int get_org(){               return(org); }
   int get_codmu(){             return(codmu);   }
   int get_tecnico(){           return(tecnico);   }
   int get_periodico(){         return(periodico);   }
   int get_livro(){             return(livro);   }
   String get_nome(){           return(nome);   }
   String get_sigla(){          return(sigla);   }
   String get_municipio(){      return(municipio);   }
   String get_uf(){             return(uf);   }
   String get_regiao(){         return(regiao);   }
   String get_mant(){           return(mant);   }
   double get_receita(){        return(receita);   }
   double get_transferencia(){  return(transferencia);   }
   double get_outrarec(){       return(outrarec);   }
   double get_despesadoc(){     return(despesadoc);   }
   double get_despesatec(){     return(despesatec);   }
   double get_despesaenc(){     return(despesaenc);   }
   double get_despesacus(){     return(despesacus);   }
   double get_despesainv(){     return(despesainv);   }
   double get_despesapes(){     return(despesapes);   }
   double get_despesaout(){     return(despesaout);   }
   //

   //SETS
   void set_codigo(int cod){         codigo=cod; }
   void set_codman(int cod){         codman=cod; }
   void set_categoria(int cat){      categoria=cat; }
   void set_org(int o){              org=o; }
   void set_codmu(int cod){          codmu=cod; }
   void set_tecnico(int t){          tecnico=t; }
   void set_periodico(int p){        periodico=p; }
   void set_livro(int l){            livro=l; }
   void set_nome(String n){          nome=n; }
   void set_sigla(String sig){       sigla=sig; }
   void set_municipio(String m){     municipio=m; }
   void set_uf(String u){            uf=u; }
   void set_regiao(String reg){      regiao=reg; }
   void set_mant(String m){          mant=m; }
   void set_receita(double r){       receita=r; }
   void set_outrarec(double o){      outrarec=o; }
   void set_despesadoc(double d){    despesadoc=d; }
   void set_despesatec(double t){    despesatec=t; }
   void set_despesaenc(double e){    despesaenc=e; }
   void set_despesacus(double c){    despesacus=c; }
   void set_despesainv(double i){    despesainv=i; }
   void set_despesapes(double p){    despesapes=p; }
   void set_despesaout(double o){    despesaout=o; }
   void set_transferencia(double t){ transferencia=t; }
   //

   //CONSTRUTORES

public Inst(){
codigo=0;
nome="";
sigla="";
codman=0;
mant="";
categoria=0;
org=0;
codmu=0;
municipio="";
uf="";
regiao="";
tecnico=0;
periodico=0;
livro=0;
receita=0;
transferencia=0;
outrarec=0;
despesadoc=0;
despesatec=0;
despesaenc=0;
despesacus=0;
despesainv=0;
despesapes=0;
despesaout=0;
}//builder

public Inst(int codigo, String nome, String sigla, int codman, String mant, int categoria, int org, int codmu, String get_municipio,
            String uf, String regiao, int tecnico, int periodico, int livro, double receita, double transferencia, double outrarec,
            double despesadoc, double despesatec, double despesaenc, double despesacus, double despesainv, double despesaout,
             double despesapes){
  this.codigo=codigo;
  this.nome=nome;
  this.sigla=sigla;
  this.codman=codman;
  this.mant=mant;
  this.categoria=categoria;
  this.org=org;
  this.codmu=codmu;
  this.municipio=municipio;
  this.uf=uf;
  this.regiao=regiao;
  this.tecnico=tecnico;
  this.periodico=periodico;
  this.livro=livro;
  this.receita=receita;
  this.transferencia=transferencia;
  this.outrarec=outrarec;
  this.despesadoc=despesadoc;
  this.despesatec=despesatec;
  this.despesaenc=despesaenc;
  this.despesacus=despesacus;
  this.despesainv=despesainv;
  this.despesapes=despesapes;
  this.despesaout=despesaout;
}//builder

void clone(Inst i){
  this.codigo=i.codigo;
  this.nome=i.nome;
  this.sigla=i.sigla;
  this.codman=i.codman;
  this.mant=i.mant;
  this.categoria=i.categoria;
  this.org=i.org;
  this.codmu=i.codmu;
  this.municipio=i.municipio;
  this.uf=i.uf;
  this.regiao=i.regiao;
  this.tecnico=i.tecnico;
  this.periodico=i.periodico;
  this.livro=i.livro;
  this.receita=i.receita;
  this.transferencia=i.transferencia;
  this.outrarec=i.outrarec;
  this.despesadoc=i.despesadoc;
  this.despesatec=i.despesatec;
  this.despesaenc=i.despesaenc;
  this.despesacus=i.despesacus;
  this.despesainv=i.despesainv;
  this.despesapes=i.despesapes;
  this.despesaout=i.despesaout;

}//clone

void imprimir(){
  MyIO.println(codigo+" "+nome+" "+sigla+" "+codman+" "+mant+" "+categoria+" "+org+" "+codmu+" "+municipio
              +" "+uf+" "+regiao+" "+tecnico+" "+periodico+" "+livro+" "+receita+" "+transferencia+" "+outrarec
              +" "+despesadoc+" "+despesatec+" "+despesaenc+" "+despesacus+" "+despesainv+" "+despesaout
               +" "+despesapes);
}//imprimir()

/**
  *Metodo para ler um arquivo e retirar as informações da instituição
  *@param valor String contendo codigo da instituição
  */
void ler(String valor){
    //dados
    String dado="";
    String cod="";
    String tmp="";
    boolean controle=false;
    int t=valor.length();
    int tc=0;
    int c=0;
    //abrir arquivo
    Arq.openRead("/tmp/censo.dat", "ISO8859-1");

        for(c=-1; c<Integer.parseInt(valor); c++){ dado=Arq.readLine(); }
        for(c=0; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c);}
        codigo=Integer.parseInt(tmp); tmp="";
        c++;

               for(c=c; dado.charAt(c)!='\t'; c++){ /*MyIO.print(dado.charAt(c));*/ nome+=dado.charAt(c); }//for
            //MyIO.println(nome+"\n");
                c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ sigla+=dado.charAt(c); }//for
            //MyIO.println(sigla+"\n");

            c++;


            for(c=c; dado.charAt(c)!='\t'; c++){tmp+=dado.charAt(c); }//for
            //MyIO.println(tmp+"\n");
            codman=Integer.parseInt(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ mant+=dado.charAt(c); }//for
            //MyIO.println(mant+"\n");
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            categoria=Integer.parseInt(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            org=Integer.parseInt(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            codmu=Integer.parseInt(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ municipio+=dado.charAt(c); }//for
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ uf+=dado.charAt(c); }//for
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ regiao+=dado.charAt(c); }//for
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            tecnico=Integer.parseInt(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            periodico=Integer.parseInt(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            livro=Integer.parseInt(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            receita= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            transferencia= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            outrarec= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            despesadoc= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            despesatec= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            despesaenc= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            despesacus= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            despesainv= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; dado.charAt(c)!='\t'; c++){ tmp+=dado.charAt(c); }//for
            despesaout= Double.parseDouble(tmp); tmp="";
            c++;

            for(c=c; c<dado.length(); c++){ tmp+=dado.charAt(c); }//for
            despesapes= Double.parseDouble(tmp); tmp="";
      //}//if
      cod="";
    //}//for
}//ler



/**
 *Metodo para verificar se duas String são iguais
 *@author Joao Marcos Aguiar Alves
 *@param a - String
 *@param b - String
 *@return resposta
 */
 boolean Equals(String a, String b){
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

}//class

class Lista extends Inst{
  //atributos
  private int n;
  private Inst []vetor;
  //

  //GETS
  int get_n(){ return(n);}
  //



//CONSTRUTORES
public Lista(){
  n=0;
  vetor=new Inst[10];
  for(int c=0; c<10; c++){ vetor[c]=new Inst(); }

}

public Lista(int tam){
  if(tam<=0){MyIO.println("Erro"); }
  n=0;
  vetor=new Inst[tam];
  for(int c=0; c<tam; c++){ vetor[c]=new Inst(); }

}
  //METODOS
  /**
    *Metodo para inserir um elemento no inicio do Vetor
    *@param i Instituicao a ser inserida
    */
  void inseririnicio(Inst i){
    if(n==vetor.length){ MyIO.println("Vetor cheio");}
    else{
      for(int c=n+1; c>0; c--){//mover todos os elementos para frente
        vetor[c].clone(vetor[c-1]);
      }//for
      vetor[0].clone(i);
      n++;
    }//else
  }//inseririnicio

  /**
    *Metodo para inserir um elemento no fim do Vetor
    *@param i Instituicao a ser inserida
    */
  void inserirfim(Inst i){
    if(n==vetor.length){MyIO.println("Vetor cheio"); }
    else{
      vetor[n].clone(i);
      n++;
    }//else
  }//inserirfim

  /**
    *Metodo para inserir um elemento no fim do Vetor
    *@param i Instituicao a ser inserida
    */
  void inserir(Inst i, int pos){
    if(n==vetor.length || pos<0 || pos>n){ MyIO.println("ERRO");}
    else{
      for(int c=n+1; c>pos; c--){
        vetor[c].clone(vetor[c-1]);
      }//for
      vetor[pos].clone(i);
      n++;
    }//else
  }//inserir


/**
  *Metodo para remover elemento do inicio do vetor
  *@return elemento removido
  */
Inst removerini(){
  Inst r=new Inst();
  if(n==0){MyIO.println("Vetor vazio"); }
  else{
    r.clone(vetor[0]);
    for(int c=0; c<n; c++){
      vetor[c].clone(vetor[c+1]);
    }//for
    vetor[n]=new Inst();
    n--;
  }//else
  return(r);
}//removerini

/**
  *Metodo para remover elemento do fim do vetor
  *@return elemento removido
  */
  Inst removerfim(){
    Inst r=new Inst();
    if(n==0){ MyIO.println("Vetor vazio");}
    else{
      r.clone(vetor[n-1]);
      vetor[n]=new Inst();
      n--;
    }//else
    return(r);
  }//remover

  /**
    *Metodo para remover elemento do vetor
    *@return elemento removido
    */
    Inst remover(int pos){
      Inst r = new Inst();
      if(n==0 || pos>n || pos<0){ MyIO.println("ERRO");}
      else{
        r.clone(vetor[pos]);
        for(int c=pos; c<n; c++){
          vetor[c].clone(vetor[c+1]);
        }//for
        n--;
      }//else
      return(r);
    }//remover

void imprimir(){
  int c=0;
  while(c<n){ vetor[c].imprimir(); c++; }
}

void imprimirR(){
  int c=0;
  while(c<n){MyIO.println("(R) "+vetor[c].get_sigla()); c++; }
}

//METODOS DE PESQUISA

/**
  *Metodo para realizar pesquisa sequencial em um vetor de instiuições
  *@param sigla atributo a ser pesquisado
  *@return true ou false
  */
boolean pesqseq(String sigla){
  boolean resp=false;
  for(int c=0; c<n; c++){
    if(Equals(vetor[c].get_sigla(), sigla)){ resp=true; c=n;}
  }
  return(resp);
}

boolean pesqbin(String sigla){
  return(pesqbin(sigla, 0, n-1));
}
boolean pesqbin(String sigla, int esq, int dir){
  //MyIO.println(esq+" "+dir);
  boolean resp=false;
  if(resp==false && esq!=dir && esq<dir){
    int c=vetor[esq+((dir-esq)/2)].get_sigla().compareTo(sigla);
    //MyIO.println(vetor[esq].get_sigla()+" "+vetor[dir].get_sigla());
    //MyIO.println(vetor[esq+((dir-esq)/2)].get_sigla()+" "+sigla);
    resp=(c==0);
    //MyIO.println(c);
    if(c>0){  resp=pesqbin(sigla, (esq+((dir-esq)/2))+1, dir);}
    else if(c<0){  resp=pesqbin(sigla, esq, esq+((dir-esq)/2)-1); }


  }//while
  return resp;
}//pesqbin

//METODOS DE ORDENAÇÃO
/**
  *Metodo para trocar a posição de dois elementos no Vetor
  *@param p1 posição do elemento
  *@param p2 posição do outro elemento
  */
void swap(int p1, int p2){
  Inst i1=new Inst();
  i1.clone(vetor[p1]);
  vetor[p1].clone(vetor[p2]);
  vetor[p2].clone(i1);
}//swap

/**
  *Metodo para realizar ordenação por seleção
  */
void selecao(){
  int c1,c2;
  for(c1=0; c1<n-1; c1++){
    int menor=c1;
    for(c2=c1+1; c2<n; c2++){
      if(vetor[c2].get_codigo()<vetor[menor].get_codigo()){
        menor=c2;
      }
    }//for
    swap(c1, menor);
  }//for
}//selecao

void selecaoR(){
  selecaoR(0, 1, 0);
}

void selecaoR(int c1, int c2, int menor){
  if(c1<n-1){
    for(; c2<n; c2++){
      if(vetor[c2].get_codigo()<vetor[menor].get_codigo()){ menor=c2; }
    }
    swap(c1, menor);
    selecaoR(c1+1, c1+2, c1+1);
  }
}//selecao

/**
  *Metodo de ordenaçao por inserçao
  *Consiste em dividir o vetor em duas partes, uma ordenada e uma não ordenada
  *Pega-se um elemento da parte não ordenada, o compara com os elementos da parte ordenada
  *e o insere na posição correta
  */
void insercao(){
  Inst i1=new Inst();
  int c=1;
  int c2=0;
  for(; c<n; c++){
    i1.clone(vetor[c]);
    while(c2>=0 && vetor[c2].get_codman()>i1.get_codman()){
      vetor[c2+1].clone(vetor[c2]);
      c2--;
    }
    vetor[c2+1].clone(i1);
  }
}//inserçao


void heapsort(){
  for(int t=2; t<=n; t++){
    constroi(t);
  }
  t=n;
  while(t>1){
    swap(1, t--);
    desconstroi(t);
  }
}
/**
  *Metodo de construçao do heap
  *@param tam ultima posição do vetor
  *Compara a posição atual com seu "pai" e caso seja maior, troca suas posições
  */
private void constroi(int tam){
  for(int c=t; c>1 && vetor[c].get_codmu()>vetor[c/2].get_codmu(); c/=2 ){
    swap(c, c/2);
  }
}//constroi

/**
  *Metodo de desconstrução do heap
  *onde de fato ocorre a ordenação
  *@param tam tamanho da parte não desconstruida
  *pega-se o último elemento inserido e o troca de posição com a raiz
  *(maior elemento vai para a ultima posição)
  *ordena-se o heap restante e reinicia o procedimento ate que tam seja igual a 1
  */
private void desconstroi(int tam){
  int i=1, f;
  while(i<=tam/2){
    f=getmaior(i, tam);//pega maior dos filhos
    if(vetor[i].get_codmu()<vetor[filho].get_codmu()){//caso filho seja maior que o pai, trocar posições
      swap(i, f);
      i=f;
    }//if
    else{
      i=tam;
    }//else
  }//while
}//desconstroi()

/**
  *Metodo para pegar o maior filho de um elementos
  *@param i posiçao do elemento
  *@param tam tamanho do heap
  */
private int getmaior(int i, int tam){
  int f=0;
  if(2*i==tam || vetor[2*i].get_codmu()> vetor[(2*i)+1].get_codmu()){//caso so tenha um filho ou filho da esquerda maior
    f=2*i;
  }
  else{ f=(2*i)+1; }
}



}//class

public class TP1Q10{

  /**
   *Metodo para verificar se duas String são iguais
   *@author Joao Marcos Aguiar Alves
   *@param a - String
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

public static void main(String[]args){
  String valor="";
  String tmp="";
  String pos="";
  int c=0;
  int c2=0;
  Inst i1=new Inst();
  Lista l1= new Lista(1000);
  Lista r1=new Lista(100);
  for(valor=MyIO.readLine(); Equals(valor, "0")==false; valor=MyIO.readLine()){
    i1.ler(valor);
    l1.inserirfim(i1);
    //i1.imprimir();
    i1=new Inst();
  }//for
  l1.insercao();
  l1.imprimir();
}//main


}//class
