
public class Patient {
	private String icNumber;
	private String name;
	private String address;
	private int age;
	private String gender;
	private String phoneNumber;
	
	public Patient(String icNumber,String name,String address,int age,String gender,String phoneNumber) {
		this.icNumber = icNumber;
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;	
	}
	
	public String getICNumber() {
		return icNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}	
}