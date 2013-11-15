
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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


public class Screen implements ItemListener  {
	private static JFrame frame;
	private static final String CARD1 = "Layout 1";
	private static final String CARD2 = "Layout 2";
	private static final String CARD3 = "Layout 3";
	JPanel contentPane;
	JPanel cards;
	JCheckBox jCB1;
	JCheckBox jCB2;
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
		contentPane.add(combo);
		frame.setContentPane(contentPane);
		
		//create cards
		JPanel GridLay = new JPanel();
		JLabel x = new JLabel("GridLay");
		GridLay.add(addGridLayout());
		
		JPanel GroupLay = new JPanel();
		JLabel y = new JLabel("GroupLay");
		GroupLay.add(y);
		
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
		GridLay.setLayout(new GridLayout(0, 1));
		
		ButtonGroup bGroup = new ButtonGroup();
		
		JRadioButton jRB1 = new JRadioButton("Radio Button #1");
		bGroup.add(jRB1);
		GridLay.add(jRB1);
		
		JRadioButton jRB2 = new JRadioButton("Radio Button #2");
		bGroup.add(jRB2);
		GridLay.add(jRB2);
		
		JRadioButton jRB3 = new JRadioButton("Radio Button #3");
		bGroup.add(jRB3);
		GridLay.add(jRB3);
		
		jCB1 =  new JCheckBox("Check Box #1");
		jCB1.addItemListener(this);
		GridLay.add(jCB1);
		
		jCB2 =  new JCheckBox("Check Box #2");
		jCB2.addItemListener(this);
		GridLay.add(jCB2);
		
		JToggleButton jTB = new JToggleButton("Toggle Button");
		GridLay.add(jTB);
		
		JTextArea jTA = new JTextArea("Text area");
		GridLay.add(jTA);
		
		JButton jB = new JButton();
		GridLay.add(jB);
		return GridLay;
		
	}
	
	
	
}
