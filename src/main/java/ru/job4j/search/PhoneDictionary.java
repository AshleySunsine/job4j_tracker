package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    @SuppressWarnings({"checkstyle:RightCurly", "checkstyle:EmptyStatement", "CheckStyle"})
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person item : persons)
        {
           if (item.getName().contains(key)) result.add(item);
           if (item.getPhone().contains(key)) result.add(item);
            if (item.getAddress().contains(key)) result.add(item);
            if (item.getSurname().contains(key)) result.add(item);
        };
        return result;
    }
}