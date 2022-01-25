package com.example.petclinic.model;

import java.io.Serializable;

/**
 * Created by Dim@$$ik on 25.01.22.
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
