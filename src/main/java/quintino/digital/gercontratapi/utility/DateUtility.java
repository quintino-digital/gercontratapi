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
        return calendar.getTime();
    }

    public static String formatarData(Date dataReferencia) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMATO_DATA_DDMMAAAA);
        return simpleDateFormat.format(dataReferencia);
    }

    public static Integer recuperarUltimoDiaMesReferencia() {
        Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.MONTH, recuperarMesCorrente());
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Integer recuperarMesCorrente() {
        Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
        System.out.println(calendar.getActualMaximum(Calendar.MONTH));
        return calendar.getActualMaximum(Calendar.MONTH);
    }

    public static Date gerarData(Integer diaMesReferencia) {
        Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, diaMesReferencia);
        return calendar.getTime();
    }

}
