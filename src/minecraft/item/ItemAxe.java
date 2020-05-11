package net.minecraft.item;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item$ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemAxe extends ItemTool {

   private static final Set field_150917_c = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});


   protected ItemAxe(Item$ToolMaterial var1) {
      super(3.0F, var1, field_150917_c);
   }

   public float func_150893_a(ItemStack var1, Block var2) {
      return var2.getMaterial() != Material.wood && var2.getMaterial() != Material.plants && var2.getMaterial() != Material.vine?super.func_150893_a(var1, var2):super.efficiencyOnProperMaterial;
   }

}
