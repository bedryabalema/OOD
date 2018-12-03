
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



@SuppressWarnings("serial")
public class AddItemDialog extends JDialog {
	private JPanel contentPane;
	private JTextField itemName;
	private JFormattedTextField expirationDate;
	private JSpinner itemAmount;
	private String name = "";
	private Date date = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	JButton btnReset, btnCancel, btnSubmit;
	
	public void setTextFields(String name, Date date, double amount){
		itemName.setText(name);
		expirationDate.setValue(date);
		itemAmount.setValue(amount);
	}
	
	public String getItemName(){
		return itemName.getText();
	}
	
	public Date getExpDate(){
		return (Date)expirationDate.getValue();
	}
	
	public int getAmount(){
		return (int)itemAmount.getValue();
	}
	
	public void addController(AddItemController controller){
		btnCancel.addActionListener(controller);
		btnReset.addActionListener(controller);
		btnSubmit.addActionListener(controller);
	}
	
	public AddItemDialog(final JFrame parent) {
		super(parent, true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
		setTitle("Add/Update Item");
		setContentPane(contentPane);
		
		
		JLabel lblItemName = new JLabel("Item Name:");
		
		itemName = new JTextField();
		itemName.setColumns(10);
		itemName.setText(name);
		
		JLabel lblItemAmount = new JLabel("Item Amount:");
		
		expirationDate = new JFormattedTextField(sdf);
		expirationDate.setColumns(10);
		expirationDate.setValue(date);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date:");
		
		itemAmount = new JSpinner();
		itemAmount.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		
		btnSubmit = new JButton("Submit");
		
		btnCancel = new JButton("Cancel");
		
		JLabel lblThresholdWarning = new JLabel("Threshold values must be set by an Admin.");
		lblThresholdWarning.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnReset = new JButton("Reset");
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(20, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblItemAmount)
								.addComponent(lblItemName)
								.addComponent(lblExpirationDate))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(15)
					.addComponent(btnReset)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(itemAmount, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(itemName, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(expirationDate, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSubmit)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThresholdWarning, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblItemName))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(itemAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblItemAmount))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExpirationDate)
						.addComponent(expirationDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(lblThresholdWarning)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnSubmit)
						.addComponent(btnReset))
					.addContainerGap())
		);
		contentPane.setLayout(groupLayout);
		
		pack();
		setLocationRelativeTo(null);
	}
}
