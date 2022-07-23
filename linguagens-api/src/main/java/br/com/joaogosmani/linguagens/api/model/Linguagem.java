package br.com.joaogosmani.linguagens.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "programmationLanguages")
public class Linguagem {
    
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

}
