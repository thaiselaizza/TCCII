public class ClasseReferenciaQuestaoUm {
	
	private int valor;
	private String status = "";

	public String mostrarStatus(int valor){
		if((valor<10) || (valor >= 22)){
			status = "Valor rejeitado";
		}else{
			status = "Valor aceito";
		}
		return status;
	}
}
