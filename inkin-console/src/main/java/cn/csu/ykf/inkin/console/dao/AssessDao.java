package cn.csu.ykf.inkin.console.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csu.ykf.inkin.common.model.po.Assessment;
import cn.csu.ykf.inkin.console.mapper.AssessMapper;

@Service
public class AssessDao {

    @Autowired
    AssessMapper assessMapper;

    public void insertAssess(Assessment assessment) {
        assessMapper.insert(assessment);
    }
}
