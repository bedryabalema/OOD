

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Date;



public class AddItemController extends KeyAdapter implements ActionListener{
	private KitchenItem newItem = null;
	private AddItemDialog addItemWindow;
	private Kitchen kitchen;
	
	public AddItemController(){
		super();
	}
	
	public void updateItem(KitchenItem update){
		newItem = update;
	}
	
	public void setView(AddItemDialog aid){
		addItemWindow = aid;
	}
	
	public void setModel(Kitchen k){
		kitchen = k;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand() == "Cancel"){
			addItemWindow.dispose();
		} else if(ae.getActionCommand() == "Submit"){
			if(newItem == null){
				newItem = new KitchenItem();
				newItem.setName(addItemWindow.getItemName());
				newItem.setExpDate(addItemWindow.getExpDate());
				newItem.setCurrAmnt(addItemWindow.getAmount());
				kitchen.addItem(newItem);
			} else {
				newItem.setName(addItemWindow.getItemName());
				newItem.setExpDate(addItemWindow.getExpDate());
				newItem.setCurrAmnt(addItemWindow.getAmount());
			}
			addItemWindow.dispose();
		} else if(ae.getActionCommand() == "Reset"){
			addItemWindow.setTextFields("", new Date(), 0.0);
		}
	}
}
