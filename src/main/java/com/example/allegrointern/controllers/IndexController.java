package com.example.allegrointern.controllers;


import com.example.allegrointern.services.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    private final RepoService repoService;

    @Autowired
    public IndexController(RepoService repoService){
        this.repoService = repoService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    String mainEvent() {
        return Integer.toString(repoService.repos.size());
    }

}