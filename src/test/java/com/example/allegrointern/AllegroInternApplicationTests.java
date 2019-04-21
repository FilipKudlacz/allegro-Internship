package com.example.allegrointern;

import com.example.allegrointern.models.Repo;
import com.example.allegrointern.services.RepoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllegroInternApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	//@Ignore
	public void jasonToObjectConvertion() throws IOException {
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-DDTHH:mm:ssZ");

		DateTime dt = new DateTime("2018-11-16T12:29:12Z");

		Repo testRepo = new Repo();
		testRepo.setName("John");
		testRepo.setUpdated(dt);

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());

		List<Repo> repos = mapper.readValue(new File("jsonToObjectConvertionTestFile.json"),new TypeReference<List<Repo>>(){});

		Assert.assertEquals(testRepo.getName(), repos.get(0).getName());
		Assert.assertTrue(testRepo.getUpdated().isEqual(repos.get(0).getUpdated()));
	}

	@Test
	public void pickingLastUpdatedRepoFromList() throws IOException {
		ObjectMapper mapper = new ObjectMapper().registerModule(new JodaModule());
		RepoService repoService = new RepoService();

		List<Repo> testRepos = mapper.readValue(new File("lastUpdatedSelectionTestFile.json"), new TypeReference<List<Repo>>(){});
		repoService.setRepos(testRepos);

		Assert.assertEquals("SpringPracProj", repoService.getNameOfLastUpdatedRepo());
	}

}
