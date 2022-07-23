package singleton;

/**
 * DCL(double checked locking)
 * Thread Safe singleton
 * Traffic 유리
 * 최초 1회만 sync 작동
 * instance 필요시 생성 (lazy initialization)
 */
public class Settings4 {

    //private static Settings4 instatnce;
    private static volatile Settings4 instatnce; //java 1.5 이상 동작

    private Settings4() {}

    public static Settings4 getInstance(){
        if(instatnce == null){
            synchronized (Settings4.class){
                if(instatnce == null){
                    instatnce = new Settings4();
                }
            }
        }

        return instatnce;
    }

}
