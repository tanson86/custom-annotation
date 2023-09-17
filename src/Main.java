import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat= new Cat();
        checkIsImportant(cat);
        Dog dog = new Dog();
        checkIsImportant(dog);

        for(Method method:cat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately ri = method.getAnnotation(RunImmediately.class);
                for(int t=0;t<ri.times();t++)
                    method.invoke(cat);
            }
        }

        for(Field field:cat.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportantString.class)){
                Object obj = field.get(cat);
                if(obj instanceof String stringValue)
                    System.out.println(stringValue.toUpperCase());
            }
        }
    }

    public static void checkIsImportant(Animal animal){
        if(animal.getClass().isAnnotationPresent(VeryImportant.class))
            System.out.println("This is important");
        else
            System.out.println("Not important");
    }
}
