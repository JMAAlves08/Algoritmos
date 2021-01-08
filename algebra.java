/*@author João Marcos Aguiar Alves
 *06/08/1999
 */

public class algebra{




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
	 *Metodo para retirar o trecho da String contendo a operação
	 *@param String a ser pesquisada
	 *@param posicao inicial e final da operação
	 *@return operação
	 */
	public static String operacao(String linha, int i, int f){
		String op="";
		for(int c=i; c<f; c++){
			op+=linha.charAt(c);
		}//for


		return(op);
	}//

	/**
	 *Metodo que recebe uma String contendo uma operação e a executa
	 *@param String contendo as operações
	 *@param variaveis A, B, e C
	 *return resultado
	 */
	public static int calculo(String op, int A, int B, int C){
		//MyIO.println(op.length());
        //MyIO.println(Integer.toBinaryString(A));
		int resp=0;
		int p=0;
		int v1=-1000, v2=-1000, v3=-1000;
        String bin=""; //String para inversao de bits
        String tmp="";
		if(op.charAt(p)=='a'){ //and
			p+=4;
			if(op.charAt(p)=='A')     { v1=A; p+=4; }//primeira variavel
			else if(op.charAt(p)=='B'){ v1=B; p+=4; }
			else if(op.charAt(p)=='-'){//caso o primeiro valor seja negativo
				v1=(int)(op.charAt(p+1)-48)*-1; p+=5;
			}
			else if(op.charAt(p)>='0' && op.charAt(p)<='9'){ v1=(int)(op.charAt(p)-48); p+=4; }//caso seja um valor inteiro


			//segunda variavel (pos=8 ou 9)
			if(op.charAt(p)=='B'){ v2=B; p+=4;}
			else if(op.charAt(p)=='C'){ v2=C; p+=4;}
			else if(op.charAt(p)=='-'){ v2=(int)(op.charAt(p+1)-48)*-1; p+=5; }//valor negativo
			else if(op.charAt(p)>='0' && op.charAt(p)<='9'){ v2=(int)(op.charAt(p)-48); p+=4; }

			//terceira variavel
			if(p<op.length()){
				if(op.charAt(p)=='C'){ v3=C; }
				else if(op.charAt(p)=='-'){ v3=(int)(op.charAt(p+1)-48)*-1; }//valor negativo
				else if(op.charAt(p)>='0' && op.charAt(p)<='9' ){v3=(int)(op.charAt(p)-48); }
			}//if
			if(v3==-1000){ resp=(v1&v2); }
			else if(v2==-1000){ resp=(v1&v3); }
			else{ resp=(v2&v3); }

		}//if

		else if(op.charAt(p)=='o'){ //or
			p+=3;
			if(op.charAt(p)=='A')     { v1=A; p+=4;}//primeira variavel
			else if(op.charAt(p)=='B'){ v1=B; p+=4;}
			else if(op.charAt(p)=='-'){ v1=(int)(op.charAt(p+1)-48)*-1; p+=5; }//valor negativo
			else if(op.charAt(p)>='0' && op.charAt(p)<='9'){ v1=(int)(op.charAt(p)-48); p+=4;}//caso seja um valor inteiro


			//segunda variavel

			if(op.charAt(p)=='B'){ v2=B; p+=4;}
			else if(op.charAt(p)=='C'){ v2=C; p+=4;}
			else if(op.charAt(p)=='-'){ v2=(int)(op.charAt(p+1)-48)+-1; p+=5;}//valor negativo
			else if(op.charAt(p)>='0' && op.charAt(p)<='9'){ v2=(int)(op.charAt(p)-48); p+=4;}

			//terceira variavel
			if(p<op.length()){
				if(op.charAt(p)=='C'){ v3=C; }
				else if(op.charAt(p)=='-'){ v3=(int)(op.charAt(p+1)-48)*-1; }//valor negativo
				else if(op.charAt(p)>='0' && op.charAt(p)<='9' ){v3=(int)(op.charAt(p)-48); }
			}//if
			if(v3==-1000){ resp=(v1|v2); }
			else if(v2==-1000){ resp=(v1|v3); }
			else{ resp=(v2|v3); }

		}//if

		else if(op.charAt(p)=='n'){ //not
			p+=4;
			if(op.charAt(p)=='A')     { v1=A; }//primeira variavel
			else if(op.charAt(p)=='B'){ v1=B; }
			else if(op.charAt(p)=='C'){ v1=C; }
			else if(op.charAt(p)=='-'){ v1=(int)(op.charAt(p+1)-48)*-1; }//valor negativo
			else if(op.charAt(p)>='0' && op.charAt(4)<='9'){ v1=(int)(op.charAt(4)-48); }//caso seja um valor inteiro

			//resp=(~v1);
            
            bin=Integer.toBinaryString(v1);
           // MyIO.println("V1: "+v1+" N: "+~v1+" BIN: "+bin);

            for(int c=0; c<bin.length(); c++){
            if(bin.charAt(c)=='1'){ tmp+='0'; }
            else{ tmp+='1'; }

            }//for

            
            //MyIO.println("N: "+tmp);
            resp=Integer.parseInt(tmp, 2);
            //MyIO.println("R: "+resp);
		}//if

		return(resp);
	}//calculo()

	/**
	 *Metodo para substituir uma operação pelo seu resultado em uma String
	 *@param linha a ser modificada
	 *@param seção da String a ser editada
	 *@param resultado da operação
	 *return String modificada
	 */
	public static String substituir(String linha, int i, int f, int valor){
		String mod="";

		//percorrer toda String
		for(int c=0; c<linha.length(); c++){
			//encontrando seção a ser editada
			if(c>=i && c<f){
				mod+=Integer.toString(valor);
				c=f;
			}//if
			else{
				mod+=linha.charAt(c);
			}//else
		}//for

		return(mod);
	}//substituir


public static String fix(String linha){
String resp="";
int c=0;
for(c=0; c<linha.length(); c++){
if(linha.charAt(c)=='(' && linha.charAt(c+2)==','){
resp+=linha.charAt(c);
resp+=linha.charAt(c+1);
resp+=' ';
resp+=linha.charAt(c+2);
c+=3;
}//if

if(linha.charAt(c)==',' && linha.charAt(c+1)!=' '){ 

resp+=linha.charAt(c);
resp+=' ';

}//if
else{ resp+=linha.charAt(c); }
}//for

return(resp);

}//linha



	public static void main (String [] args){

		int A=-1, B=-1, C=-1; //variaveis de operação
		int resultado=0;  //resultado a ser averiguado
		int c1=0;
		int resposta=0;
		int aux1=0, aux2=0;   //variaveis para guardar um trecho da linha
		boolean fim=false;
		String linha="";
		String op="";
		//ler variaveis
		for(linha=MyIO.readLine(); Equals("0", linha )==false; linha=MyIO.readLine()){
			A=-1; B=-1; C=-1; resultado=0; c1=0; resposta=0; aux1=0; aux2=0; //fim=false;

			A=(int)(linha.charAt(0)-48);//variavel a
			B=(int)(linha.charAt(2)-48);//variavel b
			if(linha.charAt(6)>='0' && linha.charAt(6)<='9'){
				C=(int)(linha.charAt(4)-48);//variavel c
				resposta=(int)(linha.charAt(6)-48);
			}//if

			else{
				resposta=(int)(linha.charAt(4)-48);
			}//else
			//MyIO.println(linha.charAt(4));
			MyIO.println("A: "+A+" B: "+B+" C: "+C+" R: "+resposta);

			//cortar linha
			while((linha.charAt(c1)!='a' && linha.charAt(c1)!='o' && linha.charAt(c1)!='n')){ c1++; }//while
			for(c1=c1; c1<linha.length(); c1++){
				op+=linha.charAt(c1);

			}//for
			linha=op;
			op="";
			c1=0;

			MyIO.println("LINHA: "+linha);
			//identificar ordem de operações
			while(fim==false){


				boolean v=false;//variavel para verificar se operacao possui apenas variaveis
				int c2=0;
				//MyIO.println("LINHA: "+linha);		
				for(int c=0; c<linha.length(); c++){

					if((linha.charAt(c)=='a' && linha.charAt(c+1)=='n') || (linha.charAt(c)=='o' && linha.charAt(c+1)=='r') || (linha.charAt(c)=='n' && linha.charAt(c+1)=='o')){//encontrada uma operação
						aux1=c;  //delimitando inicio da operação
						c2=c+1;
						while(v==false && linha.charAt(c2)!=')' && c2<=linha.length()){ //percorrer operação
							if((linha.charAt(c2)=='a' && linha.charAt(c2+1)=='n') || (linha.charAt(c2)=='o' && linha.charAt(c2+1)=='r') || (linha.charAt(c2)=='n' && linha.charAt(c2+1)=='o')){  v=true; }//se detectado uma operação interna 
							else{
								//MyIO.println("LINHA: "+linha);
								//MyIO.println(linha.charAt(c2));
								//MyIO.println(c2+" "+linha.length());

								c2++;
								aux2=c2;
							}//else
						}//while
						//MyIO.println("LINHA: "+linha);
						if(v==false){ //se ao fim do loop v continua falso, siginifica que uma operação independente foi encontrada

							//pegar trecho da linha contendo operação

							op=operacao(linha, aux1, aux2);
							op+=')';
							op=fix(op);
							MyIO.println("OP: "+op);

							//identificar e realizar operação
							resposta=calculo(op, A, B, C);
							MyIO.println("RESPOSTA: "+resposta);
							//substituir operação por resultado na linha
							linha=substituir(linha, aux1, aux2, resposta);
							MyIO.println("LINHA S: "+linha);
						}//if
						v=false;
					}//if

				}//for
				//linha+=')';

				//MyIO.println(linha.length());
				//MyIO.println("FIM: "+fim);
				//resposta=Integer.parseInt(linha);  MyIO.println(resposta);
				//if(resposta==resultado){ MyIO.println("SIM"); }  else { MyIO.println("N
				fim=(linha.length()<=3);
				A=-1; B=-1; C=-1; op=""; //linha="";
				//MyIO.println("FIM: "+fim);
			}//while
			fim=false;
				MyIO.println(linha);
		}//for
		//realizar expressão

	}//main


}//class
