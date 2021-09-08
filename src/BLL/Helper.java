package BLL;


import java.time.LocalDate;
import java.util.Date;

public abstract class Helper {


    public static String getCurrentDate() {
        return LocalDate.now().toString();
    }
}
