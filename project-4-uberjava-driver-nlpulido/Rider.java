public class Rider{
	Driver driver;
	int faresPerDriver;
	int total;
	int minutes;

	public Rider(Driver driver, int faresPerDriver, int total, int minutes){
		this.driver = driver;
		this.faresPerDriver = faresPerDriver;
		this.total = total;
		this.minutes = minutes;
	}
}