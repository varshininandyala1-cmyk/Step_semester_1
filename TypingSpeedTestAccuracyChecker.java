import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = original.length() == 0
                ? (typed.length() == 0 ? 100.0 : 0.0)
                : (matched * 100.0 / original.length());

        System.out.printf(
            "Matched: %d/%d | Accuracy: %.2f%%",
            matched, original.length(), accuracy
        );

        if (firstMismatch == -1 && original.length() == typed.length()) {
            System.out.println(" | No Mismatches");
        } else if (firstMismatch != -1) {
            System.out.printf(
                " | First Mismatch at position %d ('%c' vs '%c')%n",
                firstMismatch + 1,
                original.charAt(firstMismatch),
                typed.charAt(firstMismatch)
            );
        } else {
            System.out.printf(
                " | Length Mismatch at position %d%n",
                length + 1
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String original = sc.nextLine();
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);
        sc.close();
    }
}