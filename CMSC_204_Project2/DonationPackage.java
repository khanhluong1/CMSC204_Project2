/**
 * Object contains donated package's information
 * 
 * @author Derek Luong
 *
 */
public class DonationPackage {
	private static final double MAX_WEIGHT = 20;

	private String description;
	private double weight;
	
	public DonationPackage() {
		
	}
	
	public DonationPackage(String description, double weight) {
		this.description = description;
		this.weight = weight;
	}
	
	public boolean isHeavy() {
		return weight >= MAX_WEIGHT;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return description;
	}
	
}
