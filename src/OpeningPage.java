import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        addButtons();
        addBckground();



    }
    private void addButtons(){
        this.jButtons[0]=new JButton("Instructions");
        this.jButtons[1]=new JButton("Start Game");
        this.jButtons[2]=new JButton("Exit Game");
        for (int i=0;i<3;i++){
            jButtons[i].setBounds(startButtonX,Window.HEIGHT/3,WIDTHBUTTON,HEIGHTBUTTON);
            jButtons[i].setFocusPainted(false);

            startButtonX+=200;
            this.add(jButtons[i]);
        }
        jButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAudio();
                window.getOpeningPage().setVisible(false);
                window.remove(window.getOpeningPage());
                PanelScore panelScore=new PanelScore(window);
                window.setPanelScore(panelScore);
                window.add(window.getPanelScore());
                window.getPanelScore().timer();
                //window.getPanelScore().paintKills();
                MainSence mainSence=new MainSence(0,40,Window.WIDTH,Window.HEIGHT-40,panelScore);
                window.setMainSence(mainSence);
                window.add(window.getMainSence());
                window.getMainSence().setVisible(true);
                window.getMainSence().requestFocus();
                window.getPanelScore().setVisible(true);
            }
        });
        jButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAudio();
                window.dispose();
            }
        });
        jButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAudio();
                window.getOpeningPage().setVisible(false);
                window.remove(window.getOpeningPage());
                window.add(window.getInstructions());
                window.getInstructions().setVisible(true);
            }
        });


    }
    private void addBckground(){
        ImageIcon background=new ImageIcon("src/picture/img_6.png");
        JLabel jLabel=new JLabel(background);
        jLabel.setBounds(0,0,Window.WIDTH,Window.HEIGHT);
        this.add(jLabel);
    }
    public void buttonAudio(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\revit\\IdeaProjects\\Window\\src\\picture\\button-20.wav"));
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
