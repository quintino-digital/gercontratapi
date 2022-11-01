package quintino.digital.gercontratapi.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

    public static final String FORMATO_DATA_DDMMAAAA = "dd/MM/yyyy";

    public static Date gerarData(Integer diaVencimento, Integer mesVencimento) {
        Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, diaVencimento);
            calendar.add(Calendar.MONTH, mesVencimento);
            System.out.println(formatarData(calendar.getTime()));
        return calendar.getTime();
    }

    public static String formatarData(Date dataReferencia) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMATO_DATA_DDMMAAAA);
        return simpleDateFormat.format(dataReferencia);
    }

}
