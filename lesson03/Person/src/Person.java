public class Person {
    private String name;
    private int age;

//    конструктор
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hi there, I am " +
                name + " and am " + age + " years old");
    }
}
