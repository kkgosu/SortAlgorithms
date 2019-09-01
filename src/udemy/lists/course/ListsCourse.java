package udemy.lists.course;

public class ListsCourse {

    public static void main() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToHead(janeJones);
        list.addToHead(johnDoe);
        list.addToHead(marySmith);
        list.addToHead(mikeWilson);
    }
}
