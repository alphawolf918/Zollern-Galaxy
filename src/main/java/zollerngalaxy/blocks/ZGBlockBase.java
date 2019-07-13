package zollerngalaxy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.creativetabs.ZGTabs;
import zollerngalaxy.core.enums.EnumHarvestLevel;
import zollerngalaxy.lib.helpers.json.JSONRegistryHelper;

public class ZGBlockBase extends Block implements ISingleZGBlockRender, IJSONBlock {
	
	protected static ZGBlockBase instance;
	protected static Material blockMaterial = Material.ROCK;
	protected static SoundType blockSound = SoundType.STONE;
	protected boolean shouldAlwaysBurn = false;
	protected boolean isHotFloorBlock = false;
	protected boolean hasInfo = false;
	protected boolean shouldIgnore = false;
	protected String blockInfo = "";
	protected static String name;
	
	public ZGBlockBase(String blockName, float hardResist) {
		super(blockMaterial);
		instance = this;
		this.name = blockName;
		this.setBlockName(this, blockName);
		this.setHardResist(hardResist);
		this.setHarvestLevel("pickaxe", EnumHarvestLevel.DIAMOND.getHarvestLevel());
		this.setSoundType(blockSound);
		
		if (!this.shouldJSONIgnore()) {
			JSONRegistryHelper.registerBlock(blockName);
		}
	}
	
	public void setBlockName(final Block block, final String blockName) {
		block.setUnlocalizedName(blockName);
	}
	
	public Block setSound(SoundType bSound) {
		this.blockSoundType = bSound;
		return this;
	}
	
	public SoundType getSound() {
		return this.blockSound;
	}
	
	public boolean hasInfo() {
		return this.hasInfo;
	}
	
	public String getInfo() {
		return this.blockInfo;
	}
	
	public Block setInfo(String info) {
		this.blockInfo = info;
		return this;
	}
	
	public Block setHardResist(float hard, float resist) {
		this.setHardness(hard);
		this.setResistance(resist);
		return this;
	}
	
	public Block setHardResist(float hardResist) {
		this.setHardness(hardResist);
		this.setResistance(hardResist);
		return this;
	}
	
	public Block setIsHotBlock(boolean par1HotBlock) {
		this.isHotFloorBlock = par1HotBlock;
		return this;
	}
	
	public boolean getIsHotBlock() {
		return this.isHotFloorBlock;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase
				&& !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entityIn)
				&& this.getIsHotBlock()) {
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.5F);
		}
		
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	
	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		if (this.getShouldAlwaysBurn() && side == EnumFacing.UP) {
			return true;
		}
		return false;
	}
	
	public Block setShouldAlwaysBurn(boolean shouldBurn) {
		this.shouldAlwaysBurn = shouldBurn;
		return this;
	}
	
	public boolean getShouldAlwaysBurn() {
		return this.shouldAlwaysBurn;
	}
	
	public Block setBlockHarvestLevel(String toolClass, int level) {
		this.setHarvestLevel(toolClass, level);
		return this;
	}
	
	public Block setMaterial(Material material) {
		blockMaterial = material;
		return this;
	}
	
	@Override
	public Material getMaterial(IBlockState block) {
		return blockMaterial;
	}
	
	public static ZGBlockBase instance() {
		return instance;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZGTabs.zgBlocksTab;
	}
	
	@Override
	public String getName() {
		return this.name.toLowerCase();
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return false;
	}
	
	public Block setShouldJSONIgnore(boolean ignore) {
		this.shouldIgnore = ignore;
		return this;
	}
	
}