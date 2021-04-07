package by.it_academy.jd2.core.utils;
import org.apache.commons.lang3.StringUtils;

/**
 * Class Utils with next functions @see ApacheCommonsLang3#isAllLowerCase(CharSequence)
 * autor Damitry Zmachynski
 * @version 1.0
 */
public class ApacheCommonsLang3 {
    /**
     * <p>Checks if the CharSequence contains only lowercase characters.</p>
     *
     * <p>{@code null} will return {@code false}.
     * An empty CharSequence (length()=0) will return {@code false}.</p>
     *
     * <pre>
     * StringUtils.isAllLowerCase(null)   = false
     * StringUtils.isAllLowerCase("")     = false
     * StringUtils.isAllLowerCase("  ")   = false
     * StringUtils.isAllLowerCase("abc")  = true
     * StringUtils.isAllLowerCase("abC")  = false
     * StringUtils.isAllLowerCase("ab c") = false
     * StringUtils.isAllLowerCase("ab1c") = false
     * StringUtils.isAllLowerCase("ab/c") = false
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if only contains lowercase characters, and is non-null
     * @since 2.5
     * @since 3.0 Changed signature from isAllLowerCase(String) to isAllLowerCase(CharSequence)
     */
     public static boolean isAllLowerCase(CharSequence cs){
        return StringUtils.isAllLowerCase(cs);
    }
}