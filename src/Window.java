import javax.swing.*;

public class Window extends JFrame {
    public static final int WIDTH=800;
    public static final int HEIGHT=650;

    public Window(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
       // OpeningPage openingPage=new OpeningPage(0,50,WIDTH,HEIGHT);
       // this.add(openingPage);
        MainSence mainSence=new MainSence(0,30,WIDTH,HEIGHT-30);
        this.add(mainSence);

        this.setVisible(true);

    }
}
