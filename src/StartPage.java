


import javax.swing.*;

import java.awt.event.*;

public class StartPage implements MouseListener
{
  JLabel  JB,JB3; 
  String name;
  JFrame JF;
  public StartPage(String name)
	{
	  this.name=name;
	  System.out.println(name);
	 JF = new JFrame("StartPage");              JF.setSize(1366,768);  JF.setLayout(null);
     JLabel JL = new JLabel(new ImageIcon("pic/AMTnew.jpg")); JL.setBounds(0,0,1366,768);
	 JLabel JL2 = new JLabel(new ImageIcon("pic/newonelogo.png")); JL2.setBounds(760,30,450,350);JF.add(JL2);
	
      
     JB  = new JLabel(new ImageIcon("pic/playb.gif"));  JB.setBounds(850,400,300,125);  JB.addMouseListener(this);  JF.add(JB);
	
     JB3 = new JLabel(new ImageIcon("pic/exitb.gif"));  JB3.setBounds(850,560,300,125); JB3.addMouseListener(this); JF.add(JB3);
		
     JF.add(JL);
	 JF.setUndecorated(true);
	 JF.setVisible(true);
	 int start=1;
	 if(start == 1)
		{ Music.loginMusic();}
	  
	}
	
	@Override
	public void mouseClicked(MouseEvent ae) 
	{
		  if(ae.getSource()==JB)
			{
			new NamePage();
			}
	       if(ae.getSource()==JB3)
			{
		     //	JF.dispose();
			 System.exit(2);    // any integer pass as parameter.
			}
			
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) 
	{
		new StartPage(null);
	}
	
}
