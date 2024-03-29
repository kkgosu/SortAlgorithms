package udemy.hashtable.course;

import udemy.stacks.course.Employee;

public class SimpleHashTable {

    private StoredEmployee[] hashtable;

    SimpleHashTable() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee value) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }
        if (occupied(hashedKey)) {
            System.out.println("Sorry there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, value);
        }
    }

    private boolean occupied(int hashkey) {
        return hashtable[hashkey] != null;
    }

    public Employee remove(String key) {
        int hashKey = findKey(key);
        if (hashKey == -1)
            return null;
        Employee employee = hashtable[hashKey].value;
        hashtable[hashKey] = null;

        StoredEmployee[] oldHashTable = hashtable;
        hashtable = new StoredEmployee[oldHashTable.length];
        for (int i = 0; i < hashtable.length; i++) {
            if (oldHashTable[i] != null) {
                put(oldHashTable[i].key, oldHashTable[i].value);
            }
        }
        return employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    public void printHashtable() {
        for (StoredEmployee i : hashtable) {
            System.out.println(i.value);
        }
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }
}
