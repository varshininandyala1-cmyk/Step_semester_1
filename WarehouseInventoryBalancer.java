import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        for (int value : sectionA) {
            totalA += value;
        }

        for (int value : sectionB) {
            totalB += value;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int max = Integer.MIN_VALUE;
        String section = "";
        int index = 0;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "Section A";
                index = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "Section B";
                index = i + 1;
            }
        }

        System.out.println(
            "Section A Total: " + totalA
            + " | Section B Total: " + totalB
            + " | Status: " + status
            + " | Highest Quantity: " + max
            + " (" + section + ", Item " + index + ")"
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        for (int i = 0; i < n; i++) {
            sectionA[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sectionB[i] = sc.nextInt();
        }

        analyzeInventory(sectionA, sectionB);
        sc.close();
    }
}