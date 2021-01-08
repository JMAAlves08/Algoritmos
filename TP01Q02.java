/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
  */
class TP01Q02{

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
  *Metodo para verificar se uma String é Palindromo
  *@param x String a ser analisada
  *@return "SIM" caso seja palindromo, "NAO" caso contrario
  */
public static String Palindromo(String x){
//dados
String resp="";
String inv="";
int t=x.length();
//

//inverter String parametro
for(t=x.length()-1; t>=0; t--) inv+=x.charAt(t);

//verificar se ambas sao iguais
//MyIO.println (x+"    "+inv);
if(Equals(x, inv)==true) resp="SIM";

else{ resp="NAO"; }
return(resp);
}//Palindromo()

public static void main (String [] args){

String x="";
for(x=MyIO.readLine(); Equals(x, "FIM")== false; x=MyIO.readLine()) MyIO.println(Palindromo(x));

}//main()

}//class
