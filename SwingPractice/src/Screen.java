
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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Screen {
	private static JFrame frame;
	private static final String card1 = "Layout 1";
	private static final String card2 = "Layout 2";
	private static final String card3 = "Layout 3";
	JPanel contentPane;
	public static void main(String[] args) {
		setUp();
	}
	public void setUp(){
		frame = new JFrame("Swing practice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createCardComponents();
		frame.pack();
		frame.setVisible(true);
	}
	public void createCardComponents(){
		JPanel comboPanel  = new JPanel();
		String[] items = {card1,card2,card3};
		JComboBox combo = new JComboBox(items);
		contentPane = new JPanel();
		contentPane.add(combo);
	}
	
}
