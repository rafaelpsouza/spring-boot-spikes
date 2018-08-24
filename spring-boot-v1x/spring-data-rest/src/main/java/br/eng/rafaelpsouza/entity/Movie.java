package br.eng.rafaelpsouza.entity;

import javax.persistence.*;

/**
 *
 * @author Rafael Souza
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer year;
    private Integer rate;

    public Movie() {
    }
    
    public Movie(Long id, String name, Integer year, Integer rate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
    }

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
    
    
    

}
