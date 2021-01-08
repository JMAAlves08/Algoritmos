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

class Filac extends Inst{
  //atributos
  private int p, u;
  private Inst []vetor;
  //




//CONSTRUTORES
public Filac(){
  p=0; u=0;
  vetor=new Inst[6];
  for(int c=p; (c+1)%vetor.length!=u; c=(c+1)%vetor.length){ vetor[c]=new Inst(); }

}

public Filac(int tam){
  if(tam<=0){MyIO.println("Erro"); }
  p=0; u=0;
  vetor=new Inst[tam+1];
  for(int c=0; (c+1)%vetor.length!=u; c=(c+1)%vetor.length){ vetor[c]=new Inst(); }

}
  //METODOS

/**
  *Metodo para retornar a media de despesa docente dos elementos na fila
  *return media
  */
int media(){
int ct=0;
double valor=0;
for(int c=p; (c)%vetor.length!=u; c=(c+1)%vetor.length){ valor+=vetor[c].get_despesadoc(); ct++; }//for

return((int)Math.round((valor/ct)));
}//media

  /**
    *Metodo para inserir um elemento no fim do Vetor
    *@param i Instituicao a ser inserida
    */
  void inserirfim(Inst i){
    Inst t=new Inst();
    t=i;
    //MyIO.println(u);
    if((u+1)%vetor.length==p){ removerini();  }
      vetor[u]=t;
      u=(u+1)%vetor.length;
      MyIO.println(media());

  }//inserirfim



/**
  *Metodo para remover elemento do inicio do vetor
  *@return elemento removido
  */
Inst removerini(){
  Inst r=new Inst();
  if(p==u){MyIO.println("Vetor vazio"); }
  else{
    r.clone(vetor[p]);
    vetor[p]=new Inst();
    p=(p+1)%vetor.length;
  }//else
  return(r);
}//removerini



void imprimir(){
  int c=p;
  while((c+1)%vetor.length!=p){ vetor[c].imprimir(); c=(c+1)%vetor.length; }
}

void imprimirR(){
  int c=p;
  while((c+1)%vetor.length!=p){MyIO.println("(R) "+vetor[c].get_nome()); c=(c+1)%vetor.length; }
}

}//class

public class TP1Q4{

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
  int q=0;
  Inst i1=new Inst();
  Filac f1= new Filac();
  //Filac r1=new Filac(100);
  for(valor=MyIO.readLine(); Equals(valor, "0")==false; valor=MyIO.readLine()){
    i1.ler(valor);
    f1.inserirfim(i1);
    i1=new Inst();
  }//for
  valor=MyIO.readLine();
  q=Integer.parseInt(valor);
  for(c=0; c<q; c++ ){
    valor=MyIO.readLine();
    if(valor.charAt(0)=='I'){
      for(c2=2; c2<valor.length(); c2++){ tmp+=valor.charAt(c2);}
      i1.ler(tmp);
      f1.inserirfim(i1); tmp="";
      i1=new Inst();
    }
    else{
      f1.removerini();
      //MyIO.println(f1.media());
    }
  }


}//main


}//class
