import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Um exemplo simples com manipulação de Datas.
 *
 * @author Emerson
 */
public class DateUse {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        
        // Data atual
        System.out.println( "Data da compra: " + now.getTime() );
        
        // Depois de 10 dias
        now.add( Calendar.DATE, 10 );
        System.out.println( "Vencimento: " + now.getTime() );
        
        
        // Convertendo uma data para DD/MM/YYYY HH:MM:SS:MMM
        SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss:mmm" );
        Date date = new Date();
        
        String formatDate = formatter.format( date );
        System.out.println( "\nData: " + formatDate );
    }
}
