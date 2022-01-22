package HW3;

public class Fruit {
	protected int numF;
	protected float weightF;

	public Fruit (float weight) {
		this.weightF = weight;
	}

	public int getNumF() {
		return numF;
	}

	public float getWeightF() {
		return weightF;
	}

	public void setNumF(int num) {
		this.numF = num;
	}

	public void setWeightF(float weight) {
		this.weightF = weight;
	}
}
