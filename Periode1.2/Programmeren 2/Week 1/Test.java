import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Contact Jeff = new Contact("Jeff");
        Contact Piet = new Contact("Piet");

        ContactList contactList = new ContactList();
        contactList.addContact(Piet);
        contactList.addContact(Jeff);

        System.out.println(contactList.getContactByName("Piet"));
    }
}
