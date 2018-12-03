

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class FancyKitchen {
		static Kitchen myKitchen;
		
	
	public static void main(String[] args) {
		Disp myView = new Disp();
		
		try{
			FileInputStream fin = new FileInputStream("kitchen.dat");
			ObjectInputStream ois = new ObjectInputStream(fin);
			myKitchen = (Kitchen)ois.readObject();
			ois.close();
		}catch(IOException | ClassNotFoundException ioe){
			System.err.println(ioe);
			myKitchen = new Kitchen();
		}
		
		myKitchen.addObserver(myView);
		
		KitchenController kitchenControl = new KitchenController();
		kitchenControl.setModel(myKitchen);
		kitchenControl.setView(myView);

		myView.addKitchen(myKitchen);
		myView.addController(kitchenControl);
		
		kitchenControl.startApplication();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		    public void run() {
		    	writeKitchen();
		    }
		}));		
	}
	
	private static void writeKitchen(){
		try{
			FileOutputStream fout = new FileOutputStream("kitchen.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(myKitchen);
			oos.close();
		} catch (IOException ioe){
			System.err.print(ioe);
		}
	}
}
