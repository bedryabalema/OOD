

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class SetThresholdDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField currThreshold;
	private JTextField newThreshold;
	private ThresholdListener listener = new ThresholdListener();
	private KitchenItem currItem; 

	/**
	 * Create the dialog.
	 */
	public SetThresholdDialog(KitchenItem fi) {
		currItem = fi;
		setTitle("Set Threshold");
		setBounds(100, 100, 349, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblCurrentThreshold = new JLabel("Current Threshold:");
			contentPanel.add(lblCurrentThreshold);
		}
		{
			currThreshold = new JTextField();
			currThreshold.setEditable(false);
			currThreshold.setText(""+currItem.getThreshold());
			contentPanel.add(currThreshold);
			currThreshold.setColumns(10);
		}
		{
			JLabel lblNewThreshold = new JLabel("New Threshold:");
			contentPanel.add(lblNewThreshold);
		}
		{
			newThreshold = new JTextField();
			contentPanel.add(newThreshold);
			newThreshold.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(listener);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(listener);
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void closeDialog(){
		this.dispose();
	}
	
	private class ThresholdListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand() == "Cancel"){
				closeDialog();
			}else{
				try{
					int newVal = Integer.parseInt(newThreshold.getText());
					if(newVal > -1) {currItem.setThreshold(newVal);}
					closeDialog();
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "The value must be an integer!");
				}
			}
		}
		
	}

}
