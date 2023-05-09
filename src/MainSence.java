import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class MainSence extends JPanel {
    private final ImageIcon soliderImage=new ImageIcon("src/picture/img.png");;
    private ArrayList<Pictures> targets=new ArrayList<Pictures>();
    private Pictures solider;
    private ImageIcon backgroundImage;
    private PanelScore panelScore;
    private int targetStartingX=266;
    private int startXLINE=266;
    private final int TARGRT_WIDTH=91;
    private final int TARGRT_HEIGHT=109;
    private boolean targetMoveUp=true;

    private BufferedImage background;


    public MainSence(int x,int y,int width,int height,PanelScore panelScore){
        this.addBackground();
        this.panelScore=panelScore;
        Random random=new Random();
        this.setLayout(null);
        this.setBounds(x,y,width,height);
        this.setFocusable(true);
        this.requestFocus();
        MovementListener movementListener = new MovementListener(this,panelScore.getWindow());
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
    private void addBackground()  {
        try {
            this.background=ImageIO.read(new File("src/picture/img_4.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public PanelScore getPanelScore() {
        return panelScore;
    }

    public void setTargets(ArrayList<Pictures> targets) {
        this.targets = targets;
    }

    public void setPanelScore(PanelScore panelScore) {
        this.panelScore = panelScore;
    }

    public int getTargetStartingX() {
        return targetStartingX;
    }

    public void setTargetStartingX(int targetStartingX) {
        this.targetStartingX = targetStartingX;
    }

    public int getStartXLINE() {
        return startXLINE;
    }

    public void setStartXLINE(int startXLINE) {
        this.startXLINE = startXLINE;
    }

    public int getTARGRT_WIDTH() {
        return TARGRT_WIDTH;
    }

    public int getTARGRT_HEIGHT() {
        return TARGRT_HEIGHT;
    }

    public boolean isTargetMoveUp() {
        return targetMoveUp;
    }

    public void setTargetMoveUp(boolean targetMoveUp) {
        this.targetMoveUp = targetMoveUp;
    }

    public void setBackground(BufferedImage background) {
        this.background = background;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D=(Graphics2D)g;
        graphics2D.drawImage(this.background,0,0,getWidth(),getHeight(),null);

        }
    }
