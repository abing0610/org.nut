package org.nut.bean.io;

//import java.io.InputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 加载资源信息
 *
 *
 * Created by abing on 2016/1/14.
 */
public class Resource implements InputStreamSource {

    private final URL url;

    public Resource(URL url){
        this.url = url;
    }

    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
