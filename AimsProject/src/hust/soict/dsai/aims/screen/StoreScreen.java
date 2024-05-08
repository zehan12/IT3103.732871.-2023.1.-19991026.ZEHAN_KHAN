/**
 * @project lab05
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreScreen extends JFrame {
    private final Store store;

    public StoreScreen(Store store) {
        this.store = store;

        // Listen for changes in the store's item list
        this.store.getItemsInStore().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Media> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                // Code to update UI components with new media
                            }
                        });
                    }
                }
            }
        });

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();

        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        addBookMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen();
            }
        });
        JMenuItem addCompactDiscMenu = new JMenuItem("Add CD");
        addCompactDiscMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen();
            }
        });
        JMenuItem addDigitalVideoDiscMenu = new JMenuItem("Add DVD");
        addDigitalVideoDiscMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen();
            }
        });

        smUpdateStore.add(addBookMenu);
        smUpdateStore.add(addCompactDiscMenu);
        smUpdateStore.add(addDigitalVideoDiscMenu);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));

        JMenuItem viewCartMenu = new JMenuItem("View Cart");
        viewCartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.openCartScreen();
            }
        });
        menu.add(viewCartMenu);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton btnCart = new JButton("View Cart");
        btnCart.setPreferredSize(new Dimension(100, 50));
        btnCart.setMaximumSize(new Dimension(100, 50));

        btnCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.openCartScreen();
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JScrollPane createCenter() {
        // Panel that will be scrollable
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));

        // Panel with GridLayout for media items
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(0, 3, 2, 2)); // 0 rows means any number of rows, 3 columns

        ObservableList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            gridPanel.add(new MediaStore(media));
        }

        // Add the grid panel to the scroll panel
        scrollPanel.add(gridPanel);

        // Create a JScrollPane that contains the scroll panel
        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        return scrollPane;
    }
}
