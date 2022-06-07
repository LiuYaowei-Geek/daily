package com.lyw.sout;

import java.io.*;

import org.codehaus.plexus.util.IOUtil;
import org.apache.commons.codec.binary.Base64;

/**
 * @author liuyaowei488
 * @date created in 2019-9-4 20:19
 */
public class DirectorySout {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            String path = "I:\\workspace\\casdoc.txt";
            File file = new File(path);
            byte[] code = getBytefromFile(file);

//            String encodeBase64 =  Base64.encodeBase64String(code);
//            System.out.println(encodeBase64);
            byte[] decodeBase64 = Base64.decodeBase64(code);

            fos = new FileOutputStream("I:\\workspace\\casdoc.7z");
            fos.write(decodeBase64);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(fos);
        }

    }

    public static byte[] getBytefromFile(File file) throws IOException {
        byte[] bytes = null;
        if (file == null) {
            return bytes;
        }
        InputStream is = null;
        try {
            int length = (int) file.length();
            if (length > Integer.MAX_VALUE) {
//                logger.info("overflow.getBytefromFile.");
                return bytes;
            }
            is = new FileInputStream(file);
            bytes = new byte[length];
            int offset = 0;
            int numRead = 0;

            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
        } catch (Exception e) {
//            logger.error("FileEncryptServiceImpl.getBytefromFile error", e);
        } finally {
            IOUtil.close(is);
        }
        return bytes;
    }
}