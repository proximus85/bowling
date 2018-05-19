package org.home.bowling.backendbeans;

import lombok.Getter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@RequestScoped
@Getter
public class CurrentDateProvider implements Serializable {
    private Date date = new Date();
}
