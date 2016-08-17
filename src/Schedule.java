

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SCHEDULE database table.
 * 
 */
@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int scheduleid;

	private String schedulename;

	private String season;

	private String sponsor;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="scheduleBean")
	private List<Game> games;

	//bi-directional many-to-one association to Playerstat
	@OneToMany(mappedBy="scheduleBean")
	private List<Playerstat> playerstats;

	//bi-directional many-to-one association to League
	@ManyToOne
	@JoinColumn(name="LEAGUE")
	private League leagueBean;

	public Schedule() {
	}

	public int getScheduleid() {
		return this.scheduleid;
	}

	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getSchedulename() {
		return this.schedulename;
	}

	public void setSchedulename(String schedulename) {
		this.schedulename = schedulename;
	}

	public String getSeason() {
		return this.season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSponsor() {
		return this.sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setScheduleBean(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setScheduleBean(null);

		return game;
	}

	public List<Playerstat> getPlayerstats() {
		return this.playerstats;
	}

	public void setPlayerstats(List<Playerstat> playerstats) {
		this.playerstats = playerstats;
	}

	public Playerstat addPlayerstat(Playerstat playerstat) {
		getPlayerstats().add(playerstat);
		playerstat.setScheduleBean(this);

		return playerstat;
	}

	public Playerstat removePlayerstat(Playerstat playerstat) {
		getPlayerstats().remove(playerstat);
		playerstat.setScheduleBean(null);

		return playerstat;
	}

	public League getLeagueBean() {
		return this.leagueBean;
	}

	public void setLeagueBean(League leagueBean) {
		this.leagueBean = leagueBean;
	}

}