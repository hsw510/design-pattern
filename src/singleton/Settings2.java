package singleton;

/**
 * synchronized
 * Thread Safe singleton
 * synchronized 성능 이슈
 */
public class Settings2 {

    private static Settings2 instatnce;

    private Settings2() {}

    public static synchronized Settings2 getInstance(){
        if(instatnce == null){
            instatnce = new Settings2();
        }

        return instatnce;
    }

}
