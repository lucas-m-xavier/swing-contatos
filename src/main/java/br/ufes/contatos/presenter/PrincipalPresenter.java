package br.ufes.contatos.presenter;

import br.ufes.contatos.view.PrincipalView;

/**
 *
 * @author clayton
 */
public class PrincipalPresenter {

    private PrincipalView principalView = new PrincipalView();
    private ConsultarContatosPresenter consultarContatosPresenter = null;
    private ManterContatoPresenter manterContatoPresenter = null;

    public PrincipalPresenter() {
    
        this.principalView.setVisible(true);
    
    }
}
