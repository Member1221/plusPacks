package com.plusmods.oresplus;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = OresPlus.MODID, version = OresPlus.VERSION)
public class OresPlus {

	public static final String MODID = "OresPlus";
    public static final String VERSION = "1.1.0";

	//@SidedProxy(clientSide="com.plusmods.oresplus.ClientProxy", serverSide="com.plusmods.oresplus.CommonProxy")
    //@SidedProxy(clientSide="mod.mcreator.ClientProxyTestEnvironmentMod", serverSide="mod.mcreator.CommonProxyTestEnvironmentMod")
    public static CommonProxy proxy;
    //public static EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel("MCRBUS", new ChannelHandlerTestEnvironmentMod());

	@Instance(value = "oresplus")
    public static OresPlus instance;
	
	
	//Blocks
		public static Block jadeStone;
		public static Block theisOre;
		public static Block rubyOre;
		public static Block sapphireOre;
		public static Block amethystOre;

	
	//Items
		public static Item jade;
		public static Item theisIngot;
		public static Item ruby;
		public static Item sapphire;
		public static Item amethyst;
		
		
		public static Item citrine;
		
	//Tools
		public static Item jadePickaxe;
		public static Item rubyPickaxe;
		public static Item sapphirePickaxe;


	public void serverLoad(FMLServerStartingEvent event) 
	{
		
	}
	
	@EventHandler
	public void load(FMLPreInitializationEvent event) 
	{
			//Jade
				jade = new ItemJade(5000).setCreativeTab(OresPlusTab.tab).setUnlocalizedName("Jade").setTextureName("oresplus:jade");
				
				
			//JadeStone
				jadeStone = new BlockJadeStone(5001).setBlockName("JadeStone").setHardness(2.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:jade_ore");
				jadeStone.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				jadeStone.setHarvestLevel("pickaxe", 2);
				
			//JadePickaxe
				jadePickaxe = new ItemJadePickaxe(ToolMaterials.jadeMaterial).setCreativeTab(OresPlusTab.tab).setUnlocalizedName("JadePickaxe").setTextureName("oresplus:jade_pickaxe");
			
			//TheisIngot
				theisIngot = new TheisIngot(5002).setUnlocalizedName("TheisIngot").setCreativeTab(OresPlusTab.tab).setTextureName("oresplus:theis_ingot");
			
			
			//TheisOre
				theisOre = new TheisOre(Material.iron).setBlockName("TheisOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:theis_ore");
				theisOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				theisOre.setHarvestLevel("pickaxe", 2);
				
			//RubyOre
				rubyOre = new RubyOre(Material.iron).setBlockName("RubyOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:ruby_ore");
				rubyOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				rubyOre.setHarvestLevel("pickaxe", 2);
			
			//Citrine
				citrine = new ItemCitrine(5006).setUnlocalizedName("Citrine").setCreativeTab(OresPlusTab.tab).setTextureName("oresplus:citrine");		
				
				
			//Ruby
				ruby = new ItemRuby(5003).setUnlocalizedName("Ruby").setCreativeTab(OresPlusTab.tab).setTextureName("oresplus:ruby");
				
			//RubyPickaxe
				rubyPickaxe = new ItemRubyPickaxe(ToolMaterials.rubyMaterial).setCreativeTab(OresPlusTab.tab).setUnlocalizedName("RubyPickaxe").setTextureName("oresplus:ruby_pickaxe");
	
			//SapphireOre
				sapphireOre = new SapphireOre(Material.iron).setBlockName("SapphireOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:sapphire_ore");
				sapphireOre.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				sapphireOre.setHarvestLevel("pickaxe", 2);
				
			//Sapphire
				sapphire = new ItemSapphire(5004).setUnlocalizedName("Sapphire").setCreativeTab(OresPlusTab.tab).setTextureName("oresplus:sapphire");
				

			//AmethystOre
				amethystOre = new AmethystOre(Material.iron).setBlockName("AmethystOre").setHardness(3.0f).setCreativeTab(OresPlusTab.tab).setBlockTextureName("oresplus:amethyst_ore");
			
			//Amethyst
				amethyst = new Amethyst(5004).setUnlocalizedName("Amethyst").setCreativeTab(OresPlusTab.tab).setTextureName("oresplus:amethyst");
	
	
			//SapphirePickaxe
				sapphirePickaxe = new ItemSapphirePickaxe(ToolMaterials.sapphireMaterial).setCreativeTab(OresPlusTab.tab).setUnlocalizedName("RubyPickaxe").setTextureName("oresplus:sapphire_pickaxe");
	}
	
	@EventHandler
	public void init(FMLPreInitializationEvent event) 
	{
		
		
		//Register everything
			//Block
				GameRegistry.registerBlock(jadeStone, "JadeStone");
				GameRegistry.registerBlock(theisOre, "TheisOre");
				GameRegistry.registerBlock(rubyOre, "RubyOre");
				GameRegistry.registerBlock(sapphireOre, "SapphireOre");
				GameRegistry.registerBlock(amethystOre, "AmethystOre");
		
			//Item
				GameRegistry.registerItem(jade, "Jade");
				GameRegistry.registerItem(theisIngot, "TheisIngot");
				GameRegistry.registerItem(jadePickaxe, "JadePickaxe");
				GameRegistry.registerItem(rubyPickaxe, "RubyPickaxe");
				GameRegistry.registerItem(ruby, "Ruby");
				GameRegistry.registerItem(amethyst, "Amethyst");
				
			//Crafting Recipe
				//JadePickaxe
					GameRegistry.addRecipe(new ItemStack(jadePickaxe), "XXX", " I ", " I ", 
							'X', new ItemStack(jade),
							'I', new ItemStack(Items.stick));
				//RubyPickaxe
					GameRegistry.addRecipe(new ItemStack(rubyPickaxe), "XXX", " I ", " I ",
							'X', new ItemStack(ruby),
							'I', new ItemStack(Items.stick));
				//SapphirePickaxe
					
				
				
			//IWorldGenerator		
				GameRegistry.registerWorldGenerator(new JadeOreGenerator(), 3);
				GameRegistry.registerWorldGenerator(new TheisOreGen(), 6);
				GameRegistry.registerWorldGenerator(new RubyOreGen(), 3);
				
			//Smelting Recipe
				GameRegistry.addSmelting(theisOre, new ItemStack(theisIngot, 2), 10.0f);
	}
}