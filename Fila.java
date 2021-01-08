/**
 * Fila estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Fila {
   private int[] array;
   private int primeiro; // Remove do indice "primeiro".
   private int ultimo; // Insere no indice "ultimo".


   /**
    * Construtor da classe.
    */
   public Fila () {
      this(6);
   }


   /**
    * Construtor da classe.
    * @param tamanho Tamanho da fila.
    */
   public Fila (int tamanho){
      array = new int[tamanho+1];
      primeiro = ultimo = 0;
   }


   /**
    * Insere um elemento na ultima posicao da fila.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a fila estiver cheia.
    */
   public void inserir(int x) throws Exception {
   
      //validar insercao
      if (((ultimo + 1) % array.length) == primeiro) {
         throw new Exception("Erro ao inserir!");
      }
   
      array[ultimo] = x;
      ultimo = (ultimo + 1) % array.length;
   }


   /**
    * Remove um elemento da primeira posicao da fila e movimenta 
    * os demais elementos para o primeiro da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a fila estiver vazia.
    */
   public int remover() throws Exception {
   
      //validar remocao
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover!");
      }
   
      int resp = array[primeiro];
      primeiro = (primeiro + 1) % array.length;
      return resp;
   }


   /**
    * Mostra os array separados por espacos.
    */
   public void mostrar (){
      System.out.print("[ ");
   
      for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)) {
         System.out.print(array[i] + " ");
      }
   
      System.out.println("]");
   }

   /**
    * Retorna um boolean indicando se a fila esta vazia
    * @return boolean indicando se a fila esta vazia
    */
   public boolean isVazia() {
      return (primeiro == ultimo); 
   }
   
   public boolean pesqbin(int elemento){
      return(pesqbin(primeiro, ultimo, elemento));
   }
   
   /**
     *Metodo de pesquisa binaria em uma fila circular
     */
   private boolean pesqbin(int p, int u, int elemento){
      boolean resp=false;
      if(p>=0 && u>=0){
         int m=p;
         int c=0;
         boolean ct=false; 
      //pegar tamanho do vetor
         for(c=0; m!=u; m=(m+1)%array.length, c++);
         m=p+(c/2);//elemento do meio
         if(array[m]==elemento){ resp=true;} //elemento encontrado
         else if(resp==false && (p==u)){resp=(array[p]==elemento); }
         else{
            if(array[m]>elemento){ resp=pesqbin(p, (m-1)%array.length, elemento); }
            else if(array[m]<elemento) { resp=pesqbin((m+1)%array.length, u, elemento);}
         }
      }
      return(resp);
   }//pesqbin
}








