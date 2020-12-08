/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.service;

import br.ufes.contatos.collection.ContatoCollection;
import br.ufes.contatos.model.Contato;
import java.util.Arrays;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Lucas
 */
public class ContatoService {
    private final String url = "https://contatosapp.herokuapp.com/";
    private RestTemplate restTemplate = new RestTemplate();
    
    public void saveContato(Contato contato) {
        restTemplate.postForObject(url, contato, Contato.class);
    }
    
    public ContatoCollection getContatos() {
       Contato[] contatos = restTemplate.getForObject(url, Contato[].class);
       return new ContatoCollection(Arrays.asList(contatos));
    }
}
