/*
 * Name: Thea Siozon
 * Source File Name: FriendInput.java and FriendGUI.java
 * Description: This program will display the use of a search and sort algorithim through a GUI interface. User will be allowed to input a string values, search to delete the values and sort the values in alphabetical order.
 * IDE: Eclipse
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class FriendGUI extends JFrame {
	
	//GUI variables
	
	JTextArea  infoTextArea       = new JTextArea ();
	JLabel     nameLabel         = new JLabel ("Name: ");
	JTextField nameTextField     = new JTextField(10);
	JLabel     numLabel           = new JLabel ("Number: ");
	JTextField numTextField       = new JTextField (10);
	
	JButton    addButton         = new JButton ("Add");
	JButton    deleteButton      = new JButton ("Delete");
	JButton    sortButton        = new JButton ("Sort");
	
	private LinkedList<FriendInput> friendLinkedList = new LinkedList <FriendInput>();
	
	//GUI constructor
	public FriendGUI()
	{
		JPanel flow1Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel flow2Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel gridPanel  = new JPanel (new GridLayout (2,1));
		
		infoTextArea.setEditable (false);
		
		flow1Panel.add (nameLabel);
		flow1Panel.add (nameTextField);
		flow1Panel.add (numLabel);
		flow1Panel.add (numTextField);
		
		flow2Panel.add (addButton);
		flow2Panel.add (deleteButton);
		flow2Panel.add (sortButton);
		
		gridPanel.add (flow1Panel);
		gridPanel.add (flow2Panel);
		
		add (infoTextArea, BorderLayout.CENTER);
		add (gridPanel,     BorderLayout.SOUTH);
		
		addButton.addActionListener(event -> addFriend());
		deleteButton.addActionListener(event -> deleteFriend());
		sortButton.addActionListener(event -> sortFriend());
	}
		//method to add a friend's information
		private void addFriend ()
		{
			friendLinkedList.add
			(new FriendInput (nameTextField.getText() ,
								numTextField.getText()));
			
			displayAll();
			
			nameTextField.setText("");
		    numTextField.setText("");
			
		}
		//method to search and delete a friend's information
		private void deleteFriend()
		{
			boolean findID = false;
			
			for (FriendInput info : friendLinkedList)
			{
				if (info.getName().compareToIgnoreCase(nameTextField.getText()) == 0)
				{
					findID = true;
				}
			}
			
			if (findID == false)
			{
				JOptionPane.showMessageDialog (null, "Error: Friend not found in the database");
			}
			else
			{
				for ( int x = 0; x < friendLinkedList.size(); x++)
				{
					String searchedId = friendLinkedList.get(x).getName();
					
					if (searchedId.compareToIgnoreCase (nameTextField.getText()) == 0)
						{
							friendLinkedList.remove(x);
						}
					
				}
				
			}
			
			displayAll();
			
			nameTextField.setText("");
			numTextField.setText("");
		}
		//method to sort the Friend list
		private void sortFriend()
		{
			Collections.sort(friendLinkedList);
			
			displayAll();
				
		}
		
		//displaying the information on the text area
		private void displayAll()
		{
			
			infoTextArea.setText("");
			
			for (FriendInput friend : friendLinkedList)
			{
				infoTextArea.append ( friend + "\n");
			}
		}
		
	
	
	public static void main (String[] args)
	{
		FriendGUI panel = new FriendGUI ();
		panel.setVisible (true);
		panel.setSize (500, 500);
		panel.setLocation (200, 100);
		panel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
	}
}
