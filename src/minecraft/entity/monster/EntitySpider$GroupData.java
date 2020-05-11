package net.minecraft.entity.monster;

import java.util.Random;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.potion.Potion;

public class EntitySpider$GroupData implements IEntityLivingData {

   public int field_111105_a;


   public void func_111104_a(Random var1) {
      int var2 = var1.nextInt(5);
      if(var2 <= 1) {
         this.field_111105_a = Potion.moveSpeed.id;
      } else if(var2 <= 2) {
         this.field_111105_a = Potion.damageBoost.id;
      } else if(var2 <= 3) {
         this.field_111105_a = Potion.regeneration.id;
      } else if(var2 <= 4) {
         this.field_111105_a = Potion.invisibility.id;
      }

   }
}
