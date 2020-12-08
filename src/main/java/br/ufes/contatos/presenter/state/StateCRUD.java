/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.presenter.state;

import br.ufes.contatos.presenter.ManterContatoPresenter;
import br.ufes.contatos.service.ContatoService;

/**
 *
 * @author Lucas
 */
public abstract class StateCRUD {
    
    protected ManterContatoPresenter manterContatoPresenter;
    
    protected ContatoService contatoservice = new ContatoService();

    public StateCRUD(ManterContatoPresenter manterContatoPresenter) {
        this.manterContatoPresenter = manterContatoPresenter;
    }
    
    public void fechar() {
        this.manterContatoPresenter.getViewer().dispose();
    }
    
    public void add() {
        throw new RuntimeException("Erro: você não tem permissão para isso!");
    }
}
