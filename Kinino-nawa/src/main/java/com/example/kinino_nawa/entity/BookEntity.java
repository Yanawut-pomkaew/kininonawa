package com.example.kinino_nawa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "BOOK")
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "BOOK_REF" , columnDefinition = "UUID")
    private UUID bookRef;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "PRICE")
    private long price;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "TOTAL_PAGE")
    private String totalPage;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "CATEGORY1")
    private String category1;

    @Column(name = "CATEGORY2")
    private String category2;

    @Column(name = "CATEGORY3")
    private String category3;

    @Column(name = "PRINT_DATE")
    private Date printDate;

    @Column(name = "IMG")
    private Blob img;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "RENTABLE")
    private Long rentable;

}
