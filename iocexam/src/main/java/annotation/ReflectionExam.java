package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExam {
    public static void main(String[] args) throws Exception{
        Class<?> personClass = Class.forName("annotation.Person");
        Object personInstance = personClass.getDeclaredConstructor().newInstance();

        System.out.println(personInstance);

        Field nameFiled = personClass.getDeclaredField("name");
        nameFiled.setAccessible(true);
        nameFiled.set(personInstance,"carami");

        System.out.println(personInstance);

        Method method = personClass.getDeclaredMethod("sayHello");
        method.setAccessible(true);
        method.invoke(personInstance);
    }
}
