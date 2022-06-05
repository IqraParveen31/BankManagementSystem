/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
//insertion in table
 import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class Combined
  {
       int c1=2004;
    void InsertEmployee()
      {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         Connection con=null; 
         PreparedStatement pmt=null;
          String query=null;

   try
     {
         //jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL
  	 Class.forName("com.mysql.cj.jdbc.Driver");
   	con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/db","root","password");
  	query="insert into customerdb values(?,?,?,?,?)";
    	pmt=con.prepareStatement(query);
        
        int Acc_no=c1++;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter pin:");
         int  en= sc.nextInt();
         
  	//int en=Integer.parseInt(System.console().readLine("PIN No. ="));
        
        System.out.print("CUSTOMER NAME :");
   	String name=sc.nextLine();
        
               // System.console().readLine("CUSTOMER NAME =");
        System.out.print("ACCOUNT BALANCE =");       
	int s=sc.nextInt();
//Integer.parseInt(System.console().readLine("ACCOUNT BALANCE ="));
 System.out.print(" password =");      
  	String c=sc.nextLine();
                //System.console().readLine("PASSWORD =");
        
  	//setting values to placeholders
      
	pmt.setInt(1,en);
      	pmt.setString(2,name);
       	pmt.setInt(3,s);
        pmt.setString(4,c);
      	pmt.setInt(5,c1);
     
   
               //execute query
  
   	int r=pmt.executeUpdate();
 	 if(r>0)
   		System.out.println("RECORD INSERTED SUCCESSFULLY");
  	 else
  		System.out.println("ERROR IN INSERTION!!!");
 	 }
   catch(ClassNotFoundException ce)
 	 {
 		  ce.printStackTrace();
 	 }

  catch(SQLException se)
  	{
   		se.printStackTrace();
	  }
   }


 void Deleteaccount()
{
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          Connection con;
           con = null;
         PreparedStatement pmt=null;
        String query=null;
        Scanner sc =new Scanner(System.in);

try
 {
   Class.forName("com.mysql.cj.jdbc.Driver");
   con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/db","root","password");
 
    query= "delete from customerdb where pin=? and password=?";   
    pmt=con.prepareStatement(query);
 System.out.print("TO DELETE CUSTOMER ACCOUNT, ENTER PIN No. =");
    int en=sc.nextInt();
   
     System.out.println("PASSWORD =");
   // String p=sc.nextLine();
       String p="";
              try {
                  p = br.readLine();
              } catch (IOException ex) {
                  Logger.getLogger(Combined.class.getName()).log(Level.SEVERE, null, ex);
              }
 	//setting values to placeholders
      pmt.setInt(1,en);
      pmt.setString(2,p);
      
             //execute query
  
       int r=pmt.executeUpdate();
      if(r>0)
   	System.out.println("RECORD DELETED SUCCESSFULLY");
      else
  	System.out.println("ERROR IN DELETION!!!");

 
 }
   	catch(ClassNotFoundException ce)
  	{
   		ce.printStackTrace();
  	}

  	catch(SQLException se)
  	{
 		  se.printStackTrace();
 	 }
 }



void UpdateEmployee()
{
    Scanner sc =new Scanner(System.in);
 //  Connection con = null;
   PreparedStatement pmt = null;
  String query = null;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

try
   {

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/db","root","password");
	query = "update customerdb set balance=balance+? where pin= ?";// here ? is to putany value
	pmt=con.prepareStatement(query);
         System.out.print("TO DELETE CUSTOMER ACCOUNT, ENTER PIN No. =");
           int en=sc.nextInt();
         System.out.print("ENTER AMOUNT TO DEPOSIT =");
	int m=sc.nextInt();
        //int en=Integer.parseInt(System.console().readLine("PIN No. ="));
        //Integer.parseInt(System.console().readLine("ENTER AMOUNT TO DEPOSIT ="));

	//setting values to place holders

	pmt.setInt(1,m);
	pmt.setInt(2,en);
     //execute query

	int r=pmt.executeUpdate();
	if(r>0)
	System.out.println("RECORD UPDATED SUCCESSFULLY");
	else
	System.out.println("ERROR IN UPDATION!!!");
       }
	catch(ClassNotFoundException ce)
	{
 		System.out.println("CLASS NOT FOUND!!!");
		ce.printStackTrace();
	}

	catch(SQLException se)
	{
		se.printStackTrace();
	}
    } 


void passchange()
{
   Connection con = null;
   PreparedStatement pmt = null;
  String query = null;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   Scanner sc =new Scanner(System.in);

try
   {
        
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/db","root","password");
	query = "update customerdb set password=? where password= ?";// here ? is to putany value
	pmt=con.prepareStatement(query);

	
	String p=sc.nextLine();
                //System.console().readLine("OLD PASSWORD=");
        String pa=sc.nextLine();//System.console().readLine("NEW PASSWORD=");

	//setting values to place holders

	pmt.setString(2,p);
	pmt.setString(1,pa);
     //execute query

	int r=pmt.executeUpdate();
	if(r>0)
	System.out.println("PASSWORD UPDATED SUCCESSFULLY");
	else
	System.out.println("ERROR IN UPDATION!!!");
       }
	catch(ClassNotFoundException ce)
	{
 		System.out.println("CLASS NOT FOUND!!!");
		ce.printStackTrace();
	}

	catch(SQLException se)
	{
		se.printStackTrace();
	}
    }
   void withdraw()
{
     Scanner sc =new Scanner(System.in);
   Connection con = null;
   PreparedStatement pmt = null;
  String query = null;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

try
   {

	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/db","root","password");
	query = "update customerdb set balance=balance-? where pin= ? and password =?";// here ? is to putany value
	pmt=con.prepareStatement(query);

	/*int en=Integer.parseInt(System.console().readLine("PIN No. ="));
	String p=System.console().readLine("PASSWORD =");
	int m=Integer.parseInt(System.console().readLine("ENTER AMOUNT TO WITHDRAW="));*/
	//setting values to place holders
        System.out.print(" ENTER PIN No. =");
           int en=sc.nextInt();
           System.out.print(" ENTER PASSWORD =");
           String p=sc.nextLine();
         System.out.print("ENTER AMOUNT TO WITHDRAW =");
	int m=sc.nextInt();
 
	pmt.setInt(1,m);
	pmt.setInt(2,en);
  	pmt.setString(3,p);
     //execute query

	int r=pmt.executeUpdate();
	if(r>0)
	System.out.println("AMOUNT WITHDRAWN SUCCESSFULLY");
	else
	System.out.println("ERROR IN WITHDRAW!!!");
       }
	catch(ClassNotFoundException ce)
	{
 		System.out.println("CLASS NOT FOUND!!!");
		ce.printStackTrace();
	}

	catch(SQLException se)
	{
		se.printStackTrace();
	}
    }

    void display()
{

   Connection con=null;
   Statement stmt=null;
   ResultSet rs=null;
   String query=null;

try
 {
   Class.forName("com.mysql.cj.jdbc.Driver");
   con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/db","root","password");
   stmt=con.createStatement();
   query="select * from customerdb";
   rs=stmt.executeQuery(query);
   
   System.out.println("-------------------------------------------CUSTOMER RECORDS------------------------------------------\n\n    PIN                NAME                 BALANCE                  PASSWORD               ACCOUNT NO.\n");
   System.out.println("====================================================================================================="); 
while(rs.next())
        {
   	int pin=rs.getInt(1);
   	String name=rs.getString(2);
        int bal=rs.getInt(3); 
        String pass=rs.getString(4);
        int Acc_no=rs.getInt(5);
                   System.out.printf("%8d   |%18s   |%18d   |%20s  |%17d\n",pin,name,bal,pass,Acc_no);
   System.out.println("------------------------------------------------------------------------------------------------------");
        }
 }
   catch(ClassNotFoundException ce)
  {
   	ce.printStackTrace();
  }

  catch(SQLException se)
  {
   se.printStackTrace();
  }
}



void aboutus()
{
  System.out.println("\t\tWELCOME TO XYZ BANK");
  System.out.println("\t\t has following features :/n DEPOSIT /n WITHDRAW /n UPDATE /INFO ");
 // System.out.println("\n\n\t\tBOARD MEMBERS\n\t\t-------------\n\t\tSHUBHRANSHU DWIVEDI\n\t\tPRATYUSH KAUSHIK\n\t\tPIYUSH MISHRA\n\n");
}




void contact()
{ System.out.println("\t\tCONTACT NO.- 123367890, 9876543210\n\t\t EMAIL ID.- XYZ@gmail.com\n\t\tADDRESS: KANPUR,UP");

}
}




 class BankProject
{  
      public static void main(String args[])throws IOException
        { 
 	int chc=1;
   	Combined c=new Combined();
 	while (chc==1)
	{        System.out.println("\n\t =* = * = * = * = * = * = * =* = * = * = * = * = * = * =* = * = * =* = * =* = * ");
                 System.out.println("\t||                                                                           ||");
                 System.out.println("\t||-------------------------WELCOME TO E-BANK-----------------------||");
                 System.out.println("\t||                                                                           ||");
                 System.out.println("\t =* = * = * = * = * = * = * =* = * = * = * = * = * = * =* = * = * = * = * =* = *\n\n\n\n");



                System.out.println("                        *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
                System.out.println("     \t\t\t*                               *");
                System.out.println("     \t\t\t*              MENU             *");
                System.out.println("     \t\t\t*°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°*");
                System.out.println("     \t\t\t*                               *");
  		System.out.println("     \t\t\t*\t1. NEW ACCOUNT          *\n     \t\t\t*\t2. DELETE ACCOUNT       *\n     \t\t\t*\t3. DEPOSIT AMOUNT       *");
                System.out.println("     \t\t\t*\t4. WITHDRAW             *\n     \t\t\t*\t5. DISPLAY INFO         *\n    \t\t\t*\t6. CHANGE PASSWORD      *\n    \t\t\t*\t7. ABOUT US             *\n    \t\t\t*\t8. CONTACT US           *");
  		System.out.println("     \t\t\t*                               *");
             //   System.out.println("                        *+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n\n");
		/*int ch=Integer.parseInt(System.console().readLine("\t\tENTER YOUR CHOICE: ="));
               // Scanner sc=new Scanner(System.in);
               // int it*/
               Scanner sc= new Scanner(System.in);
                        System.out.print("Enter first number- ");
        
                int ch= sc.nextInt();
  		System.out.println();
		  switch(ch)
		{ 
  			 case 1:  
 			 c.InsertEmployee();
  			 break;
  			 case 2:
  			 c.Deleteaccount();
 	        	 break;		
			
			case 3:
  			c.UpdateEmployee();
 			 break;
			
			case 4:
  			c.withdraw();
 			 break;

			  case 5:
 			  c.display();
  			 break;
                          case 6:
                          c.passchange();
                          break;
                          case 7:
                          c.aboutus();
                          break;
                          case 8:
                          c.contact();
                          break;
  			default:
               			System.out.println("wrong choice!!!!!");
		}
    	System.out.println("\n\nENTER 1 TO REPEAT PROCEDURE ELSE ENTER 0\n\nTHANK YOU! \n");
   
  	//chc=Integer.parseInt(System.console().readLine("choice ="));
         System.out.print("choice =");
         chc=sc.nextInt();
 
	}
       }
}




