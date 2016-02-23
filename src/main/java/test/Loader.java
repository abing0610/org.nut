package test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by abing on 2016/1/18.
 */
public class Loader extends URLClassLoader {

    public Loader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
