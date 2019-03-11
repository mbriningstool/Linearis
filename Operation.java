public class Operation
{
    public static Vector add( Vector v , Vector u )
    {
        int vectorSize = Integer.parseInt( v.getSize() );
        Double[] vectorValues = new Double[vectorSize];
        if( v.vectorsAreSameSize(u) )
        {

            for (int i = 0; i < vectorSize; i++) {
                vectorValues[i] = v.getComponent(i) + u.getComponent(i);
            }
        }
        Vector summationVector = new Vector(vectorValues);
        return summationVector;
    }

    public static Matrix add(Matrix a,Matrix b)
    {
        Vector[] rowVectorsSum = new Vector[a.getNumberOfRows()];
        for( int i = 0 ; i < a.getNumberOfRows() ; i++ )
        {
            rowVectorsSum[i] = add(a.getRowVectors(i),b.getRowVectors(i));
        }



        return new Matrix(rowVectorsSum);
    }

    public static Vector scalarMultiplication(Double c , Vector u )
    {
        Double[] values = new Double[ Integer.parseInt( u.getSize() ) ];
        for(int i = 0 ; i < Integer.parseInt( u.getSize() ); i++ )
        {
            values[ i ] = c * u.getComponent( i );
        }
        return new Vector( values );
    }

    public static Matrix scalarMultiplication( Double c , Matrix a )
    {
        Vector[] rowVectorProduct = new Vector[ a.getNumberOfRows() ];
        for( int i = 0 ; i < a.getNumberOfRows() ; i++ )
        {
            rowVectorProduct[ i ] = scalarMultiplication( c , a.getRowVectors( i ) );
        }
        return new Matrix( rowVectorProduct );
    }

    public static double determinant( Matrix a ) {
        Double[][] matrix = a.matrixToArray();
        Double minorMatrix[][];
        Double determinent = 0.0;

        if (matrix.length == 1) {
            determinent = matrix[0][0];
            return (determinent);
        }

        if (matrix.length == 2) {
            determinent = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (determinent);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            minorMatrix = new Double[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        minorMatrix[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        minorMatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            determinent += matrix[0][i] * Math.pow (-1, (double) i) * determinant(new Matrix(minorMatrix) );
        }
        return (determinent);
    }

    public static Double dotProduct(Vector u , Vector v )
    {
        Double dotProduct = 0.0;
        for( int i = 0 ; i < Integer.parseInt( u.getSize() ) ; i++ )
        {
            dotProduct += u.getComponent( i ) * v.getComponent( i );
        }

        return dotProduct;
    }

    public static Double dotProduct( Matrix a , Matrix b )
    {
        Double dotProduct = 0.0;
        for( int i = 0 ; i < a.getNumberOfRows() ; i++ )
        {
            dotProduct += dotProduct( a.getRowVectors( i ), b.getRowVectors( i ) );
        }

        return dotProduct;

    }

    public static Matrix transpose( Matrix a )
    {
        Vector[] rowVectors = new Vector[a.getNumberOfColumns()];
        for(int i = 0 ; i < a.getNumberOfColumns() ; i++ )
        {
            rowVectors[i] = a.getColumnVectors(i);
        }
        return new Matrix( rowVectors );

    }

}
