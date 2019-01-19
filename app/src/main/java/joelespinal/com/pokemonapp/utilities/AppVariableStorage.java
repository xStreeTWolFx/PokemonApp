package joelespinal.com.pokemonapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Calendar;
import java.util.Date;

public class AppVariableStorage {
    private static final String LAST_UPDATED_DATE = "Last Updated Date";

    public static void putCurrencyLastUpdatedDate(Context context) {

        long today = Calendar.getInstance().getTimeInMillis();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putLong(LAST_UPDATED_DATE, today).apply();
    }
    public static Date getCurrencyLastUpdatedDate(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        long dateInMillis = sp.getLong(LAST_UPDATED_DATE, 0);
        return DateUtil.toDate(dateInMillis);
    }
}
