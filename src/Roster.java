

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROSTER database table.
 * 
 */
@Entity
@NamedQuery(name="Roster.findAll", query="SELECT r FROM Roster r")
public class Roster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int rosterid;

	private int jersey;

	private String position;

	//bi-directional many-to-one association to Playerstat
	@OneToMany(mappedBy="rosterBean")
	private List<Playerstat> playerstats;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="PLAYER")
	private Player playerBean;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="TEAM")
	private Team teamBean;

	public Roster() {
	}

	public int getRosterid() {
		return this.rosterid;
	}

	public void setRosterid(int rosterid) {
		this.rosterid = rosterid;
	}

	public int getJersey() {
		return this.jersey;
	}

	public void setJersey(int jersey) {
		this.jersey = jersey;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<Playerstat> getPlayerstats() {
		return this.playerstats;
	}

	public void setPlayerstats(List<Playerstat> playerstats) {
		this.playerstats = playerstats;
	}

	public Playerstat addPlayerstat(Playerstat playerstat) {
		getPlayerstats().add(playerstat);
		playerstat.setRosterBean(this);

		return playerstat;
	}

	public Playerstat removePlayerstat(Playerstat playerstat) {
		getPlayerstats().remove(playerstat);
		playerstat.setRosterBean(null);

		return playerstat;
	}

	public Player getPlayerBean() {
		return this.playerBean;
	}

	public void setPlayerBean(Player playerBean) {
		this.playerBean = playerBean;
	}

	public Team getTeamBean() {
		return this.teamBean;
	}

	public void setTeamBean(Team teamBean) {
		this.teamBean = teamBean;
	}

}