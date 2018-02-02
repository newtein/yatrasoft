package yatrasoft;

import java.sql.ResultSet;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class expense {
	Stage window;
	TextField remark;
	TextField value;
	public expense(Stage primageStage){
		window=primageStage;
		window.setTitle("Add/Update Expense");
		
		Label label=new Label("Enter Remark (existing remark will update while new will be inserted):");
		remark=new TextField();
		
		Label label2=new Label("Enter Value in Rs:");
		value=new TextField();
		
		Button submit=new Button("Submit");
		submit.setOnAction(e->addexpense());
		
		VBox layout=new VBox(20);
		layout.getChildren().addAll(label,remark,label2,value,submit);
		Scene index=new Scene(layout,500,350);			
		layout.setStyle("-fx-background-image: url('file:///D:/jouney/dpy2017/Image/flight.jpg');");
		layout.setAlignment(Pos.CENTER);
		
		window.setScene(index);
		window.centerOnScreen();
		window.show();
		
		
	}
	void addexpense(){
		try{
		MysqlCon obj=new MysqlCon();
		ResultSet rs=obj.stmt.executeQuery("select * from expense where remark='"+remark.getText()+"'");
		rs.last();
		int row = rs.getRow();
		if(row==0){
			System.out.println("hey");
			obj.stmt.executeUpdate("insert into expense(remark,value) values('"+remark.getText()+"', '"+Integer.parseInt(value.getText())+"')");
		}
		else{
			obj.stmt.executeUpdate("update expense set value= "+Integer.parseInt(value.getText())+" where remark='"+remark.getText()+"'");
			
		}
		  obj.close();
		}
		catch(Exception e) {System.out.println(e);}
		 Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Success");
		  alert.setHeaderText("Data Updated Successfully!!");
		  alert.setContentText("Done-)");

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
