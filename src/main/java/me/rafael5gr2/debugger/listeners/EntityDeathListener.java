package me.rafael5gr2.debugger.listeners;

import me.rafael5gr2.debugger.Debugger;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import org.jetbrains.annotations.NotNull;

public class EntityDeathListener implements Listener {

    private final @NotNull Debugger debugger;

    public EntityDeathListener(final @NotNull Debugger debugger) {
        this.debugger = debugger;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDeathEvent(EntityDeathEvent event) {
        final LivingEntity livingEntity = event.getEntity();

        debugger.getComponentLogger().info(
                Component.text("DEBUG(EntityDeathEvent) for entity with uuid: " + livingEntity.getUniqueId()).color(NamedTextColor.DARK_GREEN)
        );

        debugger.getComponentLogger().info(
                Component.text(" Killer: " + (livingEntity.getKiller() != null ? livingEntity.getKiller().getName() : "It's not a player")).color(NamedTextColor.GREEN)
        );

        debugger.getComponentLogger().info(
                Component.text(" DroppedExp: " + event.getDroppedExp()).color(NamedTextColor.GREEN)
        );

        debugger.getComponentLogger().info(
                Component.text(" Drops:").color(NamedTextColor.GREEN)
        );

        event.getDrops().forEach(itemStack ->
                debugger.getComponentLogger().info(
                        Component.text("  - Material: " + itemStack.getType()).color(NamedTextColor.GREEN)
                )
        );

        debugger.getComponentLogger().info(
                Component.text(" Persistent Data Container:").color(NamedTextColor.GREEN)
        );

        final PersistentDataContainer persistentDataContainer = livingEntity.getPersistentDataContainer();
        persistentDataContainer.getKeys().forEach(namespacedKey -> {
            if (persistentDataContainer.has(namespacedKey, PersistentDataType.BYTE)) {
                debugger.getComponentLogger().info(
                        Component.text(
                                "  - Namespace: " + namespacedKey.getNamespace() +
                                        ", Key: " + namespacedKey.getKey() +
                                        ", Value(BYTE): " + persistentDataContainer.get(namespacedKey, PersistentDataType.BYTE)
                        ).color(NamedTextColor.GREEN)
                );
            } else if (persistentDataContainer.has(namespacedKey, PersistentDataType.SHORT)) {
                debugger.getComponentLogger().info(
                        Component.text(
                                "  - Namespace: " + namespacedKey.getNamespace() +
                                        ", Key: " + namespacedKey.getKey() +
                                        ", Value(SHORT): " + persistentDataContainer.get(namespacedKey, PersistentDataType.SHORT)
                        ).color(NamedTextColor.GREEN)
                );
            } else if (persistentDataContainer.has(namespacedKey, PersistentDataType.INTEGER)) {
                debugger.getComponentLogger().info(
                        Component.text(
                                "  - Namespace: " + namespacedKey.getNamespace() +
                                        ", Key: " + namespacedKey.getKey() +
                                        ", Value(INTEGER): " + persistentDataContainer.get(namespacedKey, PersistentDataType.INTEGER)
                        ).color(NamedTextColor.GREEN)
                );
            } else if (persistentDataContainer.has(namespacedKey, PersistentDataType.LONG)) {
                debugger.getComponentLogger().info(
                        Component.text(
                                "  - Namespace: " + namespacedKey.getNamespace() +
                                        ", Key: " + namespacedKey.getKey() +
                                        ", Value(LONG): " + persistentDataContainer.get(namespacedKey, PersistentDataType.LONG)
                        ).color(NamedTextColor.GREEN)
                );
            } else if (persistentDataContainer.has(namespacedKey, PersistentDataType.FLOAT)) {
                debugger.getComponentLogger().info(
                        Component.text(
                                "  - Namespace: " + namespacedKey.getNamespace() +
                                        ", Key: " + namespacedKey.getKey() +
                                        ", Value(FLOAT): " + persistentDataContainer.get(namespacedKey, PersistentDataType.FLOAT)
                        ).color(NamedTextColor.GREEN)
                );
            } else if (persistentDataContainer.has(namespacedKey, PersistentDataType.DOUBLE)) {
                debugger.getComponentLogger().info(
                        Component.text(
                                "  - Namespace: " + namespacedKey.getNamespace() +
                                        ", Key: " + namespacedKey.getKey() +
                                        ", Value(DOUBLE): " + persistentDataContainer.get(namespacedKey, PersistentDataType.DOUBLE)
                        ).color(NamedTextColor.GREEN)
                );
            } else if (persistentDataContainer.has(namespacedKey, PersistentDataType.STRING)) {
                debugger.getComponentLogger().info(
                        Component.text(
                                "  - Namespace: " + namespacedKey.getNamespace() +
                                        ", Key: " + namespacedKey.getKey() +
                                        ", Value(STRING): " + persistentDataContainer.get(namespacedKey, PersistentDataType.STRING)
                        ).color(NamedTextColor.GREEN)
                );
            } else {
                debugger.getComponentLogger().info(
                        Component.text(
                                "  - Namespace: " + namespacedKey.getNamespace() +
                                        ", Key: " + namespacedKey.getKey() +
                                        ", Value(???): ???"
                        ).color(NamedTextColor.GREEN)
                );
            }
        });
    }
}
