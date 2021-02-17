import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Solution_1360 {
    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            return Math.toIntExact(Math.abs((d2.getTime() - d1.getTime()) / 86400000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}