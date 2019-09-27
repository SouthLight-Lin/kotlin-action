package shangshou.music


/**
 * 音乐播放App，每个用户可以自定义自己的皮肤
 * @author linnanwei
 * @version 1.0,0
 * @since 1.0.0
 * Date： 2019/9/24
 */
class PlayerUI private constructor(){
     companion object{
         fun get(): PlayerUI{
             return Holder.instance
         }
     }

    private object Holder{
        val instance = PlayerUI()
    }

    fun showPlayer(user: User){
        MediaPlayerView(getPlayerView(user.playerType)).showView()
    }
}