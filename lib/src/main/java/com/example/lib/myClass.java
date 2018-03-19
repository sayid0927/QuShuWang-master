package com.example.lib;

import java.util.regex.Pattern;

public class myClass {


    public static void main(String args[]) {
        String d= "华丽的外出HD1280高清韩语中字:thunder://QUFlZDJrOi8vfGZpbGV8JUU1JThEJThFJUU0JUI4JUJEJUU3JTlBJTg0JUU1JUE0JTk2JUU1JTg3JUJBLkhEMTI4MCVFOSVBQiU5OCVFNiVCOCU4NSVFOSU5RiVBOSVFOCVBRiVBRCVFNCVCOCVBRCVFNSVBRCU5Ny5tcDR8MTI4NTA5NzEwNHw2RjdCMTExMDZDNjkwMDBCMDk2OEY2MENEOTI5Q0MzMXxoPUdTQVFEUERQQktXNElZRkE1VFNFQ0xLRE4yT1ZCRVBDfC9aWg==";

      isMp3Url(d);

    }


    public static boolean isMp3Url(String url) {
        Pattern exp = Pattern.compile("^thunder://", Pattern.CASE_INSENSITIVE);
        return exp.matcher(url).matches();
    }
}
