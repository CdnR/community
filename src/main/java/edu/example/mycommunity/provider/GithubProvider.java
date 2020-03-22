package edu.example.mycommunity.provider;


import com.alibaba.fastjson.JSON;
import edu.example.mycommunity.dto.accessTokenDTO;
import edu.example.mycommunity.dto.GithubUesr;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(accessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
//                .url("http://github.com/login/oauth/access_token")
                .url("http://github.com/login/oauth/access_token?client_id="+accessTokenDTO.getClient_id()+"&client_secret="+accessTokenDTO.getClient_secret()+"&code="+accessTokenDTO.getCode()+"&redirect_uri="+accessTokenDTO.getRedirect_uri()+"&state=1")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUesr getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUesr githubUesr = JSON.parseObject(string,GithubUesr.class);
            return githubUesr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    }

