import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {

        String operation = "";
        if( args.length >= 1 )
        {
            operation = args[0];
        }

        switch( operation )
        {
            case "-Add" :
                if( args[1].compareTo("-V") == 0 )
                {

                    Vector u = new Vector(args[2]);
                    Vector v = new Vector(args[3]);
                    Vector sum = Operation.add(u,v);
                    sum.print();

                }
                else if(args[1].compareTo("-M") == 0 )
                {
                    Matrix a = new Matrix(args[2]);
                    Matrix b = new Matrix(args[3]);
                    Matrix sum = Operation.add(a,b);
                    sum.print();

                }

                break;
            case "-SM"  :
                Double c = Double.parseDouble(args[2]);
                if( args[1].compareTo("-V") == 0 )
                {
                    Vector u = new Vector(args[3]);
                    Vector product = Operation.scalarMultiplication(c,u);
                    product.print();

                }
                else if(args[1].compareTo("-M") == 0 )
                {
                    Matrix a = new Matrix(args[3]);
                    Matrix product = Operation.scalarMultiplication(c,a);
                    product.print();

                }
                break;
            case "-DP"  :
                if( args[1].compareTo("-V") == 0 )
                {

                    Vector u = new Vector(args[2]);
                    Vector v = new Vector(args[3]);
                    Double dotProduct = Operation.dotProduct(u,v);
                    System.out.println(dotProduct);

                }
                else if(args[1].compareTo("-M") == 0 )
                {
                    Matrix a = new Matrix( args[ 2 ] );
                    Matrix b = new Matrix( args[ 3 ] );
                    Double dotProduct = Operation.dotProduct(a,b);
                    System.out.println(dotProduct);

                }


                break;
            case "-CP"  :

                break;
            case "-Det" :
                Matrix a = new Matrix( args[ 1 ] );
                System.out.println(Operation.determinant(a));

                break;
            case "-Tran":
                a = new Matrix( args[ 1 ] );
                Matrix transpose = Operation.transpose(a);
                transpose.print();
                break;
            case "-Inv":

                break;
            case "-Diag":

                break;
            case "-Eval":

                break;
            case "EVect":

                break;
            case "-h"   :
                printHelp();
                break;

            default     :
                System.out.println("Use the -h option for usage");
                break;
        }
    }
    public static void printHelp()
    {
        System.out.println("Basic syntax java Main -[operation] -[option] [operand1] [operand2] ");
        System.out.println("Operation   Description                                   options               " );
        System.out.println("-Add        Performs addition on two operands             -V(vector operands)    ");
        System.out.println("                                                          -M(Matrix operands)    ");
        System.out.println("-SM         Performs scalar multiplication on operand     -V               ");
        System.out.println("                                                          -M               ");
        System.out.println("-DP         Performs the dot product on two operands      -V               ");
        System.out.println("                                                          -M               ");
        System.out.println("-Det        Takes the determinant of a matrix               ");
        System.out.println("-Tran       Takes displays the transpose of a matrix                     ");
        System.out.println("Example Usage              ");
        System.out.println("java Main -Add -V 2,4,5 6,4,3                  ");
        System.out.println("java Main -Add -M 2,4,5:6,4,3 3,4,5:6,7,8                 ");



    }


}
