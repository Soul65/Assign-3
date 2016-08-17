

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LEAGUE database table.
 * 
 */
@Entity
@NamedQuery(name="League.findAll", query="SELECT l FROM League l")
public class League implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String leagueid;

	private String leaguename;

	private String leaguesponsor;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="leagueBean")
	private List<Schedule> schedules;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="leagueBean")
	private List<Team> teams;

	public League() {
	}

	public String getLeagueid() {
		return this.leagueid;
	}

	public void setLeagueid(String leagueid) {
		this.leagueid = leagueid;
	}

	public String getLeaguename() {
		return this.leaguename;
	}

	public void setLeaguename(String leaguename) {
		this.leaguename = leaguename;
	}

	public String getLeaguesponsor() {
		return this.leaguesponsor;
	}

	public void setLeaguesponsor(String leaguesponsor) {
		this.leaguesponsor = leaguesponsor;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Schedule addSchedule(Schedule schedule) {
		getSchedules().add(schedule);
		schedule.setLeagueBean(this);

		return schedule;
	}

	public Schedule removeSchedule(Schedule schedule) {
		getSchedules().remove(schedule);
		schedule.setLeagueBean(null);

		return schedule;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team addTeam(Team team) {
		getTeams().add(team);
		team.setLeagueBean(this);

		return team;
	}

	public Team removeTeam(Team team) {
		getTeams().remove(team);
		team.setLeagueBean(null);

		return team;
	}

}