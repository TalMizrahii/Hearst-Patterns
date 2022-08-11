import java.util.regex.Pattern;


/**
 * a class which compile and store the regexes of the assignment.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public class RegIncluding {

    private static final String FIND_HYPO = "<np>([^<]*)<\\/np>";
    private static final String INC_ESP = "<np>([^<]*)<\\/np> ?(, ?)?(including|especially|such as) ?<np>([^<]*)"
            +
            "<\\/np>( ?(, ?<np>([^<]*)<\\/np> ?)*(, ?)?(and|or)? ?<np>([^<]*)<\\/np>)?| ?such ?<np>([^<]*)"
            +
            "<\\/np> ?as ?<np>([^<]*)<\\/np>( ?(, ?<np>([^<]*)<\\/np> ?)*( ?, ?)?(and|or)? ?<np>([^<]*)<\\/np>)?|"
            +
            "<np>([^<]*)<\\/np> ?(, ?)?which is ?((an example|a kind|a class) ?(of)?)? ?<np>([^<]*)<\\/np>";

    /**
     * a default constructor.
     */
    public RegIncluding() {
        //currently empty
    }

    /**
     * a getter for the main pattern.
     *
     * @return the main pattern.
     */
    public Pattern getPattern() {
        return Pattern.compile(INC_ESP, Pattern.CASE_INSENSITIVE);
    }

    /**
     * a getter for the hypo pattern.
     *
     * @return the hypo pattern.
     */
    public Pattern getHypo() {
        return Pattern.compile(FIND_HYPO, Pattern.CASE_INSENSITIVE);
    }


}
