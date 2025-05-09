package com.mentalfrostbyte.jello.event.impl.game.world;

import com.mentalfrostbyte.jello.event.CancellableEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShapes;

public class EventBlockCollision extends CancellableEvent {
    private BlockPos blockPos;
    private VoxelShape voxelShape;

    public EventBlockCollision(BlockPos var1, VoxelShape var2) {
        this.blockPos = var1;
        this.voxelShape = var2;
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    public VoxelShape getVoxelShape() {
        return this.voxelShape;
    }

    public void method13904(BlockPos var1) {
        this.blockPos = var1;
    }

    public void setVoxelShape(VoxelShape var1) {
        if (var1 == null) {
            var1 = VoxelShapes.create(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        }

        this.voxelShape = var1;
    }
}