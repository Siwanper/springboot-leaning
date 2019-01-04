package com.swp.springbootfileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-04 2:49 PM
 */
@Controller
public class UploadController {

    private static final String UPLOAD_FILE_FOLD = "/Users/ios/Desktop/upload/";

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "upload";
    }

    @RequestMapping(value = "/more", method = RequestMethod.GET)
    public String more(){
        return "uploadMore";
    }

    @RequestMapping(value = {"/uploadStatus"}, method = RequestMethod.GET)
    public String uploadStatus(){
        return "uploadStatus";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(name = "file") MultipartFile file, RedirectAttributes attributes) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "please select valiable file");
            return "redirect:/uploadStatus";
        }

        try {
            Path path = Paths.get(UPLOAD_FILE_FOLD + file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Files.write(path, bytes);

            attributes.addFlashAttribute("message", file.getOriginalFilename() +" Upload Success !!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }

    @RequestMapping(value = "/uploadMore", method = RequestMethod.POST)
    public String uploadMore(@RequestParam(name = "file") MultipartFile[] files, RedirectAttributes attributes) {
        if (files.length < 0) {
            attributes.addFlashAttribute("message", "please select valiable file");
            return "redirect:/uploadStatus";
        }

        for (MultipartFile file : files) {
            try {
                Path path = Paths.get(UPLOAD_FILE_FOLD + file.getOriginalFilename());
                byte[] bytes = file.getBytes();
                Files.write(path, bytes);

                attributes.addFlashAttribute("message", file.getOriginalFilename() +" Upload Success !!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/uploadStatus";
    }

}
