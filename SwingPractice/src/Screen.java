
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;


public class Screen implements ItemListener,ActionListener {
	//frame
	private static JFrame frame;
	//cards
	private static final String CARD1 = "Layout 1";
	private static final String CARD2 = "Layout 2";
	private static final String CARD3 = "Layout 3";
	//components 
	JPanel contentPane;
	JPanel cards;
	JCheckBox jCB1;
	JCheckBox jCB2;
	JToggleButton jTB;
	JTextArea jTA;
 //info
	int radio;
	public static void main(String[] args) {
		Screen scr = new Screen();
		scr.setUp();
	}
	public void setUp(){
		frame = new JFrame("Swing practice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createCardComponents();
		frame.pack();
		frame.setVisible(true);
	}
	public void createCardComponents(){
		
		String[] items = {CARD1,CARD2,CARD3};
		JComboBox combo = new JComboBox(items);
		combo.setEditable(false);        
		combo.addItemListener(this);
		contentPane = new JPanel();
		contentPane.setLayout(new MigLayout("wrap 2"));
		contentPane.add(combo,"wrap");
		frame.setContentPane(contentPane);
		
		//create cards
		JPanel GridLay = new JPanel();
		JLabel x = new JLabel("GridLay");
		GridLay.add(addGridLayout());
		
		JPanel GroupLay = new JPanel();
		JLabel y = new JLabel("MigLay");
		GroupLay.add(addMigLayout());
		
		JPanel FlowLay = new JPanel();
		JLabel z = new JLabel("FlowLay");
		FlowLay.add(z);
		
		//Create the panel that contains the "cards".      
		cards = new JPanel(new CardLayout()); 
		cards.add(GridLay,CARD1 );
		cards.add(GroupLay, CARD2);
		cards.add(FlowLay, CARD3);
		
		contentPane.add(cards);
	}
	public void itemStateChanged(ItemEvent evt) {        

			CardLayout myCards = (CardLayout)(cards.getLayout());      	
			myCards.show(cards, (String)evt.getItem());
	}     
	public JPanel addGridLayout(){
		JPanel GridLay = new JPanel();
		GridLay.setLayout(new GridLayout(0, 2));
		
		ButtonGroup bGroup = new ButtonGroup();
		
		JRadioButton jRB1 = new JRadioButton("Radio Button #1");
		jRB1.addActionListener(this);
		bGroup.add(jRB1);
		GridLay.add(jRB1);
		
		JRadioButton jRB2 = new JRadioButton("Radio Button #2");
		jRB2.addActionListener(this);
		bGroup.add(jRB2);
		GridLay.add(jRB2);
		
		JRadioButton jRB3 = new JRadioButton("Radio Button #3");
		jRB3.addActionListener(this);
		bGroup.add(jRB3);	
		GridLay.add(jRB3);
		
		jCB1 =  new JCheckBox("Check Box #1");
		GridLay.add(jCB1);
		
		jCB2 =  new JCheckBox("Check Box #2");
		GridLay.add(jCB2);
		
		jTB = new JToggleButton("Toggle Button");
		jTB.addActionListener(this);
		GridLay.add(jTB);
		
		jTA = new JTextArea("Text area");
		jTA.setEditable(true);
		GridLay.add(jTA);
		
		JButton jB = new JButton("print");
		jB.addActionListener(this);
		GridLay.add(jB);
		return GridLay;
		
	}
	public JPanel addMigLayout(){
		JPanel migLay = new JPanel();
		MigLayout migOut = new MigLayout("wrap 5");
		migLay.setLayout(migOut);
		
		ButtonGroup bGroup = new ButtonGroup();
		
		JRadioButton jRB1 = new JRadioButton("Radio Button #1");
		jRB1.addActionListener(this);
		bGroup.add(jRB1);
		migLay.add(jRB1);
		
		jCB1 =  new JCheckBox("Check Box #1");
	
		migLay.add(jCB1,"wrap");
		
		JRadioButton jRB2 = new JRadioButton("Radio Button #2");
		jRB2.addActionListener(this);
		bGroup.add(jRB2);
		migLay.add(jRB2);
		
		jCB2 =  new JCheckBox("Check Box #2");
		migLay.add(jCB2,"wrap");
		
		JRadioButton jRB3 = new JRadioButton("Radio Button #3");
		jRB3.addActionListener(this);
		bGroup.add(jRB3);	
		migLay.add(jRB3);
		
		
		
		
		
		jTB = new JToggleButton("Toggle Button");
		jTB.addActionListener(this);
		migLay.add(jTB, "wrap");
		
		jTA = new JTextArea("Text area");
		migLay.add(jTA,"wrap");
		
		JButton jB = new JButton("print");
		jB.addActionListener(this);
		migLay.add(jB,"wrap");
		return migLay;
		
	}
	 public static void printData(JCheckBox jCB1, JCheckBox jCB2, JToggleButton jTB, int radio, JTextArea jTA){
		 System.out.println("Check Box 1: " + Boolean.toString(jCB1.isSelected()));
		 System.out.println("Check Box 2: " + Boolean.toString(jCB2.isSelected()));
		 System.out.println("Radio " + radio);
		 System.out.println("Toggle Button: " + Boolean.toString(jTB.isSelected()));
		 System.out.println("Text: " + jTA.getText());
	 }
	@Override
	public void actionPerformed(ActionEvent evt) {
		if ("print".equals(evt.getActionCommand())){
			printData();
		}
		else if ("Toggle Button".equalsIgnoreCase(evt.getActionCommand())){
			
		}
				
		else{String a = evt.getActionCommand();
			char b = a.charAt(a.length() -1);
			String c = Character.toString(b);
			radio = Integer.parseInt(c);
		}
	}
	
	
}
