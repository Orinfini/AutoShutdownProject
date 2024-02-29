import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionGui extends AutoShutdown {
    public SelectionGui() {
        super("Auto Shutdown");
    }

    @Override
    protected void addGuiComponents() {
        // JFrame não é necessário, pois AutoShutdown já é uma janela
        // Remova esta linha: JFrame frame = new JFrame("Shutdown Button");

        // Cria a label do aplicativo
        JLabel AutoShutdownLabel = new JLabel("Select an Option");

        // Define a localização e o tamanho dos componentes da interface
        AutoShutdownLabel.setBounds(0, 20, super.getWidth(), 40);
        // Mude o estilo da Fonte
        AutoShutdownLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        // Centraliza o texto na interface
        AutoShutdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // Adiciona a interface
        add(AutoShutdownLabel);

        JButton ShutdownButton = new JButton("Shutdown");
        ShutdownButton.setBounds(70, 100, super.getWidth() - 150, 24);
        ShutdownButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        ShutdownButton.addActionListener(new ActionListener() {
            // ActionListener para o botão "Shutdown"
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibe uma caixa de diálogo para o usuário inserir o número de minutos
                String minutesInput = JOptionPane.showInputDialog(SelectionGui.this, "How many minutes do you want to turn off your computer?");
                if (minutesInput != null) {
                    try {
                        int minutes = Integer.parseInt(minutesInput); // Converte a entrada do usuário para um número inteiro
                        shutdownComputer(minutes); // Chama o método para desligar o computador com o número de minutos especificado
                    } catch (NumberFormatException ex) { // Se a entrada do usuário não puder ser convertida para um número inteiro
                        JOptionPane.showMessageDialog(SelectionGui.this, "Invalid input. Please enter a valid number of minutes."); // Exibe uma mensagem de erro
                    }
                }
            }
        });
        add(ShutdownButton);

        JButton RebootButton = new JButton("Reboot");
        RebootButton.setBounds(70, 200, super.getWidth() - 150, 24);
        RebootButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(RebootButton);

        JButton HibernateButton = new JButton("Hibernate");
        HibernateButton.setBounds(70, 300, super.getWidth() - 150, 24);
        HibernateButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(HibernateButton);
    }

    // Método para desligar o computador (não implementado neste exemplo)
    private void shutdownComputer(int minutes) {
        // Implemente a lógica de desligamento aqui
    }
}
