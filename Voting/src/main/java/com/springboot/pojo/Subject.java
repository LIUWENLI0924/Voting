package com.springboot.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Subject {
    private int sid;
    private String title;
    private int type;
    private Options op;

    private Item it;
/*    private List<Options> op;*/
}
