import java.util.HashSet;
import java.util.Set;

/*
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 */
public class UniqueEmail {
    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
    public static int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet();
        String email;
        for(int i=0; i< emails.length; i++){
            String[] emailContentAndDomain = emails[i].split("@");
            email = emailContentAndDomain[0];
            if(emailContentAndDomain[0].contains("+")){
                email = email.substring(0, emailContentAndDomain[0].indexOf('+'));

            }
            email = email.replaceAll("\\.", "");
            email = email + "@" + emailContentAndDomain[1];
            seen.add( email);
        }
        System.out.println(seen);
        return seen.size();
    }
}
