
public class Temperature {
	float fahrenheiTemp;

	/**
	 * @return the fahrenheiTemp
	 */
	public float getFahrenheiTemp() {
		return fahrenheiTemp;
	}

	/**
	 * @param fahrenheiTemp
	 *            the fahrenheiTemp to set
	 */
	public void setFahrenheiTemp(float fahrenheiTemp) {
		this.fahrenheiTemp = fahrenheiTemp;
	}

	public void calculateCelsius() {
		System.out.println("Celsius " + (fahrenheiTemp - 32)*5/9 );
	}
}
