

public class SequenceIterator {
	Sequence seq;
	public SequenceIterator(Sequence seq)
	{
		
		this.seq = seq;
	} //Itr::constructor

	public boolean equal(SequenceIterator other)
	{
		if (this.seq == other.seq)
		return true;
		else
		return false;
	}// Itr::equal()
	
	public void setSequence(Sequence s)
	{
		this.seq = s;
	}
	public void set(Sequence seq)
	{
		this.seq = seq;
	}// Itr::set()

	public Element get()
	{
		//System.out.print(this.seq);
		return this.seq.getData();

	}//Itr::get()

	public void advance()
	{
		this.setSequence(seq.rest());

	}//Itr::advance()

}
