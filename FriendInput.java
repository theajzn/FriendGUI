/*
 * Name: Thea Siozon
 * Description: This program will allow the user to provide input a string to add and remove from an ordered list, contents of the list may be displayed as well.
 * IDE: Eclipse
 */
public class FriendInput implements Comparable <FriendInput> {
	
	
	private String name;
	private String num;
	
	public FriendInput() {
		
		name = "";
		num = "";
	
	}
	
	public FriendInput(String name, String num) {
		
		this.name = name;
		this.num = num;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getnum() 
	{
		return num;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setId (String num)
	{
		this.num = num;
	}
	
	public String toString()
	{
		return name + "\t" + num;
	}
	
	public int compareTo (FriendInput other)
	{
		int result;
		result = name.compareTo(other.name);
		
		
		return result;
	}
	
	
	

}
