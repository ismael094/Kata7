package watch2;

import presenter.WatchPresenter;
import view.WatchDisplay;
import model.Watch;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends JFrame {

    public static void main(String[] args) throws IOException {
        new Main().launch();        
    }

    public Main() throws IOException {
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay(background());
        WatchPresenter watchPresenter = new WatchPresenter(watch, watchDisplay);
        this.init();
        this.add(watchDisplay);
    }
    
    private void launch() {
        this.setVisible(true);
    }

    private Image background() throws IOException {
        return ImageIO.read(new File("background.jpg"));
    }

    private void init() {
        this.setSize(400,400);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
