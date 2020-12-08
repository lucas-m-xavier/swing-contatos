/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.presenter.state;

import br.ufes.contatos.model.Contato;
import br.ufes.contatos.presenter.ManterContatoPresenter;
import br.ufes.contatos.view.ManterContatoView;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class AddContatoState extends StateCRUD{

    public AddContatoState(ManterContatoPresenter manterContatoPresenter) {
        super(manterContatoPresenter);
    }
    
    @Override
    public void add() {
        ManterContatoView manterContatoView = this.manterContatoPresenter.getViewer();
        Contato contato = this.manterContatoPresenter.getContatoViewer();
        this.contatoservice.saveContato(contato);
        JOptionPane.showMessageDialog(manterContatoView, "Contato salvo com sucesso!");
    }
}
