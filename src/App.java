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
        setSize(1500, 700);
        //setExtendedState(getExtendedState()|MAXIMIZED_BOTH);
        add(new Viewport(this.getWidth(),this.getHeight()));
        System.out.println(this.getWidth() + " " + this.getHeight());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) 
    {
        EventQueue.invokeLater(() -> {
            App a = new App();
            System.out.println(a.getWidth() + " " + a.getHeight());
            a.setVisible(true);
            
        });
    }
}
