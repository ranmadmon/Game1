import javax.swing.*;
import java.awt.*;
import java.util.PropertyResourceBundle;

public class OpeningPage extends JPanel {
    int startButtonX=120;
    private final int WIDTHBUTTON=150;
    private final int HEIGHTBUTTON=100;
    private Window window;
    JButton[] jButtons=new JButton[3];
    public OpeningPage(int x,int y,int width,int height ,Window window){
        this.window=window;
        this.setLayout(null);
        this.setBounds(x,y,width,height);
        this.setBackground(Color.black);
        addButtons();


    }
    private void addButtons(){
        this.jButtons[0]=new JButton("Instructions");
        this.jButtons[1]=new JButton("Start Game");
        this.jButtons[2]=new JButton("Exit Game");
        for (int i=0;i<3;i++){
            jButtons[i].setBounds(startButtonX,Window.HEIGHT/3,WIDTHBUTTON,HEIGHTBUTTON);
            startButtonX+=200;
            this.add(jButtons[i]);
        }
        
    }

}
