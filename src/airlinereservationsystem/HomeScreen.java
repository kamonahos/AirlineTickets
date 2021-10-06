package airlinereservationsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HomeScreen {

    private JFrame myframe; // instance variable of a JFrame
    private JDialog mydialog;

    public HomeScreen() {
        super();
        myframe = new JFrame(); // instantiation
        myframe.setTitle("Airline Reservation System");
        myframe.setSize(new Dimension(400, 600));
        myframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnNewTicket = new JButton("New Ticket");
        btnNewTicket.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mydialog = new JDialog();
                mydialog.setSize(new Dimension(800, 500));
                mydialog.setTitle("New Ticket");

                JTextField ticketId = new JTextField("Enter Ticket ID:");
                ticketId.setBounds(10, 10, 200, 30);
                mydialog.add(ticketId);

                JTextField issueDate = new JTextField("Enter Issue Date:");
                issueDate.setBounds(10, 60, 200, 30);
                mydialog.add(issueDate);

                JTextField clientName = new JTextField("Enter Client Name:");
                clientName.setBounds(10, 110, 200, 30);
                mydialog.add(clientName);

                JTextField itinenary = new JTextField("Enter Itinenary:");
                itinenary.setBounds(10, 160, 200, 30);
                mydialog.add(itinenary);

                JTextField ticketCost = new JTextField("Enter Ticket Cost:");
                ticketCost.setBounds(10, 210, 200, 30);
                mydialog.add(ticketCost);

                JTextField student = new JTextField("Enter Y/N if you are a Student:");
                student.setBounds(10, 260, 200, 30);
                mydialog.add(student);

                JTextField totalDiscount = new JTextField("Enter Total Discount");
                totalDiscount.setBounds(10, 310, 200, 30);
                mydialog.add(totalDiscount);

                JTextField luggage = new JTextField("Enter Number of Luggages:");
                luggage.setBounds(10, 360, 200, 30);
                mydialog.add(luggage);

                JTextField luggageWeight = new JTextField("Enter Luggage Weight");
                luggageWeight.setBounds(10, 410, 200, 30);
                mydialog.add(luggageWeight);

                JButton btnSave = new JButton("Save");
                btnSave.setBounds(10, 460, 200, 30);
                mydialog.getContentPane().add(btnSave);
                mydialog.setLayout(null);
                mydialog.setSize(400, 600);
                mydialog.setVisible(true);
                myframe.setVisible(false);
                btnSave.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("Tickets.txt", true));
                            bw.append(ticketId.getText() + " ");
                            bw.append(issueDate.getText() + " ");
                            bw.append(clientName.getText() + " ");
                            bw.append(itinenary.getText() + " ");
                            bw.append(ticketCost.getText() + " ");
                            bw.append(student.getText() + " ");
                            bw.append(totalDiscount.getText() + " ");
                            bw.append(luggage.getText() + " ");
                            bw.append(luggageWeight.getText() + System.lineSeparator());
                            bw.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        mydialog.setVisible(false);
                        myframe.setVisible(true);
                    }
                });

            }

        });

        myframe.getContentPane().add(btnNewTicket);

        JButton btnTicketList = new JButton("Ticket List");
        btnTicketList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mydialog = new JDialog();
                mydialog.setSize(new Dimension(800, 500));
                mydialog.setTitle("Ticket List");
                mydialog.setVisible(true);
                myframe.setVisible(false);

                try {
                  
                    String text = new String(Files.readAllBytes(Paths.get("asdf.txt")), StandardCharsets.UTF_8);
                    mydialog.setSize(new Dimension(1400, 800));
                    JTextArea textArea;
                    JScrollPane scrollPane;
                    JPanel panel;
                    JTextArea TicketList = new JTextArea(100, 100);
                    panel = new JPanel();
                    panel.setLayout(new FlowLayout(FlowLayout.LEADING));
                    textArea = new JTextArea();
                    textArea.setLineWrap(true);
                    textArea.setPreferredSize(new Dimension(400, 400));
                    textArea.setMinimumSize(new Dimension(400, 400));
                    textArea.setBounds(0, 0, 400, 400);
                    scrollPane = new JScrollPane(textArea);
                    scrollPane.setViewportView(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    TicketList = new JTextArea(text);
                    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK);
                    TicketList.setBorder(BorderFactory.createCompoundBorder(border,
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    TicketList.setEditable(false);                                       
                    panel.add(TicketList, BorderLayout.PAGE_START);
                    
                    mydialog.add(panel);
                    
                } catch (IOException ex) {
                    Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                JButton btnClose = new JButton("Close");                   
                mydialog.getContentPane().add(btnClose, BorderLayout.SOUTH);
                btnClose.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                      mydialog.setVisible(false);
                        myframe.setVisible(true);  
                        
                    }
                    
                });
                      
            }
                                                
        }); 
        
        myframe.getContentPane().add(btnTicketList);

        JButton btnAbout = new JButton("About");
        btnAbout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mydialog = new JDialog();
                mydialog.setSize(new Dimension(400, 100));
                mydialog.setTitle("About Page");
                JLabel AboutLabel;
                AboutLabel = new JLabel("<html><p>Project Name: airlinereservationsystem</p><p> Programmer Name:Christos Kamonachos</p><p> AM:131070</p><p> Project Expiration Date:13/06/2021</p>");

                ImageIcon imageIcon = new ImageIcon("Screenshot_14.png");
                JLabel label = new JLabel(imageIcon);

                mydialog.add(label);
                mydialog.add(AboutLabel);
                mydialog.setVisible(true);
                myframe.setVisible(false);
            }
        });
        myframe.getContentPane().add(btnAbout);

        JButton btnCloseProgram = new JButton("Close Program");
        btnCloseProgram.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the program?", "Exit Program Message Box",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    myframe.dispose();
                }
            }
        });
        myframe.getContentPane().add(btnCloseProgram);
        myframe.setVisible(true);
    }

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e1) {
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new HomeScreen();

                } catch (Exception e) {
                }
            }
        });
    }
}
