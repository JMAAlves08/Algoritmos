import java.util.Scanner;

class Fatorial{

/**
  *Metodo para calcular fatorial de um inteiro
  *@param valor a ser calculado
  *@return resultado do fatorial
  */
public static int Fatorial(int valor){

//dados
String operacao="";
int resposta=1;

while(valor>1){//executar ate que valor seja igual a 1

resposta=resposta*valor;//multiplicando o valor pela resposta ja existente
operacao+=Integer.toString(valor)+"*";

valor=valor-1;//diminuir valor em 1 a cada multiplicação

}//while

System.out.println(operacao+"="+Integer.toString(resposta));
return(resposta);
}//Fatorial()
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

/**
  *Metodo para verificar se uma String esta contida dentro de outra
  *@param String onde sera feita a busca
  *@param String a ser procurada
  *return true ou false
  */
public static boolean Contains(String a, String b){
MyIO.println("CONTAINS");
int i=0, f=b.length();
boolean resp=false;
int c=0;

while(f<a.length() && resp==false){//enquanto String 'a' puder ser subdividida
String piece="";

for(c=i; c<f; c++){//criar String com o "pedaco" de 'a'
piece+=a.charAt(c);
}//for
MyIO.println(i+"  "+f);
MyIO.println(piece);
resp=Equals(b, piece);
i++;
f++;
}//while
return(resp);
}//contains()



public static void main (String[]args){

String a="algo alem do abacate";
String b="do ";

MyIO.println(Contains(a, b));


}//main()

}//class
       
