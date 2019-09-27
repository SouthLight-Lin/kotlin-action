package shangshou.music

/**
 * @author linnanwei
 * @version 1.0,0
 * @since 1.0.0
 * Date： 2019/9/24
 */
sealed class PlayerViewType {
    object GREEN: PlayerViewType()
    object BLUE: PlayerViewType()
}

fun getPlayerView(type: PlayerViewType): PlayerView = when(type){
    PlayerViewType.GREEN -> GreenPlayerView()
    PlayerViewType.BLUE -> BluePlayerView()
}