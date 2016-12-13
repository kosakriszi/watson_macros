package io.totemo.watson.macro;

import com.google.gson.Gson;
import com.mumfrey.liteloader.LiteMod;
import com.mumfrey.liteloader.modconfig.ConfigStrategy;
import com.mumfrey.liteloader.modconfig.ExposableOptions;
import watson.debug.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Main LiteMod entry point and event handler.
 *
 * @author totemo
 */
@ExposableOptions(strategy = ConfigStrategy.Versioned, filename = "watsonmacros.json")
public class LiteModWatsonMacros implements LiteMod {

    /**
     * Default constructor.
     */
    public LiteModWatsonMacros() {
    }

    @Override
    public String getName() {
        return "Watson Macro / Keybind Support";
    }

    @Override
    public String getVersion() {
        InputStream is = null;
        try {
            Gson gson = new Gson();
            is = getLiteModJsonStream();
            @SuppressWarnings("unchecked") Map<String, String> meta = gson.fromJson(new InputStreamReader(is), HashMap.class);
            String version = meta.get("version");
            if (version == null) {
                version = "(missing version info)";
            }
            return version;
        }
        catch (Exception ex) {
            return "(error loading version)";
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (Exception ex) {
                }
            }
        }
    }

    @Override
    public void init(File configPath) {
        try {
            new ScriptActionWatson().onInit();
            new VariableProviderWatson().onInit();
            new MacroEventProviderWatson().onInit();
            Log.info(getName() + " initialised");
        }
        catch (Exception ex) {
            Log.exception(Level.SEVERE, "failed to initialise " + getName(), ex);
        }
    }

    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath) {
    }

    /**
     * Return an InputStream that reads "/litemod.json".
     * <p>
     * When running under the IDE, that's easy because the file is copied to the
     * res/ directory and getResourceAsStream() can access it directly. When
     * running as an installed mod file, getResourceAsStream() may return a
     * reference to the litemod.json file for another mod, depending on the order
     * of the mods in the classloader. In that circumstance, we use a specially
     * crafted URL that references litemod.json via the URL of the .litemod (JAR)
     * file.
     *
     * @return the InputStream, or null on failure.
     */
    private InputStream getLiteModJsonStream() {
        String classURL = getClass().getResource("/" + getClass().getName().replace('.', '/') + ".class").toString();
        if (classURL.contains("!")) {
            String jarURL = classURL.substring(0, classURL.indexOf('!'));
            try {
                URL resourceURL = new URL(jarURL + "!/litemod.json");
                return resourceURL.openStream();
            }
            catch (IOException ex) {
            }
            return null;
        }
        else {
            // No JAR. Running under the IDE.
            return getClass().getResourceAsStream("/litemod.json");
        }
    }
}
