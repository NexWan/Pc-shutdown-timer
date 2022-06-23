import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Receiver implements ActionListener {
    int time;
    JFrame frame;
    JLabel label;
    JTextField textField;
    JComboBox comboBox;
    JButton button;
    String[] list = {"Seconds","minutes","hours"};
    ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("catto.png"));
    public Receiver(){
        Frames();
    }

    public void Frames(){
        frame = new JFrame("PC shutdown program");
        frame.setSize(500,200);
        frame.setLayout(new BorderLayout(10,5));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(image.getImage());

        button = new JButton("Submit");
        button.addActionListener(this);

        textField = new JTextField("Text a number");
        textField.setPreferredSize(new Dimension(250,40)); // a default size of the field
        textField.setHorizontalAlignment(JTextField.CENTER); //This can center the text inside the box
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN,30));

        label = new JLabel();
        label.setPreferredSize(new Dimension(250,50));
        label.setLayout(new BorderLayout());
        label.setText("Introduce the time for the pc to shutdown!");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVisible(true);

        comboBox = new JComboBox(list);
        comboBox.setSize(100,40);

        frame.add(textField,BorderLayout.CENTER);
        frame.add(button,BorderLayout.WEST);
        frame.add(comboBox, BorderLayout.EAST);
        frame.add(label,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

        /*TODO
        * Add a file receiver so any user can select what video to play.
        * Add a checkbox component to select if the time goes in seconds, minutes, hours etc...
        * Fix problem when sometimes the video wont load
        * that's pretty much it.
        * */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button){
            try{
                time = Integer.parseInt(textField.getText());
                int selected = comboBox.getSelectedIndex();
                switch (selected){
                    case 0:
                        time = time;
                        break;
                    case 1:
                        time = (time*60);
                        break;
                    case 2:
                        time = (time*3600);
                        break;
                }
                System.out.println(time);
                new Shutdown(time);
                frame.dispose();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Please enter a valid number!");
            } catch (URISyntaxException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
