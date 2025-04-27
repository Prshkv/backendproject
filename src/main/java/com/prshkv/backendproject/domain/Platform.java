package com.prshkv.backendproject.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String platformName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="platform")
    private List<Exploit> exploits;

    // Getters and setters

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public List<Exploit> getExploits() {
        return this.exploits;
    }

    public void setExploits(List<Exploit> exploits) {
        this.exploits = exploits;
    }


}
