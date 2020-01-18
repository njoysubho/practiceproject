package org.example.domain;

import lombok.*;
import org.apache.tomcat.util.security.MD5Encoder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String name;
    private Integer id;
    public String hash(){
       return MD5Encoder.encode(name.getBytes());
    }
}
