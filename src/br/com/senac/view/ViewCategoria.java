package br.com.senac.view;

import br.com.senac.dao.CategoriaDAO;
import br.com.senac.model.CategoriaModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCategoria
{
    private JLabel jlabelTitulo;
    private JPanel jPanelCadastroCategoria;
    private JLabel jLabelDescricaoCategoria;
    private JTextField jTextFieldDescricaoCategoria;
    private JButton jButtonCadastrarCategoria;

    public ViewCategoria()
    {

        jButtonCadastrarCategoria.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CategoriaModel categoriaModel = new CategoriaModel();
                categoriaModel.setDescricao(jTextFieldDescricaoCategoria.getText());

                CategoriaDAO categoriaDAO = new CategoriaDAO();
                categoriaDAO.salvar(categoriaModel);
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("ViewCategoria");
        frame.setContentPane(new ViewCategoria().jPanelCadastroCategoria);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
