/**
 * @project lab05
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("$" + media.getCost() + " ");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addAddToCartButtonListener(addToCartButton);
        container.add(addToCartButton);

        if (this.media instanceof Playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);
            addPlayButtonListener(playButton);
        }


        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void addPlayButtonListener(JButton playButton) {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JDialog playDialog = new JDialog();
                playDialog.setTitle("Play Media");
                playDialog.setSize(400, 300);
                playDialog.setLayout(new BorderLayout());

                JLabel mediaLabel = new JLabel("Media playback goes here");
                try {
                    Playable playableMedia = (Playable) media;
                    playableMedia.play();
                } catch (Exception error) {
                    error.printStackTrace();
                }

                mediaLabel.setHorizontalAlignment(SwingConstants.CENTER);
                playDialog.add(mediaLabel, BorderLayout.CENTER);

                playDialog.setModal(true);
                playDialog.setAlwaysOnTop(true);
                playDialog.setVisible(true);
            }
        });
    }

    private void addAddToCartButtonListener(JButton addToCartButton) {
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.openCartScreen();
            }
        });
    }
}

