
public class Probability {
	private boolean isTrue;
	
	public Probability(double ccp) {
		int rand = (int)(Math.random() * 100) + 1;
		ccp = (int)(ccp * 100);

		if(rand <= ccp && rand >= 0)
			isTrue = true;
		else
			isTrue = false;
	}
	
	public boolean isTrue() {
		return isTrue;
	}
}
