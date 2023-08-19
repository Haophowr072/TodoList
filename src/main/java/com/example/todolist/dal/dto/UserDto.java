package com.example.todolist.dal.dto;

import com.example.todolist.entity.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    private String id;
    @NotBlank(message = "Vui lòng nhập tên")
    private String name;
    @NotEmpty(message = "Vui lòng nhập địa chỉ")
    private String address;
    @Email(message = "Vui lòng nhập email")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Vui lòng nhập đúng sdt")
    private String phone;

    @OneToMany(targetEntity = TaskDto.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Task> tasks;
}
