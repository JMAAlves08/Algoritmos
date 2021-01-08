   public static void main(String [] args){
   
      Partida c1 = new Partida();
      String arquivo="";
      String et="";
      int c=0;
      int c0=0;
      int c2=0;
      int l=0;
      int q1=0;
      int controle=0;
   
      for(arquivo=MyIO.readLine(); Equals(arquivo, "0")==false; arquivo=MyIO.readLine()){
      
         c1.get_partida(arquivo);
      	//c1.Print();
      
      	//			int q=c1.Quantidade("/tmp/copa/"+arquivo+".html");
      
      	//			et="";
      	/*
      	   do{
      
      	   if(Equals(et, "FINAL")==false){
      
      	   l=c1.Grupo("/tmp/copa/"+arquivo+".html", c);//quantidade de etapas
      	   q1=c1.Quantidade2("/tmp/copa/"+arquivo+".html", l);//quantidade de <tr>
      	   q1+=c0;
      	   c1.set_etapa  (c1.get_etapa  (arquivo+".html", l));
      	   et=c1.get_etapa();
      
      	   do{
      
      	   c2=c1.Tag(arquivo+".html",c0);
      	   c1.set_copa   (c1.get_copa   (arquivo+".html"));
      	   c1.set_placar1(c1.get_placar1("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_placar2(c1.get_placar2("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_dia    (c1.get_dia    ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_mes    (c1.get_mes    ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_time1  (c1.get_time1  ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_time2  (c1.get_time2  ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.set_local  (c1.get_local  ("/tmp/copa/"+arquivo+".html", c2));
      	   c1.Print();
      	   c0++;
      	   }while(c0<q1 );
      
      	   }//if
      	   controle=0;
      	   c++;
      
      	   }while(c<q-1 );
      
      
      
      	   c=0; c0=0;
      	 */
      }//for
   
   
   
   }//main
