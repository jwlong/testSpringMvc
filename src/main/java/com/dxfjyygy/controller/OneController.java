package com.dxfjyygy.controller;

import com.dxfjyygy.dto.OneDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/one")
public class OneController {

     @GetMapping("/test")
     @ResponseBody
     public List<OneDTO> test(){
         OneDTO oneDTO = new OneDTO();

         List<OneDTO> list = new ArrayList<>();
         for (int i = 0; i < 10; i++) {
             oneDTO.setTest1("test"+i);
             oneDTO.setTest2("test"+i);
             oneDTO.setTest3("test"+i);
             oneDTO.setTest4("test"+i);
             list.add(oneDTO);
         }
         return list;
     }

    @GetMapping("/testXml")
    @ResponseBody
    public List<OneDTO> testXml(){
        OneDTO oneDTO = new OneDTO();

        List<OneDTO> list = new ArrayList<>();

        return list;
    }
}
