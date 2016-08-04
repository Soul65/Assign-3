/* Name: Matt Allen & Robbie Syed
 * PROG3060
 * 07/07/16
 * Description: The Player bean
 * */
import java.util.*;
import java.util.List.*;

import javax.persistence.*;

@Entity @Table(name = "Player", schema = "GPAULLEY")
public class Player 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int    playerID;
    private String firstName;
    private String lastName;
    private Date   DOB;
    
    // Note that in the Player table, the height and weight columns are stored as FIXED DECIMAL,
    // and not as DOUBLE. Hibernate and/or the DBMS's JDBC driver can perform 
    // implicit type conversions, but you need to be aware of them because you can 
    // suffer from loss of precision/rounding/truncation/ with the values.
    
    private double height;
    private double weight;
    
    private String school;
    private String streetAddress;
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    private String postalCode;
    private String country;
    
    private String phone;
    private String mobile;
    private String email;
    
    public Player() 
	{
	}
    
    public int getPlayerID() 
	{
	    return playerID;
	}
    
    public void setPlayerID( int playerID )
	{
	    this.playerID = playerID;
	}
    
    public String getFirstName()
	{
	    return firstName;
	}
    
    public void setFirstName( String name )
	{
	    this.firstName = name;
	}
    
    public String getLastName()
	{
	    return lastName;
	}
    
    public void setLastName( String name )
	{
	    this.lastName = name;
	}
    
    public String getFullName()
	{
		return firstName + " " + lastName;
	}
    
    public Date getDOB()
	{
	    return DOB;
	}
    
    public void setDOB( Date birthday )
	{
	    this.DOB = birthday;
	}
    
    public double getWeight()
	{
	    return weight;
	}
    
    public void setWeight( double newWeight )
	{
	    this.weight = newWeight;
	}
    
    public double getHeight()
	{
	    return height;
	}
    
    public void setHeight( double newHeight )
	{
	    this.height = newHeight;
	}
    
    public String getStreetAddress()
    {
    	return streetAddress;
    }
    
    public void setStreetAddress( String newAddress )
	{
	    this.streetAddress = newAddress;
	}
    
    public String getSchool()
    {
    	return school; 
    }
    
    public void setSchool( String newSchool )
	{
	    this.school = newSchool;
	}
    
    public String getCity()
    {
    	return city;
    }
    
    public void setCity( String newCity )
	{
	    this.city = newCity;
	}
    
    public String getStateProvince()
    {
    	return stateProvince;
    }
    
    public void setStateProvince( String newProvince )
	{
	    this.stateProvince = newProvince;
	}

    public String getPostalCode()
    {
    	return postalCode;
    }
    
    public void setPostalCode( String newCode )
	{
	    this.postalCode = newCode;
	}

    public String getCountry()
    {
    	return country;
    }
    
    public void setCountry( String newCountry )
	{
	    this.country = newCountry;
	}
    
    public String getPhone()
    {
    	return phone;
    }
    
    public void setPhone( String newPhone )
	{
	    this.phone = newPhone;
	}
    
    public String getMobile()
    {
    	return mobile;
    }
    
    public void setMobile( String newMobile )
	{
	    this.mobile = newMobile;
	}
    
    public String getEmail()
    {
    	return email;
    }
    
    public void setEmail( String newEmail )
	{
	    this.email = newEmail;
	}
}
