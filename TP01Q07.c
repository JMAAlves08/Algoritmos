#include <stdio.h>
#include <string.h>




/**
  *Metodo para verificar se dois arranjos de caracteres sao iguais
  *@param arranjos a serem verificados
  *@return true(1) ou false(0)
  */

int Equals(char a [] , char b []){
//dados
int r=1;
int c=0;
//
if((int)strlen(a)!=(int)strlen(b)){
//printf("Tamanhos DIFERENTES\n");
r=0;
}//if
else{
//printf("TAMANHOS IGUAIS\n");
for(c=0; c<(int)strlen(a); c++){
if(a[c]!=b[c]){
//printf("char %c diferente de %c\n", a[c], b[c]);
r=0;
c=(int)strlen(a);
}//if
}//for
}//else
return(r);
}//equals

/**
  *Metodo para verificar se uma String é palindromo
  *@param arranjo de caracteres a ser analisado
  *@return 0 se nao, 1 se sim
  */
int Palindromo(char x []){
//dados
char inv [(int)strlen(x)];
int c=0;
int r=1;

for(c=((int)strlen(x))-1; c>0; c--){
inv[c]=x[c];
}//for
printf("%s\t", x);
printf("%s\t", inv);
if(strcmp(x, inv)!=0){
r=0;
}//if


return(r);
}//Palindromo()


int main(){

char c [1000];





while(strcmp(c, "FIM")!=0){
scanf("%s", c);
printf("%s", c);
if(Palindromo(c)==1){
printf("SIM\n");
}
else{
printf("NAO\n");
}
}

return 0;
}//main
