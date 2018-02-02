package yatrasoft;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class newsoft extends Application {
  
		    Button add;
			Button edit;
			Button balance;
			Button delete;
			Stage window;
			Scene index;
			Button Train;
			String yid;
			
			
			@Override
			public void start(Stage primaryStage) throws Exception {
			window=primaryStage;
			window.setTitle("Welcome");
			
			add=new Button("Add New Passengers!");
			add.setMinSize(200, 50);
			edit=new Button("Add or Edit Existing Passengers!");
			edit.setMinSize(200, 50);
			balance=new Button("Update Balancesheet!");
			balance.setMinSize(200, 50);
			delete=new Button("Generate Excel Sheets & Update Expense");
			delete.setMinSize(200, 50);
			Train=new Button("ADD Trains and Accomodation");
			Train.setMinSize(200, 50);
			
			Button addexpense=new Button("ADD/UPDATE Expense");
			addexpense.setMinSize(200, 50);
			addexpense.setOnAction(e->callexpense());
			
			   TextInputDialog dialog = new TextInputDialog("dpr2017");
				dialog.setTitle("Welcome");
				dialog.setHeaderText("Just a moment!");
				dialog.setContentText("Enter Yatra ID: ");

				// Traditional way to get the response value.
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()){
				   yid=result.get();
				}
			
			
			
			
			add.setOnAction(e->new page2(yid));
			edit.setOnAction(e->editcall());
			balance.setOnAction(e->showbalance());
			delete.setOnAction(e->generatecall());
			Train.setOnAction(e->callTrainAccoEntry());
			
			VBox layout=new VBox(20);
			layout.getChildren().addAll(add,edit,balance,Train,addexpense,delete);
			index=new Scene(layout,500,450);			
			layout.setStyle("-fx-background-image: url('file:///D:/jouney/dpy2017/Image/flight.jpg');");
			layout.setAlignment(Pos.CENTER);
			
			window.setScene(index);
			window.centerOnScreen();
			window.show();
	    }
	 public static void main(String[] args){
		 
		    launch(args);
			
		}
	 public void callexpense(){
		 expense obj=new expense(window);
	 }
	 public void callTrainAccoEntry(){
		 TrainAccoEntry obj=new TrainAccoEntry(window);
		 
	 }
	 public void editcall(){
		 tableview obj=new tableview();
		 obj.editpage(window,yid);
	 
	 }
	 public void generatecall(){
		 generateexcel obj=new generateexcel(yid);
		 
	 
	 }
	 public void showbalance(){
		 balancesheet bobj=new balancesheet();
		 bobj.showbalc(window);
		 
	 }
	
	 
	 public Scene getIndex(){
		 return index;
	 }
	


	}
	
	
	


/*
 	
 */

