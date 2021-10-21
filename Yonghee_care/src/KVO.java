import java.sql.Date;

public class KVO {
	String nick;
	String type;
	int exp;
	int leb;
	int energy;
	String id;
	Date dama_date;
	public KVO() {}
	public KVO(String nick, String type, int exp, int leb, int energy, String id, Date dama_date) {
		super();
		this.nick = nick;
		this.type = type;
		this.exp = exp;
		this.leb = leb;
		this.energy = energy;
		this.id = id;
		this.dama_date = dama_date;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getLeb() {
		return leb;
	}
	public void setLeb(int leb) {
		this.leb = leb;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDama_date() {
		return dama_date;
	}
	public void setDama_date(Date dama_date) {
		this.dama_date = dama_date;
	}
	
	
}
