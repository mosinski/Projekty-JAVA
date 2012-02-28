import java.awt.*;
import java.applet.*;

public class Pac extends Applet implements Runnable
{
  private static final long serialVersionUID = -705555689585339843L;
  public Thread thread;
  Image image;
  Image[] a = new Image[5];
  Graphics gc;
  int x;   // aktualna pozycja 
  int w;   // szerokosc apletu
  int h;   // wysokosc apletu
  int i;
   
  public void init()
  {
    thread = null;
    a[0] = getImage(getCodeBase(), "1.jpg");
    a[1] = getImage(getCodeBase(), "2.jpg");
    a[2] = getImage(getCodeBase(), "3.jpg");
    a[3] = getImage(getCodeBase(), "4.jpg");
    a[4] = getImage(getCodeBase(), "5.jpg");
    this.setBounds(0, 0, 500, 80);
    w=getSize().width;
    h=getSize().height;
    x=0;
    i=0;
    image=createImage(w,h);
    gc = image.getGraphics();  
    gc.fillRect(0, 0, w, h); 
    
  }
  
  public void start()
  {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }

  public void stop()
  {
    if (thread != null){
      thread = null;
   }
  }

  public void run()
  {
    while(thread!=null)
    {
      gc = image.getGraphics();
      x ++;      
      if(x == w/4)  x = -30;
      
      gc.setColor(Color.white);
      gc.fillRect(0,0,w,h);      //czyszczenie bufora 
      int r = (x+30)%10;
      if (r == 0 || r == 9 ) i = 0;
      if (r == 1 || r == 8 ) i = 1;
      if (r == 2 || r == 7 ) i = 2;
      if (r == 3 || r == 6 ) i = 3;
      if (r == 4 || r == 5 ) i = 4;
         
      int y = h/2 - 30;
       
      gc.drawImage(a[i], x*4, y, 64, 61, this);
    
      gc.setColor(Color.black);
      for (int j = x; j<=w/4; j++){
    	  if (j%10 == 0) gc.fillOval(j*4 + 25, h/2-11, 22, 22);
      }
      
      repaint();  //lub   paint(getGraphics());
      
      try {
        Thread.sleep(30);
      } catch(InterruptedException e){}
    }
   }
   
   synchronized public void paint(Graphics g){
     g.drawImage(image,0,0,this);
   }
   
   synchronized public void update(Graphics g){
     paint(g);
   } 
}
