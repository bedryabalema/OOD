

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Kitchen extends java.util.Observable implements Serializable{
	private static final long serialVersionUID = -3844646893552778913L;
	private ArrayList<KitchenItem> items = new ArrayList<KitchenItem>();
	private int userPasscode = 1234;
	private int adminPasscode = 9999;
	private boolean isAdmin = false;
	private ArrayList<String> lowItems = new ArrayList<String>();
	
	public Kitchen(){
		super();
	}
	
	public void sendUpdatedList(){
		setChanged();
		notifyObservers(this.getItemNames());
	}
	
	public void setAdmin(boolean admin){
		isAdmin = admin;
		setChanged();
		notifyObservers();
	}
	
	public String[] getItemsBelowThreshold(){
		String retArray[] = new String[lowItems.size()]; 
		return lowItems.toArray(retArray);
	}
	
	public void updateLowItems(){
		lowItems.clear();
		for(KitchenItem ki : items){
			if(ki.isUnderThreshold()) lowItems.add(ki.getName()); 
		}
	}
	
	public boolean hasLowItems(){
		return !lowItems.isEmpty();
	}
	
	public void addItem(KitchenItem item){
		items.add(item);
		sendUpdatedList();
	}
	
	public void deleteItem(KitchenItem item){
		if(items.contains(item)) items.remove(item);
		sendUpdatedList();
	}
	
	public KitchenItem getItemWithName(String name){
		for(KitchenItem i : items){
			if(i.getName().equals(name)) return i;
		}
		return null;
	}
	
	public KitchenItem getItemAt(int index){
		return items.get(index);
	}

	public List<KitchenItem> getItems() {
		return items;
	}
	
	public String[] getItemNames(){
		String[] itemNames = new String[items.size()];
		int i=0;
		for(KitchenItem ki : items){
			itemNames[i] = ki.getName();
			i++;
		}
		return itemNames;
	}

	public int getUserPasscode() {
		return userPasscode;
	}

	public void setUserPasscode(int userPasscode) {
		this.userPasscode = userPasscode;
	}

	public int getAdminPasscode() {
		return adminPasscode;
	}

	public void setAdminPasscode(int adminPasscode) {
		this.adminPasscode = adminPasscode;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	
	@Override
	public String toString() {
 	   return new StringBuffer(" items : ")
 	   .append(this.items)
 	   .append(" userPasscode : ")
 	   .append(this.userPasscode)
 	   .append(" adminPasscode : ")
 	   .append(this.adminPasscode)
 	   .append(" isAdmin : ")
 	   .append(this.isAdmin)
 	   .append(" lowItems : ")
 	   .append(this.lowItems)
 	   .toString();
	   }
}
