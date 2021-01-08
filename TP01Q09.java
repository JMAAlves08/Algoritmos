
import java.io.RandomAccessFile;
import java.io.*;

class TP01Q09{



	/**
	 *Metodo para verificar se String possui determinado caractere
	 *@char a ser buscado
	 *@return true se positvo, false se negativo
	 */ 
	public static boolean Contains(String p, char x){
		boolean resp=false;
		for(int c=0; c<p.length(); c++){
			if(p.charAt(c)==x){
				resp=true;
				c=p.length();
			}
		}//for
		return(resp);
	}//Contains

	public static void main(String [] args){

		String x="";
		try{
			RandomAccessFile raf=new RandomAccessFile("Numeros.txt", "rw");//abrir arquivo para leitura
			x=MyIO.readLine();//ler primeira linha contendo quantidade de numeros a serem guardados
			int t=Integer.parseInt(x);
			int ca=(t*8)-8;//cabeçote

			for(int c=0; c<Integer.parseInt(x); c++){//armazenar quantidade lida

				raf.writeDouble(Double.parseDouble(MyIO.readLine()));

			}//for

			//mostrar arquivo de baixo para cima
			while(ca>=0){//enquanto não atingir limite superior do arquivo
				raf.seek(ca);//mover cabeçote para ultima posição do arquivo
				double valor=raf.readDouble();
				if((int)valor-valor==0){
					MyIO.println((int)valor);
				}
				else{
					MyIO.println(valor);
				}//else
				ca-=8;
			}//while
		}//try
		catch(FileNotFoundException ex){
			MyIO.println("filenotfound");}//catch
		catch(IOException ex){}//catch
		//Arq.close();
	}//main()
}//class
