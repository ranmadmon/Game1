import javax.swing.*;
import java.awt.*;

public class PanelScore extends JPanel {
    private final int  HEIGHT=40;
    private JLabel timer;
    private JLabel kills ;
    private int timeInt=30;
    private int killsCounter=0;
    private MainSence mainSence;
    private Window window;
    public PanelScore(Window window){
        this.window=window;
        this.setLayout(null);
        this.addTimerJlabel();
        this.addKillsJlabel();
        this.setBounds(0,0,Window.WIDTH,40);
        this.setBackground(Color.black);
        this.add(timer);
        this.add(kills);
    }
    private void addTimerJlabel(){
        this.timer=new JLabel("Time : "+Integer.toString(timeInt));
        this.timer.setFont(new Font("Serif",Font.PLAIN,30));
        this.timer.setBounds(0,0,Window.WIDTH/4,HEIGHT);
        this.timer.setForeground(Color.GREEN);
    }
    private void addKillsJlabel(){
        this.kills=new JLabel("Kills: "+Integer.toString(killsCounter));
        this.kills.setFont(new Font("Serif",Font.PLAIN,30));
        this.kills.setBounds(Window.WIDTH/2,0,Window.WIDTH/2,HEIGHT);
        this.kills.setForeground(Color.red);
    }
    public void timer(){
        new Thread(()->{
                while (this.timeInt>0) {
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    timeInt--;
                    this.timer.setText("Time : "+Integer.toString(timeInt));
                    this.repaint();
                    System.out.println(timeInt);
                    if (timeInt==0){
                        JOptionPane.showMessageDialog(null,"You got : "+this.killsCounter+" kills ");
                        this.window.getPanelScore().setVisible(false);
                        this.window.remove(this.window.getPanelScore());
                        this.window.getMainSence().setVisible(false);
                        this.window.remove(this.window.getMainSence());
                        this.window.add(this.window.getOpeningPage());
                        this.window.getOpeningPage().setVisible(true);
                    }
                }


        }).start();
    }

    public JLabel getKills() {
        return kills;
    }

    public int getKillsCounter() {
        return killsCounter;
    }

    public void setKillsCounter() {
        this.killsCounter ++;
    }

    public void killSolider(){
        this.killsCounter++;
    }
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }
}