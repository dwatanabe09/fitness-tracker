import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FitnessTrackerGUI {
  private JFrame frame;
  private JPanel sidebarPanel, mainPanel;
  private JButton logButton, viewAllButton, viewByCategoryButton, summaryButton;

  public FitnessTrackerGUI() {
    frame = new JFrame("Fitness Tracker Dashboard");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 600);
    frame.setLayout(new BorderLayout());

    //Website Header
    JLabel header = new JLabel("DASHBOARD", SwingConstants.CENTER);
    header.setFont(new Font("Arial", Font.BOLD, 24));
    frame.add(header, BorderLayout.NORTH);

    //Side panel
    sidebarPanel = new JPanel();
    sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
    sidebarPanel.setPreferredSize(new Dimension(200, frame.getHeight()));

    logButton = new JButton("Log Workout");
    viewAllButton = new JButton("View All Workouts");
    viewByCategoryButton = new JButton("View Workouts by Category");
    summaryButton = new JButton("Weekly Summary");

    sidebarPanel.add(logButton);
    sidebarPanel.add(viewAllButton);
    sidebarPanel.add(viewByCategoryButton);
    sidebarPanel.add(summaryButton);

    //future calendar
    JLabel calendar = new JLabel("calendar", SwingConstants.CENTER);
    calendar.setPreferredSize(new Dimension(180,150));
    calendar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    sidebarPanel.add(Box.createVerticalStrut(10));
    sidebarPanel.add(calendar);

    frame.add(sidebarPanel, BorderLayout.WEST);

    //Main content
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    JLabel banner = new JLabel("[ dont forget to upload photo ]", SwingConstants.CENTER);
        banner.setPreferredSize(new Dimension(600, 150));
        banner.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        mainPanel.add(banner, BorderLayout.NORTH);

        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(1, 3, 10, 10));

        JLabel workoutA = new JLabel("WORKOUT A", SwingConstants.CENTER);
        workoutA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel workoutB = new JLabel("WORKOUT B", SwingConstants.CENTER);
        workoutB.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel workoutC = new JLabel("WORKOUT C", SwingConstants.CENTER);
        workoutC.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        cardsPanel.add(workoutA);
        cardsPanel.add(workoutB);
        cardsPanel.add(workoutC);

        mainPanel.add(cardsPanel, BorderLayout.CENTER);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        //buttons
        logButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Log Workout Clicked"));
        viewAllButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "View All Workouts Clicked"));
        viewByCategoryButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Filter by Category Clicked"));
        summaryButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Weekly Summary Clicked"));
    }

    public static void main(String[] args) {
      SwingUtilities.invokeLater(FitnessTrackerGUI::new);
    }



}