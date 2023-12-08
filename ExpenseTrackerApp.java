import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Expense {
    private String description;
    private double amount;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

public class ExpenseTrackerApp {
    private List<Expense> expenses = new ArrayList<>();
    private JTextField descriptionField, amountField, categoryField;
    private JTextArea resultArea;

    private Map<String, Double> categoryTotal = new HashMap<>();

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Expense Tracker App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextField(20);
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(20);
        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(20);

        JButton addButton = new JButton("Add Expense");
        JButton viewAllButton = new JButton("View All Expenses");
        JButton viewCategoryTotalButton = new JButton("View Category Total");

        resultArea = new JTextArea("", 10, 30);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });

        viewAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewAllExpenses();
            }
        });

        viewCategoryTotalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewCategoryTotal();
            }
        });

        panel.add(descriptionLabel);
        panel.add(descriptionField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(addButton);
        panel.add(viewAllButton);
        panel.add(viewCategoryTotalButton);

        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, resultArea);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addExpense() {
        String description = descriptionField.getText();
        double amount = Double.parseDouble(amountField.getText());
        String category = categoryField.getText();

        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);

        // Update category total
        categoryTotal.put(category, categoryTotal.getOrDefault(category, 0.0) + amount);

        displayExpenses();

        // Clear text fields after adding an expense
        descriptionField.setText("");
        amountField.setText("");
        categoryField.setText("");
    }

    private void displayExpenses() {
        StringBuilder result = new StringBuilder("Expense List:\n");

        for (Expense expense : expenses) {
            result.append("Description: ").append(expense.getDescription()).append(", Amount: Rs")
                    .append(expense.getAmount()).append(", Category: ").append(expense.getCategory()).append("\n");
        }

        resultArea.setText(result.toString());
    }

    private void viewAllExpenses() {
        JFrame expensesFrame = new JFrame("Expense List");
        JTextArea expensesTextArea = new JTextArea("", 10, 30);
        JScrollPane scrollPane = new JScrollPane(expensesTextArea);

        StringBuilder result = new StringBuilder("Expense List:\n");

        for (Expense expense : expenses) {
            result.append("Description: ").append(expense.getDescription()).append(", Amount: Rs")
                    .append(expense.getAmount()).append(", Category: ").append(expense.getCategory()).append("\n");
        }

        expensesTextArea.setText(result.toString());

        expensesFrame.getContentPane().add(scrollPane);
        expensesFrame.setSize(400, 300);
        expensesFrame.setLocationRelativeTo(null);
        expensesFrame.setVisible(true);
    }

    private void viewCategoryTotal() {
        String categoryToView = JOptionPane.showInputDialog("Enter Category to view total expenses:");

        if (categoryTotal.containsKey(categoryToView)) {
            double total = categoryTotal.get(categoryToView);
            resultArea.setText("Total expenses for category " + categoryToView + ": Rs" + total);
        } else {
            resultArea.setText("No expenses found for category " + categoryToView);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExpenseTrackerApp().createAndShowGUI();
        });
    }
}
