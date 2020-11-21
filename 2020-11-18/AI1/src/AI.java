import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;
	int leftFlag,rightFlag,upFlag,downFlag;

	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];


	Image img,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
             
			//z
			for (int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			
			}

			for (int i=0;i<heroRightImg.length;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"4.png");
			
			}
			
			for (int i=0;i<heroUpImg.length;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"6.png");
			
			}

			for (int i=0;i<heroDownImg.length;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			
			}

            /*左
			img=Image.createImage("/sayo10.png");
			
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");
            
			/*左
			img4=Image.createImage("/sayo02.png");
			img5=Image.createImage("/sayo22.png");
			img1=Image.createImage("/sayo12.png");
			
            
			//右
			img6=Image.createImage("/sayo06.png");
			img7=Image.createImage("/sayo26.png");
            
			//上
			img8=Image.createImage("/sayo04.png");
			img9=Image.createImage("/sayo24.png");
            
            //下
			img10=Image.createImage("/sayo00.png");
			img11=Image.createImage("/sayo20.png");

			*/

			currentImg=img;

			x=120;
			y=100;

			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(leftFlag==1){
				currentImg=heroLeftImg[0];
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=heroLeftImg[2];
				leftFlag=1;
			}
			System.out.println("向左转");
			x=x-1;
			repaint();
		}
		if(action==UP){
			if(upFlag==1){
				currentImg=img8;
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=img9;
				upFlag=1;
			}
			System.out.print("向上转");
			y=y-1;
			repaint();

		}
		if(action==RIGHT){
			if(rightFlag==1){
				currentImg=img6;
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=img7;
				rightFlag=1;
			}
			System.out.print("向右转");
			x=x+1;
			repaint();
		}
		if(action==DOWN){
			if(downFlag==1){
				currentImg=img10;
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=img11;
				downFlag=1;
			}
			System.out.print("向下转");
			y=y+1;
			repaint();
		}
		repaint();
	}
}