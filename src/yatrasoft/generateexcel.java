package yatrasoft;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class generateexcel {
	private String yid;
	public generateexcel(String x){
	yid=x;	
	MysqlCon obj=new MysqlCon();
	generatepilgrimsheet(obj);
	generatebalancesheet(obj);
	generatetrainplan(obj);
	obj.close();

}
 public void generatetrainplan(MysqlCon obj){
		try{
			
			XSSFWorkbook wb=new XSSFWorkbook();
			XSSFSheet spreadsheet=wb.createSheet("trainplan");
			
			XSSFRow row=spreadsheet.createRow(1);

			XSSFCell cell;
			
			//style and font
			XSSFCellStyle hstyle = wb.createCellStyle();
			hstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			hstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			
			XSSFCellStyle bstyle = wb.createCellStyle();
			bstyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			bstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			
			XSSFFont hfont = wb.createFont();
			hfont.setFontHeightInPoints((short) 15);
			hfont.setColor(IndexedColors.RED.getIndex());
			
			XSSFFont bfont = wb.createFont();
			bfont.setFontHeightInPoints((short) 12);
			bfont.setColor(IndexedColors.BLACK.getIndex());
			
			hstyle.setFont(hfont);
			bstyle.setFont(bfont);
			//style and font end
			
			for(int ptr=0;ptr<10;ptr++){
				if(ptr!=2)
				 spreadsheet.setColumnWidth(ptr, 3000);
			}
			spreadsheet.setColumnWidth(2, 5000);
			cell=row.createCell(0);
			cell.setCellValue("SNo.");
			cell.setCellStyle(hstyle);
			cell=row.createCell(1);
			cell.setCellValue("Name");
			cell.setCellStyle(hstyle);
		    cell=row.createCell(2);
		    cell.setCellValue("Gender");
		    cell.setCellStyle(hstyle);
		    cell=row.createCell(3);
		    cell.setCellValue("Phone");
		    cell.setCellStyle(hstyle);
		    cell=row.createCell(4);
		    cell.setCellValue("Math-Tpty");
		    cell.setCellStyle(hstyle);
		    cell=row.createCell(5);
		    cell.setCellValue("Tpty-RMM");
		    cell.setCellStyle(hstyle);
		    cell=row.createCell(6);
		    cell.setCellValue("Mdu-Cape");
		    cell.setCellStyle(hstyle);
		    cell=row.createCell(7);
		    cell.setCellValue("Tvc-Math");
		    cell.setCellStyle(hstyle);
		    cell=row.createCell(8);
		    cell.setCellValue("Tirupati");
		    cell.setCellStyle(hstyle);
		    cell=row.createCell(9);
		    cell.setCellValue("Rameswaram");
		    cell.setCellStyle(hstyle);
		    cell=row.createCell(10);
		    cell.setCellValue("Kanyakumari");
		    cell.setCellStyle(hstyle);
		    
		    
			ResultSet rs=obj.stmt.executeQuery("select id,name,gender,phone,ac from pilgrim where id like '"+yid+"%'");
			
			  MysqlCon myobj=new MysqlCon();
		    int i=2;
		    while(rs.next()){
		    	
		    	row=spreadsheet.createRow(i);
		    	cell=row.createCell(0);
		    	cell.setCellValue(i-1);
		    	
		    	 cell=row.createCell(1);
		         cell.setCellValue(rs.getString(2));
		        cell=row.createCell(2);
		        cell.setCellValue(rs.getString(3));
		        cell.setCellStyle(bstyle);
		        cell=row.createCell(3);
		        cell.setCellValue(rs.getString(4));
		        ResultSet r2=myobj.stmt.executeQuery("select train1,train2,train3,train4,tirupati,rameswaram,kanyakumari from train where id='"+rs.getString(1)+"' and name='"+rs.getString(2)+"'");
		        if(r2.next()){
		        cell=row.createCell(4);
		        cell.setCellValue(r2.getString(1));
		        
		        cell=row.createCell(5);
		        cell.setCellValue(r2.getString(2));
		        
		        cell=row.createCell(6);
		        cell.setCellValue(r2.getString(3));
		        
		        cell=row.createCell(7);
		        cell.setCellValue(r2.getString(4));
		        
		        cell=row.createCell(8);
		        cell.setCellValue(r2.getString(5));
		        
		        cell=row.createCell(9);
		        cell.setCellValue(r2.getString(6));
		        
		        cell=row.createCell(10);
		        cell.setCellValue(r2.getString(7));
		        
		        }
		        i++;
		    }
		    FileOutputStream out=new FileOutputStream(new File("d:/jouney/dpy2017/trainAndAccoPlan.xlsx"));
			wb.write(out);
			out.close();
			wb.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
public void generatebalancesheet(MysqlCon obj){
	int trainsum=0;
	int yatratotal=0;
	try{
	
	XSSFWorkbook wb=new XSSFWorkbook();
	XSSFSheet spreadsheet=wb.createSheet("balancesheet");
	
	XSSFRow row=spreadsheet.createRow(1);

	XSSFCell cell;
	
	//style and font
	XSSFCellStyle hstyle = wb.createCellStyle();
	hstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	hstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	
	XSSFCellStyle bstyle = wb.createCellStyle();
	bstyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	bstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	
	XSSFFont hfont = wb.createFont();
	hfont.setFontHeightInPoints((short) 15);
	hfont.setColor(IndexedColors.RED.getIndex());
	
	XSSFFont bfont = wb.createFont();
	bfont.setFontHeightInPoints((short) 12);
	bfont.setColor(IndexedColors.BLACK.getIndex());
	
	hstyle.setFont(hfont);
	bstyle.setFont(bfont);
	//style and font end
	
	for(int ptr=0;ptr<16;ptr++){
		if(ptr!=2)
		 spreadsheet.setColumnWidth(ptr, 3000);
	}
	spreadsheet.setColumnWidth(2, 5000);
	cell=row.createCell(0);
	cell.setCellValue("SNo.");
	cell.setCellStyle(hstyle);
	cell=row.createCell(1);
	cell.setCellValue("ID");
	cell.setCellStyle(hstyle);
    cell=row.createCell(2);
    cell.setCellValue("NAME");
    cell.setCellStyle(hstyle);
    cell=row.createCell(3);
    cell.setCellValue("Persons");
    cell.setCellStyle(hstyle);
    cell=row.createCell(4);
    cell.setCellValue("AdultNON");
    cell.setCellStyle(hstyle);
    cell=row.createCell(5);
    cell.setCellValue("SCMNON");
    cell.setCellStyle(hstyle);
    cell=row.createCell(6);
    cell.setCellValue("SCFNON");
    cell.setCellStyle(hstyle);
    cell=row.createCell(7);
    cell.setCellValue("ChildNON");
    cell.setCellStyle(hstyle);
    cell=row.createCell(8);
    cell.setCellValue("AdultAC");
    cell.setCellStyle(hstyle);
    cell=row.createCell(9);
    cell.setCellValue("SCMAC");
    cell.setCellStyle(hstyle);
    cell=row.createCell(10);
    cell.setCellValue("SCFAC");
    cell.setCellStyle(hstyle);
    cell=row.createCell(11);
    cell.setCellValue("ChildAC");
    cell.setCellStyle(hstyle);
    
    cell=row.createCell(12);
    cell.setCellValue("Paid");
    cell.setCellStyle(hstyle);
    cell=row.createCell(13);
    cell.setCellValue("Balance");
    cell.setCellStyle(hstyle);
    cell=row.createCell(14);
    cell.setCellValue("Total");
    cell.setCellStyle(hstyle);
    
    cell=row.createCell(15);
    cell.setCellValue("Train Ticket");
    cell.setCellStyle(hstyle);
    
    cell=row.createCell(16);
    cell.setCellValue("YatraFees");
    cell.setCellStyle(hstyle);
    
  
	ResultSet rs=obj.stmt.executeQuery("select * from balancesheet where id like '"+yid+"%' order by balance desc");
	
	  MysqlCon myobj=new MysqlCon();
    int i=2;
    while(rs.next()){
    	
    	row=spreadsheet.createRow(i);
    	cell=row.createCell(0);
    	cell.setCellValue(i-1);   	
    	 cell=row.createCell(1);
         cell.setCellValue(rs.getString(1));
        cell=row.createCell(2);
        cell.setCellValue(rs.getString(2));
        cell.setCellStyle(bstyle);
        cell=row.createCell(3);
        cell.setCellValue(rs.getInt(3));
        cell=row.createCell(4);
        cell.setCellValue(rs.getInt(4));
        
        
        cell=row.createCell(5);      
        cell.setCellValue(rs.getInt(5));
       
        
        
        cell=row.createCell(6);
        cell.setCellValue(rs.getInt(6));
        cell=row.createCell(7);
        cell.setCellValue(rs.getInt(7));
        cell=row.createCell(8);
        cell.setCellValue(rs.getInt(8));
        cell=row.createCell(9);
        cell.setCellValue(rs.getInt(9));
        cell=row.createCell(10);
        cell.setCellValue(rs.getInt(10));
        cell=row.createCell(11);
        cell.setCellValue(rs.getInt(11));
        cell=row.createCell(12);
        cell.setCellValue(rs.getInt(12));
        cell.setCellStyle(bstyle);
        cell=row.createCell(13);
        cell.setCellValue(rs.getInt(13));
        cell.setCellStyle(bstyle);
        cell=row.createCell(14);
        cell.setCellValue(rs.getInt(14));
        cell.setCellStyle(bstyle);
     
      
       /*Train*/
       
        ResultSet trainup=myobj.stmt.executeQuery("select train1+train2+train3+train4 from trainamt where id='"+rs.getString(1)+"'");
     
        while(trainup.next()){
        cell=row.createCell(15);
        trainsum=trainsum+trainup.getInt(1);
        cell.setCellValue(trainup.getInt(1));
        cell.setCellStyle(bstyle);
     
        } trainup.close();
      
        /*YatraF*/
        int tnon=rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7);
        int tac=rs.getInt(8)+rs.getInt(9)+rs.getInt(10)+rs.getInt(11);
       
        int yatrafees=tnon*1100+tac*2000;
        yatratotal=yatratotal+yatrafees;
        cell=row.createCell(16);
        cell.setCellValue(yatrafees);
    
        cell.setCellStyle(bstyle);
       
        i++;	
    	
    }
    rs.close();
    row=spreadsheet.createRow(i);
    row=spreadsheet.createRow(i+1);
    
    
    String sumquery="select id,name,sum(persons), sum(adultnon),sum(scmnon),sum(scfnon),sum(childnon),sum(adultac),sum(scmac),sum(scfac),sum(childac),sum(paid),sum(balance),sum(total) from balancesheet";
    rs=obj.stmt.executeQuery(sumquery);
    while(rs.next()){
    	row=spreadsheet.createRow(i+2);
    cell=row.createCell(3);
    cell.setCellValue(rs.getInt(3));
    cell=row.createCell(4);
    cell.setCellValue(rs.getInt(4));
    
    
    cell=row.createCell(5);      
    cell.setCellValue(rs.getInt(5));
   
    
   
    cell=row.createCell(6);
    cell.setCellValue(rs.getInt(6));
    cell=row.createCell(7);
    cell.setCellValue(rs.getInt(7));
    cell=row.createCell(8);
    cell.setCellValue(rs.getInt(8));
    cell=row.createCell(9);
    cell.setCellValue(rs.getInt(9));
    cell=row.createCell(10);
    cell.setCellValue(rs.getInt(10));
    cell=row.createCell(11);
    cell.setCellValue(rs.getInt(11));
    cell=row.createCell(12);
    cell.setCellValue(rs.getInt(12));
    cell.setCellStyle(bstyle);
    cell=row.createCell(13);
    cell.setCellValue(rs.getInt(13));
    cell.setCellStyle(bstyle);
    cell=row.createCell(14);
    cell.setCellValue(rs.getInt(14));
    cell.setCellStyle(bstyle);
    
    cell=row.createCell(15);
    cell.setCellValue(trainsum);
    cell.setCellStyle(bstyle);
    
    
    cell=row.createCell(16);
    cell.setCellValue(yatratotal);
    cell.setCellStyle(bstyle);
    
    }
    obj.stmt.executeUpdate("update expense set value="+trainsum+" where remark='Train'");
    obj.stmt.executeUpdate("update expense set value="+yatratotal+" where remark='Yatra'");
	
	FileOutputStream out=new FileOutputStream(new File("d:/jouney/dpy2017/balancesheet.xlsx"));
	wb.write(out);
	out.close();
	wb.close();
	
	}
	catch(Exception e){
		System.out.println(e);
	}
}
public void generatepilgrimsheet(MysqlCon obj){
	try{
		
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet spreadsheet=wb.createSheet("pilgrimsheet");
		
		XSSFRow row=spreadsheet.createRow(1);

		XSSFCell cell;
		
		//style and font
		XSSFCellStyle hstyle = wb.createCellStyle();
		hstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		hstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		XSSFCellStyle bstyle = wb.createCellStyle();
		bstyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		bstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		XSSFFont hfont = wb.createFont();
		hfont.setFontHeightInPoints((short) 15);
		hfont.setColor(IndexedColors.RED.getIndex());
		
		XSSFFont bfont = wb.createFont();
		bfont.setFontHeightInPoints((short) 13);
		bfont.setColor(IndexedColors.BLACK.getIndex());
		
		hstyle.setFont(hfont);
		bstyle.setFont(bfont);
		//style and font end
		
		
		 spreadsheet.setColumnWidth(0, 2000);
		 spreadsheet.setColumnWidth(1, 5000);
		 spreadsheet.setColumnWidth(2, 5000);
		 spreadsheet.setColumnWidth(3, 5000);
		 spreadsheet.setColumnWidth(4, 3000);
		 spreadsheet.setColumnWidth(5, 4000);
		 spreadsheet.setColumnWidth(6, 2000);
		 spreadsheet.setColumnWidth(7, 4000);
		 spreadsheet.setColumnWidth(8, 3000);

		cell=row.createCell(0);
		cell.setCellValue("SNo.");
		cell.setCellStyle(hstyle);
		cell=row.createCell(1);
		cell.setCellValue("ID");
		cell.setCellStyle(hstyle);
	    cell=row.createCell(2);
	    cell.setCellValue("NAME");
	    cell.setCellStyle(hstyle);
	    cell=row.createCell(3);
	    cell.setCellValue("Phone");
	    cell.setCellStyle(hstyle);
	    cell=row.createCell(4);
	    cell.setCellValue("Gender");
	    cell.setCellStyle(hstyle);
	    cell=row.createCell(5);
	    cell.setCellValue("AC/NON");
	    cell.setCellStyle(hstyle);
	    cell=row.createCell(6);
	    cell.setCellValue("Age");
	    cell.setCellStyle(hstyle);
	    cell=row.createCell(7);
	    cell.setCellValue("DOB");
	    cell.setCellStyle(hstyle);
	    cell=row.createCell(8);
	    cell.setCellValue("Charge");
	    cell.setCellStyle(hstyle);
	   
	   
	    
		
		ResultSet rs=obj.stmt.executeQuery("Select id, name, phone, gender,ac, age, dob, charge from pilgrim where id like '"+yid+"%' order by id");
		
	    int i=2;
	    while(rs.next()){
	    	
	    	row=spreadsheet.createRow(i);
	    	cell=row.createCell(0);
	    	cell.setCellValue(i-1);
	    	cell.setCellStyle(bstyle);   	
	    	 cell=row.createCell(1);
	         cell.setCellValue(rs.getString(1));
	        cell=row.createCell(2);
	        cell.setCellValue(rs.getString(2));
	        cell.setCellStyle(bstyle);
	        cell=row.createCell(3);
	        cell.setCellValue(rs.getString(3));
	        cell=row.createCell(4);
	        cell.setCellValue(rs.getString(4));
	        
	        
	        cell=row.createCell(5);
	        if(rs.getString(5)=="0")
	            cell.setCellValue("NON");
	        else if(rs.getString(5)=="1")
	        	cell.setCellValue("AC");
	        else 
	        	cell.setCellValue(rs.getString(5));
	        
	        cell=row.createCell(6);
	        cell.setCellValue(rs.getString(6));
	        cell=row.createCell(7);
	        cell.setCellValue(rs.getString(7));
	        cell=row.createCell(8);
	        cell.setCellValue(rs.getString(8));
	        cell.setCellStyle(bstyle);
	       
	       
	        i++;
	    	
	    	
	    }
	 
		
		FileOutputStream out=new FileOutputStream(new File("d:/jouney/dpy2017/pilgrimdetail.xlsx"));
		wb.write(out);
		out.close();
		wb.close();
		
		}
		catch(Exception e){
			System.out.println(e);
		}
}



}


