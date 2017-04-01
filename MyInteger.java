
 public class MyInteger extends Element{
	protected int num;
	public MyInteger()
	{
		this.num = 0;
	}
	public int Get()
	{
		return this.num;
	}
	public void Set(int i)
	{
		num = i;
	}
	public void Print()
	{
		System.out.print(this.num);
	}
	public Element copy()
	{
		MyInteger i = new MyInteger();
		i.Set(this.num);
		return (Element)i;
	}
}