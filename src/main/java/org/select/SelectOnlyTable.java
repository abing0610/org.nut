package org.select;

import org.egf.Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Created by abing on 2016/1/31.
 */
public class SelectOnlyTable {

    public static final String DIR = "D:\\egfbank\\okbak\\insert\\sql\\00.txt";

    public static final String FINDSTR = "YW_XDLDZJDK_P_3";
    public static final String TABLEDIR = "D:\\egfbank\\table\\xd_3.txt";

    public static void findTable() throws IOException {
//        File file = new File(DIR);
        BufferedReader br = Common.getBufferedReader(DIR);

        String str = null;
        while ((str = br.readLine()) != null ){
            if (str.indexOf(FINDSTR) > 0){
//                System.out.println();
                Common.writeTOFILE(str +"\n" , TABLEDIR);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        findTable();
    }

}
