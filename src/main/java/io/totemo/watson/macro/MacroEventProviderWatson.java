package io.totemo.watson.macro;

import net.eq2online.macros.core.Macros;
import net.eq2online.macros.scripting.api.IMacroEvent;
import net.eq2online.macros.scripting.api.IMacroEventDispatcher;
import net.eq2online.macros.scripting.api.IMacroEventManager;
import net.eq2online.macros.scripting.api.IMacroEventProvider;

import java.util.Collections;
import java.util.List;

/**
 * Provides custom Watson events.
 */
public class MacroEventProviderWatson implements IMacroEventProvider {

    private MacroEventDispatcherWatson _eventDispatcher = new MacroEventDispatcherWatson();

    @Override
    public void onInit() {
        Macros.getInstance().getEventManager().registerEventProvider(this);
    }

    @Override
    public IMacroEventDispatcher getDispatcher() {
        return _eventDispatcher;
    }

    @Override
    public void registerEvents(IMacroEventManager manager) {
        manager.registerEvent(this, WatsonEvent.onWatsonDisplay);
        manager.registerEvent(this, WatsonEvent.onWatsonSelection);
    }

    @Override
    public List<String> getHelp(IMacroEvent macroEvent) {
        return Collections.singletonList("");
    }

}
