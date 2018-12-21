package org.java.web;

import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Controller
public class ProcessController {


    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/forward/{folder}/{target}")
    public String forward(@PathVariable("folder") String folder,@PathVariable("target") String target){
        return "/"+folder+"/"+target;
    }

     @PostMapping("/deploy")
     public String deploy(@RequestParam("bpmn") MultipartFile bpmn,@RequestParam("png") MultipartFile png) throws Exception{

         InputStream bpmn_in=bpmn.getInputStream();
         InputStream png_in=png.getInputStream();
         String bpmn_name=bpmn.getOriginalFilename();
         String png_name=png.getOriginalFilename();

         repositoryService.createDeployment().addInputStream(bpmn_name, bpmn_in).addInputStream(png_name,png_in ).deploy();
         System.out.println("部署成功");
         return "/process/deployOk";
     }
}
