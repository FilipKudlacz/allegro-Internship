package com.example.allegrointern.services;

import com.example.allegrointern.models.Repo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class RepoService {

    ObjectMapper mapper = new ObjectMapper();
    public List<Repo> repos;

    public RepoService() throws IOException {
        repos = mapper.readValue(new File("data.json"), new TypeReference<List<Repo>>(){});
    }
}
