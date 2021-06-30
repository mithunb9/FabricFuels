package avi.mods.fabricfuels;

import avi.mods.fabricfuels.blocks.FuelBlock;
import avi.mods.fabricfuels.items.FuelItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricFuelsMod implements ModInitializer {

	public static final String MODID = "fabricfuels";

	public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MODID, "main"))
			.icon(() -> new ItemStack(FabricFuelsMod.MINI_COAL))
			.build();

	public static final Item MINI_COAL = new FuelItem(new FabricItemSettings().group(FabricFuelsMod.MAIN_GROUP));
	public static final Item MINI_CHARCOAL = new FuelItem(new FabricItemSettings().group(FabricFuelsMod.MAIN_GROUP));

	public static final Block CHARCOAL_BLOCK = new FuelBlock(FabricBlockSettings.of(Material.STONE).hardness(6.0f).strength(1.0f));
	public static final Block BLAZE_BLOCK = new FuelBlock(FabricBlockSettings.of(Material.STONE).hardness(6.0f).strength(1.0f));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "mini_coal"), MINI_COAL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "mini_charcoal"), MINI_CHARCOAL);

		Registry.register(Registry.BLOCK, new Identifier(MODID, "charcoal_block"), CHARCOAL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MODID, "charcoal_block"), new BlockItem(CHARCOAL_BLOCK, new FabricItemSettings().group(FabricFuelsMod.MAIN_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "blaze_block"), BLAZE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MODID, "blaze_block"), new BlockItem(BLAZE_BLOCK, new FabricItemSettings().group(FabricFuelsMod.MAIN_GROUP)));

		FuelRegistry.INSTANCE.add(MINI_COAL,200);
		FuelRegistry.INSTANCE.add(MINI_CHARCOAL,200);
		FuelRegistry.INSTANCE.add(CHARCOAL_BLOCK, 16000);
		FuelRegistry.INSTANCE.add(BLAZE_BLOCK, 21600);
	}
}

