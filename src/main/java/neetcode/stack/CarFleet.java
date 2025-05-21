package neetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public static void main(String[] args) {
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int target = 12;

        System.out.println(carFleetStack(position, speed, target));
        System.out.println(carFleetArray(position, speed, target));

        position = new int[]{3};
        speed = new int[]{3};
        target = 10;
        System.out.println(carFleetStack(position, speed, target));
        System.out.println(carFleetArray(position, speed, target));
    }

    private static int carFleetArray(int[] position, int[] speed, int target) {
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car((double) (target - position[i]) / speed[i], position[i]);
        }
        Arrays.sort(cars);
        int fleet = 0;
        double prev = 0;
        for (int i = cars.length - 1; i >= 0; i--) {
            double curr = cars[i].time;
            if (prev < curr) {
                fleet++;
                prev = curr;
            }

        }
        return fleet;
    }
//     0, 3, 5, 8, 10
//    12, 3, 7, 1, 1
    private static int carFleetStack(int[] position, int[] speed, int target) {
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car((double) (target - position[i]) / speed[i], position[i]);
        }

        int count = 0;
        Stack<Double> stack = new Stack<>();
        Arrays.sort(cars);
//        System.out.println(Arrays.toString(cars));
        for (int i = cars.length - 1; i >= 0; i--) {
            stack.push(cars[i].time);
            while (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }

    private record Car(double time, int pos) implements Comparable<Car> {

        @Override
        public int compareTo(Car o) {
            return this.pos - o.pos;
        }
    }


}
