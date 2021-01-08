/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
  */
class TP01Q12{

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
  *Metodo iterativo para verificar se uma String é palindromo
  *@param String a ser analisada
  *return true ou false
  */
public static boolean Palindromo(String x){
//inverter String
String xinv="";
for(int c=x.length()-1; c>=0; c--){
xinv+=x.charAt(c);
}//for

return(Palindromo(x, xinv, 0));

}//Palindromo

/**
  *Metodo recursivo para verificar se uma String e palindromo
  *@param String a ser analisada
  *@param String invertida para fazer a comparacao
  *@param posicao a ser analisada
  *return true ou false
  */
public static boolean Palindromo(String x, String xinv, int p){

boolean resp =(x.charAt(p) == xinv.charAt(p));

if(p<x.length()-1 && resp==true){//se p igual ao tamanho ou ja foi encontrado um caractere diferente, interromper a recursividade

//MyIO.println(x.charAt(p)+" é igual a "+xinv.charAt(p)+(x.charAt(p) == xinv.charAt(p)));
//resp = (x.charAt(p) == xinv.charAt(p));
resp=Palindromo(x, xinv, p+1);

}//if


return (resp);
}//Palindromo


public static void main (String [] args){

String x;
for(x=MyIO.readLine(); Equals(x, "FIM")==false; x=MyIO.readLine()){

if(Palindromo(x)==true){
MyIO.println("SIM");
}//if
else{
MyIO.println("NAO");
}//else
}//for


}//main()



}//class
