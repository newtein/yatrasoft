package yatrasoft;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList; 

public class MysqlCon {
 public Statement stmt=null;
 public Statement stmt2=null;
 private Connection con=null;
 private int adult;
 private int scm;
 private int scf;
 private int child;
 private String yatra_p;
 private String name;
 private int persons;
 public String id[];
 public String names[];
	public MysqlCon()
	{   
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newsoft","root","");   
		stmt=con.createStatement();  
		
			  
			}catch(Exception e){ System.out.println(e);} 
	}
	
	public void results(String yid,String pack){
		try{
			String tablename="fare";
			
		ResultSet rs=stmt.executeQuery("select * from "+tablename+" where yid='"+yid+"' and package='"+pack+"'");  
		while(rs.next())  { 
		adult=rs.getInt(1);
		scm=rs.getInt(4);
		scf=rs.getInt(5);
		child=rs.getInt(6);
		}
	}
		catch(Exception e){ System.out.println(e);} 
	}
	public void idshowname(String yid){
		
		int row=0,ptr=0;
		try{
			ResultSet rs=stmt.executeQuery("select distinct name, id from pilgrim where id like '"+yid+"%' group by id order by name");
			rs.last();
			row = rs.getRow();
			rs.beforeFirst();
			id=new String[row];
			names=new String[row];
			while(rs.next()){
			id[ptr]=rs.getString(2);
			names[ptr]=rs.getString(1);
			ptr++;
			}
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public int idtrue(String uid){
		int row;
		try{
		  ResultSet rs=stmt.executeQuery("select * from balancesheet where id="+"'"+uid+"'");
		  rs.last();
		  row = rs.getRow();
		  if(row>0) return 1;
		  else return 0;
		}
		catch(Exception e){ 
			System.out.println(e);
			return 0;
			} 
		
	}
	public void iddetail(String uid){
		try{
			ResultSet rs=stmt.executeQuery("select name,persons from balancesheet where id="+"'"+uid+"'");
			
			while(rs.next()){
			name=rs.getString(1);
			persons=rs.getInt(2);
			System.out.println(name);
		      
			}
		}
		catch(Exception e){ System.out.println(e);} 
		
	}
	
	
	public void insertsheet(String id, String name, int person, int adultnon, int scmnon,int scfnon,int childnon, int adultac, int scmac,int scfac,int childac,int paid,int balance,int total){
		try{
	    String query="insert into balancesheet (id,name, persons,adultac, scmac, scfac,childac,adultnon, scmnon, scfnon,childnon,paid,balance,total)"+" values('"+id+"', '"+name+"','"+person+"','"+adultac+"','"+scmac+"','"+scfac+"','"+childac+"','"+adultnon+"','"+scmnon+"','"+scfnon+"','"+childnon+"','"+paid+"','"+balance+"','"+total+"')" ;	
		stmt.executeUpdate(query);
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void updatesheet(String id, int person, int adultnon, int scmnon,int scfnon,int childnon, int adultac, int scmac,int scfac,int childac,int paid,int balance,int total){
		try{
	    String query="update balancesheet set persons="+person+", adultac="+adultac+", scmac="+scmac+", scfac="+scfac+", childac="+childac+", adultnon="+adultnon+", scmnon="+scmnon+", scfnon="+scfnon+", childnon="+childnon+", paid="+paid+", balance="+balance+", total="+total+" where id='"+id+"'";
	    stmt.executeUpdate(query);
		}
		catch(Exception e){ System.out.println(e);} 
	}
	
	public void updatesheetshort(String id,String newname, int person, int adultnon, int scmnon,int scfnon,int childnon, int adultac, int scmac,int scfac,int childac,int paid,int balance,int total){
		
		/*try{
		    String query="update balancesheet set  paid="+paid+",name='"+newname+"', balance="+balance+", total="+total+" where id='"+uid+"'";
		    stmt.executeUpdate(query);
			}
			catch(Exception e){ System.out.println(e);}
			*/
		try{
		    String query="update balancesheet set name='"+newname+"',persons="+person+", adultac="+adultac+", scmac="+scmac+", scfac="+scfac+", childac="+childac+", adultnon="+adultnon+", scmnon="+scmnon+", scfnon="+scfnon+", childnon="+childnon+", paid="+paid+", balance="+balance+", total="+total+" where id='"+id+"'";
		    stmt.executeUpdate(query);
			}
			catch(Exception e){ System.out.println(e);} 
		
	}
	
	public ObservableList<String> getpackage(String yid){
		ObservableList<String> options= FXCollections.observableArrayList();
	  	try{
			String tablename="fare";
			
		ResultSet rs=stmt.executeQuery("select distinct package from "+tablename+" where yid='"+yid.substring(0,7)+"'");  
		while(rs.next())  { 
		
		String yatra_p=rs.getString(1);
		
	     options.add(yatra_p);
		
		}
	}
		catch(Exception e){ System.out.println(e);
		} 
		return options;
	}
	
	public void insert(String id, String name, String phone, int age, String ac,int dob,int charge,String gender){
		try{
	    String query="insert into pilgrim (id,name, phone,age, ac, dob,charge,gender)"+" values('"+id+"', '"+name+"','"+phone+"','"+age+"','"+ac+"','"+dob+"','"+charge+"','"+gender+"')" ;	
		stmt.executeUpdate(query);
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public int getadult(){
		return adult;
	}
	
	public int getscm(){
		return scm;
	}
	public int getscf(){
		return scf;
	}
	public int getchild(){
		return child;
	}
	public String getbalcname(){
		return name;
	}public int getbalcpersons(){
		return persons;
	}
	public void close(){
		try{
		con.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}
	
}

