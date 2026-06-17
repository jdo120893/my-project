package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.Book;
import sample.bean.Dice;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
//        MyBean myBean = new MyBean();
//        myBean.setName("kang");
//        System.out.println(myBean.getName());

        System.out.println("공장생성전!!");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
        System.out.println("공장생성후!!");

        MyBean bean1 = (MyBean)context.getBean("myBean");
        bean1.setName("kang");
        System.out.println(bean1.getName());

        Book book = context.getBean(Book.class);
        System.out.println(book);

        MyBean bean2 = context.getBean("myBean",MyBean.class);
        bean2.setName("carami");
        System.out.println(bean2.getName());

        System.out.println(bean1.getName());

        MyBean bean3 = context.getBean("myBean2",MyBean.class);
        bean3.setName("kim");
        System.out.println(bean3.getName());

        System.out.println(bean1.getName());

        if(bean1 == bean2)
            System.out.println("같은 객체");

        if(bean1 != bean3)
            System.out.println("다른 객체");

        MyBean bean4 = context.getBean("myBean3",MyBean.class);
        bean4.setName("lee");

        System.out.println(bean4.getName());

        MyBean bean5 = context.getBean("myBean3",MyBean.class);
        if(bean5 == bean4)
            System.out.println("같다");
        else
            System.out.println("다르다");

        Dice dice = context.getBean("dice",Dice.class);
        System.out.println(dice.getNumber());

        Dice dice2 = context.getBean("dice2",Dice.class);
        System.out.println(dice2.getNumber());

        Dice dice3 = context.getBean("dice3",Dice.class);
        System.out.println(dice3.getNumber());

    }
}
