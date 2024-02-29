import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
        getContentPane().setBackground(new Color(47,212,181));
        LinearGradientPaint Classe;
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
        // Centralizando o botão Shutdown
        int buttonWidth = super.getWidth() - 150; // Calcula a largura do botão subtraindo 150 pixels da largura total da janela
        int buttonHeight = 24; // Define a altura do botão como 24 pixels
        int buttonX = (super.getWidth() - buttonWidth) / 2; // Calcula a posição horizontal do botão para centralizá-lo na janela
        int buttonY = (super.getHeight() - 40 - buttonHeight * 2 - 20) / 2;// Calcula a posição vertical do botão para centralizá-lo na janela, considerando o espaço ocupado pela label e o espaçamento entre os botões
        ShutdownButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);// Define os limites do botão (posição e tamanho) com base nos cálculos anteriores

        add(ShutdownButton);

        JButton RebootButton = new JButton("Reboot");
        RebootButton.setBounds(70, 200, super.getWidth() - 150, 24);
        RebootButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        RebootButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String minutesImput = JOptionPane.showInputDialog(SelectionGui.this, "How many minutes do you want to reboot your computer?");
                if (minutesImput != null) {
                    try {
                        int minutes = Integer.parseInt(minutesImput);
                        rebootComputer(minutes);
                        }catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(SelectionGui.this, "Invalid input. Please enter a valid number of minutes.");
                        }


                }

            }
        });
        int buttonYReboot = buttonY + buttonHeight + 40; // Espaçamento de 40 pixels entre os botões
        RebootButton.setBounds(buttonX, buttonYReboot, buttonWidth, buttonHeight);
        add(RebootButton);


    }

    // Método para desligar o computador (não implementado neste exemplo)
    private void shutdownComputer(int minutes) {
                                            //lógica de desligamento aqui
        String command = "shutdown -s -t " + (minutes * 60);
        try {
            // Executar o comando no CMD
            Process process = Runtime.getRuntime().exec(command);

            // Esperar até que o comando seja concluído
            process.waitFor();
            System.out.println("Computador será desligado em " + minutes + " minutos.");
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void rebootComputer(int minutes){
                                            //lógica de reboot aqui
        String command ="shutdown -r -t "+(minutes * 60);
        try{
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("The compute will reboot in "+minutes+"minutes");
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

}
