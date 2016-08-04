/* Name: Matt Allen & Robbie Syed
 * PROG3060
 * 07/07/16
 * Description: The Arena bean
 * */

import javax.persistence.*;

@Entity @Table(name = "ARENA", schema = "GPAULLEY")
public class Arena
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int arenaID;
	private String arenaName;
	private String streetAddress;
	private String city;
	private String state_Province;
	private String postalCode;
	private String country;
	private String phone;
	private int capacity;
	
	public Arena()
	{
		// Default empty constructor
	}
	
	public int getArenaID() 
	{
		return arenaID;
	}
	
	public void setArenaID(int arenaID) 
	{
		this.arenaID = arenaID;
	}
	
	public String getArenaName() 
	{
		return arenaName;
	}
	
	public void setArenaName(String arenaName) 
	{
		this.arenaName = arenaName;
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
	
	public int getCapacity() 
	{
		return capacity;
	}
	
	public void setCapacity(int capacity) 
	{
		this.capacity = capacity;
	}	
}
