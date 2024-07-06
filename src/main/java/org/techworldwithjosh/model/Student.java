package org.techworldwithjosh.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "student")

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;

    private String first_name;
    private String last_name;
    private String email;
    private Integer age;
    private Integer marks;
    private Integer attendance;

    @Column(name = "promotion_status")
    private boolean promotionStatus;

}
