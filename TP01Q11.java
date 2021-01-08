/**
  *@author João Marcos Aguiar Alves
  *Matricula 600092
  */
class TP01Q11{



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
  *Parte iterativa do metodo de contar letras maiusculas
  *@param String a ser analisada
  *return inicializa a parte recursiva do metodo
  */
public static int Maiusculas(String x){
return(Maiusculas(x, 0));
}//Maiusculas

/**
  *Metodo recursivo para contar quantidade de maiusculas em uma String
  *@param String a ser analisada
  *@param posicao inicial da analise
  *return quantidade de maiusulas
  */
public static int Maiusculas(String x, int p){

int resp=0;
//MyIO.println("VALOR DE P: "+p);
//MyIO.println(x.length());


if(p<x.length()){
if(x.charAt(p)>='A' && x.charAt(p)<='Z'){
resp+=1;

}//if

resp+=(Maiusculas(x, p+1));

}//while

return(resp);
}//Maiusculas()

public static void main (String [] args){

String x;

for(x=MyIO.readLine(); Equals(x, "FIM")==false; x=MyIO.readLine()){

MyIO.println(Maiusculas(x));

}//for


}//main()

}//class
