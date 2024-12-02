package bowling;

class Tourfinal extends Tour {

	private int quillesTroisiemeLancer = 0;

	Tourfinal() {
		this.numero = 10;
		this.suivant = null; // Pas de tour suivant
	}

	@Override
	void enregistreLancer(int quillesAbattues) {
		if (quillesAbattues < 0) {
			throw new IllegalArgumentException("Ne peut pas être négatif");
		}

		boulesLancees++;
		switch (boulesLancees) {
			case 1:
				quillesAbattuesLancer1 = quillesAbattues;
				break;
			case 2:
				quillesAbattuesLancer2 = quillesAbattues;
				break;
			case 3:
				quillesTroisiemeLancer = quillesAbattues;
				break;
			default:
				throw new IllegalStateException("Trop de lancers dans le dernier tour");
		}
	}

	@Override
	int bonusPourStrike() {

		return quillesAbattuesLancer1 + quillesAbattuesLancer2;
	}

	@Override
	int score() {
		return quillesAbattuesLancer1 + quillesAbattuesLancer2 + quillesTroisiemeLancer;
	}

	@Override
	public boolean estTermine() {
		return (estUnStrike() || estUnSpare()) ? (boulesLancees == 3) : (boulesLancees == 2);
	}

	@Override
	public String toString() {
		return super.toString() + ", Troisième lancer: " + quillesTroisiemeLancer;
	}
}
