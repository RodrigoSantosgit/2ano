package aula6.ex1;

public enum Dia {

	SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;

	public static Dia rand() {
		int rand = (int)(Math.random()*6); 
		switch(rand) {
			case 0:
				return SEGUNDA;
			case 1:
				return TERÇA;
			case 2:
				return QUARTA;
			case 3:
				return QUINTA;
			case 4:
				return SEXTA;
			case 5:
				return SABADO;
			case 6:
				return DOMINGO;
				
		}
		return null;
	}
}
