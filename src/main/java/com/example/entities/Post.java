package com.example.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Blog")
@Table(name = "blog")
@Getter
@Setter
public class Post {

    @Id
    private Long id;
    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;
    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;
    @Column(
            name = "pictureUrl",
            columnDefinition = "TEXT"
    )
    private String pictureUrl;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }

}
