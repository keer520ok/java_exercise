package practice.oop.ex14;

/**
 * 実行クラス Ex14
 */
public class Ex14 {
    public static void main(String[] args) {
        Person person = new Person("田中", 25, "男性");

        Bicycle bike = new Bicycle("GIANT", 15);
        person.driveVehicle(bike);
        bike.ringBell();
        System.out.println();
        Car car = new Car("Toyota", 80);
        person.driveVehicle(car);
        car.honk();
    }
}
