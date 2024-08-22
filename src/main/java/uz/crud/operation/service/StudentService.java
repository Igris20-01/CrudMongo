package uz.crud.operation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.crud.operation.dto.StudentDto;
import uz.crud.operation.model.Student;
import uz.crud.operation.repo.StudentRepo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements Serializable {


    private final StudentRepo studentRepo;


    public StudentDto createStudent(StudentDto createDto) {
        Student student = new Student();
        student.setFullName(createDto.getFullName());
        student.setMarks(createDto.getMarks());
        Student savedStudent = studentRepo.save(student);
        return convertToDto(savedStudent);
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<StudentDto> getStudentById(String id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        return studentOptional.map(this::convertToDto);
    }

    public StudentDto updateStudent(String id, StudentDto updateDto) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setFullName(updateDto.getFullName());
            existingStudent.setMarks(updateDto.getMarks());
            Student updatedStudent = studentRepo.save(existingStudent);
            return convertToDto(updatedStudent);
        } else {
            return null;
        }
    }

    public void deleteStudent(String id) {
        studentRepo.deleteById(id);
    }


    private StudentDto convertToDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFullName(student.getFullName());
        dto.setMarks(student.getMarks());
        return dto;
    }
}
