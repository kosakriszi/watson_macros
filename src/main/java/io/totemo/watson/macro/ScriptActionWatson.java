package io.totemo.watson.macro;

import net.eq2online.macros.scripting.ScriptActionBase;
import net.eq2online.macros.scripting.api.*;
import net.eq2online.macros.scripting.parser.ScriptContext;
import net.minecraft.client.Minecraft;
import watson.LiteModWatson;

/**
 * A Macro/Keybind Mod script action for a WATSON(&lt;string&gt;) command.
 */
public class ScriptActionWatson extends ScriptActionBase {

    /**
     * Default constructor.
     */
    public ScriptActionWatson() {
        super(ScriptContext.MAIN, "watson");
    }

    @Override
    public void onInit() {
        getContext().getCore().registerScriptAction(this);
    }

    @Override
    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction action, String command, String[] args) {
        LiteModWatson.sendChatMessage(Minecraft.getMinecraft().player, command);
        return null;
    }

    @Override
    public boolean isThreadSafe() {
        return false;
    }

    @Override
    public boolean isStackPushOperator() {
        return false;
    }

    @Override
    public boolean isStackPopOperator() {
        return false;
    }

    @Override
    public boolean canBePoppedBy(IScriptAction action) {
        return false;
    }

    @Override
    public boolean executeStackPush(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        return false;
    }

    @Override
    public boolean executeStackPop(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params, IMacroAction popAction) {
        return false;
    }

    @Override
    public boolean canBreak(IMacroActionProcessor processor, IScriptActionProvider provider, IMacro macro, IMacroAction instance, IMacroAction breakAction) {
        return false;
    }

    @Override
    public boolean isConditionalOperator() {
        return false;
    }

    @Override
    public boolean isConditionalElseOperator(IScriptAction action) {
        return false;
    }

    @Override
    public boolean matchesConditionalOperator(IScriptAction action) {
        return false;
    }

    @Override
    public boolean executeConditional(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        return false;
    }

    @Override
    public void executeConditionalElse(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params, IMacroActionStackEntry top) {
    }

    @Override
    public boolean canExecuteNow(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        return true;
    }

    @Override
    public int onTick(IScriptActionProvider provider) {
        return 0;
    }

    @Override
    public boolean isClocked() {
        return false;
    }

    @Override
    public boolean isPermissable() {
        return false;
    }

    @Override
    public String getPermissionGroup() {
        return null;
    }

    @Override
    public void registerPermissions(String actionName, String actionGroup) {
    }

    @Override
    public boolean checkExecutePermission() {
        return true;
    }

    @Override
    public boolean checkPermission(String actionName, String permission) {
        return false;
    }

    @Override
    public void onStopped(IScriptActionProvider provider, IMacro macro, IMacroAction instance) {
    }

}
