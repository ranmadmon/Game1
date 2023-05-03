import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Random;

public class MainSence extends JPanel {
    private final ImageIcon soliderImage=new ImageIcon("src/picture/img.png");;
    private ArrayList<Pictures> targets=new ArrayList<Pictures>();
    private Pictures solider;
    private JLabel background;
    private ImageIcon backgroundImage;
    private int targetStartingX=266;
    private final int TARGRT_WIDTH=91;
    private final int TARGRT_HEIGHT=109;
    private boolean targetMoveUp=true;


    public MainSence(int x,int y,int width,int height){
        Random random=new Random();
        this.setLayout(null);
        this.setBounds(x,y,width,height);
        this.setBackground(Color.GREEN);
        this.setFocusable(true);
        this.requestFocus();
        MovementListener movementListener = new MovementListener(this);
        this.addKeyListener(movementListener);
        this.solider=new Pictures(20,200,145,135,soliderImage);
       this.add(solider);
       for (int i=0;i<4;i++){
           int yTarget=random.nextInt(100,500);
            Pictures target=new Pictures(targetStartingX,yTarget,TARGRT_WIDTH,TARGRT_HEIGHT,new ImageIcon("src/picture/img_2.png"));
            targets.add(i,target);
           this.targetStartingX+=TARGRT_WIDTH+50;
           this.add(targets.get(i));
           this.targets.get(i).targetStartMoving(this,targetMoveUp);
       }

    }

    public ArrayList<Pictures> getTargets() {
        return targets;
    }

    public ImageIcon getSoliderImage() {
        return soliderImage;
    }

    public Pictures getSolider() {
        return solider;
    }

    public void setSolider(Pictures solider) {
        this.solider = solider;
    }
    public void setBackground(JLabel background) {
        this.background = background;
    }

    public ImageIcon getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(ImageIcon backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
    public void moveUp(){
        this.solider.moveUp();
      //  this.solider.repaint();
    }
    public void moveDown(){
        this.solider.moveDown();
    }


    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

    }


}
