import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;


public class PrintButtonActionListener implements ActionListener {
	private JCheckBox jCB1;
	private JCheckBox jCB2;
	private JToggleButton jTB;
	private JTextArea jTA;	
	private JRadioButton jRB1;
	private JRadioButton jRB2;
	private JRadioButton jRB3;
	
	public PrintButtonActionListener(JCheckBox jCB1, JCheckBox jCB2, JToggleButton jTB,JTextArea jTA, JRadioButton jRB1, JRadioButton jRB2, JRadioButton jRB3){
		this.jCB1 = jCB1;
		this.jCB2 = jCB2;
		this.jTB = jTB;
		this.jTA = jTA;
		this.jRB1=jRB1;
		this.jRB2=jRB2;
		this.jRB3=jRB3;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 System.out.println("Check Box 1: " + Boolean.toString(jCB1.isSelected()));
		 System.out.println("Check Box 2: " + Boolean.toString(jCB2.isSelected()));
		 System.out.println("Radio " + radio());
		 System.out.println("Toggle Button: " + Boolean.toString(jTB.isSelected()));
		 System.out.println("Text: " + jTA.getText());
	}
	public int radio(){
		int radio = 0;
		if (jRB1.isSelected()){
			radio = 1;
		}
		if (jRB2.isSelected()){
			radio =2;
		}
		if (jRB3.isSelected()){
			radio =3;
		}
		return radio;
	}

}
