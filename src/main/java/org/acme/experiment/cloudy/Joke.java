package org.acme.experiment.cloudy;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Joke extends PanacheEntity {

    @Column(length = 65555)
    public String content;

    @Basic
    @Temporal(TemporalType.DATE)
    public Date creationDate;

    public String category;

}
