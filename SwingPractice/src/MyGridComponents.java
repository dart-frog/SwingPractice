import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;


public class MyGridComponents implements ItemListener{
	public JPanel addLayout(){
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
		
		JCheckBox jCB1 =  new JCheckBox("Check Box #1");
		jCB1.addItemListener(this);
		GridLay.add(jCB1);
		
		JCheckBox jCB2 =  new JCheckBox("Check Box #2");
		GridLay.add(jCB2);
		
		JToggleButton jTB = new JToggleButton("Toggle Button");
		GridLay.add(jTB);
		
		JTextArea jTA = new JTextArea("Text area");
		GridLay.add(jTA);
		
		JButton jB = new JButton();
		GridLay.add(jB);
		return GridLay;
		
	}

	@Override
	public void itemStateChanged(ItemEvent evt) {
		
		
	}
	
}