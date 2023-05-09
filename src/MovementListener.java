import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener {

    private MainSence mainSence;
    private PanelScore panelScore;
    private Window window;
    private boolean canShoot=true;
    private Timer timer;

    public MovementListener(MainSence mainSence,Window window){
        this.window=window;
        this.mainSence = mainSence;
        this.panelScore=new PanelScore(this.window);
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canShoot = true;
            }
        });
        timer.setRepeats(false);

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
            if (this.mainSence.getSolider().getY()>-15){
                this.mainSence.getSolider().moveUpSolider();
                this.mainSence.repaint();
                System.out.println("up");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            if (this.mainSence.getSolider().getY()<Window.HEIGHT-this.mainSence.getSolider().getHeight()*1.5){
                this.mainSence.getSolider().moveDownSolider();
                this.mainSence.repaint();
                System.out.println("down");
            }
        }

        if ((e.getKeyCode()==KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER)&&canShoot){
                    ImageIcon bulletImage=new ImageIcon("src/picture/img_1.png");
                    Bullet bullet1=new Bullet(this.mainSence.getSolider().getX()+29+this.mainSence.getSolider().getWidth()/2,this.mainSence.getSolider().getY()+71,20,20,bulletImage,this.mainSence);
                    this.mainSence.add(bullet1);
                    this.mainSence.repaint();
                    System.out.println("done");
                    canShoot=false;
                    this.timer.start();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
