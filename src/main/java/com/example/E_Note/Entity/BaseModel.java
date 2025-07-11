package com.example.E_Note.Entity;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {

    private Boolean isActive;
    private int isDeleted;
    private Date CreatedDate;
    private int UpdatedBy;
    private Date UpdatedOn;
}
