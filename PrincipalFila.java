import java.util.Scanner;

/**
 * Fila estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalFila {
   public static void main(String[] args) throws Exception {
      System.out.println("==== FILA ESTATICA ====");
      Fila fila = new Fila();
      int x1, x2, x3=0;
      Scanner s1 = new Scanner(System.in);
      System.out.print("Vetor de 1 a 5(1) Dados escolhidos(2) ");
      int op=s1.nextInt();
      System.out.println();
      switch(op){
         case 1:
            fila.inserir(1);
            fila.inserir(2);
            fila.inserir(3);
            fila.inserir(4);
            fila.inserir(5);
            break;
         case 2:
            System.out.print("Quantidade (ate 5): ");
            x1=s1.nextInt();
            for(x2=0; x2<x1; x2++){ fila.inserir(s1.nextInt()); }
            break;
      }
      System.out.println("Pesquisas: (99)=stop ");    
      do{
         x3=s1.nextInt();
         if(x3!=99){System.out.println(fila.pesqbin(x3));}
      }while(x3!=99);
   
   
   
   }
}
