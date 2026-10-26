package CA1;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int phoneNumber;
	private String fitnessGoal;
	private String address;

	@OneToOne

	public Member(String name, int phoneNumber,String fitnessGoal, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.fitnessGoal = fitnessGoal;
		this.address = address;
	
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getFitnessGoal() {
		return fitnessGoal;
	}
	
	

	public String getAddress() {
		return address;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
