package com.KJR.ICF.world;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.KJR.ICF.config.ICF_Config;
import com.KJR.ICF.registry.ICF_Blocks;

public class ICF_WorldGen implements IWorldGenerator {
	
	//Ores
	private WorldGenerator platinumOre;
	private WorldGenerator tinOre;
	private WorldGenerator silverOre;
	private WorldGenerator aluminumOre;
	private WorldGenerator copperOre;
	private WorldGenerator nickelOre;
	private WorldGenerator sulfurOre;
	private WorldGenerator saltpeterOre;
	
	
	public ICF_WorldGen() {
		
		//Ores
		this.platinumOre = new ICF_WorldGenMinable(ICF_Blocks.icfOre.getStateFromMeta(0), 4); // last int is max vein size (here: 4)
		this.tinOre = new ICF_WorldGenMinable(ICF_Blocks.icfOre.getStateFromMeta(1), 8);
		this.silverOre = new ICF_WorldGenMinable(ICF_Blocks.icfOre.getStateFromMeta(2), 6);
		this.aluminumOre = new ICF_WorldGenMinable(ICF_Blocks.icfOre.getStateFromMeta(3), 9);
		this.copperOre = new ICF_WorldGenMinable(ICF_Blocks.icfOre.getStateFromMeta(4), 9);
		this.nickelOre = new ICF_WorldGenMinable(ICF_Blocks.icfOre.getStateFromMeta(5), 7);
		this.sulfurOre = new ICF_WorldGenMinable(ICF_Blocks.icfOre.getStateFromMeta(6), 10);
		this.saltpeterOre = new ICF_WorldGenMinable(ICF_Blocks.icfOre.getStateFromMeta(7), 5);

	}
	

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
		case 0: //Overworld
			
			//Ores
			if(ICF_Config.bGenPlatinum){
				this.runGenerator(this.platinumOre, world, random, chunkX, chunkZ, 4, 1, 30); // last 3 int's are SpawnChance, MinY, and MaxY. (here: 5, 1, 30)
			}
			if(ICF_Config.bGenTin){
				this.runGenerator(this.tinOre, world, random, chunkX, chunkZ, 27, 10, 40);
			}
			if(ICF_Config.bGenSilver){
				this.runGenerator(this.silverOre, world, random, chunkX, chunkZ, 12, 5, 35);
			}
			if(ICF_Config.bGenAluminum){
				this.runGenerator(this.aluminumOre, world, random, chunkX, chunkZ, 20, 45, 100);
			}
			if(ICF_Config.bGenCopper){
				this.runGenerator(this.copperOre, world, random, chunkX, chunkZ, 28, 35, 60);
			}
			if(ICF_Config.bGenNickel){
				this.runGenerator(this.nickelOre, world, random, chunkX, chunkZ, 18, 30, 55);
			}
			if(ICF_Config.bGenSulfur){
				this.runGenerator(this.sulfurOre, world, random, chunkX, chunkZ, 9, 1, 40);
			}
			if(ICF_Config.bGenSaltpeter){
				this.runGenerator(this.saltpeterOre, world, random, chunkX, chunkZ, 14, 50, 90);
			}
			
			break;
			
		case -1: //Nether
			
			//Nether Ores
			
			break;
			
		case 1: //The End
			
			//End Ores
			
			break;
		}
		
	}
	
	private void runGenerator (WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chanceToSpawn, int minHeight, int maxHeight) {
		
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Minimum or Maximum Height out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chanceToSpawn; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
 
	
}