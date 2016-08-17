

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ARENA database table.
 * 
 */
@Entity
@NamedQuery(name="Arena.findAll", query="SELECT a FROM Arena a")
public class Arena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int arenaid;

	private String arenaname;

	private int capacity;

	private String city;

	private String country;

	private String phone;

	private String postalcode;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	private String streetaddress;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="arenaBean")
	private List<Game> games;

	public Arena() {
	}

	public int getArenaid() {
		return this.arenaid;
	}

	public void setArenaid(int arenaid) {
		this.arenaid = arenaid;
	}

	public String getArenaname() {
		return this.arenaname;
	}

	public void setArenaname(String arenaname) {
		this.arenaname = arenaname;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setArenaBean(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setArenaBean(null);

		return game;
	}

}