package cn.oureda.util;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传的相关操作
 */
public class UploadHelper_OMG {


    public static boolean upload(HttpServletRequest request, CommonsMultipartFile Ufile) {
        String str = request.getServletContext().getRealPath("/view/images/");
        str += Ufile.getOriginalFilename();
        File file1 = new File(str);
        System.out.println(file1.getAbsolutePath());
        try {
            file1.createNewFile();
            Ufile.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
