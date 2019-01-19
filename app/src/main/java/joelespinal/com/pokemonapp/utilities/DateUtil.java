package joelespinal.com.pokemonapp.utilities;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    @NonNull
    public static long getHoursBetween(Date dateFrom, Date dateTo) {
        if (dateFrom == null || dateTo == null)
            return 0L;
        Calendar from = Calendar.getInstance();
        from.setTime(dateFrom);
        Calendar to = Calendar.getInstance();
        to.setTime(dateTo);

        Long millisFrom = from.getTimeInMillis();
        Long millisTo = to.getTimeInMillis();
        if (millisFrom > millisTo)
            return 0L;
        long msDiff = to.getTimeInMillis() - from.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toHours(msDiff);
    }

    @NonNull
    public static Date toDate(Long timeInMillis) {
        if (timeInMillis == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(0L);
            return calendar.getTime();
        }
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeInMillis);
        return c.getTime();
    }
}
