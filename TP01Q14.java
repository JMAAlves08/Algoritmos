/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
   */

import java.util.Random;
class TP01Q14{


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
  *Metodo para gerar dois caracteres aleatorios e recursivamente, subtituir o primeiro pelo seguno em uma String
  *@param String a ser analisada
  *return String modificada
  */
public static String Alteracao(String x){

Random r1= new Random();
r1.setSeed(4);
/*gerar caracteres aleatorios e passa-los como parametros para o metodo recursivo*/
char p=( char ) ( 'a' + (Math.abs ( r1.nextInt ( ) ) % 26 ) );
char s=( char ) ( 'a' + (Math.abs ( r1.nextInt ( ) ) % 26 ) );

return(Alteracao(x, p, s, 0));
}//Alteracao

/**
  *Metodo recursivo para realizar substituicao de um caractere por outro em uma String
  *@param String a ser modificada
  *@param char a ser buscado
  *@param char que substituira o encontrado
  *@param posicao da String a ser analisada
  *return String modificada
  */
public static String Alteracao(String x, char p, char s, int pos){

String resp="";

if(pos<x.length()){

if(x.charAt(pos)==p){
resp+=s+Alteracao(x, p, s, pos+1);

}//if
else{
resp+=x.charAt(pos)+Alteracao(x, p, s, pos+1);
}//else
}//if
return(resp);
}//Alteracao

public static void main (String [] args){

String x;

for(x=MyIO.readLine(); Equals(x, "FIM")==false; x=MyIO.readLine()){

MyIO.println(Alteracao(x));
}//for

}//main()


}//class
