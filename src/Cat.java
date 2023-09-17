@VeryImportant
public class Cat implements Animal {
    @ImportantString
    String name = "tom";
    @RunImmediately(times = 3) //overiding the times given in annotation class
    void sound(){
        System.out.println("Meow....");
    }
}
