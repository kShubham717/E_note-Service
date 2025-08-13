package com.example.E_Note.DTO;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private int id;
    private String name;
    private String description;
    private Boolean isActive;
    private int isDeleted;
    private Date CreatedDate;
    private int UpdatedBy;
    private Date UpdatedOn;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public Date getUpdatedOn() {
        return UpdatedOn;
    }
}
