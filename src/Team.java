

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEAM database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String teamid;

	private String sponsor;

	private String teamname;

	private String website;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="visitor")
	private List<Game> games1;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="home")
	private List<Game> games2;

	//bi-directional many-to-one association to Roster
	@OneToMany(mappedBy="teamBean")
	private List<Roster> rosters;

	//bi-directional many-to-one association to League
	@ManyToOne
	@JoinColumn(name="LEAGUE")
	private League leagueBean;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="MANAGER")
	private Staff staff1;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="TRAINER")
	private Staff staff2;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="ASSTCOACH")
	private Staff staff3;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="HEADCOACH")
	private Staff staff4;

	public Team() {
	}

	public String getTeamid() {
		return this.teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public String getSponsor() {
		return this.sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getTeamname() {
		return this.teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Game> getGames1() {
		return this.games1;
	}

	public void setGames1(List<Game> games1) {
		this.games1 = games1;
	}

	public Game addGames1(Game games1) {
		getGames1().add(games1);
		games1.setVisitor(this);

		return games1;
	}

	public Game removeGames1(Game games1) {
		getGames1().remove(games1);
		games1.setVisitor(null);

		return games1;
	}

	public List<Game> getGames2() {
		return this.games2;
	}

	public void setGames2(List<Game> games2) {
		this.games2 = games2;
	}

	public Game addGames2(Game games2) {
		getGames2().add(games2);
		games2.setHome(this);

		return games2;
	}

	public Game removeGames2(Game games2) {
		getGames2().remove(games2);
		games2.setHome(null);

		return games2;
	}

	public List<Roster> getRosters() {
		return this.rosters;
	}

	public void setRosters(List<Roster> rosters) {
		this.rosters = rosters;
	}

	public Roster addRoster(Roster roster) {
		getRosters().add(roster);
		roster.setTeamBean(this);

		return roster;
	}

	public Roster removeRoster(Roster roster) {
		getRosters().remove(roster);
		roster.setTeamBean(null);

		return roster;
	}

	public League getLeagueBean() {
		return this.leagueBean;
	}

	public void setLeagueBean(League leagueBean) {
		this.leagueBean = leagueBean;
	}

	public Staff getStaff1() {
		return this.staff1;
	}

	public void setStaff1(Staff staff1) {
		this.staff1 = staff1;
	}

	public Staff getStaff2() {
		return this.staff2;
	}

	public void setStaff2(Staff staff2) {
		this.staff2 = staff2;
	}

	public Staff getStaff3() {
		return this.staff3;
	}

	public void setStaff3(Staff staff3) {
		this.staff3 = staff3;
	}

	public Staff getStaff4() {
		return this.staff4;
	}

	public void setStaff4(Staff staff4) {
		this.staff4 = staff4;
	}

}