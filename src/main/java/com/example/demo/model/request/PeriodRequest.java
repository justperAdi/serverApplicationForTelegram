package com.example.demo.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodRequest implements Serializable {
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date fromDate;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date toDate;
}
