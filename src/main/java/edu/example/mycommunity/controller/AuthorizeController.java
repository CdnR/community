package edu.example.mycommunity.controller;

import edu.example.mycommunity.dto.GithubUesr;
import edu.example.mycommunity.dto.accessTokenDTO;
import edu.example.mycommunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name = "state")String state){
        accessTokenDTO accessTokenDTO = new accessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("1984ccc4cf0af8fc304e");
        accessTokenDTO.setClient_secret("626c8a72a734ecd6547028d6ea782382127d10aa");
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUesr user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
