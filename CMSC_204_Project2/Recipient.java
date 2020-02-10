/**
 * Object contains recipient's information
 * 
 * @author Derek Luong
 *
 */
public class Recipient {

	private String name;
	
	public Recipient() {}
	
	public Recipient(String name) {
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
