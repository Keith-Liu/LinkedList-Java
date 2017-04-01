
public class MyChar extends Element{
	protected char ch;
	public MyChar()
	{
		this.ch = '0';
	}

	public char Get()
	{
		return this.ch;
	}
	public void Set(char ch)
	{
		this.ch = ch;
	}

	public void Print()
	{
		System.out.print("'" + this.ch + "'");
	}

	public Element copy()
	{
		MyChar c = new MyChar();
		c.Set(this.ch);
		return (Element)c;
	}
}