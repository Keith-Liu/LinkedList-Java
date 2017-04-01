
public class Matrix extends Sequence {
	private int value, row_size, col_size;
	public Matrix(int rowsize, int colsize)
	{
		
		for (int i = 0; i <= rowsize*colsize; i++){
				MyInteger in = new MyInteger();
				this.add(in,i);
		}
		this.row_size = rowsize;
		this.col_size = colsize;
		
	}
	
	public void Set(int row, int col, int value)
	{
		if (row > row_size || col > col_size)
		{
			System.out.print("Error in Set");
			System.exit(1);
		}
		
		SequenceIterator it = new SequenceIterator(this);
		for (int i = 0; i < row * col_size + col + 1; i++)
		{
			
			it.advance();
		}
		
		((MyInteger)it.get()).Set(value);
	}

	public int Get(int row, int col)
	{
		if (row > row_size || col > col_size)
		{
			System.out.print("Error in Set");
			System.exit(1);
		}
		SequenceIterator it = new SequenceIterator(this);
		for (int i = 0;i < row * col_size + col + 1; i++)
		{
			it.advance();			
		}
		return ((MyInteger)it.get()).Get();
	}
	

	public Matrix Sum(Matrix mat)
	{
		if (this.row_size != mat.row_size || this.col_size != mat.col_size  ){
			System.out.print("Error in Matrix summation");
			System.exit(1);
		}
		Matrix new_matrix = new Matrix(this.row_size, mat.col_size);
		for (int i = 0; i < this.row_size ; i++){
			for (int j = 0; j < mat.col_size ; j++){
				new_matrix.Set(i,j,this.Get(i,j) + mat.Get(i,j));
			}
		}
		return new_matrix;
		
		
	}//Sum()
	
	public Matrix Product(Matrix mat)
	{
		if (this.col_size != mat.row_size) {
			System.out.println("Matrix dimensions incompatible for Product");
			return new Matrix(0,0);
		}
		Matrix new_matrix = new Matrix(this.row_size, mat.col_size);
		for (int i = 0; i < this.row_size; i++){
			for (int j = 0; j < mat.col_size; j++){
				int value = 0;
				for (int k = 0; k < this.col_size; k++) {
					value += this.Get(i,k) * mat.Get(k,j);
				}
				new_matrix.Set(i,j,value);
			}
		}
		return new_matrix;
		
	}//product()

	public void Print()
	{
		//System.out.print(this);
		SequenceIterator it = new SequenceIterator(this);
		//for (int j = 0 ; )
		
		for (int i = 0; i < row_size ; i++ )
		{
			
			System.out.print("[ ");
			for (int j = 0; j < col_size ; j++){
			//System.out.println(i);
			it.advance();
			((MyInteger)it.get()).Print();
			System.out.print(" ");
			}
			System.out.print("]");
			System.out.println();
			
		}
		
	}
}//class Matrix
