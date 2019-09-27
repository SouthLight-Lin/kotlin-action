package shangshou.music

import javax.swing.JOptionPane

class BluePlayerView: PlayerView {
    override fun getPlayButton() {
        println("显式蓝色按钮")
    }

    override fun showView() {
        JOptionPane.showConfirmDialog(null, "显式蓝色播放器", "蓝色播放器",JOptionPane.DEFAULT_OPTION)
    }

}
