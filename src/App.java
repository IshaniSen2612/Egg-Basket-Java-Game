import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class App extends JFrame {

    public App()
    {
        initUI();

    }
    
    private void initUI() 
    {
        setTitle("Catch The Eggs");
        setSize(1280, 720);
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
            
            Timer timer1=new Timer(10,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                a.repaint();
                a.revalidate();
            }
                        
            });
        });



    }
}
