package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceRun {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Service service = new Service();

        Method[] declareMethods = service.getClass().getDeclaredMethods();

        for (Method m : declareMethods) {
            if(m.isAnnotationPresent(PrintAnnotation.class)){
                System.out.println("{{{"+m.getName()+"}}}");

                PrintAnnotation annotation = m.getAnnotation(PrintAnnotation.class);

                for(int i=0; i <annotation.number(); i++){
                    System.out.print(annotation.value());
                }
                System.out.println();
            }
            m.invoke(service);
        }
    }
}
