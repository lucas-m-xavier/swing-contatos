package br.ufes.contatos.presenter;

import br.ufes.contatos.view.ManterContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.ufes.contatos.collection.ContatoCollection;
import br.ufes.contatos.model.Contato;
import br.ufes.contatos.presenter.command.AddCommand;
import br.ufes.contatos.presenter.command.PresenterCommand;
import br.ufes.contatos.presenter.observable.Subject;
import br.ufes.contatos.presenter.state.AddContatoState;
import br.ufes.contatos.presenter.state.StateCRUD;

/**
 *
 * @author clayton
 */
public class ManterContatoPresenter extends Subject{

    private ManterContatoView view;
    private StateCRUD stateCRUD;
    private PresenterCommand presenterCommand;
    private Contato contato;

    public ManterContatoPresenter() {
        this.contato = null;
        view = new ManterContatoView();
        this.stateCRUD = new AddContatoState(this);

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }

        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenterCommand = new AddCommand(stateCRUD);
                presenterCommand.execute();
                notifyObserver();
            }
        });

        view.setVisible(true);
    }

    private void fechar() {
        view.dispose();
    }

    public ManterContatoView getViewer() {
        return view;
    }
    
    public Contato getContatoViewer(){
        return new Contato(this.view.getTxtNome().getText(), this.view.getTxtTelefone().getText());
    }
    
    public void setContatoViewer(Contato contato){
        this.view.getTxtNome().setText(contato.getNome());
        this.view.getTxtTelefone().setText(contato.getTelefone());
    }
}
