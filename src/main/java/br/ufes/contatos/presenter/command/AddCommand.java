/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.presenter.command;

import br.ufes.contatos.presenter.state.StateCRUD;

/**
 *
 * @author Lucas
 */
public class AddCommand implements PresenterCommand{

    private StateCRUD stateCRUD;

    public AddCommand(StateCRUD stateCRUD) {
        this.stateCRUD = stateCRUD;
    }
    
    @Override
    public void execute() {
        this.stateCRUD.add();
    }
    
}
