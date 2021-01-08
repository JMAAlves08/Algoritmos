/**
  *@author João Marcos Aguiar Alves
  *Matricula: 6000092
  */
class TP01Q06{


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
  *Metodo para dizer se uma String e composta apenas por vogais
  *@param String a ser analisada
  *@return "SIM" para positivo, "NAO" para negativo
  */
public static String Vogal(String x){
//dados
String resp="SIM";
//

for(int c=0; c<x.length(); c++){
if(x.charAt(c)!= 'a' || x.charAt(c)!= 'e' || x.charAt(c)!= 'i' || x.charAt(c)!='o' || x.charAt(c)!='u' ||
   x.charAt(c)!= 'A' || x.charAt(c)!= 'E' || x.charAt(c)!= 'I' || x.charAt(c)!='O' || x.charAt(c)!='U'){

resp="NAO";
c=x.length();
}//if
}//for
return(resp);
}//Vogal()

/**
  *Metodo para verificar se uma String é composta apenas por numeros inteiros
  *@param String a ser analisada
  *@return "SIM" para positivo, "NAO" para negativo
  */
public static String NumeroI(String x){
String resp="SIM";

for(int c=0; c<x.length(); c++){
if(!('0'<= x.charAt(c) && x.charAt(c)<='9')){
resp="NAO";
c=x.length();
}//if
}//for
return(resp);
}//Numero()


/**
  *Metodo para verificar se uma String é composta apenas por numeros reais
  *@param String a ser analisada
  *@return "SIM" para positivo, "NAO" para negativo
  */
public static String NumeroR(String x){
String resp="SIM";

for(int c=0; c<x.length(); c++){
if(!('0'<= x.charAt(c) && x.charAt(c)<='9' || x.charAt(c)==',')){
resp="NAO";
c=x.length();
}//if
}//for
return(resp);
}//Numero()

/**
  *Metodo para verificar se uma String é composta apenas por consoantes
  *@param String a ser analisada
  *@return "SIM" para positivo, "NAO" para negativo
  */
public static String Consoante(String x){
//dados
String resp="SIM";

//percorrer toda a String
for(int c=0; c<x.length(); c++){
if(!(('b'<=x.charAt(c) && 'd'>=x.charAt(c)) || ('f'<= x.charAt(c) && 'h'>=x.charAt(c)) || ('j'<=x.charAt(c) && 'n'>=x.charAt(c)) || 
	 ('p'<=x.charAt(c) && 't'>=x.charAt(c)) || ('v'<= x.charAt(c) && 'z'>=x.charAt(c)) ||
	 ('B'<=x.charAt(c) && 'D'>=x.charAt(c)) || ('F'<= x.charAt(c) && 'H'>=x.charAt(c)) || ('J'<=x.charAt(c) && 'N'>=x.charAt(c)) || 
	 ('P'<=x.charAt(c) && 'T'>=x.charAt(c)) || ('V'<= x.charAt(c) && 'Z'>=x.charAt(c)))){
resp="NAO";
c=x.length();
}//if
}//for
return(resp);
}//Consoante()

public static void main (String [] args){
String x="";
for(x=MyIO.readLine(); Equals(x, "FIM")==false; x=MyIO.readLine()){
MyIO.println(Vogal(x)+" "+Consoante(x)+" "+NumeroI(x)+" "+NumeroR(x));
}//for
}//main






}//class
