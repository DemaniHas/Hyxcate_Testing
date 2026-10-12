package mod.emt.hyxcate.init;

import mod.emt.hyxcate.Hyxcate;
import mod.emt.hyxcate.potion.HyxcatePotionCelestialErasure;
import mod.emt.hyxcate.potion.HyxcatePotionDeepFreeze;
import mod.emt.hyxcate.potion.HyxcatePotionInferno;
import mod.emt.hyxcate.potion.HyxcatePotionParalysis;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class HyxcatePotions {
    public static Potion ASTRAL_EROSION, DEEP_FREEZE, INFERNO, PARALYSIS;
    public static PotionType PARALYSIS_NORMAL, PARALYSIS_LONG;

    private static Potion registerPotion(String name, Potion potion) {
        potion.setRegistryName(new ResourceLocation(Hyxcate.ID, name)).setPotionName("effect." + Hyxcate.ID + "." + name + ".name");
        ForgeRegistries.POTIONS.register(potion);
        return potion;
    }

    public static void potionInit() {

        ASTRAL_EROSION = registerPotion("astral_erosion", new HyxcatePotionCelestialErasure("astral_erosion", true, 16769431));
        DEEP_FREEZE = registerPotion("deep_freeze", new HyxcatePotionDeepFreeze("deep_freeze", true, 12638975)
                .registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, HyxcateAttributes.MOVEMENT_SPEED_ID.toString(), -0.25D, 2)
                .registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, HyxcateAttributes.ATTACK_SPEED_ID.toString(), -0.2D, 2));
        INFERNO = registerPotion("inferno", new HyxcatePotionInferno("inferno", true, 5570560));
        PARALYSIS = registerPotion("paralysis", new HyxcatePotionParalysis("paralysis", true, 16772589)
                .registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, HyxcateAttributes.MOVEMENT_SPEED_ID.toString(), -1.0D, 2)
                .registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, HyxcateAttributes.ATTACK_SPEED_ID.toString(), -1.0D, 2));
    }

}

