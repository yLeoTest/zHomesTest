package me.yleoft.zHomes.utils;

import java.util.List;
import me.yleoft.zHomes.Main;
import org.bukkit.entity.Player;

public class ConfigUtils {
    private static Main main = Main.getInstance();

    protected String cmdPath = "commands.";
    protected String databasePath = "database.";
    protected String lim = "limits.";
    protected String tpo = "teleport-options.";

    public static String langType() {
        return main.getConfig().getString("general.language");
    }
    public String prefix() {
        return main.getConfig().getString("prefix");
    }

    //<editor-fold desc="Plugin Information">
    public boolean canDimensionalTeleport() {
        return main.getConfig().getBoolean(this.tpo + "dimensional-teleportation");
    }
    public boolean needsLimit() {
        return main.getConfig().getBoolean(this.lim + "enabled");
    }
    public int getMaxLimit(Player p) {
        int l = -1;
        for (String str : main.getConfig().getConfigurationSection(lim.split("\\.")[0]).getKeys(false)) {
            if (str.equals("enabled") || str.equals("default")) continue;
            try {
                int i = Integer.parseInt(str);
                for (String perm : main.getConfig().getStringList(lim+str)) {
                    if (p.hasPermission(perm) && i > l) l = i;
                }
            } catch (Exception e) {
                main.getServer().getConsoleSender().sendMessage(main.coloredPluginName + "§cSomething's off in config.yml");
            }
        }
        return (l == -1) ? main.getConfig().getInt(lim+"default") : l;
    }
    //</editor-fold>

    //<editor-fold desc="Main Command">
    public String CmdMainCommand() {
        return main.getConfig().getString(this.cmdPath + "main.command");
    }
    public String CmdMainPermission() {
        return main.getConfig().getString(this.cmdPath + "main.permission");
    }
    public String CmdMainDescription() {
        return main.getConfig().getString(this.cmdPath + "main.description");
    }
    public List<String> CmdMainAliases() {
        return main.getConfig().getStringList(this.cmdPath + "main.aliases");
    }
    public String CmdMainHelpPermission() {
        return main.getConfig().getString(this.cmdPath + "main.help.permission");
    }
    public String CmdMainVersionPermission() {
        return main.getConfig().getString(this.cmdPath + "main.version.permission");
    }
    public String CmdMainReloadPermission() {
        return main.getConfig().getString(this.cmdPath + "main.reload.permission");
    }
    public String CmdMainMigratePermission() {
        return main.getConfig().getString(this.cmdPath + "main.migrate.permission");
    }
    //</editor-fold>
    //<editor-fold desc="Sethome Command">
    public String CmdSethomeCommand() {
        return main.getConfig().getString(this.cmdPath + "sethome.command");
    }
    public String CmdSethomePermission() {
        return main.getConfig().getString(this.cmdPath + "sethome.permission");
    }
    public String CmdSethomeDescription() {
        return main.getConfig().getString(this.cmdPath + "sethome.description");
    }
    public List<String> CmdSethomeAliases() {
        return main.getConfig().getStringList(this.cmdPath + "sethome.aliases");
    }
    //</editor-fold>
    //<editor-fold desc="Delhome Command">
    public String CmdDelhomeCommand() {
        return main.getConfig().getString(this.cmdPath + "delhome.command");
    }
    public String CmdDelhomePermission() {
        return main.getConfig().getString(this.cmdPath + "delhome.permission");
    }
    public String CmdDelhomeDescription() {
        return main.getConfig().getString(this.cmdPath + "delhome.description");
    }
    public List<String> CmdDelhomeAliases() {
        return main.getConfig().getStringList(this.cmdPath + "delhome.aliases");
    }
    public String CmdDelhomeOthersPermission() {
        return main.getConfig().getString(this.cmdPath + "delhome.others.permission");
    }
    //</editor-fold>
    //<editor-fold desc="Homes Command">
    public String CmdHomesCommand() {
        return main.getConfig().getString(this.cmdPath + "homes.command");
    }
    public String CmdHomesPermission() {
        return main.getConfig().getString(this.cmdPath + "homes.permission");
    }
    public String CmdHomesDescription() {
        return main.getConfig().getString(this.cmdPath + "homes.description");
    }
    public List<String> CmdHomesAliases() {
        return main.getConfig().getStringList(this.cmdPath + "homes.aliases");
    }
    //</editor-fold>
    //<editor-fold desc="Home Command">
    public String CmdHomeCommand() {
        return main.getConfig().getString(this.cmdPath + "home.command");
    }
    public String CmdHomePermission() {
        return main.getConfig().getString(this.cmdPath + "home.permission");
    }
    public String CmdHomeDescription() {
        return main.getConfig().getString(this.cmdPath + "home.description");
    }
    public List<String> CmdHomeAliases() {
        return main.getConfig().getStringList(this.cmdPath + "home.aliases");
    }
    public String CmdHomeOthersPermission() {
        return main.getConfig().getString(this.cmdPath + "home.others.permission");
    }
    //</editor-fold>

    //<editor-fold desc="Permissions">
    public String PermissionBypassDT() {
        return "zhomes.bypass.dimensionalteleportation";
    }
    //</editor-fold>

    //<editor-fold desc="Database">
    public Boolean databaseEnabled() {
        return Boolean.valueOf(main.getConfig().getBoolean(this.databasePath + "enabled"));
    }
    public String databaseHost() {
        return main.getConfig().getString(this.databasePath + "host");
    }
    public Integer databasePort() {
        return Integer.valueOf(main.getConfig().getInt(this.databasePath + "port"));
    }
    public String databaseDatabase() {
        return main.getConfig().getString(this.databasePath + "database");
    }
    public String databaseUsername() {
        return main.getConfig().getString(this.databasePath + "username");
    }
    public String databasePassword() {
        return main.getConfig().getString(this.databasePath + "password");
    }
    public String databaseTable() {
        return main.getConfig().getString(this.databasePath + "table").toUpperCase();
    }
    //</editor-fold>

}
