package com.zerulus.game.tiles.blocks;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

import com.zerulus.game.util.Vector2f;
import com.zerulus.game.util.AABB;

public class HoleBlock extends Block {

    public HoleBlock(BufferedImage img, Vector2f pos, int w, int h) {
        super(img, pos, w, h);
    }

    public boolean update(AABB p) {
        return false;
    }

    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.green);
        g.drawRect((int) pos.getWorldVar().x, (int) pos.getWorldVar().y, w, h);
    }
}