package org.gayloc.ciallo;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Ciallo extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Ciallo(∠・ω< )⌒☆插件已启用");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Ciallo(∠・ω< )⌒☆插件已禁用");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ciallo")) {
            if (args.length == 1) {
                Player targetPlayer = Bukkit.getPlayer(args[0]);
                if (targetPlayer != null && targetPlayer.isOnline()) {
                    if (sender instanceof Player) {
                        Player senderPlayer = (Player) sender;
                        // 检查发送者和目标玩家是否是同一个人
                        if (!senderPlayer.equals(targetPlayer)) {
                            senderPlayer.playSound(senderPlayer.getLocation(), "minecraft:yuzusoft.ciallo", 1.0f, 1.0f);
                        }
                    }
                    targetPlayer.playSound(targetPlayer.getLocation(), "minecraft:yuzusoft.ciallo", 1.0f, 1.0f);
                    sender.sendMessage( sender.getName() + "对" + targetPlayer.getName() + "说Ciallo(∠・ω< )⌒☆");
                    return true;
                } else {
                    sender.sendMessage("未找到目标玩家");
                    return false;
                }
            } else {
                sender.sendMessage("用法: /ciallo <player>");
                return false;
            }
        }
        return false;
    }
}
