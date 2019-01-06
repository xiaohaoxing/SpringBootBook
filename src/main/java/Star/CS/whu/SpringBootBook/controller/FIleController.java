package Star.CS.whu.SpringBootBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class FIleController {
    @PostMapping("/uploadfile")
    public String handleForm(@RequestParam("name") String name, @RequestParam("file")MultipartFile file) {
        if(!file.isEmpty()) {
            try {
                // 用 Part 对象也可以
//                InputStream in = file.getInputStream();
                byte[] bytes = file.getBytes();
                for(byte b : bytes) {
                    System.out.println(b);
                }
                System.out.println(new String(bytes));
            }catch (IOException e) {
                return "redirect:uploadFailure";
            }
            // handle the bytes

            return "redirect:uploadSuccess";
        }
        return "redirect:uploadFailure";
    }
}
