package br.com.joaogosmani.linguagens.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.joaogosmani.linguagens.api.model.Linguagem;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    
}
