package org.nut.bean.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * ����spring������б�д��  ��ȡ��Դ����������
 *
 * Created by abing on 2016/1/14.
 */
public interface InputStreamSource {

    InputStream getInputStream() throws IOException;

}
