package singleton;

/**
 * static inner class
 * Thread Safe singleton
 * Traffic 유리
 * instance 필요시 생성 (lazy loading)
 *
 */
public class Settings5 {

    private Settings5() {}

    private static class SettingsHolder{
        private static final Settings5 INSTANCE = new Settings5();
    }
    public static Settings5 getInstance(){
        return SettingsHolder.INSTANCE;
    }

}
