import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Timer;

public class Shutdown {
    TimerTask timerTask;
    Timer timer = new Timer();
    DecimalFormat df = new DecimalFormat("#.##");

    public Shutdown(int time) throws URISyntaxException, IOException {
        try {
            Process process = Runtime.getRuntime().exec("shutdown -s -t " + String.valueOf(time));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int secTime = (time * 1000) - 300000;
        if(time > 300){
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    SwingUtilities.invokeLater(() -> {
                        try {
                            new Video();
                            JOptionPane.showMessageDialog(null, "5 minutes for the pc to shutdown");
                        } catch (URISyntaxException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }

            };
            timer.schedule(timerTask, secTime);
        }else if(time < 300 || time == 300){
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    SwingUtilities.invokeLater(() -> {
                        try {
                            new Video();
                            double timeD = time;
                            JOptionPane.showMessageDialog(null, df.format((timeD/60)) + " minutes for the pc to shutdown");
                        } catch (URISyntaxException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }

            };
            timer.schedule(timerTask, 1);
        }
    }
}
