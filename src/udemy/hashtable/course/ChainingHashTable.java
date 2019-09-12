package udemy.hashtable.course;

import udemy.stacks.course.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingHashTable {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainingHashTable() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee value) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, value));
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while (iterator.hasNext()) {
            employee = iterator.next();
            index++;
            if (employee.key.equals(key)) {
                break;
            }
        }

        if (employee == null && !employee.equals(key)) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return employee.value;
        }
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()) {
            employee = iterator.next();
            if (employee.key.equals(key)) {
                return employee.value;
            }
        }

        return null;
    }

    public void printHashTable() {
        for (LinkedList<StoredEmployee> storedEmployees : hashtable) {
            for (StoredEmployee storedEmployee : storedEmployees) {
                System.out.println(storedEmployee.value);
            }
        }
    }

    private int hashKey(String key) {
        return Math.abs(key.hashCode() % hashtable.length);
    }
}
