package ru.job4j.addresslist;

public class Profile {
    private Address address;

    public Profile(String city, String street, int home, int apartment) {
        this.address = new Address(city, street, home, apartment);

    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Profile{" + "address=" + address.toString() + '}';
    }
}
