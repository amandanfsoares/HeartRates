package spring;
import java.time.LocalDate;

public class Idade {
	
	private Integer ano = LocalDate.now().getYear();
	private HeartRates heart;
	
	public Idade(HeartRates heart) {
		this.heart = heart;
	}

	public Integer Calculo(HeartRates heart) {
		return  ano - heart.getAno();
		}	
	
	public HeartRates getHeart() {
		return heart;
	}

	public void setHeart(HeartRates heart) {
		this.heart = heart;
	}

	
	}
