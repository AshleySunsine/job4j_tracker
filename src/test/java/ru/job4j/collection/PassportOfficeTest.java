package ru.job4j.collection;

import org.junit.Test;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDublicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenDubl = new Citizen("2f44a", "Olga Buzova");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizenDubl);
        assertThat(office.get("2f44a").getUsername(), is("Petr Arsentev"));
    }
}