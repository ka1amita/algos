package src.hackerrank;

public class CamelCase {
    public static void main(String[] args) {
        String input = "saveChangesInTheEditor";

        System.out.println(solveWithCharacterCode(input));
        System.out.println(solveWithCharacterIsUpperCaseForEachLoop(input));
        System.out.println(solveWithCharacterIsUpperCaseForLoop(input));
    }
    public static int solveWithCharacterCode(String s) {
        int count = 1;
        for (char c : s.toCharArray()) {
            if (c <= 'Z' && c >= 'A') {
                count++;
            }
        }
        return count;
    }

    public static int solveWithCharacterIsUpperCaseForEachLoop(String s) {
        int count = 1;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static int solveWithCharacterIsUpperCaseForLoop(String s) {
        int count = 1;
        // TODO PRACTICE I used `,` instead of `;`!
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
