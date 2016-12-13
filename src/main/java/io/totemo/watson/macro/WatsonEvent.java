package io.totemo.watson.macro;

import net.eq2online.macros.scripting.api.IMacroEventDefinition;

public enum WatsonEvent implements IMacroEventDefinition {

    onWatsonDisplay("onWatsonDisplay"),
    onWatsonSelection("onWatsonSelection");

    private final String name;
    private final String permissionGroup;

    WatsonEvent(String name) {
        this(name, null);
    }

    WatsonEvent(String name, String permissionGroup) {
        this.name = name;
        this.permissionGroup = permissionGroup;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPermissionGroup() {
        return permissionGroup;
    }

}
