
public class Sequence extends Element{

	Element data;
	Sequence next;
	boolean b;
	// int length;
	public Sequence()
	{
		this.data = null;
		this.next = null;
		// this.length = 0;
	}//constructor


	public Sequence(Element head)
	{
		this.data = head;
		this.next = null;
		// this.length = 1;
	}//Constructor II

	public Sequence(Element d, Sequence n , boolean b, int l)
	{
		this.data = d;
		this.next = n;
		this.b = b;
		// this.length = l;
		
	} //Constructor III
	
	public int length()
	{
		int len = 0;
		Sequence node = this;
		while (node != null)
		{
			if (node.data != null)
				len++ ;
			node = node.rest();
		}
		return len;


	} // Sequence length()

	public void Print()
	{
		Sequence temp = this;
		if (data != null) {
			System.out.print("[ ");
			for (int i = 0; i < length(); i++ )
			{
				temp.getData().Print();
				System.out.print(" ");
				temp = temp.rest();
			}
			System.out.print("]");
		}
	} //Seq:Print()

	public Element first()
	{

		return this.data;
	} //Element first()

	public Sequence rest()
	{
		return this.next;
	}//Sequence rest()

	public Sequence copy()
	{
		Sequence new_seq = new Sequence();
		for (Sequence seq = this; seq != null; seq = seq.getNext()){
			new_seq.add(seq.getData().copy(), new_seq.length());
		}
		return new_seq;
	}



	public void add(Element elm, int pos)
	{

		if (pos > length()) {
			System.err.println("Error in add");
			System.exit(1);
		}

		Sequence temp = this;
		
		if ( pos == 0 ){
			Sequence new_node = null;
			if(data != null) new_node = new Sequence(data);
			if(new_node != null)
				new_node.setNext(temp.rest());
			next = new_node;
			data = elm;
			//length++;
			return;

		}
		
		for (int i = 0; (i < pos - 1) && temp.rest() != null; i++)
		{
			temp = temp.rest();
		}
		Sequence new_node = new Sequence(elm);
		new_node.setNext(temp.rest());
		temp.setNext(new_node);
		// length++;
	}//add()

	public void delete(int pos)
	{

		if (pos > length()-1) {
			System.err.println("Error in delete");
			System.exit(1);
		}
		Sequence temp = this;
		if ( pos == 0 ){
			Element new_elm = null;
			if (next != null) {
			new_elm = next.getData();
			next = next.getNext();
			}
			data = new_elm;
			// length--;
			return;

		}
		for (int i = 0; (i < pos - 1) && (temp.rest())!= null; i++)
		{
			temp = temp.rest();
		}
		temp.setNext(temp.rest().rest());
		// length--;
	}//delete()

	public void setNext(Sequence next)
	{

		this.next = next;
	}// setNext()

	public Sequence getNext()
	{
		return next;
	}
	
	/*
	 *part 3 start 
	 */
	
	public Element getData()
	{
		return this.data;
	}//getData()
	
	public Element index (int pos)
	{
		return getIndex(pos).data;
	}//index()
	
	public Sequence getIndex(int pos)
	{
		if (pos > length()-1) {
			System.err.println("Error in Index");
			System.exit(1);
		}
		Sequence temp = this;
		for (int i = 0; i < pos; i++)
		{
			temp = temp.rest();
		}
		return temp;
	}
	
	// public void setLength(int i)
	// {
	// 	this.length = 1;
	// }//setLength()
	
/*
	public int getNewSize()
	{
		int size = 0;
		Sequence temp =((Sequence)this.getData()).getNext();
		for (int i = 0; i < ((Sequence) this.getData()).length(); i++)
		{
			
		}
		return size;
		
	}//getNewsize()
*/
	public Sequence flatten()
	{
		//int size = 0;
		if (length() == 0)
			return this;
		Sequence new_seq = new Sequence();
		// Sequence old_seq = new_seq;
		Sequence old_seq = this;
		//int i = 0;
		while (old_seq != null){
			Element elm = old_seq.getData();
			if(elm instanceof MyInteger){
				new_seq.add(elm, new_seq.length());					
			}
			else if (elm instanceof MyChar){
				new_seq.add(elm, new_seq.length());
			}
			else {
				Sequence temp  = ((Sequence)elm).flatten();
				for (;temp != null; temp = temp.rest()){
					new_seq.add(temp.getData(), new_seq.length());
				}
			}
			old_seq = old_seq.rest();
		}
		
		return new_seq;
	
	}
	
	// public Sequence copy()
	// {

	// 	Sequence new_seq  = null;
	// 	if (data == null)
	// 		new_seq = new Sequence();
	// 	else 
	// 		new_seq = new Sequence(data);
	// 		Sequence temp = this.rest();
		
			
	// 	for (int i = 0;  i < length() - 1 ; i++)
	// 	{
			
	// 		Sequence new_node = new Sequence(temp.data);
	// 		new_seq.add(new_node, i + 1);
	// 		temp = temp.rest();

	// 	}
	// 	return new_seq;
	// }
	

	public  SequenceIterator begin()
	{
		SequenceIterator it = new SequenceIterator(this);
		//if(this.getIndex(length() - 1).b == false)
		//this.getIndex(length() - 1).setNext(new Sequence());
			return it;
	}//begin()
	public SequenceIterator end()
	{
		SequenceIterator it = new SequenceIterator(this);
		for (int i = 0; i < this.length(); i++)
		{
			it.advance();
		}
		return it;
	}//end()

}// class Seq;