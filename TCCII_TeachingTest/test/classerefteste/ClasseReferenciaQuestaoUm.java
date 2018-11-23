public class ClasseReferenciaQuestaoUm {
	
    private int valor;
    private String status = "";

       
    public ClasseReferenciaQuestaoUm(int arg){
	valor = arg;
    }

    public String status(){
	if((valor<10) || (valor >= 22)){
            status = "Valor rejeitado";
			
	}else{
            status = "Valor aceito";
	}
            
        return status;		
    }
    
    
    public static void main(String[] args) {
	
        int arg1 = 0;		
	arg1 = Integer.parseInt(args[0]);                
		
	ClasseReferenciaQuestaoUm cr = new ClasseReferenciaQuestaoUm(arg1);
		
	System.out.println(cr.status());
        
	}
		
}


