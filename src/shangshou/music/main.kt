package shangshou.music

/**
 * @author linnanwei
 * @version 1.0,0
 * @since 1.0.0
 * Date： 2019/9/24
 */

fun main(args: Array<String>) {
    val user = User(1, "lnw", PlayerViewType.GREEN)
    PlayerUI.get().showPlayer(user)
}

class MediaPlayerView(playerView: PlayerView): PlayerView by playerView