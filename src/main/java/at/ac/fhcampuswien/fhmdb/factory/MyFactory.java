package at.ac.fhcampuswien.fhmdb.factory;

import javafx.util.Callback;

public class MyFactory implements Callback<Class<?>, Object> {
    // Todo make singleton
    @Override
    public Object call(Class<?> aClass) {
        try{
            return aClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}