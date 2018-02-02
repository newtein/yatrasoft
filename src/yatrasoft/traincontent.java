package yatrasoft;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class traincontent {
	  private TextField names;
      private TextField ages;
      private TextField coach1;
      private TextField coach2;
      private TextField coach3;
      private TextField coach4;
      private TextField seat1;
      private TextField seat2;
      private TextField seat3;
      private TextField seat4;
      private TextField tirupati;
      private TextField rameswaram;
      private TextField kanyakumari;
      
      
      
	public traincontent(String names, String ages, String coach1, String coach2,
			 String  coach3,  String  coach4, String seat1, String seat2, String seat3,
			String seat4,String tirupati,String rameswaram,String kanyakumari) {
		super();
		this.names = new TextField(names);
		this.ages = new TextField(ages);
		
		this.coach1 = new TextField(coach1);
		this.seat1=new TextField(seat1);
		
		this.coach2 = new TextField(coach2);
		this.seat2=new TextField(seat2);
		
		this.coach3 = new TextField(coach3);
		this.seat3=new TextField(seat3);
		
		this.coach4 = new TextField(coach4);
		this.seat4=new TextField(seat4);
		this.tirupati=new TextField(tirupati);
		this.rameswaram=new TextField(rameswaram);
		this.kanyakumari=new TextField(kanyakumari);
		
		
	}


	public TextField getRameswaram() {
		return rameswaram;
	}


	public void setRameswaram(TextField rameswaram) {
		this.rameswaram = rameswaram;
	}


	public TextField getTirupati() {
		return tirupati;
	}


	public void setTirupati(TextField tirupati) {
		this.tirupati = tirupati;
	}


	public TextField getKanyakumari() {
		return kanyakumari;
	}


	public void setKanyakumari(TextField kanyakumari) {
		this.kanyakumari = kanyakumari;
	}


	public TextField getNames() {
		return names;
	}


	public void setNames(TextField names) {
		this.names = names;
	}


	public TextField getAges() {
		return ages;
	}


	public void setAges(TextField ages) {
		this.ages = ages;
	}


	public TextField getCoach1() {
		return coach1;
	}


	public void setCoach1(TextField coach1) {
		this.coach1 = coach1;
	}


	public TextField getCoach2() {
		return coach2;
	}


	public void setCoach2(TextField coach2) {
		this.coach2 = coach2;
	}


	public TextField getCoach3() {
		return coach3;
	}


	public void setCoach3(TextField coach3) {
		this.coach3 = coach3;
	}


	public TextField getCoach4() {
		return coach4;
	}


	public void setCoach4(TextField coach4) {
		this.coach4 = coach4;
	}


	public TextField getSeat1() {
		return seat1;
	}


	public void setSeat1(TextField seat1) {
		this.seat1 = seat1;
	}


	public TextField getSeat2() {
		return seat2;
	}


	public void setSeat2(TextField seat2) {
		this.seat2 = seat2;
	}


	public TextField getSeat3() {
		return seat3;
	}


	public void setSeat3(TextField seat3) {
		this.seat3 = seat3;
	}


	public TextField getSeat4() {
		return seat4;
	}


	public void setSeat4(TextField seat4) {
		this.seat4 = seat4;
	}
	
	
      
      

}
