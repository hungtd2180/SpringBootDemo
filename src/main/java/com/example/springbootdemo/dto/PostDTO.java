package com.example.springbootdemo.dto;

import com.example.springbootdemo.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private Long userId;

    public static PostDTO fromEntity(Post post){
        return new PostDTO(post.getId(), post.getTitle(), post.getUser().getId());
    }
    //design pattern Adapter
    //Dto thường dùng để custom những dữ liệu đầu ra mà mình muốn thay vì hiển thị hết cả model.
}
