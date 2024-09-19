package com.example.kinino_nawa.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookBean implements Serializable {

    private UUID bookRef;
    private String bookName;
    private Long price;
    private String author;
    private long totalPage;
    private String description;
    private long amount;
    private String category1;
    private String category2;
    private String category3;
    private Date printDate;


}
