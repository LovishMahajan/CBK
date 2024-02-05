import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class NamePage implements MouseListener
{
	JFrame jf;
	JLabel okbutton,cbkanimat,backpic;
	Font namefont;
	JTextField textname;
	
	public NamePage()
	{
		jf=new JFrame("CBK");
		jf.setLayout(null);
		textname=new JTextField();
		namefont=new Font("OCR A Std",Font.PLAIN,30);
		okbutton=new JLabel(new ImageIcon("pic/okbb.png"));
		cbkanimat=new JLabel(new ImageIcon("pic/rotatelogo.gif"));
		backpic=new JLabel(new ImageIcon("pic/1st.jpg"));
		
		
		
		//setbounds
		textname.setBounds(480,470,400,40);
		okbutton.setBounds(480,540,395,125);
		cbkanimat.setBounds(20,-30,1366,720);
		backpic.setBounds(0,0,1366,768);
		
		//setfont
		textname.setFont(namefont);
		
		okbutton.addMouseListener(this);
		
		//add action*
		jf.add(textname); jf.add(cbkanimat); jf.add(okbutton); jf.add(backpic);
		
		//setbehaviour
		jf.setUndecorated(true);
		jf.setSize(1366,768);
		jf.setVisible(true);
		
	}
	public void mouseClicked(MouseEvent ae)
	{  if(ae.getSource()==okbutton)
		{
		String name=textname.getText();
		
		int flag=0;
		for(int i=0;i<=9;i++)
		{
			if(name.indexOf(String.valueOf(i))!=-1 )
				{
				JOptionPane.showMessageDialog(null,"Username:Only Alphabets Are Required", "lovish", 0);
			    flag=1;
				break;
				}
		}
		if(flag==0)
		{
	    	if(name.equals(""))
				{
	    		JOptionPane.showMessageDialog(null,"Username required", "lovish", 0);
				flag=1;
				}
	    	
	    	else
	    	{
	    		new KBC(name);
	    	}
			}}}
	
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
	
}
	