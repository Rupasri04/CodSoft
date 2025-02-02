import java.util.*;
public class LinkedList {
	int size;
	Node head;
	public LinkedList()
	{
		
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public void add(int data)
	{
		Node newnode=new Node(data);
		if(isEmpty())
		{
			head=newnode;
			size++;
		}
		else
		{
			Node cur=head;
			while(cur.next!=null)
			{
				cur=cur.next;
			}
			cur.next=newnode;
			size++;
		}
	}
	@Override
	public String toString()
	{
		String res="[";
		Node cur=head;
		while(cur!=null) {
			if(cur.next==null)
				res=res+cur.data+"";
			else
				res=res+cur.data+",";
			cur=cur.next;
		}
		return res+"]";
			
		}	
	}

