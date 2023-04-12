import java.awt.Font;

import javax.swing.*;
public class about  extends JFrame{
    about()
    {
        setTitle("About Notepad");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        ImageIcon ic=new ImageIcon(getClass().getResource("1.png"));
        setIconImage(ic.getImage()); 
        setLayout(null);

        JLabel iconLabel=new JLabel(new ImageIcon(getClass().getResource("1.png")));
        iconLabel.setBounds(100,50,80,80);
        add(iconLabel);

        JLabel textLabel=new JLabel("<html>Welcome to notepad <br> Notepad is a simple text editor  for microsoft windows and a basic text editing program which enables computer users to create documents <br>All rights reserved @Naresh Daravath </html>");
        textLabel.setBounds(100,50,350,300);
        textLabel.setFont(new Font(Font.SANS_SERIF ,Font.PLAIN,12));
        add(textLabel);
    }
}
 