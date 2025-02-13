package kh.edu.test.HealthStore.service;

import kh.edu.test.HealthStore.dto.HealthProgram;

import java.util.List;

public interface HealthProgramService {
    List<HealthProgram> getAllHealthPrograms();
    HealthProgram getHealthProgramById(int healthProgramId);
    void addHealthProgram(HealthProgram healthProgram);
}
