package yatrasoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;
import java.awt.*;
import javax.swing.*;

import javafx.scene.control.TextInputDialog;
import net.miginfocom.swing.MigLayout;
public class page2 extends JFrame{
	public JFrame frame;
    private String yid;
	private JTextField personf;
    private JTextField textfield;
    private JTextField[] newf;
    private JTextField[] phnf;
    private JTextField[] newAgeorDobf;
    private JCheckBox checkbox;
    private JComboBox<String>[] newcheckf;
    private String name;
    private String phone;
    private int age;
    private int dob;
    private String id;
    private String[] pack;
    private JComboBox<String> Combo;
    private int charge;
    private JTextField agef;
    private JTextField paid;
    private int amtpaid;
    private JTextField phonef;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gender;
    private JComboBox<String>[] genderbox;
    public String names[];
    public int agess[];
    public String phones[];
    public String genders[];
    public String acs[];
    public int charges[];
    public int dobs[];
    
    
   
    private int x;
    
	public page2(String x){
		
		yid=x;
		initilize();	
	}
	public page2(){
		
	}
	
	public void initilize(){
		frame=new JFrame();
		
		frame.setTitle("page2");
		frame.setBounds(400,0,730,740);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new MigLayout("","[]40[]","[]13[]"));
		 
		//Name		
		frame.getContentPane().add(new JLabel("Name"),"gapleft 20,gaptop 20");
		textfield=new JTextField();
		frame.getContentPane().add(textfield,"wrap");
		textfield.setColumns(10); 
		//Name ends
		
		//Age				
		frame.getContentPane().add(new JLabel("Age or DDMMYYYY"),"gapleft 20");		
		agef=new JTextField();		
		frame.getContentPane().add(agef,"wrap");
		agef.setColumns(5);
		//Age ends
			
		//Phone		
		frame.getContentPane().add(new JLabel("Phone"),"gapleft 20");		
		phonef=new JTextField();
		frame.getContentPane().add(phonef,"wrap");
		phonef.setColumns(10);
		//Phone ends
		
		//gender		
		frame.getContentPane().add(new JLabel("Gender"),"gapleft 20");						
		male = new JRadioButton("Male");
		frame.getContentPane().add(male);		
		female = new JRadioButton("Female");
		frame.getContentPane().add(female,"wrap");
		gender=new ButtonGroup();
		gender.add(male);
		gender.add(female);
		//gender ends
		
		//package
		MysqlCon myobj=new MysqlCon();
		
		
		
		frame.add(new JLabel("Package Preference"), "gapleft 20");
		try{
			String tablename="fare";
			
		ResultSet rs=myobj.stmt.executeQuery("select distinct package from "+tablename+" where yid='"+yid+"'"); 
		rs.last();
		int row=rs.getRow();
		rs.beforeFirst();
		int cc=0;
		pack = new String[row];
		while(rs.next())  { 
		
		String yatra_p=rs.getString(1);
		
		pack[cc]=yatra_p;
		cc=cc+1;
		}
	}
		catch(Exception e){ System.out.println(e);
		} 
		myobj.close();
		Combo = new JComboBox<>(pack); 
		frame.add(Combo, "wrap");
		
		//package ends
		
		//paid
		frame.add(new JLabel("Amount Paid (incl all) Rs"), "gapleft 20");		
		paid=new JTextField();
		frame.add(paid,"wrap");
		paid.setColumns(5);
		//paid ends
		
		//+persons				
		frame.getContentPane().add(new JLabel("Family (Max 9)"),"gapleft 20");		
		personf=new JTextField();
		frame.getContentPane().add(personf);
		personf.setColumns(5);
		
		JButton addb=new JButton("ADD");		
		frame.getContentPane().add(addb,"wrap");
	
		handlerclass handler= new handlerclass();
		addb.addActionListener(handler);		
		//+persons ends
		
		//submit
		JButton submit=new JButton("Submit");
		frame.add(submit,"dock south,gapleft 20");
		submitclass submithandle= new submitclass();
		submit.addActionListener(submithandle);
		
		//submit ends
		
		// Then, add the jScrollPane to your frame
		//frame.add(scroll);
		frame.setVisible(true);
		
		   
		
	}
	private class handlerclass implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			x=Integer.parseInt(personf.getText());
			
			newf=new JTextField[x];
			phnf=new JTextField[x];
			newAgeorDobf=new JTextField[x];
			newcheckf=new JComboBox[x];
			genderbox=new JComboBox[x];
			String ans;
			ans=Combo.getItemAt(Combo.getSelectedIndex());
			
			
			frame.add(new JLabel("Name"),"gapleft 20");
			frame.add(new JLabel("Age/DOB"));
			frame.add(new JLabel("Gender"));
			frame.add(new JLabel("Package"));
			frame.add(new JLabel("Phone"),"wrap");
			
			for(int i=0;i<x;i++){
				//name	
				newf[i]=new JTextField();
				frame.add(newf[i],"gapleft 20");
				newf[i].setColumns(8);
				//name ends
				//age
				newAgeorDobf[i]=new JTextField();
				frame.add(newAgeorDobf[i]);
				newAgeorDobf[i].setColumns(4);
				//age ends
				
				//genderbox
				genderbox[i]=new JComboBox<String>();
				genderbox[i].addItem("Male");
				genderbox[i].addItem("Female");
				frame.add(genderbox[i]);				
				//genderbox ends
			
				//checkbox
				
				newcheckf[i]=new JComboBox<String>(pack);
				
				frame.add(newcheckf[i]);
				newcheckf[i].setSelectedIndex(Combo.getSelectedIndex());
				
				
				//checkbox ends
				
				//phone				
				phnf[i]=new JTextField();
	    		frame.add(phnf[i],"wrap");
				phnf[i].setColumns(12);
				//phone ends																
			}
		
			frame.revalidate();
			frame.repaint();
			
			}}
public class submitclass implements ActionListener{
		private int flag=0;
		private String ac;
		public void actionPerformed(ActionEvent event){
			    names=new String[x+1];
			    agess=new int[x+1];
			    phones=new String[x+1];
			    acs=new String[x+1];
			    genders=new String[x+1];
			    charges=new int[x+1];
			    dobs=new int[x+1];
			    
			name=textfield.getText();
			//name ends
			
			//age
			if(!agef.getText().isEmpty() && agef.getText().length()==2){
				
			       age=Integer.parseInt(agef.getText());
			       dob=0;
			       System.out.println("age is of 2");
			}
			else if(!agef.getText().isEmpty() && agef.getText().length()==8){
				   dob=Integer.parseInt(agef.getText());
			       age=getage(agef.getText());
			       System.out.println("age is "+age);
			}
			else flag=1;
		   //age ends
			if(!phonef.getText().isEmpty())
			        phone=phonef.getText();
			else   
				  phone=null;
		    //pack	
			
			ac=Combo.getItemAt(Combo.getSelectedIndex());
		    // ends	
		
			//amt paid
			try{
				amtpaid=Integer.parseInt(paid.getText());
				}catch(NumberFormatException ex){ 
				   amtpaid=0;
				}
			
			//paid ends
			
			//gender
			String sex="";
			if(male.isSelected())
				sex="male";
			else if (female.isSelected())
				sex="female";
			else flag=1;

		    if(age>=60 && sex=="male")
	  		      sex="SCM";    	
	  	          	 
	  	        else if (age>=58 && sex=="female")
	  		      sex="SCF";
	  		  	 
	  	        else if(age>5&&age<11)
	  		      sex="child";
	    	 
	  	        else if(age<=5)
	  		    sex="infant";
	  		 	 
	  	        else 
	  		     sex="A";
		  
		    charge=getfare(yid,sex,ac);
		    if(name.length()>=4)
		        id=yid+name.substring(0,4);
		    else 
		    	id=yid+name;
		    		   		   
			names[0]=name;
			agess[0]=age;
			acs[0]=ac;
			genders[0]=sex;
			charges[0]=charge;
			dobs[0]=dob;
			phones[0]=phone;
			
            if(x>=1&&!personf.getText().isEmpty()) addothernames(id);
			
			if(flag==0){
			  MysqlCon myobj=new MysqlCon();
	             for(int i=0;i<x+1;i++){
				myobj.insert(id,names[i],phones[i],agess[i],acs[i],dobs[i],charges[i],genders[i]);				
	                    }
	            int remaining=createbalancesheet(id,myobj);
	            JOptionPane.showMessageDialog(null, "Success!! Data Added Successfully||Remaining Balance="+remaining);
	        
	            frame.setVisible(false);
	            frame.dispose();
				myobj.close();
			}
			else 
			 {
				   flag=0;
				   JOptionPane.showMessageDialog(null, "Enter all required fields and submit again!!");
			    }
			
			}
			
		
			}
    public void addothernames(String id){
	 int flag=0;
	 String ac;
    	for(int i=0;i<x;i++){
    		if(!newf[i].getText().isEmpty()){
    			
    		
	       name=newf[i].getText();
			
			if(!newAgeorDobf[i].getText().isEmpty() && newAgeorDobf[i].getText().length()==2){
				
			       age=Integer.parseInt(newAgeorDobf[i].getText());
			       dob=0;
			      
			}
			else if(!newAgeorDobf[i].getText().isEmpty() && newAgeorDobf[i].getText().length()==8){
				   dob=Integer.parseInt(newAgeorDobf[i].getText());
			       age=getage(newAgeorDobf[i].getText());
			       
			}
			else flag=1;
			
			if(!phnf[i].getText().isEmpty())
				phone=phnf[i].getText();
		    else   
			    phone=null;
			
			
			ac=newcheckf[i].getItemAt(newcheckf[i].getSelectedIndex());
			
			String sex="";
			if(genderbox[i].getSelectedItem()=="Male")
				sex="male";
			else if (genderbox[i].getSelectedItem()=="Female")
				sex="female";
			else flag=1;

		    if(age>=60 && sex=="male")
  		      sex="SCM";    	
  	          	 
  	        else if (age>=58 && sex=="female")
  		      sex="SCF";
  		  	 
  	        else if(age>5&&age<11)
  		      sex="child";
    	 
  	        else if(age<=5)
  		    sex="infant";
  		 	 
  	        else 
  		     sex="A";
		    
		    charge=getfare(yid,sex,ac);
  		  	   		    		  
			names[i+1]=name;
			agess[i+1]=age;
			acs[i+1]=ac;
			genders[i+1]=sex;
			charges[i+1]=charge;
			dobs[i+1]=dob;
			phones[i+1]=phone;		    		     		
    	}
    		}
    	 
    	
        }
      
     public int getage(String temp){
    	   int day=Integer.parseInt(String.valueOf(temp.charAt(0))+String.valueOf(temp.charAt(1)));
    	   int month=Integer.parseInt(String.valueOf(temp.charAt(2))+String.valueOf(temp.charAt(3)));
    	   int year=Integer.parseInt(String.valueOf(temp.charAt(4))+String.valueOf(temp.charAt(5))+String.valueOf(temp.charAt(6))+String.valueOf(temp.charAt(7)));
    	   System.out.println(day+" "+month+" "+year);
    		LocalDate today = LocalDate.now();
			LocalDate birthday = LocalDate.of(year,month, day);
			 
			Period p = Period.between(birthday, today);
			 
			//Now access the values as below
			System.out.println(p.getDays());
			System.out.println(p.getMonths());
			System.out.println(p.getYears());
			return p.getYears();
      }
     public int getfare(String x,String sex,String pack){
    	 MysqlCon myobj=new MysqlCon();
    	 yid=x;
    	 myobj.results(yid,pack);
    	 System.out.println(yid);
    	 myobj.close();
    	 
    	 if(Objects.equals(sex,"SCM")){
    		      	
    	          return myobj.getscm();
    	 }
    	 else if (Objects.equals(sex,"SCF")){
    		
    		 return myobj.getscf();
    	 }
    	 else if(Objects.equals(sex,"child")||Objects.equals(sex,"Child")){
    	
    		 return myobj.getchild();
    	 }
    	 else if(Objects.equals(sex,"infant")){
    		
    		 return 0;
    	 }
    	 else {
    		
    		 return myobj.getadult();
    	 }
     }
     
    public int createbalancesheet(String id,MysqlCon obj){
    	int adultsac=0;
    	int scmsac=0;
    	int scfsac=0;
    	int childsac=0;
    	int adultsnon=0;
    	int scmsnon=0;
    	int scfsnon=0;
    	int childsnon=0;
    	int sum=0;
    	System.out.println("namesll  "+names.length);
    	for(int i=0;i<names.length;i++){
    		System.out.println(charges[i]+" "+genders[i]+" "+acs[i]+" ");
    		sum=sum+charges[i];
    		String subpack;
    		if(acs[i].length()>=5)
  			  subpack=acs[i].substring(acs[i].length()-5, acs[i].length());
  		    else 
  			  subpack=acs[i].substring(acs[i].length()-2, acs[i].length());
    		System.out.println(subpack);
    		if(Objects.equals(genders[i], "A")){
    		  
    			if(subpack=="AC")
    			      adultsac++;
    			else 
    				  adultsnon++;
    		
    		}
    		else if(Objects.equals(genders[i], "SCM")){
    			if(subpack=="AC")
  			      scmsac++;
  			    else 
  				  scmsnon++;
    		}
    		else if(Objects.equals(genders[i], "SCF")){
    			if(subpack=="AC")
    			      scfsac++;
    			 else 
    				  scfsnon++;
    		}
    		else if(Objects.equals(genders[i], "child")){
    			if(subpack=="AC")
  			      childsac++;
  			    else 
  				  childsnon++;
    		}
    	}
    	
    	int persons=adultsnon+scmsnon+scfsnon+childsnon+adultsac+scmsac+scfsac+childsac;
  
    	//if(obj.idtrue(id)==0)
       	    obj.insertsheet(id,names[0],persons,adultsnon,scmsnon,scfsnon,childsnon,adultsac,scmsac,scfsac,childsac,amtpaid,sum-amtpaid,sum);
    	/*else{
    		
    		obj.updatesheet(id,persons,adultsnon,scmsnon,scfsnon,childsnon,adultsac,scmsac,scfsac,childsac,amtpaid,sum-amtpaid,sum);
    	}*/
    	return sum-amtpaid;
    }
	
    public void setamtpaid(int cash){
    	amtpaid=cash;
    }
  
	
}


