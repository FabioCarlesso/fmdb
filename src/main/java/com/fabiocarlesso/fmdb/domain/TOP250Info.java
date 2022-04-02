package com.fabiocarlesso.fmdb.domain;

import java.util.List;

import lombok.Data;

@Data
public class TOP250Info {
    
    List<Movie> items;
    private String errorMessage;

}
