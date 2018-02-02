package yatrasoft;

import java.sql.ResultSet;
import java.util.Objects;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class balancesheet {
	      TableView<balancecontents> table;
	      TableColumn<balancecontents,String>  snofield;
	      TableColumn<balancecontents,String> uidfield;
	      TableColumn<balancecontents,TextField> namefield;
	      TableColumn<balancecontents,String>  personfield;
	     
	      TableColumn<balancecontents,String>  adultnonfield;
	      TableColumn<balancecontents,String>  scmnonfield;
	      TableColumn<balancecontents,String>  scfnonfield;
	      TableColumn<balancecontents,String>  childnonfield;
	     
	      TableColumn<balancecontents,String>  adultacfield;
	      TableColumn<balancecontents,String>  scmacfield;
	      TableColumn<balancecontents,String>  scfacfield;
	      TableColumn<balancecontents,String>  childacfield;
	     
	      TableColumn<balancecontents,String>  paidfield;
	      TableColumn<balancecontents,String>  balancefield;
	      TableColumn<balancecontents,String>  totalfield;
	      
	      TableColumn<balancecontents,String> pluslabelfield;
	      TableColumn<balancecontents,TextField> addpaidfield;
	      public Stage window;
	      String namearray[];
	      Scene scene;
	      int row=0;
	
	  public void showbalc(Stage primaryStage) {
		  window = primaryStage;
	      window.setTitle("Balance Sheet");
	      
	      snofield=new TableColumn<>("sno"); snofield.setMinWidth(50); 
	       snofield.setCellValueFactory(new PropertyValueFactory<>("sno"));
	      
	       uidfield=new TableColumn<>("ID"); uidfield.setMinWidth(50); 
	       uidfield.setCellValueFactory(new PropertyValueFactory<>("uid"));
	       
	       namefield=new TableColumn<>("Name"); namefield.setMinWidth(150);
	       namefield.setCellValueFactory(new PropertyValueFactory<>("name"));
	       
	        personfield=new TableColumn<>("Person"); personfield.setMinWidth(50);
	        personfield.setCellValueFactory(new PropertyValueFactory<>("person"));
	     
	        adultnonfield=new TableColumn<>("AdultNon"); adultnonfield.setMinWidth(50);
	        adultnonfield.setCellValueFactory(new PropertyValueFactory<>("adultnon"));
	        
	        scmnonfield=new TableColumn<>("scmnon"); scmnonfield.setMinWidth(50);
	        scmnonfield.setCellValueFactory(new PropertyValueFactory<>("scmnon"));
	      
	        
	        scfnonfield=new TableColumn<>("scfnon"); scfnonfield.setMinWidth(50);
	        scfnonfield.setCellValueFactory(new PropertyValueFactory<>("scfnon"));
	        
	        childnonfield=new TableColumn<>("childnon"); childnonfield.setMinWidth(50);
	        childnonfield.setCellValueFactory(new PropertyValueFactory<>("childnon"));
	        
	        adultacfield=new TableColumn<>("AdultAC"); adultacfield.setMinWidth(50);
	        adultacfield.setCellValueFactory(new PropertyValueFactory<>("adultac"));
	        
	        scmacfield=new TableColumn<>("scmac"); scmacfield.setMinWidth(50);
	        scmacfield.setCellValueFactory(new PropertyValueFactory<>("scmac"));
	        
	        scfacfield=new TableColumn<>("scfac"); scfacfield.setMinWidth(50);
	        scfacfield.setCellValueFactory(new PropertyValueFactory<>("scfac"));
	        
	        childacfield=new TableColumn<>("childac"); childacfield.setMinWidth(50);
	        childacfield.setCellValueFactory(new PropertyValueFactory<>("childac"));
	
	        paidfield=new TableColumn<>("paid"); paidfield.setMinWidth(50);
	        paidfield.setCellValueFactory(new PropertyValueFactory<>("paid"));
	        
	        balancefield=new TableColumn<>("balance"); balancefield.setMinWidth(50);
	        balancefield.setCellValueFactory(new PropertyValueFactory<>("balance"));
	        
	        totalfield=new TableColumn<>("total"); totalfield.setMinWidth(50);
	        totalfield.setCellValueFactory(new PropertyValueFactory<>("total"));
	        
	        //TableColumn<balancecontents,Label> pluslabel;
		     // TableColumn<balancecontents,TextField> addpaid;
	        
	        pluslabelfield=new TableColumn<>(""); pluslabelfield.setMinWidth(50);
	        pluslabelfield.setCellValueFactory(new PropertyValueFactory<>("pluslabel"));
	        
	        addpaidfield=new TableColumn<>("Update"); addpaidfield.setMaxWidth(100);
	        addpaidfield.setCellValueFactory(new PropertyValueFactory<>("addpaid"));
	        
	      ObservableList<balancecontents> content = FXCollections.observableArrayList();
	      MysqlCon myobj=new MysqlCon();
	      int pc=0;
	 
	  	try{
			ResultSet rs=myobj.stmt.executeQuery("select * from balancesheet order by balance desc");
			   
		        rs.last();
				row = rs.getRow();
				rs.beforeFirst();
				namearray=new String[row];
			while(rs.next()){
				namearray[pc]=rs.getString(2);
				content.add(new balancecontents(String.valueOf(pc+1),rs.getString(1),rs.getString(2), String.valueOf(rs.getInt(3)),String.valueOf(rs.getInt(4)),String.valueOf(rs.getInt(5)),
						String.valueOf(rs.getInt(6)),String.valueOf(rs.getInt(7)), String.valueOf(rs.getInt(8)), String.valueOf(rs.getInt(9)),String.valueOf(rs.getInt(10)),String.valueOf(rs.getInt(11)), String.valueOf(rs.getInt(12)),
						String.valueOf(rs.getInt(13)), String.valueOf(rs.getInt(14)),"+","0"));
				pc=pc+1;
			}
		}
		catch(Exception e){ System.out.println(e);} 

	      table=new TableView<>();
	      table.setItems(content);
	      table.getColumns().addAll(  snofield,
	    		  uidfield,
	    		  namefield,
	    		   personfield,

	    		   adultnonfield,
	    		   scmnonfield,
	    		   scfnonfield,
	    		   childnonfield,

	    		   adultacfield,
	    		   scmacfield,
	    		   scfacfield,
	    		   childacfield,

	    		   paidfield,pluslabelfield,addpaidfield,
	    		   balancefield,
	    		   totalfield);
	      
	      Button submit=new Button("Update!");
	      submit.setMaxHeight(50);
	      submit.setMaxWidth(100);
	      submit.setOnAction(e->updateit(myobj,row));
	  
	      VBox layout = new VBox(20);
	      layout.setPadding(new Insets(40, 20, 20, 20));
	      layout.setStyle("-fx-background-image: url('file:///D:/jouney/dpy2017/Image/dimage.jpg');");
	      layout.getChildren().addAll(table,submit);
	   
	      scene = new Scene(layout,1200,600);
	      window.setScene(scene);
	      window.centerOnScreen();
	      window.show();
	  }
	  private void updateit(MysqlCon myobj,int row){
		  
		  for(int i=0;i<row;i++){
			  
			  int addpaid=Integer.parseInt(addpaidfield.getCellData(i).getText());
			  String newname=namefield.getCellData(i).getText();
			  if(addpaid!=0||!Objects.equals(newname,namearray[i])){
				 
			  myobj.updatesheetshort(uidfield.getCellData(i),newname,0,0,0,0,0,0,0,0,0,addpaid,-addpaid,0);
			  }
		  }
		  myobj.close();
		  
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Success");
		  alert.setHeaderText("Balancesheet Updated Successfully!!");
		  alert.setContentText("Thanks for Using!");
		  alert.showAndWait();
		  
		  try{
		  newsoft nobj=new newsoft();	  
		  nobj.start(window);
		  }
		  catch(Exception e) {
			  System.out.println("fail");
		  }
	  }
}

