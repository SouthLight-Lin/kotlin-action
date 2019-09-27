package shangshou.music

import javax.swing.JOptionPane

class GreenPlayerView: PlayerView {
    override fun getPlayButton() {
        println("显式绿色按钮")
    }

    override fun showView() {
        JOptionPane.showConfirmDialog(null, "显式绿色播放器", "绿色播放器", JOptionPane.DEFAULT_OPTION)
    }

}