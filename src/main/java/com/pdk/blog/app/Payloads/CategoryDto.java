package com.pdk.blog.app.Payloads;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;

    @NotBlank
    @Size(min = 5, max = 30)
    private String categoryTitle;

    @NotBlank
    @Size(min = 10)
    private String categoryDescription;
}
