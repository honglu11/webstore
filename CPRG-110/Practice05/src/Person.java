/**
 * 
 */

/**
 * @author honglu
 *
 */
public class Person {
	private int year;
	private int days;
	private long minutes;
	private long seconds;
	private long milliseconds;

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @param days
	 *            the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * @return the minutes
	 */
	public long getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes
	 *            the minutes to set
	 */
	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the seconds
	 */
	public long getSeconds() {
		return seconds;
	}

	/**
	 * @param seconds
	 *            the seconds to set
	 */
	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}

	/**
	 * @return the milliseconds
	 */
	public long getMilliseconds() {
		return milliseconds;
	}

	/**
	 * @param milliseconds
	 *            the milliseconds to set
	 */
	public void setMilliseconds(long milliseconds) {
		this.milliseconds = milliseconds;
	}

	public void calculateAge() {
		
		this.days = this.year * 365;
		this.seconds = this.days*24*60*60;
		this.minutes = this.seconds/60;
		this.milliseconds = this.seconds/1000;
	}
}
