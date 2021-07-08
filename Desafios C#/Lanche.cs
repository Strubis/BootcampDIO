using System;

public class Classe
{
    public static void Main()
    {
      string[] line = Console.ReadLine().Split(" ");
      string[] line2 = Console.ReadLine().Split(" ");
      
      int ca, ba, pa;
      ca = int.Parse( line[0] );
      ba = int.Parse( line[1] );
      pa = int.Parse( line[2] );
      
      int cr, br, pr;
      cr = int.Parse( line2[0] );
      br = int.Parse( line2[1] );
      pr = int.Parse( line2[2] );
      
      int res = 0;
      
      if( cr > ca ){
        res += ( cr - ca );
      }
      
      if( br > ba ){
        res += ( br - ba );
      }
      
      if( pr > pa ){
        res += ( pr - pa );
      }
      
      Console.WriteLine( res );
      
    }
}