import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;

import javax.swing.filechooser.FileNameExtensionFilter;

public class NotepadApp extends JFrame  implements ActionListener{
    JMenuBar menubar=new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu edit=new JMenu("Edit");
    JMenu help=new JMenu("Help");

    JMenuItem newfile=new JMenuItem("New");
    JMenuItem openfile=new JMenuItem("Open");
    JMenuItem savefile=new JMenuItem("Save");
    JMenuItem printfile=new JMenuItem("Print");
    JMenuItem exitfile=new JMenuItem("Exit");

    JMenuItem cut=new JMenuItem("Cut");
    JMenuItem copy=new JMenuItem("Copy");
    JMenuItem paste=new JMenuItem("Paste");
    JMenuItem selectall=new JMenuItem("Select All");

    JMenuItem about=new JMenuItem("About");

    JTextArea textArea=new JTextArea();

    NotepadApp()
    {
        setTitle("Notepad");
        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon ic=new ImageIcon(getClass().getResource("1.png"));
        setIconImage(ic.getImage());

        setJMenuBar(menubar); 
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);

        file.add(newfile);
        file.add(openfile);
        file.add(savefile);
        file.add(printfile);
        file.add(exitfile);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        
        help.add(about);

        JScrollPane scrollpane=new JScrollPane(textArea);
        add(scrollpane);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        newfile.addActionListener(this);
        openfile.addActionListener(this);
        savefile.addActionListener(this);
        printfile.addActionListener(this);
        exitfile.addActionListener(this);

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);

        about.addActionListener(this);

        //Adding Short cuts 
        newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        savefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        printfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        exitfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equalsIgnoreCase("New")){
            textArea.setText(null);
        }
        else if(ae.getActionCommand().equalsIgnoreCase("Open")){
            JFileChooser fileChooser=new JFileChooser();
            FileNameExtensionFilter extensionFilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(extensionFilter);

            int action=fileChooser.showSaveDialog(null);
            if(action!=JFileChooser.APPROVE_OPTION){
                return;
            }
            else{
                String filename=fileChooser.getSelectedFile().getAbsolutePath().toString();
                if(!filename.contains(".txt")){
                    filename+=".txt";
                }
                try{
                BufferedReader br=new BufferedReader(new FileReader(fileChooser.getSelectedFile())); 
                textArea.read(br,null);
            }
                catch(Exception e){
                }
            }
        }
        else if(ae.getActionCommand().equalsIgnoreCase("Save")){
            JFileChooser fileChooser=new JFileChooser();
            FileNameExtensionFilter extensionFilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(extensionFilter);

            int action=fileChooser.showSaveDialog(null);
            if(action!=JFileChooser.APPROVE_OPTION){
                return;
            }
            else{
                String filename=fileChooser.getSelectedFile().getAbsolutePath().toString();
                if(!filename.contains(".txt")){
                    filename+=".txt";
                }
                try{
                BufferedWriter bf=new BufferedWriter(new FileWriter(filename)); 
                textArea.write(bf);
            }
                catch(Exception e){

                }
            } 
        }
        else if(ae.getActionCommand().equalsIgnoreCase("Print"))
        {
            try{
            textArea.print();}
            catch(Exception e){

            }
        }
        else if(ae.getActionCommand().equalsIgnoreCase("Exit")){
            System.exit(0);
        }
        else if(ae.getActionCommand().equalsIgnoreCase("Cut")){
            textArea.cut();
        }
        else if(ae.getActionCommand().equalsIgnoreCase("Copy")){
            textArea.copy();
        }
        else if(ae.getActionCommand().equalsIgnoreCase("Paste")){
            textArea.paste();
        }
        else if(ae.getActionCommand().equalsIgnoreCase("Select All")){
            textArea.selectAll();
        }
        else if(ae.getActionCommand().equalsIgnoreCase("About")){
            new about().setVisible(true);
        }
    }
    public static void main(String[] args)throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotepadApp().setVisible(true);
    }
} 
