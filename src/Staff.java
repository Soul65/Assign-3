/* Name: Matt Allen & Robbie Syed
 * PROG3060
 * 07/20/16
 * Description: The Staff bean
 * */
import javax.persistence.*;

@Entity @Table(name = "STAFF", schema = "GPAULLEY")
public class Staff
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffID;
	private String lastName;
	private String firstName;
	private String streetAddress;
	private String city;
	private String state_Province;
	private String postalCode;
	private String country;
	private String phone;
	private String mobile;
	private String email;
	private String certification;
	
	public Staff(){}	
		
	public int getStaffID() 
	{
		return staffID;
	}
	
	public void setStaffID(int staffID) 
	{
		this.staffID = staffID;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	public String getStreetAddress() 
	{
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) 
	{
		this.streetAddress = streetAddress;
	}
	
	public String getCity() 
	{
		return city;
	}
	
	public void setCity(String city) 
	{
		this.city = city;
	}
	
	public String getStateProvince() 
	{
		return state_Province;
	}
	
	public void setStateProvince(String stateProvince) 
	{
		this.state_Province = stateProvince;
	}
	
	public String getPostalCode() 
	{
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) 
	{
		this.postalCode = postalCode;
	}
	
	public String getCountry() 
	{
		return country;
	}
	
	public void setCountry(String country) 
	{
		this.country = country;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public String getMobile() 
	{
		return mobile;
	}
	
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getCertification() 
	{
		return certification;
	}
	
	public void setCertification(String certification) 
	{
		this.certification = certification;
	}
}