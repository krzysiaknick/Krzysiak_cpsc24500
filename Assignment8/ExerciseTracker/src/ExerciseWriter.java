import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A JFrame-based application to track exercise activities.
 */
public class ExerciseWriter extends JFrame implements ActionListener {
    JComboBox<String> dropDown = new JComboBox<>();
    JTextArea summaryArea = new JTextArea(20, 50);
    JButton button;


    /**
     * Constructor to initialize the ExerciseWriter frame and its components.
     */
    ExerciseWriter() {
        this.setSize(1000, 500);
        this.setTitle("Exercise Tracker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());




        button = new JButton("Add Exercise");
        button.setBounds(50,50,50,50);
        this.add(button);


        menuBarsInitialization();
        DisplayGUI();
        summaryInitialization();



        this.setVisible(true);
    }


    /**
     * Initializes the menu bar with file and help options.
     */
    public void menuBarsInitialization() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loginItem = new JMenuItem("Login");
        fileMenu.add(loginItem);
        JMenu helpMenu = new JMenu("Help");

        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);

        JMenuItem helpItem = new JMenuItem("Help");
        helpMenu.add(helpItem);

        helpItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Exercise Tracker, Spring 2024", "Help", JOptionPane.INFORMATION_MESSAGE);
        });

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        loginItem.addActionListener(e -> {
            LoginFrame loginFrame = LoginFrame.getInstance(this);
            loginFrame.setVisible(true);
        });

        saveItem.addActionListener(e -> {
            saveText();
        });

        this.setJMenuBar(menuBar);
    }




    /**
     * Initializes the summary area for displaying workout data.
     */

    public void summaryInitialization() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(new JScrollPane(summaryArea), gbc);

    }



    /**
     * Sets up the GUI components like text fields and labels for input.
     */

    public void DisplayGUI() {

        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 50));
        this.add(nameField);

        JTextField dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(200, 50));
        this.add(dateField);





        JTextField durationField = new JTextField();
        durationField.setPreferredSize(new Dimension(200, 50));
        this.add(durationField);

        JTextField commentField = new JTextField();
        commentField.setPreferredSize(new Dimension(200, 50));
        this.add(commentField);

        JTextField distanceField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 50));
        this.add(distanceField);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // DropDown
        gbc.gridx = 0;
        gbc.gridy = 0;
        dropDown.addItem("RunWalk");
        dropDown.addItem("WeightLifting");
        dropDown.addItem("RockClimbing");

        add(dropDown, gbc);

        // Name
        gbc.gridy++;
        add(new JLabel("Name:"), gbc);

        nameField.setPreferredSize(new Dimension(200, 50));
        gbc.gridy++;
        add(nameField, gbc);

        // Date
        gbc.gridy++;
        add(new JLabel("Date:"), gbc);

        dateField.setPreferredSize(new Dimension(200, 50));
        gbc.gridy++;
        add(dateField, gbc);

        // Duration
        gbc.gridy++;
        add(new JLabel("Duration:"), gbc);

        durationField.setPreferredSize(new Dimension(200, 50));
        gbc.gridy++;
        add(durationField, gbc);

        //distance
        gbc.gridy++;
        add(new JLabel("Distance / Weight Lifted:"), gbc);

        distanceField.setPreferredSize(new Dimension(200, 50));
        gbc.gridy++;
        add(distanceField, gbc);


        // Comment
        gbc.gridy++;
        add(new JLabel("Add Comments:"), gbc);

        commentField.setPreferredSize(new Dimension(200, 50));
        gbc.gridy++;
        add(commentField, gbc);

        // Button
        gbc.gridy++;
        add(button, gbc);

        // Summary area
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(new JScrollPane(summaryArea), gbc);







        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                String name = nameField.getText().trim();
                String comment = commentField.getText().trim();
                String userDate = dateField.getText().trim();
                double distance = Double.parseDouble(distanceField.getText());
                double duration = Double.parseDouble(durationField.getText());

                if (name.isEmpty() || comment.isEmpty() || userDate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields. Date should be" +
                            " of form mm/dd/yyyy and duration must be greater than 0.", "Incomplete Data", JOptionPane.WARNING_MESSAGE);

                } else {



                    String selectedExercise = (String) dropDown.getSelectedItem();
                    RunWalk runwalk = new RunWalk(name, userDate, duration, distance, comment);
                    WeightLifting weightLifting = new WeightLifting(name, userDate, duration, 60, comment);
                    RockClimbing rockClimbing = new RockClimbing(name, userDate, duration, comment);


                    if ("RunWalk".equals(selectedExercise)) {
                        summaryArea.append("\n" + runwalk.toStringCustomInfo()+ "\t"+ "\t"+comment);
                    } else if ("WeightLifting".equals(selectedExercise)) {
                        summaryArea.append("\n" + weightLifting.toStringCustomInfo() + "\t"+"\t"+comment);
                    } else if ("RockClimbing".equals(selectedExercise)) {
                        summaryArea.append("\n" + rockClimbing.toStringCustomInfo() + "\t"+ "\t"+comment);
                    }
                }
            }
        });

    }



    /**
     * Saves the content of summaryArea to a user-specified file.
     */

    private void saveText() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(summaryArea.getText());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new ExerciseWriter();
    }
}






