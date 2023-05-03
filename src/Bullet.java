import javax.swing.*;

public class Bullet extends  Pictures{
    private MainSence mainSence;

    public Bullet(int x, int y, int width, int height, ImageIcon imageIcon,MainSence mainSence){
        super(x,y,width,height,imageIcon);
        this.mainSence=mainSence;
        new Thread(()->{
            boolean touch=false;
            while (!touch){
                this.moveRight();
                this.mainSence.repaint();
                for (int i=0;i<this.mainSence.getTargets().size();i++){
                    if (this.getX()>=this.mainSence.getTargets().get(i).getX()&&this.getX()<=this.mainSence.getTargets().get(i).getX()+this.mainSence.getTargets().get(i).getWidth() &&this.getY()>=this.mainSence.getTargets().get(i).getY()&&this.getY()<=this.mainSence.getTargets().get(i).getY()+this.mainSence.getTargets().get(i).getWidth()){
                        touch=true;
                        this.mainSence.remove(this.mainSence.getTargets().get(i));
                        this.mainSence.remove(this);
                        Pictures target=this.mainSence.getTargets().get(i);
                        int index=i;
                        this.mainSence.getTargets().remove(i);
                        target.backToLife(mainSence,target,index);
                        this.mainSence.repaint();

                    }
                }
                try {
                    Thread.sleep(3);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
