package net.minecraft.client.gui.achievement;

import java.util.Comparator;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.achievement.GuiStats$StatsItem;
import net.minecraft.item.Item;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;

class GuiStats$StatsItem$1 implements Comparator {

   // $FF: synthetic field
   final GuiStats field_148344_a;
   // $FF: synthetic field
   final GuiStats$StatsItem field_148343_b;


   GuiStats$StatsItem$1(GuiStats$StatsItem var1, GuiStats var2) {
      this.field_148343_b = var1;
      this.field_148344_a = var2;
   }

   public int compare(StatCrafting var1, StatCrafting var2) {
      int var3 = Item.getIdFromItem(var1.func_150959_a());
      int var4 = Item.getIdFromItem(var2.func_150959_a());
      StatBase var5 = null;
      StatBase var6 = null;
      if(this.field_148343_b.field_148217_o == 0) {
         var5 = StatList.objectBreakStats[var3];
         var6 = StatList.objectBreakStats[var4];
      } else if(this.field_148343_b.field_148217_o == 1) {
         var5 = StatList.objectCraftStats[var3];
         var6 = StatList.objectCraftStats[var4];
      } else if(this.field_148343_b.field_148217_o == 2) {
         var5 = StatList.objectUseStats[var3];
         var6 = StatList.objectUseStats[var4];
      }

      if(var5 != null || var6 != null) {
         if(var5 == null) {
            return 1;
         }

         if(var6 == null) {
            return -1;
         }

         int var7 = GuiStats.access$200(this.field_148343_b.field_148220_k).writeStat(var5);
         int var8 = GuiStats.access$200(this.field_148343_b.field_148220_k).writeStat(var6);
         if(var7 != var8) {
            return (var7 - var8) * this.field_148343_b.field_148215_p;
         }
      }

      return var3 - var4;
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.compare((StatCrafting)var1, (StatCrafting)var2);
   }
}
