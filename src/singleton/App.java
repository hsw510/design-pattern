package singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * 싱글턴패턴 main
 * https://www.notion.so/hsw510/333ae21e74c048878cf4597dfe8fc176
 */
public class App {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Settings settings = Settings.getInstance();
        Settings settings1 = Settings.getInstance();

        System.out.println("(settings == settings1) = " + (settings == settings1));

        Settings settings2 = Settings.getInstance();

        //싱글톤 깨트리기1 - 리플랙션
        Constructor<Settings> constructor = Settings.class. getDeclaredConstructor();
        constructor.setAccessible(true);
        //Settings6 settings6  = constructor.newInstance();
        Settings6 settings6  = Settings6.INSTANCE;

//        Settings6 settings7 = Settings6.INSTANCE;

  //      System.out.println("(settings6 == settings7) = " + (settings7 == settings6));

        Settings6 settings8 = null;
        //싱글톤 깨트리기2 - 직렬화 & 역직렬화
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))){
            out.writeObject(settings6);
        }
        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))){
            settings8 = (Settings6) in.readObject();
        }
        System.out.println("(settings6 == settings8) = " + (settings6 == settings8));


        /**
         * 사용예시
         */
        Runtime runtime = Runtime.getRuntime(); //자바 Application 실행 환경, 문맥

        //엄밀히 sintgleton scope, 패턴과 다름, instance를 applicaitoncontext 내에서 유일하게 관리
        //domain object 구현, 서비스나 리파지토리 빈으로 등록
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        //String hello = applicationContext.getBean("hello", String.class);
        //String hello2 = applicationContext.getBean("hello", String.class);

    }
}
