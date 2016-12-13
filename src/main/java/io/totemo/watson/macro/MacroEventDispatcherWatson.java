package io.totemo.watson.macro;

import net.eq2online.macros.scripting.api.IMacroEventDispatcher;
import net.eq2online.macros.scripting.api.IMacroEventManager;
import net.minecraft.client.Minecraft;
import watson.Controller;

/**
 * Decides when to dispatch Watson custom events.
 */
public class MacroEventDispatcherWatson implements IMacroEventDispatcher {

    @Override
    public void onTick(IMacroEventManager manager, Minecraft minecraft) {
        if (minecraft == null || minecraft.player == null || minecraft.world == null) {
            return;
        }

        if (Controller.instance.isSelectionChanged()) {
            manager.sendEvent(WatsonEvent.onWatsonSelection.getName(), 10);
        }
        if (Controller.instance.getDisplaySettings().isDisplayVisibilityChanged()) {
            manager.sendEvent(WatsonEvent.onWatsonDisplay.getName(), 10);
        }
    }

}
