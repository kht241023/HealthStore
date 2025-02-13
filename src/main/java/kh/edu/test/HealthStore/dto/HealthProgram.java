package kh.edu.test.HealthStore.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HealthProgram {
    private int healthProgramId;      // 운동 프로그램 ID
    private String programName;       // 프로그램 이름
    private String programType;       // 프로그램 유형
    private int workoutDuration;      // 운동 시간 (분)
    private String intensityLevel;    // 강도 (초급/중급/고급)
    private String programDescription; // 프로그램 설명
    private Timestamp createdAt;      // 생성 일시
    private Timestamp updatedAt;      // 업데이트 일시
}
