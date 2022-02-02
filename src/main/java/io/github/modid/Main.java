package io.github.modid;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final String MODID = "modid";/*将modid添加到字符串静态常量类MODID*/

	public static final Item EXAMPLE_ITEM = new Item (new Item.Settings().group(EXAMPLE_ITEMGROUP_1));/*添加物品静态常量类EXAMPLE_ITEM并添加到创造模式物品栏EXAMPLE_ITEMGROUP_1*/

	public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.0f));/*添加方块静态常量类EXAMPLE_BLOCK*/

	public static final ItemGroup EXAMPLE_ITEMGROUP_1 = FabricItemGroupBuilder.build(new Identifier(MODID, "example_itemgroup_1"), () -> new ItemStack(Main.EXAMPLE_ITEM));/*添加创造模式物品栏静态常量类EXAMPLE_ITEMGROUP_1, 注册EXAMPLE_ITEMGROUP_1为itemGroup.modid.example_itemgroup_1*/
	public static final ItemGroup EXAMPLE_ITEMGROUP_2 = FabricItemGroupBuilder.create(
		new Identifier("tutorial", "other"))
		.icon(() -> new ItemStack(EXAMPLE_BLOCK))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(Blocks.BONE_BLOCK));
			stacks.add(new ItemStack(Items.APPLE));
			stacks.add(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER));
			stacks.add(ItemStack.EMPTY);
			stacks.add(new ItemStack(Main.EXAMPLE_ITEM));
		})
		.build();

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MODID, "example_item"), EXAMPLE_ITEM);/*注册EXAMPLE_ITEM为item.modid.example_item*/
		Registry.register(Registry.BLOCK, new Identifier(MODID, "example_block"), EXAMPLE_BLOCK);/*注册EXAMPLE_BLOCK为block.modid.example_block*/
		Registry.register(Registry.ITEM, new Identifier(MODID, "example_block"), new BlockItem(EXAMPLE_BLOCK, new Item.Settings().group(EXAMPLE_ITEMGROUP_1)));/*注册EXAMPLE_BLOCK为item.modid.example_block并添加到创造模式物品栏EXAMPLE_ITEMGROUP_1*/

		FuelRegistry.INSTANCE.add(EXAMPLE_ITEM, 80);
	}
}
