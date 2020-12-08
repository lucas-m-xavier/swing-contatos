package br.ufes.contatos.presenter;

import br.ufes.contatos.view.PrincipalView;

/**
 *
 * @author clayton
 */
public class PrincipalPresenter {

    private PrincipalView principalView = new PrincipalView();

    public PrincipalPresenter() {
    
        this.principalView.setVisible(true);
    
        
    }
}
