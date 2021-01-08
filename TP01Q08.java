
import java.io.*;
import java.net.*;

/**
 *@author João Marcos Aguiar Alves
 *Matricula: 600092
 */
class TP01Q08{


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


	public static String getHtml(String endereco){
		URL url;
		InputStream is = null;
		BufferedReader br;
		String resp = "", line;

		try {
			url = new URL(endereco);
			is = url.openStream();  // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				resp += line + "\n";
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try {
			is.close();
		} catch (IOException ioe) {
			//tratar erro
		}

		return resp;
	}


	/**
	 *Metodo para contar vogais, consoantes e tags de um arquivo html
	 *@param String a ser pesquisada
	 *@param String contendo nome do arquivo
	 *@return Saida conforme pedido no enunciado
	 */
	public static String Contar(String b, String nome){

		//dados
		int v1=0;//a
		int v2=0;//e
		int v3=0;//i
		int v4=0;//o
		int v5=0;//u
		int v6=0;//á
		int v7=0;//é
		int v8=0;//í
		int v9=0;//ó
		int v10=0;//ú
		int v11=0;//à
		int v12=0;//è
		int v13=0;//ì
		int v14=0;//ò
		int v15=0;//ù
		int v16=0;//ã
		int v17=0;//õ
		int v18=0;//â
		int v19=0;//ê
		int v20=0;//î
		int v21=0;//ô
		int v22=0;//û
		int v23=0;//consoantes
		int v24=0;//<br>
		int v25=0;//<table>
		int v26=0;//
		int v27=0;//


		for( int c=0; c<b.length(); c++){

			if(b.charAt(c)=='a'){
				v1++;
			}//if

			if(b.charAt(c)=='e'){
				v2++;
			}//if
			if(b.charAt(c)=='i'){
				v3++;
			}//if
			if(b.charAt(c)=='o'){
				v4++;
			}//if
			if(b.charAt(c)=='u'){
				v5++;
			}//if
			if(b.charAt(c)=='á'){
				v6++;
			}//if
			if(b.charAt(c)=='é'){
				v7++;
			}//if
			if(b.charAt(c)=='í'){
				v8++;
			}//if
			if(b.charAt(c)=='ó'){
				v9++;
			}//if
			if(b.charAt(c)=='ú'){
				v10++;
			}//if
			if(b.charAt(c)=='à'){
				v11++;
			}//if
			if(b.charAt(c)=='è'){
				v12++;
			}//if
			if(b.charAt(c)=='ì'){
				v13++;
			}//if
			if(b.charAt(c)=='ò'){
				v14++;
			}//if
			if(b.charAt(c)=='ù'){
				v15++;
			}//if
			if(b.charAt(c)=='ã'){
				v16++;
			}//if
			if(b.charAt(c)=='õ'){
				v17++;
			}//if
			if(b.charAt(c)=='â'){
				v18++;
			}//if
			if(b.charAt(c)=='ê'){
				v19++;
			}//if
			if(b.charAt(c)=='î'){
				v20++;
			}//if
			if(b.charAt(c)=='ô'){
				v21++;
			}//if
			if(b.charAt(c)=='û'){
				v22++;
			}//if
			if(b.charAt(c)=='<'){

				if(b.charAt(c+1)=='b' && b.charAt(c+2)=='r' && b.charAt(c+3)=='>'){
					v24++;
					v23-=2;
				}
				else if(b.charAt(c+1)=='t' && b.charAt(c+2)=='a' && b.charAt(c+3)=='b' && b.charAt(c+4)=='l' && b.charAt(c+5)=='e' && b.charAt(c+6)=='>'){
					v25++;
					v23-=3;
					v1--;
					v2--;
				}
			}//if
			if((b.charAt(c)>='b' && b.charAt(c)<='d') || (b.charAt(c)>='f' && b.charAt(c)<='h') || (b.charAt(c)>='j' && b.charAt(c)<='n') || (b.charAt(c)>='p' && b.charAt(c)<='t') || (b.charAt(c)>='v' && b.charAt(c)<='z') /*|| (b.charAt(c)>='B' && b.charAt(c)<='D') || (b.charAt(c)>='F' && b.charAt(c)<='H') || (b.charAt(c)>='J' && b.charAt(c)<='N') || (b.charAt(c)>='P' && b.charAt(c)<='T') || (b.charAt(c)>='U' && b.charAt(c)<='Z')*/){
v23++;
}//if


		}//for


		return("a("+Integer.toString(v1)+") e("+Integer.toString(v2)+") i("+Integer.toString(v3)+") o("+Integer.toString(v4)+") u("+Integer.toString(v5)+") á("+Integer.toString(v6)+") é("+Integer.toString(v7)+") í("+Integer.toString(v8)+") ó("+Integer.toString(v9)+") ú("+Integer.toString(v10)+") à("+Integer.toString(v11)+") è("+Integer.toString(v12)+") ì("+Integer.toString(v13)+") ò("+Integer.toString(v14)+") ù("+Integer.toString(v15)+") ã("+Integer.toString(v16)+") õ("+Integer.toString(v17)+") â("+Integer.toString(v18)+") ê("+Integer.toString(v19)+") î("+Integer.toString(v20)+") ô("+Integer.toString(v21)+") û("+Integer.toString(v22)+") consoante("+Integer.toString(v23)+") <br>("+Integer.toString(v24)+") <table>("+Integer.toString(v25)+") "+nome);
	}//Contar() 


	public static void main(String[] args) {
		String endereco, html;
		String nome="";
		int linha=0;
		for(endereco=MyIO.readLine(); Equals(endereco, "FIM")==false; endereco=MyIO.readLine()){
			linha++;

			if(linha%2==0){	
				html = getHtml(endereco);
				System.out.println(Contar(html, nome));
				//System.out.println(html);
			}//if
			nome=endereco;
		}//for
	}


}//class
