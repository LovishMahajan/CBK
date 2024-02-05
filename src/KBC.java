
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class KBC implements Runnable, MouseListener 
{
 String  pass = "root", user = "root", path = "jdbc:mysql://localhost:3306/java",date,name;
 String  real_answer,user_answer,answer_status;
 int     lifeline1=0,lifeline2=0, lifeline3=0,lifeline4=0,lifeline5=0,q=1, p=0 ,qn=0;
 String  status5050="false",select, n;
 Color   orange =new Color(255,128,0);Color white =new Color(255,255,255);Color green =new Color(0,255,0);
 int     question_counter=0;
 int     TimePointPass=0,Break = 1, first = 0;;
 JFrame  KBCFRAME;
 JLabel  logo2,am,JL,PP, Option5050,FlipOption,AudienceOption,QuitOption,StopTimeOption,c5,LevelLabel ,c8,CloseLable,checkamount,print,amount, AudienceButton,QuitButton,Button5050, StopTimeButton, FlipButton,LOCK,LOCK2,rupee;
 JLabel  ShowTopAmount, ShowTopAmount1, ShowTopAmount2, ShowTopAmount3, ShowTopAmount4, ShowTopAmount5, ShowTopAmount6, ShowTopAmount7, ShowTopAmount8, ShowTopAmount9, ShowTopAmount10, ShowTopAmount11, ShowTopAmount12,ShowTopAmount13,ShowTopAmount14,ShowTopAmount15;
 JLabel  AmitabPic1, AmitabPic12;
 JLabel  XButton,XAdienceButton,Name,Date;
 JLabel  Level1Button, Level2Button, Level3Button, Level4Button, Level5Button, Level6Button, Level7Button, Level8Button, Level9Button, Level10Button, Level11Button, Level12Button,Level13Button,Level14Button,Level15Button;
 JLabel  qb,aopt,bopt,copt,dopt;
 String  answer,Amount,Rupee;
 JLabel  a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;
 String  amt[] ={"0/-","5,000/-","10,000/-","20,000/-","40,000/-","80,000/-","1,60,000/-","3,20,000/-","6,40,000/-","12,50,000/-","25,00,000/-","50,00,000/-","1,00,00,000/-","3,00,00,000/-","5,00,00,000/-","7,00,00,000/-"};
 String  ramt[]={"0","5,000/-","10,000/-","20,000/-","40,000/-","80,000/-","1,60,000/-","3,20,000/-","6,40,000/-","12,50,000/-","25,00,000/-","50,00,000/-","1,00,00,000/-","3,00,00,000/-","5,00,00,000/-","7,00,00,000/-"};
String rup[]={"Zero","Five Thousand Only","Ten Thousand Only","Twenty Thousand Only","Fourty Thousand Only","Eighty Thousand Only","One Lakh Sixty Thousand Only","Three Lakh Twenty Thousand Only","Six Lakh Fourty Thousand Only","Tweleve Lakh Fifty Thousand Only","Twenty Five Lakh Only","Fifty Lakh Only","One Crore Only","Three Crore Only","Five Crore Only","Seven Crore Only"};
 int     amt_value=0,amt_value2=0;
 int     rup_value=0,rup_value2=0;
 Random  r = new Random();
 Color   O = new Color(255,128,0); 
 Color   c = new Color(254,239,87);
 int     random_que[]= new int [15];
 int     a[]={0,1,2,3,4};
 Font    fontstyle = new Font("Times New Roman",2,25);
 Font    fontstyle2 = new Font("Times New Roman",2,30);
 Font    fontstyle3 = new Font("Times New Roman",0,72);
 int     TimeStatus=0,Time60=0,FullyTimeStop=0,Sure=0,DoubAns=0,DoubAns2;
 Font    fontBold = new Font("Times New Roman",3,25);
 Font    fontBold2 = new Font("Times New Roman",3,25);
 JLabel DoubleAns,DoubleAnsOption;
 JLabel  TimeLabel;
 Thread  T,T2,T3;
 int ax=0,bx=0,cx=0,dx=0;
 public KBC( String name)
	{  this.name=name;
	
	        KBCFRAME = new JFrame("StartPage");                KBCFRAME.setSize(1366,768);              KBCFRAME.setLayout(null);
                  JL = new JLabel(new ImageIcon("pic/newkbc.jpg"));   JL.setBounds(0,0,1366,768);
 	         
	  
JLabel JL3 = new JLabel(new ImageIcon("pic/aopt.gif")); JL3.setBounds(153,577,200,50);KBCFRAME.add(JL3);  
JLabel JL4 = new JLabel(new ImageIcon("pic/aopt.gif")); JL4.setBounds(153,650,200,50);KBCFRAME.add(JL4);  
JLabel JL5 = new JLabel(new ImageIcon("pic/aopt.gif")); JL5.setBounds(640,577,200,50);KBCFRAME.add(JL5);  
JLabel JL6 = new JLabel(new ImageIcon("pic/aopt.gif")); JL6.setBounds(640,650,200,50);KBCFRAME.add(JL6); 
JLabel logo2 = new JLabel(new ImageIcon("pic/rotatelogo2.gif")); logo2.setBounds(-35,-40,400,500);KBCFRAME.add(logo2);

print=new JLabel(new ImageIcon("pic/PRINT.png"));          print.setBounds(400,500,200,50);    print.setVisible(false);   KBCFRAME.add(print);	print.addMouseListener(this);
      Option5050     = new JLabel("50 50 option");             Option5050.setBounds(360,2,100,10);      Option5050.setForeground(Color.WHITE);     KBCFRAME.add(Option5050);      Option5050.setVisible(false);			
      FlipOption     = new JLabel("Flip Option");              FlipOption.setBounds(950,2,100,10);     FlipOption.setForeground(Color.WHITE);     KBCFRAME.add(FlipOption);      FlipOption.setVisible(false);	
      AudienceOption = new JLabel("Audience option");          AudienceOption.setBounds(1070,2,100,10); AudienceOption.setForeground(Color.WHITE); KBCFRAME.add(AudienceOption);  AudienceOption.setVisible(false);
	  QuitOption     = new JLabel("Quit Option");              QuitOption.setBounds(100,2,100,10);      QuitOption.setForeground(Color.WHITE);     KBCFRAME.add(QuitOption);      QuitOption.setVisible(false);
	  StopTimeOption = new JLabel("Stop Time Option");         StopTimeOption.setBounds(1190,2,100,10); StopTimeOption.setForeground(Color.WHITE); KBCFRAME.add(StopTimeOption);StopTimeOption.setVisible(false);
	  DoubleAnsOption= new JLabel("Double Tip Option");           DoubleAnsOption.setBounds(240,2,100,10); DoubleAnsOption.setForeground(Color.WHITE);         KBCFRAME.add( DoubleAnsOption);  DoubleAnsOption.setVisible(false);
     
	   print=new JLabel(new ImageIcon("pic/PRINT.png"));           print.setBounds(585,500,210,60);KBCFRAME.add(print);   print.addMouseListener(this);
	  checkamount    = new JLabel(new ImageIcon("pic/check.png")); checkamount.setBounds(300,150,755,399);  checkamount.addMouseListener(this);        KBCFRAME.add(checkamount);
	  XButton        = new JLabel("X");                        XButton.setBounds(700,55,70,40);         XButton.setFont(fontBold);                 XButton.addMouseListener(this);
    
	  CloseLable     = new JLabel("CLOSE");	                   CloseLable.setBounds(940,100,100,120);   CloseLable.setForeground(Color.WHITE);     CloseLable.setFont(fontBold); KBCFRAME.add(CloseLable); CloseLable.setVisible(false); checkamount.add(XButton); checkamount.setVisible(false);print.setVisible(false);
      
	  ShowTopAmount  = new JLabel(new ImageIcon("pic/Welcom.png"));      ShowTopAmount.setBounds(468,17,420,90);        KBCFRAME.add(ShowTopAmount);   ShowTopAmount.setVisible(true);
	  ShowTopAmount1 = new JLabel("Total Amount  "+amt[1]);   ShowTopAmount1.setBounds(550,15,350,90);  ShowTopAmount1.setFont(fontstyle);  ShowTopAmount1.setForeground(O);  KBCFRAME.add(ShowTopAmount1);  ShowTopAmount1.setVisible(false);
	  ShowTopAmount2 = new JLabel("Total Amount  "+amt[2]);   ShowTopAmount2.setBounds(550,15,350,90);  ShowTopAmount2.setFont(fontstyle);  ShowTopAmount2.setForeground(O);  KBCFRAME.add(ShowTopAmount2);  ShowTopAmount2.setVisible(false);
	  ShowTopAmount3 = new JLabel("Total Amount  "+amt[3]);   ShowTopAmount3.setBounds(550,15,350,90);  ShowTopAmount3.setFont(fontstyle);  ShowTopAmount3.setForeground(O);  KBCFRAME.add(ShowTopAmount3);  ShowTopAmount3.setVisible(false);
	  ShowTopAmount4 = new JLabel("Total Amount  "+amt[4]);   ShowTopAmount4.setBounds(550,15,350,90);  ShowTopAmount4.setFont(fontstyle);  ShowTopAmount4.setForeground(O);  KBCFRAME.add(ShowTopAmount4);  ShowTopAmount4.setVisible(false);
	  ShowTopAmount5 = new JLabel("Total Amount  "+amt[5]);   ShowTopAmount5.setBounds(550,15,350,90);  ShowTopAmount5.setFont(fontstyle);  ShowTopAmount5.setForeground(O);  KBCFRAME.add(ShowTopAmount5);  ShowTopAmount5.setVisible(false);
	  ShowTopAmount6 = new JLabel("Total Amount  "+amt[6]);   ShowTopAmount6.setBounds(550,15,350,90);  ShowTopAmount6.setFont(fontstyle);  ShowTopAmount6.setForeground(O);  KBCFRAME.add(ShowTopAmount6);  ShowTopAmount6.setVisible(false);
	  ShowTopAmount7 = new JLabel("Total Amount  "+amt[7]);   ShowTopAmount7.setBounds(550,15,350,90);  ShowTopAmount7.setFont(fontstyle);  ShowTopAmount7.setForeground(O);  KBCFRAME.add(ShowTopAmount7);  ShowTopAmount7.setVisible(false);
	  ShowTopAmount8 = new JLabel("Total Amount  "+amt[8]);   ShowTopAmount8.setBounds(550,15,350,90);  ShowTopAmount8.setFont(fontstyle);  ShowTopAmount8.setForeground(O);  KBCFRAME.add(ShowTopAmount8);  ShowTopAmount8.setVisible(false);
	  ShowTopAmount9 = new JLabel("Total Amount  "+amt[9]);   ShowTopAmount9.setBounds(550,15,350,90);  ShowTopAmount9.setFont(fontstyle);  ShowTopAmount9.setForeground(O);  KBCFRAME.add(ShowTopAmount9);  ShowTopAmount9.setVisible(false);
	  ShowTopAmount10= new JLabel("Total Amount  "+amt[10]);  ShowTopAmount10.setBounds(550,15,350,90); ShowTopAmount10.setFont(fontstyle); ShowTopAmount10.setForeground(O); KBCFRAME.add(ShowTopAmount10); ShowTopAmount10.setVisible(false);
	  ShowTopAmount11= new JLabel("Total Amount  "+amt[11]);  ShowTopAmount11.setBounds(550,15,350,90); ShowTopAmount11.setFont(fontstyle); ShowTopAmount11.setForeground(O); KBCFRAME.add(ShowTopAmount11); ShowTopAmount11.setVisible(false);
	  ShowTopAmount12= new JLabel("Total Amount  "+amt[12]);  ShowTopAmount12.setBounds(550,15,350,90); ShowTopAmount12.setFont(fontstyle); ShowTopAmount12.setForeground(O); KBCFRAME.add(ShowTopAmount12); ShowTopAmount12.setVisible(false);
	  ShowTopAmount13= new JLabel("Total Amount  "+amt[13]);  ShowTopAmount13.setBounds(550,15,350,90); ShowTopAmount13.setFont(fontstyle); ShowTopAmount13.setForeground(O); KBCFRAME.add(ShowTopAmount13); ShowTopAmount13.setVisible(false);
	  ShowTopAmount14= new JLabel("Total Amount  "+amt[14]);  ShowTopAmount14.setBounds(550,15,350,90); ShowTopAmount14.setFont(fontstyle); ShowTopAmount14.setForeground(O); KBCFRAME.add(ShowTopAmount14); ShowTopAmount14.setVisible(false);
	  ShowTopAmount15= new JLabel("Total Amount  "+amt[15]);  ShowTopAmount15.setBounds(550,15,350,90); ShowTopAmount15.setFont(fontstyle); ShowTopAmount15.setForeground(O); KBCFRAME.add(ShowTopAmount15); ShowTopAmount15.setVisible(false);
	 
	  Level1Button   = new JLabel(new ImageIcon("pic/1Level.jpg")); Level1Button.setBounds(1031,432,253,33); KBCFRAME.add(Level1Button); Level1Button.setVisible(true);
      Level2Button   = new JLabel(new ImageIcon("pic/2Level.jpg")); Level2Button.setBounds(1031,409,253,33); KBCFRAME.add(Level2Button); Level2Button.setVisible(false);
      Level3Button   = new JLabel(new ImageIcon("pic/3Level.jpg")); Level3Button.setBounds(1031,384,253,33); KBCFRAME.add(Level3Button); Level3Button.setVisible(false);
      Level4Button   = new JLabel(new ImageIcon("pic/4Level.jpg")); Level4Button.setBounds(1031,361,253,33); KBCFRAME.add(Level4Button); Level4Button.setVisible(false);
      Level5Button   = new JLabel(new ImageIcon("pic/5Level.jpg")); Level5Button.setBounds(1031,339,253,33); KBCFRAME.add(Level5Button); Level5Button.setVisible(false);
      Level6Button   = new JLabel(new ImageIcon("pic/6Level.jpg")); Level6Button.setBounds(1031,316,253,33); KBCFRAME.add(Level6Button); Level6Button.setVisible(false);
      Level7Button   = new JLabel(new ImageIcon("pic/7Level.jpg")); Level7Button.setBounds(1031,293,253,33); KBCFRAME.add(Level7Button); Level7Button.setVisible(false);
      Level8Button   = new JLabel(new ImageIcon("pic/8Level.jpg")); Level8Button.setBounds(1031,273,253,33); KBCFRAME.add(Level8Button); Level8Button.setVisible(false);
      Level9Button   = new JLabel(new ImageIcon("pic/9Level.jpg")); Level9Button.setBounds(1031,250,253,33); KBCFRAME.add(Level9Button); Level9Button.setVisible(false);
      Level10Button  = new JLabel(new ImageIcon("pic/10Level.jpg"));Level10Button.setBounds(1031,229,253,33);KBCFRAME.add(Level10Button);Level10Button.setVisible(false);
      Level11Button  = new JLabel(new ImageIcon("pic/11Level.jpg"));Level11Button.setBounds(1031,205,253,33);KBCFRAME.add(Level11Button);Level11Button.setVisible(false);
      Level12Button  = new JLabel(new ImageIcon("pic/12Level.jpg"));Level12Button.setBounds(1031,182,253,33);KBCFRAME.add(Level12Button);Level12Button.setVisible(false);
      Level13Button  = new JLabel(new ImageIcon("pic/13Level.jpg"));Level13Button.setBounds(1031,158,253,33);KBCFRAME.add(Level13Button);Level13Button.setVisible(false);
      Level14Button  = new JLabel(new ImageIcon("pic/14Level.jpg"));Level14Button.setBounds(1031,135,253,33);KBCFRAME.add(Level14Button);Level14Button.setVisible(false);
      Level15Button  = new JLabel(new ImageIcon("pic/15Level.jpg"));Level15Button.setBounds(1031,111,253,33);KBCFRAME.add(Level15Button);Level15Button.setVisible(false);
      	  
      LevelLabel     = new JLabel(new ImageIcon("pic/level2.png"));  LevelLabel.setBounds(920,85,480,450);  KBCFRAME.add(LevelLabel);
    		 
	  AmitabPic1     = new JLabel(new ImageIcon("pic/medium.jpg")); AmitabPic1.setBounds(308,100,670,360);   AmitabPic1.addMouseListener(this); KBCFRAME.add(AmitabPic1); AmitabPic1.setVisible(true);
      AmitabPic12    = new JLabel(new ImageIcon("pic/medium2.jpg"));AmitabPic12.setBounds(291,85,700,400);   AmitabPic12.addMouseListener(this);KBCFRAME.add(AmitabPic12);AmitabPic12.setVisible(false);
    
	          
	            qb   = new JLabel("");             qb.setBounds(330,480,900,66);   qb.addMouseListener(this);   qb.setFont(fontstyle);   qb.setForeground(c);   KBCFRAME.add(qb);  
                aopt = new JLabel("");                  aopt.setBounds(280,595,333,36); aopt.addMouseListener(this); aopt.setFont(fontstyle); aopt.setForeground(c); KBCFRAME.add(aopt);
			   	bopt = new JLabel("");                  bopt.setBounds(765,595,333,36);	bopt.addMouseListener(this); bopt.setFont(fontstyle); bopt.setForeground(c); KBCFRAME.add(bopt);
			    copt = new JLabel("");		            copt.setBounds(280,667,333,36);	copt.addMouseListener(this); copt.setFont(fontstyle); copt.setForeground(c); KBCFRAME.add(copt);
				dopt = new JLabel("");		            dopt.setBounds(765,667,333,36);	dopt.addMouseListener(this); dopt.setFont(fontstyle); dopt.setForeground(c); KBCFRAME .add(dopt);
	 					  
	            LOCK = new JLabel(new ImageIcon("pic/YesLock.gif"));LOCK.setBounds(460,700,210,55); LOCK.addMouseListener(this); KBCFRAME.add(LOCK);      LOCK.setVisible(false);		   
	            LOCK2= new JLabel(new ImageIcon("pic/NoLock.gif")); LOCK2.setBounds(680,700,210,55);LOCK2.addMouseListener(this);KBCFRAME.add(LOCK2);     LOCK2.setVisible(false);		   
  
	 Button5050      = new JLabel(new ImageIcon("pic/5050.gif"));           Button5050.setBounds(350,35,90,60);     Button5050.addMouseListener(this);    KBCFRAME.add(Button5050);
	 FlipButton      = new JLabel(new ImageIcon("pic/FLIP.gif"));           FlipButton.setBounds(925,35,90,60);    FlipButton.addMouseListener(this);    KBCFRAME.add(FlipButton);
     AudienceButton  = new JLabel(new ImageIcon("pic/audience.gif"));       AudienceButton.setBounds(1065,35,85,60);AudienceButton.addMouseListener(this);KBCFRAME.add(AudienceButton);
	 QuitButton      = new JLabel(new ImageIcon("pic/Quit.gif"));           QuitButton.setBounds(70,30,120,60);    QuitButton.addMouseListener(this);    KBCFRAME.add(QuitButton);
     StopTimeButton  = new JLabel(new ImageIcon("pic/STOP TIME.gif"));      StopTimeButton.setBounds(1200,35,90,60);StopTimeButton.addMouseListener(this);KBCFRAME.add( StopTimeButton);
 
     DoubleAns       = new JLabel(new ImageIcon("pic/DoubleAns.gif"));        DoubleAns.setBounds(225,30,90,60);     DoubleAns.addMouseListener(this); KBCFRAME.add( DoubleAns);
               
     //////////////////////////////////
     Date d=new Date();
	 					SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	 					 date=sdf.format(d);
	 					 
	 					
	 ///////////////////////////////////
	 					
	 					///////////////****************///////////////    
	 KBCFRAME.add(JL); KBCFRAME.setUndecorated(true); KBCFRAME.setVisible(true);	
	 ///////////////****************///////////////
	                          for(int i =0;i <5;i++)
	                                {	int que=r.nextInt(20); random_que[i]=que; 
									   if(i!=0){ for(int j=0;j<i;j++)
											         {  if(random_que[j]==que)  { que = r.nextInt(20); random_que[i]=que; j=-1;} }
									   
									           }
									}
							  for(int i =5;i<10;i++)
	                                {	int que=r.nextInt(40);  if(que < 21){i=4;}
										                        else{ random_que[i]=que;  if(i!=5){ for(int j=0;j<i;j++)
											                                                        {  if(random_que[j]==que)  { que = r.nextInt(40); random_que[i]=que; j=-1;}  }
									                                                              }
										                            }
									}
							  for(int i =10;i<15;i++)
	                                {	int que=r.nextInt(50);  if(que <40){i=9;}
										                        else{ random_que[i]=que;  if(i!=10){ for(int j=0;j<i;j++)
											                                                         {  if(random_que[j]==que) { que = r.nextInt(50); random_que[i]=que; j=-1;}   }
									                                                               }
										                            }
							        }
                              for(int i=0 ; i<=14 ; i++){ }
      
    // Music.loginMusic();

                         	 try{ 	
                         		 Class.forName("com.mysql.jdbc.Driver");
                         		
                         		 Connection can = DriverManager.getConnection(path,user,pass);
                         		 PreparedStatement pstmt=can.prepareStatement("Select * from qbank where qno='"+random_que[amt_value]+"'");
                         		 ResultSet rst=pstmt.executeQuery();
                         		
                                  while(rst.next())
                         		   {if(rst.getString(2).length()<75){qb.setFont(new Font("Times New Roman",2,25));}
                         		    else if (rst.getString(2).length()<120){qb.setFont(new Font("Times New Roman",2,18));}
                         		    else {qb.setFont(new Font("Times New Roman",2,16));}
                         			qb.setText(rst.getString(2));   aopt.setText(rst.getString(3)); bopt.setText(rst.getString(4)); copt.setText(rst.getString(5)); dopt.setText(rst.getString(6)); real_answer=rst.getString(7); }
                         	    }
                         	 catch( ClassNotFoundException ex) { System.out.println("Class Problem "+ex); }
                         	 catch(SQLException ex)            { System.out.println("SQL Problem "+ex);   }
                                    
                         	 BackVoice bv = new BackVoice();              T3 = new Thread(bv); T3.start();
                              Question   Q = new Question(random_que[qn]); T2 = new Thread(Q);  T2.start();
                                     
                         	 T = new Thread(this); T.start();
                         	 amt_value++; qn++;rup_value++;
                            
                         	}////  END OF CONSTRUCTOR/////////

 

public void mouseClicked(MouseEvent me)
	{
	  if(me.getSource()==aopt) { Music.FreeArea();   aopt.setForeground(green); user_answer="a"; LOCK.setVisible(true);LOCK2.setVisible(true);
	  bopt.setVisible(false);copt.setVisible(false);dopt.setVisible(false);Sure=1;}
    if(me.getSource()==bopt) { Music.FreeArea();   bopt.setForeground(green); user_answer="b"; LOCK.setVisible(true);LOCK2.setVisible(true);
    aopt.setVisible(false);copt.setVisible(false);dopt.setVisible(false);Sure=1; }
	  if(me.getSource()==copt) { Music.FreeArea();   copt.setForeground(green); user_answer="c"; LOCK.setVisible(true);LOCK2.setVisible(true);
	  bopt.setVisible(false);aopt.setVisible(false);dopt.setVisible(false);Sure=1;}
	  if(me.getSource()==dopt) { Music.FreeArea();   dopt.setForeground(green); user_answer="d"; LOCK.setVisible(true);LOCK2.setVisible(true);
	  bopt.setVisible(false);copt.setVisible(false);aopt.setVisible(false);Sure=1;}
	  if(Sure==1)              { Music2.Sure1();     Sure=0;}
	  System.out.println("a "+ax);System.out.println("b "+bx);System.out.println("c "+cx);System.out.println("d "+dx);
	  if(me.getSource()==LOCK2)
	  {
		  LOCK.setVisible(false);
	  LOCK2.setVisible(false);
	
	if(ax==1 && dx==1)
	{
		System.out.println("a d");
		aopt.setVisible(false);dopt.setVisible(false);
		bopt.setVisible(true);copt.setVisible(true);
		bopt.setForeground(c);copt.setForeground(c);
	}
	else if(bx==1 && cx==1)
	{
		System.out.println("b c");
		aopt.setVisible(true);dopt.setVisible(true);
		bopt.setVisible(false);copt.setVisible(false);
		aopt.setForeground(c);dopt.setForeground(c);
	}
	
	else
		
	{
		ax=0;bx=0;cx=0;dx=0;
		System.out.println("else");
		  aopt.setForeground(white);
		  bopt.setForeground(white);
		  copt.setForeground(white);
		  dopt.setForeground(white);	
		aopt.setVisible(true);bopt.setVisible(true);copt.setVisible(true);dopt.setVisible(true); }
	 } 
	if(me.getSource()==LOCK) { TimePointPass=1;
	                             LOCK.setVisible(true);LOCK2.setVisible(true);
	                             if(user_answer.equals(real_answer))
		                           {        TimeStatus = 1;  TimeLabel.setVisible(false);
									       
										if(first==0){  LOCK.setVisible(false);LOCK2.setVisible(false);aopt.setVisible(true);bopt.setVisible(true);copt.setVisible(true);dopt.setVisible(true);first++;ax=0;bx=0;cx=0;dx=0;}

											   
											  if(first == 1)
									            {
												  if(q==1) { Music2.Amt5000();}  if(q==2){ Music2.Amt10000();}
												  if(q==3) { Music2.Amt20000();} if(q==4){ Music2.Amt40000();} if(q==5){ Music2.Amt80000();}
												  if(q==6) { Music.LockMusic();Music2.Amt160000();}            if(q==7){ Music.LockMusic(); Music2.Amt320000();}
												  if(q==8) { Music.LockMusic(); Music2.Amt640000();}           if(q==9){ Music.LockMusic(); Music2.Amt1250000();}
												  if(q==10){ Music2.Amt2500000();}				               if(q==11){Music2.Amt5000000();}
												 if(q==12){ Music2.Amt1CRORE();}				               if(q==13){Music2.Amt1CRORE();}
												if(q==14){Music2.Amt1CRORE();}
												  if(q==15){ Music2.Amt1CRORE(); TimeStatus = 1;  TimeLabel.setVisible(false); 
												            
															ShowTopAmount15.setVisible(true);
															ShowTopAmount14.setVisible(false);
															qb.setVisible(false);            aopt.setVisible(false);          bopt.setVisible(false);
			                                                copt.setVisible(false);          dopt.setVisible(false);          LOCK.setVisible(false);
			                                                LOCK2.setVisible(false);         Button5050.setVisible(false);    FlipButton.setVisible(false);
			                                                AudienceButton.setVisible(false);StopTimeButton.setVisible(false);QuitButton.setVisible(false);
			                                                DoubleAns.setVisible(false);     checkamount.setVisible(true); print.setVisible(true);
												            checkamount.setVisible(true);
												            rupee = new JLabel(rup[15]);
															amount = new JLabel(amt[15]);
											Name=new JLabel(name);
											Date=new JLabel(date);
															amount.setBounds(602,192,200,90);
															amount.setFont(fontBold2);
															amount.addMouseListener(this);
															
												
						                                      		rupee.setBounds(150,180,600,90);
						                                     		rupee.setFont(fontBold2);
						                                      		rupee.addMouseListener(this);
						                                      		
						                                      		Name=new JLabel(name);		Date=new JLabel(date);
						                                             Name.setBounds(145,115,500,90);	Date.setBounds(570,40,500,90);
						                                             Name.addMouseListener(this);	Date.addMouseListener(this);
						                                             Name.setFont(fontBold2);Date.setFont(fontBold2);
						                                             checkamount.add(Name);	checkamount.add(Date);
						                                      		
						                                      		checkamount.add(amount);checkamount.add(rupee);
		
														  
														  }
													first = 0;	 										    
												}
											  

											switch(q)
			                                  {  case 0: ShowTopAmount.setVisible(true);  break;
				                                 case 1: Level1Button.setVisible(true);  Level2Button.setVisible(true);  ShowTopAmount1.setVisible(true); ShowTopAmount.setVisible(false); break;
		                                		 case 2: Level2Button.setVisible(true);  Level3Button.setVisible(true);  ShowTopAmount2.setVisible(true); ShowTopAmount1.setVisible(false); break;
				                                 case 3: Level3Button.setVisible(true);  Level4Button.setVisible(true);  ShowTopAmount3.setVisible(true); ShowTopAmount2.setVisible(false); break;
				                                 case 4: Level4Button.setVisible(true);  Level5Button.setVisible(true);  ShowTopAmount4.setVisible(true); ShowTopAmount3.setVisible(false); break;
				                                 case 5: Level5Button.setVisible(true);  Level6Button.setVisible(true);  ShowTopAmount5.setVisible(true); ShowTopAmount4.setVisible(false); break;
				                                 case 6:  Level6Button.setVisible(true);  Level7Button.setVisible(true);  ShowTopAmount6.setVisible(true); ShowTopAmount5.setVisible(false); break;
				                                 case 7: Level7Button.setVisible(true);  Level8Button.setVisible(true);  ShowTopAmount7.setVisible(true); ShowTopAmount6.setVisible(false); break;
				                                 case 8:Time60 = 1; Level8Button.setVisible(true);  Level9Button.setVisible(true);  ShowTopAmount8.setVisible(true); ShowTopAmount7.setVisible(false); break;
				                                 case 9: Level9Button.setVisible(true);  Level10Button.setVisible(true); ShowTopAmount9.setVisible(true);ShowTopAmount8.setVisible(false); break;
			                                     case 10:Level10Button.setVisible(true); Level11Button.setVisible(true); ShowTopAmount10.setVisible(true);ShowTopAmount9.setVisible(false);break;
				                                 case 11:Level11Button.setVisible(true); Level12Button.setVisible(true); ShowTopAmount11.setVisible(true);ShowTopAmount10.setVisible(false);break;				
				                                 case 12: Level12Button.setVisible(true);  Level13Button.setVisible(true); ShowTopAmount12.setVisible(true);ShowTopAmount11.setVisible(false); break;
			                                     case 13:Level13Button.setVisible(true); Level14Button.setVisible(true); ShowTopAmount13.setVisible(true);ShowTopAmount12.setVisible(false);break;
				                                 case 14:Level14Button.setVisible(true); Level15Button.setVisible(true); ShowTopAmount14.setVisible(true);ShowTopAmount13.setVisible(false);break;			
				                                 case 15:ShowTopAmount15.setVisible(true);ShowTopAmount14.setVisible(false);break;
				                              }											
											 q++;amt_value2++;rup_value2++;
											
						if(amt_value<=14){  	
											try
	                                          { Class.forName("com.mysql.jdbc.Driver");
		                                        Connection can = DriverManager.getConnection(path,user,pass);
		                                        
		                                        PreparedStatement pstmt=can.prepareStatement("Select * from qbank where qno='"+random_que[amt_value++]+"'");
		                                        ResultSet rst=pstmt.executeQuery();
                                              while(rst.next())  {if(rst.getString(2).length()<75){qb.setFont(new Font("Times New Roman",2,25));}
		                                                            else if (rst.getString(2).length()<120){qb.setFont(new Font("Times New Roman",2,18));}
		                                                            else {qb.setFont(new Font("Times New Roman",2,16));}
			                                                        qb.setText(rst.getString(2)); TimeStatus = 0;												                      
																	aopt.setText(rst.getString(3));
																	bopt.setText(rst.getString(4));copt.setText(rst.getString(5));
																	dopt.setText(rst.getString(6));real_answer=rst.getString(7);
																   }
																    T = new Thread(this); T.start();
		                                                            Question Q = new Question(random_que[qn++]);
		                                                            T2 = new Thread(Q);   T2.start();
                                              question_counter++;
											  }
	                                         catch( ClassNotFoundException ex)  {System.out.println("Class Problem"+ex);}
		                                     catch(SQLException ex)             {System.out.println("SQL Problem"+ex); }
                                           question_counter++;
											 aopt.setForeground(white);bopt.setForeground(white);copt.setForeground(white);dopt.setForeground(white); 
			                             }
										}
	                  
		else{   
			 if(user_answer.equals("a")){aopt.setForeground(orange);}
			 else if(user_answer.equals("b")){bopt.setForeground(orange);}
			 else if(user_answer.equals("c")){copt.setForeground(orange);}
			 else {dopt.setForeground(orange);}
			 TimeStatus = 1;  
			  Music.LockMusic();Music.wrong();
			 if (DoubAns==0)
			  {

				 if(real_answer.equals("a")){aopt.setForeground(Color.GREEN);} 
				 else if(real_answer.equals("b")){bopt.setForeground(Color.GREEN);}
				 else if(real_answer.equals("c")){copt.setForeground(Color.GREEN);}
				 else	{dopt.setForeground(Color.GREEN);}
             JOptionPane.showMessageDialog(null,"Sorroy Wrong Answer , Right answer was " + real_answer,"Admin",3);
            qb.setVisible(false);            aopt.setVisible(false);      bopt.setVisible(false);      copt.setVisible(false);      dopt.setVisible(false);
			  LOCK.setVisible(false);          LOCK2.setVisible(false);     Button5050.setVisible(false);FlipButton.setVisible(false);AudienceButton.setVisible(false);
			  StopTimeButton.setVisible(false);QuitButton.setVisible(false);DoubleAns.setVisible(false);LOCK.setVisible(false);      LOCK2.setVisible(false);     TimeLabel.setVisible(false);
		   	  user_answer="null";
		   	  
		   	Name=new JLabel(name);		Date=new JLabel(date);
            Name.setBounds(145,115,500,90);	Date.setBounds(570,40,200,90);
            Name.addMouseListener(this);	Date.addMouseListener(this);
            Name.setFont(fontBold2);Date.setFont(fontBold2);
            
		   	  
		   	rupee = new JLabel(rup[rup_value2]);
		   	  rupee.setBounds(150,180,600,90);
       		rupee.setFont(fontBold2);
      		rupee.addMouseListener(this);checkamount.add(rupee);checkamount.add(Name);	checkamount.add(Date);
		      checkamount.setVisible(true);print.setVisible(true); amount = new JLabel(amt[amt_value2]); amount.setBounds(602,192,200,90); amount.setFont(fontBold2); amount.addMouseListener(this); checkamount.add(amount);
		     }
		  else if (DoubAns==1)
			  {
			
			  aopt.setVisible(true);bopt.setVisible(true);copt.setVisible(true);dopt.setVisible(true);
			   LOCK.setVisible(false);      LOCK2.setVisible(false); 
			   user_answer="null";
		      DoubAns=0;
		      }
			
			}
		      if(status5050.equals("true")){ aopt.setVisible(true); bopt.setVisible(true); copt.setVisible(true); dopt.setVisible(true); }		
		} ///// END Of LOCK IF-ELSE  ////
   if(me.getSource()==DoubleAns)
		{
	      if(lifeline5==0)
			{ Music.lifeline();TimeStatus = 0;
		    //  DoubAns2=2;
			  DoubAns=1;
		     lifeline5++;
		    }
	  
	    else{ JOptionPane.showMessageDialog(null,"Sorry you have already used the lifeline","Owner",1);	}
	    }
	
	
	if(me.getSource()==Button5050){ if(lifeline1==0) { Music.lifeline(); lifeline1++; 	status5050="true";
				                                       if(real_answer.equals("a"))	    { bopt.setVisible(false); copt.setVisible(false); bx=1;cx=1; }
				                                       else if(real_answer.equals("b")) { aopt.setVisible(false); dopt.setVisible(false); ax=1;dx=1;}
			                                           else if(real_answer.equals("c")) { aopt.setVisible(false); dopt.setVisible(false); ax=1;dx=1;}
				                                       else                          	{ bopt.setVisible(false); copt.setVisible(false);bx=1;cx=1;}
			                                         }
			                        else{ JOptionPane.showMessageDialog(null,"Sorry you have already used the lifeline","lovish",1);	}
  	                         
	
	}//// END OF CLICK BUTTON 5050///		
	if(me.getSource()==FlipButton){  TimeStatus = 0;TimeLabel.setVisible(true);if(lifeline2==0){ Music.lifeline();
			                                           try{ Class.forName("com.mysql.jdbc.Driver");
		                                                    Connection can = DriverManager.getConnection(path,user,pass);
		                                                         int flipQuestion = r.nextInt(20);
		                                                        for(int i=0;i<=4;i++){ if(flipQuestion==random_que[i]) { flipQuestion = r.nextInt(20);i=-1;} }
                                                              
									                             if(real_answer.equals("a"))	 { bopt.setVisible(true); dopt.setVisible(true); }
				                                                 else if(real_answer.equals("b")){ aopt.setVisible(true); dopt.setVisible(true); }
			                                                     else if(real_answer.equals("c")){ aopt.setVisible(true); dopt.setVisible(true); }
				                                                 else                            { bopt.setVisible(true); copt.setVisible(true); }
		                                                    PreparedStatement pstmt=can.prepareStatement("Select * from qbank where qno='"+flipQuestion+"'");
	                                                        ResultSet rst=pstmt.executeQuery();
			                                                  while(rst.next())
		                                                       { if(rst.getString(2).length()<75)       {qb.setFont(new Font("Times New Roman",2,25));}
		                                                         else if(rst.getString(2).length()<120) {qb.setFont(new Font("Times New Roman",2,18));}
		                                                         else                                   {qb.setFont(new Font("Times New Roman",2,16));}
								                                 qb.setText(rst.getString(2)); aopt.setText(rst.getString(3)); bopt.setText(rst.getString(4)); copt.setText(rst.getString(5)); dopt.setText(rst.getString(6)); real_answer=rst.getString(7);
															   }
		                                                       question_counter++;
																 Question Q = new Question(flipQuestion);
		                                                         T2 = new Thread(Q);
		                                                         T2.start();
			         		                                 }
	                                                      catch( ClassNotFoundException ex){ System.out.println("Class Problem"+ex); }
		                                                  catch(SQLException ex)           { System.out.println("SQL Problem"+ex);   }
			                                              ////// End Of Try Catch /////
                                                              lifeline2++;
					                                    }
		                               else{ JOptionPane.showMessageDialog(null,"Sorry you have already used the lifeline","lovish",1); }
	                                } ///// END OF CLICK FLIP BUTTON ////
  if(me.getSource()==AudienceButton){ if(lifeline3==0){ Music.lifeline(); TimeStatus = 2;  lifeline3++; Music.AudienceVoting();  
	                                                      if(real_answer.equals("a"))        { new AudiencePoleA(); }
					                                      else if(real_answer.equals("b"))   { new AudiencePoleB(); }
			                                              else if(real_answer.equals("c"))   { new AudiencePoleC(); }
					                                      else	                             { new AudiencePoleD(); }
					                                    }
		                                                  else { JOptionPane.showMessageDialog(null,"Sorry you have already used the lifeline","Pawan",1); }
		                              }///// END OF CLICK Audience BUTTON ////
  if(me.getSource()==StopTimeButton){ if(lifeline4==0){ Music.lifeline(); TimeStatus = 1;	 lifeline4++;           }
			                            else { JOptionPane.showMessageDialog(null,"Sorry you have already used the lifeline","lovish",1); }
		                              }//// END OF STOPTIMEBUTTON  /////
	if(me.getSource()==QuitButton)    { TimeStatus =1; Music.lifeline(); 
		                                qb.setVisible(false);               aopt.setVisible(false);          bopt.setVisible(false);       copt.setVisible(false);       dopt.setVisible(false);
		                                LOCK.setVisible(false);             LOCK2.setVisible(false);         Button5050.setVisible(false); FlipButton.setVisible(false); AudienceButton.setVisible(false);
		                                StopTimeButton.setVisible(false);   QuitButton.setVisible(false);    XButton.setVisible(true);     DoubleAns.setVisible(false);
                                      amount=new JLabel(amt[amt_value2]); rupee=new JLabel(rup[rup_value2]); Name=new JLabel(name);		Date=new JLabel(date);
                                      amount.setBounds(602,192,200,90);		rupee.setBounds(150,180,600,90);	Name.setBounds(145,115,500,90);	Date.setBounds(570,40,200,90);
                                      amount.setFont(fontBold2);			rupee.setFont(fontBold2);		Name.setFont(fontBold2);	Date.setFont(fontBold2);
                                      amount.addMouseListener(this);		rupee.addMouseListener(this);	Name.addMouseListener(this);	Date.addMouseListener(this);
                                      checkamount.add(amount); checkamount.add(rupee);		checkamount.add(Name);	checkamount.add(Date);
                                      checkamount.setVisible(true);
                                      print.setVisible(true);
		                              }
	
	 
	

	
	///// END OF CLICK Quit BUTTON ////
  if(me.getSource()==XButton)      {TimeStatus = 1; new StartPage(null);KBCFRAME.dispose(); } ///// END OF CLICK X BUTTON ////

	if(me.getSource()==print)
	{ Amount=amount.getText();
	 Rupee=rupee.getText();
		try
		{
		String report="E:\\Project\\CBK\\checkreport\\report1.jrxml";
		JasperReport jr=JasperCompileManager.compileReport(report);
		Map props=new HashMap();
		props.put("name",name);
		props.put("date",date);
		props.put("amount",Amount);
		props.put("rupees",Rupee);
		
		JasperPrint jp=JasperFillManager.fillReport(jr, props);
		JasperViewer.viewReport(jp);
		}
		catch(Exception e)
		{
			System.out.println("Exceptions occur"+e);
		} 
		
	}
	
	
	
	
	
	
	} //////// END OF MOUSE CLICKED ////

	public void mouseEntered(MouseEvent me)
	    {
	        if(me.getSource()==XButton)        { CloseLable.setVisible(true);                                 }
	        if(me.getSource()==c5)             { c5.setForeground(new Color(255,128,0));                      }
	        if(me.getSource()==aopt)           { aopt.setFont(fontstyle2);                                    }
          if(me.getSource()==bopt)           { bopt.setFont(fontstyle2);             	                      }
		    if(me.getSource()==copt)           { copt.setFont(fontstyle2);             	                      }
		    if(me.getSource()==dopt)           { dopt.setFont(fontstyle2);                                    }
          if(me.getSource()==Button5050)     { Option5050.setVisible(true);	                              }
	        if(me.getSource()==FlipButton)     { FlipOption.setVisible(true);                                 }
			if(me.getSource()==StopTimeButton) { StopTimeOption.setVisible(true);                             }
	        if(me.getSource()==AudienceButton) { AudienceOption.setVisible(true);                             }
          if(me.getSource()==QuitButton)     { QuitOption.setVisible(true);                                 }
			if(me.getSource()==DoubleAns)      { DoubleAnsOption.setVisible(true);                            }
	        if(me.getSource()==AmitabPic1)     { AmitabPic1.setVisible(false);  AmitabPic12.setVisible(true); }
	    }  ///// END OF MOUSE ENTERED  ////
	public void mouseExited(MouseEvent me) 
	    { 		
		   if(me.getSource()==XButton)         { CloseLable.setVisible(false);                                }
	       if(me.getSource()==c5)              { c5.setForeground(new Color(255,255,255));                    }
		   if(me.getSource()==aopt)            { aopt.setFont(fontstyle); 	                                  }
		   if(me.getSource()==bopt)            { bopt.setFont(fontstyle);                                     }
		   if(me.getSource()==copt)            { copt.setFont(fontstyle);                                     }
		   if(me.getSource()==dopt)            { dopt.setFont(fontstyle);  	                                  }
         if(me.getSource()==Button5050)      { Option5050.setVisible(false);                                }
	       if(me.getSource()==FlipButton)      { FlipOption.setVisible(false);	                              } 
	       if(me.getSource()==StopTimeButton)  { StopTimeOption.setVisible(false);                            }
		   if(me.getSource()==AudienceButton)  { AudienceOption.setVisible(false);                            }
	       if(me.getSource()==QuitButton) 	   { QuitOption.setVisible(false); 	                              }
		   if(me.getSource()==DoubleAns)       { DoubleAnsOption.setVisible(false);                           }
	       if(me.getSource()==AmitabPic12)     { AmitabPic12.setVisible(false);  AmitabPic1.setVisible(true); }
	   	}
	public void mousePressed(MouseEvent me)    {}
	public void mouseReleased(MouseEvent me)   {}
  // ***************************************************************************** //
	// ***************************************************************************** //
	 public void run()
	  {  TimeLabel = new JLabel();TimeLabel.setBounds(128,350,100,100); TimeLabel.setFont(fontstyle3);TimeLabel.setForeground(c); JL.add(TimeLabel); JL.setVisible(true);
	     if(FullyTimeStop==0 && Time60==0)
	      { for(int i=60;i>=0;i--){
	    	  
	    	  if( TimeStatus == 1){ break; }
	    	  if(i>9)
	    	  {
	    		  n=String.valueOf(i);TimeLabel.setText(n);
	    	  }
	    	  else
	    	  {
	    	  
		                              System.out.println(i); n = String.valueOf("0"+i); TimeLabel.setText(n);} 
				                    if(TimeStatus== 2)  { try{ Thread.sleep(13000); TimeStatus=0; } catch(Exception e) {  System.out.println(e); } }
                                     try{ Music.TikTik(); Thread.sleep(400); } catch(Exception e) {  System.out.println(e); }
			                       if(i==0){ if(TimePointPass==1)
						                       {
			                                     qb.setVisible(false);             aopt.setVisible(false);      bopt.setVisible(false);       copt.setVisible(false);       dopt.setVisible(false);     
												 LOCK.setVisible(false); 	       LOCK2.setVisible(false);     Button5050.setVisible(false); DoubleAns.setVisible(false); FlipButton.setVisible(false); AudienceButton.setVisible(false);
							                     StopTimeButton.setVisible(false); QuitButton.setVisible(false);XButton.setVisible(false);
												 FullyTimeStop = 1;                 int Break = 1;
                                               }
					                          if( Break == 1) { Music.TimeOver();
											                    checkamount.setVisible(true); print.setVisible(true);
											                    amount=new JLabel(amt[amt_value-1]);rupee=new JLabel(rup[rup_value-1]);Name=new JLabel(name);Date=new JLabel(date);
																amount.setBounds(602,192,200,90);rupee.setBounds(150,180,600,90);Name.setBounds(145, 115, 500, 90);Date.setBounds(570, 40, 200, 90);
																amount.setFont(fontBold2);rupee.setFont(fontBold2);Name.setFont(fontBold2);Date.setFont(fontBold2);
																amount.addMouseListener(this);rupee.addMouseListener(this);    Name.addMouseListener(this);Date.addMouseListener(this);
																checkamount.add(amount);checkamount.add(rupee);checkamount.add(Name);checkamount.add(Date);
																 qb.setVisible(false); aopt.setVisible(false); bopt.setVisible(false); copt.setVisible(false);dopt.setVisible(false); LOCK.setVisible(false);LOCK2.setVisible(false);
						                                        Button5050.setVisible(false); FlipButton.setVisible(false);DoubleAns.setVisible(false); AudienceButton.setVisible(false); StopTimeButton.setVisible(false);QuitButton.setVisible(false);
			                                   
						                      
															  }
						                                        break;
					                        }
			                      }//  End Of For Loop
	  	    }
		   if(FullyTimeStop==0 && Time60==1)
		    {for(int i=90;i>=0;i--){ 
		    	if( TimeStatus == 1){ break; }
		    if(i>9)
	    	  {
	    		  n=String.valueOf(i);TimeLabel.setText(n);
	    	  }
	    	  else
	    	  {
		                              System.out.println(i); n = String.valueOf("0"+i); TimeLabel.setText(n); }
				                     if(TimeStatus== 2){ try{ Thread.sleep(13000); TimeStatus=0; } catch(Exception e) {  System.out.println(e); } }
                                      try{ Music.TikTik(); Thread.sleep(400);   } catch(Exception e) {  System.out.println(e); }
			                         if(i==0){ Music.TimeOver();
                                               checkamount.setVisible(true);print.setVisible(true); amount = new JLabel(amt[amt_value-1]); amount.setBounds(602,192,200,90); amount.setFont(fontBold2); amount.addMouseListener(this); checkamount.add(amount);
		                                      
                                               rupee=new JLabel(rup[rup_value-1]);Name=new JLabel(name);Date=new JLabel(date);
                                               rupee.setBounds(150,180,600,90);Name.setBounds(145, 115, 500, 90);Date.setBounds(570, 40, 200, 90);
                                               rupee.setFont(fontBold2);Name.setFont(fontBold2);Date.setFont(fontBold2);
                                               rupee.addMouseListener(this);    Name.addMouseListener(this);Date.addMouseListener(this);
                                               checkamount.add(rupee);checkamount.add(Name);checkamount.add(Date);
                                               qb.setVisible(false); aopt.setVisible(false); bopt.setVisible(false); copt.setVisible(false);dopt.setVisible(false); LOCK.setVisible(false);LOCK2.setVisible(false);
						                       Button5050.setVisible(false); FlipButton.setVisible(false);DoubleAns.setVisible(false); AudienceButton.setVisible(false); StopTimeButton.setVisible(false);QuitButton.setVisible(false);
			                                   FullyTimeStop = 1;
						                       break;
						                     }
			                       }//  End Of For Loop
	  	    }
	}

	

}// End OF CBK class
class BackVoice implements Runnable
  { int a; BackVoice() { Thread T3 = new Thread(); T3.start();   }// End Of BackVoice Constructor
	public void run()  { for(int i=0;;i++){  Music.BackVoice();} }
  }
class Question implements Runnable
  { int QN2; 
    Question(int QN)   { QN2 = QN; Thread T2 =new Thread(); T2.start(); }// End Of Question Constructor
	public void run()  { switch(QN2) {
		                               case  0:  Music.StartQuestion(); QVoice.Q0(); break;  case  1:  Music.StartQuestion(); QVoice.Q1();  break;
		                               case  2:  Music.StartQuestion(); QVoice.Q2();  break;  case  3:  Music.StartQuestion(); QVoice.Q3();  break;
		                               case  4:  Music.StartQuestion(); QVoice.Q4();  break;  case  5:  Music.StartQuestion(); QVoice.Q5();  break;
		                               case  6:  Music.StartQuestion(); QVoice.Q6();  break;  case  7:  Music.StartQuestion(); QVoice.Q7();  break;
		                               case  8:  Music.StartQuestion(); QVoice.Q8();  break;  case  9:  Music.StartQuestion(); QVoice.Q9();  break;
		                               case  10: Music.StartQuestion(); QVoice.Q10(); break;  case  11: Music.StartQuestion(); QVoice.Q11(); break;
		                               case  12: Music.StartQuestion(); QVoice.Q12(); break;  case  13: Music.StartQuestion(); QVoice.Q13(); break;
		                               case  14: Music.StartQuestion(); QVoice.Q14(); break;  case  15: Music.StartQuestion(); QVoice.Q15(); break;
		                               case  16: Music.StartQuestion(); QVoice.Q16(); break;  case  17: Music.StartQuestion(); QVoice.Q17(); break;
		                               case  18: Music.StartQuestion(); QVoice.Q18(); break;  case  19: Music.StartQuestion(); QVoice.Q19(); break;
		                               case  20: Music.StartQuestion(); QVoice.Q20(); break;  case  21: Music.StartQuestion(); QVoice.Q21(); break;
		                               case  22: Music.StartQuestion(); QVoice.Q22(); break;  case  23: Music.StartQuestion(); QVoice.Q23(); break;
		                               case  24: Music.StartQuestion(); QVoice.Q24(); break;  case  25: Music.StartQuestion(); QVoice.Q25(); break;
		                               case  26: Music.StartQuestion(); QVoice.Q26(); break;  case  27: Music.StartQuestion(); QVoice.Q27(); break;
		                               case  28: Music.StartQuestion(); QVoice.Q28(); break;  case  29: Music.StartQuestion(); QVoice.Q29(); break;
		                               case  30: Music.StartQuestion(); QVoice.Q30(); break;  case  31: Music.StartQuestion(); QVoice.Q31(); break;
		                               case  32: Music.StartQuestion(); QVoice.Q32(); break;  case  33: Music.StartQuestion(); QVoice.Q33(); break;
		                               case  34: Music.StartQuestion(); QVoice.Q34(); break;  case  35: Music.StartQuestion(); QVoice.Q35(); break;
		                               case  36: Music.StartQuestion(); QVoice.Q36(); break;  case  37: Music.StartQuestion(); QVoice.Q37(); break;
		                               case  38: Music.StartQuestion(); QVoice.Q38(); break;  case  39: Music.StartQuestion(); QVoice.Q39(); break;  
		                               case  40: Music.StartQuestion(); QVoice.Q40(); break;  case  41: Music.StartQuestion(); QVoice.Q41(); break;
		                               case  42: Music.StartQuestion(); QVoice.Q42(); break;  case  43: Music.StartQuestion(); QVoice.Q43(); break;
		                               case  44: Music.StartQuestion(); QVoice.Q44(); break;  case  45: Music.StartQuestion(); QVoice.Q45(); break;
		                               case  46: Music.StartQuestion(); QVoice.Q46(); break;  case  47: Music.StartQuestion(); QVoice.Q47(); break;
		                               case  48: Music.StartQuestion(); QVoice.Q48(); break;  case  49: Music.StartQuestion(); QVoice.Q49(); break;
		                               case  50: Music.StartQuestion(); QVoice.Q50(); break;  
		                             }
	                    }
  }
