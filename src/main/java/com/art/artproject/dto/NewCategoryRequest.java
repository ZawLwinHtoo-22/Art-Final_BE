package com.art.artproject.dto;

import com.art.artproject.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewCategoryRequest {

    private String name;

    public static Category getCategory(NewCategoryRequest request) {

        return new Category()
                .builder()
                .name(request.getName())
                .build();
    }

}
