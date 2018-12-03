

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KitchenItem implements Serializable{
	private static final long serialVersionUID = 5525457742529408067L;
	private String name = null;
	private Date expDate = new Date();
	private int currAmnt = 0;
	private int threshold = 0;
	
	public boolean isUnderThreshold(){
		return currAmnt < threshold;
	}
	
	public KitchenItem(){
		super();
	}
	
	public KitchenItem(String name, Date expDate, int currAmnt){
		this.name = name;
		this.expDate = expDate;
		this.currAmnt = currAmnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getExpDate(){
		return expDate;
	}

	public String getExpDateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");
		return sdf.format(expDate);
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getCurrAmnt() {
		return currAmnt;
	}

	public void setCurrAmnt(int currAmnt) {
		this.currAmnt = currAmnt;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	@Override
	public String toString() {
		return "KitchenItem [name=" + name + ", expDate=" + expDate + "]";
	}
}
