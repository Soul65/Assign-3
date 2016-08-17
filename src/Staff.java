

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STAFF database table.
 * 
 */
@Entity
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int staffid;

	private String certification;

	private String city;

	private String country;

	private String email;

	private String firstname;

	private String lastname;

	private String mobile;

	private String phone;

	private String postalcode;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	private String streetaddress;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="staff1")
	private List<Team> teams1;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="staff2")
	private List<Team> teams2;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="staff3")
	private List<Team> teams3;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="staff4")
	private List<Team> teams4;

	public Staff() {
	}

	public int getStaffid() {
		return this.staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getCertification() {
		return this.certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getStreetaddress() {
		return this.streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public List<Team> getTeams1() {
		return this.teams1;
	}

	public void setTeams1(List<Team> teams1) {
		this.teams1 = teams1;
	}

	public Team addTeams1(Team teams1) {
		getTeams1().add(teams1);
		teams1.setStaff1(this);

		return teams1;
	}

	public Team removeTeams1(Team teams1) {
		getTeams1().remove(teams1);
		teams1.setStaff1(null);

		return teams1;
	}

	public List<Team> getTeams2() {
		return this.teams2;
	}

	public void setTeams2(List<Team> teams2) {
		this.teams2 = teams2;
	}

	public Team addTeams2(Team teams2) {
		getTeams2().add(teams2);
		teams2.setStaff2(this);

		return teams2;
	}

	public Team removeTeams2(Team teams2) {
		getTeams2().remove(teams2);
		teams2.setStaff2(null);

		return teams2;
	}

	public List<Team> getTeams3() {
		return this.teams3;
	}

	public void setTeams3(List<Team> teams3) {
		this.teams3 = teams3;
	}

	public Team addTeams3(Team teams3) {
		getTeams3().add(teams3);
		teams3.setStaff3(this);

		return teams3;
	}

	public Team removeTeams3(Team teams3) {
		getTeams3().remove(teams3);
		teams3.setStaff3(null);

		return teams3;
	}

	public List<Team> getTeams4() {
		return this.teams4;
	}

	public void setTeams4(List<Team> teams4) {
		this.teams4 = teams4;
	}

	public Team addTeams4(Team teams4) {
		getTeams4().add(teams4);
		teams4.setStaff4(this);

		return teams4;
	}

	public Team removeTeams4(Team teams4) {
		getTeams4().remove(teams4);
		teams4.setStaff4(null);

		return teams4;
	}

	public String getFullName()
	{
		return firstname + " " + lastname;
	}
}