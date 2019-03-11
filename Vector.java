import java.util.ArrayList;

public class Vector implements Operand
{
    public Vector(String vectorString )
    {
        String[] stringValues = vectorString.split(",");
        this.components = new Double[stringValues.length];
        for(int i = 0 ; i < stringValues.length ; i++)
        {
            this.components[i]= Double.parseDouble( stringValues[i] );
        }
    }

    public Vector(Double[] values)
    {
        this.components= new Double[values.length];
        for(int i = 0 ; i<values.length ;i++)
        {
            this.components[i] = values[i];
        }
    }
    private Double[] components;

    public Boolean vectorsAreSameSize( Vector otherVector )
    {
        Boolean returnBool = true;
        Integer otherVectorSize = Integer.parseInt( otherVector.getSize() );
        if (otherVectorSize  != this.components.length)
        {
            returnBool = false;
        }
        return returnBool;
    }



    public double getComponent( int i )
    {
        return this.components[i];
    }
    @Override
    public String getSize()
    {
        return Integer.toString( this.components.length );
    }

    @Override
    public void print()
    {
      String outputString= new String();
      for ( int i = 0; i < this.components.length;i++)
      {
          outputString+= components[i] + " ";
      }
      System.out.println(outputString);
    }


}
