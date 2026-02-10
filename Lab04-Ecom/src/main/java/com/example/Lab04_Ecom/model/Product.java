package com.example.Lab04_Ecom.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @Length(min=0, max=360, message = "Hình ảnh san phẩm không được qua' 360 kí tự")
    private String image;

    @NotNull(message = "Tên sản phẩm không được để trống")
    @Min(value = 1, message = "Giá sản phẩm 0 được nhỏ hơn 1")
    @Max(value = 999999, message = "giá sản phẩm không được lon hơn 9999999")
    private long price;

    private Category category;
}
