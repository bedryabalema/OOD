

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LowItemsView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String itemText = "";
	/**
	 * Create the dialog.
	 */
	public LowItemsView(String[] lowItems) {
		setBounds(100, 100, 250, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JTextArea textArea = new JTextArea();
			textArea.setColumns(20);
			textArea.setRows(25);
			textArea.setEditable(false);
			textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			contentPanel.add(textArea);
			for(String s : lowItems){
				itemText = itemText + s + "\n";
			}
			textArea.setText(itemText);
			System.out.println(lowItems.toString());
			//lowItems.toString()
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent ae){
						closeDialog();
					}
				});
			}
		}
	}
	
	private void closeDialog(){
		this.dispose();
	}

}
