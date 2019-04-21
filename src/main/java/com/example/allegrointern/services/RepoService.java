package com.example.allegrointern.services;

import com.example.allegrointern.models.Repo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class RepoService {

    private List<Repo> repos;
    private String nameOfLastUpdatedRepo;

    public RepoService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        URL url = new URL("https://api.github.com/users/allegro/repos");
        repos = mapper.readValue( url, new TypeReference<List<Repo>>(){});
        this.nameOfLastUpdatedRepo =  repos.get(0).getName();
    }

    public void setRepos(List<Repo> repos){
        this.repos = repos;
    }

    public String getNameOfLastUpdatedRepo(){
        int indexOfLastUpdatedRepo = 0;

        for (Repo repo: repos) {
            if(repo.getUpdated().isAfter(repos.get(indexOfLastUpdatedRepo).getUpdated())){
                nameOfLastUpdatedRepo = repo.getName();
                indexOfLastUpdatedRepo = repos.indexOf(repo);
            }
        }

        return nameOfLastUpdatedRepo;
    }


}
