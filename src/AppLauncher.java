import javax.swing.*;

public class AppLauncher {
    public static void main (String[] args){
// use o involakeLater para fazer updates da interface mais seguras para os threads
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SelectionGui().setVisible(true);
            }
        });

    }

}
