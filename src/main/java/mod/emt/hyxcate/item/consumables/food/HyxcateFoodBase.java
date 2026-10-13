package mod.emt.hyxcate.item.consumables.food;

import mod.emt.hyxcate.init.HyxcateItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFood;
import net.minecraft.init.MobEffects;
import mod.emt.hyxcate.init.HyxcatePotions;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class HyxcateFoodBase extends ItemFood {

    /**
     * FoodBase templates, with the possibility to add up to 3 potion effects, food with potion effects are consumable regardless of the player's hunger state.
     */

    public HyxcateFoodBase(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
    }

    public HyxcateFoodBase(int amount, float saturation, boolean isWolfFood, PotionEffect potionEffect, float effectProbability) {
        super(amount, saturation, isWolfFood);
        this.setPotionEffect(potionEffect, effectProbability);
        setAlwaysEdible();
    }

    public HyxcateFoodBase(int amount, float saturation, boolean isWolfFood, PotionEffect potionEffect1, float effectProbability1,
                           PotionEffect potionEffect2, float effectProbability2) {
        super(amount, saturation, isWolfFood);
        this.setPotionEffect(potionEffect1, effectProbability1);
        this.setPotionEffect(potionEffect2, effectProbability2);
        setAlwaysEdible();
    }

    public HyxcateFoodBase(int amount, float saturation, boolean isWolfFood, PotionEffect potionEffect1, float effectProbability1,
                           PotionEffect potionEffect2, float effectProbability2, PotionEffect potionEffect3, float effectProbability3) {
        super(amount, saturation, isWolfFood);
        this.setPotionEffect(potionEffect1, effectProbability1);
        this.setPotionEffect(potionEffect2, effectProbability2);
        this.setPotionEffect(potionEffect3, effectProbability3);
        setAlwaysEdible();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
        if (this == HyxcateItems.moonBreaker) {
            tooltip.add(TextFormatting.GRAY + I18n.format("tooltip.hyxcate.moonbreaker_candy"));
        }
    }
}