/**
  *@author João Marcos Aguiar Alves
  *Matricula: 60092
  */

class TP01Q15{


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
  *Metodo para determinar se uma String é composta apenas por vogais, consoantes, inteiros ou reais
  *@param String a ser analisada
  *return SIM ou NAO para cada tipo
  */
public Static String Is(String x){


}//Is

}//class
