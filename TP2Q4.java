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
void imprimirR(){ MyIO.println("(R) "+nome);}

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

class CelulaDupla extends Inst{
  //attributos
  private Inst elemento;
  private CelulaDupla prox, ant;

  //construtor
  public CelulaDupla(){
    this(null);
  }

  public CelulaDupla(Inst i){
    elemento=i;
    prox=ant=null;
  }

  CelulaDupla get_prox(){
    return(prox);
  }
  void set_prox(CelulaDupla c){
    prox=c;
  }
  CelulaDupla get_ant(){ return(ant); }
  void set_ant(CelulaDupla c){ant=c;}

  Inst get_elemento(){ return(elemento); }
  void set_elemento(Inst i){ this.elemento=i;}
}//class

class Lista extends CelulaDupla{
  private CelulaDupla p, u;

  public Lista(){
    p=u=new CelulaDupla();
  }
   void inf(Inst i){
    u.set_prox(new CelulaDupla(i));
    u.get_prox().set_ant(u);
    u=u.get_prox();
  }

  void ini(Inst i){
    CelulaDupla tmp=new CelulaDupla(i);
    tmp.set_prox(p.get_prox());
    tmp.get_prox().set_ant(tmp);
    p.set_prox(tmp);
    p.get_prox().set_ant(p);
    tmp=null;
  }

  void inp(Inst i, int p){
    int c;
    CelulaDupla tmp=this.p.get_prox();
    CelulaDupla t=new CelulaDupla();
    for(c=0; tmp!=null; c++, tmp=tmp.get_prox());//pegar quantidade de elementos
    if(p<0 || p>c){ MyIO.println("ERRO");}
    else{
      tmp= new CelulaDupla(i);
      t=(this.p.get_prox());
      for(int ct=0; ct<p-1; ct++, t=t.get_prox());
      tmp.set_prox(t.get_prox());
      tmp.get_prox().set_ant(tmp);
      t.set_prox(tmp);
      t.get_prox().set_ant(t);
      tmp=null;
      t=null;
    }

  }//inserir

  Inst ri(){
    CelulaDupla tmp=p.get_prox();
    p.set_prox(p.get_prox().get_prox());
    p.get_prox().set_ant(p);
    Inst i=new Inst();
    i.clone(tmp.get_elemento());
    tmp.set_prox(null);
    tmp.set_ant(null);
    tmp=null;
    return(i);

  }//ri

  Inst rf(){
      CelulaDupla t=p;
      for(t=p; t.get_prox()!=u; t=t.get_prox());
      Inst r=u.get_elemento();
      t.get_prox().set_ant(null);
      t.set_prox(null);
      u=t;
      t=null;
       return(r);
  }//rf

  Inst r(int x){
    CelulaDupla t=p.get_prox();
    Inst i = new Inst();
    int c=0;
    for(c=0; t!=null; t=t.get_prox(), c++);
    if(x<0 || x>c){MyIO.println("ERRO");}
    else{
        t=p.get_prox();
        for(c=0; c<x-1; c++, t=t.get_prox());
        i=t.get_prox().get_elemento();
        CelulaDupla tmp=t.get_prox();
        t.set_prox(tmp.get_prox());
        t.get_prox().set_ant(t);
        tmp.get_prox().set_ant(null);
        tmp.set_prox(null);
        tmp=null;
        t=null;
    }
    return(i);
  }

  void mostrar(){
    for(CelulaDupla tmp=p.get_prox(); tmp!=null; tmp=tmp.get_prox()){
      tmp.get_elemento().imprimir();
    }
  }
  void mostrarR(){
    for(CelulaDupla tmp=p.get_prox(); tmp!=null; tmp=tmp.get_prox()){
      tmp.get_elemento().imprimirR();
    }
  }

}


public class TP2Q4{
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
    Lista l1 = new Lista();
    Inst i1= new Inst();
    String linha="";
    String valor="", tmp="", pos="";
    int c=0; int c2=0;
    for(linha=MyIO.readLine(); Equals(linha, "0")==false; linha=MyIO.readLine()){
      i1.ler(linha);
      l1.inf(i1);
      i1=new Inst();
    }

    l1.mostrar();
  }
}
