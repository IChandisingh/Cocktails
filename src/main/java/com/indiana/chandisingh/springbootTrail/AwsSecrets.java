package com.indiana.chandisingh.springbootTrail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwsSecrets {

    private String  host  ;
    private String  port ;
    private String  dbname ;
    private String  username ;
    private String  password ;
    private String engine;

}
