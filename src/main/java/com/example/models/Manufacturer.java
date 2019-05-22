package com.example.models;


import javax.persistence.*;

@Entity
@Table(name="manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manu_name", length = 500)
    private String name;

    public Manufacturer(long parseLong, String string) {
        this.id = parseLong;
        this.name = string;
    }

	public Manufacturer() {}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
