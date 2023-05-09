import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JPanel {
    private Window window;
    public Instructions(Window window){
        this.window=window;
        this.setLayout(null);
        this.setBounds(0,0,Window.WIDTH,Window.HEIGHT);
        this.addButton();
        this.addImageBackground();




    }
    private void addButton(){
        JButton jButton=new JButton("Back To Home");
        jButton.setFont(new Font("Serif",Font.BOLD,70));
        jButton.setForeground(Color.black);
        jButton.setBounds(Window.WIDTH/7+23,Window.HEIGHT/3*2+74,Window.WIDTH-270,Window.HEIGHT/7-3);
        jButton.setBorderPainted(false);
        jButton.setContentAreaFilled(false);
        jButton.setFocusPainted(false);
        this.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getOpeningPage().buttonAudio();
                window.getInstructions().setVisible(false);
                window.remove(window.getInstructions());
                window.getOpeningPage().setVisible(true);
                window.add( window.getOpeningPage());
            }
        });
    }
    private void addImageBackground(){
        ImageIcon imageIcon=new ImageIcon("src/picture/img_5.png");
        JLabel background=new JLabel(imageIcon);
        background.setBounds(0,0,Window.WIDTH,Window.HEIGHT);
        this.add(background);
    }
}
