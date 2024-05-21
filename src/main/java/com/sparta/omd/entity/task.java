package com.sparta.omd.entity;

import com.sparta.omd.dto.taskRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Entity
@Getter
@Setter
@Table(name="task")
@NoArgsConstructor
public class task extends com.sparta.memo.entity.Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @Column(name = "title" , nullable = false, length = 255)
    private String title;
    @Column(name = "content" , nullable = false, length = 255)
    private String content;
    private String manager;
    private String password;

    public task(taskRequestDto requestDto) {

        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();

    }

    public void update(taskRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
    }
}
