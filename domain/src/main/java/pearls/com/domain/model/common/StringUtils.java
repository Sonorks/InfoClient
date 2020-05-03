package pearls.com.domain.model.common;

public class StringUtils {

    public static boolean validateStringUsingRegexp(String string, String regexp){
        return string != null && !string.isEmpty() && string.matches(regexp);
    }
}
