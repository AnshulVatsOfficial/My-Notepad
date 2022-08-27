/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mynotepad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author avans
 */
public class MyNotepad extends JFrame implements ActionListener{

    JMenuBar menubar = new JMenuBar();//A menubar that have options to perform some basic functions
    
    JMenu file = new JMenu("File");//an option to perform functions related to files like make new file, save a file and open existing file
    JMenu edit = new JMenu("Edit");//to edit something
    JMenu help = new JMenu("Help");// to get help related to anything
    
    JMenuItem newFile = new JMenuItem("New File");
    JMenuItem openFile = new JMenuItem("Open File");
    JMenuItem saveFile = new JMenuItem("Save File");
//    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");
    
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectAll = new JMenuItem("Select All Text");
    
    JMenuItem about = new JMenuItem("About");
    
    JTextArea textarea = new JTextArea();
    
    
    public MyNotepad(){
        setTitle("My Notepad");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon myicon = new ImageIcon(getClass().getResource("notepad-icon.png"));
        setIconImage(myicon.getImage());
        
        setJMenuBar(menubar);//adding a Menubar to the JFrame
    
        //adding all the below MAIN options (headings) to the Menubar
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
        
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(exit);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        
        help.add(about);
        
        textarea.setFont(new Font("Arial", Font.PLAIN, 15));//setting up the font type
        textarea.setLineWrap(true);
        JScrollPane scrollpane = new JScrollPane(textarea);//a field where we can scroll
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//so that we do not get scroll bar in horiozontal direction
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollpane);//adding this scroll pane to JFrame
        
        //now adding actionlistener to each menu items so that they can perform their required functions
        
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        about.addActionListener(this);
        
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
    }
    
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new MyNotepad().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("New File")){
            textarea.setText(null);
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Open File")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            int action = fileChooser.showOpenDialog(null);
            
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }
            
            else{
                try{
                BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                textarea.read(reader, null);
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Save File")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            int action = fileChooser.showSaveDialog(null);
            
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }
            
            else{
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if(!fileName.contains(".txt")){
                    fileName += ".txt";
                }
                
                try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                textarea.write(writer);
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Exit")){
            System.exit(0);
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Cut")){
            textarea.cut();
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Copy")){
            textarea.copy();
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Paste")){
            textarea.paste();
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Select All Text")){
            textarea.selectAll();
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("about")){
            new About().setVisible(true);
        }
    }
}
