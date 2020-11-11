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
	int flag;   //定义图片
	

	Image heroImg[][]=new Image[4][3]; //4个方向，每个方向3张图片，0表示left，1表示right,，2表示up,3表示down

	/*

	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
*/
	
	Image currentImg;

	//Image img,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
    
			 for (int i=0;i<heroImg.length;i++){
				 for(int j=0;j<heroImg[i].length;j++){
					 heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				 }
			 }





			/*
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

			currentImg=heroImg[3][1];

			x=120;
			y=100;

			flag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(200,210,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标

	}

		
	public void changePicAndDirect(int direction){  //自定义函数
		if(flag==1){
			currentImg=heroImg[direction][0];
			flag++;
		}
		else if(flag==2){
				currentImg=heroImg[direction][2];
				flag=1;
			}
			repaint();
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
			
			changePicAndDirect(0);
			x=x-10;
		}
		if(action==UP){
			changePicAndDirect(2);
			y=y-10;
			repaint();

		}
		if(action==RIGHT){
			changePicAndDirect(1);		
			x=x+10;
			repaint();
		}
		if(action==DOWN){
			changePicAndDirect(3);		
			y=y+10;
			repaint();
		}
		repaint();
	}
}