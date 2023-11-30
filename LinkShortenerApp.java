import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LinkShortenerApp {
    private static final Map<String, String> linkMap = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Link Shortener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel longUrlLabel = new JLabel("Enter Long URL:");
        longUrlLabel.setBounds(10, 20, 120, 25);
        panel.add(longUrlLabel);

        JTextField longUrlText = new JTextField(20);
        longUrlText.setBounds(140, 20, 200, 25);
        panel.add(longUrlText);

        JButton shortenButton = new JButton("Shorten URL");
        shortenButton.setBounds(10, 80, 150, 25);
        panel.add(shortenButton);

        JLabel shortUrlLabel = new JLabel("Shortened URL:");
        shortUrlLabel.setBounds(10, 120, 120, 25);
        panel.add(shortUrlLabel);

        JTextField shortUrlText = new JTextField(20);
        shortUrlText.setBounds(140, 120, 200, 25);
        shortUrlText.setEditable(false);
        panel.add(shortUrlText);

        JButton retrieveButton = new JButton("Retrieve Long URL");
        retrieveButton.setBounds(10, 160, 200, 25);
        panel.add(retrieveButton);

        JButton printListButton = new JButton("Print Shortened URLs");
        printListButton.setBounds(220, 160, 200, 25);
        panel.add(printListButton);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(10, 200, 500, 150);
        panel.add(scrollPane);

        retrieveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shortLink = shortUrlText.getText();  // Corrected line
                String longUrl = retrieve(shortLink);
                if (longUrl != null) {
                    longUrlText.setText(longUrl);
                } else {
                    JOptionPane.showMessageDialog(null, "Short link not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        shortenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String longUrl = longUrlText.getText();
                String shortLink = shorten(longUrl);
                linkMap.put(shortLink, longUrl);
                shortUrlText.setText(shortLink);
            }
        });

        printListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printShortenedURLs(outputArea);
            }
        });
    }

    private static String shorten(String longUrl) {
        UUID uuid = UUID.nameUUIDFromBytes(longUrl.getBytes());
        return Base64.getUrlEncoder().encodeToString(uuid.toString().getBytes()).substring(0, 8);
    }

    private static String retrieve(String shortLink) {
        return linkMap.get(shortLink);
    }

    private static void printShortenedURLs(JTextArea outputArea) {
        outputArea.setText("Shortened URLs and their corresponding Long URLs:\n");
        for (Map.Entry<String, String> entry : linkMap.entrySet()) {
            outputArea.append(entry.getKey() + " -> " + entry.getValue() + "\n");
        }
    }
}
