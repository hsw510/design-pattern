package singleton;

/**
 * Thread Safe singleton
 * 이른 초기화(eager initialization) 사용
 * 클래스 로딩시점 static 필드 초기화
 * 미리 만드는 단점, 비용 고려
 */
public class Settings3 {

    private static final Settings3 INSTANCE = new Settings3();

    private Settings3() {}

    public static Settings3 getInstance(){
        return INSTANCE;
    }

}
