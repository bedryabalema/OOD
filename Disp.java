

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class Disp implements Observer{
	private JFrame frmfancyKitchen;
	JLabel lblExpDate;
	JLabel lblCurrThreshold;
	JLabel lblCurrAmt;
	JLabel lblCurrName;
	JButton btnChangeThreshold, btnDisplayShoppingList, btnAddNewItem, btnDecrement, btnIncrement;
	JList<String> itemList;
	Kitchen myKitchen;
	private JTextField txtLowItemWarning;
	
	public JFrame getFrame(){
		return frmfancyKitchen;
	}
	
	public void addKitchen(Kitchen f){
		myKitchen = f;
	}
	
	public void setLowItemWarning(){
		txtLowItemWarning.setBackground(Color.RED);
		txtLowItemWarning.setText("Warning! Low Items!");
	}
	
	public void clearLowItemWarning(){
		txtLowItemWarning.setBackground(Color.LIGHT_GRAY);
		txtLowItemWarning.setText("No Low Items");
	}
	
	public String getSelectedItem(){
		return itemList.getSelectedValue();
	}

	/**
	 * Create the application.
	 */
	public Disp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmfancyKitchen = new JFrame();
		frmfancyKitchen.setTitle("FancyKitchen");
		frmfancyKitchen.setBounds(100, 100, 350, 470);
		frmfancyKitchen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmfancyKitchen.setMinimumSize(new Dimension(300, 450));
		
		itemList = new JList<String>();
		itemList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblItemList = new JLabel("Items in Kitchen");
		lblItemList.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemList.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JPanel panelSelectedItem = new JPanel();
		panelSelectedItem.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Selected Item", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		btnChangeThreshold = new JButton("Change Threshold");
		
		btnDisplayShoppingList = new JButton("Display Shopping List");
		
		btnAddNewItem = new JButton("Add New Item");
		
		txtLowItemWarning = new JTextField();
		txtLowItemWarning.setBackground(new Color(192, 192, 192));
		txtLowItemWarning.setHorizontalAlignment(SwingConstants.CENTER);
		txtLowItemWarning.setEditable(false);
		txtLowItemWarning.setText("No Low Items");
		txtLowItemWarning.setColumns(10);
		
		btnIncrement = new JButton("Add");
				
		btnDecrement = new JButton("Remove");
		
		JPanel panel = new JPanel();
		final JLabel lblCurrentTime = new JLabel("Current Time:");
		panel.add(lblCurrentTime);
		Timer timer = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				Date now = new Date();
				String time = DateFormat.getDateTimeInstance().format(now);
				lblCurrentTime.setText(time);
			}
		});
		timer.start();
		
		GroupLayout groupLayout = new GroupLayout(frmfancyKitchen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(itemList, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(lblItemList, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(btnDisplayShoppingList, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(btnAddNewItem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnIncrement, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDecrement, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
						.addComponent(panelSelectedItem, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(txtLowItemWarning, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(btnChangeThreshold, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtLowItemWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblItemList))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelSelectedItem, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIncrement)
								.addComponent(btnDecrement))
							.addGap(18)
							.addComponent(btnAddNewItem)
							.addGap(18)
							.addComponent(btnDisplayShoppingList)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnChangeThreshold))
						.addComponent(itemList, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		panelSelectedItem.setLayout(new BoxLayout(panelSelectedItem, BoxLayout.Y_AXIS));
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblCurrentAmount = new JLabel("Current Amount:");
		
		panelSelectedItem.add(lblName);
		
		lblCurrName = new JLabel("");
		panelSelectedItem.add(lblCurrName);
		
		panelSelectedItem.add(Box.createRigidArea(new Dimension(0, 5)));
		panelSelectedItem.add(lblCurrentAmount);
		
		lblCurrAmt = new JLabel("");
		panelSelectedItem.add(lblCurrAmt);
		
		panelSelectedItem.add(Box.createRigidArea(new Dimension(0, 5)));
		
		JLabel lblThreshold = new JLabel("Threshold:");
		panelSelectedItem.add(lblThreshold);
		
		lblCurrThreshold = new JLabel("");
		panelSelectedItem.add(lblCurrThreshold);
		
		panelSelectedItem.add(Box.createRigidArea(new Dimension(0, 5)));
		
		JLabel lblExpirationDate = new JLabel("Expiration Date:");
		panelSelectedItem.add(lblExpirationDate);
		
		lblExpDate = new JLabel("");
		panelSelectedItem.add(lblExpDate);
		frmfancyKitchen.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmfancyKitchen.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		final JMenuItem mntmAdminOptions = new JMenuItem("Admin Options");
		mntmAdminOptions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run(){
						AdminOptionDialog aod = new AdminOptionDialog(myKitchen);
						aod.setVisible(true);
					}
				});
				
			}
		});
		mnFile.add(mntmAdminOptions);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		frmfancyKitchen.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e){
				mntmAdminOptions.setEnabled(myKitchen.isAdmin());
				btnChangeThreshold.setEnabled(myKitchen.isAdmin());
			}
		});
	}
	
	public void updateSelectedItem(String name, String expDate, int amount, int threshold){
		lblCurrName.setText(name);
		lblExpDate.setText(expDate);
		lblCurrAmt.setText(""+amount);
		lblCurrThreshold.setText(""+threshold);
	}
	
	public void update(Observable obs, Object obj){
		if(obj instanceof String[])
			itemList.setListData((String[])obj);
	}
	
	public void addController(KitchenController controller){
		btnIncrement.addActionListener(controller);
		btnDecrement.addActionListener(controller);
		btnAddNewItem.addActionListener(controller);
		btnDisplayShoppingList.addActionListener(controller);
		btnChangeThreshold.addActionListener(controller);
		itemList.addListSelectionListener(controller);
		frmfancyKitchen.addWindowFocusListener(controller);
	}
}
