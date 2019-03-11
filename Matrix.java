

public class Matrix implements Operand
{
    private Integer columns;
    private Integer rows;
    private Vector[] rowVectors;

    public Matrix(){}
    public Matrix(Double[][] matrix )
    {

        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.rowVectors = new Vector[this.rows];
        for( int i = 0 ; i < this.rows ; i++)
        {
            this.rowVectors[i] = new Vector(matrix[i]);
        }
    }
    public Matrix( String matrixString )
    {
        String[] vectorStrings = matrixString.split(":");
        this.rows = vectorStrings.length;
        this.rowVectors = new Vector[this.rows];
        for(int i = 0; i < vectorStrings.length ; i++)
        {
           this.rowVectors[i] = new Vector(vectorStrings[i]);
        }
        this.columns = Integer.parseInt(this.rowVectors[0].getSize());

    }

    public Matrix( Vector[] rowVectors )
    {
        this.rowVectors = rowVectors;
        this.rows = rowVectors.length;
        this.columns = Integer.parseInt(rowVectors[0].getSize());
    }

    public Vector getRowVectors(int element )
    {
        return this.rowVectors[element];
    }

    public Vector getColumnVectors(int element )
    {
        Double[] columnValues = new Double[this.rows];
        for( int i = 0 ; i < columnValues.length ; i++ )
        {
            columnValues[i] = this.rowVectors[i].getComponent(element);
        }
        return new Vector(columnValues);
    }

    public int getNumberOfRows()
    {
        return this.rowVectors.length;
    }

    public int getNumberOfColumns()
    {
        return Integer.parseInt( this.rowVectors[0].getSize() );
    }

    public boolean isSquareMatrix()
    {
        Boolean returnBoolean = false;
        if( this.rows == this.columns )
            returnBoolean = true;
        return returnBoolean;
    }
    public Double[][] matrixToArray()
    {
        Double[][] matrix = new Double[this.rows][this.columns];
        for(int i = 0 ; i < this.rows ; i++ )
        {
            for( int j = 0 ; j < this.columns ; j++)
            {
                matrix[i][j] = this.rowVectors[i].getComponent(j);
            }
        }
        return matrix;
    }
    @Override
    public String getSize()
    {
        String returnString = this.columns + " x " + this.rows;
        if( this.isSquareMatrix() )
            returnString = Integer.toString( this.rows );
        return returnString;
    }

    @Override
    public void print()
    {
        for (int i = 0; i < this.rows ; i++)
        {
            this.rowVectors[i].print();
        }
    }

}
