package com.cralor.ch3.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

/**
 * Created by cc.
 * 2018/6/13 14:08
 **/
@RestController
public class UploadController {

    @RequestMapping("file")
    public ModelAndView upload(){
        return new ModelAndView("fileUpload");
    }
    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("file")MultipartFile file) throws IOException {

        if (!file.isEmpty()){
            String filename = file.getOriginalFilename();
            InputStream in = file.getInputStream();
       //     File file1=new File("./"+filename);
            File file1=new File(ResourceUtils.getURL("classpath:").getPath()+"/static/"+filename);
            System.out.println(file1.getAbsolutePath());
            if(!file1.exists()){
                file1.createNewFile();
            }

  /*          byte[] b=new byte[1024];
            int len;
            OutputStream out =new FileOutputStream(file1);
            while((len=in.read(b))!=-1){
                out.write(b,0,len);
                out.flush();
            }
            out.close();
       */
            file.transferTo(file1);

            return "success";
        }
        return "failure";
    }
    @PostMapping("fileUploads")
    public String fileUploads(@RequestParam("files")MultipartFile[] files) throws IOException {

        if (!files[0].isEmpty()){
            for(MultipartFile file:files) {
                String filename = file.getOriginalFilename();
                InputStream in = file.getInputStream();
                //     File file1=new File("./"+filename);
                File file1 = new File(ResourceUtils.getURL("classpath:").getPath() + "/static/" + filename);
                System.out.println(file1.getAbsolutePath());
                if (!file1.exists()) {
                    file1.createNewFile();
                }
                //将上传文件保存到指定文件中
                file.transferTo(file1);
            }
            return "success";
        }
        return "failure";
    }

}
