using System; 

class minhaClasse {

    static void Main(string[] args) { 

            double a, b, c, delta, r1, r2;
            string[] valor = Console.ReadLine().Split();

            a = Convert.ToDouble( valor[0] );
            b = Convert.ToDouble( valor[1] );
            c = Convert.ToDouble( valor[2] );

            delta = ( Math.Pow(b, 2) - (4 * a * c) );
            r1 = ( -b + Math.Sqrt(delta) ) / ( 2 * a );
            r2 = ( -b - Math.Sqrt(delta) ) / ( 2 * a );

            if ( delta >= 0 && ( 2 * a ) > 0 )
            {
                Console.WriteLine( string.Format( "R1 = {0:0.00000}", r1 ) );
                Console.WriteLine( string.Format( "R2 = {0:0.00000}", r2 ) );
            }
            else
            {
                Console.WriteLine( "Impossivel calcular" );
            }

    }

}