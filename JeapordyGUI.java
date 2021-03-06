import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;




public class JeapordyGUI extends JPanel implements ActionListener{
  
  
  JButton startbutton, instructionbutton;  // startbutton and instructionbutton
  
  public static QuestionWindowPanel  p; // the panel for question window
  JFrame frame = new JFrame("Who Wants To Be A Millionaire"); // creates a frame with the name of IMPROVISED - JEAPORDY
  JPanel startmenues = new JPanel(); // creates a panel for the start menu
  ProgressBar moneyamount = new ProgressBar(); // creates an object from the progress bar class
  JPanel progress = new JPanel(); // creates new JPanel for the progress bar
  LifelnGui lifeline = new LifelnGui(); // creates an object from the lifeline gui
  JPanel east = new JPanel (); // creates new JPanel for the progress panel and the lifelin panel
  
  
  public  JPanel startmenupanel(){ // start menu
    
    
    
    
    startbutton = new JButton ("Start"); // creates start button 
    startbutton.addActionListener (this); // adds action listener
    startbutton.setPreferredSize(new Dimension(0,40)); // gives the buttons its size
    
    
    
    instructionbutton = new JButton ("Instructions"); // creates instructions button 
    instructionbutton.addActionListener(this); // adds action listener
    instructionbutton.setPreferredSize(new Dimension(0,40)); // gives the buttons its size
    
    //startmenu panel
    JPanel startmenu = new JPanel(); //creates panel to put buttons on to
    startmenu.setBackground(Color.blue); // gives the startmenu panel a background of blue
    
    
    GridLayout startmenulayout = new GridLayout(1,2,30,0); // creates a new GridLayout
    
    startmenu.setLayout(startmenulayout); // sets the startmenu panel layout to startmenulayout which is a gridlayout
    
    startmenu.add(startbutton); // adds start button and the position of the button on the panel
    
    startmenu.add(instructionbutton) ; // adds instruction button and the position of the button on the panel
    
    return startmenu; // returns startmenu
  }
  
  
  public JPanel backgrounds(){// background Jpanel
    
    JPanel backgrounds = new JPanel(); //creates panel to put background stuff on to
    backgrounds.setBackground(Color.blue); // makes the panel background blue
    StartMenuGraphics drawing = new StartMenuGraphics();
    backgrounds.add(drawing); // adds this drawing to the panel
    
    return backgrounds; //returns this panel 
  }
  
  public void actionPerformed (ActionEvent e){ // creates action listeners
    
    //instruction button action listener
    if (e.getSource() == instructionbutton) 
    {
      JOptionPane.showMessageDialog(null, "Instructions:\nWarning: In order to play this game, you need a good understanding of GUI." +
                                    "\n\nTo advance towards the next levels, you need to answer questions correctly, after each " +
                                    "correctly answered question,\n you will need to decide to keep your score and leave or to keep " +
                                    "going to next rounds.\n\nYou win when you reach one million dollars.\n\nThere are lifelines to help you in case" +
                                    " you become stuck (Use them wisely).","Instructions", JOptionPane.INFORMATION_MESSAGE); // displays the instructions message (a popup)
    }
    
    // startmenu button action listener
    else if (e.getSource() == startbutton) 
    {
      startmenues.setVisible(false); // makes the startmenu gui disappear
      p.setVisible(true); // makes the question panel gui appear
      east.setVisible(true); // makes the east side of the question panel appear
      lifeline.setVisible(true);
    }
    
    
  }
  
  
  private void createAndShowGUI(){
    //creates and sets up the window
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the program when closed
    
    frame.setLayout(new BorderLayout()); // creates a new border layout for the frame
    
    frame.setSize(800,450); // sets frame to this size 
    
    east.setLayout(new BorderLayout()); // creates a new border layout for the frame east
    
    // Panel created for start menu
    
    startmenues.setLayout(new BorderLayout()); // creates a new border layout for the new Jpanel.
    
    JPanel backgroundss = backgrounds(); // creates new backgrounds panel
    startmenues.add(backgroundss);
    JPanel startmenus = startmenupanel(); // creates new startmenu panel
    startmenues.add(startmenus, BorderLayout.SOUTH); // ads the start menu panel to this panel
    
    
//adding question GUI to this frame.     
    QuestionDeck qd = new QuestionDeck ();// creates new question deck
    
    qd.fill(); // fills the qd questiondeck
    p = new QuestionWindowPanel(qd,moneyamount); // creates new questions window panel with question deck  
    p.setSize(50, 50); // sets panel size
    
    frame.add(p, BorderLayout.NORTH); // adds the p to the frame and put it in the center. 
    p.setVisible(false);
    
    progress.add(moneyamount); // adds the progressbar to the panel
    progress.setSize(50,100); // sets the panel size
    
    east.setSize(200,200); // sets size of east panel 
    east.add(progress, BorderLayout.NORTH); // adds the progressbar panel to the east panel
    
    frame.add(lifeline,BorderLayout.WEST);
    lifeline.setSize(100,100);
    
    frame.add(east, BorderLayout.EAST);// adds the panel to the frame on the west side
    east.setVisible(false);
    lifeline.setVisible(false);
    frame.add (startmenues); // adds the startmenu and the back ground for the program
    
    
    //displays Frame/Window 
    frame.setVisible (true);
  }
  
  public static void main (String[] args){
    
    JeapordyGUI jg = new JeapordyGUI();
    jg.createAndShowGUI();
  }
  
  
}



