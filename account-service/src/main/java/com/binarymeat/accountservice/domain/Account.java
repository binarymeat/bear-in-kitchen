package com.binarymeat.accountservice.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by rob on 12/5/16.
 */

@Document(collection = "accounts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @Id
    private String name;

    private Date lastSeen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }
}
