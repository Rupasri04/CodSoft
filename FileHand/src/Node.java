import java.util.*;
public class Node {
	int data;
	Node next;
	Node()
	{
		
	}
	Node(int data)
	{
		this.data=data;
	}
	
	Node(int data,Node next)
	{
		this(data);
		this.next=next;
	}
	

}
