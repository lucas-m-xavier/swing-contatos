package br.ufes.contatos.presenter;


import br.ufes.contatos.view.ConsultarContatosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import br.ufes.contatos.collection.ContatoCollection;
import br.ufes.contatos.model.Contato;
import br.ufes.contatos.presenter.command.PresenterCommand;
import br.ufes.contatos.presenter.observable.Observer;
import br.ufes.contatos.service.ContatoService;

/**
 *
 * @author clayton
 */
public class ConsultarContatosPresenter implements Observer{

    private ConsultarContatosView view = new ConsultarContatosView();
    private ContatoCollection contatos;
    private DefaultTableModel tmContatos;
    
    private ContatoService contatoService = new ContatoService();
    private PresenterCommand presenterCommand;

    public ConsultarContatosPresenter() {
        this.contatos = this.contatoService.getContatos();

        tmContatos = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Telefone"}
        );
        
        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.completeTable();

        view.getTblContatos().setModel(tmContatos);

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        view.setVisible(true);

    }
    
    private void completeTable() {
        tmContatos.setNumRows(0);
        
        contatos = contatoService.getContatos();
        
        ListIterator<Contato> it = contatos.getContatos().listIterator();
        
        while (it.hasNext()) {
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(), contato.getTelefone()});
        }
        
        this.view.getTblContatos().setModel(tmContatos);
    }

    private void fechar() {
        view.dispose();
    }

    @Override
    public void update() {
        this.completeTable();
    }
}
