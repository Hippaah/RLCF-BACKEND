package com.rlcf.spring.dto;

import com.rlcf.spring.models.EStatus;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DemandDto {

    private ClientDto clientDto;
    private ProductDto productDto;
    private long fileId;

}
