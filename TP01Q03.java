/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
  */
class TP01Q03{

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
  *Metodo para transformar uma String usando ciframento de Cesar
  *@param String a ser modificada
  *@return String modificada
  */
public static String Ciframento(String x){
//dados
int t=x.length();
String code="";
//

//percorrer toda a String
for(int c=0;c<t; c++){
code+=(char)((int)x.charAt(c)+3);//somar 3 ao valor inteiro do caractere e depois reconvertê-lo adicionando-o a String
}//for
return(code);
}//Ciframento()

public static void main (String [] args){

String x="";
for(x=MyIO.readLine(); Equals(x, "FIM") == false; x=MyIO.readLine()){
MyIO.println(Ciframento(x));
}//for

}//main()

}//class
