/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
  */
public class TP01Q01{


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
  *Metodo para contar quantidade de caracteres maiusculos em uma String
  *@param String a ser analisada
  *@return quantidade de maiusculas
  */
public static int Maiusculas(String x){
//dados
int t=x.length();
int q=0;
//

//percorrer toda a String 
for(int c=0; c<t; c++){
if('A' <= x.charAt(c) && x.charAt(c) <='Z') q++;//se caractere maiusculo, somar 1 ao contador
}//for
return (q);
}//Maiusculas

public static void main (String [] args){

String x="";
for(x=MyIO.readLine(); Equals(x, "FIM")==false; x=MyIO.readLine()){ //continuar lendo do arquivo ate encontrar "FIM"
MyIO.println(Maiusculas(x));
}//for


}//main()

}//class
