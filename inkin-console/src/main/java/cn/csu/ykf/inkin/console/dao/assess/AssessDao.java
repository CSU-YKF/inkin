package cn.csu.ykf.inkin.console.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csu.ykf.inkin.common.model.po.Assessment;
import cn.csu.ykf.inkin.console.mapper.AssessMapper;
import jakarta.annotation.PostConstruct;

@Service
public class AssessDao {

    @Autowired
    AssessMapper assessMapper;

    public void insertAssess(Assessment assessment) {
        assessMapper.insert(assessment);
    }

    public Assessment selectAssessById(Long id) {
        return assessMapper.selectById(id);
    }

    public List<Assessment> selectAllAssess() {
        return assessMapper.selectList(null);
    }
}
