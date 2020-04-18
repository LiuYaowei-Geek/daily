package com.lyw.sout;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.plexus.util.IOUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author liuyaowei488
 * @date created in 2019-10-3 10:21
 */
public class FileListSout {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\workspace\\xhl";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        FileOutputStream fos = null;
        for (File f : fs) {                    //遍历File[]数组

            FileOutputStream fos1 = new FileOutputStream(new File(String.format("D:\\workspace\\xhl\\%s", f.getName())));
            ZipDirectorySout.toZip(String.format("D:\\workspace\\xhlZip\\%s.zip", f.getName()), fos1, true);
//
//
            String fileName = f.getName();
            System.out.println(f);
            try {
                byte[] code = ReadDirectory.getBytefromFile(f);

                String encodeBase64 = Base64.encodeBase64String(code);
                System.out.println(fileName);
                FileUtil.writeUtf8String(encodeBase64, String.format("D:\\workspace\\lywCopy\\%s.txt", fileName.substring(0, fileName.indexOf("."))));

//                byte[] decodeBase64 = Base64.decodeBase64("UEsDBBQACAgIAIeVa1AAAAAAAAAAAAAAAAASAAAA6IKW6KGh5Li9LnppcC56aXAvAwBQSwcIAAAAAAIAAAAAAAAAUEsBAhQAFAAICAgAh5VrUAAAAAACAAAAAAAAABIAAAAAAAAAAAAAAAAAAAAAAOiCluihoeS4vS56aXAuemlwL1BLBQYAAAAAAQABAEAAAABCAAAAAAA=");
//                fos = new FileOutputStream(String.format("D:\\workspace\\lywZip\\%s.docx", "xhl"));
//                fos.write(decodeBase64);
//                fos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IOUtil.close(fos);
            }
        }
    }
}
