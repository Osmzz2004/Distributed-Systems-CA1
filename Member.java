package CA1;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement(name = "member")
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phoneNumber;
	private String fitnessGoal;
	private String address;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Payment> payments = new ArrayList<Payment>();

	
	public Member() {
		
	}
	
	public Member(String name, String phoneNumber,String fitnessGoal, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.fitnessGoal = fitnessGoal;
		this.address = address;
	
	}
	
	@XmlElement
	public int getId() {
		return id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	@XmlElement
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@XmlElement
	public String getFitnessGoal() {
		return fitnessGoal;
	}
	

	@XmlElement
	public String getAddress() {
		return address;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public void setFitnessGoal(String fitnessGoal) {
		this.fitnessGoal = fitnessGoal;
	}
	
	

}
