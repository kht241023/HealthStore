package kh.edu.test.HealthStore.service;

import kh.edu.test.HealthStore.dto.HealthProgram;
import kh.edu.test.HealthStore.mapper.HealthProgramMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HealthProgramServiceImpl implements HealthProgramService {

    @Autowired
    private HealthProgramMapper healthProgramMapper;

    @Override
    public List<HealthProgram> getAllHealthPrograms() {
        return healthProgramMapper.selectAllHealthPrograms();
    }

    @Override
    public HealthProgram getHealthProgramById(int healthProgramId) {
        return healthProgramMapper.selectHealthProgramById(healthProgramId);
    }

    @Override
    public void addHealthProgram(HealthProgram healthProgram) {
        healthProgramMapper.insertHealthProgram(healthProgram);
    }
}
