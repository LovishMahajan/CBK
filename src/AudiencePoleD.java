

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AudiencePoleD implements MouseListener
{  
	JFrame jf = new JFrame();
	JLabel jl = new JLabel(new ImageIcon("pic/AudienceD.gif"));
	JButton jb = new JButton("X");
  AudiencePoleD()
	{
	 jf.setSize(670,360);
	 jf.setLayout(null);

     jl.setBounds(0,0,670,360);
	 jf.add(jl);
     
	 jb.setBounds(600,10,60,30);
	 jb.addMouseListener(this);
	 jl.add(jb);

	 jf.setUndecorated(true);
	 jf.setLocation(306,98);
     jf.setVisible(true);
	}

public static void main(String[] args) 
	{
	  new AudiencePoleD();	

	}

	public void mouseClicked(MouseEvent me)
	{
	  if(me.getSource()== jb)
		{
	    jf.dispose();
	    }
	}
		public void mouseEntered(MouseEvent arg0) {
			}

	public void mouseExited(MouseEvent arg0) {
	
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
	

