/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
  */

class TP01Q013{



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
  *Inicializador do Metodo recursivo de Ciframento
  *@param String a ser codificada
  *return String modificada
  */
public static String Ciframento(String x){

return(Ciframento(x, 0));
}//Ciframento()

/**
  *Metodo recursivo para codificar uma mensagem utilizando ciframento de Cesar
  *@param String a ser codificada
  *@param posicao a ser analisada
  *return String modificada
  */
public static String Ciframento(String x, int pos){

String resp="";

if(pos<x.length()){//enquanto nao percorrer toda String
int ch=(int)x.charAt(pos)+3;//(codigo ascII+3)

resp+=((char)ch)+(Ciframento(x, pos+1));

}//if
return(resp);
}//Ciframento()

public static void main (String [] args){

String x;

for(x=MyIO.readLine(); Equals(x, "FIM")==false; x=MyIO.readLine()){

MyIO.println(Ciframento(x));
}//for

}//main()


}//class
