import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AutoCompleteSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Autocomplete com Swing");
        JTextField textField = new JTextField(20);
        JPopupMenu suggestionPopup = new JPopupMenu();

        // Lista de sugestões pré-definidas
        List<String> suggestions = List.of("Brasil", "Brasília", "Bahia", "Belém", "Belo Horizonte");

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = textField.getText().toLowerCase();
                suggestionPopup.removeAll(); // Limpa as sugestões anteriores

                if (!input.isEmpty()) {
                    List<String> filteredSuggestions = new ArrayList<>();
                    for (String suggestion : suggestions) {
                        if (suggestion.toLowerCase().contains(input)) {
                            filteredSuggestions.add(suggestion);
                        }
                    }

                    // Adiciona as sugestões filtradas no popup
                    for (String suggestion : filteredSuggestions) {
                        JMenuItem item = new JMenuItem(suggestion);
                        item.addActionListener(event -> {
                            textField.setText(suggestion);
                            suggestionPopup.setVisible(false);
                        });
                        suggestionPopup.add(item);
                    }

                    // Exibe o popup se houver sugestões
                    if (!filteredSuggestions.isEmpty()) {
                        suggestionPopup.show(textField, 0, textField.getHeight());
                    } else {
                        suggestionPopup.setVisible(false);
                    }
                } else {
                    suggestionPopup.setVisible(false);
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textField);
        frame.setSize(300, 200);
        frame.setLayout(null);
        textField.setBounds(50, 50, 200, 30); // Define a posição do campo de texto
        frame.setVisible(true);
    }
}
