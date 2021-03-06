package reborncore.common.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Mark on 13/03/2016.
 */
public class WorldUtils
{

	public static void updateBlock(World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		world.notifyBlockUpdate(pos, state, state, 3);
	}

	public static boolean chunkExists(World world, int x, int z){
		return world.isBlockLoaded(new BlockPos(x << 4, 64, z << 4));
	}
}
