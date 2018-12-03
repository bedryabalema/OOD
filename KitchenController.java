

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

//import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class KitchenController implements ActionListener, ListSelectionListener, WindowFocusListener {

	Kitchen kitchenModel;
	Disp kitchenView;
	LoginController login;
	Login loginView;
	AddItemDialog addView;
	AddItemController addController;
	
	private KitchenItem selectedItem;
	
	
	public KitchenController(){
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		System.out.println(ae.getActionCommand());
		addView = new AddItemDialog(kitchenView.getFrame());
		addController = new AddItemController();
		if(ae.getActionCommand() == "Add New Item"){
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run(){
					addController.setModel(kitchenModel);
					addController.setView(addView);
					addView.addController(addController);
					
					addView.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e){
							kitchenModel.updateLowItems();
						}
					});
					
					addView.setVisible(true);
				}
			});
		}
		if(ae.getActionCommand() == "Display Shopping List"){
			kitchenModel.updateLowItems();
			LowItemsView liv = new LowItemsView(kitchenModel.getItemsBelowThreshold());
			//fridgeModel.getItemsBelowThreshold()
			liv.setVisible(true);
		}
		if(ae.getActionCommand() == "Add"){
			selectedItem = kitchenModel.getItemWithName(kitchenView.getSelectedItem());
			if(selectedItem != null){
				int newAmnt = selectedItem.getCurrAmnt() + 1;
					selectedItem.setCurrAmnt(newAmnt);
					kitchenView.updateSelectedItem(selectedItem.getName(), selectedItem.getExpDateString(), selectedItem.getCurrAmnt(), selectedItem.getThreshold());
				kitchenModel.updateLowItems();
				if(kitchenModel.hasLowItems()){
					kitchenView.setLowItemWarning();
				} else kitchenView.clearLowItemWarning();
			}
		}
		if(ae.getActionCommand() == "Remove"){
			selectedItem = kitchenModel.getItemWithName(kitchenView.getSelectedItem());
			if(selectedItem != null){
				int newAmnt = selectedItem.getCurrAmnt() - 1;
				if(newAmnt >= 0) {
					selectedItem.setCurrAmnt(newAmnt);
					kitchenView.updateSelectedItem(selectedItem.getName(), selectedItem.getExpDateString(), selectedItem.getCurrAmnt(), selectedItem.getThreshold());
				} else {
					kitchenModel.deleteItem(selectedItem);
				}
				kitchenModel.updateLowItems();
				if(kitchenModel.hasLowItems()){
					kitchenView.setLowItemWarning();
				} else kitchenView.clearLowItemWarning();
			}
		}
		if(ae.getActionCommand() == "Change Threshold"){
			if(selectedItem != null){
				SetThresholdDialog std = new SetThresholdDialog(selectedItem);
				std.setVisible(true);}
			else{
				JOptionPane.showMessageDialog(null,"Please select an Item!"); }
			}
		}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		selectedItem = kitchenModel.getItemWithName(kitchenView.getSelectedItem());
		if(selectedItem !=null)
			kitchenView.updateSelectedItem(selectedItem.getName(), selectedItem.getExpDateString(), selectedItem.getCurrAmnt(), selectedItem.getThreshold());
		
	}
		
	
	public void setModel(Kitchen f){
		this.kitchenModel = f;
		login = new LoginController(""+kitchenModel.getUserPasscode(), ""+kitchenModel.getAdminPasscode());
	}
	
	public void setView(Disp d){
		this.kitchenView = d;
		loginView = new Login(kitchenView.getFrame());
	}
	
	public void startApplication(){		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run(){
				login.setView(loginView);
				login.setKitchen(kitchenModel);
				loginView.addController(login);
				kitchenView.getFrame().setVisible(false);
				loginView.setVisible(true);
			}
		});
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		if(kitchenModel.hasLowItems()) kitchenView.setLowItemWarning();
		else kitchenView.clearLowItemWarning();
		
		kitchenView.update(kitchenModel, kitchenModel.getItemNames());
		
		selectedItem = kitchenModel.getItemWithName(kitchenView.getSelectedItem());
		if(selectedItem != null)
			kitchenView.updateSelectedItem(selectedItem.getName(), selectedItem.getExpDateString(), selectedItem.getCurrAmnt(), selectedItem.getThreshold());
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		//do nothing
	}
}
