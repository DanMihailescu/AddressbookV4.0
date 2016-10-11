import java.util.*;

public class AddressBook {
	public ArrayList<Buddyinfo> bl;
	
	public AddressBook(){
		bl = new ArrayList<Buddyinfo>();
	}
	
	public void main (String[] args){
		System.out.println("AddressBook");
		Buddyinfo b = new Buddyinfo();
		AddressBook ab = new AddressBook();
		ab.addBuddy(b);
		ab.removeBuddy(b);
	}
	
	public void addBuddy(Buddyinfo b){
		bl.add(b);
	}
	
	public void removeBuddy(Buddyinfo b){
		bl.remove(b);
	}
}
