

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;



@SuppressWarnings("serial")
public class AdminOptionDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField userPasscode;
	private JTextField adminPasscode;
	private JLabel lblNewPasscode;
	private JLabel lblNewAdminPasscode;
	private Kitchen theKitchen;

	/**
	 * Create the dialog.
	 */
	public AdminOptionDialog(Kitchen f) {
		theKitchen = f;
		setTitle("Admin Options");
		setBounds(100, 100, 320, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewPasscode = new JLabel("New Passcode:");
		}
		{
			userPasscode = new JTextField();
			userPasscode.setColumns(10);
		}
		{
			lblNewAdminPasscode = new JLabel("New Admin Passcode: ");
		}
		{
			adminPasscode = new JTextField();
			adminPasscode.setColumns(10);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewPasscode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewAdminPasscode))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(userPasscode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminPasscode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPasscode)
						.addComponent(userPasscode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewAdminPasscode)
						.addComponent(adminPasscode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(100))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!userPasscode.getText().equals("")){
							if(userPasscode.getText().matches("^([0-9]{0,5})")) theKitchen.setUserPasscode(Integer.parseInt(userPasscode.getText()));
						}
						if(!adminPasscode.getText().equals("")){	
							if(adminPasscode.getText().matches("^([0-9]{0,5})")) theKitchen.setAdminPasscode(Integer.parseInt(adminPasscode.getText()));
						}
						closeDialog();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						closeDialog();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

	private void closeDialog(){
		this.dispose();
	}
}
