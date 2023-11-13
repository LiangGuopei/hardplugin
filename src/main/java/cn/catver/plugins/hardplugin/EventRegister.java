package cn.catver.plugins.hardplugin;

import cn.catver.plugins.hardplugin.rule.cannotEmptyBreakBlock.cannotEmptyBreakBlock;
import cn.catver.plugins.hardplugin.rule.cannotNoToolsBreakBlock.cannotNoToolsBreakBlock;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class EventRegister {
    Map<String, Listener> events = new HashMap<>();
    public EventRegister(Hardplugin hardplugin){
        Logger logger = hardplugin.getLogger();

        //TODO 写在这里
        events.put("cannotEmptyBreakBlock",new cannotEmptyBreakBlock());
        events.put("cannotNoToolsBreakBlock",new cannotNoToolsBreakBlock());

        logger.info("正在导入事件！");
        for (Map.Entry<String, Listener> entry : events.entrySet()) {
            Bukkit.getPluginManager().registerEvents(entry.getValue(),hardplugin);
            logger.info(String.format("%s事件导入完成！", entry.getKey()));

        }
        logger.info("所有事件导入完成");
    }
}
