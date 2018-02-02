package yatrasoft;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
public class contents {
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

	public TextField getPhones() {
		return phones;
	}

	public void setPhones(TextField phones) {
		this.phones = phones;
	}

	  private TextField names;
      private TextField ages;
      private TextField phones;
      private ComboBox<String> acs;
      private ComboBox<String> genders;
      
   

	public ComboBox<String> getAcs() {
		return acs;
	}

	public void setAcs(ComboBox<String> acs) {
		this.acs = acs;
	}

	public ComboBox<String> getGenders() {
		return genders;
	}

	public void setGenders(ComboBox<String> genders) {
		this.genders = genders;
	}
   
	public contents(String yid,String names, String ages, String phones, String acs,ObservableList<String> packs, String genders) {
		super();
	  this.names=new TextField(names);
   	  this.ages=new TextField(ages);
   	  this.phones=new TextField(phones);
   	  this.acs=new ComboBox<>();
   	  this.acs.getItems().addAll(packs);
   	  this.acs.setValue(acs);
   
     this.genders=new ComboBox<>();
	 this.genders.getItems().addAll("Male","Female");
	 this.genders.setValue(genders);
	 
		
    
	}

	public contents(ObservableList<String> packs){
    	  names=new TextField();
    	  ages=new TextField();
    	  phones=new TextField();
    	  acs=new ComboBox<String>(packs);
    	 genders=new ComboBox<>();
    	 genders.getItems().addAll("Male","Female");
    	 
      }
       
}
