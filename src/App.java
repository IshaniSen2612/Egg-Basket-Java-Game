import java.awt.EventQueue;

import javax.swing.JFrame;

public class App extends JFrame {

    public App()
    {
        initUI();
    }
    
    private void initUI() 
    {
        setTitle("Moving sprite");
        setSize(1280, 720);
        //setExtendedState(getExtendedState()|MAXIMIZED_BOTH);

        add(new Viewport(this.getWidth(),this.getHeight()));
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) 
    {
        EventQueue.invokeLater(() -> {
            App a = new App();
            a.setVisible(true);
            
        });
    }
}
