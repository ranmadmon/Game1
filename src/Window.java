import javax.swing.*;

public class Window extends JFrame {
    public static final int WIDTH=800;
    public static final int HEIGHT=650;
    private OpeningPage openingPage;
    private MainSence mainSence;
    private PanelScore panelScore;
    private Instructions instructions;

    public Window(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Shooting Game");
        this.openingPage=new OpeningPage(0,0,WIDTH,HEIGHT,this);
        this.add(openingPage);
        this.panelScore=new PanelScore(this);
        this.mainSence=new MainSence(0,40,WIDTH,HEIGHT-40,panelScore);
        this.instructions=new Instructions(this);
        this.setVisible(true);

    }

    public Instructions getInstructions() {
        return instructions;
    }

    public void setInstructions(Instructions instructions) {
        this.instructions = instructions;
    }

    public OpeningPage getOpeningPage() {
        return openingPage;
    }

    public void setOpeningPage(OpeningPage openingPage) {
        this.openingPage = openingPage;
    }

    public MainSence getMainSence() {
        return mainSence;
    }

    public void setMainSence(MainSence mainSence) {
        this.mainSence = mainSence;
    }

    public PanelScore getPanelScore() {
        return panelScore;
    }

    public void setPanelScore(PanelScore panelScore) {
        this.panelScore = panelScore;
    }
}
