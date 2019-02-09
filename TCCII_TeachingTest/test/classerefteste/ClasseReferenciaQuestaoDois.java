public class ClasseReferenciaQuestaoDois {
	
    private double a,b,c;
    private String mensagem = "";

       
    public ClasseReferenciaQuestaoDois(double arg1,double arg2, double arg3){
		a = arg1;
		b = arg2;
		c = arg3;
    }

    public String mensagem(){
	if((a <(b+c)) && (b < (a+c)) && (c < (a+b))){
            mensagem = "Forma um triangulo";
			
	}else{
            mensagem = "Nao forma um triangulo";
	}
            
        return mensagem;		
    }
    
    
    public static void main(String[] args) {
	
        int arg1 = 0;	
	int arg2 = 0;
	int arg3 = 0;
		
	arg1 = Integer.parseInt(args[0]);         
        arg2 = Integer.parseInt(args[1]);
        arg3 = Integer.parseInt(args[2]);		
		
	ClasseReferenciaQuestaoDois cr = new ClasseReferenciaQuestaoDois(arg1,arg2,arg3);
		
	System.out.println(cr.mensagem());
        
	}
		
}


