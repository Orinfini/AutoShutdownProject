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
        JLabel autoShutdownLabel = new JLabel("Select an Option");
        autoShutdownLabel.setBounds(0, 20, super.getWidth(), 40);
        autoShutdownLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        autoShutdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(autoShutdownLabel);

        JButton shutdownButton = new JButton("Shutdown");
        shutdownButton.setBounds(70, 100, super.getWidth() - 150, 24);
        shutdownButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        shutdownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String minutesInput = JOptionPane.showInputDialog(SelectionGui.this, "How many minutes do you want to turn off your computer?");
                if (minutesInput != null) {
                    try {
                        int minutes = Integer.parseInt(minutesInput);
                        executeShutdownCommand("shutdown -s -t " + (minutes * 60)); // Chamando método específico para desligamento
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(SelectionGui.this, "Invalid input. Please enter a valid number of minutes.");
                    }
                }
            }
        });
        add(shutdownButton);

        JButton rebootButton = new JButton("Reboot");
        rebootButton.setBounds(70, 200, super.getWidth() - 150, 24);
        rebootButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        rebootButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String minutesInput = JOptionPane.showInputDialog(SelectionGui.this, "How many minutes do you want to reboot your computer?");
                if (minutesInput != null) {
                    try {
                        int minutes = Integer.parseInt(minutesInput);
                        executeRebootCommand("shutdown -r -t " + (minutes * 60)); // Chamando método específico para reinicialização
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(SelectionGui.this, "Invalid input. Please enter a valid number of minutes.");
                    }
                }
            }
        });
        add(rebootButton);
    }

    // Método para executar o comando de desligamento no prompt de comando
    private void executeShutdownCommand(String command) {
        executeCommand(command, "Shutdown command executed successfully.", "Failed to execute shutdown command.");
    }

    // Método para executar o comando de reinicialização no prompt de comando
    private void executeRebootCommand(String command) {
        executeCommand(command, "Reboot command executed successfully.", "Failed to execute reboot command.");
    }

    // Método para executar um comando no prompt de comando
    private void executeCommand(String command, String successMessage, String failureMessage) {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                JOptionPane.showMessageDialog(this, successMessage);
            } else {
                JOptionPane.showMessageDialog(this, failureMessage + " Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to execute command: " + ex.getMessage());
        }
    }
}