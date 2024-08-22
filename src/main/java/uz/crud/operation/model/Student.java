package uz.crud.operation.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@RequiredArgsConstructor
@Document("student")
public class Student {

    @Id
    private String id;

    @Field("full_name")
    private String fullName;

    @Field("marks")
    private int marks;



}
