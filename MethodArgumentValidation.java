package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) throws Exception{
        if(name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Name must be valid and have total length of less than 40");
        } 
        this.name = name;
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        } 
        this.age = age;


    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

package validation;

public class Calculator {

    public int multiplication(int fromInteger) {
        
        if (fromInteger < 0) {
            throw new IllegalArgumentException("illegal value passed to method");
        }
        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {

        if (setSize < 0 || subsetSize < 0 || subsetSize > setSize) {
            throw new IllegalArgumentException("invalid input");
        }
 
        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}
