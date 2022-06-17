import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Video{
    Random ran = new Random();
    String videoFile = "";
    private int selector = ran.nextInt(1,3);
    JFrame frame;
    JPanel panel;
    int width, height;
    public final JFXPanel jfxPanel = new JFXPanel();

    public Video() throws URISyntaxException, IOException {
        frame = new JFrame();
        switch (selector){
            case 1:
                videoFile = "ratchet.mp4";
                width = 229;
                height = 230;
                break;
            case 2:
                videoFile = "dog.mp4";
                width = 430;
                height = 430;
                break;
            case 3:

                break;

        }

        createScene();
        frame.setTitle("Video");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setSize(width,height);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jfxPanel, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void createScene() throws URISyntaxException {
        URL file = getClass().getClassLoader().getResource(videoFile);
        System.out.println(file);
        MediaPlayer oracleVid = new MediaPlayer(new Media(file.toURI().toString()));
        System.out.println(oracleVid);
        jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));
        oracleVid.setVolume(0.5);
        oracleVid.setCycleCount(MediaPlayer.INDEFINITE);
        oracleVid.play();
    }
}
