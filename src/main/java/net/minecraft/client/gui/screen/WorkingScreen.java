package net.minecraft.client.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import javax.annotation.Nullable;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.optifine.CustomLoadingScreen;
import net.optifine.CustomLoadingScreens;

public class WorkingScreen extends Screen implements IProgressUpdate
{
    @Nullable
    private ITextComponent field_238648_a_;
    @Nullable
    private ITextComponent stage;
    private int progress;
    private boolean doneWorking;
    private CustomLoadingScreen customLoadingScreen = CustomLoadingScreens.getCustomLoadingScreen();

    public WorkingScreen()
    {
        super(NarratorChatListener.EMPTY);
    }

    public boolean shouldCloseOnEsc()
    {
        return false;
    }

    public void displaySavingString(ITextComponent component)
    {
        this.resetProgressAndMessage(component);
    }

    public void resetProgressAndMessage(ITextComponent component)
    {
        this.field_238648_a_ = component;
        this.displayLoadingString(new TranslationTextComponent("progress.working"));
    }

    public void displayLoadingString(ITextComponent component)
    {
        this.stage = component;
        this.setLoadingProgress(0);
    }

    /**
     * Updates the progress bar on the loading screen to the specified amount.
     */
    public void setLoadingProgress(int progress)
    {
        this.progress = progress;
    }

    public void setDoneWorking()
    {
        this.doneWorking = true;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta)
    {
        if (this.doneWorking)
        {
            this.minecraft.displayGuiScreen((Screen)null);
        }
        else
        {
            if (this.customLoadingScreen != null && this.minecraft.world == null)
            {
                this.customLoadingScreen.drawBackground(this.width, this.height);
            }
            else
            {
                this.renderBackground(matrices);
            }

            if (this.progress > 0)
            {
                if (this.field_238648_a_ != null)
                {
                    drawCenteredString(matrices, this.font, this.field_238648_a_, this.width / 2, 70, 16777215);
                }

                if (this.stage != null && this.progress != 0)
                {
                    drawCenteredString(matrices, this.font, (new StringTextComponent("")).append(this.stage).appendString(" " + this.progress + "%"), this.width / 2, 90, 16777215);
                }
            }

            super.render(matrices, mouseX, mouseY, delta);
        }
    }
}
