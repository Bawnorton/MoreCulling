package ca.fxco.moreculling.config.cloth;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;

public class DynamicEnumBuilder<T extends Enum<?>> extends AbstractDynamicBuilder<T, DynamicEnumEntry<T>, DynamicEnumBuilder<T>> {
    private final Class<T> clazz;
    @Nullable
    private Function<T, Component> enumNameProvider;

    public DynamicEnumBuilder(String translationKey, Class<T> clazz) {
        super(translationKey);
        Objects.requireNonNull(clazz);
        this.clazz = clazz;
    }

    public DynamicEnumBuilder(String translationKey, Component resetButtonKey, Class<T> clazz) {
        super(translationKey, resetButtonKey);
        Objects.requireNonNull(clazz);
        this.clazz = clazz;
    }

    public DynamicEnumBuilder<T> setEnumNameProvider(Function<T, Component> enumNameProvider) {
        this.enumNameProvider = enumNameProvider;
        return this;
    }

    @NotNull
    public DynamicEnumEntry<T> runBuild() {
        DynamicEnumEntry<T> entry = new DynamicEnumEntry<>(this, this.clazz, this.enumNameProvider);
        entry.setTooltipSupplier(() -> this.tooltipSupplier.apply(entry.getValue()));
        if (this.errorSupplier != null) {
            entry.setErrorSupplier(() -> this.errorSupplier.apply(entry.getValue()));
        }
        return entry;
    }
}
