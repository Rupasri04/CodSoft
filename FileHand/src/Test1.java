class Test1
{
	int i;
	{
		System.out.println("java1");
	}
	Test1()
	{
		this(10);
		System.out.println("java");
		
	}
	Test1(int a)
	{
		System.out.println(a);
	}

	public static void main(String[] args) {
		Test1 d=new Test1();
		
	}
	
}
