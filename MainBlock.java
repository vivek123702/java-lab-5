import java.util.Scanner;

interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

abstract class RainySeasonConservation implements WaterConservationSystem {
    // Abstract class for future common behavior
}

class CityBlockConservation extends RainySeasonConservation {

    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        if (blockHeights == null || blockHeights.length == 0) {
            return 0;
        }

        int n = blockHeights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        // Calculate the trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return trappedWater;
    }
}

public class MainBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CityBlockConservation conservationSystem = new CityBlockConservation();

        System.out.println("Enter the number of blocks:");
        int numBlocks;
        while (true) {
            if (scanner.hasNextInt()) {
                numBlocks = scanner.nextInt();
                if (numBlocks > 0) {
                    break;
                } else {
                    System.out.println("Number of blocks must be a positive integer. Please try again:");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer:");
                scanner.next(); // Clear invalid input
            }
        }

        int[] blockHeights = new int[numBlocks];
        System.out.println("Enter the heights of the blocks (non-negative integers):");

        for (int i = 0; i < numBlocks; i++) {
            while (true) {
                if (scanner.hasNextInt()) {
                    int height = scanner.nextInt();
                    if (height >= 0) {
                        blockHeights[i] = height;
                        break;
                    } else {
                        System.out.println("Height must be a non-negative integer. Please try again:");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a non-negative integer:");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        // Calculate and display the trapped water volume
        int trappedWater = conservationSystem.calculateTrappedWater(blockHeights);
        System.out.println("Total trapped water: " + trappedWater + " units");
        scanner.close();
    }
}
