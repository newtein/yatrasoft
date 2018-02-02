package yatrasoft;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
public class balancecontents {
     private String sno;
     private String uid;
     private TextField name;
     private String person;
     
     private String adultnon;
     private String scmnon;
     private String scfnon;
     private String childnon;
     
     private String adultac;
     private String scmac;
     private String scfac;
     private String childac;
     
     private String paid;
     private String balance;
     private String total;
     
     private String pluslabel;
     private TextField addpaid;
     

	public balancecontents(String sno, String uid, String name, String person, String adultnon, String scmnon,
			String scfnon, String childnon, String adultac, String scmac, String scfac, String childac, String paid,
			String balance, String total, String pluslabel,String xval) {
		super();
		this.sno = sno;
		this.uid = uid;
		this.name = new TextField(name);
		this.person = person;
		this.adultnon = adultnon;
		this.scmnon = scmnon;
		this.scfnon = scfnon;
		this.childnon = childnon;
		this.adultac = adultac;
		this.scmac = scmac;
		this.scfac = scfac;
		this.childac = childac;
		this.paid = paid;
		this.balance = balance;
		this.total = total;
		this.pluslabel = pluslabel;
		addpaid=new TextField(xval);
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public TextField getName() {
		return name;
	}
	public void setName(TextField name) {
		this.name = name;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getAdultnon() {
		return adultnon;
	}
	public void setAdultnon(String adultnon) {
		this.adultnon = adultnon;
	}
	public String getScmnon() {
		return scmnon;
	}
	public void setScmnon(String scmnon) {
		this.scmnon = scmnon;
	}
	public String getScfnon() {
		return scfnon;
	}
	public void setScfnon(String scfnon) {
		this.scfnon = scfnon;
	}
	public String getChildnon() {
		return childnon;
	}
	public void setChildnon(String childnon) {
		this.childnon = childnon;
	}
	public String getAdultac() {
		return adultac;
	}
	public void setAdultac(String adultac) {
		this.adultac = adultac;
	}
	public String getScmac() {
		return scmac;
	}
	public void setScmac(String scmac) {
		this.scmac = scmac;
	}
	public String getScfac() {
		return scfac;
	}
	public void setScfac(String scfac) {
		this.scfac = scfac;
	}
	public String getChildac() {
		return childac;
	}
	public void setChildac(String childac) {
		this.childac = childac;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getPluslabel() {
		return pluslabel;
	}
	public void setPluslabel(String pluslabel) {
		this.pluslabel = pluslabel;
	}
	public TextField getAddpaid() {
		return addpaid;
	}
	public void setAddpaid(TextField addpaid) {
		this.addpaid = addpaid;
	}
	
     
     
     
    
     
     
     
}
