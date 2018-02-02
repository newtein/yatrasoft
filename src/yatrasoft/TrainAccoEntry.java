package yatrasoft;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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

public class TrainAccoEntry {
	Button button;
	Stage window;
	ComboBox<String> comboBox;
	Scene scene2;
	int row;
	  TableColumn<traincontent,TextField> namefield;
	  TableColumn<traincontent,TextField> agefield;
	  TableColumn<traincontent,TextField> coach1;
	  TableColumn<traincontent,TextField> coach2;
	  TableColumn<traincontent,TextField> coach3;
	  TableColumn<traincontent,TextField> coach4;
	  TableColumn<traincontent,TextField> seat1;
	  TableColumn<traincontent,TextField> seat2;
	  TableColumn<traincontent,TextField> seat3;
	  TableColumn<traincontent,TextField> seat4;
	  TableColumn<traincontent,TextField> tirupati;
	  TableColumn<traincontent,TextField> kanyakumari;
	  TableColumn<traincontent,TextField> rameswaram;
	  TextField amt1;
	  TextField amt2;
	  TextField amt3;
	  TextField amt4;
	 
	  
   public TrainAccoEntry(Stage primaryStage){
	   window=primaryStage;
	   window.setTitle("Train and Accommodation");
	      button = new Button("Submit");
	      MysqlCon obj=new MysqlCon();
	      showscene2(obj);
	   
   }
   void showscene2(MysqlCon obj){
	   
		  
		  namefield=new TableColumn<>("Name");
		  namefield.setMaxWidth(150);
		  namefield.setCellValueFactory(new PropertyValueFactory<>("names"));
		  
		  agefield=new TableColumn<>("Gender");
		  agefield.setMaxWidth(80);
		  agefield.setCellValueFactory(new PropertyValueFactory<>("ages"));
		  
		  coach1=new TableColumn<>("Math-TPTY");
		  coach1.setMaxWidth(80);
		  coach1.setCellValueFactory(new PropertyValueFactory<>("coach1"));
		  
		  seat1=new TableColumn<>("Seat");
		  seat1.setMaxWidth(60);
		  seat1.setCellValueFactory(new PropertyValueFactory<>("seat1"));
		  
		  
		  coach2=new TableColumn<>("TPTY-RMM");
		  coach2.setMaxWidth(80);
		  coach2.setCellValueFactory(new PropertyValueFactory<>("coach2"));
		  
		  seat2=new TableColumn<>("Seat");
		  seat2.setMaxWidth(60);
		  seat2.setCellValueFactory(new PropertyValueFactory<>("seat2"));
		  
		  coach3=new TableColumn<>("MDU-Kanya");
		  coach3.setMaxWidth(100);
		  coach3.setCellValueFactory(new PropertyValueFactory<>("coach3"));
		  
		  seat3=new TableColumn<>("Seat");
		  seat3.setMaxWidth(60);
		  seat3.setCellValueFactory(new PropertyValueFactory<>("seat3"));
		  
		  coach4=new TableColumn<>("TVC-Math");
		  coach4.setMinWidth(20);
		  coach4.setMaxWidth(60);
		  coach4.setCellValueFactory(new PropertyValueFactory<>("coach4"));
		  
		  seat4=new TableColumn<>("Seat");
		  seat4.setMinWidth(25);
		  seat4.setMaxWidth(60);
		  seat4.setCellValueFactory(new PropertyValueFactory<>("seat4"));
		  
		  tirupati=new TableColumn<>("Tirupati Acco");
		  tirupati.setMinWidth(80);
		  tirupati.setMaxWidth(100);
		  tirupati.setCellValueFactory(new PropertyValueFactory<>("tirupati"));
		  
		  kanyakumari=new TableColumn<>("Kanyak Acco");
		  kanyakumari.setMinWidth(80);
		  kanyakumari.setMaxWidth(100);
		  kanyakumari.setCellValueFactory(new PropertyValueFactory<>("kanyakumari"));
		  
		  rameswaram=new TableColumn<>("RMM Acco");
		  rameswaram.setMinWidth(80);
		  rameswaram.setMaxWidth(100);
		  rameswaram.setCellValueFactory(new PropertyValueFactory<>("rameswaram"));
		  

		  
		  ObservableList<traincontent> content = FXCollections.observableArrayList();
		  
		  row=0;int ptr=0;
			try{
				ResultSet rs=obj.stmt.executeQuery("select name,gender,train1, train2, train3,train4,tirupati,rameswaram,kanyakumari from train order by id");// where id="+"'"+selid+"'");
				rs.last();
				row = rs.getRow();
				rs.beforeFirst();
				
				while(rs.next()){
					   String ttrain1=rs.getString(3);
					   String tcoach1=String.valueOf(ttrain1.charAt(0))+String.valueOf(ttrain1.charAt(1))+String.valueOf(ttrain1.charAt(2));
					   String tseat1=String.valueOf(ttrain1.charAt(3))+String.valueOf(ttrain1.charAt(4));
					   
					   String ttrain2=rs.getString(4);
					   String tcoach2=String.valueOf(ttrain2.charAt(0))+String.valueOf(ttrain2.charAt(1))+String.valueOf(ttrain2.charAt(2));
					   String tseat2=String.valueOf(ttrain2.charAt(3))+String.valueOf(ttrain2.charAt(4));
					   
					   String ttrain3=rs.getString(5);
					   String tcoach3=String.valueOf(ttrain3.charAt(0))+String.valueOf(ttrain3.charAt(1))+String.valueOf(ttrain3.charAt(2));
					   String tseat3=String.valueOf(ttrain3.charAt(3))+String.valueOf(ttrain3.charAt(4));
					   
					   String ttrain4=rs.getString(6);
					   String tcoach4=String.valueOf(ttrain4.charAt(0))+String.valueOf(ttrain4.charAt(1))+String.valueOf(ttrain4.charAt(3));
					   String tseat4=String.valueOf(ttrain4.charAt(3))+String.valueOf(ttrain4.charAt(4));
					 
					   content.add(new traincontent(rs.getString(1),rs.getString(2),tcoach1,tcoach2,tcoach3,tcoach4,tseat1,tseat2,tseat3,tseat4,rs.getString(7),rs.getString(8),rs.getString(9)));
					 
				ptr++;
				}
			
				  
			}
			catch(Exception e){ System.out.println(e);} 
			
			    TableView<traincontent> table=new TableView<>();
			    table.setItems(content);
			    table.getColumns().addAll(namefield,agefield,coach1,seat1,coach2,seat2,coach3,seat3,coach4,seat4,tirupati,rameswaram,kanyakumari);
                
			    Button submit=new Button("Submit");
			   submit.setOnAction(e->submitit(obj,row));
			    submit.setPadding(new Insets(10, 20, 10, 20));
			    
			    final Text showid=new Text();
			    showid.setStyle("-fx-font-weight:bold;-fx-font-stroke:blue;-fx-fill:red;");
			    showid.setText("Note:Write coach S1 as S01 and seat 1 as 01");
			    showid.setFont(Font.font("Verdana", 12));
			
			    
			    VBox vbox=new VBox();
			    vbox.setAlignment(Pos.CENTER);
			    vbox.setPrefSize(1100, 600);
			    vbox.getChildren().addAll(showid,table,submit);
			  
			    vbox.setStyle("-fx-background-image: url('file:///D:/jouney/dpy2017/Image/dimage.jpg');");
			    Scene scene=new Scene(vbox);
			    window.setScene(scene);
			    window.centerOnScreen();
			    window.show();
		  
		 
   }
   void alertclass(String error){
	   Alert alert = new Alert(AlertType.ERROR);
	   alert.setTitle("Error");
	   alert.setHeaderText("Invalid Entry,Submit Again");
	   alert.setContentText(error);

	   alert.showAndWait();
   }
   void submitit(MysqlCon obj,int row){
	   String t1,t2,t3,t4,tquery;
	 
	   int flag=0;
	   for(int i=0;i<row;i++){
		   
		  if(coach1.getCellData(i).getText().length()!=3||coach2.getCellData(i).getText().length()!=3||coach3.getCellData(i).getText().length()!=3||coach4.getCellData(i).getText().length()!=3)
		  {
			alertclass("Invalid Entry in row "+i+1+"Coach Length should be 3 eg S1=S01");
			flag=1;
		  
	       }
		  if(seat1.getCellData(i).getText().length()!=2||seat2.getCellData(i).getText().length()!=2||seat2.getCellData(i).getText().length()!=2||seat4.getCellData(i).getText().length()!=2)
		  {
			alertclass("Invalid Entry in row "+i+1+"seat Length should be 2 eg 6=06");
			flag=1;
		  
	       }
	   }
	  if(flag==0){ 
	   for(int i=0;i<row;i++){
		   t1=coach1.getCellData(i).getText()+seat1.getCellData(i).getText();
		   t2=coach2.getCellData(i).getText()+seat2.getCellData(i).getText();
		   t3=coach3.getCellData(i).getText()+seat3.getCellData(i).getText();
		   t4=coach4.getCellData(i).getText()+seat4.getCellData(i).getText();
		 
		   tquery="update train set train1='"+t1+"',train2='"+t2+"',train3='"+t3+"',train4='"+t4+"',tirupati='"+tirupati.getCellData(i).getText()+"',kanyakumari='"+kanyakumari.getCellData(i).getText()+"',rameswaram='"+rameswaram.getCellData(i).getText()+"' where name='"+namefield.getCellData(i).getText()+"'";
	       try{
		   obj.stmt.executeUpdate(tquery);
	       }
	       catch (Exception e){
	    	  System.out.println(e); 
	       }
	       
	   }
	  
	      Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Success");
		  alert.setHeaderText("Data Updated Successfully!!");
		  alert.setContentText("Done-)");

		  alert.show();

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
}
