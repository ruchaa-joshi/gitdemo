import java.awt.*;
import java.applet.*;

public class Chesspaint extends Applet
{
	public void paint(Graphics g)
	{
		int x = 100;
		int y= 100;
		int k = 100;
		int l= 100;
		int count=0;
	
	
		/*for(int m=0;m<4;m++)
			
		{
			
			for(int o=1;o<=4;o++)
			{
				
				g.setColor(Color.black);
				g.fillRect(x,y,k,l);
			
				x=x+200;
				
				
			}
		
			y=y+100;
			x=100;
			
		}*/
		for(int m=0;m<4;m++)
			
		{
			
			for(int o=1;o<=4;o++)
			{
				
				g.setColor(Color.black);
				g.fillRect(x,y,k,l);
			
				x=x+200;
				g.setColor(Color.black);
				g.drawRect(x-100,y,k,l);
				
			}
		
			y=y+100;
			x=100;
			count++;
			if(count%2==0)
			{
				g.setColor(Color.black);
				g.fillRect(x,y,k,l);
			
				y=y+200;
				g.setColor(Color.black);
				g.drawRect(x-100,y,k,l);
			}

		
		}


		
		

		
	}

}

/* <applet code ="Chesspaint" width=1200 height=1200> </applet>*/