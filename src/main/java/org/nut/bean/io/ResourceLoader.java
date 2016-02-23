package org.nut.bean.io;

import java.net.URL;

/**
 * Created by abing on 2016/1/14.
 */
public class ResourceLoader {
    public InputStreamSource getResource(String location){
        URL url = this.getClass().getClassLoader().getResource(location);

        return new Resource(url);
    }
}
