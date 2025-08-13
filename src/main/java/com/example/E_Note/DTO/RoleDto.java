package com.example.E_Note.DTO;

import lombok.*;


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public class RoleDto {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

