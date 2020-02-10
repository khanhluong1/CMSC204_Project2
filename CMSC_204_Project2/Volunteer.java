/**
 * Object contains volunteer's information
 * 
 * @author Derek Luong
 *
 */
public class Volunteer {
	private String name;

	public Volunteer() {}
	
	public Volunteer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
