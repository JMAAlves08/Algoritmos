import java.io.*;

class RAF{

public static void main (String [] args){
try{
RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");

raf.writeInt(1);
raf.writeDouble(5.3);
raf.writeChar('X');
raf.writeBoolean(true);
raf.writeBytes("Algoritmos");


raf.seek(0);//retornando o cabeçote para a posição 0
System.out.println(raf.readInt());//imprimindo o inteiro

raf.seek(12);//setando o cabeçote na posição 12(char)
			 //12= 4 do inteiro+8 do double
System.out.println(raf.readChar());

raf.seek(12);//setando o cabeçote novamente na posição 12
raf.writeChar('@');//substituindo o caractere

raf.seek(12);
System.out.println(raf.readChar());

raf.close();
}//try
catch(FileNotFoundException ex){}
catch(IOException ex){}

}//main()
}//class
