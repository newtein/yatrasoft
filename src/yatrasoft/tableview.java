package yatrasoft;

import java.sql.ResultSet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tableview {
  private Stage window;
  TableView<contents> table;
  String selid,selname;
  int totalpass,passen;
  TextField paidamt;
  private String yid;
  Scene scene;
  Scene scene2;
  Button button;
  ComboBox<String> comboBox;
  
  TextField num;
  
  String idname;
  int totalpersons;
  TableColumn<contents,TextField> namefield;
  TableColumn<contents,TextField> phonefield;
  TableColumn<contents,TextField> agefield;
  TableColumn<contents,ComboBox<String>> genderfield;
  TableColumn<contents,ComboBox<String>> acfield;
  


  public void editpage(Stage primaryStage,String x) {
      window = primaryStage;
      yid=x;
      window.setTitle("Edit Page");
      button = new Button("Submit");
      MysqlCon obj=new MysqlCon();
      obj.idshowname(yid);
      comboBox = new ComboBox<>();
      for(int i=0;i<obj.id.length;i++){
      	comboBox.getItems().add(obj.names[i]+"\t\t"+obj.id[i]);
      	
      }
                    
      comboBox.setPromptText("Select Passenger ID");
      button.setOnAction(e -> showscene2(obj));
      Label label=new Label("Enter no. of passengers to add [0 to EDIT]");
      num=new TextField("0");
     
      
      VBox layout = new VBox(20);
      layout.setPadding(new Insets(40, 20, 20, 20));
      layout.setMargin(button,new Insets(20, 0, 0, 0));
      layout.getChildren().addAll(comboBox,label,num, button);
      layout.setStyle("-fx-background-image: url('file:///D:/jouney/dpy2017/Image/flight.jpg');");
      scene2 = new Scene(layout, 500, 350);
      window.setScene(scene2);
      window.centerOnScreen();
      window.show();
      
  }

  private void showscene2(MysqlCon obj){
	  
	  String s=comboBox.getValue();
	  String idNname[]=new String[2];
	  idNname=s.split("\t\t"); 
	  selid=idNname[1];
	  
	  passen=Integer.parseInt(num.getText());
	  
	  obj.iddetail(selid);
	  selname=obj.getbalcname();
	  totalpass=obj.getbalcpersons();
  	
      namefield=new TableColumn<>("Name");
	  namefield.setMinWidth(200);
	  namefield.setCellValueFactory(new PropertyValueFactory<>("names"));
	  
	  phonefield=new TableColumn<>("Phone");
	  phonefield.setMinWidth(150);
	  phonefield.setCellValueFactory(new PropertyValueFactory<>("phones"));
	  
	  agefield=new TableColumn<>("Age/DDMMYYYY");
	  agefield.setMinWidth(120);
	  agefield.setCellValueFactory(new PropertyValueFactory<>("ages"));
	  
	  acfield=new TableColumn<>("Package");
	  acfield.setMinWidth(100);
	  acfield.setCellValueFactory(new PropertyValueFactory<>("acs"));
	  
	  genderfield=new TableColumn<>("Gender");
	  genderfield.setMinWidth(100);
	  genderfield.setCellValueFactory(new PropertyValueFactory<>("genders"));

	  ObservableList<contents> content = FXCollections.observableArrayList();
	  ObservableList<String> options = FXCollections.observableArrayList();
	  options=obj.getpackage(selid);
	  System.out.println(options);
	  int row=0,ptr=0;
		try{
			ResultSet rs=obj.stmt.executeQuery("select name, phone, age, gender,ac from pilgrim where id="+"'"+selid+"'");
			rs.last();
			row = rs.getRow();
			rs.beforeFirst();
		
			while(rs.next()){
				   content.add(new contents(selid,rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(5),options,rs.getString(4)));
		
			ptr++;
			}
		}
		catch(Exception e){ System.out.println(e);} 
	  
	 
	   
	  
	  for(int i=0;i<passen;i++)
	      content.add(new contents(options));
	  
    table=new TableView<>();
    table.setItems(content);
    table.getColumns().addAll(namefield,phonefield,agefield,acfield,genderfield);

    Button submit=new Button("Submit");
    submit.setOnAction(e->submitit(obj));
    submit.setPadding(new Insets(10, 20, 10, 20));
    
    final Text showid=new Text();
    showid.setStyle("-fx-font-weight:bold;-fx-font-stroke:blue;-fx-fill:blue;");
    showid.setText("ID:\t "+selid+"\t\t\tName:\t "+selname+"\t\t\tTotal Pilgrims:\t "+totalpass);
    showid.setFont(Font.font("Verdana", 12));
    
    Label amtdisp=new Label("Amount Paid");
    paidamt=new TextField();
    paidamt.setMaxWidth(100);
    paidamt.setMaxHeight(50);
    
    VBox vbox=new VBox(20);
    vbox.setAlignment(Pos.CENTER);
    vbox.getChildren().addAll(showid,table,amtdisp,paidamt,submit);
  
    vbox.setStyle("-fx-background-image: url('file:///D:/jouney/dpy2017/Image/dimage.jpg');");
    scene=new Scene(vbox);
    window.setScene(scene);
    window.centerOnScreen();
    window.show();
  	
  	

  }
  public void submitit(MysqlCon obj){
	int total=totalpass+passen;
	int alreadypaid=0;
	  page2 pobj=new page2();
	  pobj.names=new String[total];
	  pobj.agess=new int[total];
	  pobj.phones=new String[total];
	  pobj.acs=new String[total];
	  pobj.genders=new String[total];
	  pobj.charges=new int[total];
	  pobj.dobs=new int[total];
	 
	  int dob=0,tage=0,tcharge=0,charge=0;
	  String sex="";
	  try{
	  ResultSet rs=obj.stmt.executeQuery("select paid from balancesheet where id='"+selid+"'");
	    rs.next();
		alreadypaid=rs.getInt(1);
		
	  }  catch(Exception e){ System.out.println(e);} 
	  
	  try{
		  String queryPil="delete from pilgrim where id='"+selid+"'";
		  obj.stmt.executeUpdate(queryPil);
		
		
		  String queryBal="delete from balancesheet where id='"+selid+"'";
		  
		 
		  obj.stmt.executeUpdate(queryBal);
		  
		  obj.stmt.executeUpdate("delete from train where id='"+selid+"'");
		  
		  obj.stmt.executeUpdate("delete from trainamt where id='"+selid+"'");
			
		  
	  }
	  catch(Exception e){ System.out.println(e);} 
	  
	  int clr=0;
	  
	  for(int i=0;i<total;i++){
		  
		  //age
	
		  if(!agefield.getCellData(i).getText().isEmpty() && agefield.getCellData(i).getText().length()==2){
				
		       tage=Integer.parseInt(agefield.getCellData(i).getText());
		       dob=0;
		     
		}
		else if(!agefield.getCellData(i).getText().isEmpty() && agefield.getCellData(i).getText().length()==8){
			   dob=Integer.parseInt(agefield.getCellData(i).getText());
		       tage=pobj.getage(agefield.getCellData(i).getText());
		       
		       
		}
		  //age ends
		  //ac
		  String tac;
		  tac=acfield.getCellData(i).getValue();
		  
	      //ac ends
		  String dispsex=genderfield.getCellData(i).getValue();
		
		  if(dispsex=="Male"||dispsex=="Female"){
			
			if(dispsex=="Male")
				sex="male";
			else if (dispsex=="Female")
				sex="female";
		  
		
			
		    if(tage>=60 && sex=="male")
	  		      sex="SCM";    	
	  	          	 
	  	        else if (tage>=58 && sex=="female")
	  		      sex="SCF";
	  		  	 
	  	        else if(tage>5&&tage<11)
	  		      sex="child";
	    	 
	  	        else if(tage<=5)
	  		    sex="infant";
	  		 	 
	  	        else 
	  		     sex="A";
			
		  }
		  else sex=dispsex;
		  
		    charge=pobj.getfare(yid,sex,tac);
	        System.out.println(charge+sex+tac);
			 
		    pobj.names[i]=namefield.getCellData(i).getText();
		    pobj.agess[i]=tage;
		    pobj.acs[i]=tac;
		    pobj.genders[i]=sex;
		    pobj.charges[i]=charge;
		    pobj.dobs[i]=dob;
		    pobj.phones[i]=phonefield.getCellData(i).getText();
		
		
	  obj.insert(selid,namefield.getCellData(i).getText(),phonefield.getCellData(i).getText(),tage, tac, dob, charge, sex);
	
	  }
	  int cash=0;
	        try{
			    cash=Integer.parseInt(paidamt.getText());
			    System.out.println("now paid "+cash);
			}catch(NumberFormatException ex){ 
			    cash=0;
			}
	  pobj.setamtpaid(cash+alreadypaid);
	  int balc=pobj.createbalancesheet(selid, obj);
	
	  Alert alert = new Alert(AlertType.INFORMATION);
	  alert.setTitle("Success");
	  alert.setHeaderText("Data Updated Successfully!!");
	  alert.setContentText("Remaining Balance for id: "+selid+" is Rs "+balc);

	  alert.showAndWait();

	  obj.close();
	
	
	  try{
		  newsoft nobj=new newsoft();
		  nobj.start(window);
		  }
		  catch(Exception e) {
			  System.out.println("fail");
		  }
	    
	  }

}
