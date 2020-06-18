

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;
//import com.itextpdf.text.Image

public class pdf {
    private static String FILE = "E:/biodata.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 15,
            Font.BOLD);

	
	public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date)
	{
	if(date!=null)
	{
	java.sql.Date sqld=new java.sql.Date(date.getTime());
	return sqld;
	}
	return null;
	}

    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addfamilycontent(document);
            addContent(document);
            addContent1(document);
            JOptionPane.showMessageDialog(null, "PDF saved in your E Drive as biodata.pdf");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("My Biodata");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Divyesh");
        document.addCreator("Divyesh");
    }

    private static void addTitlePage(Document document)
            throws DocumentException, MalformedURLException, IOException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
       
               preface.add(new Paragraph("BIODATA", catFont));
               preface.add(new Paragraph("____________________________________________________",smallBold));
        addEmptyLine(preface, 3);
        
      

        
        
        
    
        
        
        // Will create: Report generated by: _name, _date
       // preface.add(new Paragraph(
         //       "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
           //     smallBold));
        preface.add(new Paragraph("Personal Details: ",subFont));
        preface.add(new Paragraph("_____________________",redFont));
        
        addEmptyLine(preface, 2);
        
        preface.add(new Paragraph("Name:"+" "+" "+" "+" " +biodata.name.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Age:"+" "+" "+" "+" "  +biodata.age.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Gender:"+" "+" "+" "+" "+biodata.name.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Year of graduation: "+" "+biodata.year.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Address:"+" "+" "+" "+" "+biodata.add.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Pin Code:"+" "+" "+" "+" "+biodata.pin.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Mobile No:"+" "+" "+" "+" "+biodata.mob.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Email Id:"+" "+" "+" "+" "+biodata.email.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("City:"+" "+" "+" "+" "+biodata.city.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("State:"+" "+" "+" "+" "+biodata.state.getText(),smallBold));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Native Language:"+" "+" "+" "+" "+biodata.native1.getText(),smallBold));
        addEmptyLine(preface, 2);
        
      //  preface.add(new Paragraph("DOB:"+" "+" "+" "+" "+biodata.date.getDateFormatString(),smallBold));
        
        
        //preface.add(new Paragraph(
        //        "This document describes something which is very important ",
        //        smallBold));
       

        document.add(preface);
        // Start a new page
        document.newPage();
    }
    
    
    private static void addfamilycontent(Document document) throws DocumentException {
    	
    	Paragraph p=new Paragraph();
    	  p.add(new Paragraph("Family Details: ",subFont));
          p.add(new Paragraph("_____________________",redFont));
          
          addEmptyLine(p, 3);
          
          p.add(new Paragraph("Father's Name:"     +biodata.father.getText(),smallBold));
          addEmptyLine(p, 3);
          p.add(new Paragraph("Occupation:"        +biodata.fathero.getText(),smallBold));
          addEmptyLine(p, 3);
          p.add(new Paragraph("Mobile No:"         +biodata.c1.getText(),smallBold));
          addEmptyLine(p, 3);
          p.add(new Paragraph("Mother's Name:"     +biodata.mother.getText(),smallBold));
          addEmptyLine(p, 3);
          p.add(new Paragraph("Occuaption:"        +biodata.mothero.getText(),smallBold));
          addEmptyLine(p, 3);
          p.add(new Paragraph("Mobile No:"         +biodata.c2.getText(),smallBold));
          addEmptyLine(p, 3);
          
          
          document.add(p);
          // Start a new page
          document.newPage();
    	
    }
    
    private static void addContent(Document document) throws DocumentException {
        
    	Paragraph p1=new Paragraph();
  	  p1.add(new Paragraph("Education Details: ",subFont));
        p1.add(new Paragraph("_____________________",redFont));
        
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Class 10 : ",smallBold));
        p1.add(new Paragraph("_____________________",smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Institute:"       +biodata.degreei.getText(),smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("University:"      +biodata.univ.getText(),smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Year:"            +biodata.yr.getText(),smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Grade:"           +biodata.grade.getText(),smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Percentage:"      +biodata.perc.getText(),smallBold));
        addEmptyLine(p1, 2);
        addEmptyLine(p1, 3);
        p1.add(new Paragraph("High School: ",smallBold));
        p1.add(new Paragraph("_____________________",smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Institute:"       +biodata.inst.getText(),smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("University:"      +biodata.univ1.getText(),smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Year:"            +biodata.yr1.getText(),smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Grade:"           +biodata.grade1.getText(),smallBold));
        addEmptyLine(p1, 2);
        p1.add(new Paragraph("Percentage:"      +biodata.perc1.getText(),smallBold));
        addEmptyLine(p1, 2);
        
        
        document.add(p1);
        // Start a new page
        document.newPage();

      
    }
    
    private static void addContent1(Document document) throws DocumentException {
    	
    	Paragraph p1=new Paragraph();
    	  p1.add(new Paragraph("Engineering Details: ",subFont));
          p1.add(new Paragraph("_____________________",redFont));
          addEmptyLine(p1, 2);
          p1.add(new Paragraph("Sem Wise results: ",smallBold));
          addEmptyLine(p1, 2);
    	PdfPTable t=new PdfPTable(9);
    	
    	PdfPCell c1=new PdfPCell(new Paragraph("Sem"));
    	PdfPCell c2=new PdfPCell(new Paragraph("I"));
    	PdfPCell c3=new PdfPCell(new Paragraph("II"));
    	PdfPCell c4=new PdfPCell(new Paragraph("III"));
    	PdfPCell c5=new PdfPCell(new Paragraph("IV"));
    	PdfPCell c6=new PdfPCell(new Paragraph("V"));
    	PdfPCell c7=new PdfPCell(new Paragraph("VI"));
    	PdfPCell c8=new PdfPCell(new Paragraph("VII"));
    	PdfPCell c9=new PdfPCell(new Paragraph("VIII"));
    	
    	t.addCell(c1);
    	t.addCell(c2);
    	t.addCell(c3);
    	t.addCell(c4);
    	t.addCell(c5);
    	t.addCell(c6);
    	t.addCell(c7);
    	t.addCell(c8);
    	t.addCell(c9);
    	
    	c1=new PdfPCell(new Paragraph("SGPA"));
    	c2=new PdfPCell(new Paragraph(biodata1.sem1.getText()));
    	c3=new PdfPCell(new Paragraph(biodata1.sem2.getText()));
    	c4=new PdfPCell(new Paragraph(biodata1.sem3.getText()));
    	c5=new PdfPCell(new Paragraph(biodata1.sem4.getText()));
    	c6=new PdfPCell(new Paragraph(biodata1.sem5.getText()));
    	c7=new PdfPCell(new Paragraph(biodata1.sem6.getText()));
    	c8=new PdfPCell(new Paragraph(biodata1.sem7.getText()));
    	c9=new PdfPCell(new Paragraph(biodata1.sem8.getText()));
    	
    	t.addCell(c1);
    	t.addCell(c2);
    	t.addCell(c3);
    	t.addCell(c4);
    	t.addCell(c5);
    	t.addCell(c6);
    	t.addCell(c7);
    	t.addCell(c8);
    	t.addCell(c9);
    	Paragraph p2=new Paragraph();
    	 addEmptyLine(p2, 2);
    	 p2.add(new Paragraph("Projects: ",subFont));
         p2.add(new Paragraph("__________",redFont));
         addEmptyLine(p2, 2);
         p2.add(new Paragraph("Project Name:"+" "+" "+biodata1.p1.getText(),smallBold));
         addEmptyLine(p2, 2);
        p2.add(new Paragraph("Brief:"+" "+biodata1.pb1.getText(),smallBold));
         addEmptyLine(p2, 2);
         p2.add(new Paragraph("Project Name:"+" "+" "+biodata1.p2.getText(),smallBold));
         addEmptyLine(p2, 2);
         p2.add(new Paragraph("Brief:"+" "+biodata1.pb2.getText(),smallBold));
         addEmptyLine(p2, 3);
         p2.add(new Paragraph("Awards: ",subFont));
         p2.add(new Paragraph("__________",redFont));
         addEmptyLine(p2, 2);
         p2.add(new Paragraph("1)"+" "+biodata1.award.getText(),smallBold));
         addEmptyLine(p2, 2);
         p2.add(new Paragraph("2):"+" "+biodata1.award2.getText(),smallBold));
         addEmptyLine(p2, 5);
         PreparedStatement ps;
 	    String query = "select * from register where name='"+studentdashboard1.textField.getText()+"'";
 	     
 	     try {
 	     	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
 	         ps = conn.prepareStatement(query);
 	     
 	        ResultSet rs=ps.executeQuery();
 	        if(rs.next())
 	         {
 	     	  
 	     		byte[]imagedata=rs.getBytes("picture");
 	     		Image image=Image.getInstance(imagedata);
 	     		p2.add(image);
 	        	//format=new ImageIcon(new ImageIcon(imagedata).getImage().getScaledInstance(lk.getWidth(), lk.getHeight(), Image.SCALE_SMOOTH));
 	        	//ImageIcon img=new ImageIcon(new ImageIcon("D:/choose.jpg").getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH));
 	    	//	l1.setIcon(img);
 	       //lk.setIcon(format);
 	     	  
 	         }
 	       
 	     	
 		}catch(Exception e1)
 	     {
 				e1.printStackTrace();
 	     }
 	    addEmptyLine(p2, 1);
         p2.add(new Paragraph("--------------PDF created on: "+new Date()+"---------------------"));
         document.add(p1);
         document.add(t);
         document.add(p2);
    	
    	
    	
    	
    }
    


    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}