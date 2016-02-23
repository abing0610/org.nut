package org.select;

import org.egf.Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Created by abing on 2016/1/31.
 */
public class App {

    public static final String DIR = "D:\\egfbank\\yxlog\\xian\\select";
    public static final String INSERT = "INSERT INTO";
    public static final String CHECK_LOCK ="CHECK_LOCK_INFO";
    public static final String DIRFILE = "D:\\egfbank\\yxlog\\xian\\select\\sql\\00.txt";

    public static void getSQL() throws IOException {

        File dir = new File(DIR);
        File[] files = dir.listFiles();

        for (File file : files){
            if (file.isDirectory()){
                continue;
            }
            BufferedReader br = Common.getBufferedReader(file.toString());
            String str = null;
            while ((str = br.readLine()) != null){
                if (str.indexOf(CHECK_LOCK) >= 0){
                    continue;
                }
                if (str.indexOf(INSERT) >= 0){
//                    String[] strings = str.split("],");
//                    System.out.println();
                    dealStr(str);
                }
            }

        }
    }

    public static void dealStr(String str){
        String[] strings = str.split("],");
        String sql = strings[0].trim().substring(1).trim() + ";\n";

        Common.writeTOFILE(sql , DIRFILE);


    }

    public static void main(String[] args) throws IOException {

        getSQL();

//        String str = "[INSERT INTO XDFRKHZL_1 ( CONTENT_STATUS, SERVER_ID, BUSI_SERIAL_NO, VERSION, ANNO_PATH, CHECK_FLAG, IS_ACTIVE, AMOUNT, BUSI_START_DATE, MIGRATION_STATUS, CHECK_USER, CHECK_TIME, UPLOAD_TIME, BASE_VERSION, NEAR_PATH, UPLOAD_USER, CONTENT_ID, RECEIVE_TIME, GROUP_ID, BUSI_END_DATE ) SELECT 1, SERVER_ID,'133437', 6 AS VERSION, ANNO_PATH, CHECK_FLAG, IS_ACTIVE,253,'20131103', 1, CHECK_USER, CHECK_TIME, UPLOAD_TIME, BASE_VERSION, NEAR_PATH, UPLOAD_USER, CONTENT_ID, RECEIVE_TIME, GROUP_ID,'' FROM XDFRKHZL_1 WHERE GROUP_ID = '1' AND CONTENT_ID = '20130205_000_000_C6EC8BC5-540B-614C-A73E-7A514E14813C-1' AND VERSION= (SELECT max(VERSION) FROM XDFRKHZL_1 WHERE CONTENT_ID='20130205_000_000_C6EC8BC5-540B-614C-A73E-7A514E14813C-1') AND EXISTS (SELECT CONTENTID FROM CHECK_LOCK_INFO WHERE CONTENTID = '20130205_000_000_C6EC8BC5-540B-614C-A73E-7A514E14813C-1')], params=[],affectNum=[1],flag=[true], ";
//        dealStr(str);
    }
}
