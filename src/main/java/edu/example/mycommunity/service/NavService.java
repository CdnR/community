package edu.example.mycommunity.service;


import edu.example.mycommunity.mapper.NavMapper;
import edu.example.mycommunity.model.Nav;
import edu.example.mycommunity.model.NavExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by codedrinker on 2019/9/2.
 */
@Service
public class NavService {
    @Autowired
    private NavMapper navMapper;

    public List<Nav> list() {
        NavExample navExample = new NavExample();
        navExample.createCriteria()
                .andStatusEqualTo(1);
        navExample.setOrderByClause("priority desc");
        List<Nav> navs = navMapper.selectByExample(navExample);
        return navs;
    }
}
