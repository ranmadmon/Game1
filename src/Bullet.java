import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class Bullet extends  Pictures{
    private MainSence mainSence;


    public Bullet(int x, int y, int width, int height, ImageIcon imageIcon,MainSence mainSence){
        super(x,y,width,height,imageIcon);
        this.mainSence=mainSence;
        this.bulletAudio();
        new Thread(()->{
            boolean touch=false;
            while (!touch){
                    this.moveRight();
                this.mainSence.repaint();
                if (this.mainSence.getTargets().size()!=0){
                    for (int i=0;i<this.mainSence.getTargets().size();i++){
                        if (this.getX()>=this.mainSence.getTargets().get(i).getX()&&this.getX()<=this.mainSence.getTargets().get(i).getX()+this.mainSence.getTargets().get(i).getWidth() &&this.getY()>=this.mainSence.getTargets().get(i).getY()&&this.getY()<=this.mainSence.getTargets().get(i).getY()+this.mainSence.getTargets().get(i).getWidth()&&this.mainSence.getTargets().size()!=0){
                            touch=true;
                            this.bulletHit();
                            this.mainSence.getPanelScore().killSolider();
                            this.mainSence.getPanelScore().getKills().setText("Kills : "+this.mainSence.getPanelScore().getKillsCounter());
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
            }
        }).start();
    }
    public void bulletAudio(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\revit\\IdeaProjects\\Window\\src\\picture\\gunShot.wav"));
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void bulletHit(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\revit\\IdeaProjects\\Window\\src\\picture\\bulletHit.wav"));
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
