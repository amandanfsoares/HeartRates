package spring;



public class FrequenciaCardiaca {
	
	private HeartRates heart;
	private Idade idade;
	private Integer freqCardMax=220;

	public FrequenciaCardiaca(Idade idade, HeartRates heart) {
		this.idade =idade; 
		this.heart=heart;
	}
		
	public Integer CalcularFreqCard(Idade idade, HeartRates heart) {
		return freqCardMax - idade.Calculo(heart);
		}


	public Idade getIdade() {
		return idade;
	}

	public void setIdade(Idade idade) {
		this.idade = idade;
	}
	
	public HeartRates getHeart() {
		return heart;
	}

	public void setHeart(HeartRates heart) {
		this.heart = heart;
	}

	public Integer getFreqCardMax() {
		return freqCardMax;
	}

	public void setFreqCardMax(Integer freqCardMax) {
		this.freqCardMax = freqCardMax;
	}

	@Override
	public String toString() {
		return "Frequencia Cardiaca:"  + CalcularFreqCard(idade,heart);
	}

	
	
}
