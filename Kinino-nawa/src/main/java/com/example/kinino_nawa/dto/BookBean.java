package com.example.kinino_nawa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
public class BookBean implements Serializable {

    private UUID bookRef;
    private String bookName;
    private String price;
    private String author;
    private long totalPage;
    private String description;
    private long amount;
    private String category1;
    private String category2;
    private String category3;
    private Date printDate;




}
