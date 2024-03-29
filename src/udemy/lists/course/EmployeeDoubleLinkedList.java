package udemy.lists.course;

public class EmployeeDoubleLinkedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToHead(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public void addBefore(Employee employee, Employee employeeBefore) {
        if (head == null)
            return;

        if (employeeBefore == head.getEmployee()) {
            addToHead(employee);
            return;
        } else if (employeeBefore == tail.getEmployee()) {
            addToEnd(employee);
            return;
        }

        EmployeeNode node = new EmployeeNode(employee);
        EmployeeNode searchNode = head;

        while (searchNode != null) {
            if (searchNode.getEmployee() == employeeBefore) {
                searchNode.getPrevious().setNext(node);
                node.setPrevious(searchNode.getPrevious());
                searchNode.setPrevious(node);
                node.setNext(searchNode);
                size++;
            }
            searchNode = searchNode.getNext();
        }
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty())
            return null;
        EmployeeNode removeNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public EmployeeNode removeFromEnd() {
        if (isEmpty())
            return null;
        EmployeeNode removeNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removeNode.setPrevious(null);
        return removeNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.print("null");
    }
}
