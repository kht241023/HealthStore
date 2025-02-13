package kh.edu.test.HealthStore.mapper;

import kh.edu.test.HealthStore.dto.HealthProgram;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HealthProgramMapper {
    List<HealthProgram> selectAllHealthPrograms();
    HealthProgram selectHealthProgramById(int healthProgramId);
    void insertHealthProgram(HealthProgram healthProgram);
}
