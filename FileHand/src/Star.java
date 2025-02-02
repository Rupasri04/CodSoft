import java.util.*;
public class Star {
	public static void main(String[] args) {
		String str="varshini*rupa*shehnaz";
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++)
		{
			if(i==0)
			{
				if((str.charAt(i)!='*') && (str.charAt(i+1)!='*'))
				{
					sb.append(str.charAt(i));
				}
			}
			else if(i==str.length()-1)
			{
				if((str.charAt(i)!='*') && (str.charAt(i-1)!='*'))
				{
					sb.append(str.charAt(i));
				}
			}
			else

			{
				if(((str.charAt(i)!='*') && (str.charAt(i-1)!='*') && (str.charAt(i+1)!='*')))
				{
					sb.append(str.charAt(i));
				}
				
			}
		}
		
		System.out.println(sb);
	}

}
