import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator {

    private final static Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private final static Pattern phonePattern = Pattern.compile("^\\+375 ?((29)|(33)|(44)) ?[\\d]{3}[ -]?[\\d]{2}[ -]?[\\d]{2}$");

    public static boolean validateEmail(String vString) {
        Matcher m = emailPattern.matcher(vString);
        return m.find();
    }

    public static boolean validatePhone(String vString) {
        Matcher m = phonePattern.matcher(vString);
        return m.find();
    }


}
