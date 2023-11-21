import java.util.*;

public class BuildingConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total no of floors in the building.");
        int totalFloors = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        int[] floorSizes = new int[totalFloors];
        for (int i = 1; i <= totalFloors; i++) {
            stack.push(i);
        }
        for (int day = 1; day <= totalFloors; day++) {
            System.out.println("Enter the floor size given on day : " + day);
            floorSizes[day - 1] = scanner.nextInt();
        }
        System.out.println("\nThe order of construction is as follows\n");
        for (int day = 1; day <= totalFloors; day++) {
            int floorSize = floorSizes[day - 1];
            tempStack.push(floorSize);
            System.out.print("Day: " + day + "\n");
            while (!stack.isEmpty() && !tempStack.isEmpty() && stack.peek().equals(tempStack.peek())) {
                System.out.print(stack.pop() + " ");
                tempStack.pop();
            }
            System.out.println("\n");
        }
        scanner.close();
    }
}
