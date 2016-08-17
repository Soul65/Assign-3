

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PLAYER database table.
 * 
 */
@Entity
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int playerid;

	private String city;

	private String country;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String firstname;

	private BigDecimal height;

	private String lastname;

	private String mobile;

	private String phone;

	private String postalcode;

	private String school;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	private String streetaddress;

	private BigDecimal weight;

	//bi-directional many-to-one association to Playerstat
	@OneToMany(mappedBy="playerBean")
	private List<Playerstat> playerstats;

	//bi-directional many-to-one association to Roster
	@OneToMany(mappedBy="playerBean")
	private List<Roster> rosters;

	public Player() {
	}

	public int getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
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

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
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

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
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

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public List<Playerstat> getPlayerstats() {
		return this.playerstats;
	}

	public void setPlayerstats(List<Playerstat> playerstats) {
		this.playerstats = playerstats;
	}

	public Playerstat addPlayerstat(Playerstat playerstat) {
		getPlayerstats().add(playerstat);
		playerstat.setPlayerBean(this);

		return playerstat;
	}

	public Playerstat removePlayerstat(Playerstat playerstat) {
		getPlayerstats().remove(playerstat);
		playerstat.setPlayerBean(null);

		return playerstat;
	}

	public List<Roster> getRosters() {
		return this.rosters;
	}

	public void setRosters(List<Roster> rosters) {
		this.rosters = rosters;
	}

	public Roster addRoster(Roster roster) {
		getRosters().add(roster);
		roster.setPlayerBean(this);

		return roster;
	}

	public Roster removeRoster(Roster roster) {
		getRosters().remove(roster);
		roster.setPlayerBean(null);

		return roster;
	}

	public String getFullName()
	{
		return firstname + " " + lastname;
	}
}