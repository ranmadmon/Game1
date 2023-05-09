import javax.swing.*;
import java.awt.*;

public  class Pictures extends JLabel {
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon imageIcon;
    public  Pictures (int x,int y,int width,int height,ImageIcon imageIcon){
        super(imageIcon);
        this.setBounds(x,y,width,height);
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

    };

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void moveUp(){
        this.y-=8;
    }
    public void moveDown(){
        this.y+=8;
    }
    public void moveUpSolider(){
        this.y-=12;
    }
    public void moveDownSolider(){
        this.y+=12;
    }
    public void moveLeft(){
        this.x--;
    } public void moveRight(){
        this.x++;
    }
    public void targetStartMoving(MainSence mainSence,boolean goUP){
            new Thread(()->{
            boolean moveUp=goUP;
            while (true){
                while (moveUp){
                    if (this.y>=10){
                        this.moveUp();
                        mainSence.repaint();
                    }else{
                        moveUp = false;
                    }
                    try {
                        Thread.sleep(32);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                while (moveUp==false){
                    if (this.y<=Window.HEIGHT-30-this.height*1.5){
                        this.moveDown();
                        mainSence.repaint();
                    }else {
                        moveUp=true;
                    }
                    try {
                        Thread.sleep(32);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

    }
    public void backToLife(MainSence mainSence,Pictures target,int i){
     Thread thread=new Thread(()->{
            int time=0;
            while (time<3){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                time++;
            }
         mainSence.getTargets().add(target);
         mainSence.add(target);
        });
     thread.start();
        }
    }

