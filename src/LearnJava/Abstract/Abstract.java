package LearnJava.Abstract;

/*
 * An abstract class in Java is a class that is declared with the abstract keyword. 
 * It serves as a blueprint for other classes and cannot be instantiated directly, 
 * meaning you cannot create objects of an abstract class.

Key characteristics of an abstract class:
- Cannot be instantiated:
- You cannot use the new keyword to create an object of an abstract class.
- Can contain abstract methods:
- An abstract class can declare abstract methods, which are methods without a body (implementation). 
- These methods are declared with the abstract keyword and end with a semicolon, like abstract void draw();.
- Can contain concrete methods:
- Abstract classes can also have regular (non-abstract) methods with full implementations.
- Can contain fields and constructors:
- Like regular classes, abstract classes can have fields (instance variables) and constructors.
- Must be subclassed:
- To use an abstract class, it must be extended by another class (a subclass).
- Subclasses must implement abstract methods:
- If a subclass extends an abstract class, it must either provide concrete implementations for all inherited abstract methods or be declared as abstract itself.

Purpose of Abstract Classes:
Abstract classes are primarily used to achieve abstraction and polymorphism in Java. They define a common interface and potentially some shared functionality for a group of related classes, while leaving specific implementations to their subclasses. This promotes code reusability and ensures that certain methods are implemented by all subclasses.

*/

public class Abstract {
	
	public static void main(String args[]) {
		Circle c = new Circle("red", 4.5);
		c.displayColor();
		System.out.println("It has edges: " + c.edges());
	}

}

abstract class Shape {
    String color;

    // Constructor
    public Shape(String color) {
        this.color = color;
    }

    // Abstract method (no implementation)
    public abstract void draw();
    
 // Abstract method (no implementation)
    public abstract int edges();

    // Concrete method (with implementation)
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Implementing the abstract method from Shape
    @Override
    public void draw() {
        System.out.println("Drawing a circle of color " + color + " with radius " + radius);
    }
    
    // Implementing the abstract method from Shape
    public int edges() {
    	return 0;
    }
}
