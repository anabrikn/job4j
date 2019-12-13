package ru.job4j.addresslist;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

public class ProfilesTest {
    @Test
    public void whenTouristsHaveDifferentAddresses() {
        Profile traveler1 = new Profile("Одинцово", "Молодёжная", 2, 5);
        Profile traveler2 = new Profile("Одинцово", "Молодёжная", 4, 5);
        Profile traveler3 = new Profile("Одинцово", "Молодёжная", 6, 5);
        Profile traveler4 = new Profile("Одинцово", "Молодёжная", 10, 5);
        Profile traveler5 = new Profile("Одинцово", "Молодёжная", 14, 5);
        Profile traveler6 = new Profile("Одинцово", "Молодёжная", 18, 5);
        Profile traveler7 = new Profile("Одинцово", "Молодёжная", 22, 5);
        Profile traveler8 = new Profile("Одинцово", "Молодёжная", 26, 5);
        Profile traveler9 = new Profile("Одинцово", "Молодёжная", 28, 5);
        List<Profile> travelers = Arrays.asList(
                traveler1, traveler2, traveler3,
                traveler4, traveler5, traveler6,
                traveler7, traveler8, traveler9
        );
        Profiles pf = new Profiles();
        List<Address> addresses = pf.collect(travelers);
        List<Address> expected = Arrays.asList(
                traveler1.getAddress(), traveler2.getAddress(), traveler3.getAddress(),
                traveler4.getAddress(), traveler5.getAddress(), traveler6.getAddress(),
                traveler7.getAddress(), traveler8.getAddress(), traveler9.getAddress());
        assertTrue(expected.containsAll(addresses));
    }

    @Test
    public void whenSomeTouristsHaveSameAddresses() {
        Profile traveler1 = new Profile("Брянск", "Ленина", 2, 5);
        Profile traveler2 = new Profile("Брянск", "Ленина", 2, 5);
        Profile traveler3 = new Profile("Челябинск", "Ленина", 2, 5);
        Profile traveler4 = new Profile("Омск", "Ленина", 10, 5);
        Profile traveler5 = new Profile("Сочи", "Ленина", 14, 5);
        Profile traveler6 = new Profile("Сочи", "Ленина", 14, 5);
        Profile traveler7 = new Profile("Хабаровск", "Ленина", 22, 5);
        Profile traveler8 = new Profile("Одинцово", "Молодёжная", 28, 5);
        Profile traveler9 = new Profile("Одинцово", "Молодёжная", 28, 5);
        List<Profile> travelers = Arrays.asList(
                traveler1, traveler2, traveler3,
                traveler4, traveler5, traveler6,
                traveler7, traveler8, traveler9
        );
        Profiles pf = new Profiles();
        List<Address> addresses = pf.collect(travelers);
        List<Address> expected = Arrays.asList(
                traveler1.getAddress(), traveler8.getAddress(), traveler4.getAddress(),
                traveler5.getAddress(), traveler7.getAddress(), traveler3.getAddress());
        assertEquals(expected, addresses);
    }
}
