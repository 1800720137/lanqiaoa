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
	int x,y; 
	int flag;
	//int leftflag,rightflag,upflag,downflag;
	Image currentImg;
	/* Ò»Î¬Êý×é
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
*/
	Image heroImg[][]=new Image[4][3];

	//Image currentImg,img0,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11;ÒÆ¶¯Í¼Æ¬ÇÐ»»

	public MainCanvas(){
		try
			{
			for (int i=0;i<heroImg.length;i++){
				for (int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
		}
			

			/*
			for (int i=0;i<3;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			for (int i=0;i<3;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
			for (int i=0;i<3;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
			for (int i=0;i<3;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}

*/
			/* ÒÆ¶¯Í¼Æ¬ÇÐ»»
			img0=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo16.png");
			img3=Image.createImage("/sayo14.png");
			img4=Image.createImage("/sayo02.png");
			img5=Image.createImage("/sayo22.png");
			img6=Image.createImage("/sayo06.png");
			img7=Image.createImage("/sayo26.png");
			img8=Image.createImage("/sayo04.png");
			img9=Image.createImage("/sayo24.png");
			img10=Image.createImage("/sayo00.png");
			img11=Image.createImage("/sayo20.png");
*/
			currentImg=heroImg[3][1];
			
			x=120;
			y=100;
			flag=1;
		/*	
			leftflag=1;
			rightflag=1;
			upflag=1;
			downflag=1;
			*/
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void changePicAndDirect(int direction){
			if(flag==1){
				currentImg=heroImg[direction][0];
					flag++;
			}
			else if (flag==2){
				currentImg=heroImg[direction][2];
				flag=1;
			}			
			repaint();
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			changePicAndDirect(0);
			x=x-1;
			}
			if(action==RIGHT){
			changePicAndDirect(1);
			x=x+1;
			}
			if(action==UP){
			changePicAndDirect(2);
			y=y-1;
			}
			if(action==DOWN){
			changePicAndDirect(3);
			y=y+1;
			}
		repaint();
	}
}


/*
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			if(leftflag==1){
				currentImg=heroImg[0][0];
					leftflag++;
			}
			else if (leftflag==2){
				currentImg=heroImg[0][2];
				leftflag=1;
			}
			x=x-1;
			}
			if(action==RIGHT){
			if(rightflag==1){
				currentImg=heroImg[1][0];
					rightflag++;
			}
			else if (rightflag==2){
				currentImg=heroImg[1][2];
				rightflag=1;
			}
			x=x+1;
			}
			if(action==UP){
			if(upflag==1){
				currentImg=heroImg[2][0];
					upflag++;
			}
			else if (upflag==2){
				currentImg=heroImg[2][2];
				upflag=1;
			}
			y=y-1;
			}
			if(action==DOWN){
			if(downflag==1){
				currentImg=heroImg[3][0];
					downflag++;
			}
			else if (downflag==2){
				currentImg=heroImg[3][2];
				downflag=1;
			}
			y=y+1;
			}
			repaint();
	}
}
			

*/





		/*
		if(action==LEFT){
			if(leftflag==1){
				currentImg=heroLeftImg[0];
					leftflag++;
			}
			else if (leftflag==2){
				currentImg=heroLeftImg[2];
				leftflag=1;
			}
			x=x-1;
			}
			if(action==RIGHT){
			if(rightflag==1){
				currentImg=heroRightImg[0];
					rightflag++;
			}
			else if (rightflag==2){
				currentImg=heroRightImg[2];
				rightflag=1;
			}
			x=x+1;
			}
			if(action==UP){
			if(upflag==1){
				currentImg=heroUpImg[0];
					upflag++;
			}
			else if (upflag==2){
				currentImg=heroUpImg[2];
				upflag=1;
			}
			y=y-1;
			}
			if(action==DOWN){
			if(downflag==1){
				currentImg=heroDownImg[0];
					downflag++;
			}
			else if (downflag==2){
				currentImg=heroDownImg[2];
				downflag=1;
			}
			y=y+1;
			}
			repaint();
	}
}
			


*/








/* FORÑ­»·
		if(action==LEFT){
			if(leftflag==1){
				currentImg=img4;
					leftflag++;
			}
			else if (leftflag==2){
				currentImg=img5;
				leftflag=1;
			}
			x=x-1;
			}
		if(action==RIGHT){
			if(rightflag==1){
				currentImg=img6;
					rightflag++;
			}
			else if (rightflag==2){
				currentImg=img7;
				rightflag=1;
			}
			x=x+1;
			}
			if(action==UP){
			if(upflag==1){
				currentImg=img8;
					upflag++;
			}
			else if (upflag==2){
				currentImg=img9;
				upflag=1;
			}
			y=y-1;
			}
			if(action==DOWN){
			if(downflag==1){
				currentImg=img10;
					downflag++;
			}
			else if (downflag==2){
				currentImg=img11;
				downflag=1;
			}
			y=y+1;
			}
			
		repaint();

	}
}   */