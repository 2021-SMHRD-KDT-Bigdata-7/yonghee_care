import java.sql.Date;

public class KVO {
	String nick;
	String dmtype; /// xkdlq -> dmtype
	int dmexp; // rudgjacl -> dmexp
	int lv;
	int energy = 0;
	String id;
	String pw;
	Date dmdate; // dama_date -> dmdate

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getDmtype() {
		return dmtype;
	}

	public void setDmtype(String dmtype) {
		this.dmtype = dmtype;
	}

	public int getDmexp() {
		return dmexp;
	}

	public void setDmexp(int dmexp) {
		this.dmexp = dmexp;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getDmdate() {
		return dmdate;
	}

	public void setDmdate(Date dmdate) {
		this.dmdate = dmdate;
	}

}