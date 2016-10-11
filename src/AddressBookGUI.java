import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
  
public class AddressBookGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 250;
  
    private JTextField nameTextField, addressTextField, phoneTextField;
    public AddressBook a;
    
	public AddressBookGUI() {
		setSize(WIDTH,HEIGHT);
		setTitle("Address Book");
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.RED);
        contentPane.setLayout(new GridLayout(8,2));
  
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem newItem = new JMenuItem("Create AddressBook", 'C');
        newItem.addActionListener(this);
        fileMenu.add(newItem);
        fileMenu.addSeparator();
        
        JMenuItem saveItem = new JMenuItem("Save AddressBook", 'S');
        saveItem.addActionListener(this);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        
        JMenuItem displayItem = new JMenuItem("Display BuddyInfos", 'D');
        displayItem.addActionListener(this);
        fileMenu.add(displayItem);
        fileMenu.addSeparator();
       
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        JLabel nameLabel = new JLabel("Name: ");
        contentPane.add(nameLabel);
        nameTextField = new JTextField(25);
        contentPane.add(nameTextField);
  
        JLabel addressLabel = new JLabel("Address:  ");
        contentPane.add(addressLabel);
        addressTextField = new JTextField(25);
        contentPane.add(addressTextField);
  
        JLabel phoneLabel = new JLabel("Phone number: ");
        contentPane.add(phoneLabel);
        phoneTextField = new JTextField(25);
        contentPane.add(phoneTextField);
  
        JButton enterButton = new JButton("Enter BuddyInfo");
        enterButton.addActionListener(this);
        contentPane.add(enterButton);
        
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        contentPane.add(exitButton);
    }
 
    public void actionPerformed(ActionEvent e) {
    	String actionCommand = e.getActionCommand();
  
    	if(actionCommand.equals("Create AddressBook"))
    	{
    		a = new AddressBook();
    	}
    	else if(actionCommand.equals("Save AddressBook"))
    	{
    		String s = "";
    		
    		BufferedWriter out;
			try {
				out = new BufferedWriter(new FileWriter("myFile.txt"));
				for (Buddyinfo b : a.bl) {
	    			s += b.toString();
	    			out.write(s);
	    			out.write("\n");
	    		}	
	    		out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}
    	else if(actionCommand.equals("Display BuddyInfos"))
    	{
    		for (Buddyinfo b : a.bl) {
    			System.out.println(b.toString());
    		}
    	}
    	else if(actionCommand.equals("Enter BuddyInfo"))
    	{
    		Buddyinfo b = new Buddyinfo(nameTextField.getText(), addressTextField.getText(), Integer.parseInt(phoneTextField.getText()) );
    		String display = b.toString();
    		
    		nameTextField.setText("");
    		addressTextField.setText("");
    		phoneTextField.setText("");
  
    		a.addBuddy(b);
    		JOptionPane.showMessageDialog(null, display);
    	}
    	else System.exit(0);
    }
  
    public static void main(String[] args) {
    	AddressBookGUI gui = new AddressBookGUI();
    	gui.setVisible(true);
    }
}