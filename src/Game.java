

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the GAME database table.
 * 
 */
@Entity
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int gameid;

	@Temporal(TemporalType.DATE)
	private Date gamedate;

	private Time gametime;

	private int homescore;

	private String ot;

	private String so;

	private int visitorscore;

	//bi-directional many-to-one association to Arena
	@ManyToOne
	@JoinColumn(name="ARENA")
	private Arena arenaBean;

	//bi-directional many-to-one association to Schedule
	@ManyToOne
	@JoinColumn(name="SCHEDULE")
	private Schedule scheduleBean;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="VISITOR")
	private Team visitor;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="HOME")
	private Team home;

	public Game() {
	}

	public int getGameid() {
		return this.gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public Date getGamedate() {
		return this.gamedate;
	}

	public void setGamedate(Date gamedate) {
		this.gamedate = gamedate;
	}

	public Time getGametime() {
		return this.gametime;
	}

	public void setGametime(Time gametime) {
		this.gametime = gametime;
	}

	public int getHomescore() {
		return this.homescore;
	}

	public void setHomescore(int homescore) {
		this.homescore = homescore;
	}

	public String getOt() {
		return this.ot;
	}

	public void setOt(String ot) {
		this.ot = ot;
	}

	public String getSo() {
		return this.so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public int getVisitorscore() {
		return this.visitorscore;
	}

	public void setVisitorscore(int visitorscore) {
		this.visitorscore = visitorscore;
	}

	public Arena getArenaBean() {
		return this.arenaBean;
	}

	public void setArenaBean(Arena arenaBean) {
		this.arenaBean = arenaBean;
	}

	public Schedule getScheduleBean() {
		return this.scheduleBean;
	}

	public void setScheduleBean(Schedule scheduleBean) {
		this.scheduleBean = scheduleBean;
	}

	public Team getVisitor() {
		return this.visitor;
	}

	public void setVisitor(Team visitor) {
		this.visitor = visitor;
	}

	public Team getHome() {
		return this.home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

}