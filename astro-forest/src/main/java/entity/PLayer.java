package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.astroforest.GamePanel;
import com.astroforest.KeyHandler;

public final class PLayer extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public PLayer(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down"; 
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/The Male adventurer - Free/Walk/walk_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/The Male adventurer - Free/Walk/walk_up2.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/The Male adventurer - Free/Walk/walk_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/The Male adventurer - Free/Walk/walk_down2.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/The Male adventurer - Free/Walk/walk_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/The Male adventurer - Free/Walk/walk_left2.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/The Male adventurer - Free/Walk/walk_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/The Male adventurer - Free/Walk/walk_right2.png"));

        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Erro ao carregar imagens do player: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = switch (direction) {
            case "up" -> (spriteNum == 1) ? up1 : up2;
            case "down" -> (spriteNum == 1) ? down1 : down2;
            case "left" -> (spriteNum == 1) ? left1 : left2;
            case "right" -> (spriteNum == 1) ? right1 : right2;
            default -> null;
        };

        if (image != null) {
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }
    }
}
