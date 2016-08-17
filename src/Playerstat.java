

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PLAYERSTATS database table.
 * 
 */
@Entity
@Table(name="PLAYERSTATS")
@NamedQuery(name="Playerstat.findAll", query="SELECT p FROM Playerstat p")
public class Playerstat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int statsid;

	private int assists;

	private BigDecimal gaa;

	private int goals;

	private int gp;

	private int gwg;

	private int pim;

	private int plusminus;

	private int pp;

	private int sh;

	private BigDecimal shotpct;

	private int shots;

	private int so;

	private int suspensions;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="PLAYER")
	private Player playerBean;

	//bi-directional many-to-one association to Roster
	@ManyToOne
	@JoinColumn(name="ROSTER")
	private Roster rosterBean;

	//bi-directional many-to-one association to Schedule
	@ManyToOne
	@JoinColumn(name="SCHEDULE")
	private Schedule scheduleBean;

	public Playerstat() {
	}

	public int getStatsid() {
		return this.statsid;
	}

	public void setStatsid(int statsid) {
		this.statsid = statsid;
	}

	public int getAssists() {
		return this.assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public BigDecimal getGaa() {
		return this.gaa;
	}

	public void setGaa(BigDecimal gaa) {
		this.gaa = gaa;
	}

	public int getGoals() {
		return this.goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getGp() {
		return this.gp;
	}

	public void setGp(int gp) {
		this.gp = gp;
	}

	public int getGwg() {
		return this.gwg;
	}

	public void setGwg(int gwg) {
		this.gwg = gwg;
	}

	public int getPim() {
		return this.pim;
	}

	public void setPim(int pim) {
		this.pim = pim;
	}

	public int getPlusminus() {
		return this.plusminus;
	}

	public void setPlusminus(int plusminus) {
		this.plusminus = plusminus;
	}

	public int getPp() {
		return this.pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getSh() {
		return this.sh;
	}

	public void setSh(int sh) {
		this.sh = sh;
	}

	public BigDecimal getShotpct() {
		return this.shotpct;
	}

	public void setShotpct(BigDecimal shotpct) {
		this.shotpct = shotpct;
	}

	public int getShots() {
		return this.shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}

	public int getSo() {
		return this.so;
	}

	public void setSo(int so) {
		this.so = so;
	}

	public int getSuspensions() {
		return this.suspensions;
	}

	public void setSuspensions(int suspensions) {
		this.suspensions = suspensions;
	}

	public Player getPlayerBean() {
		return this.playerBean;
	}

	public void setPlayerBean(Player playerBean) {
		this.playerBean = playerBean;
	}

	public Roster getRosterBean() {
		return this.rosterBean;
	}

	public void setRosterBean(Roster rosterBean) {
		this.rosterBean = rosterBean;
	}

	public Schedule getScheduleBean() {
		return this.scheduleBean;
	}

	public void setScheduleBean(Schedule scheduleBean) {
		this.scheduleBean = scheduleBean;
	}

}