import javax.swing.*;
import java.awt.*;

/*
    Criando uma classe abstracta ajuda a configurar o modelo que as gui's seguirá, por exemplo em cada uma das gui's elas
  terão os mesmos tamanhos e precisarão invocar seus proprios addGUicomponents() que serão exclusivos para cada subclasse
 */
public abstract class AutoShutdown extends JFrame {
    public AutoShutdown(String title){
        initialize (title);

    }
    private void initialize (String title){

    // instancia as propriedadess do iframe e adiciona um titulo na barra
        setTitle(title);
    // define o tamanho (em pixels)
        setSize(400, 300);
    // encerra o programa quando a GUI é fechada
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    // define o layout para nulo para ter um layout absoluto que nos permite especificar manualmente o tamanho e a posição dos componentes
        setLayout(null);
    // previne que a interface não seja redimencionada
        setResizable(false);
    // inicializa a interface no centro da tela
        setLocationRelativeTo(null);

    // chama a subclasse  addGuiComponent();
        addGuiComponents();
    }
    // esse metodo precisará ser definido pelas subclasses quando ela estiver sendo herdada
    protected abstract void addGuiComponents();


    }

