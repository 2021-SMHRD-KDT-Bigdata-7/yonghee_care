import java.sql.Date;

public class KVO {
   String nick;
   String xkdlq;
   int rudgjacl;
   int leb;
   int energy;
   String id;
   Date dama_date;
   public KVO() {}
   public KVO(String nick, String xkdlq, int rudgjacl, int leb, int energy, String id, Date dama_date) {
      super();
      this.nick = nick;
      this.xkdlq = xkdlq;
      this.rudgjacl = rudgjacl;
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
   public String getXkdlq() {
      return xkdlq;
   }
   public void setXkdlq(String xkdlq) {
      this.xkdlq = xkdlq;
   }
   public int getRudgjacl() {
      return rudgjacl;
   }
   public void setRudgjacl(int rudgjacl) {
      this.rudgjacl = rudgjacl;
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