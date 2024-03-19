package com.example.demo.CatFactEntity;

import com.example.demo.CatFact.CatFact;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cat_facts")
@AllArgsConstructor
@NoArgsConstructor
public class CatFactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "catfactJSON")
    private String catfactJSON;

    public CatFactEntity(CatFact catFact) {
        this.catfactJSON = convertToJson(catFact);
    }

    public String convertToJson(CatFact catFact) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(catFact);
        } catch (Exception e) {
            throw new RuntimeException("Cannot convert to JSON");
        }
    }

    public CatFact convertToCatFact() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(catfactJSON, CatFact.class);
        } catch (Exception e) {
            throw new RuntimeException("Cannot convert to catfact");
        }
    }
}
