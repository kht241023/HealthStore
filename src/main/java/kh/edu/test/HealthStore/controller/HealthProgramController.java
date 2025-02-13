package kh.edu.test.HealthStore.controller;


import kh.edu.test.HealthStore.dto.HealthProgram;
import kh.edu.test.HealthStore.service.HealthProgramService;
import kh.edu.test.HealthStore.service.HealthProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-programs")
public class HealthProgramController {

    @Autowired
    private HealthProgramServiceImpl healthProgramService;

    // 모든 운동 프로그램 조회
    @GetMapping
    public List<HealthProgram> getAllHealthPrograms() {
        return healthProgramService.getAllHealthPrograms();
    }

    // 특정 운동 프로그램 조회
    @GetMapping("/{id}")
    public HealthProgram getHealthProgramById(@PathVariable int id) {
        return healthProgramService.getHealthProgramById(id);
    }

    // 새로운 운동 프로그램 추가
    @PostMapping
    public void addHealthProgram(@RequestBody HealthProgram healthProgram) {
        healthProgramService.addHealthProgram(healthProgram);
    }
}