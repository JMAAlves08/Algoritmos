class Hash {
   int tabela[];
   int m;
   int NULO = -1;

   public Hash (){
      this(13, 2);
   }

   public Hash (int m, int res){
      this.m = m;
      this.tabela = new int [this.m+res];
      for(int i = 0; i < m+res; i++){
         tabela[i] = NULO;
      }
   }

   public int h(int elemento){
      return elemento % m;
   }

   public int reh(int elemento){
      return ++elemento % m;
   }

   public boolean inserir (int elemento){
      boolean resp = false;

      if(elemento != NULO){

         int pos = h(elemento);

         if(tabela[pos] == NULO){
            tabela[pos] = elemento;
            resp = true;

         } else{

            //pos = reh(elemento);
			for(int c=m+1; c<tabela.length; c++){
				if(tabela[c]==NULO){ tabela[c]=elemento; resp=true; }//if
			}//for
		
         }
      }

      return resp;
   }

   public boolean pesquisar (int elemento){
      boolean resp = false;

      int pos = h(elemento);

      if(tabela[pos] == elemento){
         resp = true;

      } else {
         //pos = reh(elemento);
		 for(int c=m+1; c<tabela.length; c++){
			if(tabela[c]==elemento){ resp=true; }//if
		 }//for
      }
      return resp;
   }

   boolean remover (int elemento){
      boolean resp = false;

      int pos=h(elemento);
	  if(tabela[pos]==elemento){ tabela[pos]=NULO; resp=true; }
	  else{
       for(int c=m+1; c<tabela.length; c++){
			if(tabela[c]==elemento){ tabela[pos]=NULO; resp=true; }
	   }//for
	}//else
      return resp;
   }
}
