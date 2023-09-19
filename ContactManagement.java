package prodigyInfoTech;
                                                    // PRODIGY_SD_03  Contact Management System
import java.util.ArrayList;
import java.util.Scanner;

class ContactBook{
    private String name, phoneNo, email;
    ContactBook(String name, String phoneNo, String email){
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: "+getName()+"\n"+"Phone No: "+getPhoneNo()+"\n"+"Email: "+getEmail()+"\n";
    }
}

public class ContactManagement {
    public static Scanner sc = new Scanner(System.in);
    private final ArrayList<ContactBook> store;
    ContactManagement(){
        store = new ArrayList<>();
    }
    public void addContact(){
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.println("Enter email id: ");
        String email = sc.nextLine();
        ContactBook cb = new ContactBook(name,phone,email);
        store.add(cb);
        System.out.println("Contact added successfully!");
    }
    public void displayContact(){
        System.out.println("----------------Contact List------------------");
        if (store.isEmpty()){
            System.out.println("Empty!");
            return;
        }

        for (ContactBook contactBook : store) {
            System.out.println(contactBook);
        }
        System.out.println("--------------------End------------------------");
    }
    public void editContact(){
        System.out.println("Enter the name of the contact to edit: ");
        String name = sc.nextLine();
        boolean match = false;
        for (ContactBook contactBook : store){
            if (contactBook.getName().equalsIgnoreCase(name)){
                System.out.println("Enter new name: ");
                String newName = sc.nextLine();
                contactBook.setName(newName);
                System.out.println("Enter new phone number: ");
                String newPhone = sc.nextLine();
                contactBook.setPhoneNo(newPhone);
                System.out.println("Enter new email: ");
                String newEmail = sc.nextLine();
                contactBook.setEmail(newEmail);
                System.out.println("Contact edited successfully!");
                match = true;
                break;
            }
        }
        if (!match){
            System.out.println("Contact not found!");
        }
    }

    public void deleteContact(){
        System.out.println("Enter the name of the contact to delete: ");
        String name = sc.nextLine();
        boolean match = false;
        for (ContactBook contactBook : store){
            if (contactBook.getName().equalsIgnoreCase(name)){
                store.remove(contactBook);
                System.out.println("Contact deleted successfully!");
                match = true;
                break;
            }
        }
        if (!match){
            System.out.println("Contact not found!");
        }
    }

    public static void main(String[] args) {

        ContactManagement cm = new ContactManagement();

        while (true){
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    cm.addContact();
                    break;
                case 2:
                    cm.displayContact();
                    break;
                case 3:
                    cm.editContact();
                    break;
                case 4:
                    cm.deleteContact();
                    break;
                case 5:
                    System.out.println("Exit.....");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!!! TRY AGAIN");
            }
        }
    }
}
