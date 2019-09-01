package udemy.stacks.course;

import java.util.LinkedList;

public class StacksCourse {

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

    public static boolean checkForPalindrome(String string) {
        LinkedList<Character> list = new LinkedList<>();
        StringBuilder newString = new StringBuilder();
        string = string.replaceAll("[^a-zA-Z0-9]", "");
        for (int i = 0; i < string.length(); i++) {
            list.push(string.trim().charAt(i));
        }
        while (!list.isEmpty()) {
            newString.append(list.pop());
        }

        return newString.toString().equalsIgnoreCase(string);
    }
}

