import java.util.*;

public class Vector1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Vector v=new Vector();
		System.out.println(v.size());
		System.out.println(v.capacity());
		for(int i=0;i<=10;i++)
		{
			System.out.println("enter the elements: ");
			v.add(sc.nextInt());
		}
		System.out.println(v.capacity());
	}

}
