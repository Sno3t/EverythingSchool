import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ContactList {
    private Map<String, Contact> contacts2 = new HashMap<String, Contact>();

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public ContactList() {
    }

    public void addContact(Contact contact) {
        this.contacts2.put(contact.getName().trim().toLowerCase(), contact);
    }

    public Contact getContactByName(String name) {
        return contacts2.get(name.trim().toLowerCase());
    }


//    public void addContact(Contact contact) {
//        this.contacts.add(contact);
//    }
//
//    public Contact getContactByName(String name) {
//        for (int i = 0; i < contacts.size(); i++) {
//            if (Objects.equals(contacts.get(i).getName(), name)) {
//                return contacts.get(i);
//            }
//        }
//        return null;
//    }


}
