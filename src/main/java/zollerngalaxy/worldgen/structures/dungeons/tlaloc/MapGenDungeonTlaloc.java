/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.dungeons.tlaloc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.google.common.collect.Lists;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenDungeonTlaloc extends MapGenStructure {
	
	private static boolean initialized;
	private DungeonConfigurationTlaloc configuration;
	
	static {
		try {
			MapGenDungeonTlaloc.initiateStructures();
		} catch (Throwable e) {
			
		}
	}
	
	public MapGenDungeonTlaloc(DungeonConfigurationTlaloc configuration) {
		this.configuration = configuration;
	}
	
	public static void initiateStructures() throws Throwable {
		if (!MapGenDungeonTlaloc.initialized) {
			MapGenStructureIO.registerStructure(MapGenDungeonTlaloc.Start.class, "TlalocDungeon");
			MapGenStructureIO.registerStructureComponent(DungeonStartTlaloc.class, "TlalocDungeonStart");
			MapGenStructureIO.registerStructureComponent(CorridorTlaloc.class, "TlalocDungeonCorridor");
			MapGenStructureIO.registerStructureComponent(RoomEmptyTlaloc.class, "TlalocDungeonEmptyRoom");
			MapGenStructureIO.registerStructureComponent(RoomBossTlaloc.class, "TlalocDungeonBossRoom");
			MapGenStructureIO.registerStructureComponent(RoomTreasureTlaloc.class, "TlalocDungeonTreasureRoom");
			MapGenStructureIO.registerStructureComponent(RoomSpawnerTlaloc.class, "TlalocDungeonSpawnerRoom");
			MapGenStructureIO.registerStructureComponent(RoomChestTlaloc.class, "TlalocDungeonChestRoom");
			MapGenStructureIO.registerStructureComponent(RoomEntranceTlaloc.class, "TlalocDungeonEntranceRoom");
		}
		
		MapGenDungeonTlaloc.initialized = true;
	}
	
	@Override
	public String getStructureName() {
		return "Tlaloc_Dungeon";
	}
	
	@Override
	protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
		long dungeonPos = getDungeonPosForCoords(this.world, chunkX, chunkZ, ((IGalacticraftWorldProvider) this.world.provider).getDungeonSpacing());
		int i = (int) (dungeonPos >> 32);
		int j = (int) dungeonPos; // Java automatically gives the 32 least significant bits
		return i == chunkX && j == chunkZ;
	}
	
	public static long getDungeonPosForCoords(World world, int chunkX, int chunkZ, int spacing) {
		final int numChunks = spacing / 16;
		if (chunkX < 0) {
			chunkX -= numChunks - 1;
		}
		
		if (chunkZ < 0) {
			chunkZ -= numChunks - 1;
		}
		
		int k = chunkX / numChunks;
		int l = chunkZ / numChunks;
		long seed = k * 341873128712L + l * 132897987541L + world.getWorldInfo().getSeed() + 10387340 + world.provider.getDimension();
		Random random = new Random();
		random.setSeed(seed);
		k = k * numChunks + random.nextInt(numChunks);
		l = l * numChunks + random.nextInt(numChunks);
		return (((long) k) << 32) + l;
	}
	
	public static float directionToNearestDungeon(World world, double xpos, double zpos) {
		int spacing = ((IGalacticraftWorldProvider) world.provider).getDungeonSpacing();
		if (spacing == 0)
			return 0F;
		int x = MathHelper.floor(xpos);
		int z = MathHelper.floor(zpos);
		int quadrantX = x % spacing;
		int quadrantZ = z % spacing;
		int searchOffsetX = quadrantX / (spacing / 2); // 0 or 1
		int searchOffsetZ = quadrantZ / (spacing / 2); // 0 or 1
		double nearestX = 0;
		double nearestZ = 0;
		double nearestDistance = Double.MAX_VALUE;
		for (int cx = searchOffsetX - 1; cx < searchOffsetX + 1; cx++) {
			for (int cz = searchOffsetZ - 1; cz < searchOffsetZ + 1; cz++) {
				long dungeonPos = getDungeonPosForCoords(world, (x + cx * spacing) / 16, (z + cz * spacing) / 16, spacing);
				int i = 2 + (((int) (dungeonPos >> 32)) << 4);
				int j = 2 + (((int) dungeonPos) << 4); // Java automatically gives the 32 least
														// significant bits
				double oX = i - xpos;
				double oZ = j - zpos;
				double distanceSq = oX * oX + oZ * oZ;
				if (distanceSq < nearestDistance) {
					nearestDistance = distanceSq;
					nearestX = oX;
					nearestZ = oZ;
				}
			}
		}
		
		return GCCoreUtil.getAngleForRelativePosition(nearestX, nearestZ);
	}
	
	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		return new MapGenDungeonTlaloc.Start(this.world, this.rand, chunkX, chunkZ, this.configuration);
	}
	
	@Override
	public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean p_180706_3_) {
		return null;
	}
	
	public static class Start extends StructureStart {
		
		private DungeonConfigurationTlaloc configuration;
		DungeonStartTlaloc startPiece;
		
		public Start() {
		}
		
		public Start(World worldIn, Random rand, int chunkX, int chunkZ, DungeonConfigurationTlaloc configuration) {
			super(chunkX, chunkZ);
			this.configuration = configuration;
			startPiece = new DungeonStartTlaloc(worldIn, configuration, rand, (chunkX << 4) + 2, (chunkZ << 4) + 2);
			startPiece.buildComponent(startPiece, this.components, rand);
			List<StructureComponent> list = startPiece.attachedComponents;
			
			while (!list.isEmpty()) {
				int i = rand.nextInt(list.size());
				StructureComponent structurecomponent = list.remove(i);
				structurecomponent.buildComponent(startPiece, this.components, rand);
			}
			
			this.updateBoundingBox();
		}
	}
	
	public static void main(String args[]) {
		Random rand = new Random();
		Start start = new Start(null, rand, 0, 0, new DungeonConfigurationTlaloc(null, 25, 8, 16, 5, 6, RoomBossTlaloc.class, RoomTreasureTlaloc.class));
		
		EventQueue.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				ex.printStackTrace();
			}
			
			JFrame frame = new JFrame("Dungeon Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new DungeonGenPanel(start.startPiece.componentBounds));
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
	
	public static class DungeonGenPanel extends JPanel {
		DungeonGenPanel(List<StructureBoundingBox> componentBounds) {
			int absMinX = Integer.MAX_VALUE;
			int absMinZ = Integer.MAX_VALUE;
			int absMaxX = Integer.MIN_VALUE;
			int absMaxZ = Integer.MIN_VALUE;
			for (StructureBoundingBox b : componentBounds) {
				if (b.minX < absMinX) {
					absMinX = b.minX;
				}
				if (b.minZ < absMinZ) {
					absMinZ = b.minZ;
				}
				if (b.maxX > absMaxX) {
					absMaxX = b.maxX;
				}
				if (b.maxZ > absMaxZ) {
					absMaxZ = b.maxZ;
				}
			}
			setLayout(new GridLayout(absMaxX - absMinX, absMaxZ - absMinZ, 0, 0));
			
			Color[] colors = new Color[] { Color.GREEN, Color.BLUE, Color.RED, Color.MAGENTA };
			List<List<JPanel>> cells = Lists.newArrayList();
			for (int row = 0; row < absMaxX - absMinX; row++) {
				List<JPanel> rowCells = Lists.newArrayList();
				for (int col = 0; col < absMaxZ - absMinZ; col++) {
					JPanel cell = new JPanel() {
						@Override
						public Dimension getPreferredSize() {
							return new Dimension(8, 8);
						}
					};
					cell.setBackground(Color.GRAY);
					add(cell);
					rowCells.add(cell);
				}
				cells.add(rowCells);
			}
			
			int color = 0;
			// X is rows, Z is cols
			for (StructureBoundingBox bb : componentBounds) {
				color = ++color % colors.length;
				
				for (int i = bb.minX; i < bb.maxX; ++i) {
					for (int j = bb.minZ; j < bb.maxZ; ++j) {
						cells.get(i - absMinX).get(j - absMinZ).setBackground(colors[color]);
					}
				}
			}
		}
	}
}