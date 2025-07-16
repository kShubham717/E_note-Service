package com.example.E_Note.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private int id;
    private String name;
    private String description;
    private Boolean isActive;
    private int isDeleted;
    private Date CreatedDate;
    private int UpdatedBy;
    private Date UpdatedOn;
}
