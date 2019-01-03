package spring;

public class FrequenciaCardiacaAlvo {
	
	private FrequenciaCardiaca freqCardiaca;
	private Idade idade;
	private HeartRates heart;
	

	public Double CalcFreqCardAlvInicio(FrequenciaCardiaca freqCardiaca) {
	return (double) (freqCardiaca.CalcularFreqCard(idade, heart)*50/100);
		}
	public Double CalcFreqCardAlvFim(FrequenciaCardiaca freqCardiaca) {
		return  (double) (freqCardiaca.CalcularFreqCard(idade, heart)*85/100);
				
		}

	public FrequenciaCardiaca getFreqCardiaca() {
		return freqCardiaca;
	}
	public void setFreqCardiaca(FrequenciaCardiaca freqCardiaca) {
		this.freqCardiaca = freqCardiaca;
	}
	@Override
	public String toString() {
		return "Frequencia Cardiaca Alvo Mínimo: " + CalcFreqCardAlvInicio(freqCardiaca) + "	Frequencia Cardiaca Alvo Máximo: " + CalcFreqCardAlvFim(freqCardiaca);
	}
	
	public FrequenciaCardiacaAlvo(Idade idade, HeartRates heart, FrequenciaCardiaca freqCardiaca) {
		this.freqCardiaca=freqCardiaca;
		this.heart=heart;
		this.idade=idade;
	}
	
	
}
