package com.ust.jpastreamer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterData {
    Integer year;
    Integer experience;
    String education;
    String gender;
}
