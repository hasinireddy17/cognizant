class Car {
    String make;
    String model;
    int year;
    
    Car(String make, String model, int year){
        this.make=make;
        this.model=model;
        this.year=year;
    }

    void displayDetails(){
        System.out.println("Make: "+make);
        System.out.println("Model: "+model);
        System.out.println("Year: "+year);
    }
}
public class Class_Object_creation{
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020);
        Car car2 = new Car("Honda", "Civic", 2019);

        System.out.println("Car 1 details:");
        car1.displayDetails();

        System.out.println();
        
        System.out.println("Car 2 details:");
        car2.displayDetails();
    }
}
