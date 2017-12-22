package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

/**
 * Painel no topo do menu. É este painel que permite definir os caminhos para os
 * ficheiros bem como alterar a configuração a ser utilizada dinamicamente.
 *
 */
public class TopPanel extends JPanel {
	private UserMenu menu;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TopPanel(UserMenu menu) {
		if (menu == null)
			throw new IllegalArgumentException();
		else
			this.menu = menu;
	}

	/**
	 * Adiciona o contéudo a ser visualizado ao painel.
	 */
	public void addContent() {
		this.setLayout(new GridLayout(0, 2));
		JPanel files = new JPanel();
		files.setLayout(new GridLayout(0, 2, 10, 3));
		JLabel spam = new JLabel("spam.log", SwingConstants.RIGHT);
		JLabel log = new JLabel("ham.log", SwingConstants.RIGHT);
		JLabel rules = new JLabel("rules.cf", SwingConstants.RIGHT);
		files.add(rules);
		JTextField rules_p = new JTextField();
		rules_p.addActionListener(new PathListener(rules_p, 0));
		files.add(rules_p);
		files.add(log);
		JTextField log_p = new JTextField();
		log_p.addActionListener(new PathListener(log_p, 1));
		files.add(log_p);
		files.add(spam);
		JTextField spam_p = new JTextField();
		spam_p.addActionListener(new PathListener(spam_p, 1));
		files.add(spam_p);
		this.add(leftpanel());

		this.add(files);
	}

	/**
	 * Subpainel representativo do lado esquerdo do painel principal.
	 * 
	 * @return
	 */
	private JPanel leftpanel() {
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(2, 0));
		pane.add(new JLabel("Caminho para os ficheiros"));
		JPanel checks = new JPanel(new GridLayout(2, 2));
		JLabel man_config = new JLabel("Configuração manual");
		JLabel auto_config = new JLabel("Configuração automática");
		JCheckBox check_man = new JCheckBox();
		check_man.addActionListener(new OptionListener("manual"));
		JCheckBox check_auto = new JCheckBox();
		check_auto.addActionListener(new OptionListener("auto"));
		ButtonGroup check_group = new ButtonGroup();
		checks.add(man_config);
		checks.add(check_man);
		check_group.add(check_auto);
		check_group.add(check_man);
		checks.add(auto_config);
		checks.add(check_auto);
		pane.add(checks);
		return pane;
	}

	/**
	 * Sentinela que escuta por eventos despoletados pelo user quando este
	 * insere algo nas caixas de texto dos ficheiros e pressiona ENTER.
	 *
	 */
	private class PathListener implements ActionListener {
		private JTextField field;
		private int type;

		public PathListener(JTextField field, int type) {
			if(field==null)
				throw new IllegalArgumentException();
			this.field = field;
			this.type = type;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = field.getText().trim();
			if (!text.isEmpty()) {
				File f = new File(text);
				if (f.exists() && !f.isDirectory()) {
					if (type == 0)
						menu.fillTables(f);
					else // convém verificar se acaba em spam.log ou ham.log
							// para garantir que é o file correto
						menu.getFile_list().add(f);
					field.setEnabled(false);
				} else
					JOptionPane.showMessageDialog(menu.getFrame(), "Caminho especificado não encontrado.");
			}
		}
	}

	/**
	 * Sentinela que escuta pela interação do utilizador na selecção da
	 * configuração a ser utilizada. É possível o utilizador alterar a
	 * configuração a ser utilizada dinamicamente porém apenas uma configuração
	 * pode ser utilizada de cada vez.
	 *
	 */
	private class OptionListener implements ActionListener {
		private String type;

		public OptionListener(String type) {
			if (type == null)
				throw new IllegalArgumentException("Configuration option unrecognized.");
			this.type = type;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (type.equals("auto")) {
				menu.getManual_config().setVisible(false);
				menu.getAuto_config().setVisible(true);
			} else if (type.equals("manual")) {
				menu.getManual_config().setVisible(true);
				menu.getAuto_config().setVisible(false);
				menu.getFrame().pack();
			}
		}
	}
}
