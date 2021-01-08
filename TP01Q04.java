/**
  *@author João Marcos Aguiar Alves
  *Matricula: 600092
  */
import java.util.Random;
class TP01Q04{

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
  *Metodo para alterar caracteres de uma String aleatoriamente
  *@param String a ser alterada
  *@return String modificad
  */
public static String Alteracao(String x){
//dados
int code1=0;
int code2=0;
int t=x.length();
String resp="";
Random g1= new Random();//classe para gerar numeros aleatorios
Random g2= new Random();//iden
//

//gerar duas letras minusculas aleatorias
g1.setSeed(4);
g2.setSeed(4);

char c1=(char)('a'+Math.abs(g1.nextInt())%26);
char c2=(char)('a'+Math.abs(g1.nextInt())%26);
//MyIO.println (c1+" ==== "+c2);
//code1=(int)(Math.random()*121)+97;
//code2=(int)(Math.random()*121)+97;
//MyIO.println(code1+"===="+code2);

//percorrer toda a String realizando as alterações
for(int c=0; c<t; c++){
if(x.charAt(c)==(char)code1){
resp+=(char)code2;
}//if
else{
resp+=x.charAt(c);
}//else
}//for

return(resp);
}//Alteracao()

public static void main(String [] args){

String x="";
for(x=MyIO.readLine(); Equals(x, "FIM")==false; x=MyIO.readLine()){
MyIO.println(Alteracao(x));
}//for
}//main()
}//class
