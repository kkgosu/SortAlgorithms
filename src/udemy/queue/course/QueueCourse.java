package udemy.queue.course;

import java.util.LinkedList;

public class QueueCourse {
    public static void main() {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    private static boolean checkForPalindrome(String string) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();

        string = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            queue.addLast(string.trim().charAt(i));
            stack.push(string.trim().charAt(i));
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst()))
                return false;
        }

        return true;
    }
}
