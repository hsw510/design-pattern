package singleton;

import java.io.Serializable;

/**
 * 고전적 방식
 * MultiThread Issue
 */
public class Settings implements Serializable {

    private static Settings instatnce;

    private Settings() {}

    public static Settings getInstance(){
        if(instatnce == null){
            instatnce = new Settings();
        }

        return instatnce;
    }
// 직렬화&역직렬화 대응
//    protected Object readResolve(){
//        return getInstance();
//    }
}
