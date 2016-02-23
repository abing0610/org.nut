package org.nut.bean.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 仿照spring的类进行编写的  获取资源输入流的类
 *
 * Created by abing on 2016/1/14.
 */
public interface InputStreamSource {

    InputStream getInputStream() throws IOException;

}
