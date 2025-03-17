
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    public static void main(String[] args) {
        Date data = new Date();
        System.out.println(data); //Data sem formatação

        SimpleDateFormat formato = new SimpleDateFormat("yyyy");
        System.out.println(formato.format(data));

        SimpleDateFormat formatoBrasil = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formatoBrasil.format(data));

        /*
            y Year
            M Mês no ano
            D Dia no ano
            d Dia no mês
            H Hora no dia
            h Hora no dia
            m Minuto na hora
            s Segundo no minuto
            S Milisegundo 
         */
    }
}
