import java.util.HashSet;
import java.util.Set;

public class Contact {
    String name;
    Set<String> emails = new HashSet<>();
    Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this.name = name;
    }

    public Contact(long phone, String name) {
        this(name, "", phone);
    }

    public Contact(String name, String email) {
       this(name, email, 0);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (!email.isEmpty()) this.emails.add(email);
        if (phone > 0){
            String convertedPhone = String.valueOf(phone);
            String result = "(" + convertedPhone.substring(0, 3) + ") "
                    + convertedPhone.substring(3, 6) + "-"
                    + convertedPhone.substring(6);
            phones.add(result);
        }
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }

    public Contact mergeContactData(Contact contact){
        Set<String> emails = new HashSet<>(contact.emails);
        emails.addAll(this.emails);

        Set<String> phones = new HashSet<>(contact.phones);
        phones.addAll(this.phones);

        Contact result = new Contact();
        result.name = this.name;
        result.emails = emails;
        result.phones = phones;

        return result;
    }
}
