import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> phoneData = List.of(
                "Charlie Brown, 3334445555",
                "Maid Marion, 1234567890",
                "Mickey Mouse, 9998887777",
                "Mickey Mouse, 1247489758",
                "Minnie Mouse, 4567805666",
                "Robin Hood, 5647893000",
                "Robin Hood, 7899028222",
                "Lucy Van Pelt, 5642086852",
                "Mickey Mouse, 9998887777"
        );
        List<String> emailData = List.of(
            "Mickey Mouse, mckmouse@gmail.com",
            "Mickey Mouse, micky1@aws.com",
            "Minnie Mouse, minnie@verizon.net",
            "Robin Hood, rhood@gmail.com",
            "Linus Van Pelt, lvpelt2015@gmail.com",
            "Daffy Duck, daffy@google.com"
        );

        HashMap<String, Contact> map = new HashMap<>();
        for (String item : phoneData){
            String name = item.split(", ")[0];
            long phone = Long.parseLong(item.split(", ")[1]);
            Contact contact = new Contact(name, "", phone);
            if (map.containsKey(name)) {
                map.put(name, map.get(name).mergeContactData(contact));
            } else {
                map.put(name, contact);
            }
        }

        for (String item : emailData){
            String name = item.split(", ")[0];
            String email = item.split(", ")[1];
            Contact contact = new Contact(name, email, 0);
            if (map.containsKey(name)) {
                map.put(name, map.get(name).mergeContactData(contact));
            } else {
                map.put(name, contact);
            }
        }

        var contacts = map.values();
        System.out.println(map.values());
    }
}