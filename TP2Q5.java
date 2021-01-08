/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
  */

class CelulaM{
  //attributos
  private int elemento;
  private CelulaM prox, ant, sup, inf;

  //construtor
  public CelulaM(){
    this(0);
  }

  public CelulaM(int i){
    elemento=i;
    prox=ant=inf=sup=null;
  }

  CelulaM get_prox(){
    return(prox);
  }
  void set_prox(CelulaM c){
    prox=c;
  }
  CelulaM get_ant(){return(ant);}
  void set_ant(CelulaM ant){ this.ant=ant; }
  CelulaM get_sup(){return(sup);}
  void set_sup(CelulaM c){sup=c;}
  CelulaM get_inf(){return(inf);}
  void set_inf(CelulaM c){inf=c;}

  int get_elemento(){ return(elemento); }
  void set_elemento(int i){ this.elemento=i;}
}//class

class Matriz extends CelulaM{
  private CelulaM i;//inicio
  private int linha, coluna;

  public Matriz(int l, int c){
    linha=l;
    coluna=c;
    i=new CelulaM();
    CelulaM tmp=i;

    //criar colunas
    for(int ct=1; ct<c; ct++){
      tmp.set_prox(new CelulaM());
      tmp.get_prox().set_ant(tmp);
      tmp=tmp.get_prox();
    }
    CelulaM tl=i;
    CelulaM tc=i;
    int cc=0;
    int cl=0;
    for(cl=1; cl<l; cl++){
       tl.set_inf(new CelulaM());
       tl.get_inf().set_sup(tl);
       tc=tl.get_inf();
       for(cc=1; cc<c; cc++){
          tc.set_prox(new CelulaM());
          tc.get_prox().set_ant(tc);
          tc.get_sup().get_prox().set_inf(tc.get_prox());
          tc.get_prox().set_sup(tc.get_sup().get_prox());
          tc=tc.get_prox();
          //MyIO.println("LINHA");

       }
       tl=tl.get_inf();
       //MyIO.println("SAIU");
    }
  }//construir()

  void dp(){
    if(linha==coluna){
      dp(i);
    }
  }
  void dp(CelulaM c){
    MyIO.println(c.get_elemento());
    c=c.get_prox();
      if(c!=null){
        dp(c.get_inf());
      }
  }

  void ds(){
    if(linha==coluna){ 
      CelulaM t=new CelulaM();
      for(t=i; t.get_prox()!=null; t=t.get_prox());
      ds(t);
    }
  }
  void ds(CelulaM t){
    MyIO.println(t.get_elemento());
    t=t.get_ant();
    if(t!=null){
      ds(t.get_inf());
    }
  }

  Matriz soma(Matriz m){
    CelulaM tt=i; CelulaM tt2=i;
    CelulaM ts=m.i; CelulaM ts2=m.i;
    Matriz r =new Matriz(linha,coluna);
    if(m.linha==linha && m.coluna==coluna){
      CelulaM tr=r.i; CelulaM tr2=r.i;
      while(tt2!=null && ts2!=null){
        for(tt=tt2, ts=ts2; tt!=null && ts!=null; tt=tt.get_prox(), ts=ts.get_prox() ){
          tr.set_elemento(tt.get_elemento()+ts.get_elemento());
          tr=tr.get_prox();
        }
        tt2=tt2.get_inf();
        ts2=ts2.get_inf();
        tr2=tr2.get_inf();
        tr=tr2;
      }
    }
    return(r);
  }//soma

  void inserir(int[] e){
    CelulaM t=i;
    CelulaM t2=i;
    int c=0;
    while(t2!=null){
      t=t2;
      while(t!=null){
        t.set_elemento(e[c]);
        c++;
        t=t.get_prox();
      }
      t2=t2.get_inf();
    }
  }//inserir

  void mostrar(){
    CelulaM l=i;
    CelulaM c=i;
    while(l!=null){
      c=l;
      while(c!=null){
        MyIO.print(c.get_elemento()+"\t");
        c=c.get_prox();
      }
      MyIO.println("\n");
      l=l.get_inf();
    }
  }
}//class


public class TP2Q5{
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
    String arq=MyIO.readLine();//quantidade de testes
    int ctr=0;
    for(int q=0; q<Integer.parseInt(arq); q++){
      int l=Integer.parseInt(MyIO.readLine());
      int c=Integer.parseInt(MyIO.readLine());
      Matriz m1=new Matriz(l, c);
      ctr=0;
      int ct=0;
      int[]elementos=new int[l*c];
      int pe=0;
      for(ct=0; ct<l; ct++){
        String e=MyIO.readLine();
        for(int p=0; p<e.length(); p++){
          if(e.charAt(p)>='0' && e.charAt(p)<='9'){ elementos[pe]=((int)(e.charAt(p)-48)); pe++;}
        }
      }
      m1.inserir(elementos);
      l=Integer.parseInt(MyIO.readLine());
      c=Integer.parseInt(MyIO.readLine());
      Matriz m2=new Matriz(l, c);
      ctr=0;
      ct=0;
      elementos=new int[l*c];
      pe=0;
      for(ct=0; ct<l; ct++){
        String e=MyIO.readLine();
        for(int p=0; p<e.length(); p++){
          if(e.charAt(p)>='0' && e.charAt(p)<='9'){ elementos[pe]=((int)(e.charAt(p)-48)); pe++; }
        }
      }
      //m2.inserir(elementos);
      //MyIO.println("PRIMEIRA MATRIZ");
      //m1.dp();
      //m1.ds();
      //MyIO.println("SEGUNDA MATRIZ");
      //m2.dp();
      //m2.ds();
      Matriz m3=m1.soma(m2);
      MyIO.println("SOMA");
      (m1.soma(m3)).mostrar();
    }
  
  }
}
