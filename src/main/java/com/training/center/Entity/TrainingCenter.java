package com.training.center.Entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import java.util.List;

@Entity
@Data
public class TrainingCenter {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @NotBlank(message = "Center name is mandatory")
    @Length(max = 40, message = "Center name should be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is mandatory")
    @Length(min = 12, max = 12, message = "Center code should be exactly 12 characters")
    private String centerCode;

    @Valid
    @Embedded
    @NotNull(message = "Address is mandatory")
    private Address address;

    @Min(value = 1, message = "Student capacity should be greater than 0")
    private int studentCapacity;

    @NotNull(message = "Courses offered is mandatory")
    @ElementCollection
    private List<@NotBlank(message = "Course name cannot be blank") String> coursesOffered;

    private long createdOn;

    @Email(regexp = "^([\\w-\\.]+)@([\\w-]+\\.)+([\\w-]{2,4})$", message = "Invalid email format")
    private String contactEmail;


    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
    @NotBlank(message = "Phone Number is mandatory")
    private String contactPhone;
}

@Embeddable
@Data
class Address {
    @NotBlank(message = "Detailed address is mandatory")
    private String detailedAddress;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid pincode format")
    @NotBlank(message = "Pin code is Mandatory ")
    private String pincode;
}

