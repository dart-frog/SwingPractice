
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	private static final String CARD1 = "Grid Layout";
	private static final String CARD2 = "Mig Layout";
	private static final String CARD3 = "GridBag Layout";
	//components 
	JPanel contentPane;
	JPanel cards;
	JCheckBox jCB1;
	JCheckBox jCB2;
	JToggleButton jTB;
	JTextArea jTA;
	JRadioButton jRB1;
	JRadioButton jRB2;
	JRadioButton jRB3;
 //info
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
		contentPane.add(new JLabel("Choose a Card"));
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
		FlowLay.add(addGridbagLayout());
		
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
		
		jRB1 = new JRadioButton("Radio Button #1");
		jRB1.addActionListener(this);
		bGroup.add(jRB1);
		GridLay.add(jRB1);
		
		jRB2 = new JRadioButton("Radio Button #2");
		jRB2.addActionListener(this);
		bGroup.add(jRB2);
		GridLay.add(jRB2);
		
		jRB3 = new JRadioButton("Radio Button #3");
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
		jTA.setColumns(30);
		jTA.setRows(5);
		GridLay.add(jTA);
		
		PrintButtonActionListener v = new PrintButtonActionListener(jCB1,jCB2, jTB, jTA, jRB1,jRB2,jRB3);
		JButton jB = new JButton("print");
		jB.addActionListener(v);
		GridLay.add(jB);
		return GridLay;
		
	}
	public JPanel addMigLayout(){
		JPanel migLay = new JPanel();
		MigLayout migOut = new MigLayout("wrap 5");
		migLay.setLayout(migOut);
		
		ButtonGroup bGroup = new ButtonGroup();
		jRB1 = new JRadioButton("Radio Button #1");
		//jRB1.addActionListener(this);
		bGroup.add(jRB1);
		migLay.add(jRB1);
		
		jCB1 =  new JCheckBox("Check Box #1");
	
		migLay.add(jCB1,"wrap");
		
		jRB2 = new JRadioButton("Radio Button #2");
		//jRB2.addActionListener(this);
		bGroup.add(jRB2);
		migLay.add(jRB2);
		
		jCB2 =  new JCheckBox("Check Box #2");
		migLay.add(jCB2,"wrap");
		
		jRB3 = new JRadioButton("Radio Button #3");
		//jRB3.addActionListener(this);
		bGroup.add(jRB3);	
		migLay.add(jRB3);
		
		jTB = new JToggleButton("Toggle Button");
		jTB.addActionListener(this);
		migLay.add(jTB, "wrap");
		
		jTA = new JTextArea("Text area");
		jTA.setColumns(30);
		jTA.setRows(5);
		migLay.add(jTA,"wrap");
		
		PrintButtonActionListener v = new PrintButtonActionListener(jCB1,jCB2, jTB, jTA,jRB1,jRB2,jRB3);
		JButton jB = new JButton("print");
		jB.addActionListener(v);
		migLay.add(jB,"wrap");
		return migLay;
		
	}
	public JPanel addGridbagLayout(){
		JPanel GridBagLay = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		
		ButtonGroup bGroup = new ButtonGroup();
		jRB1 = new JRadioButton("Radio Button #1");
		//jRB1.addActionListener(this);
		bGroup.add(jRB1);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		GridBagLay.add(jRB1,c);
		
		jCB1 =  new JCheckBox("Check Box #1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		GridBagLay.add(jCB1,c);
		
		jRB2 = new JRadioButton("Radio Button #2");
		bGroup.add(jRB2);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		GridBagLay.add(jRB2,c);
		
		jCB2 =  new JCheckBox("Check Box #2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		GridBagLay.add(jCB2,c);
		
		jRB3 = new JRadioButton("Radio Button #3");
		bGroup.add(jRB3);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		GridBagLay.add(jRB3,c);
		
		jTB = new JToggleButton("Toggle Button");
		jTB.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		GridBagLay.add(jTB, c);
		
		jTA = new JTextArea("Text area");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;     
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		GridBagLay.add(jTA,c);
		
		PrintButtonActionListener v = new PrintButtonActionListener(jCB1,jCB2, jTB, jTA,jRB1,jRB2,jRB3);
		JButton jB = new JButton("print");
		jB.addActionListener(v);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		GridBagLay.add(jB,c);
		return GridBagLay;
		
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
	
	
}
