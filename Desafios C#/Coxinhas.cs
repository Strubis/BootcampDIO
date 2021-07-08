using System;

class Classe {
    static void Main() {
        string[] line = Console.ReadLine().Split(" ");
        
        int h, p;
        h = int.Parse( line[0] );
        p = int.Parse( line[1] );
        
        double res = Convert.ToDouble( h ) / p;
        
        Console.WriteLine( string.Format( "{0:0.00}", res ) );

    }
}